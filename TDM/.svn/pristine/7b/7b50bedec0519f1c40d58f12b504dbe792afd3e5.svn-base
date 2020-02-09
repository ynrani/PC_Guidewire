function menu_highlight(targetItem){
	var targetItemObj= $('#'+targetItem);
	targetItemObj.addClass('active');
}




function toggle2(showHideDiv, switchTextDiv) {
	var ele = document.getElementById(showHideDiv);
	var text = document.getElementById(switchTextDiv);
	if(ele.style.display == "table-row-group") {
    		ele.style.display = "none";
		text.innerHTML = "Create Table..?";
  	}
	else {
		ele.style.display = "table-row-group";
		text.innerHTML = "Alreay exists..!";
	}
}

function enableParentScroll(obj, flag){
	if (flag)
	{
		$(obj).parent().addClass('scrollable');
	}
	else
	{
		$(obj).parent().removeClass('scrollable');
	}
}


  
function indexValidation(){
	var formObj1 = $("#tdmUploadForm");
	var buttonObj = formObj1.find('#upload');
	 

	//form validation rules
	formObj1.validate({
		 errorClass: "my-error-class",
	     validClass: "my-valid-class",
	     rules: {		   	
	    	 file:{
	    		 extension: "xlsx|csv|txt"
			} 			
	     },
	});
}

function loginValidation(){
		var formObj1 = $("#loginForm");
		var buttonObj = formObj1.find('#submit');
		 

		//form validation rules
		formObj1.validate({
			 errorClass: "my-error-class",
		     validClass: "my-valid-class",
		     rules: {		   	
		    	userid:{
					required:true,
					maxlength:13
				},
				password:{
					required:true,
					maxlength:12
				},
				projectId:{
					required:true,
					maxlength:20
				}				
		     },
		});
	}

function forgotPasswordValidation(){
	var formObj1 = $("#fPasswordForm");
	var buttonObj = formObj1.find('#submit');	 

	//form validation rules
	formObj1.validate({
		 errorClass: "my-error-class",
	     validClass: "my-valid-class",
	     rules: {		   	
	    	 userId:{
				required:true,
				maxlength:13
			},
			emailId:{
				required:true,
				email: true
			},
	     },
	});
}
 
  
 
 
 function clearFields(url){ 
 	window.location.href =url;
 	} 
 
 

 
 
 function submitPop(){
	 
	 disablePage();
	 $.ajax({
		type:'POST',
			url: "./tdmOnboardReq",
			dataType: 'html',
		data: $("#dataOnboardReqForm").serialize(),
		
			success: function( data ) {
				confirmation_dialog('Success Message','Your Request Id : '+data+' has been submited' ,400,'Ok','','');
				$('#submit').removeAttr();
			},
			error:function(jqXHR,error, errorThrown){
		
			}
		});
 }
 
 
function submitPopMr(){
	 
	 disablePage();
	 $.ajax({
		type:'POST',
			url: "./tdmDataMaskingPage3New",
			dataType: 'html',
		data: $("#dataMaskingForm3").serialize(),
		
			success: function( data ) {
			 	confirmation_dialog('Success Message','Your Request Id : '+data+' has been submited' ,400,'Ok','','',data);
			},
			error:function(jqXHR,error, errorThrown){
		
			}
		});
 }
 
 
function tdgChngReqValidation(){
	var formObj1 = $("#dataChReqForm");
	var buttonObj = formObj1.find('.btn-cell');
	 
 	//form validation rules
	formObj1.validate({
		 errorClass: "my-error-class",
	     validClass: "my-valid-class",
	     rules: {
	    	 reqId:{
					required:true,
					rangelength: [8, 13],
			} 
	     },
	     messages: {
	    	 reqId: {
	    		 required: "You must enter a Request Id",
	    		 rangelength: "Please enter valid Request Id",
              
	            } 
	        },
	     
	      
	     
	});
	 
}
 


/** for cancel request*/
function submitPopCancel(btn){
	document.location.href="./tdmDataMaskingPage3Cancel?reqId="+btn.name;
}

