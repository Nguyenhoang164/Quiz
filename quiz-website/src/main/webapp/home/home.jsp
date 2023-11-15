<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Pik Quizz</title>
    <link rel="stylesheet" href="../home/style.css">
</head>
<body>
<header>
    <div class="logo">
        <img src="/img/PikQuiz2.png" alt="Logo">
    </div>
    <div class="buttons">
        <form action="/sign-up/sign-up.jsp" method="get">
            <input class="button" name="signup" type="submit" value="Register"/>
        </form>
        <br>
        <form action="/login/login.jsp" method="get">
            <input class="button" name="login" type="submit" value="Login"/>
        </form>
    </div>
</header>
<div class="background">
    <video autoplay loop muted>
        <source src="/video/Pink Purple Gradient Kawaii Cute Vlog YouTube Intro (2).mp4" type="video/mp4">
    </video>
</div>
<div class="content">
    <%--    các bài ktra--%>
</div>
<script src="../home/script.js"></script>
</body>
</html>
