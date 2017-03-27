<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Baccarat Login Page</title>
<script src="${pageContext.request.contextPath }/js/jquery-1.8.3.js" type="text/javascript"></script>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/style.css" />
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/css/style_grey.css" />
<style>
input[type=text] {
	width: 80%;
	height: 25px;
	font-size: 12pt;
	font-weight: bold;
	margin-left: 45px;
	padding: 3px;
	border-width: 0;
}

input[type=password] {
	width: 80%;
	height: 25px;
	font-size: 12pt;
	font-weight: bold;
	margin-left: 45px;
	padding: 3px;
	border-width: 0;
}

#loginform\:codeInput {
	margin-left: 1px;
	margin-top: 1px;
}

#loginform\:vCode {
	margin: 0px 0 0 60px;
	height: 34px;
}
</style>
</head>
<body>
	<div
		style="width: 900px; height: 50px; position: absolute; text-align: left; left: 50%; top: 50%; margin-left: -450px;; margin-top: -280px;">
		<span style="float: right; margin-top: 35px; color: #488ED5;">Welcome to Baccarat Pro V1.0</span>
	</div>
	<div class="main-inner" id="mainCnt"
		style="width: 900px; height: 440px; overflow: hidden; position: absolute; left: 50%; top: 50%; margin-left: -450px; margin-top: -220px; background-image: url('${pageContext.request.contextPath }/images/baccarat_login.jpg')">
		<div id="loginBlock" class="login" style="margin-top: 200px; height: 220px;right: 95px">
			<div class="loginFunc">
				<div id="lbNormal" class="loginFuncMobile">User Login</div>
			</div>
			<div class="loginForm">
				<s:form namespace="/" action="login" id="loginform" name="loginform" method="post" cssClass="niceform" target="_top">
				<s:actionerror/>

						<s:textfield id="loginform:idInput" name="userName"
							 maxlength="50" tabindex="1" title="Username" label="Username " style="margin-left:20px"/>	

						<s:password id="loginform:pwdInput"  type="password"
							name="passWord" value="" tabindex="2" title="Password" label="Password"  style="margin-left:20px"/>	
						
					<div class="loginFormIpt loginFormIptWiotTh"
						style="margin-top:58px;">
						<div id="codeInputLine" class="loginFormIpt showPlaceholder"
							style="margin-left:0px;margin-top:-40px;width:50px;">
							<img id="loginform:vCode" src="${pageContext.request.contextPath }/validatecode.jsp"
								onclick="javascript:document.getElementById('loginform:vCode').src='${pageContext.request.contextPath }/validatecode.jsp?'+Math.random();" />
							<input id="loginform:codeInput" class="loginFormTdIpt" type="text"
								name="validationCode" title="Please input validation code" />
						</div>
						<a href="javascript:$('#loginform').submit();" id="loginform:j_id19" name="loginform:j_id19">
						<span
							id="loginform:loginBtn" class="btn btn-login"
							style="margin-top:-36px;">Login</span>
						</a>
					</div>
				</s:form>
			</div>
		</div>
	</div>
	<div
		style="width: 900px; height: 50px; position: absolute; text-align: left; left: 50%; top: 50%; margin-left: -450px;; margin-top: 220px;">
		<span style="color: #488ED5;">Powered By Du Hong; All Rights Reserved</span><span
			style="color: #488ED5;margin-left:10px;">Recommended Browser <a
			href="http://download.firefox.com.cn/releases/full/23.0/zh-CN/Firefox-full-latest.exe">Firefox</a>
		</span><span style="float: right; color: #488ED5;">Baccarat Pro</span>
	</div>
</body>
</html>