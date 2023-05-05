document.addEventListener("DOMContentLoaded", function() {

    const form = document.getElementById("myForm");

    form.addEventListener('submit', function (event) {
        event.preventDefault(); // Prevent the default form submission
        // Get the form data
        const formData = new FormData(form);
        const FamilyName = formData.get('FamilyName'); //NB: this works with the name of the input field not the ID
        const CompanyName = formData.get('CompanyName');
        if(FamilyName==null || FamilyName===""){
            alert('Family name is a required field, please insert it.')
        }
        else {
            const page= document.createElement("html");
            page.appendChild(document.createTextNode("This is your Data"));
            const table = document.createElement('table');
            table.style.borderCollapse = 'collapse';
            table.style.border = '1px solid black';

            // create the first row and cells
            const row1 = document.createElement('tr');
            const cell1 = document.createElement('td');
            cell1.textContent = 'Family Name';
            cell1.style.border = '1px solid black'
            const cell2 = document.createElement('td');
            cell2.textContent = FamilyName;
            cell2.style.border = '1px solid black'
            row1.appendChild(cell1);
            row1.appendChild(cell2);

            // create the second row and cells
            const row2 = document.createElement('tr');
            const cell3 = document.createElement('td');
            cell3.textContent = 'Company Name';
            cell3.style.border = '1px solid black'
            const cell4 = document.createElement('td');
            cell4.textContent = CompanyName;
            cell4.style.border = '1px solid black'
            row2.appendChild(cell3);
            row2.appendChild(cell4);

            // add the rows to the table element
            table.appendChild(row1);
            table.appendChild(row2);
            page.appendChild(table);
            const buttonBack = document.createElement('button');
            buttonBack.innerText="Back";
            buttonBack.onclick = () =>window.history.back();
            page.appendChild(buttonBack);

            // add the table element to the document body
            document.body.appendChild(table);
        }
    }); // close the addEventListener function call
});