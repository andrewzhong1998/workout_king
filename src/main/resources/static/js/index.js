

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
let getCalories = async function(ingredients){
    return await axios({
        method: 'post',
        url: 'https://api.edamam.com/api/nutrition-details',
        params: {
            app_id: 'c653bc23',
            app_key: '39063867d27088781fb1b31772bc5a3d'
        },
        data: {
            title:'',
            ingr: ingredients//["1 apple","1 beef steak"]
        }
    })
}

let ingredients=[];

const handleCalculateButton = function(event) {
    let res = `
<section class="performance-facts">
  <header class="performance-facts__header">
    <h1 class="performance-facts__title">Nutrition Facts</h1>
    <p>Serving Size 1/2 cup (about 82g)
    <p>Serving Per Container 8</p>
  </header>
  <table class="performance-facts__table">
    <thead>
      <tr>
        <th colspan="3" class="small-info">
          Amount Per Serving
        </th>
      </tr>
    </thead>
    <tbody>
      <tr>
        <th colspan="2">
          <b>Calories</b>
          200
        </th>
        <td>
          Calories from Fat
          130
        </td>
      </tr>
      <tr class="thick-row">
        <td colspan="3" class="small-info">
          <b>% Daily Value*</b>
        </td>
      </tr>
      <tr>
        <th colspan="2">
          <b>Total Fat</b>
          14g
        </th>
        <td>
          <b>22%</b>
        </td>
      </tr>
      <tr>
        <td class="blank-cell">
        </td>
        <th>
          Saturated Fat
          9g
        </th>
        <td>
          <b>22%</b>
        </td>
      </tr>
      <tr>
        <td class="blank-cell">
        </td>
        <th>
          Trans Fat
          0g
        </th>
        <td>
        </td>
      </tr>
      <tr>
        <th colspan="2">
          <b>Cholesterol</b>
          55mg
        </th>
        <td>
          <b>18%</b>
        </td>
      </tr>
      <tr>
        <th colspan="2">
          <b>Sodium</b>
          40mg
        </th>
        <td>
          <b>2%</b>
        </td>
      </tr>
      <tr>
        <th colspan="2">
          <b>Total Carbohydrate</b>
          17g
        </th>
        <td>
          <b>6%</b>
        </td>
      </tr>
      <tr>
        <td class="blank-cell">
        </td>
        <th>
          Dietary Fiber
          1g
        </th>
        <td>
          <b>4%</b>
        </td>
      </tr>
      <tr>
        <td class="blank-cell">
        </td>
        <th>
          Sugars
          14g
        </th>
        <td>
        </td>
      </tr>
      <tr class="thick-end">
        <th colspan="2">
          <b>Protein</b>
          3g
        </th>
        <td>
        </td>
      </tr>
    </tbody>
  </table>
  
  <table class="performance-facts__table--grid">
    <tbody>
      <tr>
        <td colspan="2">
          Vitamin A
          10%
        </td>
        <td>
          Vitamin C
          0%
        </td>
      </tr>
      <tr class="thin-end">
        <td colspan="2">
          Calcium
          10%
        </td>
        <td>
          Iron
          6%
        </td>
      </tr>
    </tbody>
  </table>
  
  <p class="small-info">* Percent Daily Values are based on a 2,000 calorie diet. Your daily values may be higher or lower depending on your calorie needs:</p>
  
  <table class="performance-facts__table--small small-info">
    <thead>
      <tr>
        <td colspan="2"></td>
        <th>Calories:</th>
        <th>2,000</th>
        <th>2,500</th>
      </tr>
    </thead>
    <tbody>
      <tr>
        <th colspan="2">Total Fat</th>
        <td>Less than</td>
        <td>65g</td>
        <td>80g</td>
      </tr>
      <tr>
        <td class="blank-cell"></td>
        <th>Saturated Fat</th>
        <td>Less than</td>
        <td>20g</td>
        <td>25g</td>
      </tr>
      <tr>
        <th colspan="2">Cholesterol</th>
        <td>Less than</td>
        <td>300mg</td>
        <td>300 mg</td>
      </tr>
      <tr>
        <th colspan="2">Sodium</th>
        <td>Less than</td>
        <td>2,400mg</td>
        <td>2,400mg</td>
      </tr>
      <tr>
        <th colspan="3">Total Carbohydrate</th>
        <td>300g</td>
        <td>375g</td>
      </tr>
      <tr>
        <td class="blank-cell"></td>
        <th colspan="2">Dietary Fiber</th>
        <td>25g</td>
        <td>30g</td>
      </tr>
    </tbody>
  </table>
  
  <p class="small-info">
    Calories per gram:
  </p>
  <p class="small-info text-center">
    Fat 9
    &bull;
    Carbohydrate 4
    &bull;
    Protein 4
  </p>
  
</section>`
    $('#calculate').parent().parent().parent().append(res);
    ingredients=[];
}

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



const handleDeleteItem = function(event) {
    event.preventDefault();

    let s = event.target.id;
    console.log(s);
    $("#"+s).remove();
    ingredients.splice(ingredients.indexOf(s), 1);
    $("#"+event.target).parent().remove();

}

const loadCalculator = function() {
    $("input_food:text").keyup( debounce( request.onreadystatechange, 250 ) );
    $("#addItem").on("click",handleAddButton);
    $("#calculate").on("click",handleCalculateButton);
    $('.delete').click(function(){
        alert("clicked!!");
    })
    $(".delete:button").on("click", handleDeleteItem);
}

$(function() {
    loadCalculator();
})
