<!DOCTYPE html>
<html>

<head>
    <link rel="stylesheet" href="node_modules/bootstrap/dist/css/bootstrap.min.css" />
    <link rel="stylesheet" href="css/login.css"/>
    <script type="text/javascript" src="node_modules/jquery/dist/jquery.js"></script>
    <script type="text/javascript" src="js/register.js"></script>
    <script type="text/javascript" src="node_modules/axios/dist/axios.js"></script>
    <title>workout_king</title>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
            <div class="card card-signin my-5">
                <div class="card-body">
                    <h5 class="card-title text-center">Log In</h5>
                    <div class="form-signin">
                        <div class="form-label-group">
                            <input type="email" id="inputEmail" class="form-control" placeholder="Email address" required autofocus>
                            <label for="inputEmail">Email address</label>
                        </div>
                        <div class="form-label-group">
                            <input type="password" id="inputPassword" class="form-control" placeholder="Password" required>
                            <label for="inputPassword">Password</label>
                        </div>
                        <div class="custom-control custom-checkbox mb-3">
                            <input type="checkbox" class="custom-control-input" id="customCheck1">
                            <label class="custom-control-label" for="customCheck1">Remember password</label>
                        </div>
                        <button class="btn btn-lg btn-primary btn-block text-uppercase" id="buttonLogin">Log In</button>
                        <button class="btn btn-lg btn-primary btn-block text-uppercase" id="buttonSignup">Sign up</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
<script>
    $('#buttonSignup').on('click',function(){
        location.href = 'signup';
    })
    $('#buttonLogin').on('click',function(){
        let email = $('#inputEmail').val();
        let password = $('#inputPassword').val();
        let remember = $('#customCheck1').prop('checked');
        if(!isValidEmail(email)){
            alert('Email not valid');
            return false;
        }
        if(password.length<8){
            alert('Password not valid');
            return false;
        }
        login(email,password,remember).then(res=>{
            console.log(res.data);
            let status = res.data.status;
            //if(status) location.href = "/";
            //else alert('Error');
        }).catch(err=>{
            console.log(err);
        })
    })
</script>
</html>