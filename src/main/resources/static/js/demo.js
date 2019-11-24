let tabCounter = 0;
let DailyCalorie = (
    `<section class = "box demoBox">
        <div class >
            <h1 class = "tabHeader">Calorie Count!!!</h1>
            <br><p>1800/2300</p>
        </div>
    </section>`
);

let DailyNutrient = (
    `<section class = "box demoBox">
        <div class >
            <h1 class = "tabHeader">MacroNutrient Count!!!</h1>
            <br><p>Carbs: </p>
            <br><p>Proteins: </p>
            <br><p>Fat: </p>
        </div>
    </section>`
);

let WeightProgress = (
    `<section class = "box demoBox">
        <div class >
            <h1 class = "tabHeader">Your Past 5 Weeks!!!</h1>
            <br><p>Week 1: </p>
            <br><p>Week 2: </p>
            <br><p>Week 3: </p>
            <br><p>Week 4: </p>
            <br><p>Week 5: </p>
        </div>
    </section>`
);

let ExerciseCounter = (
    `<section class = "box demoBox">
        <div class >
            <h1 class = "tabHeader">Personal Streaks!!!</h1>
            <br><p>Current Streak: </p>
            <br><p>Longest Streak: </p>
        </div>
    </section>`
);

let PersonalInformation = (
    `<section class = "box demoBox">
        <div class >
            <h1 class = "tabHeader">All About You!!!</h1>
            <br><p>Current Weight: </p>
            <br><p>Eating Grade: </p>
            <br><p>Favorite Food: </p>
            <br><p>Check-In: </p>
        </div>
    </section>`
);
let tabs = [DailyCalorie, DailyNutrient, WeightProgress, ExerciseCounter, PersonalInformation];

export const loadDemoPage = function() {
    const $root = $('#root');

    let addition = DailyCalorie;

    $root.append(addition);

    $("#rightArrow").on( "click", handleRightButton);
    $("#leftArrow").on( "click", handleLeftButton);
    $("#calorieTab").on( "click", handleCalorieTab);
    $("#nutrientTab").on( "click", handleNutrientTab);
    $("#weightTab").on( "click", handleWeightTab);
    $("#exerciseTab").on( "click", handleExerciseTab);
    $("#personalTab").on( "click", handlePersonalTab);
}

export const tooMuchWork = function() {
    $('#calorieTab').removeClass("is-active");
    $('#weightTab').removeClass("is-active");
    $('#exerciseTab').removeClass("is-active");
    $('#personalTab').removeClass("is-active");
    $('#nutrientTab').removeClass("is-active");
    if(tabCounter == 0){
        $('#calorieTab').addClass("is-active");
    } else if (tabCounter == 1){
        $('#nutrientTab').addClass("is-active");
    } else if (tabCounter == 2){
        $('#weightTab').addClass("is-active");
    } else if (tabCounter == 3){
        $('#exerciseTab').addClass("is-active");
    } else {
        $('#personalTab').addClass("is-active");
    }
}

export const handleLeftButton = function(event) {
    if(tabCounter - 1 < 0){
        return;
    }
    tabCounter--;
    $(".demoBox").replaceWith(tabs[tabCounter]);
    tooMuchWork();
}

export const handleRightButton = function(event) {
    if(tabCounter + 1 >= tabs.length){
        return;
    }
    tabCounter++;
    $(".demoBox").replaceWith(tabs[tabCounter]);
    tooMuchWork();
}

export const handleCalorieTab = function(event) {
    $(".demoBox").replaceWith(tabs[0]);
    $('#calorieTab').addClass("is-active");
    $('#weightTab').removeClass("is-active");
    $('#exerciseTab').removeClass("is-active");
    $('#personalTab').removeClass("is-active");
    $('#nutrientTab').removeClass("is-active");
    tabCounter = 0;
}

export const handleNutrientTab = function(event) {
    $(".demoBox").replaceWith(tabs[1]);
    $('#calorieTab').removeClass("is-active");
    $('#weightTab').removeClass("is-active");
    $('#exerciseTab').removeClass("is-active");
    $('#personalTab').removeClass("is-active");
    $('#nutrientTab').addClass("is-active");
    tabCounter = 1;
}

export const handleWeightTab = function(event) {
    $(".demoBox").replaceWith(tabs[2]);
    $('#calorieTab').removeClass("is-active");
    $('#weightTab').addClass("is-active");
    $('#exerciseTab').removeClass("is-active");
    $('#personalTab').removeClass("is-active");
    $('#nutrientTab').removeClass("is-active");
    tabCounter = 2;
}

export const handleExerciseTab = function(event) {
    $(".demoBox").replaceWith(tabs[3]);
    $('#calorieTab').removeClass("is-active");
    $('#weightTab').removeClass("is-active");
    $('#exerciseTab').addClass("is-active");
    $('#personalTab').removeClass("is-active");
    $('#nutrientTab').removeClass("is-active");
    tabCounter = 3;
}

export const handlePersonalTab = function(event) {
    $(".demoBox").replaceWith(tabs[4]);
    $('#calorieTab').removeClass("is-active");
    $('#weightTab').removeClass("is-active");
    $('#exerciseTab').removeClass("is-active");
    $('#personalTab').addClass("is-active");
    $('#nutrientTab').removeClass("is-active");
    tabCounter = 4;
}

$(function() {
    loadDemoPage();
})