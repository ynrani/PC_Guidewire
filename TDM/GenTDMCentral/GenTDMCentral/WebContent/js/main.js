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


function providerSearchValidation(){
	var formObj = $("#testDataForm");
	var buttonObj = formObj.find('.validClass');
	 

	//form validation rules
	formObj.validate({
		 errorClass: "my-error-class",
	     validClass: "my-valid-class",
	     rules: {
	    	provZip:{
	    			number:true,
					maxlength:5,
					digits: true
				},
			countryCode:{
					number:true,
					maxlength:4
				},
			tin:{
					number:true,
					maxlength:9
				},
			nip:{
					maxlength:10,
					number:true
				},
			envType:{
				required:true
			}, 
			testCaseId:{
				maxlength:25,
			},
			testCaseName:{
				maxlength:50,
	 		} 
	     },
	     
	     submitHandler: function(form) {
	    	 $("body").addClass("loading");
	    	 form.submit();
	     },
	     messages: {
	    	 provZip: "Please enter no more than 5 digits."
	        },
	});
}

function submitCancelonBoardReq(reqId){
	
	if ($('#text_MR').val() == '')
	{
		$('#text_MR').next(".my-error-class").remove(); 
		$('#text_MR').after('<div class="my-error-class">Please enter reason for concellation.</div>');
	  return false;
	}
	
	var forwardUrl ="./tdmOnBoardingDashBoard";
	if(reqId.indexOf("CR") > -1)
		{
	    	forwardUrl ="./tdmOnBoardingDashBoardCR"
		}
	
	 $.ajax({
		type:'POST',
			url: "./cancelOnBoardingReq?reqId="+reqId,
			dataType: 'html',		   
			success: function( data ) {
				   if(data == 'true')
					{
					  confirmation_dialog_forward(forwardUrl,'Message', "Request Id "+reqId+" successfully cancelled."  ,400,'Ok','','');
					}
			     	else if(data == 'false')
					{
			     		confirmation_dialog('Message', "Requested Id contains change requests, please cancel them first."  ,400,'Ok','','');
					}
			     	else
			     	{
			     		confirmation_dialog('Error Message', "Unable to do requested operation."  ,400,'Ok','','');
			        }				
				},
				error:function(data){
					confirmation_dialog('Error Message', "Unable to do requested operation."  ,400,'Ok','','');
				}
		});
}

function submitCancelMR(reqId){
	
	if ($('#text_MR').val() == '')
	{
		$('#text_MR').next(".my-error-class").remove(); 
		$('#text_MR').after('<div class="my-error-class">Please enter reason for concellation.</div>');
	  return false;
	}
	var forwardUrl ="./tdmDtMaskDashboard";
	if(reqId.indexOf("CR") > -1)
		{
	    	forwardUrl ="./tdmDtMaskDashBoardCR"
		}
	
	 $.ajax({
		type:'POST',
			url: "./cancelMaskingReq?reqId="+reqId,
			dataType: 'html',		   
			success: function( data ) {
				   if(data == 'true')
					{
					  confirmation_dialog_forward(forwardUrl,'Message', "Request Id "+reqId+" successfully cancelled."  ,400,'Ok','','');
					}
			     	else if(data == 'false')
					{
			     		confirmation_dialog('Message', "Requested Id contains change requests, please cancel them first."  ,400,'Ok','','');
					}
			     	else
			     	{
			     		confirmation_dialog('Error Message', "Unable to do requested operation."  ,400,'Ok','','');
			        }				
				},
				error:function(data){
					confirmation_dialog('Error Message', "Unable to do requested operation."  ,400,'Ok','','');
				}
		});
}
 
function subscriberSearchValidation(){
	var formObj = $("#testDataFormSubsc");
	var buttonObj = formObj.find('.btn-cell');
	 
	 
	//form validation rules
	formObj.validate({
		 errorClass: "my-error-class",
	     validClass: "my-valid-class",
	     rules: {
	   	
			envType:{
				required:true
			},
			 
			subscZip:{
				number:true,
				maxlength:5,
				digits: true
			},
			subscAgeStart: {
 			    digits: true,
 			   range: [1, 30]
			},
			subscAgeEnd: {
			    digits: true,
			    range: [31, 99]
		 	},
		 	testCaseId:{
				maxlength:25
			},
			testCaseName:{
				maxlength:50
			} 
			
	     },
	     submitHandler: function(form) {
	    	 $("body").addClass("loading");
	    	 form.submit();
	     },
	     
	     messages: {
	    	 subscZip: "Please enter no more than 5 digits."
	        },
	});
}


