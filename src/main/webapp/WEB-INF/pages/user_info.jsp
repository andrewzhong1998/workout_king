<!DOCTYPE html>
<html>

<head>
    <link rel="stylesheet" href="node_modules/bulma/css/bulma.css" />
    <link rel="stylesheet" href="css/user_info.css" />
    <title>User Information</title>
</head>

<body>
<section class="hero is-medium has-text-centered" id="headBanner">
    <div class="hero-body">
        <div class="container">
                <span class="title infoTitleText">
                    Update Personal Information!!!
                </span>
            <br><span class="subtitle infoTitleText">
                    Please complete or update before using the app!
                </span>
        </div>
    </div>
</section>

<section class="section">
    <div class="container">
        <div class="tabs is-medium is-centered is-boxed is-toggle">
            <ul>
                <li class="is-active" id = "genderTab"><a>Gender</a></li>
                <li id = "heightTab"><a>Height</a></li>
                <li id = "weightTab"><a>Weight</a></li>
                <li id = "targetTab"><a>Target Weight</a></li>
                <li id = "allergiesTab"><a>Food Allergies</a></li>
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
            <script src="js/user_info.js" type="module"></script>
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

<!-- <div class="userInput">
    <section class="box columns" id="GenderSelector">
        <div class="tile column"></div>
        <div class="tile">
            <h1 class="header">
                Gender:
            </h1>
            <div class=>
                <label class="">
                    <br><input type="checkbox" id="Male">
                    Male
                    <br><input id="Female" type="checkbox">
                    Female
                    <br><input id="Other" type="checkbox">
                    Other
                    <br><input id="Skip" type="checkbox">
                    Prefer Not To Answer
                </label>
            </div>
        </div>
        <div class="tile column"></div>
    </section>

    <section class="box columns" id="HeightSelector">
        <div class="tile column"></div>
        <div>
            <div class="field">
                <label class="header">Height</label>
                <div class="control">
                    <input class="input" type="text" placeholder="Inches" id="endTime">
                </div>
            </div>
        </div>
        <div class="tile column"></div>
    </section>

    <section class="box columns" id="WeightSelector">
        <div class="tile column"></div>
        <div>
            <div class="field">
                <label class="header">Weight</label>
                <div class="control">
                    <input class="input" type="text" placeholder="Pounds" id="endTime">
                </div>
            </div>
        </div>
        <div class="tile columns"></div>
    </section>

    <section class="box columns" id="TargetWeight">
        <div class="tile column"></div>
        <div>
            <div class="field">
                <label class="header">Target Weight</label>
                <div class="control">
                    <input class="input" type="text" placeholder="Pounds" id="endTime">
                </div>
            </div>
        </div>
        <div class="tile column"></div>
    </section>

    <section class="box columns" id="AllergiesSelector">
        <div class="tile column"></div>
        <div>
            <h1 class="header">Food Allergies</h1>
            <div class="">
                <label class="">
                    <br><input type="checkbox" id="Nut">
                    Peanut
                    <br><input id="Vege" type="checkbox">
                    Vegetarian
                    <br><input id="Vegan" type="checkbox">
                    Vegan
                    <br><input id="Eyup" type="checkbox">
                    Lactose Intolerant
                    <br><input id="SkipDiet" type="checkbox">
                    Prefer Not To Answer
                </label>
            </div>
        </div>
        <div class="tile column"></div>
    </section>
</div> -->

<section class="section">
    <div class="container" id="buttonFloat">
        <div class="button navigationButton is-outlined" id="finishedUserInfo">
            <a href="index.html">
                <p id="buttonText">
                    Look At Your Daily Overview!!
                </p>
            </a>
        </div>
    </div>
</section>
</body>
</html>