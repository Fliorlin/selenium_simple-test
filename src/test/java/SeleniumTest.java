import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SeleniumTest {

    WebDriver driver = new ChromeDriver();

    @Test
    public void openPage (){
        driver.get("https://www.selenium.dev/selenium/web/web-form.html");
        String title = driver.getTitle();
        assertEquals("Web form", title);

        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));

        WebElement textBox = driver.findElement(By.name("my-text"));
        WebElement submitButton = driver.findElement(By.cssSelector("button"));
        WebElement passwordField = driver.findElement(By.name("my-password"));
        WebElement disabledField = driver.findElement(By.name("my-disabled"));

        textBox.sendKeys("Selenium");
        passwordField.sendKeys("SomePassword");
        String prop = disabledField.getAttribute("disabled");
        assertTrue(Boolean.parseBoolean(prop));
        submitButton.click();

        WebElement message = driver.findElement(By.id("message"));
        String value = message.getText();
        assertEquals("Received!", value);


    }
    @After
    public void closeDriver (){
        driver.quit();
    }
}
