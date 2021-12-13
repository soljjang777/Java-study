function call() {
	let i1Input = document.myForm.i1;
	let i2Input = document.myForm.i2;
	let i3Input = document.myForm.i3;
	let i4Input = document.myForm.i4;
	let i5Input = document.myForm.i5;

/*i1Input 필수입력 유효성검사 */	
	if( isEmpty(i1Input) || lessThan(i1Input,3) || containKR(i1Input) ){
		alert('필수입력 에러');
		
		i1Input.focus();
		i1Input.value="";
		
		return false;
	}
/*i2Input 글자수 유효성검사 */	
		if(lessThan(i2Input,3)){
		alert('3글자 이상 입력해주세요');
		
		i2Input.focus();
		i2Input.value="";
		
		return false;
	}
/*i3Input 비밀번호 유효성검사(글자수) */	
	if(lessThan(i3Input,5)){
		alert('비밀번호 양식에 맞춰 주세요');
		
		i3Input.value = '';
		i3Input.focus();
		
		return false;
	}
/*i3Input 비밀번호 유효성검사(포함) */	
	if(notContains(i3Input,"1234567890") || notContains(i3Input,"QWERTYUIOPASDFGHJKLZXCVBNM")){
		alert('비밀번호에 대문자나 숫자가 포함되어있지 않습니다');
		
		i3Input.value = '';
		i3Input.focus();
		
		return false;
	}
/*i3Input, i4Input 비밀번호 유효성검사(동일한지) */	
	if(notEquals(i3Input,i4Input)){
		alert('비밀번호가 일치하지 않습니다');
		
		i4Input.focus();
		i4Input.value='';
		
		return false;
	}
/*i5Input 숫자 유효성검사(숫자가아니면, 공백이면)*/	
	if(isNotNumber(i5Input) || isEmpty(i5Input)) {
		alert('숫자확인');
		
		i5Input.focus();
		i5Input.value = '';
		
		return false;
	}	
/* 유효성 다 확인하면 리턴투루(다음페이지 넘어가기) */	
	return true;
}

