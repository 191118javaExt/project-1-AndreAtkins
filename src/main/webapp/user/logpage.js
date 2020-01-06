



button = document.getElementsByName("type");
//button.addEventListener(click, select);
let press = document.getElementById("press");
let form = document.getElementById("reinform");
var one = document.getElementById("1");
var two = document.getElementById("2");
var three = document.getElementById("3");
var four = document.getElementById("4"); 






function select(){

let type = getElementsByName("type");

if(type.checked == true){

    type.checked= false;

}

}

function isChosen(){

    if(one.checked == false && two.checked == false && three.checked == false && four.checked == false)
    {
        alert("Must select a reinbursement type")
  
    }
    


}






function isNumThere (){

let box = document.getElementById("numbox")

if(box.value == false){

alert("Amount can not be left blank")

return false;

}else{

    return true;
}
}

function isFileUpload (){

    let file = document.getElementById("exampleFormControlFile1")

    let label =  document.getElementById("upload")


    if(file.value == false || label.value == false){
    
    alert("Must upload a reciept to submit a reinbursement")


    }

}