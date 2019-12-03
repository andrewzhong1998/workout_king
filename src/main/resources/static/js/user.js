let getInfo = function(){
    return axios({
        method: "get",
        url: "/api/user/me"
    })
}

let updateInfo = function(name,height,target_weight,gender,motto){
    return axios({
        method: "put",
        url: "/api/user/me",
        params: {
            name: name,
            height: height,
            target_weight: target_weight,
            gender: gender,
            motto: motto
        }
    })
}