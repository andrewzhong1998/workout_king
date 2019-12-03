<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <title>Sign Up</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link href="https://fonts.googleapis.com/css?family=Questrial&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="/node_modules/bulma/css/bulma.css" />
    <link rel="stylesheet" type="text/css" href="/css/login.css">
</head>
<body>
<section class="hero is-success is-fullheight">
    <div class="hero-body">
        <div class="container has-text-centered">
            <div class="column is-4 is-offset-4">
                <h3 class="title has-text-black">Sign Up</h3>
                <hr class="login-hr">
                <div class="box">
                    <figure class="avatar">
                        <img src="https://placehold.it/128x128">
                    </figure>
                    <div>
                        <div class="field">
                            <div class="control">
                                <input id="inputEmail" class="input is-large" type="email" placeholder="Your Email" autofocus="">
                            </div>
                        </div>

                        <div class="field">
                            <div class="control">
                                <input id="inputPassword" class="input is-large" type="password" placeholder="Your Password">
                            </div>
                        </div>

                        <div class="field">
                            <div class="control">
                                <input id="inputConfirm" class="input is-large" type="password" placeholder="Confirm Password">
                            </div>
                        </div>
                        <div class="field">
                            <label class="checkbox">
                                <input id="checkAgree" type="checkbox">Agree to Terms and Conditions
                            </label>
                        </div>
                        <button id="buttonSignup" class="button is-block is-info is-large is-fullwidth">Sign Up <i class="fa fa-sign-in" aria-hidden="true"></i></button>
                    </div>
                </div>
                <p class="has-text-grey">
                    <a href="/login">Login</a>
                </p>
            </div>
        </div>
    </div>
</section>
<script async type="text/javascript" src="/js/bulma.js"></script>
<script type="text/javascript" src="/js/register.js"></script>
<script type="text/javascript" src="/node_modules/jquery/dist/jquery.js"></script>
<script type="text/javascript" src="/node_modules/axios/dist/axios.js"></script>
</body>
<script>
    $('#buttonSignup').on('click',function(){
        let email = $('#inputEmail').val();
        let password = $('#inputPassword').val();
        let confirm = $('#inputConfirm').val();
        if(!isValidEmail(email)){
            alert('Email address not valid');
            return false;
        }
        if(password.length<8){
            alert('Password should consist of at least 8 characters');
            return false;
        }
        if(confirm!=password){
            alert('Passwords not matched');
            return false;
        }
        if(!($('#checkAgree').prop('checked'))){
            alert('Please agree to our Terms and Conditions to proceed');
            return false;
        }
        signup(email,password).then(res=>{
            if(res.data){
                location.href = "/login"
            }
            else{
                alert("Email already exists");
            }
        }).catch(err=>{
            console.log(err);
        })
    })
</script>
</html>