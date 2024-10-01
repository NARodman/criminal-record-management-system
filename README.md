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
If you wish to manage records through a standalone Java application: 

1. Ensure Java is installed 
- If not installed, download and install JDK from the Oracle wesbite or use an open source version.
2. Compile the Java file
- Navigate to the project directory 
- Compile the java application 
```bash
javac CriminalRecordsManager.java
```
3. Run the application 
- Execute the compiled Java program 
```bash
java CriminalRecordsManager
```
4. Manage Records
- Follow the on-screen prompts to add, view, edit, or delete records via the command line interface.

Note: The Java application operates independently of the web application. Records managed via the Java application are stored in a separate file (records.txt) and do not synchronize with the web application's local storage.

## File Structure 
```bash
File Name	                        Description
index.html	                    Homepage displaying all criminal records.
addCriminal.html	            Page with a form to add new criminal records.
listCriminal.html	            Page displaying a table of all criminal records.
editCriminal.html	            Page with a form to edit existing records.
styles.css	                    Stylesheet for all pages, including animations.
script.js	                    JavaScript file handling CRUD operations.
CriminalRecordsManager.java	    Java application for managing records via CLI.
README.md	                    Project documentation 
```
## Technologies Used
- HTML5: Structure of the web pages.
- CSS3: Styling, layout, and animations.
- JavaScript: Interactivity and data management.
- Java (Optional): Standalone application for managing records via the command line.

## License
This project is licensed under MIT License

## Future Enhancements
- Search Functionality: Implement a search bar to filter records by name, crime, or date.
- Sorting: Allow sorting records by different fields such as name or crime.
- Pagination: Add pagination for better handling of large datasets.
- Enhanced Security: Implement data encryption for sensitive information.
- Backend Integration: Connect to a backend server and database for persistent and scalable data management.
- Advanced Java Integration: Explore ways to integrate the Java application with the web frontend for synchronized data management.

## Contact
For any questions or suggestions, please reach out to Nina Lanier 