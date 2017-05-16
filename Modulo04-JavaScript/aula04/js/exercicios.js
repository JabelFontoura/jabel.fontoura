Number.prototype.arredondar = function (casas = 2) {
    const mutiplicador = Math.pow(10.0, casas);
    return Math.round(this * mutiplicador) / mutiplicador;
}