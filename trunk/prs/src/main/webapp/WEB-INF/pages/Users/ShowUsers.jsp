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
          
            <h1>Users</h1>
            <p>These are the users in the database. These represent just a user entity for testing purposes<br/>
            These will eventually be used as login authentication credentials moving forward.</p>
      
            <table class="table table-hover">
		<th>Number</th>
		<th>User name</th>
		<th>Action</th>
			
		<c:forEach items="${users}" var="user" varStatus="counter">			
			<tr>
                            <td><c:out value="${counter.count}"></c:out></td>
                            <td><c:out value="${user.getUsername()}"></c:out></td>
                            <c:url value="/User/Delete/${user.getUsername()}" var="deleteURL"/>
                            <td><a href="${deleteURL}"> Delete </a></td>
			</tr>
		</c:forEach>
            </table>
            <c:url value="/User/ShowAddUser" var="createUserURL"/>
            <a class="btn btn-primary" href="${createUserURL}">Create new user</a>
         
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