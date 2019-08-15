<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html lang="en">
<head>
<meta charset="UTF-8">

<title>Log in with your account</title>

<meta http-equiv="Content-Type" content="text/html" charset=UTF-8>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="shortcut icon" th:href="@{image/caridade.ico}" />
<link href="css/bootstrap.css" rel="stylesheet" />
<link href="dist/jquery.bootgrid.css" rel="stylesheet" />
<link href="css/menu-customer.css" rel="stylesheet" />
<script type="text/javascript" src="js/moderniz.2.8.1.js"></script>

</head>

  <body>

    <div class="container">
      <form method="POST" action="${contextPath}/login" class="form-signin">
        <h2 class="form-heading">Log in</h2>

        <div class="form-group ${error != null ? 'has-error' : ''}">
            <span>${message}</span>
            <input name="username" type="text" class="form-control" placeholder="Username"
                   autofocus="true"/>
            <input name="password" type="password" class="form-control" placeholder="Password"/>
            <span>${error}</span>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

            <button class="btn btn-lg btn-primary btn-block" type="submit">Log In</button>
            <h4 class="text-center"><a href="${contextPath}/registration">Create an account</a></h4>
        </div>
      </form>
    </div>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="${contextPath}/resources/js/bootstrap.min.js"></script>
  </body>
</html>
