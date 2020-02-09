
/* POP-UP code starts */
$.fn.center = function (){
	var intH = 0;
	if(typeof window.innerWidth == 'number' ){
		intH = window.innerHeight;
	}else if(document.documentElement && (document.documentElement.clientWidth || document.documentElement.clientHeight)){
		intH = document.documentElement.clientHeight;
	}else if(document.body && (document.body.clientWidth || document.body.clientHeight)){
		intH = document.body.clientHeight;
	}
	intH2=parseInt(intH);
	this.css("top", (intH2 - this.outerHeight()) / 2 + "px");
	this.css("left", Math.max(0, (($(window).width() - this.outerWidth()) / 2) + $(window).scrollLeft()) + "px");
	//console.log('css is :: ',this.css);
	return this;
}


function popupuser(popURL,title,pop,overlay,w){
	$.ajax({
		url:popURL,
		dataType:'html',
		data:'',
		async: true,
		success:function(resp){
			var objPop=$("#"+pop),objOverLay=$("#"+overlay);
			$('#'+pop+"_content").html(resp);
			if(objPop.find('#popTitle').length){
				$('#popTitle').html(title);
			}
			else{
				$('#'+pop+'_title').html(title);
			}
			var popW= (w)? w : 500;
			objPop.css({'width': popW+'px'})
			objPop.center().show();
			objOverLay.show();
		},
		error:function(jqXHR,error, errorThrown){
			//console.log("Error: ",errorThrown);
		}
	});
}


function popup(popURL,title,pop,overlay,w){
	console.log('url',popURL);
	$.ajax({
		url:popURL,
		dataType:'html',
		data:'',
		async: true,
		success:function(resp){
			var objPop=$("#"+pop),objOverLay=$("#"+overlay);
			$('#'+pop+"_content").html(resp);
			if(objPop.find('#popTitle').length){
				$('#popTitle').html(title);
			}
			else{
				$('#'+pop+'_title').html(title);
			}
			var popW= (w)? w : 500;
			objPop.css({'width': popW+'px'})
			objPop.center().show();
			objOverLay.show();
		},
		error:function(jqXHR,error, errorThrown){
			//console.log("Error: ",errorThrown);
		}
	});
}

function resizePopup(popId){
	var objPop = $('#'+popId);
	objPop.center().show();	
}

// Data Loader Starts
function dataLoader(msg){
	var objLoader=$("#dataLoader"),objOverLay=$("#dataLoader_overlay");
	var _msg = "Please wait...";
	if(msg){
		_msg = msg;
	}
	objLoader.html(_msg).center().show();
	objOverLay.show();
}
// Data Loader Ends

// Hide Data Loader Starts
function hideDataLoader(){
	var objLoader=$("#dataLoader"),objOverLay=$("#dataLoader_overlay");
	objLoader.html('').hide();
	objOverLay.hide();
}
// Hide Data Loader Ends

function hidePopup(pop,overlay){
	var objPop=$("#"+pop),objOverLay=$("#"+overlay);
	objPop.center().hide();
	objOverLay.hide();
	var objPopContent = $('#'+pop+"_content");
	
	if(objPopContent.find('iframe').length){
		objPopContent.find('iframe').remove();
	}
	objPopContent.html('');
}
/* POP-UP code ends */


//Left Nav Highlight function
function leftNav_highlight(targetItem,parentLI){
	var targetItemObj= $('#'+targetItem);
	var parentLIobj= $('#'+parentLI);
	targetItemObj.addClass('active');
	if (parentLIobj){
		parentLIobj.addClass('active');
	}
}
//Left Nav Highlight function
function menu_highlight(targetItem){
	var targetItemObj= $('#'+targetItem);
	targetItemObj.addClass('active');
}

/* *********************************************************/

