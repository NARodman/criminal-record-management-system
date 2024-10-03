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
}

