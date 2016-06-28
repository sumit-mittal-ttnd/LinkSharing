<!DOCTYPE html>
<html lang="en">
<head>
    <meta name="layout" content="main"/>
    <meta charset="UTF-8">
    <title>Users</title>

    <style>
    .tab-space {
        padding-left: 10px
    }
    </style>
</head>

<body>
<div class="container bodyMinHeight">

    <g:render template="/shared/header"/>

    <div class="row">
        <div class="col-xs-12" style="font-size: 24px;">
            <center>  <strong>Users List</strong> </center>
        </div>
    </div><br/>

    <div class="row">
        <table id="userListTable" class="display">
            <thead>
            <tr>
                <th>Id</th>
                <th>UserName</th>
                <th>Email</th>
                <th>FirstName</th>
                <th>LastName</th>
                <th>Active</th>
                <th>Manage</th>
            </tr>
            </thead>
            <tbody>
            <g:each var="user" in="${usersList}">
                <tr>
                    <td>${user.id}</td>
                    <td><g:link action="showUser" controller="login" params="[userId:user.id]">${user.userName}</g:link></td>
                    <td>${user.email}</td>
                    <td>${user.firstName}</td>
                    <td>${user.lastName}</td>
                    <td>  ${user.active ? 'YES' : 'NO'}</td>
                    <td><g:link action="activate" controller="user" params="[activateUser:user.active?'false':'true', userId:user.id]">${user.active ? 'Deactivate' : 'Activate'}</g:link></td>
                </tr>
            </g:each>
            </tbody>
        </table>
    </div>
</div>
<script>
    $(document).ready( function () {
        $('#userListTable').DataTable({
            "order": [[ 1, "asc" ]]
        });
    } );
</script>
</body>
</html>