async function getCommentListFromServer(bno){
  try {
    const resp = await fetch("/cmt/list/" + bno);
    const cmtList = await resp.json();
    return await cmtList;
  } catch (error) {
    console.log(error);
  }
}

function spreadCommentList(cmtArr) {
  let div = document.getElementById('accordionExample');
  div.innerHTML = '';
  for (let i = 0; i < cmtArr.length; i++) {
    let html = `<div class="accordion-item">
                  <h2 class="accordion-header" id="heading${i}">
                    <button class="accordion-button" type="button"
                      data-bs-toggle="collapse" data-bs-target="#collapse${i}"
                      aria-expanded="true" aria-controls="collapse${i}">${cmtArr[i].cno}, ${cmtArr[i].bno}, ${cmtArr[i].writer}</button>
                  </h2>
                  <div id="collapse${i}" class="accordion-collapse collapse show"
                    aria-labelledby="heading${i}" data-bs-parent="#accordionExample">
                    <div class="accordion-body">
                      <button type="button" data-cno="${cmtArr[i].cno}" class="btn btn-sm btn-outline-warning cmtModBtn">%</button>
                      <button type="button" data-cno="${cmtArr[i].cno}" class="btn btn-sm btn-outline-danger cmtDelBtn">X</button>
                      <input type="text" class="form-control" id="cmtText" value="${cmtArr[i].content}">
                      ${cmtArr[i].content}, ${cmtArr[i].mod_at}
                    </div>
                  </div>
                </div>`;
    div.innerHTML += html;
  }

}

function printCommentList(bno){
  getCommentListFromServer(bno).then(result => {
    if(result.length > 0) {
      spreadCommentList(result);
    }else {
      let div = document.getElementById('accordionExample');
      div.innerHTML = '더이상의 Comment가 존재하지 않습니다.';
    }

  });
}

async function removeCommnetFromServer(cnoVal) {
  try {
    const url = "/cmt/remove/"+cnoVal;
    const config = {
      method : 'POST'
    }
    const resp = await fetch(url, config);
    const result = await resp.text();
    return result;
  } catch (error) {
    console.log(error)
  }
}

async function updateCommentToServer(cnoVal, cmtText) {
  try {
    const url = "/cmt/modify";
    const config = {
      method : 'POST',
      headers : {
        'Content-Type' : 'application/json; charset=utf-8'
      },
      body : JSON.stringify({cno:cnoVal, content:cmtText})
    }
    const resp = await fetch(url, config);
    const result = await resp.text();
    return result;
  } catch (error) {
    console.log(error);
  }
}

document.addEventListener('click', (e) => {
  if (e.target.classList.contains('cmtModBtn')) {
    let cnoVal = e.target.dataset.cno;
    let div = e.target.closest('div');
    let cmtText = div.querySelector('#cmtText').value;
    updateCommentToServer(cnoVal, cmtText).then(result => {
      if(result > 0) {
        alert('댓글 수정 성공!');
        printCommentList(bnoVal);
      }
    });
  }
  if (e.target.classList.contains('cmtDelBtn')) {
    let cnoVal = e.target.dataset.cno;
    removeCommnetFromServer(cnoVal).then(result => {
      if(result > 0) {
        alert('댓글 삭제 성공!');
        printCommentList(bnoVal);
      }
    });
  }
});

async function postCommentToServer(cmtData){
  try {
    const url = "/cmt/post";
    const config = {
      method : 'POST',
      headers : {
        'Content-Type' : 'application/json; charset=utf-8'
      },
      body : JSON.stringify(cmtData)
    };
    const resp = await fetch(url, config);
    const result = await resp.text();
    return result;
  }catch(error){
    console.log(error);
  }
}

document.getElementById('cmtAddBtn').addEventListener('click', () => {
  const cmtText = document.getElementById('cmtText').value;
  if(cmtText == null || cmtText == ''){
    alert('댓글 내용을 입력해 주세요!');
    return false;
  }else {
    let cmtData = {
      bno : bnoVal,
      writer : document.getElementById('cmtWriter').innerText,
      content : cmtText
    };
    postCommentToServer(cmtData).then(result => {
      if(result > 0) {
        alert('댓글 등록 성공!');
        document.getElementById('cmtText').value = "";
      }
      printCommentList(cmtData.bno);
    });
  }
});