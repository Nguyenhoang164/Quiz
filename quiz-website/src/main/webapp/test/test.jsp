<%--
  Created by IntelliJ IDEA.
  User: tuancd
  Date: 25/10/2023
  Time: 09:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Main Page</title>
    <style>
        /* CSS cho phần header */
        header {
            background-color: #f2f2f2;
            padding: 20px;
        }

        /* CSS cho phần nav bên trái */
        nav.left-nav {
            background-color: #e6e6e6;
            float: left;
            width: 20%;
            height: 800px;
            padding: 10px;
        }

        /* CSS cho phần div bên phải */
        div.right-div {
            background-color: #ffffff;
            float: right;
            width: 77%;
            height: 800px;
            padding: 5px;
        }

        /* CSS cho phần nav dưới cùng */
        nav.bottom-nav {
            background-color: #f2f2f2;
            clear: both;
            padding: 20px;
            position: fixed;
            display: flex;
            justify-content: space-around;
        }
    </style>
</head>
<body>
<header>
    <!-- Nội dung của phần header -->
</header>

<nav class="left-nav">
    <!-- Nội dung của phần nav bên trái -->
</nav>

<div class="right-div">
    <!-- Nội dung của phần div bên phải -->
</div>

<nav class="bottom-nav">
    <!-- Nội dung của phần nav dưới cùng -->
</nav>
</body>
</html>
