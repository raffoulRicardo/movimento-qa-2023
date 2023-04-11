package br.com.sumiko.testesaceitacao;

public class TelaDeCadastroPage {

    public DSL dsl;

    public TelaDeCadastroPage() {
        dsl = new DSL();
    }

    public void setNome(String nome) {
        dsl.escrever("nome", nome);
    }

    public void setCPF(String cpf) {
        dsl.escrever("cpf", cpf);
    }

    public void setCelular(String celular) {
        dsl.escrever("celular", celular);
    }

    public void setDataNascimento(String dtNascimento) {
        dsl.escrever("dt-nascimento", dtNascimento);
    }


    public void salvar() {
        dsl.clicarBotao("btn-salvar");
    }


    public String obterNomeCadastro() {
        return dsl.obterConteudoCelula("//table/tbody/tr/td[1]");
    }

    public String obterCPFCadastro() {
        return dsl.obterConteudoCelula("//table/tbody/tr/td[2]");
    }

    public String obterCelularCadastro() {
        return dsl.obterConteudoCelula("//table/tbody/tr/td[3]");
    }

    public String obterDataNascimentoCadastro() {
        return dsl.obterConteudoCelula("//table/tbody/tr/td[4]");
    }

}
