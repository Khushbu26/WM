<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html >
  <head>
    <meta charset="UTF-8">
    <title>Complaint Registration</title>
    
    

<!--     <link rel="stylesheet" href="css/normalize.css">

    
        <link rel="stylesheet" href="css/style.css"> -->
    
    
  <script>
	$(document).ready(function(){
  var placeholder = null;
  $('input[type=text]').focus(function(){
    placeholder = $(this).attr("placeholder");
    $(this).attr("placeholder","");
  });
  $('input[type=text]').blur(function(){
    $(this).attr("placeholder", placeholder);
  });
   $('textarea').blur(function(){
    $(this).attr("placeholder", placeholder);
  });
});
</script>
<style>
html {
	font-family: sans-serif;
	-ms-text-size-adjust: 100%;
	-webkit-text-size-adjust: 100%
}

body {
	background-image:url(example/slide_22.jpg);
	height:auto;
	margin: 0;
	text-align: center;
	margin-top: 203px;
} 
article, aside, details, figcaption, figure, footer, header, hgroup,
	main, menu, nav, section, summary {
	display: block
}

audio, canvas, progress, video {
	display: inline-block;
	vertical-align: baseline
}

audio:not ([controls] ){
	display: none;
	height: 0
}

[hidden], template {
	display: none
}

a {
	background-color: transparent
}

a:active, a:hover {
	outline: 0
}

abbr[title] {
	border-bottom: 1px dotted
}

b, strong {
	font-weight: bold
}

dfn {
	font-style: italic
}

h1 {
	font-size: 2em;
	margin: 0.67em 0
}

mark {
	background: #ff0;
	color: #000
}

small {
	font-size: 80%
}

sub, sup {
	font-size: 75%;
	line-height: 0;
	position: relative;
	vertical-align: baseline
}

sup {
	top: -0.5em
}

sub {
	bottom: -0.25em
}

img {
	border: 0
}

svg:not (:root ){
	overflow: hidden
}

figure {
	margin: 1em 40px
}

hr {
	-moz-box-sizing: content-box;
	-webkit-box-sizing: content-box;
	box-sizing: content-box;
	height: 0
}

pre {
	overflow: auto
}

code, kbd, pre, samp {
	font-family: monospace, monospace;
	font-size: 1em
}

button, input, optgroup, select, textarea {
	color: inherit;
	font: inherit;
	margin: 0
}

button {
	overflow: visible
}

button, select {
	text-transform: none
}

button, html input[type="button"], input[type="reset"], input[type="submit"]
	{
	-webkit-appearance: button;
	cursor: pointer
}

button[disabled], html input[disabled] {
	cursor: default
}

button::-moz-focus-inner, input::-moz-focus-inner {
	border: 0;
	padding: 0
}

input {
	line-height: normal
}

input[type="checkbox"], input[type="radio"] {
	-webkit-box-sizing: border-box;
	-moz-box-sizing: border-box;
	box-sizing: border-box;
	padding: 0
}

input[type="number"]::-webkit-inner-spin-button, input[type="number"]::-webkit-outer-spin-button
	{
	height: auto
}

input[type="search"] {
	-webkit-appearance: textfield;
	-moz-box-sizing: content-box;
	-webkit-box-sizing: content-box;
	box-sizing: content-box
}

input[type="search"]::-webkit-search-cancel-button, input[type="search"]::-webkit-search-decoration
	{
	-webkit-appearance: none
}

fieldset {
	border: 1px solid #c0c0c0;
	margin: 0 2px;
	padding: 0.35em 0.625em 0.75em
}

legend {
	border: 0;
	padding: 0
}

textarea {
	overflow: auto
}

optgroup {
	font-weight: bold
}

table {
	border-collapse: collapse;
	border-spacing: 0
}

td, th {
	padding: 0
}

.main>div {
	display: inline-block;
	width: 49%;
	margin-top: 10px;
}

.two .register {
	border: none;
}

.two .register h3 {
	border-bottom-color: #909090;
}

.two .register .sep {
	border-color: #909090;
}

.register {
	width: 500px;
	margin: 10px auto;
	padding: 10px;
	border: 7px solid #72B372;
	border-radius: 10px;
	font-family: "Helvetica Neue", Helvetica, Arial, sans-serif;
	color: #444;
	background-color: #F0F0F0;
	box-shadow: 0 0 20px 0 #000000;
}

.register h3 {
	margin: 0 15px 20px;
	border-bottom: 2px solid #72B372;
	padding: 5px 10px 5px 0;
	font-size: 1.1em;
}