//Generic Add row and delete row implementation starts
function addNewRowItem(target,mandateField,nested,serURL,delFromDBLnk,delItemType,noOfRecAllowed,targetContnr,delFromDB_YN){
	var targetCls = target ? target : 'addRow' ;
	$("tbody").delegate("."+targetCls,"click",
		function(){
			var targetContnr = $(this).parents('tbody').attr('class');
			var delRow = 'delRow_'+targetContnr;
			var el = $(this);
			var countrField = el.attr('id')+"_hidden";
			var td_txtbox = el.parent().parent().find('td').find('input[type="text"],input[type="file"],input[type="button"],input[type="submit"],textarea,select');
			var td_dateTxtbox = el.parent().parent().find('td').find('input[type="text"].datepicker,input[type="text"].pastDatepicker,input[type="text"].futureDatepicker,input[type="text"].startDatepicker,input[type="text"].endDatepicker,input[type="text"].birthDatepicker,input[type="text"].monthpicker');
			var td_rdo = el.parent().parent().find('td').find('input[type="radio"]');
			var td_hiddenbox = el.parent().parent().find('td').find('input[type="hidden"]');
			var txtbx_countr = 0;
			var txtbx_array;
			var txtbx_arrayLen = 0;
			if (mandateField){
				txtbx_array = el.parent().parent().find('td').find('input[type="text"]:visible,input[type="file"]:visible,input[type="button"]:visible,input[type="submit"]:visible,textarea:visible,select:visible').filter('.'+mandateField);
				txtbx_arrayLen = (txtbx_array.length == 1) ? 1 : ((txtbx_array.length == 2) ? 2 : txtbx_array.length);
				$.each(txtbx_array,function(i,txtbx){
					if ($.trim($(txtbx).val()) !=''){
						txtbx_countr+=1;
					}
					$(txtbx).bind('focus',function(){
						$(this).removeClass('errorClass');
					});
				});
			}
			if (txtbx_arrayLen == txtbx_countr){
				var jsCountr = 0;
				jsCountr = ($('#'+countrField).val()) ? parseInt($('#'+countrField).val()) : jsCountr;

				jsCountr+=1;

				var noOfAddedRows = el.closest('tbody.'+targetContnr).find("tr:visible").length;

				if(noOfRecAllowed != noOfAddedRows){

					// Destroy existing datepicker
					if (td_dateTxtbox) td_dateTxtbox.datepicker('destroy');

					// Destroy existing placeholder
					//td_txtbox.placeholder('destroy');

					// Destroy existing autocomplete
					if ($(td_txtbox[0]).data('uiAutocomplete')) {
						$(td_txtbox[0]).autocomplete("destroy");
					}

					el.closest('tr').clone(true).insertAfter(el.closest('tbody.'+targetContnr).find('tr:last'));
					// Clear error message after adding a row
					if (td_txtbox.parent().find('label.error')){
						td_txtbox.removeClass('errorClass');
						td_txtbox.parent().find('label.error').remove();
					}	
					
					// Original Row Manupulation
					var originalRow = el.closest('tbody.'+targetContnr).find('tr:last').closest('tr');
					var orgRow_td_txtbox = originalRow.find('td').find('input[type="text"],input[type="file"],input[type="button"],input[type="submit"],textarea,select');
					var orgRow_td_dateTxtbox = originalRow.find('td').find('input[type="text"].datepicker,input[type="text"].pastDatepicker,input[type="text"].futureDatepicker,input[type="text"].startDatepicker,input[type="text"].endDatepicker,input[type="text"].birthDatepicker,input[type="text"].monthpicker');
					var orgRow_td_rdo = originalRow.find('td').find('input[type="radio"]');
					var orgRow_td_hiddenbox = originalRow.find('td').find('input[type="hidden"]');
										
					$.each(orgRow_td_txtbox,function(i,txtbx){
						var id = $(txtbx).attr('id').split('.');
						var newID = id[0].split('[');
						var txtbxId = newID[0]+'['+jsCountr+'].'+id[1];
						$(txtbx).removeAttr('name id').attr({'name':txtbxId,'id':txtbxId});
					});

					$.each(orgRow_td_hiddenbox,function(i,txtbxhidden){
						var id = $(txtbxhidden).attr('id').split('.');
						var newID = id[0].split('[');
						var txtbxId = newID[0]+'['+jsCountr+'].'+id[1];
						$(txtbxhidden).removeAttr('name id').attr({'name':txtbxId,'id':txtbxId});
					});

					$.each(orgRow_td_dateTxtbox,function(i,date){
						var id = $(date).attr('id').split('.');
						var newID = id[0].split('[');
						var txtbxId = newID[0]+'['+jsCountr+'].'+id[1];
						$(date).attr({'name':txtbxId,'id':txtbxId});
					});
					orgRow_td_txtbox.filter('input:not(:button)').val('');
					originalRow.find('td').find('label.item').html('');
					// Ends
					
					el.removeClass(targetCls+' icon-add mRght20').addClass(delRow+' mRght5 icon-delete').off('click');
					el.html('Delete');

					if(td_rdo.length){
						td_rdo.removeAttr('name checked').prop({'name':'radio_other_'+targetContnr+'_'+jsCountr});
						el.parent().parent().find('td').find('input[type="radio"]:eq(1)').click();
					}

				 

					if (countrField){
						$('#'+countrField).val(jsCountr);
					}
				}
				else{
					confirmation_dialog1('Alert','Only '+noOfRecAllowed+' rows are allowed','400','Ok');
				}
			}
			else{
				if(nested == 'nested') confirmation_dialogWithinPop(messages.promtMsg.addRow_msg.title,messages.promtMsg.addRow_msg.bodytext,'400','Ok');
				else confirmation_dialog1(messages.promtMsg.addRow_msg.title,messages.promtMsg.addRow_msg.bodytext,'400','Ok');

				if (txtbx_array){
					$.each(txtbx_array,function(i,txtbx){
						if ($.trim($(txtbx).val()) ==''){
							$(txtbx).addClass('errorClass');
						}
					});
				}
			}
			$('tbody.'+targetContnr).delegate('.'+delRow,'click',function(){
				var objDelete = $(this).parent().parent();
				if(nested == 'nested'){
					confirmation_dialogWithinPop(messages.promtMsg.txt_delete.title,messages.promtMsg.txt_delete.bodytext,'400','YesNo');
					confmWithinPop_deleteItem(objDelete);
				}
				else{
					confirmation_dialog1(messages.promtMsg.txt_delete.title,messages.promtMsg.txt_delete.bodytext,'400','YesNo');
					itemDeleteAction(objDelete);
				}
			});
			$('#smgBtn_ok').bind('click',function(){
				hidePopup('popup','popupOverlay');
			});
			$(window).trigger('addRowTrigger',[targetContnr]);
		});
		initDBDeleteRow(serURL,delFromDBLnk,delItemType,nested,targetContnr,delFromDB_YN);
}

