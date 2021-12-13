function deleteMovie(n) {
	let ok = confirm('정말 삭제 하시겠습니까?');
	/*//alert(ok);*/
	if (ok) {
		location.href = 'MovieDelController?no=' + n
	}
}

function updateMovie(t, a, s, n) {
   
   let t1 = prompt("수정 할 제목", t);

   if (t1 != null && t1 != '') {
      let a1 = prompt("수정 할 배우", a);
      let s1 = prompt("수정 할 줄거리", s);

	  location.href='MovieUpdateC?title=' + t1 + '&actor=' + a1 + '&story=' + s1 + '&no=' + n;
   }
   
}