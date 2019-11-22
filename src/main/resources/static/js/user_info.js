let tabCounter = 0;

let genderSelect = (
    `<div class="userInput">
    <section class="box columns" id="GenderSelector">
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
    </section>
    </div>`
);

let heightSelect = (
    `<div class="userInput">
    <section class="box columns" id="HeightSelector">
            <div>
                <div class="field">
                    <label class="header">Height</label>
                    <div class="control">
                        <input class="input" type="text" placeholder="Inches" id="endTime">
                    </div>
                </div>
            </div>
        </section>
    </div>`
);

let weightSelect = (
    `<div class="userInput">
    <section class="box columns" id="WeightSelector">
            <div>
                <div class="field">
                    <label class="header">Weight</label>
                    <div class="control">
                        <input class="input" type="text" placeholder="Pounds" id="endTime">
                    </div>
                </div>
            </div>
        </section>
        </div>`
);

let targetWeight = (
    `<div class="userInput">
    <section class="box columns" id="TargetWeight">
            <div>
                <div class="field">
                    <label class="header">Target Weight</label>
                    <div class="control">
                        <input class="input" type="text" placeholder="Pounds" id="endTime">
                    </div>
                </div>
            </div>
        </section>
        </div>`
);

let allergiesSelect = (
    `<div class="userInput">
    <section class="box columns" id="AllergiesSelector">
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
        </section>
        </div>`
);

let tabs = [genderSelect, heightSelect, weightSelect, targetWeight, allergiesSelect];

export const loadUserInfoPage = function() {
    const $root = $('#root');

    let addition = genderSelect;

    $root.append(addition);

    $("#rightArrow").on( "click", handleRightButton);
    $("#leftArrow").on( "click", handleLeftButton);
    $("#weightTab").on( "click", handleWeightTab);
    $("#heightTab").on( "click", handleHeightTab);
    $("#genderTab").on( "click", handleGenderTab);
    $("#allergiesTab").on( "click", handleAllergiesTab);
    $("#targetTab").on( "click", handleTargetTab);
}

export const handleWeightTab = function(event) {
    $(".userInput").replaceWith(tabs[2]);
}

export const handleHeightTab = function(event) {
    $(".userInput").replaceWith(tabs[1]);
}

export const handleGenderTab = function(event) {
    $(".userInput").replaceWith(tabs[0]);
}

export const handleTargetTab = function(event) {
    $(".userInput").replaceWith(tabs[3]);
}

export const handleAllergiesTab = function(event) {
    $(".userInput").replaceWith(tabs[4]);
}

export const handleRightButton = function(event) {
    if(tabCounter + 1 >= tabs.length){
        return;
    }
    tabCounter++;
    $(".userInput").replaceWith(tabs[tabCounter]);
}

export const handleLeftButton = function(event) {
    if(tabCounter - 1 < 0){
        return;
    }
    tabCounter--;
    $(".userInput").replaceWith(tabs[tabCounter]);
}

$(function() {
    loadUserInfoPage();
})