function initDBDeleteRow(serverUrl,delFromDBLnk,delItemType,nested,targetContnr,delFromDB_YN) {
	$("tbody").delegate('.'+delFromDBLnk,'click',function(){
		var objDelete = $(this).closest('tr');

		if(nested=="nested"){
			confirmation_dialogWithinPop(messages.promtMsg.txt_delete.title,messages.promtMsg.txt_delete.bodytext,'400','YesNo');
		}
		else{
			confirmation_dialog1(messages.promtMsg.txt_delete.title,messages.promtMsg.txt_delete.bodytext,'400','YesNo');
		}
		deleteRowItem_fromDatabase(objDelete,serverUrl,delItemType,nested,targetContnr,delFromDB_YN);
	});
}

function deleteRowItem_fromDatabase(deleteObj,serverUrl,delItemType,nested,targetContnr,delFromDB_YN){
	var btnAction = $('#btn_action');
	if (nested=="nested"){
		btnAction = $('#btnAction_nestedConfm');
	}

	btnAction.bind('click',function(){
		var curRowId = $(deleteObj).attr('id');
		if(delFromDB_YN){
			if ((delFromDB_YN).toLowerCase() =='yes' || (delFromDB_YN).toLowerCase() =='y'){
				deleteObj.remove();
				hidePopup('popup','popupOverlay');
				$(window).trigger('deleteRowTrigger');
			}
		}
		else{
			$.ajaxSetup({cache:false});
			$.ajax({
				url: serverUrl + '?id='+curRowId+'&itemType='+delItemType,
				//dataType: 'json',
				success:function(serverResp)
				{
					var serverRespSplit = serverResp=='true' || serverResp == true ? serverResp : serverResp.split('?');

					if ((serverResp == 'true' || serverResp == true)){

					}

					if ((serverResp == 'true' || serverResp == true) || (serverRespSplit[1] && serverRespSplit[0]== 'true'))
					{
						deleteObj.remove();
						$(window).trigger('deleteRowTrigger');

						if(nested=="nested"){
							confirmation_dialogWithinPop('Alert',"Data deleted successfully.",'400','Ok');
						}
						else{
							confirmation_dialog1('Alert',"Data deleted successfully.",'400','Ok');
							$('#smgBtn_ok').bind('click',function(){
								hidePopup('popup','popupOverlay');
							});
						}
						if(delItemType =="PCG"){
							afetrDeleteFromPopup();
						}

						if(targetContnr){
							$("#"+targetContnr).html('');
							$("#"+targetContnr).append(serverRespSplit[1]);
						}
					}
					else
					{
						if(curRowId=='0000'){

							deleteObj.remove();
							$(window).trigger('deleteRowTrigger');

							if(nested=="nested"){
								confirmation_dialogWithinPop('Alert',"Data deleted successfully.",'400','Ok');
							}
							else{
								confirmation_dialog1('Alert',"Data deleted successfully.",'400','Ok');
								$('#smgBtn_ok').bind('click',function(){
									hidePopup('popup','popupOverlay');
								});
							}
							if(delItemType =="PCG"){
								afetrDeleteFromPopup();
							}

							if(targetContnr){
								$("#"+targetContnr).html('');
								$("#"+targetContnr).append(serverRespSplit[1]);
							}

						}
						else{
							if(nested=="nested") {
								confirmation_dialogWithinPop('Error',"Data deletion failed.",'400','Ok');
							}
							else{
								confirmation_dialog1('Error',"Data deletion failed.",'400','Ok');
							}
							$('#smgBtn_ok').bind('click',function(){
								hidePopup('popup','popupOverlay');
							});
						}

					}
				},
				error: function(jqXHR, serverResp, errorThrown)
				{
					if(nested=="nested") {
						confirmation_dialogWithinPop('Error',"Data deletion failed. System Error occurred. Please re-try after some time.",'400','Ok');
					}
					else{
						confirmation_dialog1('Error',"Data deletion failed. System Error occurred. Please re-try after some time.",'400','Ok');
					}
					$('#smgBtn_ok').bind('click',function(){
						hidePopup('popup','popupOverlay');
					});
				}
			});
		}
	});
}
//Generic Add row and delete row implementation ends

