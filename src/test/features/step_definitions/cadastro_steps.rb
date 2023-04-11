  Dado('que o usuário tenha acesso ao formulário') do
    @driver = Selenium::WebDriver.for :chrome
    @driver.get("http://localhost:8080/")

    @table_user = @driver.find_element(:id, 'tabela-usuarios')
    @rows_before = @table_user.find_elements(:tag_name, 'tr').count
  end
  
  Quando('preencher todos os campos com informações válidas') do
    @driver.find_element(:id, "nome").send_keys("Beatriz Ereno")
    @driver.find_element(:id, "cpf").send_keys("464.298.298-92")
    @driver.find_element(:id, "celular").send_keys("13987672536")
    @driver.find_element(:id, "dt-nascimento").send_keys("12/11/1998")
  end

  Quando('clicar no botão Salvar') do
    @driver.find_element(:id, "btn-salvar").click
  end

  Então('uma nova linha na tabela de usuários é inserida') do
    @table_user = @driver.find_element(:id, 'tabela-usuarios')
    @rows_after = @table_user.find_elements(:tag_name, 'tr').count
    expect(@rows_after - 1).to eq(@rows_before)
  end

  Quando('preencher todos os campos, exceto CPF, com informações válidas') do
    @driver.find_element(:id, "nome").send_keys("Beatriz Ereno")
    @driver.find_element(:id, "celular").send_keys("13987672536")
    @driver.find_element(:id, "dt-nascimento").send_keys("12/11/1998")
  end
  
  Quando('preencher o CPF apenas utilizando letras') do
    @driver.find_element(:id, "cpf").send_keys("abcdefghijklmno")
  end
  
  Então('não é adicionada uma nova linha na tabela de usuários') do
    @table_user = @driver.find_element(:id, 'tabela-usuarios')
    @rows_after = @table_user.find_elements(:tag_name, 'tr').count
    expect(@rows_after).to eq(@rows_before)
  end

  Quando('preencher todos os campos, exceto celular, com informações válidas') do
    @driver.find_element(:id, "nome").send_keys("Beatriz Ereno")
    @driver.find_element(:id, "cpf").send_keys("464.298.298-92")
    @driver.find_element(:id, "dt-nascimento").send_keys("12/11/1998")
  end

  Quando('preencher o celular apenas utilizando letras') do
    @driver.find_element(:id, "celular").send_keys("abcdefghijk")
  end
  
  Quando('preencher o CPF utilizando 15 caracteres') do
    @driver.find_element(:id, "cpf").send_keys("464.298.298-923")
  end
  
  Dado('que já existe um usuário salvo na tabela de usuários') do
    @driver.find_element(:id, "nome").send_keys("Beatriz Ereno")
    @driver.find_element(:id, "cpf").send_keys("464.298.298-92")
    @driver.find_element(:id, "celular").send_keys("13987672536")
    @driver.find_element(:id, "dt-nascimento").send_keys("12/11/1998")
    @driver.find_element(:id, "btn-salvar").click
  end
  
  Quando('preencher todos os campos com as mesmas informações do usuário existente') do
    @driver.find_element(:id, "nome").send_keys("Beatriz Ereno")
    @driver.find_element(:id, "cpf").send_keys("464.298.298-92")
    @driver.find_element(:id, "celular").send_keys("13987672536")
    @driver.find_element(:id, "dt-nascimento").send_keys("12/11/1998")
  end
  
  Quando('preencher todos os campos, exceto data de nascimento, com informações válidas') do
    @driver.find_element(:id, "nome").send_keys("Beatriz Ereno")
    @driver.find_element(:id, "cpf").send_keys("464.298.298-92")
    @driver.find_element(:id, "celular").send_keys("13987672536")
  end
  
  Quando('preencher a data de nascimento com uma data futura') do
    @driver.find_element(:id, "dt-nascimento").send_keys("12/11/2030")
  end