function onGenMainLoad() {
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
    xhttp.open("GET", "http://localhost:8080/StoryPitch-2/gen/priorityStories", true);
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


function viewGenPendingStories() {
    let url = 'http://localhost:8080/StoryPitch-2/gen/stories';
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

            if (res.length != null) {

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
            window.location.href="EditorLoginPage.html";
        }
    }
}
