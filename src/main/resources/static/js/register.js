let login = function(email,password){
    return axios({
        method: 'post',
        url: '/api/login',
        params: {
            'email': email,
            'password': password
        }
    })
}

let logout = function(){
    axios({
        method: 'get',
        url: '/api/logout'
    }).then(res => location.href="index.html").catach(err=>console.log(err))
}

let isValidEmail = function(email){
    return /^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(email);
}
