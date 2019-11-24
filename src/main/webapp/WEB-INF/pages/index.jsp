<!DOCTYPE html>
<html>

<head>
    <link rel="stylesheet" href="node_modules/bulma/css/bulma.css" />
    <link rel="stylesheet" href="css/custom_style.css" />
    <script type="text/javascript" src="js/diet.js"></script>
    <script type="text/javascript" src="node_modules/jquery/dist/jquery.js"></script>
    <script type="text/javascript" src="node_modules/axios/dist/axios.js"></script>
    <title>workout_king</title>
</head>

<body>
<nav class="navbar" role="navigation" aria-label="main navigation">
    <div class="navbar-brand">
        <a class="navbar-item">
            <img id="logo" src="image/wk_title.png" width="112" height="40">
        </a>

        <a role="button" class="navbar-burger burger" aria-label="menu" aria-expanded="false"
           data-target="navbarBasicExample">
            <span aria-hidden="true"></span>
            <span aria-hidden="true"></span>
            <span aria-hidden="true"></span>
        </a>
    </div>

    <div id="navbarBasicExample" class="navbar-menu">
        <div class="navbar-start">
            <a class="navbar-item">
                Home
            </a>

            <a class="navbar-item">
                Documentation
            </a>

            <div class="navbar-item has-dropdown is-hoverable">
                <a class="navbar-link">
                    More
                </a>

                <div class="navbar-dropdown">
                    <a class="navbar-item">
                        About
                    </a>
                    <a class="navbar-item">
                        Jobs
                    </a>
                    <a class="navbar-item">
                        Contact
                    </a>
                    <hr class="navbar-divider">
                    <a class="navbar-item">
                        Report an issue
                    </a>
                </div>
            </div>
        </div>

        <div class="navbar-end">
            <div class="navbar-item">
                <div class="buttons">
                    <a class="button is-rounded is-inverted" id="login" href="login">
                        Log In or Sign Up!!
                    </a>
                </div>
            </div>
        </div>
    </div>
</nav>
<section class="hero is-primary is-medium has-text-centered" id="bannerTitle">
    <div class="hero-body">
        <div class="container" id="titleText">
            <h1 class="title bannerTitleText">
                Calorie Calculator!!!
            </h1>
            <h2 class="subtitle bannerTitleText">
                Choose Your Food Items Below!!!
            </h2>
        </div>
    </div>
</section>

<section class="section" id="appDescription">
    <div class="container">
        <div class="content">
            <h1 class="title">Why Use Calorie Calculator</h1>
            <div class=>
                <blockquote>
                    <div class="blockTextClass">
                        <p id="blockText">
                            "I used Calorie Calculator, and I have lost over 30 pounds!!"
                        </p>
                    </div>
                </blockquote>
                <p>
                    We know that it can be hard to eat healthy and maintain a good lifestyle.
                    Well, Calorie Calculator makes that easy since we can keep track of everything
                    that you eat and tell you exactly what you are putting into your body.
                </p>
            </div>
        </div>
    </div>
</section>

<section class="section" id="calculator">
    <div class="columns is-multiline">
        <div class="column">

        </div>
        <div class="column">
            <h3 id="instruction1">
                What Did You Eat Today :)
            </h3>
            <div class="dropdown is-active" id="menu">
                <div class="dropdown-trigger">
                    <button class="button is-primary is-outlined is-rounded" aria-haspopup="true" aria-controls="dropdown-menu">
                        <span>Dropdown button</span>
                        <span class="icon is-small">
                <i class="fas fa-angle-down" aria-hidden="true"></i>
              </span>
                    </button>
                </div>
                <div class="dropdown-menu" id="dropdown-menu" role="menu">
                    <div class="dropdown-content">
                        <a href="#" class="dropdown-item">
                            Apple
                        </a>
                        <a class="dropdown-item">
                            Banana
                        </a>
                        <a href="#" class="dropdown-item is-active">
                            Corn
                        </a>
                        <a href="#" class="dropdown-item">
                            Egg
                        </a>
                        <a href="#" class="dropdown-item">
                            Grape
                        </a>
                    </div>
                </div>
            </div>
        </div>
        <div class="column">
            <h3 id="instruction2">
                Enter The Amount!
            </h3>
            <div>
                <input class="is-primary input is-rounded is-info" type="text" placeholder="Enter Serving Amount" id="input_amount">
            </div>
        </div>
        <div class="column">

        </div>
    </div>
