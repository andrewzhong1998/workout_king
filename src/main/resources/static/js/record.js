String.prototype.replaceAll = function(search, replacement) {
    let target = this;
    return target.split(search).join(replacement);
};
let addRecord = () => {
    let amount = $('#inputAmount').val()
    let unit = $('#selectUnit').val()
    let food = $('#inputFood').val()
    //console.log([amount,unit,food])
    if(amount.length==0||food.length==0||unit.length==0) return;
    if(isNaN(amount)){
        alert("Amount should be a number")
        return;
    }
    $('#inputAmount').val('')
    $('#selectUnit').val('Piece')
    $('#inputFood').val('')
    $('#summaryFoods').append(`<a class="list-item">${food} (${amount} ${unit})</a>`)
    foodRecords.push(`${amount} ${unit} ${food}`)
    foodRecords_json.push({
        food: food,
        amount: amount,
        unit: unit
    })
    if(foodRecords.length==0) $('#summary').addClass('is-hidden');
    else $('#summary').removeClass('is-hidden');
}
let calculate = ()=>{
    if(foodRecords.length==0) return;
    $('#buttonCalculate').addClass("is-loading");
    getCalories(foodRecords).then((res)=>{
        $('#buttonCalculate').removeClass("is-loading");
        nutritions = res.data
        renderReport(nutritions)
        //console.log(nutritions)
    }).catch((err)=>{
        $('#buttonCalculate').removeClass("is-loading");
        alert("Oops, the third-party API returned error message. Check console for the details.")
        console.log(err)
    })
}
let record = () => {
    if(nutritions==null){
        alert("Nothing to record")
        return;
    }
    let description = $('#inputDescription').val()
    if(description.length==0) description = "Untitled Meal"
    nutritions['description'] = description
    nutritions['diets'] = foodRecords_json
    nutritions['fat'] = 0
    if(nutritions.totalNutrients['FAT']!=null) nutritions['fat'] = r(nutritions.totalNutrients['FAT']['quantity'])
    nutritions['carbohydrate']
    if(nutritions.totalNutrients['CHOCDF']!=null) nutritions['carbohydrate'] = r(nutritions.totalNutrients['CHOCDF']['quantity'])
    nutritions['protein']
    if(nutritions.totalNutrients['PROCNT']!=null) nutritions['protein'] = r(nutritions.totalNutrients['PROCNT']['quantity'])
    addJSONRecordToDatabase(nutritions).then(res=>{
        location.href = "user_dashboard.html"
    }).catch(err=>{console.log(err)})
}
let renderReport = (data) => {
    $('#divReport').removeClass('is-hidden')
    $('#intakeLabels').html('')
    $('#healthLabels').html('')
    $('#cautionLabels').html('')
    $('#dietLabels').html('')
    $('#listNutritions').html('')
    let keys = Object.keys(data.totalDaily);
    for(let i=0;i<keys.length;i++){
        if(data.totalNutrients[keys[i]]!=null){
            let name = data.totalDaily[keys[i]].label
            let amount = r(data.totalNutrients[keys[i]].quantity) + data.totalNutrients[keys[i]].unit
            let percentage = r(data.totalDaily[keys[i]].quantity) + data.totalDaily[keys[i]].unit
            $('#listNutritions').append(`<tr><td>${name}</td><td>${amount}</td><td>${percentage}</td></tr>`)
            //console.log([name,amount,percentage])
        }
    }
    let cautionLabels = data.cautions
    let dietLabels = data.dietLabels
    let healthLabels = data.healthLabels
    let calories = data.calories
    let totalWeight = data.totalWeight

    $('#intakeLabels').append(`
                            <div class="board-item">
                                <div class="board-item-content"><span>Calories: ${r(calories)}kJ</span></div>
                            </div>
                            <div class="board-item">
                                <div class="board-item-content"><span>Total Weight: ${r(totalWeight)}g</span></div>
                            </div>`)

    if(healthLabels!=null&&healthLabels.length>0){
        for(let i=0;i<healthLabels.length;i++) $('#healthLabels').append(`
                            <div class="board-item">
                                <div class="board-item-content"><span>${healthLabels[i].toLowerCase().replaceAll('_',' ')}</span></div>
                            </div>`)
    }else{
        $('#healthLabels').append(`<div class="board-item">
                                <div class="board-item-content"><span>No labels matched</span></div>
                            </div>`)
    }
    if(cautionLabels!=null&&cautionLabels.length>0){
        for(let i=0;i<cautionLabels.length;i++) $('#cautionLabels').append(`
                            <div class="board-item">
                                <div class="board-item-content"><span>${cautionLabels[i].toLowerCase().replaceAll('_',' ')}</span></div>
                            </div>`)
    }else{
        $('#cautionLabels').append(`<div class="board-item">
                                <div class="board-item-content"><span>No labels matched</span></div>
                            </div>`)
    }
    if(dietLabels!=null&&dietLabels.length>0){
        for(let i=0;i<dietLabels.length;i++) $('#dietLabels').append(`
                            <div class="board-item">
                                <div class="board-item-content"><span>${dietLabels[i].toLowerCase().replaceAll('_',' ')}</span></div>
                            </div>`)
    }else{
        $('#dietLabels').append(`<div class="board-item">
                                <div class="board-item-content"><span>No labels matched</span></div>
                            </div>`)
    }
}
let switchToOverview = () => {
    $('#tabNutrition').removeClass('is-active')
    $('#tabOverview').addClass('is-active')
    $('#tableNutritions').addClass('is-hidden')
    $('#tableOverview').removeClass('is-hidden')
}
let switchToNutrition = () => {
    $('#tabNutrition').addClass('is-active')
    $('#tabOverview').removeClass('is-active')
    $('#tableNutritions').removeClass('is-hidden')
    $('#tableOverview').addClass('is-hidden')
}
let foodRecords = []
let foodRecords_json = []
let nutritions = null
let r = (num) => {
    return Math.round( num * 10 ) / 10;
}