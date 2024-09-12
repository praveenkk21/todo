<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
    <head>
        <link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
        <link href="webjars/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker3.min.css" rel="stylesheet">
        <title>Add ToDo</title>
    </head>
    <body>
    <div class="container">
        <div>
            <h1>Enter the ToDo</h1>
        </div>
            <form:form method="post" modelAttribute="Todo">
            <fieldset class="mb-3">
                <form:label path="username">Name</form:label>
                <form:input type="text" path="username" id="username"/>
                <form:errors path="username" cssClass="text-warning"/>
            </fieldset>
            <fieldset class="mb-3">
                <form:label path="course">Course</form:label>
                <form:input type="text" path="course" required="required"/>
                <form:errors path="course" cssClass="text-warning"/>
            </fieldset>
            <fieldset class="mb-3">
                <form:label path="date">Date</form:label>
                <form:input path="date" type="text" class="datepicker"/>
            </fieldset>
                <form:input path="id" type="hidden"/>
                <form:input path="done" type="hidden"/>
                <input type="submit" class="btn btn-success"/>
                <a href="javascript:history.back()" class="btn btn-primary">Go Back</a>
            </form:form>
    </div>
         <script src="webjars/jquery/3.6.0/jquery.min.js"></script>
         <script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
         <script src="webjars/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.min.js"></script>
         <script type="text/javascript">
                $('#date').datepicker({
                    format: 'yyyy-mm-dd'
                });
         </script>
          <script type="text/javascript">
              window.onload = function() {
                  var addLoggedUser = <%= (request.getAttribute("addLoggedUser") != null && (Boolean) request.getAttribute("addLoggedUser")) %>;

                  if (addLoggedUser) {
                      document.getElementById("username").disabled = true;
                  }
              };
          </script>
    </body>
</html>