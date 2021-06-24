function authorLogin() {
    window.location.href="AuthorLoginPage.html";
}

function editorLogin() {
    window.location.href="EditorLoginPage.html";
}

function authorSignup() {
    window.location.href="AuthorSignupPage.html";
}

function onAuthorSignup() {

    let nameInput = document.getElementById('name').value;
    let usernameInput = document.getElementById('username').value;
    let passwordInput = document.getElementById('password').value;

    console.log(nameInput);
    console.log(usernameInput);
    console.log(passwordInput);

    let author = {
        name: nameInput,
        username: usernameInput,
        password: passwordInput
    }

    let url = 'http://localhost:8080/StoryPitch-2/authorSignup';

    let xhttp = new XMLHttpRequest();
    xhttp.open("POST", url, true);
    xhttp.onreadystatechange = function() {
        if (xhttp.readyState == 4 && xhttp.status == 200) {
            console.log("Created Author");
            window.location.assign('mainPage.html');
        }
    };

    xhttp.send(JSON.stringify(author));
}

function AutLoginLoad() {
    // window.location.href="AuthorMainPage.html";
}

function routePage() {
    window.location.href="AuthorMainPage.html";
}


function onAuthorLogin() {
    let usernameInput = document.getElementById('username').value;
    let passwordInput = document.getElementById('userPass').value;
    console.log(usernameInput);
    console.log(passwordInput);
    let author = {
        username: usernameInput,
        password: passwordInput
    }
    let url = 'http://localhost:8080/StoryPitch-2/authors/id';
    let xhttp = new XMLHttpRequest();
    xhttp.open('POST', url, true);
    xhttp.onreadystatechange = function () {
        if (xhttp.readyState == 4 && xhttp.status == 200) {
            console.log("test");  
            routePage();
        }
    };
    xhttp.send(JSON.stringify(author));
}

function logout() {
    let xhttp = new XMLHttpRequest();
    xhttp.open('GET', 'http://localhost:8080/StoryPitch-2/logout', true);
    xhttp.send();
    xhttp.onreadystatechange = function() {
        if (xhttp.readyState == 4 && xhttp.status == 200) {
            console.log("logout");
            window.location.href="AuthorLoginPage.html";
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
                res = JSON.parse(res);
                console.log(res);
                // create a table
                let authorTable = document.createElement('table');
                authorTable.id = 'authorTable';

                // Create Table Header Row
                let thRow = document.createElement('tr');
                let tHeaders = ['Name', "Username"];
                for (let h of tHeaders) {
                    let th = document.createElement('th');
                    th.innerHTML = h;
                    thRow.appendChild(th);
                }

                authorTable.append(thRow);

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

// function getEditorData() {

//     let url = 'http://localhost:8080/StoryPitch-2/editors';

//     let xhttp = new XMLHttpRequest();

//     xhttp.onreadystatechange = receiveData;

//     xhttp.open('GET', url, true);

//     xhttp.send(); 

//     function receiveData() {

//         let dataSection = document.getElementById('data');
//         dataSection.innerHTML = '';

//         if (xhttp.readyState == 4) {
//             if (xhttp.status == 200) {

//                 let res = xhttp.responseText;
//                 console.log(res);

//                 res = JSON.parse(res);
//                 console.log(res);

//                 // create a table
//                 let editorTable = document.createElement('table');
//                 editorTable.id = 'editorTable';

//                 // we will need: <tr> table row, <td> for each piece of data, <th> for header

//                 // Create Table Header Row
//                 let thRow = document.createElement('tr');
//                 let tHeaders = ['Name', "Username", "Title", "Genre"];
//                 for (let h of tHeaders) {
//                     let th = document.createElement('th');
//                     th.innerHTML = h;
//                     thRow.appendChild(th);
//                 }

//                 editorTable.append(thRow);

//                 // Iterate through the authors and create a tr with the td we want to show
//                 for (let editor of res) {
//                     // Row for each Author
//                     let tr = document.createElement('tr');

//                     // Author Name
//                     let tdName = document.createElement('td');
//                     tdName.innerHTML = editor.editorName;
//                     tr.appendChild(tdName);

//                     // Author Username
//                     let tdUsername = document.createElement('td');
//                     tdUsername.innerHTML = editor.username;
//                     tr.appendChild(tdUsername);

//                     let tdTitle = document.createElement('td');
//                     tdTitle.innerHTML = editor.jobTitle;
//                     tr.appendChild(tdTitle);

//                     let tdGenre = document.createElement('td');
//                     tdGenre.innerHTML = editor.genreId;
//                     tr.appendChild(tdGenre);

//                     editorTable.appendChild(tr);
//                 }

                
                
//                 dataSection.appendChild(editorTable);



//             }
//         }
//     }
// }


