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
    temp.textContent = str;
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

//Function to edit a record 
function editRecord(index, name, crime, date, sentence) {
    if(index >= 0 && index < records.length){
        records[index] = {name, crime, date, sentence};
        localStorage.setItem('records', JSON.stringify(records));
    }
}

//Event Listener for Adding Records
if (document.getElementById('add-form')) {
    document.getElementById('add-form').addEventListener('submit', function(event){
        event.preventDefault();
        const name = document.getElementById('name').value.trim();
        const crime = document.getElementById('crime').value.trim();
        const date = document.getElementById('date').value.trim();
        const sentence = document.getElementById('sentence').value.trim();

        if (name === '' || crime === ''|| date === ''|| sentence === '') {
            alert('Please fill in all fields');
            return;
        }

        addRecord(name, crime, date, sentence);
        window.location.href = 'list.html';
    });
}

//Event Listener for Editing Records
if (document.getElementById('edit-form')) {
    const urlParams = new URLSearchParams(window.location.search);
    const index = urlParams.get('index');

    if(index !== null && records[index] !== undefined) {
        document.getElementById('index').value = index;
        document.getElementById('name').value = records[index].name;
        document.getElementById('crime').value = records[index].crime;
        document.getElementById('date').value = records[index].date;
        document.getElementById('sentence').value = records[index].sentence;
    }
    else {
        alert('Invalid Record Index');
        window.location.href = 'list.html';
    }

    document.getElementById('edit-form').addEventListener('submit', function(event){
        event.preventDefault();
        const index = document.getElementById('index').value;
        const name = document.getElementById('name').value.trim();
        const crime = document.getElementById('crime').value.trim();
        const date = document.getElementById('date').value.trim();
        const sentence = document.getElementById('sentence').value.trim();

        if (name === '' || crime === '' || date === '' || sentence === '') {
            alert('Please fill in all fields.');
            return;
        }

        editRecord(index, name, crime, date, sentence);
        window.location.href = 'list.html';
    });
}

//Display Records in the table (list.html)

if (document.querySelector('#recordsTable tbody')) {
    displayRecordsTable();
}