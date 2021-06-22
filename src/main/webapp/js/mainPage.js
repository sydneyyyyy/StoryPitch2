function onMainLoad() {
    let url = 'http://localhost:8080/StoryPitch-2/session';
    let xhttp = new XMLHttpRequest();
    xhttp.open("GET", url, true);
    xhttp.send();
    xhttp.onreadystatechange = function() {
        if (xhttp.readyState == 4 && xhttp.status == 200) {
            console.log("working...");
            let sessionObj = JSON.parse(this.responseText);
            console.log(sessionObj);
        }
    }
}

function onEditorLoad() {
    let url = 'http://localhost:8080/StoryPitch-2/edSession';
    let xhttp = new XMLHttpRequest();
    xhttp.open("GET", url, true);
    xhttp.send();
    xhttp.onreadystatechange = function() {
        if (xhttp.readyState == 4 && xhttp.status == 200) {
            console.log("working...");
            let sessionObj = JSON.parse(this.responseText);
            console.log(sessionObj);
        }
    }
}

function onEditorLogin() {

    // window.location.assign = 'EditorMainPage.html';
    let usernameInput = document.getElementById('username').value;
    let passwordInput = document.getElementById('userPass').value;

    console.log(usernameInput);
    console.log(passwordInput);

    let editor = {
        username: usernameInput,
        password: passwordInput
    }

    let url = 'http://localhost:8080/StoryPitch-2/editors/id';
    
    let xhttp = new XMLHttpRequest();
    xhttp.open('POST', url, true);
    // xhttp.setRequestHeader('Content-Type', 'application/json');
    
    xhttp.onreadystatechange = displayData;

    function displayData() {

        if (this.readyState == 4 && this.status == 200) {
            console.log("working");
            
        }
    };

    xhttp.send(JSON.stringify(editor));
}

function viewStories() {

    let url = 'http://localhost:8080/StoryPitch-2/authors/stories';
    let xhttp = new XMLHttpRequest();
    xhttp.open('GET', url, true);
    xhttp.send();
    xhttp.onreadystatechange = function() {
        let dataSection = document.getElementById('storyData');
        dataSection.innerHTML = '';

        if (xhttp.readyState == 4 && xhttp.status == 200) {
            let res = xhttp.responseText;
            res = JSON.parse(res);

            let storyTable = document.createElement('table');
            storyTable.id = 'storyTable';

            let thRow = document.createElement('tr')
            let tHeaders = ['Title', 'Description', 'Author', 'Status'];
            for (let h of tHeaders) {
                let th = document.createElement('th');
                th.innerHTML = h;
                thRow.appendChild(th);
            }

            storyTable.append(thRow);

            for (let story of res) {
                // Story title
                let tr = document.createElement('tr');
                let tdName = document.createElement('td');
                tdName.innerHTML = story.title;
                tr.appendChild(tdName);

                // Story Description
                let tdDes = document.createElement('td');
                tdDes.innerHTML = story.description;
                tr.appendChild(tdDes);

                // Story Author
                let tdAuthor = document.createElement('td');
                tdAuthor.innerHTML = story.authorName;
                tr.appendChild(tdAuthor);

                // Story Status
                let tdStatus = document.createElement('td');
                tdStatus.innerHTML = story.submitted;
                tr.appendChild(tdStatus);

                storyTable.appendChild(tr);
            }

            dataSection.appendChild(storyTable);
        }
    }
}

function submitStory() {
    window.location.href="SubmitStory.html";
}

function onSubmitStory() {

    let authorNameInput = document.getElementById('authorName').value;
    let titleInput = document.getElementById('title').value;
    let releaseDateInput = document.getElementById('releaseDate').value;
    let storyTypeInput = document.getElementById('storyType').value;
    let genreTypeInput = document.getElementById('genre').value;
    let tagLineInput = document.getElementById('tagLine').value;
    let descInput = document.getElementById('description').value;

    console.log(authorNameInput);
    console.log(titleInput);
    console.log(releaseDateInput);
    console.log(storyTypeInput);
    console.log(genreTypeInput);
    console.log(tagLineInput);
    console.log(descInput);

    let story = {
        authorName: authorNameInput,
        title: titleInput,
        releaseDate: releaseDateInput,
        storyType: storyTypeInput,
        genre: genreTypeInput,
        tagLine: tagLineInput,
        description: descInput
    }

    let url = 'http://localhost:8080/StoryPitch-2/newStory';

    let xhttp = new XMLHttpRequest();
    xhttp.open('POST', url, true);

    xhttp.onreadystatechange = function() {
        if (xhttp.readyState == 4 && xhttp.status == 200) {
            console.log("Creating Story...");
            // window.location.assign('mainPage.html');
        }
    };

    xhttp.send(JSON.stringify(story));
}

