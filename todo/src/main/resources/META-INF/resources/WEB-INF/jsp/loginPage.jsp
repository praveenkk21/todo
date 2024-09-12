<%@ include file="common/header.jspf"%>

<%@ include file="common/navigation.jspf"%>

    <div class="container">
        <h1>Login Page</h1>
        <hr>
        <form method="post">
        Username: <input type="username" name="username"><br><br>
        Password: <input type="password" name="password"><br><br>
        <pre>${errorMessage}</pre>
        <input type="submit" class="btn btn-success">
        </form>
      </div>
      <script src="webjars/jquery/3.6.0/jquery.min.js"></script>
      <script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
    </body>
<%@ include file="common/footer.jspf" %>