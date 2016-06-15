<!DOCTYPE html>
<html lang="en">
<head>
    <meta name="layout" content="main"/>
    <meta charset="UTF-8">
    <title>Dashboard</title>

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

        <g:render template="/shared/profile"/>

        <g:render template="/shared/inbox"/>

        <g:render template="/shared/subscription"/>

        <g:render template="/shared/trendingTopics"/>

    </div>
</div>
</body>
</html>