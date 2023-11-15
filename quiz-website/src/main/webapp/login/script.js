document.getElementById("login-form").addEventListener("submit", function(event) {
    event.preventDefault();

    // Lấy giá trị từ các trường input
    var email = document.getElementById("email").value;
    var password = document.getElementById("password").value;

    // Kiểm tra xem email và mật khẩu có hợp lệ hay không (ví dụ: không được để trống)
    if (email.trim() === "" || password.trim() === "") {
        showErrorMessage("Vui lòng điền đầy đủ thông tin.");
        return;
    }

    // Gửi dữ liệu đăng nhập đến server
    // Code xử lý đăng nhập ở phía server

    // Xóa nội dung các trường input
    document.getElementById("email").value = "";
    document.getElementById("password").value = "";

    // Hiển thị thông báo thành công
    alert("Đăng nhập thành công!");
});

function showErrorMessage(message) {
    var errorElement = document.createElement("p");
    errorElement.classList.add("error-message");
    errorElement.textContent = message;

    var container = document.querySelector(".container");
    container.appendChild(errorElement);
}