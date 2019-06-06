package tests;

import org.junit.*;
import org.junit.rules.TestName;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import suporte.Generator;
import suporte.Screenshot;

import java.util.concurrent.TimeUnit;

public class InformacoesUsuarioTest {

    private WebDriver navegador;

    @Rule
    public TestName test = new TestName();

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\SeleniumDriver\\chromedriver.exe");
        navegador = new ChromeDriver();
        navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);  // espera até 5 segundos para carregar os itens da página
        navegador.manage().window().maximize();
        navegador.get("http://www.juliodelima.com.br/taskit");  // abrir o site

        navegador.findElement(By.linkText("Sign in")).click();  // clicar no elemento "Sign in"
        WebElement formularioSignInBox = navegador.findElement(By.id("signinbox"));
        formularioSignInBox.findElement(By.name("login")).sendKeys("julio0001");    // setar valor
        formularioSignInBox.findElement(By.name("password")).sendKeys("123456");
        formularioSignInBox.findElement(By.linkText("SIGN IN")).click();

        navegador.findElement(By.className("me")).click();  // obter e clicar no elemento
        navegador.findElement(By.linkText("MORE DATA ABOUT YOU")).click();
    }

//    @Test
    public void testAdicionarUmaInforcacaoAdicionalDoUsuario() {

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

        //--- Validação
        Assert.assertEquals("Your contact has been added!", textoToast);
    }

    @Test
    public void testRemoverUmContatoDeUmUsuario() {
        // clicar no elemento pelo XPath
        navegador.findElement(By.xpath("//span[text()=\"+558199887766\"]/following-sibling::a")).click();

        navegador.switchTo().alert().accept();  // confimar a janela javascript

        // validar se a mensagem apresentada foi 'Rest in peace, dear phone!'
        WebElement webToast = navegador
                .findElement(By.xpath("//div[@id=\"toast-container\"]//div[@class=\"toast rounded\"]"));
        String textoToast = webToast.getText();     // obter o texto da mensagem
        Assert.assertEquals("Rest in peace, dear phone!", textoToast);

        String nomeArquivo = "C:\\Roberto\\Udemy\\IdeaProj\\teste-screenshot\\taskit\\"
                + Generator.dataHoraParaArquivo() + test.getMethodName() + ".png";
        Screenshot.tirar(navegador,nomeArquivo);

        // aguardar até 10 segundos para que a janela desapareça.
        // é uma espera explícita de 10 segundos para o navegador
        WebDriverWait aguardar = new WebDriverWait(navegador, 10);
        aguardar.until(ExpectedConditions.stalenessOf(webToast));

        // clicar no link com texto 'Logout'
        navegador.findElement(By.linkText("Logout")).click();
    }

    @After
    public void tearDown() {
        navegador.quit();   // fechar o navegador
    }
}
