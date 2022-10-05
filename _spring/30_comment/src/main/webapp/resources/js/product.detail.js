document.getElementById('productRemove').addEventListener('click', (e) => {
    e.preventDefault();
    if (confirm('정말 삭제하시겠습니까?')) {
        const delForm = document.getElementById('productRmForm');
        delForm.setAttribute('action', '/product/remove');
        delForm.submit();
    }
});