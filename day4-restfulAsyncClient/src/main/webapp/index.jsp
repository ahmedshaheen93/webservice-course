<%@ page import="com.shaheen.Employee" %>
<%@ page import="java.util.List" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>

<div class="container">
    <h2>Test Rest Sync Client</h2>

    <section name="seach by id">
        <div>
            <form action="/client/employee" method="post">
                <label for="empID">enter employee id</label>
                <input type="number" id="empID" name="empID">
                <input type="submit" value="search for employee">
            </form>
        </div>
        <%
            Employee employee = (Employee) request.getAttribute("employee");
            if (employee != null) {
        %>

        <table class="table table-striped table-bordered">
            <thead class="thead-dark">


            <td scope="col">first name</td>
            <td scope="col">last name</td>
            <td scope="col">email</td>
            <td scope="col">phone</td>
            </thead>
            <tbody>
            <tr>
                <td scope="row"><%=employee.getFirstName()%>
                </td>
                <td scope="row"><%=employee.getLastName()%>
                </td>
                <td scope="row"><%=employee.getEmail()%>
                </td>
                <td scope="row"><%=employee.getPhone()%>
                </td>
            </tr>
            </tbody>
        </table>
        <%}%>
    </section>
    <section name="allEmployee">

        <%
            List<Employee> employees = (List<Employee>) request.getAttribute("employees");
            if (employees != null) {
        %>
        <h2>All employees</h2>
        <table class="table table-striped table-bordered" id="table">
            <thead class="thead-dark">


            <td scope="col">first name</td>
            <td scope="col">last name</td>
            <td scope="col">email</td>
            <td scope="col">phone</td>
            </thead>
            <tbody>
            <%for (Employee empl : employees) {%>
            <tr>
                <td scope="row"><%=empl.getFirstName()%>
                </td>
                <td scope="row"><%=empl.getLastName()%>
                </td>
                <td scope="row"><%=empl.getEmail()%>
                </td>
                <td scope="row"><%=empl.getPhone()%>
                </td>
                <td hidden scope="row"><%=empl.getId()%>
                </td>
            </tr>
            <%}%>
            </tbody>
        </table>
        <%}%>
    </section>
    <section>
        <div class="row">


            <div class="col-lg-6">
                <h4>Add new Employee</h4>
                <%
                    if (request.getAttribute("employeeAdded") != null) {%>
                <p style="color: green;">
                    <%System.out.println(request.getAttribute("employeeAdded"));%>
                </p>
                <%
                    }
                %>
                <%
                    if (request.getAttribute("erorrOnAdd") != null) {%>
                <p style="color: red;">
                    <%System.out.println(request.getAttribute("erorrOnAdd"));%>
                </p>
                <%
                    }
                %>
                <form action="/client/newEmployee" method="post">
                    <div class="form-group">
                        <label for="firstName"> first name</label>
                        <input class="form-control" type="text" name="firstName" id="firstName" required>
                    </div>

                    <div class="form-group">
                        <label for="lastName"> lastName</label>
                        <input class="form-control" type="text" name="lastName" id="lastName" required>
                    </div>
                    <div class="form-group">
                        <label for="email"> email</label>
                        <input class="form-control" type="text" name="email" id="email" required>
                    </div>
                    <div class="form-group">
                        <label for="phone"> phone</label>
                        <input class="form-control" type="text" name="phone" id="phone" required>
                    </div>
                    <div class="form-group">
                        <label for="password"> password</label>
                        <input class="form-control" type="text" name="password" id="password" required>
                    </div>
                    <input type="submit">
                </form>
            </div>
            <div class="col-lg-6">
                <h4>Update employee</h4>
                <%
                    String employeeUpdated = (String) request.getAttribute("employeeUpdated");
                    if (employeeUpdated != null) {%>
                <p style="color: green;">
                    <%System.out.println(employeeUpdated);%>
                </p>
                <%
                    }
                %>
                <%
                    if (request.getAttribute("erorrOnUpdate") != null) {%>
                <p style="color: red;">
                    <%System.out.println(request.getAttribute("erorrOnUpdate"));%>
                </p>
                <%
                    }
                %>
                <form action="/client/updateEmployee" method="post">
                    <input type="hidden" id="id" name="id">
                    <div class="form-group">
                        <label for="firstName1"> first name</label>
                        <input class="form-control" type="text" name="firstName" id="firstName1" required>
                    </div>

                    <div class="form-group">
                        <label for="lastName1"> lastName</label>
                        <input class="form-control" type="text" name="lastName" id="lastName1" required>
                    </div>
                    <div class="form-group">
                        <label for="email1"> email</label>
                        <input class="form-control" type="text" name="email" id="email1" required>
                    </div>
                    <div class="form-group">
                        <label for="phone1"> phone</label>
                        <input class="form-control" type="text" name="phone" id="phone1" required>
                    </div>
                    <div class="form-group">
                        <label for="password1"> password</label>
                        <input class="form-control" type="password" name="password" id="password1" required>
                    </div>
                    <input type="submit">
                </form>
            </div>
        </div>
    </section>
</div>
<script>
    var table = document.getElementById('table');

    for (var i = 1; i < table.rows.length; i++) {
        table.rows[i].onclick = function () {
            //rIndex = this.rowIndex;
            document.getElementById("firstName1").value = this.cells[0].innerHTML.trim();
            document.getElementById("lastName1").value = this.cells[1].innerHTML.trim();
            document.getElementById("email1").value = this.cells[2].innerHTML.trim();
            document.getElementById("phone1").value = this.cells[3].innerHTML.trim();
            document.getElementById("id").value = this.cells[4].innerHTML.trim();

        };
    }

</script>
</body>
</html>
