let signup = function(email,password){
    //resolve(true);
    //reject(new Error("…")); // ignored
    //setTimeout(() => resolve("…"));
    return axios({
        method: 'post',
        url: 'api/signup',
        params: {
            'email': email,
            'password': password
        }
    })
}

let login = function(email,password,remember){
    return axios({
        method: 'post',
        url: 'api/login',
        params: {
            'email': email,
            'password': password,
            'remember': remember
        }
    })
}

let isValidEmail = function(email){
    return /^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(email);
}
