package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

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

        // clicar em um link que tenha o texto "me"
        WebElement me = navegador.findElement(By.className("me"));  // obter o elemento
        String textoMe = me.getText();
        me.click();
//        navegador.findElement(By.className("me")).click();

        // clicar em um link que tenha o texto "MORE DATA ABOUT YOU"
        navegador.findElement(By.linkText("MORE DATA ABOUT YOU")).click();

        // clicar em um botão através do seu XPath: //div[@id="moredata"]//button[@data-target="addmoredata"]
        navegador.findElement(By.xpath("//div[@id=\"moredata\"]//button[@data-target=\"addmoredata\"]")).click();

        // Identificar a popup onde está o formulário de id addmoradata
        WebElement popup = navegador.findElement(By.id("addmoredata"));

        // na combo de name "type" escolher a opção "Phone"
        WebElement campoType = popup.findElement(By.name("type"));
        new Select(campoType).selectByValue("phone");

//        popup.findElement(By.xpath("//select/option[@value=\"phone\"]"));

        // No campo de name "contact"  digitar +558199887766
//        popup.findElement(By.xpath("//input[@name=\"contact\"]")).sendKeys("+558199887766");
        popup.findElement(By.name("contact")).sendKeys("+558199887766");

        // Clicar no link que tenha o Texto "SAVE" ou XPath: //div[@id="addmoredata"]//a[text()="Save"]
        popup.findElement(By.linkText("SAVE")).click();

        // Verificar se apresentou a mensagem de inclusão via XPath: //div[@id="toast-container"]//div[@class="toast rounded"]
        WebElement webToast = navegador
                .findElement(By.xpath("//div[@id=\"toast-container\"]//div[@class=\"toast rounded\"]"));
        String textoToast = webToast.getText();

        System.out.println(">>> textoMe: " + textoMe);
        System.out.println(">>> textoToast: " + textoToast);
        //--- Validação
        Assert.assertEquals("Hi, Julio", textoMe);
        Assert.assertEquals("Your contact has been added!", textoToast);
    }

    @After
    public void tearDown() {
        navegador.quit();   // fechar o navegador
    }
}
