var messages={
	tooltip:{
		MOA:{
			title: "abc",
			bodytext: "Memorandum Of Association"
		},
		AOA:{
			title: "abc",
			bodytext: "Articles Of Association"
		},
		COI:{
			title: "abc",
			bodytext: "Certificate Of Incorporation"
		},
		COCB:{
			title: "abc",
			bodytext: "Certificate Of Commencement of Business"
		},
		POA:{
			title: "abc",
			bodytext: "Power Of Attorney"
		},
		MAT:{
			title: "abc",
			bodytext: "Minimum Alternate Tax"
		},
		COD:{
			title: "abc",
			bodytext: "Commercial Operations Date"
		},
		DIN:{
			title: "abc",
			bodytext: "Director Identification Number"
		},
		saveAsDraft:{
			title: "abc",
			bodytext: "It allows you to save the data without validating the mandatory fields."
		},
		effectiveRate:{
			title: "Effective Rate",
			bodytext: "Effective Rate = Base Rate + Spread + Revised Tenor Premium."
		},
		pwdPolicy:{
			title: "Password Policy",
			bodytext: "<div style='width:400px'>Seshadri's password policy is as under:<br/><ol class=\"orderList\"><li>Passwords shall have a minimum length of 8 characters.</li><li>Strong passwords having a combination of One Alphabet, One Numeral and one special characters should be used.</li><li>The system should force a new user to change the password at first logon and on reset of password.</li><li>Password history should be maintained.</li><li>Passwords should be masked while keying-in.</li><li>On change of password, it should be entered twice to confirm the correctness of password and to prevent from being locked out of the system.</li></ol></div>"
		},
		withRM:{
			title: "abc",
			bodytext: "<b>With RM</b> | This document is with RM for verification."
		},
		inProgress:{
			title: "abc",
			bodytext: "<b>In Progress</b> | More information is required to complete this row item."
		},
		inProgressReport:{
			title: "title",
			bodytext: "<b>In Progress</b> | More information is required to complete the report."
		},
		completed:{
			title: "abc",
			bodytext: "<b>Completed</b> | Required information is filled. You can still modify if required."
		},
		completedNoModi:{
			title: "title",
			bodytext: "<b>Completed</b> | Modification not allowed."
		},
		inputDefroze:{
			title: "abc",
			bodytext: "You are modifying past data. Modifying this will create new revision."
		},
		highlightTxt:{
			title: "abc",
			bodytext: "Data in this column is modified and this label shows the current revision of the data."
		},
		sourcePromoFund:{
			title: "abc",
			bodytext: "<div style='width:300px'>Sources of Promoter's funds to be specified ,e.g details of assets , investments to be liquidated; incase of investments from Associates - thier Cash Accruals to be examined over the project implementation period with reference to past performance, current trends, debt servicing requirements / CAPEX , cash flow comfort and other requirements</div>"
		},
		internalAccu:{
			title: "abc",
			bodytext: "<div style='width:300px'>Internal accurals : (Details relating to availability/ adequacy of surplus to be commented upon)</div>"
		},
		cics:{
			title: "abc",
			bodytext: "<div style='width:300px'>Credit Information Companies</div>"
		},
		EpcAssessment:{
			title:"abc",
			bodytext:"<div style='width:300px'>In case of EPC Contractors/  Construction industry detailed assessment in respect of Guarantees issued for  Bid bond, Mobilization, <br/>Performance, Retention, Other BGs be provided</div>"
		},
		SundryCreditorHelp:{
			title:"Sundry Creditor Help",
			bodytext:"Total of <em>Sundry Creditors Import</em> and <em>Sundry Creditors Domestic</em><br/>should be equal to total of <em>Sundry Creditors (Trade-Without LC)</em><br/>and <em>Sundry Creditors (Trade-Under LC)</em>."
		},
		tmpltAmt:{
			title:"Amount",
			bodytext:"[Amount] This field is required. Max 6 digits & 2 decimals allowed."
		},
		tmpltYr:{
			title:"Year",
			bodytext:"[Year] This field is required. Max 2 digits & 2 decimals allowed."
		},
		tmpltMnth:{
			title:"Month",
			bodytext:"[Month] This field is required. Max 2 digits allowed."
		},
		tmpltDay:{
			title:"Day",
			bodytext:"[Day] This field is required. Max 3 digits allowed."
		},
		tmpltSlct:{
			title:"Select",
			bodytext:"[Select] Please select an option."
		},
		tmpltMultiSlct:{
			title:"Multi Select",
			bodytext:"[Multi Select] Please select one or more options."
		},
		tmpltRequired50:{
			title:"Required Field",
			bodytext:"[Required Field] This field is required. Max 50 characters allowed."
		},
		tmpltRating:{
			title:"Rating",
			bodytext:"[Rating] This field is required. Max 8 characters allowed."
		},
		tmpltIntrnlRating:{
			title:"Internal Rating",
			bodytext:"[Internal Rating] This field is required. Max 2 digits & 0 decimals allowed."
		},
		tmpltRatio:{
			title:"Ratio",
			bodytext:"[Ratio] This field is required. Max 2 digits & 2 decimals allowed."
		},
		tmpltScore:{
			title:"Score",
			bodytext:"[Score] This field is required. Max 2 digits & 2 decimals allowed."
		},
		tmpltPurpose:{
			title:"Purpose",
			bodytext:"[Purpose] This field is required. Max 100 characters allowed."
		},
		tmpltPrcnt:{
			title:"Percentage",
			bodytext:"[Percentage] This field is required. Max 2 digits & 2 decimals allowed."
		},
		tmpltDate:{
			title:"Date",
			bodytext:"[Date] This field is required. Please enter correct date."
		},
		tmpltUnit:{
			title:"Unit",
			bodytext:"[Unit] This field is required. Max 3 digits allowed."
		},
		requiredRdoFld:{
			title:"Required Field",
			bodytext:"[Required Field] This field is required. Select a radio button"
		}
	}, //Ends ToolTip
	response: {
		forgotPwdFail: {
			title: "Forgot Password",
			bodytext: "Your 'User ID' and 'Date of Birth' does not match."
		},
		forgotPwdSuccess: {
			title: "Forgot Password",
			bodytext: "Your password has been reset and sent to your registered email ID."
		},
		changePwdFail_oldPwd: {
			title: "Change Password",
			bodytext: "Your Old Password is incorrect. or New Password does not match."
		},
		changePwdFail_newPwd: {
			title: "Change Password",
			bodytext: "New Password does not match."
		},
		changePwdFail_newPwdRule: {
			title: "Change Password",
			bodytext: "New Password does not follow password policy."
		},
		changePwdSuccess: {
			title: "Change Password",
			bodytext: "Your password has been changed."
		},
		teamHasMembers: {
			title: "Team Can Not Be Deleted",
			bodytext: "This team has members mapped to it; so it can not be deleted. Please unmap all the members from the team before deleting it."
		}
	},
	promtMsg: {
		txt_delete: {
			title: "Delete Confirmation",
			bodytext: "Are you sure you want to Delete this item?"
		},
		addRow_msg: {
			title: "Alert",
			bodytext: "Please fill the current row fields before adding a row."
		},
		addField_msg: {
			title: "Alert",
			bodytext: "Please fill the highlighted field."
		},
		error_msg: {
			title: "abc",
			bodytext: "Information is not saved. Please complete the mandatory fields before saving."
		},
		successSave_msg: {
			title: "abc",
			bodytext: "Information saved successfully."
		},
		meetingAgenda_msg: {
			title: "Please Confirm",
			bodytext: "Once Regular Item Agenda is generated you will not be able to add more regular items. Only table items can be added. Would you like to generate Regular Agenda?"
		},
		meetingTbleAgenda_msg: {
			title: "Please Confirm",
			bodytext: "Would you like to generate Table Agenda?"
		},
		nonSpecialChar: {
			title: "Alert",
			msg: "Speacial characters are not allowed & removed."
		}
	}
}