package suporte;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Web {

    public static WebDriver createChrome() {
        System.setProperty("webdriver.chrome.driver", "C:\\SeleniumDriver\\chromedriver.exe");
        WebDriver navegador = new ChromeDriver();
        navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);  // espera até 5 segundos para carregar os itens da página
        navegador.manage().window().maximize();
        navegador.get("http://www.juliodelima.com.br/taskit");  // abrir o site
        return navegador;
    }
}
