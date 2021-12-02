<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>로그인 화면</title>
    <%@ include file ="/module/head.jsp" %>
</head>
<body>
	<div class="modal-open" style="padding-right:16px;">
  	<%@ include file="/module/header.jsp" %>
    <div class="modal fade show" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-modal="true" style="display:block">
      <div class="modal-dialog" role="document">
        <div class="modal-content">
          <div class="modal-body">
            <div class="column" id="main">
              <h1>LOG IN </h1>
              
				<form action="./login" method="post">
					<%
						String login_error = "";
						if(request.getAttribute("login_error")!=null){
							login_error = (String) request.getAttribute("login_error");
						}
					%>
					<div class="form-group">
						<label>아이디</label>
						<%
							if(!login_error.isEmpty()){
						%>
							<input type="text" class="form-control" name="username" value="<%=request.getParameter("username") %>" placeholder="아이디">
						<%
							} else {
						%>		
							<input type="text" class="form-control" name="username" placeholder="아이디">
						<%
							}
						%>
					</div>
					<div class="form-group">
			            <label>비밀번호</label>
			            <input type="password" class="form-control" name="password" placeholder="패스워드">
			        </div>
					<%
						if(!login_error.isEmpty()){
					%>
						<div>
							<label><%=login_error %></label>
						</div>
					<%
						}
					%>
					<div>
						<button type="submit" class="bubbly-button">LOG IN</button>
					</div>
				</form>
				  <div class="not-regist-div">
					  <span class="not-register-span">회원이 아니신가요?</span>
                    <a href="/register" class="link">
                        <span class="mask">
                            <div class="link-container">
                            <span class="link-title1 title">SIGN UP </span>
                            <span class="link-title2 title">SIGN UP </span>
                            </div>
                        </span>
                        <div class="link-icon">
                            <svg class="icon" width="24" height="24" xmlns="http://www.w3.org/2000/svg" fill-rule="evenodd" clip-rule="evenodd">
                            <path d="M21.883 12l-7.527 6.235.644.765 9-7.521-9-7.479-.645.764 7.529 6.236h-21.884v1h21.883z" />
                            </svg>
                            <svg class="icon" width="24" height="24" xmlns="http://www.w3.org/2000/svg" fill-rule="evenodd" clip-rule="evenodd">
                            <path d="M21.883 12l-7.527 6.235.644.765 9-7.521-9-7.479-.645.764 7.529 6.236h-21.884v1h21.883z" />
                            </svg>
                        </div>
                    </a>
				  </div>
			  </div>
			  <div style="height: 578px;">
                <?xml version="1.0" encoding="UTF-8"?>
                <svg width="67px" height="578px" viewBox="0 0 67 578" version="1.1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink">
                    <!-- Generator: Sketch 53.2 (72643) - https://sketchapp.com -->
                    <title>Path</title>
                    <desc>Created with Sketch.</desc>
                    <g id="Page-1" stroke="none" stroke-width="1" fill="none" fill-rule="evenodd">
                      <path d="M11.3847656,-5.68434189e-14 C-7.44726562,36.7213542 5.14322917,126.757812 49.15625,270.109375 C70.9827986,341.199016 54.8877465,443.829224 20.87109375,578 L67,578 L67,-5.68434189e-14 L11.3847656,-5.68434189e-14 Z" id="Path" fill="lavender"></path>            
                    </g>
                </svg>
              </div>
            <div class="column" id="secondary">
              
            </div>
          </div>
        </div>
      </div>
    </div>
    <script type="text/javascript" src="/static/js/bubble.js"></script>
    </div> 
    
</body>
</body>
</html>