function confirmation_dialog1(title,msg,w,popType,caption1,caption2,data){
	var objPop = $("#popup"), popTitle = $('#popTitle'), objOverLay = $("#popupOverlay"), objContnt = $("#popup_content");
	var popW= (w)? w : 500;

	objContnt.html('');
	popTitle.html(title);
	objContnt.html(msg);
	objPop.css({'width': popW+'px'});

	if (popType == 'OkCancel'){
		objContnt.append('<div class="popup_button"><input type="button" value="OK" class="mRght5" /><input type="button" value="Cancel" onclick="hidePopup(\'popup\',\'popupOverlay\')"/></div>');
	}
	else if (popType == 'YesNo'){
		var yesCaption = 'Yes';
		var noCaption = 'No';
		if (caption1 != null && caption1 != undefined && caption1 != '') {
			yesCaption = caption1;
		}
		if (caption2 != null && caption2 != undefined && caption2 != '') {
			noCaption = caption2;
		}
		objContnt.append('<div class="ynpopup_button buttonsAll8"><input type="button" value="'+yesCaption+'" id="btn_action" class="mRght5" /><input type="button" value="'+noCaption+'" onclick="hidePopup(\'popup\',\'popupOverlay\')"/></div>');
	}
	else if (popType == 'Ok'){
		objContnt.append('<div class="popup_button buttonsAll8"><input type="button" value="OK" id="smgBtn_ok" onclick="hidePopup(\'popup\',\'popupOverlay\');"/></div>');
 
	}
	 
	// Don't change button id "btn_action". Event is bind with this id
	objPop.center().show();
	objOverLay.show();
	
	
}


