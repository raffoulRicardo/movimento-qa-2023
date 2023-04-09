Feature: Cadastrar cliente

  Scenario: Cadastrar cliente com sucesso
    Given que acesso o localhost
    When eu preencho todos os campos corretamente
    And clico em salvar
    Then eu vejo o cliente cadastrado na tabela
