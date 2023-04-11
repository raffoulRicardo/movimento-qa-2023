package br.com.sumiko.testesaceitacao;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static br.com.sumiko.testesaceitacao.DriverFactory.getDriver;

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

    public void setNomeBusca(String nomeBusca) {
        dsl.escrever("input-search", nomeBusca);
    }

    public void buscar() {
        dsl.clicarBotao("buscar");
    }

}



