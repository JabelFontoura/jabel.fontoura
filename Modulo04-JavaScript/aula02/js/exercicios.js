//Exercicio 1
function seriesInvalidas(series) {
  const invalidas = [];
  invalidas.push('Séries inválidas: ');
  series.forEach(item => {
    if(item.anoEstreia > new Date().getFullYear()) 
      invalidas.push(item.titulo + ' - ');
    
    for(prop of Object.values(item)) {
      if(typeof prop === 'undefined' || prop === null) 
        invalidas.push(item.titulo + ' - ');
    }
  });
  return invalidas.join('').substring(0, invalidas.join('').length - 2);
}

console.log(`1) ${seriesInvalidas(series)}`);

//Exercicio 2
function filtrarSeriesPorAno(series, ano) {
  return series.filter(item => item.anoEstreia >= ano ? item : ''); 
}

console.log('2)', filtrarSeriesPorAno(series, 2017));

//Exercicio 3
function mediaDeEpisodios(series) {
  let totalEpi = 0;

  for(serie of series) 
    totalEpi += serie.numeroEpisodios;

  return totalEpi / series.length;
}

console.log(`3) ${mediaDeEpisodios(series)}`);

//Exercicio 4
function procurarPorNome(series, nome) {
  let achou = false;

   series.forEach(item => {
     if(item.elenco.filter(e => e === nome).length >= 1)
      achou = true;
  });

  return achou;
}

console.log(`4) ${procurarPorNome(series, 'Jabel Fontoura')}`);

//Exercicio 5
function mascadaEmSerie(serie) {
  let salario = 0;
  
  salario += 100000 * serie.diretor.length; 
  salario += 40000 * serie.elenco.length;

  return salario;
} 

console.log(`5) ${mascadaEmSerie(series[0])}`);

//Exercicio 6-A
function queroGenero(genero) {
  let result = [];

  for(serie of series) {
    if(serie.genero.filter(value => value === genero).length >= 1)
      result.push(serie.titulo);
  }
  return result;  
}

console.log('6-A)', queroGenero('Caos'));

//Exercicio 6-B
function queroTitulo(titulo) {
  let result = [];

  for(serie of series) {
    if(serie.titulo.includes(titulo))
      result.push(serie.titulo);
  }

  return result;
} 

console.log('6-B)', queroTitulo('The'));

