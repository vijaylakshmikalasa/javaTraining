<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login Page</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f2f5;
        }
        .container {
            text-align: center;
            margin: 100px auto;
            max-width: 400px;
            background-color: #fff;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        }
        .logo {
            margin-bottom: 20px;
        }
        .form-control {
            width: 90%;
            padding: 10px;
            margin: 10px 0;
            border: 1px solid #ccc;
            border-radius: 3px;
        }
        .forgot-password {
            text-align: center;
        }
        h1{
        color: blue;
        }
        .newAC{
        text-decoration: blink;
        color: green;
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="logo">
            <img src="valtechLogo.jpg" alt="Facebook Logo" width="100">
            <h1 >Valtech India</h1>
        </div>
        <form action="facebooklogin" method="post">
            <input type="text" class="form-control" name="username" placeholder="Username" required>
            <input type="password" class="form-control" name="password" placeholder="Password" required>
            <button type="submit" class="form-control">Log In</button>
        </form>
        <div class="forgot-password">
            <a href="forgot-password.jsp">Forgot Password?</a>
        </div>
        <hr>
        <div>
        <button type="reset" class=" newAC" >Create New Account</button>
        </div>
    </div>
</body>
</html>