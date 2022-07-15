<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	body{
    		background-image: url("img/1.png");
    	}
    .login-page {
		  width: 360px;
		  padding: 8% 0 0;
		  margin: auto;
		}
	.form {
		  position: relative;
		  z-index: 1;
		  background: #FFFFFF;
		  max-width: 360px;
		  margin: 0 auto 100px;
		  padding: 45px;
		  text-align: center;
		  box-shadow: 0 0 20px 0 rgba(0, 0, 0, 0.2), 0 5px 5px 0 rgba(0, 0, 0, 0.24);
		}
		.form input {
		  font-family: "Roboto", sans-serif;
		  outline: 0;
		  background: #f2f2f2;
		  width: 100%;
		  border: 0;
		  margin: 0 0 15px;
		  padding: 15px;
		  box-sizing: border-box;
		  font-size: 14px;
		}
		.form button {
		  font-family: "Microsoft YaHei","Roboto", sans-serif;
		  text-transform: uppercase;
		  outline: 0;
		  background: #4CAF50;
		  width: 100%;
		  border: 0;
		  padding: 15px;
		  color: #FFFFFF;
		  font-size: 14px;
		  -webkit-transition: all 0.3 ease;
		  transition: all 0.3 ease;
		  cursor: pointer;
		}
		.form button:hover,.form button:active,.form button:focus {
		  background: #43A047;
		}
		.form .message {
		  margin: 15px 0 0;
		  color: #b3b3b3;
		  font-size: 12px;
		}
		.form .message a {
		  color: #4CAF50;
		  text-decoration: none;
		}
</style>
</head>
<body>
<div id="wrapper" class="login-page">
<div id="login_form" class="form">
	<form action="registerServlet" method="post">
		<input type="text" placeholder="用户名" id="r_user_name" name="r_name"/>
		<input type="password" placeholder="密码" id="r_password" name="r_password"/>
		<input type="password" placeholder="确认密码" id="r_password" name="r_password2"/>
		<button id="create">创建账户</button>
		<p class="message">已经有了一个账户? <a href="login.jsp">立刻登录</a></p>
		<p style="color: red; font-size: 10px;" id="r_msg">${msg}</p>
	</form>
</div>
</div>
</body>
</html>