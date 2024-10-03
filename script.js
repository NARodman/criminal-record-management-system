//Initialize records from local storage or empty array 
let records = JSON.parse(localStorage.getItem('records')) || [];

//Display records in the table (list.html)
function displayRecordsTable() {
    const tableBody = document.querySelector('#recordsTable tbody');
    tableBody.innerHTML = '';

    if (records.length === 0) {
        tableBody.innerHTML = '<tr><td colspan="5"> No Criminal Records Found.</td></tr>';
        return;
    }

    records.forEach((record, index) => {
        const row = document.createElement('tr');
        row.innerHTML = `
            <td>${sanitizeHTML(record.name)}</td>
            <td>${sanitizeHTML(record.crime)}</td>
            <td>${sanitizeHTML(record.date)}</td>
            <td>${sanitizeHTML(record.sentence)}</td>
            <td class="actions">
                <button onclick="navigateToEdit(${index})" class="button">Edit</button>
                <button onclick="deleteRecord(${index})" class="button delete">Delete</button>
            </td>
        `;
        tableBody.appendChild(row);
    });
}

//Function to Sanitize HTML to prevent XSS Attacks
function sanitizeHTML(str) {
    const temp = document.createElement('div');
    temp.textContext = str;
    return temp.innerHTML;
}

//Function to navigate to the edit page 
function navigateToEdit(index) {
    window.location.href = `edit.html?index=${index}`;
}

//Function to navigate back to homepage from add.html

function cancelAdd() {
    window.location.href = 'index.html';
}

//Function to navigate back to records list from edit.html
function cancelEdit() {
    window.location.href = 'list.html';
}

//function to add new record

function addRecord(name, crime, date, sentence) {
    records.push({name, crime, date, sentence});
    localStorage.setItem('records', JSON.stringify(records));
}

//function to delete a record 
function deleteRecord(index) {
    if(confirm('Are you sure you want to delete this record')){
        records.splice(index, 1);
        localStorage.setItem('records', JSON.stringify(records));
        if (window.location.pathname.endsWith('list.html')) {
            displayRecordsTable();
        }
    }
}