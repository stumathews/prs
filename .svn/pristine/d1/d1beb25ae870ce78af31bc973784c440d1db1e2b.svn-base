<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <c:url value="/themes" var="themeURLBase"/>	
    <!-- <link rel="stylesheet" href="${themeURLBase}/<spring:theme code='stylesheet'/>" type="text/css" /> -->
    <link rel="stylesheet" href="${themeURLBase}/bootstrap/css/bootstrap.min.css" media="screen">
    <link rel="stylesheet" href="${themeURLBase}/bootstrap/css/bootstrap-responsive.css">
    <style>
      body {
        padding-top: 60px; /* 60px to make the container go all the way to the bottom of the topbar */
      }
    </style>
</head>
<body>
<c:import url="/Navigation/TopMenu"></c:import>
<div class="container">
  <div class="row">
    <div class="span3">          
        <c:import url="/Navigation/NavMenu"></c:import>          
    </div>
    <div class="span1"></div>
    <div class="span9">
        <div class="row">                
            <div class="span2">
                <img class="img-polaroid" src="${product.getImageURL()}"/>                
            </div>
            <div class="span6">                    
                <strong>Title: </strong>${product.getTitle()}<br/>
                <strong>Who made it: </strong>${product.getWhoMadeIt()}<br/>
                <strong>What it is: </strong>${product.getWhatIsIt()}<br/>                                       
            </div>
        </div>
        <br/>
        <div class="row">                
            <div class="span8">                    
                Content Goes here
            </div>                     
        </div>



    </div><!--/span-->
  </div><!--/row-->

  <hr>

  <footer>
    <p>© Recommendations, Reviews and Reviews 2013</p>
  </footer>

</div><!--/.fluid-container-->

<!-- Le javascript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="http://code.jquery.com/jquery.js"></script>
<script src="${themeURLBase}/bootstrap/js/bootstrap.min.js"></script>
<script>
   
    $( document ).ready(function(){        
       $('#characteristicTabs a:first').tab('show');  
    });

</script>
  

</body>

</html>