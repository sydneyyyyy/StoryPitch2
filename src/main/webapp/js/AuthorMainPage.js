function onAutMainLoad() {
    let url = 'http://localhost:8080/StoryPitch-2/session';
    let xhttp = new XMLHttpRequest();
    xhttp.open("GET", url, true);
    xhttp.send();
    xhttp.onreadystatechange = function() {
        let dataSection = document.getElementById('storyData');
        dataSection.innerHTML = '';
        if (xhttp.readyState == 4 && xhttp.status == 200) {
            console.log("working...");
            let res = xhttp.responseText;
            res = JSON.parse(res);
            console.log(res);
        }
    }
}

function viewStoriesPending() {

    let url = 'http://localhost:8080/StoryPitch-2/authors/stories';
    let xhttp = new XMLHttpRequest();
    xhttp.open('GET', url, true);
    xhttp.send();
    xhttp.onreadystatechange = function() {
        let dataSection = document.getElementById('storyData');
        dataSection.innerHTML = '';

        if (xhttp.readyState == 4 && xhttp.status == 200) {
            console.log("working...");
            let res = xhttp.responseText;
            res = JSON.parse(res);
            console.log(res);

            if (res.length != 0) {

                let storyTable = document.createElement('table');
                storyTable.id = 'storyTable';
    
                let tableHead = document.createElement('h3');
                tableHead.innerHTML="All of Your Stories";
    
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
                dataSection.innerHTML = "You have not submitted stories yet!";
            
            }
        }
    }
}

function getMyStories() {

    let url = 'http://localhost:8080/StoryPitch-2/authors/stories';

    let xhttp = new XMLHttpRequest();

    xhttp.open('GET', url, true);

    xhttp.onreadystatechange = receiveStories;

    xhttp.send(); 

    function receiveStories() {

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
                authorTable.id = 'storyTable';

                // we will need: <tr> table row, <td> for each piece of data, <th> for header

                // Create Table Header Row
                let thRow = document.createElement('tr');
                let tHeaders = ['Title', "Author"];
                for (let h of tHeaders) {
                    let th = document.createElement('th');
                    th.innerHTML = h;
                    thRow.appendChild(th);
                }

                authorTable.append(thRow);

                for (let story of res) {
                    
                    let tr = document.createElement('tr');

                    let tdTitle = document.createElement('td');
                    tdTitle.innerHTML = story.title;
                    tr.appendChild(tdTitle);

                    // Author Username
                    let tdAuthor = document.createElement('td');
                    tdAuthor.innerHTML = story.authorName;
                    tr.appendChild(tdAuthor);

                    authorTable.appendChild(tr);
                }

                
                
                dataSection.appendChild(storyTable);



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

            let reButton = document.createElement('button');
            reButton.setAttribute('class', 'btn btn-primary');
            reButton.setAttribute('type', 'submit');
            reButton.setAttribute('value', 'pending');
            reButton.innerHTML = 'ReSubmit';
            reButton.onclick = () => {
                resubmitStory(res);
            }
        
            storySection.appendChild(reButton);

        }
    }
}

function viewStoriesHold() {
    let url = 'http://localhost:8080/StoryPitch-2/authors/holdStories';
    let xhttp = new XMLHttpRequest();
    xhttp.open('GET', url, true);
    xhttp.send();
    xhttp.onreadystatechange = function() {
        let dataSection = document.getElementById('storyData');
        dataSection.innerHTML = '';
        if (xhttp.readyState == 4 && xhttp.status == 200) {
            console.log("working...");
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
                dataSection.innerHTML = "None of your stories are on-hold!"
            
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
            window.location.href="ViewStory.html";
        }
    };
}
function viewStoriesApproved() {
    let url = 'http://localhost:8080/StoryPitch-2/authors/approvedStories';
    let xhttp = new XMLHttpRequest();
    xhttp.open('GET', url, true);
    xhttp.send();
    xhttp.onreadystatechange = function() {
        let dataSection = document.getElementById('storyData');
        dataSection.innerHTML = '';
        if (xhttp.readyState == 4 && xhttp.status == 200) {
            console.log("working...");
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
                    // tr.onclick = () => {
                    //     updateStory(story);
                    // }
    
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
                dataSection.innerHTML = "None of your stories are approved!"
            
            }
        }
    }
}

function onViewStoryLoad() {
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

            let reButton = document.createElement('button');
            reButton.setAttribute('class', 'btn btn-primary');
            reButton.setAttribute('type', 'submit');
            reButton.setAttribute('value', 'pending');
            reButton.innerHTML = 'ReSubmit';
            reButton.onclick = () => {
                resubmitStory(res);
            }
        
            storySection.appendChild(reButton);

        }
    }
}

function resubmitStory(res) {
    let xhttp = new XMLHttpRequest();
    xhttp.open('POST', 'http://localhost:8080/StoryPitch-2/resubmit', true);
    console.log(res);
    xhttp.send(JSON.stringify(res));
    xhttp.onreadystatechange = function() {
        if (xhttp.readyState == 4 && xhttp.status == 200) {  
            console.log("resubmitting...");
        } else {
            let info = document.getElementById('storyData');
            info.innerHTML = "You do not have enough points for this re-submission!"
        }
    };

    // let xhttp2 = new XMLHttpRequest();
    // xhttp2.open("GET", 'http://localhost:8080/StoryPitch-2/resubmit', true);
    // xhttp2.send();
    // xhttp2.onreadystatechange = function() {
    //     if (xhttp.readyState == 4 && xhttp.status == 200) {
    //         console.log("working...");
    //         let res = xhttp.responseText;
    //         res = JSON.parse(res);
    //         console.log(res);
    //     }
    // }        
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