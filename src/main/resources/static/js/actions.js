function demo(){
    alert("Thymeleaf with CSS an JS demo")
}
let itemNum = 1;
function addItem() {
    itemNum++;
    const inputList = document.getElementById("input-list");
    const newItem = document.createElement("input");
    const newItem2 = document.createElement("br");
    newItem.setAttribute("type", "text");
    newItem.setAttribute("name", "item");
    inputList.insertBefore(newItem, inputList.lastChild);
    inputList.insertBefore(newItem2, inputList.lastChild);
}
function deleteItem() {
    const inputList = document.getElementById('input-list');
    const inputCount = inputList.children.length;
    if (inputCount > 1) {
        inputList.removeChild(inputList.lastElementChild);
        inputList.removeChild(inputList.lastElementChild);
    }
}
function merge(){
    const resulto = document.getElementById("resultText");
    var inputs = document.querySelectorAll('#input-list input[name="item"]');
    var totalString  = "";
    for (var i = 0; i < inputs.length; i++) {
        totalString =  totalString.concat(inputs[i].value);
        totalString =  totalString.concat("-");
    }
    resulto.value = totalString;


}