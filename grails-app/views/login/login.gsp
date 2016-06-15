<!DOCTYPE html>
<html lang="en">
<head>
    <meta name="layout" content="main"/>
    <meta charset="UTF-8">
    <title>Link Sharing App</title>

    <style>
    .tab-space {
        padding-left: 10px
    }
    </style>
</head>

<body>
<div class="container">


    <g:render template="/shared/headerTemplate"/>


    <div class="row">

        <g:render template="/shared/RecentSharedTemplate"/>

        <g:render template="/shared/LoginTemplate"/>

        <g:render template="/shared/RegisterTemplate"/>

        <g:render template="/shared/topPostTemplate"/>

    </div>
</div>
</body>
</html>