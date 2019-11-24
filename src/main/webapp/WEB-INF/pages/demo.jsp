<!DOCTYPE html>
<html>

<head>
    <link rel="stylesheet" href="node_modules/bulma/css/bulma.css" />
    <link rel="stylesheet" href="css/demo.css" />
    <title>workout_demo</title>
</head>

<body>
<section class="hero is-medium has-text-centered" id="titleBanner">
    <div class="hero-body">
        <div class="container">
                <span class="title demoTitleText">
                    Daily Calorie Overview!!
                </span>
            <br><span class="subtitle demoTitleText">
                    Below are your dietary history and status!!
                </span>
        </div>
    </div>
</section>

<section class="section">
    <div class="container">
        <div class="tabs is-medium is-centered is-boxed is-toggle">
            <ul>
                <li class = "is-active" id = "calorieTab"><a>Daily Calorie Count</a></li>
                <li id = "nutrientTab"><a>Daily Macronutrient Count</a></li>
                <li id = "weightTab"><a>Weight Progress</a></li>
                <li id = "exerciseTab"><a>Exercise Counter</a></li>
                <li id = "personalTab"><a>Personal Information</a></li>
            </ul>
        </div>
    </div>
</section>

<div class="tile is-parent box section columns">
    <div class="tile is-child column outerArrow">
        <div class = "innerArrow">
            <label class="arrowNavi button" id = "leftArrow">
                <h1>&larr;</h1>
            </label>
        </div>
    </div>
    <div class="tile is-child column">
        <div id="root">
            <script src="js/demo.js" type="module"></script>
            <script src="node_modules/jquery/dist/jquery.js"></script>
        </div>
    </div>
    <div class="tile is-child column outerArrow">
        <div class = "innerArrow">
            <label class="arrowNavi button" id = "rightArrow">
                <h1>&rarr;</h1>
            </label>
        </div>
    </div>
</div>

<section class="section">
    <div class="container" id="buttonFloat">
        <div class="button navigationButton is-outlined" id="finishedUserInfo">
            <a href="index.html">
                <p id="buttonText">
                    Back To The Home Screen!!
                </p>
            </a>
        </div>
    </div>
</section>

</body>
</html>