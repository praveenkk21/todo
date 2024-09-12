<%@ include file="common/header.jspf"%>

<%@ include file="common/navigation.jspf"%>

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

<%@ include file="common/footer.jspf" %>

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

