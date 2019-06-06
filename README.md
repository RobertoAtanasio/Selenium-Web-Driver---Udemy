"# Selenium-Web-Driver---Udemy" 

O método findElement provavelmente é o método que você mais vai utilizar durante sua trajetória na automação de testes com Selenium WebDriver. Isso porque ele retorna um objeto do tipo WebElement que representa um objeto qualquer contido na página, por exemplo, um botão, um campo, uma caixa de textos, etc.

Alguns dos métodos mais utilizados em um WebElement são:

click() 
Para clicar em um determinado elemento.

sendKeys(String texto) 
Para atribuir um texto a um elemento, esse método pode ser mesclado com o uso da classe Keys, que possibilita, por exemplo, o digitar de teclas especiais como Shift, Enter, Backspace, etc.

https://seleniumhq.github.io/selenium/docs/api/java/org/openqa/selenium/Keys.html

getText() 
Retorna o texto contido entre o abrir e fechar da tag. No código <a id="mensagem">Este é meu texto</a>, o getText() retornaria "Este é meu texto".

clear() 
Limpa um campo que já possui um valor default.

getAttribute(String atributo) 
Retorna o texto contido em um atributo. No código <a id="mensagem">Este é meu texto</a>, o getAttribute("id") retornaria "mensagem".

Você pode ter acesso a todos os métodos da classe WebElement através do link abaixo:

https://seleniumhq.github.io/selenium/docs/api/java/org/openqa/selenium/WebElement.html

@BeforeClass
Método público, sem retorno e estático usado para executar comandos antes da execução do primeiro teste contido no projeto.

@AfterClass
Método público, sem retorno e estático usado para executar comandos depois da execução do último teste contido no projeto.

@Ignore(String motivo)
Permite que testes sejam ignorados.

A classe Select foi usada para ter acesso a métodos que não foram disponibilizados nativamente na interface WebElement. Veja abaixo a relação completa de métodos disponíveis para interação com comboboxes:

http://seleniumhq.github.io/selenium/docs/api/java/index.html

Lembre-se, todos os métodos de teste precisam ter a anotação @Test e serem públicos e sem retorno, ou seja, void.

XPath é um completo mecanismo de pesquisa em arquivos baseados em XML, além dos comando básicos de pesquisa, há uma série de métodos e axes que permitem navegar em elementos que estão ao redor de um determinado elemento. Vimos isso na utilização dos axes ancestor e following. Veja abaixo uma lista com todos os axes disponíveis no XPath:

https://www.w3schools.com/xml/xpath_axes.asp

A classe ExpectedConditions possui uma série de estratégias. Elas nos ajudam a criar formas de aguardar que certos eventos aconteçam, como por exemplos que um determinado seja removido do DOM (caso que vimos no vídeo relacionado ao staleness). Abaixo está um link com todas as estratégias de espera, ou seja, métodos da classe ExpectedConditions:

https://seleniumhq.github.io/selenium/docs/api/java/org/openqa/selenium/support/ui/ExpectedConditions.html

As estratégias mais utilizadas são:

alertIsPresent()  
Aguarda até que uma mensagem Javascript seja apresentada.

elementToBeClickable(By localizador) 
Aguarda até que um elemento esteja pronto para receber um clique, por exemplo, ele poderia ficar desabilitado durante algum período e então teríamos de esperar até que ficasse habilitado novamente.

visibilityOfElementLocated(By localizador) 
Aguarda até que as propriedades CSS display e hidden possuam valores que possibilitam a visualização do elemento pelo usuário.
