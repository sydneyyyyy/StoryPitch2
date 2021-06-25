function onSenMainLoad() {
    let url = 'http://localhost:8080/StoryPitch-2/edSession';
    let xhttp = new XMLHttpRequest();
    xhttp.open("GET", url, true);
    xhttp.send();
    xhttp.onreadystatechange = function() {
        if (xhttp.readyState == 4 && xhttp.status == 200) {
            console.log("working...");
            let res = xhttp.responseText;
            res = JSON.parse(res);
            console.log(res);
            getHighPriorityStories();
        }
    }
}

function getHighPriorityStories() {
    let xhttp = new XMLHttpRequest();
    xhttp.open("GET", "http://localhost:8080/StoryPitch-2/sen/priorityStories", true);
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
                // let viewPend = document.getElementById('viewPend');
                // viewPend.setAttribute('class', 'invisible');
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
                }
                dataSection.appendChild(storyTable);
            } else {
                dataSection.innerHTML = "There are no priority stories that need your attention!";
            }
        }
    }
}

function viewSenPendingStories() {
    let url = 'http://localhost:8080/StoryPitch-2/sen/stories';
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
    
                let tableHead = document.createElement('h3');
                tableHead.innerHTML="All Pending Stories";
    
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
    
                }
                dataSection.appendChild(tableHead);
                dataSection.appendChild(storyTable);
            } else {
                dataSection.innerHTML = "There are no pitches that need your attention!"
            
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
            'Ae-Approved', 'Ge-Approved', 'Se-Approved'];

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
            tdStatus.innerHTML = res.submitted;
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

            storyTable.appendChild(tr);  
            storySection.appendChild(storyTable);

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

            let changeButton = document.createElement('button');
            changeButton.setAttribute('class', 'btn btn-primary');
            changeButton.setAttribute('type', 'submit');
            changeButton.setAttribute('value', 'change');
            changeButton.innerHTML = 'Change Pitch';
            changeButton.onclick = () => {
                changeStoryForm(res);
            }
        
            storySection.appendChild(approveButton);
            storySection.appendChild(rejectButton);
            storySection.appendChild(changeButton);

        }
    }
}

function updateStory(story) {
    let xhttp = new XMLHttpRequest();
    xhttp.open('POST', 'http://localhost:8080/StoryPitch-2/currentStory', true);
    console.log(story);
    xhttp.send(JSON.stringify(story));
    xhttp.onreadystatechange = function() {
        if (xhttp.readyState == 4 && xhttp.status == 200) {  
            window.location.href="SenStoryPage.html";
        }
    };
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

function changeStoryForm(res) {

    
    let changeSection = document.getElementById('changeForm');
        
    console.log("changing story..");
    let changeForm = document.createElement('form');
    changeSection.appendChild(changeForm);

    let formDiv = document.createElement('div');
    formDiv.setAttribute('class', 'input-group mb-3');
    changeForm.appendChild(formDiv);

    let span1 = document.createElement('span');
    span1.setAttribute('class', 'input-group-text');
    span1.setAttribute('id', 'inputGroup-sizing-default');
    span1.innerHTML = "Change Title:";
    
    let input1 = document.createElement('input');
    input1.setAttribute('id', 'newTitle');
    input1.setAttribute('type', 'text');
    input1.setAttribute('class', 'form-control');
    input1.setAttribute('aria-label', 'Sizing example input');
    input1.setAttribute('aria-describedby', 'inputGroup-sizing-default');

    formDiv.appendChild(span1);
    formDiv.appendChild(input1);

    let formDiv2 = document.createElement('div');
    formDiv2.setAttribute('class', 'input-group mb-3');
    changeForm.appendChild(formDiv2);

    let span2 = document.createElement('span');
    span2.setAttribute('class', 'input-group-text');
    span2.setAttribute('id', 'inputGroup-sizing-default');
    span2.innerHTML = "Change Tagline:";
    
    let input2 = document.createElement('input');
    input2.setAttribute('id', 'newTag');
    input2.setAttribute('type', 'text');
    input2.setAttribute('class', 'form-control');
    input2.setAttribute('aria-label', 'Sizing example input');
    input2.setAttribute('aria-describedby', 'inputGroup-sizing-default');

    formDiv2.appendChild(span2);
    formDiv2.appendChild(input2);

    let formDiv3 = document.createElement('div');
    formDiv3.setAttribute('class', 'input-group mb-3');
    changeForm.appendChild(formDiv3);

    let span3 = document.createElement('span');
    span3.setAttribute('class', 'input-group-text');
    span3.setAttribute('id', 'inputGroup-sizing-default');
    span3.innerHTML = "Change Release Date:";
    
    let input3 = document.createElement('input');
    input3.setAttribute('id', 'newRelDate');
    input3.setAttribute('type', 'date');
    input3.setAttribute('value', 'yyyy-mm-dd');
    input3.setAttribute('class', 'form-control');
    input3.setAttribute('aria-label', 'Sizing example input');
    input3.setAttribute('aria-describedby', 'inputGroup-sizing-default');

    formDiv3.appendChild(span3);
    formDiv3.appendChild(input3);

    let subButton = document.createElement('button');
    subButton.setAttribute('class', 'btn btn-primary');
    subButton.setAttribute('type', 'submit');
    subButton.innerHTML = "Submit";
    subButton.onclick = () => {
        submitChange(res);
    }
    changeForm.appendChild(subButton);
}

function submitChange(res) {

    let titleInput = document.getElementById('newTitle').value;
    let tagInput = document.getElementById('newTag').value;
    let dateInput = document.getElementById('newRelDate').value;

    console.log(titleInput);
    console.log(tagInput);
    console.log(dateInput);

    let newChange = {
        title: titleInput,
        releaseDate: dateInput,
        tagLine: tagInput
    }

    console.log(newChange);

    let xhttp = new XMLHttpRequest();
    xhttp.open('POST', 'http://localhost:8080/StoryPitch-2/submitChange');
    xhttp.send(JSON.stringify(newChange));
    xhttp.onreadystatechange = function() {
        if (xhttp.readyState == 4 && xhttp.status == 200) {
            console.log("submitting...");
        }
    }
}



function logout() {
    let xhttp = new XMLHttpRequest();
    xhttp.open('GET', 'http://localhost:8080/StoryPitch-2/logout', true);
    xhttp.send();
    xhttp.onreadystatechange = function() {
        if (xhttp.readyState == 4 && xhttp.status == 200) {
            console.log("logout");
            window.location.href="landingPage.html";
        }
    }
}