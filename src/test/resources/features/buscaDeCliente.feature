Feature: Buscar cliente

  Scenario: Buscar um cliente com sucesso
    Given que eu logue em localhost
    And eu inserir um cliente para ser buscado
    And clico no botao salvar
    And verifico se o cliente esta salvo
    When preencher o campo para busca com o nome completo do cliente cadastrado
    And clicar no botao buscar
    Then eu veja o cliente cadastrado na tabela

  Scenario: Busca falha de cliente nome nao cadastrado
    Given que eu logue em localhost
    And eu inserir um cliente para ser buscado
    And clico no botao salvar
    And verifico se o cliente esta salvo
    When preencher o campo para busca com o nome de cliente diferente do cliente cadastrado
    And clicar no botao buscar
    Then nao retorne nenhum cliente na tabela de cadastro

  Scenario: Busca falha de cliente nome incompleto
    Given que eu logue em localhost
    And eu inserir um cliente para ser buscado
    And clico no botao salvar
    And verifico se o cliente esta salvo
    When preencher o campo para busca com o nome de cliente incompleto
    And clicar no botao buscar
    Then nao encontre nenhum cliente na tabela de cadastro




