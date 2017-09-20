<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>Video.js | HTML5 Video Player</title>
<link href="css/video-js.min.css" rel="stylesheet">
<script src="js/video.min.js"></script>
</head>

<body>

 <video id="example_video_1" class="video-js vjs-default-skin" controls preload="none" width="640" height="264"
      poster="http://video-js.zencoder.com/oceans-clip.png"
      data-setup="{}">
    <source src="${pageContext.request.contextPath }/video/201701160313069773.avi" type='video/mp4' />
    <source src="${pageContext.request.contextPath }/video/201701160313069773.avi" type='video/webm' />
    <source src="vedio/201701160847322986.avi" type='video/ogg' />
    <track kind="captions" src="demo.captions.vtt" srclang="en" label="English"></track><!-- Tracks need an ending tag thanks to IE9 -->
    <track kind="subtitles" src="demo.captions.vtt" srclang="en" label="English"></track><!-- Tracks need an ending tag thanks to IE9 -->


</body>
</html>
