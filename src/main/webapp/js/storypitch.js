function onLoad() {
    
    let url = "http://localhost:8080/StoryPitch-2/homePage.html";
    let xhttp = new XMLHttpRequest();

    xhttp.onreadystatechange = loggedUser;
    
    xhttp.open("GET", url, true);

    xhttp.send();

    function loggedUser() {
        if (xhttp.readyState == 4) {
            if (xhttp.status == 200) {

                let session = JSON.parse(this.responseText);
                console.log(session);

                
            }
        }
    }
}


function getData() {

    let url = 'http://localhost:8080/StoryPitch-2/authors';

    let xhttp = new XMLHttpRequest();

    xhttp.onreadystatechange = receiveData;

    xhttp.open('GET', url, true);

    xhttp.send(); 

    function receiveData() {

        let dataSection = document.getElementById('data');
        dataSection.innerHTML = '';

        if (xhttp.readyState == 4) {
            if (xhttp.status == 200) {

                let res = xhttp.responseText;
                console.log(res);

                res = JSON.parse(res);
                console.log(res);

                // create a table
                let authorTable = document.createElement('table');
                authorTable.id = 'authorTable';

                // we will need: <tr> table row, <td> for each piece of data, <th> for header

                // Create Table Header Row
                let thRow = document.createElement('tr');
                let tHeaders = ['Name', "Username"];
                for (let h of tHeaders) {
                    let th = document.createElement('th');
                    th.innerHTML = h;
                    thRow.appendChild(th);
                }

                authorTable.append(thRow);

                // Iterate through the authors and create a tr with the td we want to show
                for (let author of res) {
                    // Row for each Author
                    let tr = document.createElement('tr');

                    // Author Name
                    let tdName = document.createElement('td');
                    tdName.innerHTML = author.name;
                    tr.appendChild(tdName);

                    // Author Username
                    let tdUsername = document.createElement('td');
                    tdUsername.innerHTML = author.username;
                    tr.appendChild(tdUsername);

                    authorTable.appendChild(tr);
                }

                
                
                dataSection.appendChild(authorTable);



            }
        }
    }
}

