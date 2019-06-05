package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class InformacoesUsuarioTest {

    private WebDriver navegador;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\SeleniumDriver\\chromedriver.exe");
        navegador = new ChromeDriver();
        navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);  // espera até 5 segundos para carregar os itens da página
        navegador.manage().window().maximize();
        navegador.get("http://www.juliodelima.com.br/taskit");  // abrir o site
    }

    @Test
    public void testAdicionarUmaInforcacaoAdicionalDoUsuario() {

        navegador.findElement(By.linkText("Sign in")).click();  // clicar no elemento "Sign in"
        WebElement formularioSignInBox = navegador.findElement(By.id("signinbox"));
        formularioSignInBox.findElement(By.name("login")).sendKeys("julio0001");    // setar valor
        formularioSignInBox.findElement(By.name("password")).sendKeys("123456");
        formularioSignInBox.findElement(By.linkText("SIGN IN")).click();
        WebElement me = navegador.findElement(By.className("me"));  // obter o elemento
        String textoNolementoMe = me.getText();

        //--- Validação
        Assert.assertEquals("Hi, Julio", textoNolementoMe);
    }

    @After
    public void tearDown() {
        navegador.quit();   // fechar o navegador
    }
}
