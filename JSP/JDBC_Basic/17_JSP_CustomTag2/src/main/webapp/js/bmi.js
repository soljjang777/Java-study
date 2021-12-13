function call(){
	 let input1 = document.getElementById('i1');
	 let input2 = document.getElementById('i2');
	 let input3 = document.getElementById('i3');

//이름 글자만입력해주세요(2자리이상)
if(isEmpty(input1) || lessThan(input1,2)) {
	alert('글자를 2자리 이상 입력해주세요!');
	
	input1.focus();
	input1.value = "";
	
	return false;
}
//키 숫자만입력하세요(3자리이상)
if(isNotNumber(input2) || lessThan(input2,3)) {
	alert('숫자만 3자리 이상 입력해주세요');
	
	input2.focus();
	input2.value = "";
	
	return false;
}
//체중 숫자만입력해주세요(2자리이상)
if(isNotNumber(input3) || lessThan(input3,2)) {
	alert('숫자만 2자리 이상 입력해주세요');
	
	input3.focus();
	input3.value = "";
	
	return false;
}



	return true;
}