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
	     messages: {
	    	 provZip: "Please enter no more than 5 digits."
	        },
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
	   	
	    	 memCat:{
				required:true
			},
			subscRelation:{
				required:true
			},
			provState:{
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
					maxlength:12
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
 
 
 function tdgDataMaskingValidationPage3(){
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
		    	 confirmation_dialogYNMR('Submit','Are you sure do u want to submit ?',400,'YesNo','Yes','No');
			        
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
 
 function tdgDataRefreshValidation(){
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
 
 
function submitPopMr(){
	 
	 disablePage();
	 $.ajax({
		type:'POST',
			url: "./tdmDataMaskingPage3",
			dataType: 'html',
		data: $("#dataMaskingForm3").serialize(),
		
			success: function( data ) {
				confirmation_dialog('Success Message','Your Request Id : '+data+' has been submited' ,400,'Ok','','');
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
			invalidHandler: function(form, validator){
			
			},
			onkeyup: function(element, event){
				
			}
	});
	 
}
 