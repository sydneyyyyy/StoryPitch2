
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
    xhttp.setRequestHeader('Content-Type', 'application/json');
  
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            console.log("working");
            let res = xhttp.responseText;
            console.log(res);
            window.location.href="http://localhost:8080/StoryPitch-2/index.html";

        }
    };

    xhttp.send(JSON.stringify(author));

}

function editorLogin() {
    let usernameInput = document.getElementById('username').value;
    let passwordInput = document.getElementById('userPass').value;

    console.log(usernameInput);
    console.log(passwordInput);

    let editor = {
        username: usernameInput,
        password: passwordInput
    }

    let url = 'http://localhost:8080/StoryPitch-2/editor/id';
    
    let xhttp = new XMLHttpRequest();
    xhttp.open('POST', url, true);
    xhttp.setRequestHeader('Content-Type', 'application/json');
  
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            console.log("working");
            let res = xhttp.responseText;
            console.log(res);
            window.location.href="http://localhost:8080/StoryPitch-2/index.html";

        }
    };

    xhttp.send(JSON.stringify(editor));

}

function logout() {
    
}