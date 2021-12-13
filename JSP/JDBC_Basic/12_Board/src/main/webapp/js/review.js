function reviewDel(n) {
	let ok = confirm('삭제 하시겠습니까?');
	
	if(ok){
	location.href='ReviewDeleteC?num=' + n;		
	}
}

function search() {
	
	let searchInput = document.getElementById('search');
	let searchVal = searchInput.value;
	
	location.href='ReviewSearchC?search=' + searchVal;
}