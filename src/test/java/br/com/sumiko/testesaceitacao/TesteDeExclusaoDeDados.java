package br.com.sumiko.testesaceitacao;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static br.com.sumiko.testesaceitacao.DriverFactory.getDriver;
import static br.com.sumiko.testesaceitacao.DriverFactory.killDriver;

import org.openqa.selenium.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static br.com.sumiko.testesaceitacao.DriverFactory.getDriver;
import static br.com.sumiko.testesaceitacao.DriverFactory.killDriver;

public class TesteDeExclusaoDeDados {
        private static TelaDeCadastroPage page;
        @Before
        public void inicializa() {
            getDriver().get("http://localhost:8080");
            page = new TelaDeCadastroPage();
        }
        @After
        public void finaliza() {
            killDriver();
        }
        @Test
        public void excluirDadosCadastrados() {
            page.setNome("Sumiko");
            page.setCPF("111.111.111-11");
            page.setCelular("(11)99999-9999");;
            page.setDataNascimento("13/11/1111");
            page.salvar();
            page.clicarLink("linkExcluir");
            Assert.assertThrows(NoSuchElementException.class, () -> page.obterValorCelulaNome());


        }
    }

