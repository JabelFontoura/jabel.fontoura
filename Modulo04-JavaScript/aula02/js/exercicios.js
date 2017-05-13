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

console.log(seriesInvalidas(series));

//Exercicio 2
function filtrarSeriesPorAno(series, ano) {
  return series.filter(item => item.anoEstreia >= ano ? item : ''); 
}

console.log(filtrarSeriesPorAno(series, 2017));

//Exercicio 3
function mediaDeEpisodios(series) {
  let totalEpi = 0;

  for(serie of series) 
    totalEpi += serie.numeroEpisodios;

  return totalEpi / series.length;
}

console.log(mediaDeEpisodios(series));

//Exercicio 4
function procurarPorNome(series, nome) {
  let achou = false;

   series.forEach(item => {
     if(item.elenco.filter(e => e === nome).length >= 1)
      achou = true;
  });

  return achou;
}

console.log(procurarPorNome(series, "Jabel Fontoura"));