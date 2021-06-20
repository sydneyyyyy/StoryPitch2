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

    // JSON.parse(story);

    xhttp.onreadystatechange = function() {
        if (xhttp.readyState == 4 && xhttp.status == 200) {
            console.log("Creating Story...");
            window.location.assign('mainPage.html');
        }
    };

    xhttp.send(JSON.stringify(story));
}