function confirmation_dialog(title,msg,w,popType,caption1,caption2,data){
	var objPop = $("#popup"), popTitle = $('#popTitle'), objOverLay = $("#popupOverlay"), objContnt = $("#popup_content");
	var popW= (w)? w : 500;

	objContnt.html('');
	popTitle.html(title);
	objContnt.html(msg);
	objPop.css({'width': popW+'px'});

	if (popType == 'OkCancel'){
		objContnt.append('<div class="popup_button"><input type="button" value="OK" class="mRght5" /><input type="button" value="Cancel" onclick="hidePopup(\'popup\',\'popupOverlay\')"/></div>');
	}
	else if (popType == 'YesNo'){
		var yesCaption = 'Yes';
		var noCaption = 'No';
		if (caption1 != null && caption1 != undefined && caption1 != '') {
			yesCaption = caption1;
		}
		if (caption2 != null && caption2 != undefined && caption2 != '') {
			noCaption = caption2;
		}
		objContnt.append('<div class="ynpopup_button buttonsAll8"><input type="button" value="'+yesCaption+'" id="btn_action" class="mRght5" /><input type="button" value="'+noCaption+'" onclick="hidePopup(\'popup\',\'popupOverlay\')"/></div>');
	}
	else if (popType == 'Ok'){
		objContnt.append('<div class="popup_button buttonsAll8"><input type="button" value="OK" name="'+data+'" id="smgBtn_ok" onclick="hidePopup(\'popup\',\'popupOverlay\');redirctMRboard(this);"/></div>');
 
	}
	 
	// Don't change button id "btn_action". Event is bind with this id
	objPop.center().show();
	objOverLay.show();
	
	
}

function redirctMRboard(btn){
	if(0 <= btn.name.indexOf("CR")){
		window.location= "./tdmDtMaskDashBoardCR";
	}else{
		window.location= "./tdmDtMaskDashboard";
	}
}


function itemDeleteAction(deleteObj){
	$('#btn_action').bind('click',function(){
		deleteObj.remove();
		hidePopup('popup','popupOverlay');
		$(window).trigger('deleteRowTrigger');
	});
}





function confirmation_dialogYN(title,msg,w,popType,caption1,caption2){
	var objPop = $("#popup"), popTitle = $('#popTitle'), objOverLay = $("#popupOverlay"), objContnt = $("#popup_content");
	var popW= (w)? w : 500;

	objContnt.html('');
	popTitle.html(title);
	objContnt.html(msg);
	objPop.css({'width': popW+'px'});

	if (popType == 'YesNo'){
		var yesCaption = 'Yes';
		var noCaption = 'No';
		if (caption1 != null && caption1 != undefined && caption1 != '') {
			yesCaption = caption1;
		}
		if (caption2 != null && caption2 != undefined && caption2 != '') {
			noCaption = caption2;
		}
		objContnt.append('<div class="ynpopup_button buttonsAll8"><input type="button" value="'+yesCaption+'" id="btn_action" class="mRght5" onclick="submitPop();"/><input type="button" value="'+noCaption+'" onclick="hidePopup(\'popup\',\'popupOverlay\')"/></div>');
	}
	 
	// Don't change button id "btn_action". Event is bind with this id
	objPop.center().show();
	objOverLay.show();
	
}

