Number.prototype.arredondar = function (casas = 2) {
    return parseFloat(this).toFixed(casas);
}