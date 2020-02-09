
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
	return this;
}

function popup(popURL,title,pop,overlay,w,append){
	$.ajax({
		url:popURL+'?result='+append,
		dataType:'html',
		data:'',
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

function popupuser(popURL,title,pop,overlay,w){
	$.ajax({
		url:popURL,
		dataType:'html',
		data:'',
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


function popupPass(popURL,title,pop,overlay,w){
	
	console.log('popURL',popURL);
	$.ajax({
		url:popURL,
		dataType:'html',
		data:'',
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
			console.log("Error: ",errorThrown);
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