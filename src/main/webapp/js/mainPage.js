
// function onEditorLoad() {
//     let url = 'http://localhost:8080/StoryPitch-2/edSession';
//     let xhttp = new XMLHttpRequest();
//     xhttp.open("GET", url, true);
//     xhttp.send();
//     xhttp.onreadystatechange = function() {
//         if (xhttp.readyState == 4 && xhttp.status == 200) {
//             console.log("working...");
//             let res = xhttp.responseText;
//             res = JSON.parse(res);
//             console.log(res);
//             if (res.jobTitle == "Assistant") {
//                 console.log("Assistant");
//                 window.location.href='AsstMainPage.html';
//             } else if (res.jobTitle == "General") {
//                 console.log("General");
//                 window.location.href='GenMainPage.html';
//             } else if (res.jobTitle == "Senior") {
//                 console.log('Senior');
//                 window.location.href='SenMainPage.html';
//             }
//         }
//     }
// }

function onAsstMainLoad() {
    let xhttp = new XMLHttpRequest();
    xhttp.open("GET", "http://localhost:8080/StoryPitch-2/pendingStories", true);
    xhttp.send();
    xhttp.onreadystatechange = function() {
        if (xhttp.readyState == 4 && xhttp.status == 200) {
            console.log("Pending stories...");
            let res = xhttp.responseText;
            res = JSON.parse(res);
            console.log(res);
            getHighPriorityStories();
        }
    }
}

