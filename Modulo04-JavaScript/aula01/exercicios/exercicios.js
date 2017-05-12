//Exercicio 1
function daisyGame(petals) {
  return petals % 2 == 0 ? 'Love me not' : 'Love me';
}
console.log(daisyGame(4));

//Exercicio 2
function maiorTexto(textos) {
  var maiorTexto = textos[0];
  for(texto of textos) {
    if(texto.length > maiorTexto.length) maiorTexto = texto;
  }
  return maiorTexto;
}
console.log(maiorTexto(['Jabel', 'Teste', 'um', 'dois', 'Um texto bem grande', 'Qualquer coisa']));

//Exercicio 3
function imprime(funcao, instrutores) {
  if(typeof funcao !== 'function') {
    console.log('Não foi inserida uma função');
    return;  
  }
  
  for(instrutor of instrutores) {
    funcao(instrutor);
  }
}
imprime(instrutor => console.log('Olá querido instrutor: ', instrutor),
                    [ 'bernardo', 'nunes', 'fabrício', 'ben-hur', 'carlos' ]);
            
imprime(3.5, [ 'bernardo', 'nunes', 'fabrício', 'ben-hur', 'carlos' ]);

//Exercicio 4
function adicionar (a) {
  return b => a + b;
}

console.log(adicionar(3)(4));
console.log(adicionar(5642)(8749)); // 14391);

//Exercicio 5
function fiboSum(n) {
  if (n === 0) return 0;
  if (n === 1) return 1;
  return fiboSum(n-1) + fiboSum(n-2) + 1;
}

console.log(fiboSum(7));


//Exercicio 6
function queroCafe(mascada, precos) {
  precos.sort((a, b) => a - b);
  
  return precos.map(item => { 
    return item <= mascada ? item : "";
  }).join(',');
}

console.log(queroCafe(3.14, [ 5.16, 2.12, 1.15, 3.11, 17.5 ]));