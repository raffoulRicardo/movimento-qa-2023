Feature: Exclusao de cliente

  Scenario: Excluir um cliente salvo
    Given que eu esteja logado
    And eu inserir um cliente para ser deletado
    And verifico cliente salvo
    When eu clicar no botao excluir todos os usuarios
    Then a tabela de clientes cadastrados deve estar vazia