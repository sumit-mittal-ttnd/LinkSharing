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
<div class="container">


    <g:render template="/shared/header"/>


    <div class="row">
        <table class="table">
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
                <g:each var="user" in="${usersList}" status="i">
                    <g:set var="classInfo" value="${ (i % 2) == 0 ? 'success' : 'info'}"/>
                    <tr class="${classInfo}">
                        <td>${user.id}</td>
                        <td>${user.userName}</td>
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
</body>
</html>