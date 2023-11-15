<%--
  Created by IntelliJ IDEA.
  User: tuancd
  Date: 25/10/2023
  Time: 08:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <title>Trang web trò chơi câu hỏi</title>
  <link rel="stylesheet" type="text/css" href="style.css">
</head>

<body>
<header>
  <div class="header">
    <img src="img-profile.png" alt="Profile Image" class="img-profile">
    <div class="profile-menu">
      <ul>
        <li>Tài khoản</li>
        <li>Cài đặt</li>
      </ul>
    </div>
  </div>
</header>

<div class="category">
  <div class="category-list">
    <div class="category-list-item active">Class 1</div>
    <div class="category-list-item">Class 2</div>
    <div class="category-list-item">Class 3</div>
    <!-- Thêm danh mục khác tại đây -->
  </div>
  <button class="add-category">Thêm Class</button>
</div>

<div class="main-content">
  <!-- Nội dung thao tác chính -->
</div>
</body>

<footer>
  <div class="nav-bar">
    <div class="nav-bar-item">Khám phá</div>
    <div class="nav-bar-item">Lớp học</div>
    <div class="nav-bar-item">Lịch sử</div>
    <div class="nav-bar-item">Thống kê</div>
    <div class="nav-bar-item">Cài đặt</div>
  </div>
</footer>
<script src="script.js"></script>
</html>
