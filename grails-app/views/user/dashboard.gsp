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


    <g:render template="/shared/header"/>


    <div class="row">

        <g:render template="/user/profileSummary"/>

        <g:render template="/resource/inbox"/>

        <g:render template="/subscription/subscription"/>

        <g:render template="/shared/trendingTopics"/>

    </div>
</div>
</body>
</html>