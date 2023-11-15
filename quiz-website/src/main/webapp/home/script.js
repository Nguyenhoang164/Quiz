// Thêm hiệu ứng khi di chuột qua nút đăng kí và đăng nhập
var buttons = document.querySelectorAll('.buttons button');
buttons.forEach(function(button) {
    button.addEventListener('mouseover', function() {
        this.style.backgroundColor = '#ff8b5c';
    });
    button.addEventListener('mouseout', function() {
        this.style.backgroundColor = '#c15b75';
    });
    button.addEventListener('mouseout', function() {
        this.style.backgroundColor = '#ff8b5c';
    });
    button.addEventListener('mouseout', function() {
        this.style.backgroundColor = '#c15b75';
    });
});

// Thêm hiệu ứng khi di chuột qua logo
var logo = document.querySelector('.logo img');
logo.addEventListener('mouseover', function() {
    this.style.transform = 'rotate(360deg)';
    this.style.transition = 'transform 1s';
});
logo.addEventListener('mouseout', function() {
    this.style.transform = 'rotate(0deg)';
    this.style.transition = 'transform 1s';
});

window.onload = function() {
    var audio = document.getElementById("myAudio");
    audio.play();
};