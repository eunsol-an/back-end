async function getRepliesListFromToServer(pno) {
    try {
        const resp = await fetch("/rpl/list/" + pno);
        const rplList = await resp.json();
        return await rplList;
    } catch (error) {
        console.log(error);
    }
}

function spreadRepliesList(rplArr) {
    let div = document.getElementById('accordionExample');
    div.innerHTML = '';
    for (let i = 0; i < rplArr.length; i++) {
        let html = `<div class="accordion-item">
                        <h2 class="accordion-header" id="heading${i}">
                        <button class="accordion-button" type="button"
                            data-bs-toggle="collapse" data-bs-target="#collapse${i}"
                            aria-expanded="true" aria-controls="collapse${i}">${rplArr[i].rno}, ${rplArr[i].pno}, ${rplArr[i].replier}</button>
                        </h2>
                        <div id="collapse${i}" class="accordion-collapse collapse show"
                        aria-labelledby="heading${i}" data-bs-parent="#accordionExample">
                        <div class="accordion-body">
                            <button type="button" data-rno="${rplArr[i].rno}" class="btn btn-sm btn-outline-warning rplModBtn">✏</button>
                            <button type="button" data-rno="${rplArr[i].rno}" class="btn btn-sm btn-outline-danger rplDelBtn">✖</button>
                            <input type="text" class="form-control" id="rplText" value="${rplArr[i].reply}">
                            ${rplArr[i].reply}, ${rplArr[i].mod_at}
                        </div>
                        </div>
                    </div>`;
        div.innerHTML += html;
    }
}

function printRepliesList(pno) {
    getRepliesListFromToServer(pno).then(result => {
        console.log(result);
        if(result.length > 0) {
            spreadRepliesList(result);
        }else {
            let div = document.getElementById('accordionExample');
            div.innerHTML = '더이상의 Comment가 존재하지 않습니다.';
        }
    });
}

async function removeRepliesFromServer(rnoVal) {
    try {
        const url = "/rpl/remove/"+rnoVal;
        const config = {
            method: 'POST'
        }
        const resp = await fetch(url, config);
        const result = await resp.text();
        return result;
    } catch (error) {
        console.log(error)
    }
}

async function updateRepliesToServer(rnoVal, rplText) {
    try {
        const url = "/rpl/modify/";
        const config = {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json; charset=utf-8'
            },
            body: JSON.stringify({rno:rnoVal, reply:rplText})
        }
        const resp = await fetch(url, config);
        const result = await resp.text();
        return result;
    } catch (error) {
        console.log(error)
    }
}

document.addEventListener('click', (e) => {
    if (e.target.classList.contains('rplModBtn')) {
        let rnoVal = e.target.dataset.rno;
        let div = e.target.closest('div');
        let rplText = div.querySelector('#rplText').value;
        updateRepliesToServer(rnoVal, rplText).then(result => {
            if (result > 0) {
                alert('댓글 수정 성공!');
                printRepliesList(pnoVal);
            }
        });
    }
    if (e.target.classList.contains('rplDelBtn')) {
        let rnoVal = e.target.dataset.rno;
        removeRepliesFromServer(rnoVal).then(result => {
            if (result > 0) {
                alert('댓글 삭제 성공!');
                printRepliesList(pnoVal);
            }
        })
    }
});

async function postRepliesToServer(rplData) {
    try {
        const url = "/rpl/post";
        const config = {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json; charset=utf-8'
            },
            body: JSON.stringify(rplData)
        };
        const resp = await fetch(url, config);
        const result = await resp.text();
        return result;
    } catch (error) {
        console.log(error)
    }
}

document.getElementById('rplAddBtn').addEventListener('click', () => {
    const rplText = document.getElementById('rplText');
    if (rplText.value == null || rplText.value == '') {
        alert('댓글 내용을 입력해 주세요.');
        return false;
    } else {
        let rplData = {
            pno : pnoVal,
            replier : document.getElementById('replier').innerText,
            reply : rplText.value
        }
        console.log(rplData);
        postRepliesToServer(rplData).then(result => {
            if (result > 0) {
                alert('댓글 등록 성공!');
                rplText.value = "";
            } else {
                console.log('댓글 등록 실패');
            }
            printRepliesList(pnoVal);
        });
    }
});