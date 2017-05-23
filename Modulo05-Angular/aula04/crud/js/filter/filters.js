angular.module('crud').filter('idToNome', () => (id, scope) => {
  for(item of scope.$parent.$parent.aulas) 
    if(item.id === Number(id)) return item.nome;
});

angular.module('crud').filter('dandoAulaToText', () => (dandoAula) => dandoAula ? 'Sim' : 'Não');