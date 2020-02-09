var str='';
str+= '<!-- Popup Starts -->';
str+= '<div id="popupOverlay" class="popupOverlay"></div>';
str+= '<div id="popup" class="popup">';
str+= '	<div class="hdr clearfix"><span id="popTitle" class="fLft">Title goes here</span><div class="fRght"><a href="javascript:;" class="sprite icon-close" onclick="hidePopup(\'popup\',\'popupOverlay\')">Close</a></div></div>';
str+= '	<div id="popup_content" class="cont"></div>';
str+= '</div>';
str+= '<!-- Popup Ends -->';
str+= '<!-- Popup within Popup Starts -->';
str+= '<div id="popupWithinPop_overlay" class="popupWithinPop_overlay"></div>';
str+= '<div id="popupWithinPop" class="popup popupWithinPop">';
str+= '	<div class="hdr clearfix"><span id="popupWithinPop_title" class="fLft">Title goes here</span><div class="fRght"><a href="javascript:;" class="sprite icon-close" onclick="hidePopup(\'popupWithinPop\',\'popupWithinPop_overlay\')">Close</a></div></div>';
str+= '	<div id="popupWithinPop_content" class="cont"></div>';
str+= '</div>';
str+= '<!-- Popup within Popup Ends -->';
str+= '<!-- ToolTip Starts -->';
str+= '<div class="toolTip" id="infoTip">';
str+= '	<div class="innerWrap">';
str+= '		<div id="content"></div>';
str+= '	</div>';
str+= '	<div class="sprite topPointer"></div>';
str+= '</div>';
str+= '<!-- ToolTip Ends -->';
str+= '<!-- Confirmation Within Popup Starts -->';
str+= '<div id="confmWithinPop_overlay" class="confmWithinPop_overlay"></div>';
str+= '<div id="confmWithinPop" class="popup confmWithinPop">';
str+= '	<div class="hdr clearfix"><span id="confmWithinPop_title" class="fLft">Title goes here</span><div class="fRght"><a href="javascript:;" class="sprite icon-close" onclick="hidePopup(\'confmWithinPop\',\'confmWithinPop_overlay\')">Close</a></div></div>';
str+= '	<div id="confmWithinPop_content" class="cont"></div>';
str+= '</div>';
str+= '<!-- Confirmation Within Popup Ends -->';
str+= '<!-- Data Loader Starts -->';
str+= '<div id="dataLoader_overlay"></div>';
str+= '<div id="dataLoader"></div>';
str+= '<!-- Data Loader Ends -->';




document.write(str);

 
 
/*
updateSessionInfo();
*/