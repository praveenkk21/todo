<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
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
        <th>Date</th>
        <th>Is Done?</th>
        <th></th>
        <th></th>
    </tr>
</thead>
<tbody>
    <c:forEach items="${Todo}" var="Todo">
    <tr>
        <td>${Todo.id}</td>
        <td>${Todo.username}</td>
        <td>${Todo.course}</td>
        <td>${Todo.date}</td>
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

 <!-- Form for adding new ToDos -->
             <form action="add-todo" method="GET">
                 <button type="submit" class="btn btn-success mr-3">Add ToDo</button>

                 <div class="form-check">
                     <input class="form-check-input" type="checkbox" name="addLoggedUser" id="defaultCheck1" checked>
                     <label class="form-check-label" for="defaultCheck1">
                         Add with Logged User
                     </label>
                 </div>
             </form>


</div>
         <script type="text/javascript">
                 $('#date').datepicker({
                     format: 'mm-dd-yyyy'
                 });
          </script>
<%@ include file="common/footer.jspf"%>