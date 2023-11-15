// Xử lý hiển thị/ẩn menu tài khoản khi click vào ảnh
const imgProfile = document.querySelector('.img-profile');
const profileMenu = document.querySelector('.profile-menu');
imgProfile.addEventListener('click', function() {
    profileMenu.style.display = profileMenu.style.display === 'none' ? 'block' : 'none';
});

// Xử lý chọn danh mục
const categoryListItems = document.querySelectorAll('.category-list-item');
categoryListItems.forEach(function(item) {
    item.addEventListener('click', function() {
        categoryListItems.forEach(function(item) {
            item.classList.remove('active');
        });
        item.classList.add('active');
    });
});