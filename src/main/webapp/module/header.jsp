<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" href="/static/css/side-bar.css">
<div class="header" style="border-bottom:none;">
        <div class="side-menu-bar">
            <!-- 사이드 메뉴바 jsp --> 
            <nav role="navigation">
                <div id="menuToggle">
                    <input type="checkbox">
                    <span></span>
                    <span></span>
                    <span></span>
                
                <!-- 사이드 메뉴 종류들 -->
                    <ul id="menu">
                        <li class="menu-name">TOP</li>
                        <a href="/"><ul>니트</ul></a>
                        <a href="/"><ul>후드티</ul></a>
                        <a href="/"><ul>셔츠/블라우스</ul></a>
                        <a href="/"><ul>크롭/민소매</ul></a>
                        
                        <li class="menu-name">BOTTOM</li>
                        <a href="/"><ul>바지</ul></a>
                        <a href="/"><ul>치마</ul></a>
                        <a href="/"><ul>원피스</ul></a>
                        <a href="/"><ul>트레이닝/레깅스</ul></a>
                        
                        <li class="menu-name">OUTER</li>
                        <a href="/"><ul>자켓</ul></a>
                        <a href="/"><ul>가디건</ul></a>
                        <a href="/"><ul>트렌치코트</ul></a>
                        <a href="/"><ul>패딩</ul></a>
                                
                        <li class="menu-name">COMMUNITY</li>
                        <a href="/"><ul>상품후기</ul></a>
                        <a href="/"><ul>이벤트</ul></a>
                        <a href="/"><ul>공지사항</ul></a>
                        <a href="/"><ul>고객문의</ul></a>   
                    </ul>
                </div>
            </nav>
        </div>
        <div class="header-img">
            <a href="/">
                <img src="/static/img/semi-logo.PNG">
            </a>
        </div>
    	<% 
	   		if(session.getAttribute("login_name") != null) {
	    %>
        <div class="header-right-block">
	        <div class="header-welcome-user">
                <p class="header-welcome-user-p"><%=(String)session.getAttribute("login_name") %>님 환영합니다</p>
            </div>
	        <div class="header-right">
	            <nav class="header-nav">
	                <ul>
	                
				    	<li><a href="/logout">Logout</a></li>
				    	<li><a href="/review">review</a></li>
				    </ul>
            	</nav>
        	</div>
       </div>
	    <%
	    	} else {
	   	%>
	   	<div class="header-right-block">
	        <div class="header-welcome-user">
                
            </div>
	        <div class="header-right">
	            <nav class="header-nav">
	                <ul>	
	                    <li><a href="/register">Sign in</a></li>
	                    <li><a href="/login">Login</a></li>
                    </ul>
            	</nav>
        	</div>
       </div>
        <%
	    	}
		%>
	               
    </div>