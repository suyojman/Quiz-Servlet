/*$('.message a').click(function(){
   $('form').animate({height: "toggle", opacity: "toggle"}, "slow");
});*/
$('.message a').click(function(){
    $('form').animate({height: "toggle", opacity: "toggle"}, "slow");
});

function validate() {
    if (validateEmail() && validatePassword()) {
        return true;
    } else {

        return false;
    }
}


    function validatePassword() {
        var y = document.forms["login"]["password"].value;

        if (y =="") {
            alert("Please enter the password");
            document.forms["login"]["password"].focus();
            return false;

        } else {
            return true;
        }
    }


    function validateEmail() {
        var x = document.forms["login"]["email"].value;

        if (x == "") {
            alert("Please enter the email");
            document.forms["login"]["email"].focus();
            return false;

        } else {
            return true;
        }


}

var sec=20;

function countdown(){
    if (parseInt(sec)>0){
        document.getElementById("timer").innerHTML="Time Remaining :"+ sec +"seconds"
        sec=parseInt(sec)-1;

        var currentSec=document.getElementById("second");
        currentSec.val=sec;
        tim=setTimeout("countdown()",1000);
    }
    else{
        if(parseInt(sec)==0){
            document.getElementById("timer").innerHTML="Time Remaining :"+ sec + "seconds"
            alert("Time out !!");
            var inputs=document.getElementsByTagName('input');
            for(var i=0;i<inputs.length;i++){
                if(inputs[i].type=='radio')
                {
                    inputs[i].disabled=true;
                }
            }
        }
    }
}