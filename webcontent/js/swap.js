//var picPaths = ['images/logo.jpg','images/page1_img1.jpg','images/page1_img2.jpg','images/page1_img3.jpg','images/page1_img4.jpg'];


function displayNextImage() {
    x = (x === images.length - 1) ? 0 : x + 1;
    document.getElementById("img").src = images[x];
}

function displayPreviousImage() {
    x = (x <= 0) ? images.length - 1 : x - 1;
    document.getElementById("img").src = images[x];
}

function startTimer() {
    setInterval(displayNextImage, 3000);
}

var images = [], x = -1;
images[0] = "images/logo.jpg";
images[1] = "images/page1_img1.jpg";
images[2] = "images/page1_img2.jpg";
images[3] = "images/page1_img3.jpg";
images[4] = "images/page1_img4.jpg";