.register div {
	margin: 0 0 15px 0;
	border: none;
}

.register label {
	display: inline-block;
	width: 25%;
	text-align: right;
	margin: 10px;
}

.register input[type=text], .register input[type=password] {
	width: 65%;
	font-family: "Lucida Grande", "Lucida Sans Unicode", Tahoma, Sans-Serif;
	padding: 5px;
	font-size: 0.9em;
	border-radius: 5px;
	background: rgba(0, 0, 0, 0.07);
}

.register input[type=text]:focus, .register input[type=password]:focus {
	background: #FFFFFF;
}

.register .button {
	font-size: 1em;
	border-radius: 8px;
	padding: 10px;
	border: 1px solid #59B969;
	box-shadow: 0 1px 0 0 #60BD49 inset;
	background: #63E651;
	background: -webkit-linear-gradient(#63E651, #42753E);
	background: -moz-linear-gradient(#63E651, #42753E);
	background: -o-linear-gradient(#63E651, #42753E);
	background: linear-gradient(#63e651, #42753e);
}

.register .button:hover {
	background: #51DB1C;
	background: -webkit-linear-gradient(#51DB1C, #6BA061);
	background: -moz-linear-gradient(#51DB1C, #6BA061);
	background: -o-linear-gradient(#51DB1C, #6BA061);
	background: linear-gradient(#51db1c, #6ba061);
}

.register .sep {
	border: 1px solid #72B372;
	position: relative;
	margin: 35px 20px;
}

.register .or {
	position: absolute;
	width: 50px;
	left: 50%;
	background: #F0F0F0;
	text-align: center;
	margin: -10px 0 0 -25px;
	line-height: 20px;
}

.register .connect {
	width: 400px;
	margin: 0 auto;
	text-align: center;
}

.register .social-buttons {
	display: inline-block;
	min-width: 150px;
	height: 50px;
	margin: 0 5px 10px;
	border-radius: 10px;
	text-shadow: 1px 1px 5px #000000;
}

.register .social-buttons a {
	display: block;
	height: 100%;
	text-decoration: none;
	color: #FFFFFF;
	padding: 10px 15px;
}

.register .social-buttons span {
	font-size: 30px;
	margin-left: 35px;
}

.register .facebook {
	background: #415EA3;
	background: -webkit-linear-gradient(#415EA3, #2E4A88);
	background: -moz-linear-gradient(#415EA3, #2E4A88);
	background: -o-linear-gradient(#415EA3, #2E4A88);
	background: linear-gradient(#415ea3, #2e4a88);
}

.register .facebook:hover {
	background: #3B5591;
	background: -webkit-linear-gradient(#3B5591, #2A437C);
	background: -moz-linear-gradient(#3B5591, #2A437C);
	background: -o-linear-gradient(#3B5591, #2A437C);
	background: linear-gradient(#3b5591, #2a437c);
}

.register .facebook a {
	background: url(../images/logo_fb_31x42.png) no-repeat 5% 10%;
}

.register .twitter {
	background: #41C0F3;
	background: -webkit-linear-gradient(#41C0F3, #3FBAEC);
	background: -moz-linear-gradient(#41C0F3, #3FBAEC);
	background: -o-linear-gradient(#41C0F3, #3FBAEC);
	background: linear-gradient(#41c0f3, #3fbaec);
}

.register .twitter:hover {
	background: #3EB1DF;
	background: -webkit-linear-gradient(#3EB1DF, #3EAAD6);
	background: -moz-linear-gradient(#3EB1DF, #3EAAD6);
	background: -o-linear-gradient(#3EB1DF, #3EAAD6);
	background: linear-gradient(#3eb1df, #3eaad6);
}

.register .twitter a {
	background: url(../images/logo_twitter_38x32.png) no-repeat 6% 25%;
}
</style>
  </head>

  <body>
  

     <div class="main">
      <div class="one">
        <div class="register">
          <h3>Post your complaint here..</h3>
          <form id="reg-form">
            <div>
              <label for="subject">Subject</label>
              <input type="text" id="subject" spellcheck="false" placeholder="Enter complaint subject here"/>
             
            </div>
            <div>
              <label for="subject_dec">
              Description</label>
              <input type="text" id="subject_des" spellcheck="false" placeholder="Describe your complaint here"/>
            </div>
           
            
            
              <label></label>
              <input type="submit" value="submit" id="submit" class="button"/>
            </div>
          </form>
    <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>

        <!-- <script src="js/index.js"></script> -->

    
    
    
  </body>
</html>
