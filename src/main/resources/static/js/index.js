// Get the <datalist> and <input> elements.
let dataList = document.getElementById('food_list');
let input = document.getElementById('input_food');

// Create a new XMLHttpRequest.
let request = new XMLHttpRequest();

// Handle state changes for the request.
request.onreadystatechange = function(response) {
    if (request.readyState === 4) {
        if (request.status === 200) {
            // Parse the JSON
            let jsonOptions = JSON.parse(request.responseText);

            // Loop over the JSON array.
            jsonOptions.name.forEach(function(item) {
                // Create a new <option> element.
                let option = document.createElement('option');
                // Set the value using the item in the JSON array.
                option.value = item;
                // Add the <option> element to the <datalist>.
                dataList.appendChild(option);
            });

            // Update the placeholder text.
            input.placeholder = "e.g. Apple";
        } else {
            // An error occured :(
            input.placeholder = "Couldn't load datalist options :(";
        }
    }
};

// Update the placeholder text.
input.placeholder = "Loading options...";
// Set up and make the request.
request.open('GET', 'foodName.json', true);
request.send();


let debounce = function(func, wait, immediate) {
    var timeout, args, context, timestamp, result;

    var later = function() {
        // 据上一次触发时间间隔
        var last = _.now() - timestamp;

        // 上次被包装函数被调用时间间隔last小于设定时间间隔wait
        if (last < wait && last > 0) {
            timeout = setTimeout(later, wait - last);
        } else {
            timeout = null;
            // 如果设定为immediate===true，因为开始边界已经调用过了此处无需调用
            if (!immediate) {
                result = func.apply(context, args);
                if (!timeout) context = args = null;
            }
        }
    };

    return function() {
        context = this;
        args = arguments;
        timestamp = _.now();
        var callNow = immediate && !timeout;
        // 如果延时不存在，重新设定延时
        if (!timeout) timeout = setTimeout(later, wait);
        if (callNow) {
            result = func.apply(context, args);
            context = args = null;
        }

        return result;
    };
};
let getCalories = function(ingredients){
    return axios({
        method: 'post',
        url: 'https://api.edamam.com/api/nutrition-details',
        params: {
            app_id: 'c653bc23',
            app_key: '39063867d27088781fb1b31772bc5a3d'
        },
        data: {
            ingr: ingredients//["1 apple","1 beef steak"]
        }
    })
}

let ingredients=[];

const handleAddButton = function(event){
    let a = $('#input_amount:input').val();
    let b = $('#input_measure:input').val();
    let c = $('#input_food:input').val();
    let res = a.concat(' ',b,' of ',c);
    let ans =`<div class="items">`+ `<span class="summary">${res}</span>` +
            `<button class="delete"></button>`+`</div>`
    ingredients.push(res);
    console.log(ingredients);
    $('#addItem').parent().append(ans);
    $('#input_amount:input').val('');
    $('#input_food:input').val('');
    $('#input_measure:input').val('');

}

const handleCalculateButton = function(event) {
    let res = getCalories(ingredients);
    $('#calculate').parent().parent().parent().append(res);
    ingredients=[];
}

const loadCalculator = function() {
    $("input_food:text").keyup( debounce( request.onreadystatechange, 250 ) );
    $("#addItem").on("click",handleAddButton);
    $("#calculate").on("click",handleCalculateButton);
}

$(function() {
    loadCalculator();
})


