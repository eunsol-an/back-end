document.addEventListener('DOMContentLoaded', printCommentList);

// 서버로 댓글 전송하기
async function postCommentToServer(cmtData){
    try {
        const url = "/comment/post";
        const config = {
            method : 'post',
            headers : {
                'Content-Type' : 'application/json; charset=utf-8'
            },
            body : JSON.stringify(cmtData)
            };
        const resp = await fetch(url, config);
        const result = await resp.text();
        return result;
    } catch (error) {
        console.log(error);
    }
    
}

// 댓글 등록 버튼을 눌렀을 때
if (document.getElementById('cmtSbmBtn') != null) {
    document.getElementById('cmtSbmBtn').addEventListener('click', (e) => {
        const cmtInputObj = document.getElementById('cmtText');
        if (cmtInputObj.value == null || cmtInputObj.value == '') {
            alert('댓글 내용을 입력해 주세요!');
            cmtInputObj.focus();
            return false;
        }else {
            let cmtData = {
                pno : document.getElementById('pnoVal').innerText,
                writer : document.getElementById('cmtWriter').innerText,
                content : cmtInputObj.value 
            };
            postCommentToServer(cmtData).then(result => {
                if (parseInt(result)) {
                    alert('댓글이 등록되었습니다');
                    cmtInputObj.value = "";
                }
                printCommentList();
            });
        }
    });
}

// 서버로부터 댓글 리스트 받아오기
async function getCommentListFromServer(pnoVal) {
    try {
        const resp = await fetch("/comment/" + pnoVal); // RESTful
        const cmtList = await resp.json();
        return await cmtList;
    } catch (error) {
        console.log(error);
    }
}

// 댓글 리스트 화면에 출력
function spreadCommentList(cmtList) {
    let cmtZone = document.getElementById('cmtZone');
    cmtZone.innerHTML = '';
    for (const cvo of cmtList) {
        let html = `<tr>
                        <td>${cvo.writer}</td>
                        <td>${cvo.content}</td>
                        <td>${cvo.modAt}</td>`
        if (document.getElementById('cmtWriter') != null && document.getElementById('cmtWriter').innerText == cvo.writer) {
                html +=    `<td><button class="btn btn-sm cmtModBtn" data-cno="${cvo.cno}">✏</button></td>
                        <td><button class="btn btn-sm cmtDelBtn" data-cno="${cvo.cno}">🗑</button></td>
                    </tr>`};
        cmtZone.innerHTML += html;
    }
}

// 댓글 리스트 받아오기
function printCommentList() {
    let pnoVal = document.getElementById('pnoVal').innerText;
    getCommentListFromServer(pnoVal).then(result => {
        if (result.length > 0) {
            spreadCommentList(result);
        } else {
            document.getElementById('cmtZone').parentElement.innerHTML = '<p class="text-center">댓글을 남겨주세요!</p>';
        }
    })
}

// 서버로 수정할 댓글 전달하기
async function commentUpdateToServer(cmtData){
    try {
        const url = "/comment/" + cmtData.cno;
        const config = {
            method: 'PUT', // PATCH도 가능
            headers : {
                'Content-Type' : 'application/json; charset=utf-8'
            },
            body : JSON.stringify(cmtData)
        }
        const resp = await fetch(url, config);
        const result = await resp.text();
        return result;
    } catch (error) {
        console.log(error);
    }
}

// 서버로 삭제할 댓글 전달하기
async function commentDeleteToServer(cnoVal){
    try {
        const url = "/comment/" + cnoVal;
        const config = {method: 'DELETE'}
        const resp = await fetch(url, config);
        const result = await resp.text();
        return result;
    } catch (error) {
        console.log(error);
    }
}

// 댓글 수정, 삭제하기
document.addEventListener('click', (e) => {
    if (e.target.classList.contains('cmtModBtn')) {
        let cnoVal = e.target.dataset.cno;
        let tr = e.target.closest('tr');
        let contentVal = tr.querySelector('td:nth-child(2)').innerText;
        document.querySelector('.modal-body').innerHTML = `<input type="text" class="form-control cmtModifiedText" value="${contentVal}">`;
        document.querySelector('.modSbmBtn').dataset.cno = cnoVal;
        document.getElementById('modalBtn').click();
    }
    if (e.target.classList.contains('modSbmBtn')) {
        const cmtModInput = document.querySelector('.cmtModifiedText');
        const cmtTextVal = cmtModInput.value;
        if (cmtTextVal == null || cmtTextVal == '') {
            alert('수정할 댓글 내용을 입력하세요!');
            cmtModInput.focus();
            return false;
        }else {
            const cmtData = {
                cno: e.target.dataset.cno,
                content: cmtTextVal
            };
            commentUpdateToServer(cmtData).then(result =>{
                if (parseInt(result)) {
                    document.querySelector('.btn-close').click();
                }
                printCommentList();
            });
        }
    }
    if (e.target.classList.contains('cmtDelBtn')) {
        const cnoVal = e.target.dataset.cno;
        commentDeleteToServer(cnoVal).then(result => {
            if (parseInt(result)) {
                alert('댓글이 삭제되었습니다');
            }
            printCommentList();
        });
    }
});