</section>

<section class="section">
    <div class="container" style="padding:100px 20px 50px 20px">
        <div class ="button navigationButton is-primary is-rounded is-outlined" id="demoButton">
            <a id="demoLink" href="demo.html">
                <p id="buttonText">
                    Look At Your Daily Overview!!
                </p>
            </a>
        </div>
    </div>
</section>

<section class="section" id="pictures">
    <div class="columns">
        <div class="img__wrap column is-food">
            <img class="food" src="image/Apple.jpg" alt="Apple" />
            <div class="img__description_layer">
                <p class="img__description">This is an apple.</p>
            </div>
        </div>
        <div class="img__wrap column is-food">
            <img class="food" src="image/banana.png" alt="Banana" />
            <div class="img__description_layer">
                <p class="img__description">This is a banana.</p>
            </div>
        </div>
        <div class="img__wrap column is-food">
            <img class="food" src="image/chicken.png" alt="Chicken" />
            <div class="img__description_layer">
                <p class="img__description">This is a chicken.</p>
            </div>
        </div>
        <div class="img__wrap column is-food">
            <img class="food" src="image/corn.jpg" alt="Corn" />
            <div class="img__description_layer">
                <p class="img__description">This is a corn.</p>
            </div>
        </div>
    </div>
    <div class="columns">
        <div class="img__wrap column is-food">
            <img class="food" src="image/egg.jpg" alt="Egg" />
            <div class="img__description_layer">
                <p class="img__description">This is an apple.</p>
            </div>
        </div>
        <div class="img__wrap column is-food">
            <img class="food" src="image/grape.svg" alt="Grape" />
            <div class="img__description_layer">
                <p class="img__description">This is an apple.</p>
            </div>
        </div>
        <div class="img__wrap column is-food">
            <img class="food" src="image/lettuce.png" alt="Lettuce" />
            <div class="img__description_layer">
                <p class="img__description">This is an apple.</p>
            </div>
        </div>
        <div class="img__wrap column is-food">
            <img class="food" src="image/nuts.png" alt="Nuts" />
            <div class="img__description_layer">
                <p class="img__description">This is an apple.</p>
            </div>
        </div>
    </div>
    <div class="columns">
        <div class="img__wrap column is-food">
            <img class="food" src="image/orange.png" alt="Orange" />
            <div class="img__description_layer">
                <p class="img__description">This is an apple.</p>
            </div>
        </div>
        <div class="img__wrap column is-food">
            <img class="food" src="image/potatoes.jpg" alt="Potatoes" />
            <div class="img__description_layer">
                <p class="img__description">This is an apple.</p>
            </div>
        </div>
        <div class="img__wrap column is-food">
            <img class="food" src="image/rice.png" alt="Rice" />
            <div class="img__description_layer">
                <p class="img__description">This is an apple.</p>
            </div>
        </div>
        <div class="img__wrap column is-food">
            <img class="food" src="image/salmon.png" alt="Salmon" />
            <div class="img__description_layer">
                <p class="img__description">This is an apple.</p>
            </div>
        </div>
    </div>
    <div class="columns">
        <div class="img__wrap column is-food">
            <img class="food" src="image/shrimp.png" alt="Shrimp" />
            <div class="img__description_layer">
                <p class="img__description">This is an apple.</p>
            </div>
        </div>
        <div class="img__wrap column is-food">
            <img class="food" src="image/steak.png" alt="Steak" />
            <div class="img__description_layer">
                <p class="img__description">This is an apple.</p>
            </div>
        </div>
        <div class="img__wrap column is-food">
            <img class="food" src="image/sushi.png" alt="Sushi" />
            <div class="img__description_layer">
                <p class="img__description">This is an apple.</p>
            </div>
        </div>
        <div class="img__wrap column is-food">
            <img class="food" src="image/yogurt.png" alt="Yogur" />
            <div class="img__description_layer">
                <p class="img__description">This is an apple.</p>
            </div>
        </div>
    </div>
    <div class="columns">
        <div class="img__wrap column is-food">
            <img class="food" src="image/Apple.jpg" alt="Apple" />
            <div class="img__description_layer">
                <p class="img__description">This is an apple.</p>
            </div>
        </div>
        <div class="img__wrap column is-food">
            <img class="food" src="image/Apple.jpg" alt="Apple" />
            <div class="img__description_layer">
                <p class="img__description">This is an apple.</p>
            </div>
        </div>
        <div class="img__wrap column is-food">
            <img class="food" src="image/Apple.jpg" alt="Apple" />
            <div class="img__description_layer">
                <p class="img__description">This is an apple.</p>
            </div>
        </div>
        <div class="img__wrap column is-food">
            <img class="food" src="image/Apple.jpg" alt="Apple" />
            <div class="img__description_layer">
                <p class="img__description">This is an apple.</p>
            </div>
        </div>
    </div>
    <div class="columns">
        <div class="img__wrap column is-food">
            <img class="food" src="image/Apple.jpg" alt="Apple" />
            <div class="img__description_layer">
                <p class="img__description">This is an apple.</p>
            </div>
        </div>
        <div class="img__wrap column is-food">
            <img class="food" src="image/Apple.jpg" alt="Apple" />
            <div class="img__description_layer">
                <p class="img__description">This is an apple.</p>
            </div>
        </div>
        <div class="img__wrap column is-food">
            <img class="food" src="image/Apple.jpg" alt="Apple" />
            <div class="img__description_layer">
                <p class="img__description">This is an apple.</p>
            </div>
        </div>
        <div class="img__wrap column is-food">
            <img class="food" src="image/Apple.jpg" alt="Apple" />
            <div class="img__description_layer">
                <p class="img__description">This is an apple.</p>
            </div>
        </div>
    </div>
    <div class="columns">
        <div class="img__wrap column is-food">
            <img class="food" src="image/Apple.jpg" alt="Apple" />
            <div class="img__description_layer">
                <p class="img__description">This is an apple.</p>
            </div>
        </div>
        <div class="img__wrap column is-food">
            <img class="food" src="image/Apple.jpg" alt="Apple" />
            <div class="img__description_layer">
                <p class="img__description">This is an apple.</p>
            </div>
        </div>
        <div class="img__wrap column is-food">
            <img class="food" src="image/Apple.jpg" alt="Apple" />
            <div class="img__description_layer">
                <p class="img__description">This is an apple.</p>
            </div>
        </div>
        <div class="img__wrap column is-food">
            <img class="food" src="image/Apple.jpg" alt="Apple" />
            <div class="img__description_layer">
                <p class="img__description">This is an apple.</p>
            </div>
        </div>
    </div>
    <div class="columns">
        <div class="img__wrap column is-food">
            <img class="food" src="image/Apple.jpg" alt="Apple" />
            <div class="img__description_layer">
                <p class="img__description">This is an apple.</p>
            </div>
        </div>
        <div class="img__wrap column is-food">
            <img class="food" src="image/Apple.jpg" alt="Apple" />
            <div class="img__description_layer">
                <p class="img__description">This is an apple.</p>
            </div>
        </div>
        <div class="img__wrap column is-food">
            <img class="food" src="image/Apple.jpg" alt="Apple" />
            <div class="img__description_layer">
                <p class="img__description">This is an apple.</p>
            </div>
        </div>
        <div class="img__wrap column is-food">
            <img class="food" src="image/Apple.jpg" alt="Apple" />
            <div class="img__description_layer">
                <p class="img__description">This is an apple.</p>
            </div>
        </div>
    </div>
</section>

</body>
<script>
    $(function(){
        getCalories().then(data => {
            console.log(data);
        }).catch(err => {
            console.log(err);
        })
    })
</script>
</html>