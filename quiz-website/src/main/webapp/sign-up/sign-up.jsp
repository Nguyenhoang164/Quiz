<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Pik Quizz - Register</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <style>
        body {
            padding: 40px;
            background: #FBEAEB;
        }

        .form-container {
            max-width: 400px;
            margin: 0 auto;
            background-color: #fff;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.3);
        }

        .form-container h1 {
            text-align: center;
            margin-bottom: 20px;
            color: #020053;
        }

        .form-container label {
            color: #020053;
            font-size: 20px;
        }

        .form-container input[type="text"],
        .form-container input[type="email"],
        .form-container input[type="password"],
        .form-container select {
            width: 100%;
            padding: 10px;
            margin-bottom: 20px;
            border-radius: 5px;
            border: 1px solid #ccc;
        }

        .form-container input[type="submit"] {
            width: 100%;
            padding: 10px;
            border-radius: 5px;
            border: none;
            background-color: #38368b;
            color: #fff;
            font-weight: bold;
            cursor: pointer;
        }

        .form-container input[type="submit"]:hover {
            background-color: #1A2557;
        }

        .text-center {
            text-align: center;
        }

        .mt-3 {
            margin-top: 20px;
        }

        .text-center a {
            color: #3F3C7E;
            text-decoration: none;
        }

        .text-center a:hover {
            text-decoration: underline;
        }

        .form-container select {
            width: 100%;
            padding: 10px;
            margin-bottom: 20px;
            border-radius: 5px;
            border: 1px solid #ccc;
            box-sizing: border-box; /* Ensure the select box includes padding and border in its width */
        }
    </style>
</head>
<body>
<div class="form-container">
    <h1>Register</h1>
    <form id="form-signup" action="/signup?action=register" method="post">
        <div class="form-group">
            <label for="display-name">Name:</label>
            <input type="text" id="display-name" name="displayName" style="width: 362px; height: auto"
                   class="form-control ">
        </div>

        <div class="form-group">
            <label for="email">Email:</label>
            <input type="email" id="email" name="email" class="form-control" style="width: 362px; height: auto"
                   required>
        </div>

        <div class="form-group">
            <label for="password">Password:</label>
            <input type="password" id="password" onchange="checkPassword()" name="password" class="form-control"
                   minlength="6" style="width: 362px; height: auto" required>
        </div>

        <div class="form-group">
            <label for="confirm-password">Confirm Password:</label>
            <input type="password" id="confirm-password" name="confirmPassword" class="form-control" minlength="6"
                   style="width: 362px; height: auto" required>
            <p id="notify"></p>
        </div>

        <div class="form-group">
            <label for="role">Role:</label>
            <select id="role" name="role" class="form-control" style="width: 362px; height: auto">
                <option value="student" style="color: #020053">Student</option>
                <option value="teacher" style="color: #020053">Teacher</option>
            </select>
        </div>

        <div class="d-grid">
            <input type="submit" value="Register" style=" background-color: #38368b;color: #FBEAEB"
                   class="btn btn-primary">
        </div>
    </form>

    <script>
        const password = document.getElementById("password");
        const confirmPassword = document.getElementById("confirm-password");
        const notify = document.getElementById("notify");

        confirmPassword.addEventListener("input", checkPassword);
        password.addEventListener("input", checkPassword);

        function checkPassword() {
            let pass = password.value;
            let passwordConfirm = confirmPassword.value;

            if (pass === "" || passwordConfirm === "") {
                notify.textContent = "";
            } else if (pass === passwordConfirm) {
                notify.textContent = "Check!";
            } else {
                notify.textContent = "Password mismatch!";
            }
        }
    </script>

    <div class="text-center mt-3">
        <p style="color: #020053">Already have an account? <a href="/login/login.jsp">Login here</a></p>
    </div>
    <div class="text-center mt-3">
        <p style="color: #020053">Love the bunny? <a href="/home/home.jsp">Back home</a></p>
    </div>
</div>
<script src="js/bootstrap.min.js"></script>
</body>
</html>