<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.web.register.model.*" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>회원가입</title>
	<%@ include file ="/module/head.jsp" %>
</head>
<body class="modal-open" style="padding-right:16px;">
	
	<%@ include file="/module/header.jsp" %>
	
    <div class="modal fade show" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-modal="true" style="display:block">
      <div class="modal-dialog" role="document">
        <div class="modal-content">
          <div class="modal-body">
            <div class="column" id="main">
              <h1>Sign Up </h1>
              
              <form action="./register" method="post"> 
                <div class="form-group">
                  <label>아이디</label>
                  <input type="name" class="form-control" name="username" placeholder="Name">
                </div>
                <div class="form-group">
                  <label>비밀번호</label>
                  <input type="password" class="form-control" name="password" placeholder="Password">
                </div>
                <div class="form-group">
                  <label>비밀번호 확인</label>
                  <input type="password" class="form-control" name="password_check" placeholder="Password">
                </div>
                <div class="form-group">
                  <label>이메일</label>
                  <input type="email" class="form-control" name="email" aria-describedby="emailHelp" placeholder="E-mail">
                </div>
                <div class="form-group">
                  <label>성별</label>
                  <select class="form-select form-control" name="gender">
                    <option value="f">여자</option>
                    <option value="m">남자</option>
                  </select>
                </div>
                <div class="height-weight">
                  <div class="height-div form-group">
                    <label>키</label>
                    <input type="text" class="height-inp form-control" name="height" placeholder="Password">
                  </div>
                  <div class="weight-div form-group">
                    <label>몸무게</label>
                    <input type="text" class="weight-inp form-control" name="weight" placeholder="Password">
                  </div>
                </div>
                <button type="submit" class="bubbly-button">Sign Up</button>
              </form>
            </div>
            <div style="height: 904.25px;">
              <?xml version="1.0" encoding="UTF-8"?>
              <svg width="67px" height="904.250px" viewBox="0 0 67 904.250" version="1.1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink">
                  <!-- Generator: Sketch 53.2 (72643) - https://sketchapp.com -->
                  <title>Path</title>
                  <desc>Created with Sketch.</desc>
                  <g id="Page-1" stroke="none" stroke-width="1" fill="none" fill-rule="evenodd">
                    <path d="M11.3847656,-5.68434189e-14 C-7.44726562,36.7213542 5.14322917,126.757812 49.15625,270.109375 C70.9827986,341.199016 54.8877465,443.829224 20.87109375,578  C5.9827986,650.1 35.8877465,830.829224 50.87109375,904.250 L67,904.250 L67,-5.68434189e-14 L11.3847656,-5.68434189e-14 Z" id="Path" fill="lavender"></path>            
                  </g>
              </svg>
            </div>
            <div class="column" id="secondary">
              <div class="sec-content">
            
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    <script type="text/javascript" src="/static/js/bubble.js"></script>
      
</body>
</html>