function displayMessage() {
    let url = 'http://localhost:8080/StoryPitch-2/newStory';
    let xhttp = new XMLHttpRequest();

    
    xhttp.open('GET', url, true);
    xhttp.onreadystatechange = function() {

        let messageSection = document.getElementById('message');
        messageSection.innerHTML = '';
        
        if (xhttp.readyState == 4 && xhttp.status == 200) {
            let res = xhttp.responseText;
            res = JSON.parse(res);

            let mesHold = document.createElement('div');
            mesHold.id = 'messageHolder';

            for (let story of r) {
                let mess = document.createElement('p');
                if (story.submitted == 'on-hold') {
                    mess.innerHTML = "You do not have enough points for this submission! Story Pitch placed on hold."
                } else {
                    mess.innerHTML = "Story created successfully."
                }
                mesHold.append(mess);
            }
            
            messageSection.appendChild(mesHold);
        }
    };
    xhttp.send();


}

function viewPendingStories() {

    let url = 'http://localhost:8080/StoryPitch-2/editors/stories';
    let xhttp = new XMLHttpRequest();
    xhttp.open('GET', url, true);
    xhttp.send();
    xhttp.onreadystatechange = function() {
        let dataSection = document.getElementById('pendingData');
        dataSection.innerHTML = '';

        if (xhttp.readyState == 4 && xhttp.status == 200) {
            let res = xhttp.responseText;
            res = JSON.parse(res);

            let storyTable = document.createElement('table');
            storyTable.id = 'storyTable';

            let thRow = document.createElement('tr')

            let tHeaders = ['Title', 'releaseDate', 'Description', 'tagLine', 'Author', 'storyType', 'genre', 'Status'];
            for (let h of tHeaders) {
                let th = document.createElement('th');
                th.innerHTML = h;
                thRow.appendChild(th);
            }

            

            storyTable.append(thRow);

            for (let story of res) {
                // Story title
                let tr = document.createElement('tr');
                let tdTitle = document.createElement('td');
                tdTitle.innerHTML = story.title;
                tr.appendChild(tdTitle);

                let tdDate = document.createElement('td');
                tdDate.innerHTML = story.releaseDate;
                tr.appendChild(tdDate);

                // Story Description
                let tdDes = document.createElement('td');
                tdDes.innerHTML = story.description;
                tr.appendChild(tdDes);

                let tdTag = document.createElement('td');
                tdTag.innerHTML = story.tagLine;
                tr.appendChild(tdTag);

                // Story Author
                let tdAuthor = document.createElement('td');
                tdAuthor.innerHTML = story.authorName;
                tr.appendChild(tdAuthor);

                let tdSt = document.createElement('td');
                tdSt.innerHTML = story.storyType;
                tr.appendChild(tdSt);

                let tdGenre = document.createElement('td');
                tdGenre.innerHTML = story.genre;
                tr.appendChild(tdGenre);

                // Story Status
                let tdStatus = document.createElement('td');
                tdStatus.innerHTML = story.submitted;
                tr.appendChild(tdStatus);
   
                let thApproveButton = document.createElement('button');
                thApproveButton.innerHTML = "Approve";
                thApproveButton.setAttribute('onclick', 'approvePending');
                thApproveButton.setAttribute('class', 'btn btn-primary');

                let thRejectButton = document.createElement('button');
                thRejectButton.innerHTML = "Reject";
                thRejectButton.setAttribute('onclick', 'rejectPending');
                thRejectButton.setAttribute('class', 'btn btn-primary');

                let thReqInfoButton = document.createElement('button');
                thReqInfoButton.innerHTML = "Request Info";
                thReqInfoButton.setAttribute('onclick', 'requestPending');
                thReqInfoButton.setAttribute('class', 'btn btn-primary');

                storyTable.appendChild(tr);
                tr.appendChild(thApproveButton);
                tr.appendChild(thRejectButton);
                tr.appendChild(thReqInfoButton);

                
            }

            dataSection.appendChild(storyTable);
        }
    }
}

