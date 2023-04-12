#language: pt

Funcionalidade: Busca por usuário

Cenario: Busca por usuário por parte do nome
     Dado que o usuário tenha acesso à tela de Busca
     E que existe um usuário cadastrado na tabela de usuários
     Quando buscar pelo usuário cadastrado utilizando apenas uma parte do nome
     E clicar em Buscar
     Então o sistema deve retornar na tabela o usuário correspondente

Cenario: Busca por usuário sem utilizar acento
     Dado que o usuário tenha acesso à tela de Busca
     E que existe um usuário cadastrado na tabela de usuários com um nome com acento
     Quando buscar pelo usuário cadastrado sem utilizar o acento
     E clicar em Buscar
     Então o sistema deve retornar na tabela o usuário correspondente

Cenario: Busca por usuário sem utilizar letras maiúsculas
     Dado que o usuário tenha acesso à tela de Busca
     E que existe um usuário cadastrado na tabela de usuários com pelo menos uma letra maiúscula no nome
     Quando buscar pelo usuário cadastrado utilizando apenas letras minúsculas
     E clicar em Buscar
     Então o sistema deve retornar na tabela o usuário correspondente

Cenario: Exclusão de usuário
     Dado que o usuário tenha acesso à tela de Busca
     E que existe um usuário cadastrado na tabela de usuários
     Quando clicar no botão Excluir todos os usuário
     Então o sistema deve excluir todos os usuários cadastrados