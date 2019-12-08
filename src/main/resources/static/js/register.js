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

let isValidEmail = function(email){
    return /^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(email);
}