function confirmation_dialogYNMR(title,msg,w,popType,caption1,caption2){
	var objPop = $("#popup"), popTitle = $('#popTitle'), objOverLay = $("#popupOverlay"), objContnt = $("#popup_content");
	var popW= (w)? w : 500;

	objContnt.html('');
	popTitle.html(title);
	objContnt.html(msg);
	objPop.css({'width': popW+'px'});

	if (popType == 'YesNo'){
		var yesCaption = 'Yes';
		var noCaption = 'No';
		if (caption1 != null && caption1 != undefined && caption1 != '') {
			yesCaption = caption1;
		}
		if (caption2 != null && caption2 != undefined && caption2 != '') {
			noCaption = caption2;
		}
		objContnt.append('<div class="ynpopup_button buttonsAll8"><input type="button" value="'+yesCaption+'" id="btn_action" class="mRght5" onclick="submitPopMr();"/><input type="button" value="'+noCaption+'" onclick="hidePopup(\'popup\',\'popupOverlay\')"/></div>');
	}
	 
	// Don't change button id "btn_action". Event is bind with this id
	objPop.center().show();
	objOverLay.show();
	
}


function confirmationFotCancel(title,msg,w,popType,caption1,caption2,id){
	var objPop = $("#popup"), popTitle = $('#popTitle'), objOverLay = $("#popupOverlay"), objContnt = $("#popup_content");
	var popW= (w)? w : 500;

	objContnt.html('');
	popTitle.html(title);
	objContnt.html(msg);
	objPop.css({'width': popW+'px'});

	if (popType == 'YesNo'){
		var yesCaption = 'Yes';
		var noCaption = 'No';
		if (caption1 != null && caption1 != undefined && caption1 != '') {
			yesCaption = caption1;
		}
		if (caption2 != null && caption2 != undefined && caption2 != '') {
			noCaption = caption2;
		}
		objContnt.append('<div class="ynpopup_button buttonsAll8"><input type="button" value="'+yesCaption+'" id="btn_action" name="'+id+'" class="mRght5" onclick="submitPopCancel(this);"/><input type="button" value="'+noCaption+'" onclick="hidePopup(\'popup\',\'popupOverlay\')"/></div>');
	}
	 
	// Don't change button id "btn_action". Event is bind with this id
	objPop.center().show();
	objOverLay.show();
	
}



//888888888888888888888888888888888888

function disabledRefresh_backspace(){
	$(document).bind('keydown',function(event){
		var inputFields = $(document.activeElement).is("input:focus, textarea:focus");
		switch (event.keyCode){
			case 112 : //F1 button
				event.returnValue = false;
				event.keyCode = 0;
				if (!("onhelp" in window)) {
					var mapID = $('#helpID').val();
					if ($('#popup').is(':visible')) {
						mapID = $('#popup').find('input#helpID').val();;
					}
					if (mapID != null && mapID != 'null' && mapID != undefined && mapID != '' && mapID != false && mapID != 'false') {
						openHelp(mapID);
					}
				}
				return false;
			case 116 : //F5 button
				event.returnValue = false;
				event.keyCode = 0;
				return false;
				
			case 117 : //F6 button
				event.returnValue = false;
				event.keyCode = 0;
				return false;
				
			case 82 : //R button
				if (event.ctrlKey){
					event.returnValue = false;
					event.keyCode = 0;
					return false;
				}
			case 8 : //Backspace
				if(!inputFields){
					event.returnValue = false;
					event.keyCode = 0;
					return false;
				}
		}
	});
}
// It disables Ctrl, Alt and Shift Keys
function disableKeys(){
	$('a').bind('click',function(e){
		if(e.ctrlKey || e.altKey || e.shiftKey){
			return false;
		}
	});
}



function clearSession(){
	$.ajax({
		url: "",
		success: function( data ) {

			window.close();
			window.location.href = './login';
		},
		error:function(jqXHR,error, errorThrown){
	
		}
	});
}

function logout(){

	clearSession();

}




function disablePage() {
	$('div.container input[type="radio"]').attr('disabled','disabled');
	disablePageExceptRadioBtn();
}

function disablePageExceptRadioBtn() {
	$('div.container input[type="text"]:not(".datepicker"),div.container textarea').attr("readonly","readonly");
	$('div.container input[type="checkbox"],div.container select').attr('disabled','disabled');
	 

	//Search Criteria related controls in all list pages should always be enabled.
	//enableListPageSearchCriteria();
}