<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Pik Quiz - Teacher</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
            crossorigin="anonymous"></script>

    <!-- Add FontAwesome library -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">

    <style>
        body {
            background-color: #FBEAEB;
        }

        .custom-navbar {
            padding: 1rem 2rem; /* Adjust the padding to increase the size of the navbar */
            background-color: #38368b; /* Set the background color of the navbar */
        }

        .navbar-brand {
            font-size: 1.5rem; /* Increase the font size of the navbar brand */
            color: #FBEAEB; /* Set the color of the navbar brand */
        }

        .navbar-nav .nav-link {
            font-size: 1.2rem; /* Increase the font size of the navbar links */
            color: #FBEAEB; /* Set the color of the navbar links */
        }

        .nav-item:hover .nav-link {
            color: #FF0000; /* Change the color of the navbar link on hover */
            font-weight: bold; /* Add bold font weight on hover */
        }
    </style>
</head>
<body>


<nav class="navbar navbar-expand-lg navbar-light custom-navbar">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">
            <strong>
                <span class="cute-text" STYLE="color: #020053">Pik Quizizz</span>
            </strong>
        </a>
        <style>
            .cute-text {
                display: inline-block;
                background-color: #FBEAEB; /* Màu nền */
                border-radius: 10px; /* Bo tròn góc */
                padding: 5px 10px; /* Khoảng cách giữa văn bản và viền */
                font-size: 20px; /* Cỡ chữ */
                font-weight: bold; /* Đậm chữ */
                box-shadow: 2px 2px 5px rgba(0, 0, 0, 0.2); /* Đổ bóng */
            }
        </style>
        <div class="collapse navbar-collapse justify-content-end" id="navbarSupportedContent">
            <ul class="navbar-nav mb-2 mb-lg-0">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button"
                       data-bs-toggle="dropdown" aria-expanded="false">
                        <i class="fas fa-cog" style="color: #FBEAEB"></i>
                        <!-- Thay thế chữ "Account" bằng biểu tượng bánh răng -->
                    </a>
                    <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="navbarDropdown">
                        <li><a class="dropdown-item" href="#" style="color: #020053">Edit Account</a></li>
                        <li><a class="dropdown-item" href="#" onclick="confirmLogout()" style="color: #020053">Log
                            Out</a></li>

                        <li><a class="dropdown-item" href="#" style="color: #020053">Delete Account</a></li>
                        <li>
                            <hr class="dropdown-divider">
                        </li>
                        <li><a class="dropdown-item" href="/admin/teacher_Management.jsp" style="color: #020053">Teacher
                            Management</a></li>
                        <li><a class="dropdown-item" href="/admin/student_Management.jsp" style="color: #020053">Student
                            Management</a></li>
                        ```html
                    </ul>
                </li>
            </ul>
        </div>
    </div>
</nav>

<!-- ... -->
<div class="container mt-4">
    <table class="table table-bordered table-striped">
        <thead>
        <tr>
            <th>Name</th>
            <th>Email</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="list" items="${requestScope.u}">
            <tr>
                <td class="rounded">${list.getName()}</td>
                <td class="rounded">${list.getEmail()}</td>
                <td>
                    <a href="admin?action=delete&id=${list.getId()}&permission=${list.getPermission()}">
                        <button class="btn btn-danger" onclick="confirmDelete()">Delete</button>
                    </a>
                    <button class="btn btn-primary" onclick="editUser()">Edit</button>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<!-- ... -->
<script>
    function editUser() {
        // Chỉnh sửa người dùng
        // ...
    }
    function confirmDelete(){
        window.location.reload();
    }
</script></body>
</html>