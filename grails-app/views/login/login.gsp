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


    <g:render template="/shared/header"/>


    <div class="row">

        <g:render template="/resource/RecentShared"/>

        <g:render template="/login/Login"/>

        <g:render template="/shared/Register"/>

        <g:render template="/resource/topPost"/>

    </div>
</div>
</body>
</html>