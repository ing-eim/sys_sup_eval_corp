/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(document).ready(function() {     
    $("form").submit(function(e){
        e.preventDefault();
        var us = $("#txtempleado").val();
        var pwd = $("#txtpassword").val();
        /*if (pwd.length > 10){
            $("#msg_sal").html("Longitud del Password debe ser menor a 10 caracteres");
            $("#txtpassword").focus();
            return 0;
        }*/
        
        $.ajax({
			url : 'log_in',
                        type: 'post',
			data : {
				us : us,
                                pwd : pwd
			},
			success : function(responseText) {                                
                                var s =  responseText.split("|");
				if(s[0] === true || s[0]=== "true"){
                                    window.location.href = 'sup_eval_corp.jsp';
                                }else{                                    
                                    //alert(s[1]);
                                    $("#msg_sal").html(s[1]);
                                }                              
                                
			}
		});
   });    
});
