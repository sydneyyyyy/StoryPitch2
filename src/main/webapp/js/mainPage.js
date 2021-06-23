function onMainLoad() {
    let url = 'http://localhost:8080/StoryPitch-2/session';
    let xhttp = new XMLHttpRequest();
    xhttp.open("GET", url, true);
    xhttp.send();
    xhttp.onreadystatechange = function() {
        if (xhttp.readyState == 4 && xhttp.status == 200) {
            console.log("working...");
            let res = xhttp.responseText;
            console.log(res);
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
            let res = xhttp.responseText;
            console.log(res);
        }
    }
}

function onStoryLoad() {
    let url = 'http://localhost:8080/StoryPitch-2/storySession';
    let xhttp = new XMLHttpRequest();
    xhttp.open('GET', url, true);
    xhttp.send();
    xhttp.onreadystatechange = function() {
        if (xhttp.readyState == 4 && xhttp.status == 200) {
            console.log("working...");
            let res = xhttp.responseText;
            res = JSON.parse(res);
            console.log(res);
            
            let storySection = document.getElementById('storyInfo');
            storySection.innerHTML = '';

            let head = document.createElement('h4');
            head.innerHTML = res.title;

            storySection.appendChild(head);

            let approveButton = document.createElement('button');
            approveButton.setAttribute('class', 'btn btn-primary');
            approveButton.setAttribute('onclick', 'updateStory()');
            approveButton.setAttribute('type', 'submit');
            // approveButton.setAttribute('value', 'approved');
            approveButton.innerHTML = 'Approve';
        
            head.appendChild(approveButton);

        }
    }
}

