function menu_highlight(targetItem){
	var targetItemObj= $('#'+targetItem);
	targetItemObj.addClass('active');
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


function toggle3(showHideDiv,values) {

	var ele = document.getElementById(showHideDiv);
	if(values == "N"){
    		//ele.style.display = "none";
  	 }
	else {
		//ele.style.display = "table-row-group";
	}
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
 
 
 
 
 
 
 function loginValidation1(){
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
				} 
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
					digits: true,
					phoneUS: true
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
		     messages: {
		    	 addYearBuilt: "Please enter valid year. (Ex.: 1920 onwords)",
		    	 zipCode: "Please enter valid zipcode.",
		    	 addPayReq: "The functionality on Associated Payment is currently awaited for PAS to be updated to the latest version."
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
 
