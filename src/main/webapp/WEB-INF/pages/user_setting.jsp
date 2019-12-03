<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <title>User Setting</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,700" rel="stylesheet">
    <!-- Bulma Version 0.8.x-->
    <link rel="stylesheet" href="/node_modules/bulma/css/bulma.css" />
    <link rel="stylesheet" type="text/css" href="/css/admin.css">
</head>

<body>

<!-- START NAV -->
<jsp:include page="../../../resources/static/header.html"/>
<!-- END NAV -->
<div class="container">
    <div class="columns">
        <div class="column is-3 ">
            <!-- START MENU-->
            <jsp:include page="../../../resources/static/menu.html"/>
            <!-- END MENU-->
        </div>
        <div class="column is-9">

        </div>
    </div>
</div>
<script async type="text/javascript" src="/js/bulma.js"></script>
<script type="text/javascript" src="/js/register.js"></script>
<script type="text/javascript" src="/js/user.js"></script>
<script type="text/javascript" src="/node_modules/jquery/dist/jquery.js"></script>
<script type="text/javascript" src="/node_modules/axios/dist/axios.js"></script>
</body>
<script>
    $('.setting').addClass("is-active");
    getInfo().then(res=>{
        console.log(res);
    }).catch(err=>{
        console.log(err);
    })
</script>
</html>