function subscriberSearchValidationResr(){
	 
	
}


function claimSearchValidation(){
	var formObj = $("#testDataFormClaim");
	var buttonObj = formObj.find('.btn-cell');
	 

	//form validation rules
	formObj.validate({
		 errorClass: "my-error-class",
	     validClass: "my-valid-class",
	     rules: {
	   	
			envType:{
				required:true
			}, 
			claimModifier:{
				maxlength:10
			},
			claimProviderTIN:{
				number:true,
				maxlength:9
			},
			claimProviderNPI:{
				number:true,
				maxlength:9
			}
	     },
	     
	     submitHandler: function(form) {
	    	 $("body").addClass("loading");
	    	 form.submit();
	     },
	 });
}


function claimSearchValidationResr(){
	var formObj = $("#testDataFormClaim");
	var buttonObj = formObj.find('#Reserve');
	 

	//form validation rules
	formObj.validate({
		 errorClass: "my-error-class",
	     validClass: "my-valid-class",
	     rules: {
	    	testCaseId:{
				required:true,
				maxlength:25
			},
			testCaseName:{
				required:true,
				maxlength:50
			} 
	     },
	});
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
	     
	     submitHandler: function(form) {
	    	 $("body").addClass("loading");
	    	 form.submit();
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
					maxlength:22
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
 
 function tdgDataMaskingValidation(){
		var formObj1 = $("#dataMaskingForm");
		var buttonObj = formObj1.find('.btn-cell');
		 

		//form validation rules
		formObj1.validate({
			 errorClass: "my-error-class",
		     validClass: "my-valid-class",
		     rules: {
		   		 userName:{
					required:true,
					minlength:5,
					maxlength:40
				},
				emailId:{
					required:true,
					email: true
				} ,
				deptName:{
					required:true,
					minlength:3,
				} ,
				projName:{
					required:true
				} ,
				envType:{
					required:true
				} ,
				phoneNo:{
					digits: true
			 	}
		     },
		});
	}
 
 
 function tdgDataMaskingValidationPage2(){
		var formObj1 = $("#dataMaskingForm2");
		var buttonObj = formObj1.find('.btn-cell');
		 

		//form validation rules
		formObj1.validate({
			 errorClass: "my-error-class",
		     validClass: "my-valid-class",
		     rules: {
		    	page2Q1:{
					required:true
				},
				page2Q2:{
					required:true
				} ,
				page2Q3:{
					required:true
				} ,
				page2Q4:{
					required:true
				} ,
				page2Q5:{
					required:true
				},
				page2Q6:{
					required:true
				},
				page2Q7:{
					required:true
				} ,
				page2Q8:{
					required:true
				} ,
				page2Q9:{
					required:true
				} ,
				page2Q10:{
					required:true
				},
				page2Q11:{
					required:true
				} ,
				page2Q12:{
					required:true
				}  
		     },
		});
	}
 
 
 function tdgDataMaskingValidationPage3(subset, dataRefresh, id){
		var formObj1 = $("#dataMaskingForm3");
		var buttonObj = formObj1.find('.btn-cell');
		 

		//form validation rules
		formObj1.validate({
			 errorClass: "my-error-class",
		     validClass: "my-valid-class",
		     rules: {
		    	   page3Q1:{
						required:true
					},
					page3Q2:{
						required:true
					} ,
					page3Q3:{
						required:true
					} ,
					page3Q4:{
						required:true
					} ,
					page3Q5:{
						required:true
					},
					page3Q6:{
						required:true
					},
					page3Q7:{
						required:true
					} ,
					page3Q8:{
						required:true
					} ,
					page3Q9:{
						required:true
					} ,
					page3Q10:{
						required:true
					},
				    appName:{
						required:true
					},
					dbName:{
						required:true
					},
					noOfTables:{
						required:true
					}
		     },
		     
		     submitHandler: function(form) {
		    	 if(subset =='' && dataRefresh=='')
		    		 {
		    	        confirmation_dialogYNMR('Submit','Are you sure do you want to submit ?',400,'YesNo','Yes','No','./tdmDataMaskingPage3New1?#dataMaskingForm3');
		    		 }
		    	 else
		    		 {
		    		 submitCombinedMr('./tdmDataMaskingPage3New1?#dataMaskingForm3',id);
		    		 }
				},
				invalidHandler: function(form, validator){
				
				},
				onkeyup: function(element, event){
					
				}
			    
		      
		     
		});
		
		$(".listValidator").each(function(){
			$(this).rules("add",
				{
				required:true
				}
			);
	    });
	}
 
 function tdgDataRefreshValidation(reqid){
		var formObj1 = $("#dataRefreshForm");
		var buttonObj = formObj1.find('.btn-cell');
		 
		//form validation rules
		formObj1.validate({
			 errorClass: "my-error-class",
		     validClass: "my-valid-class",
		     rules: {
		    	   pageDtRef1:{
						required:true
					},
					pageDtRef2:{
						required:true
					} ,
					pageDtRef3:{
						required:true
					}	
		     },
		     submitHandler: function(form) {
	    	        confirmation_dialogYNMR('Submit','Are you sure do you want to submit ?',400,'YesNo','Yes','No','./tdmDataRefreshingNew1?#dataRefreshForm');		    	
			},
		});
	}

 
 function tdgDataSubsettingValidation(dataRefresh, id){
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
		     submitHandler: function(form) {
		    	 if(dataRefresh=='')
		    		 {
		    	        confirmation_dialogYNMR('Submit','Are you sure do you want to submit ?',400,'YesNo','Yes','No','./tdmDataSubsettingNew1?#dataSubsettingForm');
		    		 }
		    	 else
		    		 {
		    		   submitCombinedMr('./tdmDataSubsettingNew1?#dataSubsettingForm',id);
		    		 }
				},
				invalidHandler: function(form, validator){
				
				},
				onkeyup: function(element, event){
					
				}
		});
	}
 
 function tdgDataChMgmtValidation(){
		var formObj1 = $("#dataChMgmtForm");
		var buttonObj = formObj1.find('.btn-cell');
		 
		//form validation rules
		formObj1.validate({
			 errorClass: "my-error-class",
		     validClass: "my-valid-class",
		     rules: {
		    	 pageDtChMgmt1:{
						required:true
					},
					pageDtChMgmt2:{
						required:true
					} 
		     },
		});
	}

 
 
 function clearFields(url){ 
 	window.location.href =url;
 	} 
 
 

 
 
 function tdmOnboardingReqVali(){
		var formObj1 = $("#dataOnboardReqForm");
		var buttonObj = formObj1.find('.btn-cell');
		 

		//form validation rules
		formObj1.validate({
			 errorClass: "my-error-class",
		     validClass: "my-valid-class",
		     rules: {
		    	 
		    	 userName:{
						required:true
					},
		    	 emailId:{
						required:true
					},
		    	 deptName:{
						required:true
					},
		    	 envType:{
						required:true
					},
		    	 appDesc:{
						required:true
					},
		    	 
		    	    appName:{
						required:true
					},
					dbName:{
						required:true
					},
					noOfTables:{
						required:true
					},
					chngReqCmmtnoOfTables:{
						required:true
					}
		     },
		     
		     submitHandler: function(form) {
		       confirmation_dialogYN('Submit','Are you sure do you want to submit ?',400,'YesNo','Yes','No');
		        
			},
			invalidHandler: function(form, validator){
			
			},
			onkeyup: function(element, event){
				
			}
		    
		});
		
		$(".listValidator").each(function(){
			$(this).rules("add",
				{
				required:true
				}
			);
	    });
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
 
 
 function submitPopMr(value){
	 var values = value.split('?');
	 var url = values[0];
	 var form = values[1];
	 disablePage();
	 $.ajax({
		type:'POST',
			url: url,
			dataType: 'html',	
			data: $(form).serialize(),
			success: function( data ) {
				if(data=='tdmDataSubSettingNew')
					{
				       document.location.href="./tdmDataSubSettingNew?reqId=${tdgDataMaskingDTO.id}";
					}
				else if(data=='tdmDataRefreshNew')
					{
					   document.location.href="./tdmDataRefreshNew?reqId=${tdgDataMaskingDTO.id}";
					}
				else
					{
					   confirmation_dialog('Success Message','Your Request Id : '+data+' has been submited' ,400,'Ok','','',data);
					}		
			 	
			},
			error:function(jqXHR,error, errorThrown){
		
			}
		});
 }
 
 function submitCombinedMr(value,reqId){
		var values = value.split('?');
		 var url = values[0];
		 var form = values[1]; 
		
		 disablePage();
		 $.ajax({
			type:'POST',
				url: url,
				dataType: 'html',
			    data: $(form).serialize(),
			
				success: function( data ) {
					if(data=='tdmDataSubSettingNew')
						{
						document.location.href="./tdmDataSubSettingNew?reqId="+reqId;
						}
					else if(data=='tdmDataRefreshNew')
						{
						   document.location.href="./tdmDataRefreshNew?reqId="+reqId;
						}
					else
						{
						  confirmation_dialog('Success Message','Your Request Id : '+data+' has been submited' ,400,'Ok','','',data);
						}			
				 	
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




function policySearchFormValidation(){
	var formObj = $("#policySearchForm");
	var buttonObj = formObj.find('.validClass');
	 

	//form validation rules
	formObj.validate({
		 errorClass: "my-error-class",
	     validClass: "my-valid-class",
	     rules: {
	    	envType:{
				required:true
			}, 
			testCaseId:{
				maxlength:25,
			},
			testCaseName:{
				maxlength:50,
	 		} 
	     },
	     messages: {
	    	 provZip: "Please enter no more than 5 digits."
	        },
	});
}

function claimSearchFormValidation(){
	var formObj = $("#claimSearchForm");
	var buttonObj = formObj.find('.validClass');
	 

	//form validation rules
	formObj.validate({
		 errorClass: "my-error-class",
	     validClass: "my-valid-class",
	     rules: {
	    	envType:{
				required:true
			}, 
			testCaseId:{
				maxlength:25,
			},
			testCaseName:{
				maxlength:50,
	 		} 
	     },
	     messages: {
	    	 provZip: "Please enter no more than 5 digits."
	        },
	});
}


function policyAutoSearchValidation(){
	var formObj = $("#testDataForm");
	var buttonObj = formObj.find('.validClass');
	 

	//form validation rules
	formObj.validate({
		 errorClass: "my-error-class",
	     validClass: "my-valid-class",
	     rules: {
	    	noOfDrivers:{
	    			number:true 
			 
				},
			noOfVehi:{
					number:true 
				},
			noOfNamedInsu:{
					number:true 
				}, 
			noOfViola:{
					number:true 
				}, 
			testCaseId:{
				maxlength:25,
			},
			testCaseName:{
				maxlength:50,
	 		} 
	     },
	     messages: {
	    	 noOfDrivers: "Please enter valid digit(s).",
	    	 noOfVehi: "Please enter valid digit(s).",
	    	 noOfNamedInsu: "Please enter valid digit(s).",
	    	 noOfViola: "Please enter valid digit(s)."
	        },
	});
}

function policyPropSearchValidation(){
	var formObj = $("#testDataForm");
	var buttonObj = formObj.find('.validClass');
	 

	//form validation rules
	formObj.validate({
		 errorClass: "my-error-class",
	     validClass: "my-valid-class",
	     rules: {
	    	 addYearBuilt:{
	    			number:true,
	    			min: 1920
			},
			zipCode:{
					number:true 
			},
			tin:{
					number:true,
					maxlength:9
			}, 
			testCaseId:{
				maxlength:25,
			},
			testCaseName:{
				maxlength:50,
	 		},
	 		addPayReq:{
				mailength:0,
	 		}
	     },
	     
	     submitHandler: function(form) {
	    	 $("body").addClass("loading");
	    	 form.submit();
	     },
	     messages: {
	    	 addYearBuilt: "Please enter valid year. (Ex.: 1920 onwords)",
	    	 zipCode: "Please enter valid zipcode.",
	    	 addPayReq: "The functionality on Associated Payment is currently awaited for PAS to be updated to the latest version."
	        },
	});
}


function toggle3(showHideDiv,values) {

	var ele = document.getElementById(showHideDiv);
	if(values == "N"){
    		//ele.style.display = "none";
  	 }
	else {
		//ele.style.display = "table-row-group";
	}
}