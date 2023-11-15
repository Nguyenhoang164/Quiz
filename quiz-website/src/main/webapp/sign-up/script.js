document.getElementById('register-form').addEventListener('submit', function(event) {
    event.preventDefault(); // Ngăn chặn form gửi dữ liệu đi

    // Lấy giá trị từ các trường input
    var displayName = document.getElementById('display-name').value;
    var email = document.getElementById('email').value;
    var password = document.getElementById('password').value;
    var confirmPassword = document.getElementById('confirm-password').value;

    // Kiểm tra xem mật khẩu và nhập lại mật khẩu có khớp nhau hay không
    if (password !== confirmPassword) {
        alert('Mật khẩu và nhập lại mật khẩu không khớp!');
        return;
    }

    // Gửi dữ liệu đăng ký đến máy chủ hoặc xử lý theo yêu cầu của bạn
    // ở đây, chúng ta chỉ in ra thông tin đăng ký
    console.log('Tên hiển thị:', displayName);
    console.log('Email:', email);
    console.log('Mật khẩu:', password);

    // Reset form sau khi đăng ký thành công
    document.getElementById('register-form').reset();
});