function getHighPriorityStories() {
    let xhttp = new XMLHttpRequest();
    xhttp.open("GET", "http://localhost:8080/StoryPitch-2/asst/priorityStories", true);
    xhttp.send();
    xhttp.onreadystatechange = function() {
        let dataSection = document.getElementById('pendingData');
        dataSection.innerHTML = '';
        if (xhttp.readyState == 4 && xhttp.status == 200) {
            console.log("Priority stories...");
            let res = xhttp.responseText;
            res = JSON.parse(res);
            console.log(res);
            if (res.length != 0) {
                let viewPend = document.getElementById('viewPend');
                viewPend.setAttribute('class', 'invisible');
                let head = document.createElement('h2');
                head.innerHTML = "High Priority Stories";
                dataSection.appendChild(head);
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
                    tr.onclick = () => {
                        updateStory(story);
                    }

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
                    tdStatus.innerHTML = story.pitchStatus;
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
                }
                dataSection.appendChild(storyTable);
            } else {
                dataSection.innerHTML = "There are no priority stories that need your attention!";
            }
          
            
           
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

            let storyTable = document.createElement('table');
            storyTable.id = 'storyTable';

            let thRow = document.createElement('tr')
            
            let tHeaders = ['id', 'Author', 'Title', 'Release-Date', 'Tag-Line', 
            'Description', 'Status' , 'Story-Type', 'Genre', 'Date-Submitted', 
            'Ae-Approved', 'Ge-Approved', 'Se-Approved', 'Draft'];

            for (let h of tHeaders) {
                let th = document.createElement('th');
                th.innerHTML = h;
                thRow.appendChild(th);
            }

            storyTable.append(thRow);
            
            let tr = document.createElement('tr');

            let tdId = document.createElement('td');
            tdId.innerHTML = res.id;
            tdId.setAttribute('id', 'storyId');
            tr.appendChild(tdId);
            
            let tdAuthor = document.createElement('td');
            tdAuthor.innerHTML = res.authorName;
            tdAuthor.setAttribute('id', 'author');
            tr.appendChild(tdAuthor);

            let tdTitle = document.createElement('td');
            tdTitle.innerHTML = res.title;
            tdTitle.setAttribute('id', 'title');
            tr.appendChild(tdTitle);

            let tdDate = document.createElement('td');
            tdDate.innerHTML = res.releaseDate;
            tdDate.setAttribute('id', 'releaseDate');
            tr.appendChild(tdDate);

            let tdTag = document.createElement('td');
            tdTag.innerHTML = res.tagLine;
            tdTag.setAttribute('id', 'tagLine');
            tr.appendChild(tdTag);

            let tdDes = document.createElement('td');
            tdDes.innerHTML = res.description;
            tdDes.setAttribute('id', 'description');
            tr.appendChild(tdDes);

            let tdStatus = document.createElement('td');
            tdStatus.innerHTML = res.pitchStatus;
            tdStatus.setAttribute('id', 'status');
            tr.appendChild(tdStatus);

            let tdSt = document.createElement('td');
            tdSt.innerHTML = res.storyType;
            tdSt.setAttribute('id', 'storyType');
            tr.appendChild(tdSt);

            let tdGenre = document.createElement('td');
            tdGenre.innerHTML = res.genre;
            tdGenre.setAttribute('id', 'genre');
            tr.appendChild(tdGenre);

            let tdDateSub = document.createElement('td');
            tdDateSub.innerHTML = res.dateSubmitted;
            tdDateSub.setAttribute('id', 'dateSub');
            tr.appendChild(tdDateSub);

            let tdAeAppr = document.createElement('td');
            tdAeAppr.innerHTML = res.ae_approval;
            tdAeAppr.setAttribute('id', 'aeApp');
            tr.appendChild(tdAeAppr);

            let tdGeAppr = document.createElement('td');
            tdGeAppr.innerHTML = res.ge_approval;
            tdGeAppr.setAttribute('id', 'geApp');
            tr.appendChild(tdGeAppr);

            let tdSeAppr = document.createElement('td');
            tdSeAppr.innerHTML = res.se_approval;
            tdSeAppr.setAttribute('id', 'seApp');
            tr.appendChild(tdSeAppr);

            if (res.storyDraft == null) {
                let tdDraft = document.createElement('td');
                tdDraft.innerHTML = "N/A";
                tdDraft.setAttribute('id', 'draft');
                tr.appendChild(tdDraft);
            } else {
                let tdDraft = document.createElement('td');
                tdDraft.innerHTML = res.storyDraft;
                tdDraft.setAttribute('id', 'draft');
                tr.appendChild(tdDraft); 
            }
           

            storyTable.appendChild(tr);  
            storySection.appendChild(storyTable);

            if (res.pitchStatus == "approved") {
                let appDraftButton = document.createElement('button');
                appDraftButton.setAttribute('class', 'btn btn-primary');
                appDraftButton.setAttribute('type', 'submit');
                appDraftButton.setAttribute('value', 'AppDraft');
                appDraftButton.innerHTML = 'Approve Draft';
                appDraftButton.onclick = () => {
                    approveDraft(res);
                }

                let rejDraftButton = document.createElement('button');
                rejDraftButton.setAttribute('class', 'btn btn-primary');
                rejDraftButton.setAttribute('type', 'submit');
                rejDraftButton.setAttribute('value', 'AppDraft');
                rejDraftButton.innerHTML = 'Reject Draft';
                rejDraftButton.onclick = () => {
                    rejectStory(res);
                }
                storySection.appendChild(appDraftButton);
                storySection.appendChild(rejDraftButton);
            } else {
                let approveButton = document.createElement('button');
                approveButton.setAttribute('class', 'btn btn-primary');
                approveButton.setAttribute('type', 'submit');
                approveButton.setAttribute('value', 'approved');
                approveButton.innerHTML = 'Approve';
                approveButton.onclick = () => {
                    approveStory(res);
                }

                let rejectButton = document.createElement('button');
                rejectButton.setAttribute('class', 'btn btn-primary');
                rejectButton.setAttribute('type', 'submit');
                rejectButton.setAttribute('value', 'rejected');
                rejectButton.innerHTML = 'Reject';
                rejectButton.onclick = () => {
                    rejectStory(res);
                }
        
                storySection.appendChild(approveButton);
                storySection.appendChild(rejectButton);
            
            }
            

        }
    }
}

function approveDraft(res) {
    console.log("approving draft...");
    let xhttp = new XMLHttpRequest();
    xhttp.open("POST", 'http://localhost:8080/StoryPitch-2/approveDraft', true);
    xhttp.send(JSON.stringify(res));
    xhttp.onreadystatechange = function() {
        if (xhttp.readyState == 4 && xhttp.status == 200) {
            console.log("approving...");
        }
    }
}

function rejectDraft(res) {
    console.log("rejecting draft...");
    let xhttp = new XMLHttpRequest();
    xhttp.open('POST', 'http://localhost:8080/StoryPitch-2/rejectStory', true);
    xhttp.send(JSON.stringify(res));
    xhttp.onreadystatechange = function() {
        if (xhttp.readyState == 4 && xhttp.status == 200) {  
            console.log("rejecting..");
        }
    }
}

function approveStory(res) {
    let xhttp = new XMLHttpRequest();
    xhttp.open('POST', 'http://localhost:8080/StoryPitch-2/approveStory', true);
    xhttp.send(JSON.stringify(res));
    xhttp.onreadystatechange = function() {
        if (xhttp.readyState == 4 && xhttp.status == 200) {  
            console.log("approving..");
        }
    }
}

