<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <c:url value="/themes" var="themeURLBase"/>	
    <link rel="stylesheet" href="${themeURLBase}/<spring:theme code='stylesheet'/>" type="text/css" />
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

    <div class="container-fluid">
      <div class="row-fluid">
          
        <div class="span3">
          <c:import url="/Navigation/NavMenu"></c:import> 
        </div>
        
        <div class="span9">          
            
            <!-- Title: What is the Characteristic? -->
            <!-- Description: Give a description of what this characteristic is all about -->
            <c:url value="/Product/add/characteristic/${productID}" var="AddProductCharacteristicURL"/>
            <form:form modelAttribute="FormProductCharacteristic" action="${AddProductCharacteristicURL}" method="post">
                <fieldset>
                    <legend>Add product characteristic</legend>    
                    <div class="span9">
                        <form:label for="title" path="title">Title</form:label>
                        <form:input id="char_title" type="text" path="title" />  
                            <span class="help-block">Name or title for this characteristic</span>
                        <form:label for="description" path="description">Description</form:label>
                        <form:input type="text" path="description" />
                            <span id="char_description" class="help-block"> What is specific aspect of the characteristic ? Give a description eg. Its affects the usability, style, robustness etc....</span> 
                        <form:label for="review" path="review">Review</form:label>
                        <form:textarea class="default boxsizingBorder" path="review"/>
                            <span class="help-block">Go ahead, provide your take on this aspect of the ${product.getTitle()}. </span>                      
                    </div>
                </fieldset> 
                <input type="submit" value="add" class="btn" />
                </form:form>
        </div><!--/span-->
      </div><!--/row-->
      <hr>
      <footer>
        <p>� R3 2013</p>
      </footer>

    </div><!--/.fluid-container-->

    <!-- Le javascript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="http://code.jquery.com/jquery.js"></script>
    <script src="${themeURLBase}/bootstrap/js/bootstrap.min.js"></script>
    <script>
    $(document).ready(function(){
        
        // set the default focus for this page
        $('#char_title').focus();
       
        // update the descriptin of the aspect to describe on title focus loss
        $('#char_title').focusout(function() { 
            message = 'What is the aspect of the '+$('#char_title').val().toLowerCase()+' that you would like to describe? Give a short description.';             
            $('#char_description').text(message);
        });

    });
    
    
    </script>
        

  

</body>

</html>