function onEditorLogin() {

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
    xhttp.send(JSON.stringify(editor));
  
    xhttp.onreadystatechange = function() {
        if (xhttp.readyState == 4 && xhttp.status == 200) {
            console.log(xhttp.responseText);
            
        }
    };

    
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

function viewAsstPendingStories() {

    let url = 'http://localhost:8080/StoryPitch-2/asst/stories';
    let xhttp = new XMLHttpRequest();
    xhttp.open('GET', url, true);
    xhttp.send();
    xhttp.onreadystatechange = function() {
        let dataSection = document.getElementById('pendingData');
        dataSection.innerHTML = '';

        if (xhttp.readyState == 4 && xhttp.status == 200) {
            let res = xhttp.responseText;
            res = JSON.parse(res);
            console.log(res);

            let storyTable = document.createElement('table');
            storyTable.id = 'storyTable';

            let thRow = document.createElement('tr')
            

            let tHeaders = ['id', 'Author', 'Title', 'Release-Date', 'Tag-Line', 
            'Description', 'Status' , 'Story-Type', 'Genre', 'Date-Submitted', 
            'Ae-Approved', 'Ge-Approved', 'Se-Approved'];
            for (let h of tHeaders) {
                let th = document.createElement('th');
                th.innerHTML = h;
                thRow.appendChild(th);
            }

            storyTable.append(thRow);
            

            for (let story of res) {
                
                let tr = document.createElement('tr');
                tr.setAttribute('onclick', 'updateStory()');

                let tdId = document.createElement('td');
                tdId.innerHTML = story.id;
                tdId.setAttribute('id', 'storyId');
                tr.appendChild(tdId);
                
                let tdAuthor = document.createElement('td');
                tdAuthor.innerHTML = story.authorName;
                tdAuthor.setAttribute('id', 'author');
                tr.appendChild(tdAuthor);

                let tdTitle = document.createElement('td');
                tdTitle.innerHTML = story.title;
                tdTitle.setAttribute('id', 'title');
                tr.appendChild(tdTitle);

                let tdDate = document.createElement('td');
                tdDate.innerHTML = story.releaseDate;
                tdDate.setAttribute('id', 'releaseDate');
                tr.appendChild(tdDate);

                let tdTag = document.createElement('td');
                tdTag.innerHTML = story.tagLine;
                tdTag.setAttribute('id', 'tagLine');
                tr.appendChild(tdTag);

                let tdDes = document.createElement('td');
                tdDes.innerHTML = story.description;
                tdDes.setAttribute('id', 'description');
                tr.appendChild(tdDes);

                let tdStatus = document.createElement('td');
                tdStatus.innerHTML = story.submitted;
                tdStatus.setAttribute('id', 'status');
                tr.appendChild(tdStatus);
   
                let tdSt = document.createElement('td');
                tdSt.innerHTML = story.storyType;
                tdSt.setAttribute('id', 'storyType');
                tr.appendChild(tdSt);

                let tdGenre = document.createElement('td');
                tdGenre.innerHTML = story.genre;
                tdGenre.setAttribute('id', 'genre');
                tr.appendChild(tdGenre);

                let tdDateSub = document.createElement('td');
                tdDateSub.innerHTML = story.dateSubmitted;
                tdDateSub.setAttribute('id', 'dateSub');
                tr.appendChild(tdDateSub);

                let tdAeAppr = document.createElement('td');
                tdAeAppr.innerHTML = story.ae_approval;
                tdAeAppr.setAttribute('id', 'aeApp');
                tr.appendChild(tdAeAppr);

                let tdGeAppr = document.createElement('td');
                tdGeAppr.innerHTML = story.ge_approval;
                tdGeAppr.setAttribute('id', 'geApp');
                tr.appendChild(tdGeAppr);

                let tdSeAppr = document.createElement('td');
                tdSeAppr.innerHTML = story.se_approval;
                tdSeAppr.setAttribute('id', 'seApp');
                tr.appendChild(tdSeAppr);


                
                storyTable.appendChild(tr);  

                // let approveButton = document.createElement('button');
                // approveButton.setAttribute('class', 'btn btn-primary');
                // approveButton.setAttribute('onclick', 'updateStory()');
                // approveButton.setAttribute('id', 'approve');
                // approveButton.setAttribute('value', 'approved');
                // approveButton.setAttribute('type', 'submit');
                // approveButton.innerHTML = 'Approve';

                // tr.appendChild(approveButton);
            }

            dataSection.appendChild(storyTable);
        }
    }
}

function updateStory() {
    // let newUpdate = document.getElementById('approve').value;
    // let xhttp2 = new XMLHttpRequest();
    // xhttp2.open('GET', 'http://localhost:8080/StoryPitch-2/storySession', true);
    // xhttp2.send();
    // xhttp2.onreadystatechange = function() {
    //     if (xhttp2.readyState == 4 && xhttp2.status == 200) {
    //         let res = xhttp2.responseText;
    //         console.log(res);

    //         let currStory = JSON.parse(res);
    //         console.log(currStory);

    //         let updated = {
    //             storyId: currStory.id,
    //             ae_approval: newUpdate
    //         }

    //         let xhttp = new XMLHttpRequest();
    //         xhttp.open('POST', 'http://localhost:8080/StoryPitch-2/story/id', true);

    //         xhttp.send(JSON.stringify(updated));
    //         xhttp.onreadystatechange = function() {
    //             if (xhttp.readyState == 4 && xhttp.status == 200) {
    //                 console.log(xhttp.responseText);
    //             }
    //         }
    //     }
    // }

    let xhttp = new XMLHttpRequest();
    xhttp.open('POST', 'http://localhost:8080/StoryPitch-2/currentStory', true);

    let storyId = document.getElementById('storyId').innerText;
    let author = document.getElementById('author').innerText;
    let title = document.getElementById('title').innerText;
    let relDate = document.getElementById('releaseDate').innerText;
    let tag = document.getElementById('tagLine').innerText;
    let des = document.getElementById('description').innerText;
    let status = document.getElementById('status').innerText;
    let storyT = document.getElementById('storyType').innerText;
    let gen = document.getElementById('genre').innerText;
    let dateSub = document.getElementById('dateSub').innerText;
    let aeApp = document.getElementById('aeApp').innerText;
    let geApp = document.getElementById('geApp').innerText;
    let seApp = document.getElementById('seApp').innerText;

    let story = {
        id: storyId,
        authorName: author,
        title: title,
        releaseDate: relDate,
        tagLine: tag,
        description: des,
        submitted: status,
        storyType: storyT,
        genre: gen,
        dateSubmitted: dateSub,
        ae_approval: aeApp,
        ge_approval: geApp,
        se_approval: seApp
    }

    console.log(story);

    xhttp.send(JSON.stringify(story));
  
    xhttp.onreadystatechange = function() {
        if (xhttp.readyState == 4 && xhttp.status == 200) {
            
        }
    };
}

function viewAsstPendingHighStories() {
    let url = 'http://localhost:8080/StoryPitch-2/asst/highStories';
    let xhttp = new XMLHttpRequest();
    xhttp.open('GET', url, true);
    xhttp.send();
    xhttp.onreadystatechange = function() {
        let dataSection = document.getElementById('pendingData');
        dataSection.innerHTML = '';
        

        if (xhttp.readyState == 4 && xhttp.status == 200) {
            let res = xhttp.responseText;
            res = JSON.parse(res);

            if (res.length == 0) {
                dataSection.innerHTML = "There are no High Priority Stories that need your attention!";
            } else {
                // dataSection.setAttribute('style', 'border: red 2px solid');
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
}

