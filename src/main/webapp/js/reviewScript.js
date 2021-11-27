/**
 * 수정 삭제 클릭
 */

function reviewModify(element){
	var tr = element.parentElement;
	
// 1. 테이블의 번호에 해당하는 값을 input 태그의 값으로 설정
	var review_id = tr.children[0];
	var review_id_input = document.createElement("input");
	 review_id_input.type ="hidden";
	 review_id_input.value = "review_id.innerText";
	 review_id_input.name = "reivew_id";
	 review_id.append(review_id_input);
	
	
// reivew_title	
	var review_title = tr.children[1];
	var review_area = document.createElement("review_title");
	review_area.value = review_title.innerText;
	review_title.innerText = "";
	review_area.name = "review_title";
	review_title_area.setAttribute("form", "modify_form");
	review_title.append(review_title);
	
	
	
// review_context	
	var review_context = tr.children[2];
	var review_context_area = document.createElement("review_context");
	review_context_area.value = review_context.innerText;
	review_context.innerText = "";
	review_context_area.name = "review_context";
	review_context_area.setAttribute("form", "modify_form");
	context.append(review_context);
	
	
// 수정 버튼은 확인 버튼으로 변경
	var btn_modify = element.children[0];
	btn_modify.innerText = "확인";
	btn_modify.onclick = function(){
		document.getElementById("modify_form").submit();
	}
	
	
// 삭제 버튼은 취소 버튼으로 변경

	var btn_delete = element.children[1];
	btn_delete.innerText = "취소";
	btn_delete.onclick = function() {};

	
}


function reviewDelete(element){
	
}