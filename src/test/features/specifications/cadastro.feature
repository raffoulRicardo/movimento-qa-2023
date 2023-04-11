#language:pt

Funcionalidade: Cadastro de Usuário

Cenario: Cadastro de Usuário com credenciais válidas
    Dado que o usuário tenha acesso ao formulário
    Quando preencher todos os campos com informações válidas
    E clicar no botão Salvar
    Então uma nova linha na tabela de usuários é inserida

Cenario: Cadastro de Usuário com CPF apenas com letras
      Dado que o usuário tenha acesso ao formulário
      Quando preencher todos os campos, exceto CPF, com informações válidas
      E preencher o CPF apenas utilizando letras
      E clicar no botão Salvar
      Então não é adicionada uma nova linha na tabela de usuários

Cenario: Cadastro de Usuário com celular apenas com letras
     Dado que o usuário tenha acesso ao formulário
     Quando preencher todos os campos, exceto celular, com informações válidas
     E preencher o celular apenas utilizando letras
     E clicar no botão Salvar
     Então não é adicionada uma nova linha na tabela de usuários

Cenario: Cadastro de Usuário com todos os campos vazios
     Dado que o usuário tenha acesso ao formulário
     Quando clicar no botão Salvar
     Então não é adicionada uma nova linha na tabela de usuários

Cenario: Cadastro de usuário com CPF com mais de 14 caracteres
     Dado que o usuário tenha acesso ao formulário
     Quando preencher todos os campos, exceto CPF, com informações válidas
     E preencher o CPF utilizando 15 caracteres
     E clicar no botão Salvar
     Então não é adicionada uma nova linha na tabela de usuários

Cenario: Cadastro de dois usuários idênticos
     Dado que o usuário tenha acesso ao formulário
     E que já existe um usuário salvo na tabela de usuários
     Quando preencher todos os campos com as mesmas informações do usuário existente
     E clicar no botão Salvar
     Então não é adicionada uma nova linha na tabela de usuários

Cenario: Cadastro de usuário com data de nascimento após data atual
     Dado que o usuário tenha acesso ao formulário
     Quando preencher todos os campos, exceto data de nascimento, com informações válidas
     E preencher a data de nascimento com uma data futura
     E clicar no botão Salvar
     Então não é adicionada uma nova linha na tabela de usuários