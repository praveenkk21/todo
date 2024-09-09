<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
    <head>
        <link href="/webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
        <title>Add ToDo</title>
    </head>
    <body>
    <div class="container">
        <div>
            <h1>Enter the ToDo</h1>
        </div>
            <form:form method="post" modelAttribute="Todo">
                Course: <form:input path="course" required="required"/>
                <form:errors path="course" cssClass="text-warning"/>
                <form:input path="id" type="hidden"/>
                <form:input path="done" type="hidden"/><br><br>
                <input type="submit" class="btn btn-success"/>
                <a href="javascript:history.back()" class="btn btn-primary">Go Back</a>
            </form:form>
    </div>
         <script src="webjars/jquery/3.6.0/jquery.min.js"></script>
         <script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
    </body>
</html>