
window.onload = function () {          
	document.getElementById("id_pass2").addEventListener("blur", passwordCheck); 
}

function passwordCheck() {
	var password = document.getElementById("id_pass1");
	if(this.value === password.value) { 
					//password입력값과 동일한지 확인
	   this.nextElementSibling.firstChild.innerText ="올바른 입력값입니다.";
	}else {
		this.nextElementSibling.firstChild.innerText ="패스워드를 다시 확인하세요.";
	}
} 

