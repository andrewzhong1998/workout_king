let  getCalories = function(){
    return axios({
        method: 'post',
        url: 'https://api.edamam.com/api/nutrition-details',
        params: {
            app_id: 'c653bc23',
            app_key: '39063867d27088781fb1b31772bc5a3d'
        },
        data: {
            ingr: ["1 apple","1 beef steak"]
        }
    })
}