function rejectStory(res) {
    let xhttp = new XMLHttpRequest();
    xhttp.open('POST', 'http://localhost:8080/StoryPitch-2/rejectStory', true);
    xhttp.send(JSON.stringify(res));
    xhttp.onreadystatechange = function() {
        if (xhttp.readyState == 4 && xhttp.status == 200) {  
            console.log("rejecting..");
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
            window.location.reload();
            
        }
    };

    
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
        let message = document.getElementById('message');
        if (xhttp.readyState == 4 && xhttp.status == 200) {
            message.innerHTML = "Story Successfully Submitted!"
        } else {
            message.innerHTML = "You do not have enough points for this submission. Story placed on-hold.";
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

            if (res.length != 0) {
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
                    // tr.setAttribute('onclick', 'updateStory()');
                    tr.onclick = () => {
                        updateStory(story);
                    }

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
                    tdStatus.innerHTML = story.pitchStatus;
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
                } 
                dataSection.appendChild(storyTable);
            } else {
                dataSection.innerHTML = "There are no stories that need your attention!"
            }
           
        }
            
            
    }
}

function viewPendingDrafts() {
    console.log("pending drafts...");
    let url = 'http://localhost:8080/StoryPitch-2/pendingDraft';
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

            if (res.length != 0) {
                let storyTable = document.createElement('table');
                storyTable.id = 'storyTable';

                let thRow = document.createElement('tr')
                

                let tHeaders = ['id', 'Author', 'Title', 'Release-Date', 'Tag-Line', 
                'Description', 'Status' , 'Story-Type', 'Genre', 'Date-Submitted', 
                'Draft', 'AE_DraftApp', 'GE DraftApp', 'SE_DraftApp'];
                for (let h of tHeaders) {
                    let th = document.createElement('th');
                    th.innerHTML = h;
                    thRow.appendChild(th);
                }

                storyTable.append(thRow);
                
                for (let story of res) {
                    
                    let tr = document.createElement('tr');
                    tr.onclick = () => {
                        updateStory(story);
                    }

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
                    tdStatus.innerHTML = story.pitchStatus;
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

                    let tdDraft = document.createElement('td');
                    tdDraft.innerHTML = story.storyDraft;
                    tdDraft.setAttribute('id', 'draft');
                    tr.appendChild(tdDraft);

                    let tdAeDraft = document.createElement('td');
                    tdAeDraft.innerHTML = story.aeDraft_Approval;
                    tdAeDraft.setAttribute('id', 'aeApp');
                    tr.appendChild(tdAeDraft);

                    let tdGeDraft = document.createElement('td');
                    tdGeDraft.innerHTML = story.geDraft_Approval;
                    tdGeDraft.setAttribute('id', 'geApp');
                    tr.appendChild(tdGeDraft);

                    let tdSeDraft = document.createElement('td');
                    tdSeDraft.innerHTML = story.seDraft_Approval;
                    tdSeDraft.setAttribute('id', 'seApp');
                    tr.appendChild(tdSeDraft);

                    storyTable.appendChild(tr);  
                } 
                dataSection.appendChild(storyTable);
            } else {
                dataSection.innerHTML = "There are no Drafts that need your attention!"
                let a = document.createElement('a');
                a.setAttribute('onclick', 'getHighPriorityStories()');
                a.innerHTML = "   <-- Go Back";
                dataSection.appendChild(a);  
            
            }  
        }
    }
}

function back() {
    getHighPriorityStories();
}

function updateStory(story) {
    let xhttp = new XMLHttpRequest();
    xhttp.open('POST', 'http://localhost:8080/StoryPitch-2/currentStory', true);
    console.log(story);
    xhttp.send(JSON.stringify(story));
    xhttp.onreadystatechange = function() {
        if (xhttp.readyState == 4 && xhttp.status == 200) {  
            window.location.href="storyPage.html";
        }
    };
}

function logout() {
    let xhttp = new XMLHttpRequest();
    xhttp.open('GET', 'http://localhost:8080/StoryPitch-2/logout', true);
    xhttp.send();
    xhttp.onreadystatechange = function() {
        if (xhttp.readyState == 4 && xhttp.status == 200) {
            console.log("logout");
            window.location.href='EditorLoginPage.html';
        }
    }
}

