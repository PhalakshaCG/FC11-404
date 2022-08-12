document.getElementById("button").addEventListener("click", changeStyle);
function changeStyle(){
    var element = document.getElementById("alert");
    element.style.opacity = "0";
}
changeStyle();