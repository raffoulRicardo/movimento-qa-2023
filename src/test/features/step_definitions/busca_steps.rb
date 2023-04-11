  Dado('que o usuário tenha acesso à tela de Busca') do
    @driver = Selenium::WebDriver.for :chrome
    @driver.get("http://localhost:8080/")
  end

  Dado('que existe um usuário cadastrado na tabela de usuários') do
    @driver.find_element(:id, "nome").send_keys("João da Silva")
    @driver.find_element(:id, "cpf").send_keys("464.298.298-92")
    @driver.find_element(:id, "celular").send_keys("13987672536")
    @driver.find_element(:id, "dt-nascimento").send_keys("12/11/1998")
    @driver.find_element(:id, "btn-salvar").click
  end
  
  Quando('buscar pelo usuário cadastrado utilizando apenas uma parte do nome') do
    @driver.find_element(:id, "input-search").send_keys("Jo")
  end
  
  Quando('clicar em Buscar') do
    @driver.find_element(xpath: '//*[@id="app"]/form[2]/button').click
  end
  
  Então('o sistema deve retornar na tabela o usuário correspondente') do
    @table_user = @driver.find_element(:id, 'tabela-usuarios')

    expect(@table_user.find_element(:xpath, ".//tr/td[1]").text).to eq("João da Silva")
    expect(@table_user.find_element(:xpath, ".//tr/td[2]").text).to eq("464.298.298-92")
    expect(@table_user.find_element(:xpath, ".//tr/td[3]").text).to eq("13987672536")
    expect(@table_user.find_element(:xpath, ".//tr/td[4]").text).to eq("12/11/1998")
  end

  Dado('que existe um usuário cadastrado na tabela de usuários com um nome com acento') do
    @driver.find_element(:id, "nome").send_keys("João da Silva")
    @driver.find_element(:id, "cpf").send_keys("464.298.298-92")
    @driver.find_element(:id, "celular").send_keys("13987672536")
    @driver.find_element(:id, "dt-nascimento").send_keys("12/11/1998")
    @driver.find_element(:id, "btn-salvar").click
  end
  
  Quando('buscar pelo usuário cadastrado sem utilizar o acento') do
    @driver.find_element(:id, "input-search").send_keys("Joao da Silva")
  end
 
  Dado('que existe um usuário cadastrado na tabela de usuários com pelo menos uma letra maiúscula no nome') do
    @driver.find_element(:id, "nome").send_keys("João da Silva")
    @driver.find_element(:id, "cpf").send_keys("464.298.298-92")
    @driver.find_element(:id, "celular").send_keys("13987672536")
    @driver.find_element(:id, "dt-nascimento").send_keys("12/11/1998")
    @driver.find_element(:id, "btn-salvar").click
  end
  
  Quando('buscar pelo usuário cadastrado utilizando apenas letras minúsculas') do
    @driver.find_element(:id, "input-search").send_keys("joão da silva")
  end