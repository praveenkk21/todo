<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <link href="/webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
        <title>Login</title>
    </head>
    <body>
    <div class="container">
        <div>
            <h1>Welcome ${username} </h1>
         </div>
        <hr>
        <div>
            <h4><i>Your ToDos are</i></h4>
        </div>
        <table class="table">
        <thead>
            <tr>
                <th>id</th>
                <th>Name</th>
                <th>Course</th>
                <th>Is Done?</th>
                <th>Update</th>
                <th>Delete</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${Todo}" var="Todo">
            <tr>
                <td>${Todo.id}</td>
                <td>${Todo.username}</td>
                <td>${Todo.course}</td>
                <td>${Todo.done}</td>
                <td>
                    <a href="update-todo?id=${Todo.id}" class="btn btn-success">Update</a>
                </td>
                <td>
                    <a href="delete-todo?id=${Todo.id}" class="btn btn-warning">Delete</a>
                </td>
            </tr>
            </c:forEach>
         </tbody>
        </table>
        <pre>${EmptyMessage}</pre>
         <a href="add-todo" class="btn btn-success">Add ToDo</a>
      </div>
         <script src="webjars/jquery/3.6.0/jquery.min.js"></script>
         <script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
    </body>
</html>