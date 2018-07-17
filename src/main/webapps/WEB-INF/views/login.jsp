<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <title>Login</title>

    <!-- start: CSS -->
    <link href="../static/css/bootstrap.min.css" rel="stylesheet" />
    <link href="../static/css/bootstrap-responsive.min.css" rel="stylesheet" />
    <link href="../static/css/style.min.css" rel="stylesheet" />
    <link href="../static/css/style-responsive.min.css" rel="stylesheet" />
    <link href="../static/css/retina.css" rel="stylesheet" />
    <!-- end: CSS -->


    <!-- start: Favicon and Touch Icons -->
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="../static/ico/apple-touch-icon-144-precomposed.png" />
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="../static/ico/apple-touch-icon-114-precomposed.png" />
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="../static/ico/apple-touch-icon-72-precomposed.png" />
    <link rel="apple-touch-icon-precomposed" href="../static/ico/apple-touch-icon-57-precomposed.png" />
    <link rel="shortcut icon" href="../static/ico/favicon.png" />
    <!-- end: Favicon and Touch Icons -->

    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>

<body>
<div class="container-fluid-full">
    <div class="row-fluid">

        <div class="row-fluid">
            <div class="login-box">
                <h2>Login to your account</h2>
                <form class="form-horizontal" action="index.html" method="post" />
                <fieldset>

                    <input class="input-large span12" name="username" id="username" type="text" placeholder="type username" />

                    <input class="input-large span12" name="password" id="password" type="password" placeholder="type password" />

                    <div class="clearfix"></div>

                    <label class="remember" for="remember"><input type="checkbox" id="remember" />Remember me</label>

                    <div class="clearfix"></div>

                    <button type="submit" class="btn btn-primary span12">Login</button>
                </fieldset>

                </form>
                <hr />
                <h3>Forgot Password?</h3>
                <p>
                    No problem, <a href="#">click here</a> to get a new password.
                </p>
            </div>
        </div><!--/row-->

    </div><!--/fluid-row-->

</div><!--/.fluid-container-->


</body>
</html>