angular.module('app', ['ngRoute', 'auth', 'ngAnimate', 'toastr']);

// Configurações utilizadas pelo módulo de autenticação (authService)
angular.module('app').constant('authConfig', {

    // Obrigatória - URL da API que retorna o usuário
    urlUsuario: 'http://localhost:55166/api/acessos/usuario',

    // Obrigatória - URL da aplicação que possui o formulário de login
    urlLogin: '/usuario',

    // Opcional - URL da aplicação para onde será redirecionado (se for informado) após o LOGIN com sucesso
    urlPrivado: '/privado',

    // Opcional - URL da aplicação para onde será redirecionado (se for informado) após o LOGOUT
    urlLogout: '/'
});

