//Melhor maneira de verificar undefined.
if(typeof variavel !== 'undefined') {
    console.log(variavel)
}

// Função sem parametros declarados e ainda recebe.
function semArgumentos() {
    var argumento = arguments[0];
    console.log(argumento)
}

semArgumentos('teste'); 

//for in percorre propriedade
//for of percorre elementos