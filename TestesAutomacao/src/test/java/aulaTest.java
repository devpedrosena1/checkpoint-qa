import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class aulaTest {

    // Testando funcionalidade de login

    // 1. Login feito com sucesso (login e senha corretos)
    @Test
    public void loginTestSuccess() {

        // Dado: que esteja na página saucedemo.com
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        assert driver.getCurrentUrl().equals("https://www.saucedemo.com/");
        assert driver.getTitle().equals("Swag Labs");

        // Quando: inserido dados de usuário e senha válidos
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        // Então: deverá ser redirecionado para a página https://www.saucedemo.com/inventory.html
        assert driver.getCurrentUrl().equals("https://www.saucedemo.com/inventory.html");
        assert driver.findElement(By.id("shopping_cart_container")).isDisplayed();

        driver.quit();
    }

    // 2. Login não realizado (login correto e senha incorreta)
    @Test
    public void loginInvalidWithLoginCorrectAndPasswordInvalid() {

        // Dado: que esteja na página saucedemo.com
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        assert driver.getCurrentUrl().equals("https://www.saucedemo.com/");
        assert driver.getTitle().equals("Swag Labs");

        // Quando: inserido login correto e senha inválida
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce_2");
        driver.findElement(By.id("login-button")).click();

        // Então: login não será feito
        String messageError = driver.findElement(By.cssSelector("[data-test='error']")).getText();
        Assert.assertTrue(messageError.contains("do not match"));

        driver.quit();
    }

    // 3. Login não realizado (login incorreto e senha correta)
    @Test
    public void loginInvalidWithLoginInvalidAndPasswordCorrect() {

        // Dado: que esteja na página saucedemo.com
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        assert driver.getCurrentUrl().equals("https://www.saucedemo.com/");
        assert driver.getTitle().equals("Swag Labs");

        // Quando: inserido login inválido e senha correta
        driver.findElement(By.id("user-name")).sendKeys("standard_user_2");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        // Então: login não será feito
        String messageError = driver.findElement(By.cssSelector("[data-test='error']")).getText();
        Assert.assertTrue(messageError.contains("do not match"));

        driver.quit();
    }

    // 4. Login não realizado (login e senha incorretos)
    @Test
    public void loginInvalidWithLoginInvalidAndPasswordInvalid() {

        // Dado: que esteja na página saucedemo.com
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        assert driver.getCurrentUrl().equals("https://www.saucedemo.com/");
        assert driver.getTitle().equals("Swag Labs");

        // Quando: inserido login incorreto e senha incorreta
        driver.findElement(By.id("user-name")).sendKeys("standard_user_2");
        driver.findElement(By.id("password")).sendKeys("secret_sauce_2");
        driver.findElement(By.id("login-button")).click();

        // Então: login não será feito
        String messageError = driver.findElement(By.cssSelector("[data-test='error']")).getText();
        Assert.assertTrue(messageError.contains("do not match"));

        driver.quit();
    }

    // só está testado quando todos os cenários são aplicados
}