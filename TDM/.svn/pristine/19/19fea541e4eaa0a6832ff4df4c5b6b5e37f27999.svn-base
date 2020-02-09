function menu_highlight(targetItem){
	var targetItemObj= $('#'+targetItem);
	targetItemObj.addClass('active');
}




function toggle2(showHideDiv, switchTextDiv) {
	var ele = document.getElementById(showHideDiv);
	var text = document.getElementById(switchTextDiv);
	if(ele.style.display == "table-row-group") {
    		ele.style.display = "none";
		text.innerHTML = "Show Advance Search";
  	}
	else {
		ele.style.display = "table-row-group";
		text.innerHTML = "Hide Advance Search";
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



function testDataFormNon(){
	var formObj = $("#testDataFormNon");
	var buttonObj = formObj.find('.btn-cell');
	 

	//form validation rules
	formObj.validate({
		 errorClass: "my-error-class",
	     validClass: "my-valid-class",
	     rules: {
	   	
			envType:{
				required:true
			},
			subscType:{
				required:true
			},
			provType:{
				required:true
			},
			testCaseId:{
				maxlength:25
	
			},
			testCaseName:{
				maxlength:50
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
 

 
 function tdgDataSubsettingValidation(){
		var formObj1 = $("#dataSubsettingForm");
		var buttonObj = formObj1.find('.btn-cell');
		 
		//form validation rules
		formObj1.validate({
			 errorClass: "my-error-class",
		     validClass: "my-valid-class",
		     rules: {
		    	    pageDtSub1:{
						required:true
					},
					pageDtSub2:{
						required:true
					} ,
					pageDtSub3:{
						required:true
					}	
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
 
 
 


/** for cancel request*/
function submitPopCancel(btn){
	document.location.href="./tdmDataMaskingPage3Cancel?reqId="+btn.name;
}

