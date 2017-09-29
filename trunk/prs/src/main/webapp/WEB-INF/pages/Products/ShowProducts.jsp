<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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

    <div class="container-fluid">
      <div class="row-fluid">
        <div class="span3">
          <c:import url="/Navigation/NavMenu"></c:import> 
        </div><!--/span-->
        <div class="span9">
          
            <h1>Show products</h1>
            <p>These are the products currently in the database.</p>
            
            <table class="table table-hover">	
                <th>Image</th>
                <th>Product Title</th>
                <th>What is it?</th>
                <th>Who made it?</th>                
		<th>Action</th>                
		<c:forEach items="${products}" var="product" varStatus="counter">
                    <c:url var="DeleteURL" value="/Product/Delete/${product.getId()}"/>
                    <c:url var="EditURL" value="/Product/ShowEdit/${product.getId()}"/>
                    <c:url var="ViewProductURL" value="/Product/Show/${product.getId()}"/>
                    <tr>
                        <td class="span1"><img src="${product.getImageURL()}" class="img-polaroid"/></td>
                        <td>
                            <a href="${ViewProductURL}"><c:out value="${product.getTitle()}"></c:out></a>
                        </td>
                        <td><c:out value="${product.getWhatIsIt()}"></c:out></td>
                        <td><c:out value="${product.getWhoMadeIt()}"></c:out></td>                       
                        
                        <td>
                            <ul class="inline">
                            <li><a href="${DeleteURL}">Delete</a> </li>   
                            <li><a href="${EditURL}">Edit</a> </li> 
                            </ul>                                                                  

                        </td>				
                    </tr>
		</c:forEach>
		
	</table>
	<c:url value="/Product/ShowAdd" var="AddProductsURL" />
	<a class="btn btn-primary" href="${AddProductsURL}">Add new product</a>
            
        
        </div><!--/span-->
      </div><!--/row-->

      <hr>

      <footer>
        <p>� Recommendations, Reviews and Reviews 2013</p>
      </footer>

    </div><!--/.fluid-container-->

    <!-- Le javascript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="http://code.jquery.com/jquery.js"></script>
    <script src="${themeURLBase}/bootstrap/js/bootstrap.min.js"></script>

  

</body>

</html>