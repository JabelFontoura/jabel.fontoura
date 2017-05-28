angular.module('app').factory('chatService', function ($http) {

  const url = 'http://localhost:57960/api/chat';

  return {
    create: function(mensagem) {
      return $http.post(url, mensagem);
    },
    list: function() {
      return $http.get(url);
    }
  };
});