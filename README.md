# Criminal Records Management System (CRMS)

## Overview

The Criminal Records Management System (CRMS) is a web-based application designed to efficiently manage criminal records through an intuitive and user-friendly interface. This system allows users to add, view, edit, and delete criminal records seamlessly. The frontend of the system is built using **HTML**, **CSS**, and **JavaScript**, ensuring a responsive and interactive experience directly from the browser. Additionally, there's an optional **Java** component for managing records via a standalone application without the need for a backend server.

## Features
- Add New Record: Easily add new criminal records with details such as name, crime, date of crime, and sentence.
- View Records: Display all criminal records in a neatly formatted table.
- Edit Records: Modify existing criminal records with ease.
- Delete Records: Remove unwanted or incorrect criminal records from the system.

## Project Structure 

```perl
criminal-record-management-system/
│
├── index.html              # Homepage displaying records
├── addCriminal.html        # Page for adding new criminal records
├── listCriminal.html       # Page displaying a table of all criminal records
├── editCriminal.html       # Page for viewing and editing existing criminal records
├── styles.css              # Stylesheet for all pages
├── script.js               # JavaScript file for handling logic
├── CriminalRecordsManager.java  # Java application file (optional)
└── README.md               # Documentation for the project
```
## Installation
1. Clone the repository 
2. Navigate to the project folder

## Usage
1. Open the application: 
- Open your web browser (e.g. Chrome, Firefox)
- Navigate to the index.html file by dragging it into the browser or using File > Open File to locate and open it 
2. Add a New Record 
- CLick on the "Add Record" button in the navigation bar on the homepage. 
- Fill in the "Name" and "Crime" fields
3. View Records
- All added records will be displayed on the main page(index.html) or list.html
- If no records are present, a message indicating that no records are found will be shown.
4. Edit a Record 
- CLick the "Edit" button next to the record you wish to modify 
- Update the "Name" and or/Crime fields. 
- Click "Update Record" to save changes
5. Delete a Record
- Click the "Delete" button next to the record you choose to remove
- Confirm the deletion in the prompt 

## Java Application 
