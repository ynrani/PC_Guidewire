<!DOCTYPE html>
<html> 
<head> 
   
    <!-- Caption Style -->
    <style> 
        .captionOrange, .captionBlue, .captionBlack, .captionSymbol
        {
            display: block;
            color: #fff;
            font-size: 20px;
            line-height: 30px;
            text-align: center;
            border-radius: 4px;
        }
        .captionOrange
        {
            background: #EB5100;
            background-color: #1F97CA;
        }
        .captionBlue
        {
            background: #746FBD;
            background-color: rgba(21, 21, 120, 0.6);
        }
        .captionBlack
        {
            background: #000;
            background-color: rgba(0, 0, 0, 0.4);
        }
        .captionSymbol
        {
        	border-radius: 100px !important;
        	font-weight: 400 !important;
        	font-size: 26px !important;
            background: #000;
            background-color: rgba(0, 0, 0, 0.4);
        }
        .captionTextBlack
        {
        	display: block;
        	color: #000;
        	font-size: 20px;
        	line-height: 30px;
        }
        .captionTextWhite
        {
        	display: block;
        	color: #fff;
        	font-size: 20px;
        	line-height: 30px;
        }
        a.captionOrange, a.captionOrange:active, a.captionOrange:visited,a.captionTextWhite, a.captionTextWhite:active, a.captionTextWhite:visited
        {
        	color: #fff;
        	text-decoration: none;
        }
        a.captionOrange:hover
        {
            color: #eb5100;
            text-decoration: underline;
            background-color: #eeeeee;
            background-color: rgba(238, 238, 238, 0.7);
        }
        a.captionTextBlack, a.captionTextBlack:active, a.captionTextBlack:visited
        {
        	color: #000;
        	text-decoration: none;
        }
        a.captionTextWhite:hover
        {
            color: #eb5100;
            text-decoration: underline;
        }
        a.captionTextBlack:hover
        {
            color: #eb5100;
            text-decoration: underline;
        }
        .bricon
        {
            background: url(images/browser-icons.png);
        }
    </style>
    
    <style>
         
        .tdmSeshub01 {
            position: absolute;
        }
        .tdmSeshub01 div, .tdmSeshub01 div:hover, .tdmSeshub01 .av {
            position: absolute;
            /* size of bullet elment */
            width: 12px;
            height: 12px;
            filter: alpha(opacity=70);
            opacity: .7;
            overflow: hidden;
            cursor: pointer;
            border: #000 1px solid;
        }
        .tdmSeshub01 div { background-color: gray; }
        .tdmSeshub01 div:hover, .tdmSeshub01 .av:hover { background-color: #d3d3d3; }
        .tdmSeshub01 .av { background-color: #fff; }
        .tdmSeshub01 .dn, .tdmSeshub01 .dn:hover { background-color: #555555; }
    </style>
    
    <style>
        
        .tdmSeshua05l, .tdmSeshua05r {
            display: block;
            position: absolute;
            /* size of arrow element */
            width: 40px;
            height: 40px;
            cursor: pointer;
            background: url(images/a17.png) no-repeat;
            overflow: hidden;
        }
        .tdmSeshua05l { background-position: -10px -40px; }
        .tdmSeshua05r { background-position: -70px -40px; }
        .tdmSeshua05l:hover { background-position: -130px -40px; }
        .tdmSeshua05r:hover { background-position: -190px -40px; }
        .tdmSeshua05l.tdmSeshua05ldn { background-position: -250px -40px; }
        .tdmSeshua05r.tdmSeshua05rdn { background-position: -310px -40px; }
    </style>
    
     <style>
           
        .tdmSeshua02l, .tdmSeshua02r {
            display: block;
            position: absolute;
            /* size of arrow element */
            width: 55px;
            height: 55px;
            cursor: pointer;
            background: url(images/a02.png) no-repeat;
            overflow: hidden;
        }
        .tdmSeshua02l { background-position: -3px -33px; }
        .tdmSeshua02r { background-position: -63px -33px; }
        .tdmSeshua02l:hover { background-position: -123px -33px; }
        .tdmSeshua02r:hover { background-position: -183px -33px; }
        .tdmSeshua02l.tdmSeshua02ldn { background-position: -3px -33px; }
        .tdmSeshua02r.tdmSeshua02rdn { background-position: -63px -33px; }
    </style>
</head> 
<body style="margin:0;padding:0; font-family: Calibri, Palatino"> 
    <!-- it works the same with all jquery version from 1.x to 2.x -->
   
  
    <script type="text/javascript" src="js/tdmSeshu.js"></script>
    <script type="text/javascript" src="js/tdmSeshu.slider.js"></script>
    <script>
        jQuery(document).ready(function ($) {
           

            var _SlideshowTransitions = [
                //Rotate Overlap
                { $Duration: 1200, $Zoom: 11, $Rotate: -1, $Easing: { $Zoom: $tdmSeshuEasing$.$EaseInQuad, $Opacity: $tdmSeshuEasing$.$EaseLinear, $Rotate: $tdmSeshuEasing$.$EaseInQuad }, $Opacity: 2, $Round: { $Rotate: 0.5 }, $Brother: { $Duration: 1200, $Zoom: 1, $Rotate: 1, $Easing: $tdmSeshuEasing$.$EaseSwing, $Opacity: 2, $Round: { $Rotate: 0.5 }, $Shift: 90 } },
                //Switch
                { $Duration: 1400, x: 0.25, $Zoom: 1.5, $Easing: { $Left: $tdmSeshuEasing$.$EaseInWave, $Zoom: $tdmSeshuEasing$.$EaseInSine }, $Opacity: 2, $ZIndex: -10, $Brother: { $Duration: 1400, x: -0.25, $Zoom: 1.5, $Easing: { $Left: $tdmSeshuEasing$.$EaseInWave, $Zoom: $tdmSeshuEasing$.$EaseInSine }, $Opacity: 2, $ZIndex: -10 } },
                //Rotate Relay
                { $Duration: 1200, $Zoom: 11, $Rotate: 1, $Easing: { $Opacity: $tdmSeshuEasing$.$EaseLinear, $Rotate: $tdmSeshuEasing$.$EaseInQuad }, $Opacity: 2, $Round: { $Rotate: 1 }, $ZIndex: -10, $Brother: { $Duration: 1200, $Zoom: 11, $Rotate: -1, $Easing: { $Opacity: $tdmSeshuEasing$.$EaseLinear, $Rotate: $tdmSeshuEasing$.$EaseInQuad }, $Opacity: 2, $Round: { $Rotate: 1 }, $ZIndex: -10, $Shift: 600 } },
                //Doors
                { $Duration: 1500, x: 0.5, $Cols: 2, $ChessMode: { $Column: 3 }, $Easing: { $Left: $tdmSeshuEasing$.$EaseInOutCubic }, $Opacity: 2, $Brother: { $Duration: 1500, $Opacity: 2 } },
                //Rotate in+ out-
                { $Duration: 1500, x: -0.3, y: 0.5, $Zoom: 1, $Rotate: 0.1, $During: { $Left: [0.6, 0.4], $Top: [0.6, 0.4], $Rotate: [0.6, 0.4], $Zoom: [0.6, 0.4] }, $Easing: { $Left: $tdmSeshuEasing$.$EaseInQuad, $Top: $tdmSeshuEasing$.$EaseInQuad, $Opacity: $tdmSeshuEasing$.$EaseLinear, $Rotate: $tdmSeshuEasing$.$EaseInQuad }, $Opacity: 2, $Brother: { $Duration: 1000, $Zoom: 11, $Rotate: -0.5, $Easing: { $Opacity: $tdmSeshuEasing$.$EaseLinear, $Rotate: $tdmSeshuEasing$.$EaseInQuad }, $Opacity: 2, $Shift: 200 } },
                //Fly Twins
                { $Duration: 1500, x: 0.3, $During: { $Left: [0.6, 0.4] }, $Easing: { $Left: $tdmSeshuEasing$.$EaseInQuad, $Opacity: $tdmSeshuEasing$.$EaseLinear }, $Opacity: 2, $Outside: true, $Brother: { $Duration: 1000, x: -0.3, $Easing: { $Left: $tdmSeshuEasing$.$EaseInQuad, $Opacity: $tdmSeshuEasing$.$EaseLinear }, $Opacity: 2 } },
                //Rotate in- out+
                { $Duration: 1500, $Zoom: 11, $Rotate: 0.5, $During: { $Left: [0.4, 0.6], $Top: [0.4, 0.6], $Rotate: [0.4, 0.6], $Zoom: [0.4, 0.6] }, $Easing: { $Opacity: $tdmSeshuEasing$.$EaseLinear, $Rotate: $tdmSeshuEasing$.$EaseInQuad }, $Opacity: 2, $Brother: { $Duration: 1000, $Zoom: 1, $Rotate: -0.5, $Easing: { $Opacity: $tdmSeshuEasing$.$EaseLinear, $Rotate: $tdmSeshuEasing$.$EaseInQuad }, $Opacity: 2, $Shift: 200 } },
                //Rotate Axis up overlap
                { $Duration: 1200, x: 0.25, y: 0.5, $Rotate: -0.1, $Easing: { $Left: $tdmSeshuEasing$.$EaseInQuad, $Top: $tdmSeshuEasing$.$EaseInQuad, $Opacity: $tdmSeshuEasing$.$EaseLinear, $Rotate: $tdmSeshuEasing$.$EaseInQuad }, $Opacity: 2, $Brother: { $Duration: 1200, x: -0.1, y: -0.7, $Rotate: 0.1, $Easing: { $Left: $tdmSeshuEasing$.$EaseInQuad, $Top: $tdmSeshuEasing$.$EaseInQuad, $Opacity: $tdmSeshuEasing$.$EaseLinear, $Rotate: $tdmSeshuEasing$.$EaseInQuad }, $Opacity: 2 } },
                //Chess Replace TB
                { $Duration: 1600, x: 1, $Rows: 2, $ChessMode: { $Row: 3 }, $Easing: { $Left: $tdmSeshuEasing$.$EaseInOutQuart, $Opacity: $tdmSeshuEasing$.$EaseLinear }, $Opacity: 2, $Brother: { $Duration: 1600, x: -1, $Rows: 2, $ChessMode: { $Row: 3 }, $Easing: { $Left: $tdmSeshuEasing$.$EaseInOutQuart, $Opacity: $tdmSeshuEasing$.$EaseLinear }, $Opacity: 2 } },
                //Chess Replace LR
                { $Duration: 1600, y: -1, $Cols: 2, $ChessMode: { $Column: 12 }, $Easing: { $Top: $tdmSeshuEasing$.$EaseInOutQuart, $Opacity: $tdmSeshuEasing$.$EaseLinear }, $Opacity: 2, $Brother: { $Duration: 1600, y: 1, $Cols: 2, $ChessMode: { $Column: 12 }, $Easing: { $Top: $tdmSeshuEasing$.$EaseInOutQuart, $Opacity: $tdmSeshuEasing$.$EaseLinear }, $Opacity: 2 } },
                //Shift TB
                { $Duration: 1200, y: 1, $Easing: { $Top: $tdmSeshuEasing$.$EaseInOutQuart, $Opacity: $tdmSeshuEasing$.$EaseLinear }, $Opacity: 2, $Brother: { $Duration: 1200, y: -1, $Easing: { $Top: $tdmSeshuEasing$.$EaseInOutQuart, $Opacity: $tdmSeshuEasing$.$EaseLinear }, $Opacity: 2 } },
                //Shift LR
                { $Duration: 1200, x: 1, $Easing: { $Left: $tdmSeshuEasing$.$EaseInOutQuart, $Opacity: $tdmSeshuEasing$.$EaseLinear }, $Opacity: 2, $Brother: { $Duration: 1200, x: -1, $Easing: { $Left: $tdmSeshuEasing$.$EaseInOutQuart, $Opacity: $tdmSeshuEasing$.$EaseLinear }, $Opacity: 2 } },
                //Return TB
                { $Duration: 1200, y: -1, $Easing: { $Top: $tdmSeshuEasing$.$EaseInOutQuart, $Opacity: $tdmSeshuEasing$.$EaseLinear }, $Opacity: 2, $ZIndex: -10, $Brother: { $Duration: 1200, y: -1, $Easing: { $Top: $tdmSeshuEasing$.$EaseInOutQuart, $Opacity: $tdmSeshuEasing$.$EaseLinear }, $Opacity: 2, $ZIndex: -10, $Shift: -100 } },
                //Return LR
                { $Duration: 1200, x: 1, $Delay: 40, $Cols: 6, $Formation: $tdmSeshuSlideshowFormations$.$FormationStraight, $Easing: { $Left: $tdmSeshuEasing$.$EaseInOutQuart, $Opacity: $tdmSeshuEasing$.$EaseLinear }, $Opacity: 2, $ZIndex: -10, $Brother: { $Duration: 1200, x: 1, $Delay: 40, $Cols: 6, $Formation: $tdmSeshuSlideshowFormations$.$FormationStraight, $Easing: { $Top: $tdmSeshuEasing$.$EaseInOutQuart, $Opacity: $tdmSeshuEasing$.$EaseLinear }, $Opacity: 2, $ZIndex: -10, $Shift: -100 } },
                //Rotate Axis down
                { $Duration: 1500, x: -0.1, y: -0.7, $Rotate: 0.1, $During: { $Left: [0.6, 0.4], $Top: [0.6, 0.4], $Rotate: [0.6, 0.4] }, $Easing: { $Left: $tdmSeshuEasing$.$EaseInQuad, $Top: $tdmSeshuEasing$.$EaseInQuad, $Opacity: $tdmSeshuEasing$.$EaseLinear, $Rotate: $tdmSeshuEasing$.$EaseInQuad }, $Opacity: 2, $Brother: { $Duration: 1000, x: 0.2, y: 0.5, $Rotate: -0.1, $Easing: { $Left: $tdmSeshuEasing$.$EaseInQuad, $Top: $tdmSeshuEasing$.$EaseInQuad, $Opacity: $tdmSeshuEasing$.$EaseLinear, $Rotate: $tdmSeshuEasing$.$EaseInQuad }, $Opacity: 2 } },
                //Extrude Replace
                { $Duration: 1600, x: -0.2, $Delay: 40, $Cols: 12, $During: { $Left: [0.4, 0.6] }, $SlideOut: true, $Formation: $tdmSeshuSlideshowFormations$.$FormationStraight, $Assembly: 260, $Easing: { $Left: $tdmSeshuEasing$.$EaseInOutExpo, $Opacity: $tdmSeshuEasing$.$EaseInOutQuad }, $Opacity: 2, $Outside: true, $Round: { $Top: 0.5 }, $Brother: { $Duration: 1000, x: 0.2, $Delay: 40, $Cols: 12, $Formation: $tdmSeshuSlideshowFormations$.$FormationStraight, $Assembly: 1028, $Easing: { $Left: $tdmSeshuEasing$.$EaseInOutExpo, $Opacity: $tdmSeshuEasing$.$EaseInOutQuad }, $Opacity: 2, $Round: { $Top: 0.5 } } }
            ];

           
            var captionTransitions = [];

            var t_tr = { $Duration: 700, x: -0.6, y: 0.6, $Easing: { $Left: $tdmSeshuEasing$.$EaseInOutSine, $Top: $tdmSeshuEasing$.$EaseInOutSine }, $Opacity: 2 };
            var t_tr_ib = { $Duration: 900, x: -0.6, y: 0.6, $Easing: { $Left: $tdmSeshuEasing$.$EaseInOutBack, $Top: $tdmSeshuEasing$.$EaseInOutBack }, $Opacity: 2 };
            var t_rtt_tr = { $Duration: 700, x: -0.6, y: 0.6, $Zoom: 11, $Rotate: 1, $Easing: { $Left: $tdmSeshuEasing$.$EaseInCubic, $Top: $tdmSeshuEasing$.$EaseInCubic, $Zoom: $tdmSeshuEasing$.$EaseInCubic, $Opacity: $tdmSeshuEasing$.$EaseLinear, $Rotate: $tdmSeshuEasing$.$EaseInCubic }, $Opacity: 2, $Round: { $Rotate: 0.8} };

            var t_rtt_360 = { $Duration: 800, $Rotate: 1, $Easing: { $Opacity: $tdmSeshuEasing$.$EaseLinear, $Rotate: $tdmSeshuEasing$.$EaseInQuad }, $Opacity: 2 };
            var t_clip_lr = { $Duration: 900, $Clip: 3, $Easing: { $Clip: $tdmSeshuEasing$.$EaseInOutCubic }, $Opacity: 2 };
            var t_zm = { $Duration: 700, $Zoom: 1, $Easing: $tdmSeshuEasing$.$EaseInCubic, $Opacity: 2 };
            var t_b_ = { $Duration: 700, y: -0.6, $Rotate: 0.05, $Easing: { $Top: $tdmSeshuEasing$.$EaseInOutSine }, $Opacity: 2 };

            captionTransitions["TEAM_1"] = [[t_rtt_360, t_zm], [t_zm, t_rtt_tr]];
            captionTransitions["TEAM_2"] = [t_rtt_360, t_clip_lr, t_zm, t_b_];

            captionTransitions["L|IB"] = { $Duration: 900, x: 0.6, $Easing: { $Left: $tdmSeshuEasing$.$EaseInOutBack }, $Opacity: 2 };
            captionTransitions["L|EP"] = { $Duration: 900, x: 0.6, $Easing: { $Left: $tdmSeshuEasing$.$EaseInOutExpo }, $Opacity: 2 };
            captionTransitions["L*IB"] = { $Duration: 900, x: 0.6, $Zoom: 3, $Rotate: -0.3, $Easing: { $Left: $tdmSeshuEasing$.$EaseInCubic, $Rotate: $tdmSeshuEasing$.$EaseInBack }, $Opacity: 2 };
            captionTransitions["B*IB"] = { $Duration: 900, y: -0.6, $Zoom: 3, $Rotate: -0.3, $Easing: { $Top: $tdmSeshuEasing$.$EaseInCubic, $Rotate: $tdmSeshuEasing$.$EaseInBack }, $Opacity: 2 };
            captionTransitions["T|IE*IE"] = { $Duration: 1800, y: 0.8, $Zoom: 11, $Rotate: -1.5, $Easing: { $Top: $tdmSeshuEasing$.$EaseInOutElastic, $Zoom: $tdmSeshuEasing$.$EaseInElastic, $Rotate: $tdmSeshuEasing$.$EaseInOutElastic }, $Opacity: 2, $During: { $Zoom: [0, 0.8], $Opacity: [0, 0.7] }, $Round: { $Rotate: 0.5} };
            captionTransitions["CLIP|L"] = { $Duration: 800, $Clip: 1, $Easing: { $Clip: $tdmSeshuEasing$.$EaseInOutCubic }, $Opacity: 2 };
            captionTransitions["CLIP|LR"] = t_clip_lr;
            captionTransitions["RTT|360"] = t_rtt_360;
            captionTransitions["RTT*JUP|BR"] = { $Duration: 1000, x: -0.5, y: -0.8, $Zoom: 11, $Rotate: 0.2, $Easing: { $Left: $tdmSeshuEasing$.$EaseInCubic, $Top: $tdmSeshuEasing$.$EaseLinear, $Zoom: $tdmSeshuEasing$.$EaseInCubic }, $Opacity: 2, $During: { $Left: [0, 0.5]} };
            captionTransitions["RTT*JDN|L"] = { $Duration: 1200, x: 0.3, $Zoom: 11, $Rotate: 0.2, $Easing: { $Left: $tdmSeshuEasing$.$EaseOutCubic, $Zoom: $tdmSeshuEasing$.$EaseInCubic }, $Opacity: 2, $During: { $Left: [0, 0.5]} };
            captionTransitions["SPACESHIP|LB"] = { $Duration: 1000, x: 1, y: -0.1, $Zoom: 3, $Rotate: -0.1, $Easing: { $Left: $tdmSeshuEasing$.$EaseInQuint, $Top: $tdmSeshuEasing$.$EaseInWave, $Opacity: $tdmSeshuEasing$.$EaseInQuint }, $Opacity: 2 };
            captionTransitions["SPACESHIP|RB"] = { $Duration: 1000, x: -1, y: -0.1, $Zoom: 3, $Rotate: 0.1, $Easing: { $Left: $tdmSeshuEasing$.$EaseInQuint, $Top: $tdmSeshuEasing$.$EaseInWave, $Opacity: $tdmSeshuEasing$.$EaseInQuint }, $Opacity: 2 };
            captionTransitions["ZM"] = { $Duration: 600, $Zoom: 1, $Easing: $tdmSeshuEasing$.$EaseInCubic, $Opacity: 2 };

            var captionTransitions_childSliders = [
            //R|IB
            {$Duration: 900, x: -0.6, $Easing: { $Left: $tdmSeshuEasing$.$EaseInOutBack }, $Opacity: 2 }
            //B|IB
            , { $Duration: 900, y: -0.6, $Easing: { $Top: $tdmSeshuEasing$.$EaseInOutBack }, $Opacity: 2 }
            //R*|IB
            , { $Duration: 900, x: -0.6, $Zoom: 3, $Rotate: -0.3, $Easing: { $Left: $tdmSeshuEasing$.$EaseInCubic, $Rotate: $tdmSeshuEasing$.$EaseInBack }, $Opacity: 2 }
            //B*|IB
            , { $Duration: 900, y: -0.6, $Zoom: 3, $Rotate: -0.3, $Easing: { $Top: $tdmSeshuEasing$.$EaseInCubic, $Rotate: $tdmSeshuEasing$.$EaseInBack }, $Opacity: 2 }
            //R-*|IB
            , { $Duration: 900, x: -0.7, $Rotate: 0.5, $Easing: { $Left: $tdmSeshuEasing$.$EaseInCubic, $Opacity: $tdmSeshuEasing$.$EaseInQuad, $Rotate: $tdmSeshuEasing$.$EaseInBack }, $Opacity: 2, $During: { $Left: [0.2, 0.8]} }
            //B-*|IB
            , { $Duration: 900, y: -0.7, $Rotate: 0.5, $Easing: { $Top: $tdmSeshuEasing$.$EaseInCubic, $Opacity: $tdmSeshuEasing$.$EaseInQuad, $Rotate: $tdmSeshuEasing$.$EaseInBack }, $Opacity: 2, $During: { $Top: [0.2, 0.8]} }
            //CLIP|LR
            , { $Duration: 900, $Clip: 3, $Easing: { $Clip: $tdmSeshuEasing$.$EaseInOutCubic }, $Opacity: 2 }
            //CLIP|TB
            , { $Duration: 900, $Clip: 12, $Easing: { $Clip: $tdmSeshuEasing$.$EaseInOutCubic }, $Opacity: 2 }
            //CLIP|L
            , { $Duration: 800, $Clip: 1, $Easing: { $Clip: $tdmSeshuEasing$.$EaseInOutCubic }, $Opacity: 2 }
            //ZM*JDN|RB
            , { $Duration: 1200, x: -0.8, y: -0.5, $Zoom: 11, $Easing: { $Left: $tdmSeshuEasing$.$EaseLinear, $Top: $tdmSeshuEasing$.$EaseOutCubic, $Zoom: $tdmSeshuEasing$.$EaseInCubic }, $Opacity: 2, $During: { $Top: [0, 0.5]} }
            //RTT*JUP|RB
            , { $Duration: 1200, x: -0.8, y: -0.5, $Zoom: 11, $Rotate: 0.2, $Easing: { $Left: $tdmSeshuEasing$.$EaseLinear, $Top: $tdmSeshuEasing$.$EaseInCubic, $Zoom: $tdmSeshuEasing$.$EaseInCubic }, $Opacity: 2, $During: { $Top: [0, 0.5]} }
            //TORTUOUS|VB
            , { $Duration: 1800, y: -0.2, $Zoom: 1, $Easing: { $Top: $tdmSeshuEasing$.$EaseOutWave, $Zoom: $tdmSeshuEasing$.$EaseOutCubic }, $Opacity: 2, $During: { $Top: [0, 0.7] }, $Round: { $Top: 1.3} }
            ];

            var slider1Options = {
                $AutoPlayInterval: 3000,                            //[Optional] Interval (in milliseconds) to go for next slide since the previous stopped if the slider is auto playing, default value is 3000
                $DragOrientation: 0,                                //[Optional] Orientation to drag slide, 0 no drag, 1 horizental, 2 vertical, 3 either, default value is 1 (Note that the $DragOrientation should be the same as $PlayOrientation when $DisplayPieces is greater than 1, or parking position is not 0)

                $CaptionSliderOptions: {                            //[Optional] Options which specifies how to animate caption
                    $Class: $tdmSeshuCaptionSlider$,                   //[Required] Class to create instance to animate caption
                    $CaptionTransitions: captionTransitions_childSliders,       //[Required] An array of caption transitions to play caption, see caption transition section at tdmSeshu slideshow transition builder
                    $PlayInMode: 1,                                 //[Optional] 0 None (no play), 1 Chain (goes after main slide), 3 Chain Flatten (goes after main slide and flatten all caption animations), default value is 1
                    $PlayOutMode: 3                                 //[Optional] 0 None (no play), 1 Chain (goes before main slide), 3 Chain Flatten (goes before main slide and flatten all caption animations), default value is 1
                },

                $BulletNavigatorOptions: {                                //[Optional] Options to specify and enable navigator or not
                    $Class: $tdmSeshuBulletNavigator$,                       //[Required] Class to create navigator instance
                    $ChanceToShow: 2,                               //[Required] 0 Never, 1 Mouse Over, 2 Always
                    $SpacingX: 10,                                  //[Optional] Horizontal space between each item in pixel, default value is 0
                    $SpacingY: 10                                   //[Optional] Vertical space between each item in pixel, default value is 0
                },

                $ArrowNavigatorOptions: {
                    $Class: $tdmSeshuArrowNavigator$,              //[Requried] Class to create arrow navigator instance
                    $ChanceToShow: 2                                //[Required] 0 Never, 1 Mouse Over, 2 Always
                }
            };

            var tdmSeshuSlider1 = new $tdmSeshuSlider$("slider1_container", slider1Options);

            var slider2Options = {
                $AutoPlayInterval: 3000,                            //[Optional] Interval (in milliseconds) to go for next slide since the previous stopped if the slider is auto playing, default value is 3000
                $DragOrientation: 0,                                //[Optional] Orientation to drag slide, 0 no drag, 1 horizental, 2 vertical, 3 either, default value is 1 (Note that the $DragOrientation should be the same as $PlayOrientation when $DisplayPieces is greater than 1, or parking position is not 0)

                $SlideshowOptions: {                                //[Optional] Options to specify and enable slideshow or not
                    $Class: $tdmSeshuSlideshowRunner$,                 //[Required] Class to create instance of slideshow
                    $Transitions: _SlideshowTransitions,             //[Required] An array of slideshow transitions to play slideshow
                    $TransitionsOrder: 1,                           //[Optional] The way to choose transition to play slide, 1 Sequence, 0 Random
                    $ShowLink: true                                    //[Optional] Whether to bring slide link on top of the slider when slideshow is running, default value is false
                },

                $CaptionSliderOptions: {                            //[Optional] Options which specifies how to animate caption
                    $Class: $tdmSeshuCaptionSlider$,                   //[Required] Class to create instance to animate caption
                    $CaptionTransitions: captionTransitions_childSliders,       //[Required] An array of caption transitions to play caption, see caption transition section at tdmSeshu slideshow transition builder
                    $PlayInMode: 1,                                 //[Optional] 0 None (no play), 1 Chain (goes after main slide), 3 Chain Flatten (goes after main slide and flatten all caption animations), default value is 1
                    $PlayOutMode: 3                                 //[Optional] 0 None (no play), 1 Chain (goes before main slide), 3 Chain Flatten (goes before main slide and flatten all caption animations), default value is 1
                },

                $BulletNavigatorOptions: {                                //[Optional] Options to specify and enable navigator or not
                    $Class: $tdmSeshuBulletNavigator$,                       //[Required] Class to create navigator instance
                    $ChanceToShow: 2,                               //[Required] 0 Never, 1 Mouse Over, 2 Always
                    $SpacingX: 10,                                  //[Optional] Horizontal space between each item in pixel, default value is 0
                    $SpacingY: 10                                   //[Optional] Vertical space between each item in pixel, default value is 0
                },

                $ArrowNavigatorOptions: {
                    $Class: $tdmSeshuArrowNavigator$,              //[Requried] Class to create arrow navigator instance
                    $ChanceToShow: 2                                //[Required] 0 Never, 1 Mouse Over, 2 Always
                }
            };

            var tdmSeshuSlider2 = new $tdmSeshuSlider$("slider2_container", slider2Options);

            var bannerSlider_slideshowTransitions = [
            //Fade in R
            {$Duration: 1200, x: -0.3, $During: { $Left: [0.3, 0.7] }, $Easing: { $Left: $tdmSeshuEasing$.$EaseInCubic, $Opacity: $tdmSeshuEasing$.$EaseLinear }, $Opacity: 2 }
            //Fade out L
            , { $Duration: 1200, x: 0.3, $SlideOut: true, $Easing: { $Left: $tdmSeshuEasing$.$EaseInCubic, $Opacity: $tdmSeshuEasing$.$EaseLinear }, $Opacity: 2 }
            ];

            var slider3Options = {
                $AutoPlayInterval: 3000,                            //[Optional] Interval (in milliseconds) to go for next slide since the previous stopped if the slider is auto playing, default value is 3000
                $DragOrientation: 0,                                //[Optional] Orientation to drag slide, 0 no drag, 1 horizental, 2 vertical, 3 either, default value is 1 (Note that the $DragOrientation should be the same as $PlayOrientation when $DisplayPieces is greater than 1, or parking position is not 0)

                $SlideshowOptions: {                                //[Optional] Options to specify and enable slideshow or not
                    $Class: $tdmSeshuSlideshowRunner$,                 //[Required] Class to create instance of slideshow
                    $Transitions: bannerSlider_slideshowTransitions,            //[Required] An array of slideshow transitions to play slideshow
                    $TransitionsOrder: 1,                           //[Optional] The way to choose transition to play slide, 1 Sequence, 0 Random
                    $ShowLink: true                                    //[Optional] Whether to bring slide link on top of the slider when slideshow is running, default value is false
                },

                $BulletNavigatorOptions: {                                //[Optional] Options to specify and enable navigator or not
                    $Class: $tdmSeshuBulletNavigator$,                       //[Required] Class to create navigator instance
                    $ChanceToShow: 2,                               //[Required] 0 Never, 1 Mouse Over, 2 Always
                    $SpacingX: 10,                                  //[Optional] Horizontal space between each item in pixel, default value is 0
                    $SpacingY: 10                                   //[Optional] Vertical space between each item in pixel, default value is 0
                },

                $ArrowNavigatorOptions: {
                    $Class: $tdmSeshuArrowNavigator$,              //[Requried] Class to create arrow navigator instance
                    $ChanceToShow: 2                                //[Required] 0 Never, 1 Mouse Over, 2 Always
                },

                $ThumbnailNavigatorOptions: {
                    $Class: $tdmSeshuThumbnailNavigator$,              //[Required] Class to create thumbnail navigator instance
                    $ChanceToShow: 2,                               //[Required] 0 Never, 1 Mouse Over, 2 Always
                    $ActionMode: 0,                                 //[Optional] 0 None, 1 act by click, 2 act by mouse hover, 3 both, default value is 1
                    $DisableDrag: true                              //[Optional] Disable drag or not, default value is false
                }
            };

            var tdmSeshuSlider3 = new $tdmSeshuSlider$("slider3_container", slider3Options);

            function IsBrowserIe8Earlier() {
                var isBrowserIe8Earlier;

                var app = navigator.appName;
                var ua = navigator.userAgent;

                if (app == "Microsoft Internet Explorer" &&
                !!window.attachEvent && !!window.ActiveXObject) {

                    var ieOffset = ua.indexOf("MSIE");

                    browserRuntimeVersion = document.documentMode || parseFloat(ua.substring(ieOffset + 5, ua.indexOf(";", ieOffset)));

                    isBrowserIe8Earlier = browserRuntimeVersion < 8;
                }
            }

            var sliderClusterSlideshowOptions = IsBrowserIe8Earlier() ? null : {                                //[Optional] Options to specify and enable slideshow or not
                $Class: $tdmSeshuSlideshowRunner$,                 //[Required] Class to create instance of slideshow
                $Transitions: _SlideshowTransitions,            //[Required] An array of slideshow transitions to play slideshow
                $TransitionsOrder: 1,                           //[Optional] The way to choose transition to play slide, 1 Sequence, 0 Random
                $ShowLink: true                                    //[Optional] Whether to bring slide link on top of the slider when slideshow is running, default value is false
            };

            var slidercOptions = {
                $AutoPlay: false,                                   //[Optional] Whether to auto play, to enable slideshow, this option must be set to true, default value is false
                $AutoPlayInterval: 3000,                            //[Optional] Interval (in milliseconds) to go for next slide since the previous stopped if the slider is auto playing, default value is 3000
                $PauseOnHover: 1,                                   //[Optional] Whether to pause when mouse over if a slider is auto playing, 0 no pause, 1 pause for desktop, 2 pause for touch device, 3 pause for desktop and touch device, 4 freeze for desktop, 8 freeze for touch device, 12 freeze for desktop and touch device, default value is 1

                $ArrowKeyNavigation: true,   			            //Allows arrow key to navigate or not
                $SlideDuration: 800,                                //[Optional] Specifies default duration (swipe) for slide in milliseconds, default value is 500
                $UISearchMode: 0,                                   //[Optional] The way (0 parellel, 1 recursive, default value is 1) to search UI components (slides container, loading screen, navigator container, arrow navigator container, thumbnail navigator container etc).
                $DragOrientation: 3,                                //[Optional] Orientation to drag slide, 0 no drag, 1 horizental, 2 vertical, 3 either, default value is 1 (Note that the $DragOrientation should be the same as $PlayOrientation when $DisplayPieces is greater than 1, or parking position is not 0)

                $SlideshowOptions: sliderClusterSlideshowOptions,

                $CaptionSliderOptions: {                            //[Optional] Options which specifies how to animate caption
                    $Class: $tdmSeshuCaptionSlider$,                   //[Required] Class to create instance to animate caption
                    $CaptionTransitions: captionTransitions,        //[Required] An array of caption transitions to play caption, see caption transition section at tdmSeshu slideshow transition builder
                    $PlayInMode: 1,                                 //[Optional] 0 None (no play), 1 Chain (goes after main slide), 3 Chain Flatten (goes after main slide and flatten all caption animations), default value is 1
                    $PlayOutMode: 3                                 //[Optional] 0 None (no play), 1 Chain (goes before main slide), 3 Chain Flatten (goes before main slide and flatten all caption animations), default value is 1
                },

                $ArrowNavigatorOptions: {                       //[Optional] Options to specify and enable arrow navigator or not
                    $Class: $tdmSeshuArrowNavigator$,              //[Requried] Class to create arrow navigator instance
                    $ChanceToShow: 1,                               //[Required] 0 Never, 1 Mouse Over, 2 Always
                    $AutoCenter: 2                                  //[Optional] Auto center arrows in parent container, 0 No, 1 Horizontal, 2 Vertical, 3 Both, default value is 0
                },

                $BulletNavigatorOptions: {                                //[Optional] Options to specify and enable navigator or not
                    $Class: $tdmSeshuBulletNavigator$,                       //[Required] Class to create navigator instance
                    $ChanceToShow: 2,                               //[Required] 0 Never, 1 Mouse Over, 2 Always
                    $AutoCenter: 1,                                 //[Optional] Auto center navigator in parent container, 0 None, 1 Horizontal, 2 Vertical, 3 Both, default value is 0
                    $SpacingX: 4,                                   //[Optional] Horizontal space between each item in pixel, default value is 0
                    $SpacingY: 4                                    //[Optional] Vertical space between each item in pixel, default value is 0
                }
            };

            var tdmSeshuSliderc = new $tdmSeshuSlider$("sliderc_container", slidercOptions);

            //responsive code begin
            //you can remove responsive code if you don't want the slider scales while window resizes
            function ScaleSlider() {
                var parentWidth = tdmSeshuSliderc.$Elmt.parentNode.clientWidth;
                if (parentWidth)
                    tdmSeshuSliderc.$ScaleWidth(Math.max(Math.min(parentWidth, 960), 300));
                else
                    window.setTimeout(ScaleSlider, 30);
            }
            ScaleSlider();

            $(window).bind("load", ScaleSlider);
            $(window).bind("resize", ScaleSlider);
            $(window).bind("orientationchange", ScaleSlider);
            //responsive code end

            //slider cluster controller code begin
            function SliderCluster(mainSlider, autoPlayInterval) {
                var _Self = this;
                var _NestedSliders = [];
                var _NestedSliderCurrent;

                var _CaptionInCounter = 0;

                function OnChildSliderStateChange(currentIndex, progress, progressBegin, idleBegin, idleEnd, progressEnd) {
                    if (progress == idleBegin) {
                        if (!(++_CaptionInCounter % 4)) {

                            _NestedSliderCurrent && _NestedSliderCurrent.$Pause();

                            mainSlider.$Play(true);
                        }
                    }
                }

                function OnMainSliderStateChange(currentIndex, progress, progressBegin, idleBegin, idleEnd, progressEnd) {

                    _NestedSliderCurrent = _NestedSliders[currentIndex];

                    if (_NestedSliderCurrent) {
                        if (progress == idleBegin) {

                            mainSlider.$Pause();
                            _NestedSliderCurrent.$Play(true);
                        }
                        else if (progress == progressBegin) {
                            _CaptionInCounter = 0;
                            mainSlider.$Play(true);
                        }
                    }
                }

                function OnMainSliderSwipeStart(position, virtualPosition) {
                    _NestedSliderCurrent && _NestedSliderCurrent.$Pause();
                    mainSlider.$Pause();
                }

                function OnMainSliderPark(slideIndex, fromIndex) {
                    _CaptionInCounter = 0;
                    mainSlider.$Play();
                }

                _Self.$AddChildSlider = function (childSlider, slideIndex) {
                    _NestedSliders[slideIndex] = childSlider;
                    childSlider.$On($tdmSeshuSlider$.$EVT_STATE_CHANGE, OnChildSliderStateChange);
                };

                _Self.$Start = function () {
                    mainSlider.$On($tdmSeshuSlider$.$EVT_PARK, OnMainSliderPark);
                    mainSlider.$On($tdmSeshuSlider$.$EVT_STATE_CHANGE, OnMainSliderStateChange);
                    mainSlider.$On($tdmSeshuSlider$.$EVT_SWIPE_START, OnMainSliderSwipeStart);

                    mainSlider.$Play(true);
                }
            }

            var sliderCluster = new SliderCluster(tdmSeshuSliderc);
            sliderCluster.$AddChildSlider(tdmSeshuSlider1, 0);
            sliderCluster.$AddChildSlider(tdmSeshuSlider2, 1);
            sliderCluster.$AddChildSlider(tdmSeshuSlider3, 2);
            sliderCluster.$Start();

            //slider cluster controller code end
        });
    </script>
    <div style="  border-radius: 5px; position: relative; margin-top: 19px; top: 40px; left: 57px; width:90%; text-align: center; background-image: url(images/1920/blue.jpg); border-top: 1px solid gray; border-bottom: 1px solid gray; overflow: hidden;">
        <!--  Slider Begin -->
        <!-- To move inline styles to css file/block, please specify a class name for each element. -->  
        <div id="sliderc_container" style="position: relative; margin: 0 auto; width: 960px;
            height: 450px; text-align: left; overflow: hidden;">
 
            <!-- Slides Container --> 
            <div u="slides" style="cursor: move; position: absolute; left: 0px; top: 0px; width: 960px; height: 450px;
                overflow: hidden;">
                <div>
                    <!--  Slider Begin -->
                    <!-- To move inline styles to css file/block, please specify a class name for each element. --> 
                    <div id="slider1_container" style="position: relative; top: 90px; left: 0px; width: 600px;
                        height: 300px; overflow: hidden; border-radius: 8px;">

                        <!-- Loading Screen -->
                        <div u="loading" style="position: absolute; top: 0px; left: 0px;">
                            <div style="filter: alpha(opacity=70); opacity:0.7; position: absolute; display: block;
                                background-color: #000; top: 0px; left: 0px;width: 100%;height:100%;">
                            </div>
                            <div style="position: absolute; display: block; background: url(images/loading.gif) no-repeat center center;
                                top: 0px; left: 0px;width: 100%;height:100%;">
                            </div>
                        </div>

                        <!-- Slides Container -->
                        <div u="slides" style="cursor: move; position: absolute; left: 0px; top: 0px; width: 600px; height: 300px; overflow: hidden;">
                            <div>
                                <a u="image" href="#"><img src="images/photography/002.jpg" alt="image slider" /></a>
                                <div u=caption t="*" class="captionOrange"  style="position:absolute; left:20px; top: 30px; width:300px; height:30px;"> 
                                Only 25% effort is involved in TDM
                                </div>
                            </div>
                            <div>
                                <a u="image" href="#"><img src="images/photography/003.jpg" alt="jqeury image slider" /></a>
                                <div u=caption t="*" class="captionOrange"  style="position:absolute; left:20px; top: 30px; width:300px; height:30px;"> 
                                Increase in the self service capabilities
                                </div>
                            </div>
                            <div>
                                <a u="image" href="#"><img src="images/photography/004.jpg" alt="responsive image slider" /></a>
                                <div u=caption t="*" class="captionOrange"  style="position:absolute; left:20px; top: 30px; width:300px; height:30px;"> 
                                Centralized TDM governance
                                </div>
                            </div>
                            <div>
                                <a u="image" href="#"><img src="images/photography/005.jpg" alt="touch swipe image slider" /></a>
                                <div u=caption t="*" class="captionOrange"  style="position:absolute; left:20px; top: 30px; width:300px; height:30px;"> 
                                Reduces manual intervention
                                </div>
                            </div>
                        </div>
        
                        <!--#region Bullet Navigator Skin Begin -->
                        
                        <!-- bullet navigator container -->
                        <div u="navigator" class="tdmSeshub01" style="bottom: 16px; right: 10px;">
                            <!-- bullet navigator item prototype -->
                            <div u="prototype"></div>
                        </div>
                        <!--#endregion Bullet Navigator Skin End -->
        
                        <!--#region Arrow Navigator Skin Begin -->
                        
                       
                        <!-- Arrow Left -->
                        <span u="arrowleft" class="tdmSeshua05l" style="top: 123px; left: 8px;">
                        </span>
                        <!-- Arrow Right -->
                        <span u="arrowright" class="tdmSeshua05r" style="top: 123px; right: 8px;">
                        </span>
                        <!--#endregion Arrow Navigator Skin End -->
         
                    </div>
                    <!-- tdmSeshu Slider End -->
                    <div u="caption" t="RTT*JUP|BR" t2="SPACESHIP|RB" style="position: absolute; left: 0px;top:30px;width:600px;height:30px;font-size:28px;color:#fff;line-height:30px; text-align: center;">
                    TDM Central 
                    </div>
                    <div style="position: absolute; top: 110px; left: 640px; width: 320px; height: 250px;">
                        <div u="caption" t="TEAM_1" d="-200" du="50%" class="captionSymbol" style="position: absolute; top: 10px; left: 0px; width: 30px; height: 30px;">&gt;</div>
                        <div u="caption" t="TEAM_1" d="-200" y="100%" class="captionOrange" style="position: absolute; top: 10px; left: 40px; width: 280px; height: 30px;">
                        Find Test Data
                        </div>
                        <div u="caption" t="TEAM_1" d="-200" du="50%" class="captionSymbol" style="position: absolute; top: 60px; left: 0px; width: 30px; height: 30px;" debug-id="team-caption">&gt;</div>
                        <div u="caption" t="TEAM_1" d="-200" y="50%" class="captionOrange" style="position: absolute; top: 60px; left: 40px; width: 280px; height: 30px;">
                        Data masking
                        </div>
                        <div u="caption" t="TEAM_1" d="-200" du="50%" class="captionSymbol" style="position: absolute; top: 110px; left: 0px; width: 30px; height: 30px;">&gt;</div>
                        <div u="caption" t="TEAM_1" d="-200" y="0" class="captionOrange" style="position: absolute; top: 110px; left: 40px; width: 280px; height: 30px;">
                        Data Refresh
                        </div>
                        <div u="caption" t="TEAM_1" d="-200" du="50%" class="captionSymbol" style="position: absolute; top: 160px; left: 0px; width: 30px; height: 30px;">&gt;</div>
                        <div u="caption" t="TEAM_1" d="-200" y="-50%" class="captionOrange" style="position: absolute; top: 160px; left: 40px; width: 280px; height: 30px;">
                        Data genarater
                        </div>
                        <div u="caption" t="TEAM_1" d="-200" du="50%" class="captionSymbol" style="position: absolute; top: 210px; left: 0px; width: 30px; height: 30px;">&gt;</div>
                        <div u="caption" t="TEAM_1" d="-200" y="-100%" class="captionOrange" style="position: absolute; top: 210px; left: 40px; width: 280px; height: 30px;">
                        Reservation
                        </div>
                    </div>
                </div>
                <div>
                    <!-- tdmSeshu Slider Begin -->
                    <!-- To move inline styles to css file/block, please specify a class name for each element. --> 
					<div id="slider2_container" style="position: relative; top: 90px; left: 0px; width: 600px;
                        height: 300px; overflow: hidden; border-radius: 8px;">

                        
                        <!-- Loading Screen -->
                        <div u="loading" style="position: absolute; top: 0px; left: 0px;">
                            <div style="filter: alpha(opacity=70); opacity:0.7; position: absolute; display: block;
                                background-color: #000; top: 0px; left: 0px;width: 100%;height:100%;">
                            </div>
                            <div style="position: absolute; display: block; background: url(images/loading.gif) no-repeat center center;
                                top: 0px; left: 0px;width: 100%;height:100%;">
                            </div>
                        </div>

                        <!-- Slides Container -->
                        <div u="slides" style="cursor: move; position: absolute; left: 0px; top: 0px; width: 600px; height: 300px; overflow: hidden;">
                            <div>
                                <a u="image" href="#"><img src="images/photography/003.jpg" alt="image slider" /></a>
                                <div u=caption t="*" class="captionOrange"  style="position:absolute; left:20px; top: 30px; width:300px; height:30px;"> 
                                Find Test Data 
                                </div>
                            </div>
                            <div>
                                <a u="image" href="#"><img src="images/photography/004.jpg" alt="jqeury image slider" /></a>
                                <div u=caption t="*" class="captionOrange"  style="position:absolute; left:20px; top: 30px; width:300px; height:30px;"> 
                                Customized test data finding
                                </div>
                            </div>
                            <div>
                                <a u="image" href="#"><img src="images/photography/005.jpg" alt="responsive image slider" /></a>
                                <div u=caption t="*" class="captionOrange"  style="position:absolute; left:20px; top: 30px; width:300px; height:30px;"> 
                                Reduces manual searches for test data
                                </div>
                            </div>
                            <div>
                                <a u="image" href="#"><img src="images/photography/002.jpg" alt="touch swipe image slider" /></a>
                                <div u=caption t="*" class="captionOrange"  style="position:absolute; left:20px; top: 30px; width:300px; height:30px;"> 
                                Maintains traking of all users test data
                                </div>
                            </div>
                        </div>
        
                        <!--#region Bullet Navigator Skin Begin -->
                        
                        <!-- bullet navigator container -->
                        <div u="navigator" class="tdmSeshub01" style="bottom: 16px; right: 10px;">
                            <!-- bullet navigator item prototype -->
                            <div u="prototype"></div>
                        </div>
                        <!--#endregion Bullet Navigator Skin End -->
        
                        <!--#region Arrow Navigator Skin Begin -->
                        
                       
                        <!-- Arrow Left -->
                        <span u="arrowleft" class="tdmSeshua05l" style="top: 123px; left: 8px;">
                        </span>
                        <!-- Arrow Right -->
                        <span u="arrowright" class="tdmSeshua05r" style="top: 123px; right: 8px;">
                        </span>
                        <!--#endregion Arrow Navigator Skin End -->
         
                    </div>
                    <!-- tdmSeshu Slider End -->
                    <div u="caption" t="RTT*JUP|BR" t2="SPACESHIP|RB" style="position: absolute; left: 0px;top:30px;width:600px;height:30px;font-size:28px;color:#fff;line-height:30px; text-align: center;">
                    TDM Central (Find Test Data and Data genarater)
                    </div>
                    <div style="position: absolute; top: 110px; left: 640px; width: 320px; height: 250px;">
                        <div u="caption" t="TEAM_1" d="-200" du="50%" class="captionSymbol" style="position: absolute; top: 10px; left: 0px; width: 30px; height: 30px;">&gt;</div>
                        <div u="caption" t="TEAM_1" d="-200" y="100%" class="captionOrange" style="position: absolute; top: 10px; left: 40px; width: 280px; height: 30px;">
                        Custom UI fields
                        </div>
                        <div u="caption" t="TEAM_1" d="-200" du="50%" class="captionSymbol" style="position: absolute; top: 60px; left: 0px; width: 30px; height: 30px;" debug-id="team-caption">&gt;</div>
                        <div u="caption" t="TEAM_1" d="-200" y="50%" class="captionOrange" style="position: absolute; top: 60px; left: 40px; width: 280px; height: 30px;">
                        Reservation and Un-Reservation
                        </div>
                        <div u="caption" t="TEAM_1" d="-200" du="50%" class="captionSymbol" style="position: absolute; top: 110px; left: 0px; width: 30px; height: 30px;">&gt;</div>
                        <div u="caption" t="TEAM_1" d="-200" y="0" class="captionOrange" style="position: absolute; top: 110px; left: 40px; width: 280px; height: 30px;">
                        Avoids data conflicts  
                        </div>
                        <div u="caption" t="TEAM_1" d="-200" du="50%" class="captionSymbol" style="position: absolute; top: 160px; left: 0px; width: 30px; height: 30px;">&gt;</div>
                        <div u="caption" t="TEAM_1" d="-200" y="-50%" class="captionOrange" style="position: absolute; top: 160px; left: 40px; width: 280px; height: 30px;">
                        Synthatic data & business data
                        </div>
                        <div u="caption" t="TEAM_1" d="-200" du="50%" class="captionSymbol" style="position: absolute; top: 210px; left: 0px; width: 30px; height: 30px;">&gt;</div>
                        <div u="caption" t="TEAM_1" d="-200" y="-100%" class="captionOrange" style="position: absolute; top: 210px; left: 40px; width: 280px; height: 30px;">
                        Keeps track of genarated data. 
                        </div>
                    </div>
                </div>
                <div>
                    <!-- tdmSeshu Slider Begin -->
                    <!-- To move inline styles to css file/block, please specify a class name for each element. --> 
                     <div id="slider3_container" style="position: relative; top: 90px; left: 0px; width: 600px;
                        height: 300px; overflow: hidden; border-radius: 8px;">

                        <!-- Loading Screen -->
                        <div u="loading" style="position: absolute; top: 0px; left: 0px;">
                            <div style="filter: alpha(opacity=70); opacity:0.7; position: absolute; display: block;
                                background-color: #000; top: 0px; left: 0px;width: 100%;height:100%;">
                            </div>
                            <div style="position: absolute; display: block; background: url(images/loading.gif) no-repeat center center;
                                top: 0px; left: 0px;width: 100%;height:100%;">
                            </div>
                        </div>

                        <!-- Slides Container -->
                        <div u="slides" style="cursor: move; position: absolute; left: 0px; top: 0px; width: 600px; height: 300px; overflow: hidden;">
                            <div>
                                <a u="image" href="#"><img src="images/photography/004.jpg" alt="image slider" /></a>
                                <div u=caption t="*" class="captionOrange"  style="position:absolute; left:20px; top: 30px; width:300px; height:30px;"> 
                                Only 30% effort is involved in masking
                                </div>
                            </div>
                            <div>
                                <a u="image" href="#"><img src="images/photography/005.jpg" alt="jqeury image slider" /></a>
                                <div u=caption t="*" class="captionOrange"  style="position:absolute; left:20px; top: 30px; width:300px; height:30px;"> 
                                Consistent data masking
                                </div>
                            </div>
                            <div>
                                <a u="image" href="#"><img src="images/photography/002.jpg" alt="responsive image slider" /></a>
                                <div u=caption t="*" class="captionOrange"  style="position:absolute; left:20px; top: 30px; width:300px; height:30px;"> 
                                Hiding sensitive
                                </div>
                            </div>
                            <div>
                                <a u="image" href="#"><img src="images/photography/003.jpg" alt="touch swipe image slider" /></a>
                                <div u=caption t="*" class="captionOrange"  style="position:absolute; left:20px; top: 30px; width:300px; height:30px;"> 
                                Sophisticated approch
                                </div>
                            </div>
                        </div>
        
                        <!--#region Bullet Navigator Skin Begin -->
                        
                        <!-- bullet navigator container -->
                        <div u="navigator" class="tdmSeshub01" style="bottom: 16px; right: 10px;">
                            <!-- bullet navigator item prototype -->
                            <div u="prototype"></div>
                        </div>
                        <!--#endregion Bullet Navigator Skin End -->
        
                        <!--#region Arrow Navigator Skin Begin -->
                        
                       
                        <!-- Arrow Left -->
                        <span u="arrowleft" class="tdmSeshua05l" style="top: 123px; left: 8px;">
                        </span>
                        <!-- Arrow Right -->
                        <span u="arrowright" class="tdmSeshua05r" style="top: 123px; right: 8px;">
                        </span>
                        <!--#endregion Arrow Navigator Skin End -->
         
                    </div>
                    <!-- tdmSeshu Slider End -->
                    <div u="caption" t="RTT*JUP|BR" t2="SPACESHIP|RB" style="position: absolute; left: 0px;top:30px;width:600px;height:30px;font-size:28px;color:#fff;line-height:30px; text-align: center;">
                    TDM Central (Data masking and Refresh)
                    </div>
                    <div style="position: absolute; top: 110px; left: 640px; width: 320px; height: 250px;">
                        <div u="caption" t="TEAM_1" d="-200" du="50%" class="captionSymbol" style="position: absolute; top: 10px; left: 0px; width: 30px; height: 30px;">&gt;</div>
                        <div u="caption" t="TEAM_1" d="-200" y="100%" class="captionOrange" style="position: absolute; top: 10px; left: 40px; width: 280px; height: 30px;">
                        Masking with efficient rules.
                        </div>
                        <div u="caption" t="TEAM_1" d="-200" du="50%" class="captionSymbol" style="position: absolute; top: 60px; left: 0px; width: 30px; height: 30px;" debug-id="team-caption">&gt;</div>
                        <div u="caption" t="TEAM_1" d="-200" y="50%" class="captionOrange" style="position: absolute; top: 60px; left: 40px; width: 280px; height: 30px;">
                        Hiding sensitive data.
                        </div>
                        <div u="caption" t="TEAM_1" d="-200" du="50%" class="captionSymbol" style="position: absolute; top: 110px; left: 0px; width: 30px; height: 30px;">&gt;</div>
                        <div u="caption" t="TEAM_1" d="-200" y="0" class="captionOrange" style="position: absolute; top: 110px; left: 40px; width: 280px; height: 30px;">
                        Consistent data masking.
                        </div>
                        <div u="caption" t="TEAM_1" d="-200" du="50%" class="captionSymbol" style="position: absolute; top: 160px; left: 0px; width: 30px; height: 30px;">&gt;</div>
                        <div u="caption" t="TEAM_1" d="-200" y="-50%" class="captionOrange" style="position: absolute; top: 160px; left: 40px; width: 280px; height: 30px;">
                      	Faster refreshing on request basis.
                        </div>
                        <div u="caption" t="TEAM_1" d="-200" du="50%" class="captionSymbol" style="position: absolute; top: 210px; left: 0px; width: 30px; height: 30px;">&gt;</div>
                        <div u="caption" t="TEAM_1" d="-200" y="-100%" class="captionOrange" style="position: absolute; top: 210px; left: 40px; width: 280px; height: 30px;">
                        Sophisticated approch for refresh.
                        </div>
                    </div>
                </div>
            </div> 
 
            <!--#region Bullet Navigator Skin Begin -->
          
            <style>
               
                .tdmSeshub03 {
                    position: absolute;
                }
                .tdmSeshub03 div, .tdmSeshub03 div:hover, .tdmSeshub03 .av {
                    position: absolute;
                    /* size of bullet elment */
                    width: 21px;
                    height: 21px;
                    text-align: center;
                    line-height: 21px;
                    color: white;
                    font-size: 12px;
                    background: url(images/b02.png) no-repeat;
                    overflow: hidden;
                    cursor: pointer;
                }
                .tdmSeshub03 div { background-position: -5px -4px; }
                .tdmSeshub03 div:hover, .tdmSeshub03 .av:hover { background-position: -35px -4px; }
                .tdmSeshub03 .av { background-position: -65px -4px; }
                .tdmSeshub03 .dn, .tdmSeshub03 .dn:hover { background-position: -95px -4px; }
            </style>
            <!-- bullet navigator container -->
            <div u="navigator" class="tdmSeshub03" style="bottom: 16px; right: 6px;">
                <!-- bullet navigator item prototype -->
                <div u="prototype"><div u=""></div></div>
            </div>
            <!--#endregion Bullet Navigator Skin End -->
        
            <!--#region Arrow Navigator Skin Begin -->
            
            <style>
                
                .tdmSeshua20l, .tdmSeshua20r {
                    display: block;
                    position: absolute;
                    /* size of arrow element */
                    width: 55px;
                    height: 55px;
                    cursor: pointer;
                    background: url(images/a20.png) no-repeat;
                    overflow: hidden;
                }
                .tdmSeshua20l { background-position: -3px -33px; }
                .tdmSeshua20r { background-position: -63px -33px; }
                .tdmSeshua20l:hover { background-position: -123px -33px; }
                .tdmSeshua20r:hover { background-position: -183px -33px; }
                .tdmSeshua20l.tdmSeshua20ldn { background-position: -243px -33px; }
                .tdmSeshua20r.tdmSeshua20rdn { background-position: -303px -33px; }
            </style>
            <!-- Arrow Left -->
            <span u="arrowleft" class="tdmSeshua05l" style="top: 371px; left: 8px;">
            </span>
            <!-- Arrow Right -->
            <span u="arrowright" class="tdmSeshua05r" style="top: 371px; right: 8px;">
            </span>
           
        </div> 
        <!--  Slider End -->
    </div>
</body> 
</html>