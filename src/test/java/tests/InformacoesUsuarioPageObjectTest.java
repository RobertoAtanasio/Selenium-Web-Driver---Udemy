package tests;

import org.easetech.easytest.annotation.Param;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.openqa.selenium.WebDriver;
import pages.LoginFormPage;
import pages.LoginPage;
import suporte.Web;

public class InformacoesUsuarioPageObjectTest {

    private WebDriver navegador;

    @Rule
    public TestName test = new TestName();

    @Before
    public void setUp() {
        navegador = Web.createChrome();
    }

    @Test
    public void testAdicionarUmaInforcacaoAdicionalDoUsuario(
            @Param(name="tipo") String tipo,
            @Param(name="contato") String contato,
            @Param(name="mensagem") String mensagem) {
        new LoginPage(navegador)
                .clickSignIn()
                .typeLogin("julio0001")
                .typePassword("123456");
    }

    @After
    public void tearDown() {
        navegador.quit();
    }
}
