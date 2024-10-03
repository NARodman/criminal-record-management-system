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

