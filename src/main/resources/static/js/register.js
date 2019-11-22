let signup = function(email,password){
    let promise = new Promise(function(resolve, reject) {
        resolve(true);

        //reject(new Error("…")); // ignored
        //setTimeout(() => resolve("…"));
    });
    return promise;
}

let login = function(email,password,remember){
    let promise = new Promise(function(resolve, reject) {
        resolve(true);

        //reject(new Error("…")); // ignored
        //setTimeout(() => resolve("…"));
    });
    return promise;
}

let isValidEmail = function(email){
    return /^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(email);
}
