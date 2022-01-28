import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class MainClass
{

    private String login = "test-simbir-valeev";
    private String passwd = "ks007410";


    @Test
    public void Login() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Mishka\\chromedriver.exe");
        Auth();
    }

    private void Auth() throws InterruptedException {
        String login = "test-simbir-valeev";
        String passwd = "ks007410";

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Mishka\\chromedriver.exe");

        ChromeDriver driver = new ChromeDriver();

        Functions func = new Functions();

        driver.get("https://mail.yandex.ru/?uid=1555275419#tabs/relevant");

        WebElement btn = driver.findElement(By.xpath
                ("//*[@id=\"index-page-container\"]/div/div[2]/div/div/div[4]/a[2]"));
        btn.click();

        Thread.sleep(2000);

        WebElement loginField = driver.findElement(By.xpath("//*[@id=\"passp-field-login\"]"));
        func.InsertInto(loginField, login);

        WebElement entryBtn1 = driver.findElement(By.xpath("//*[@id=\"passp:sign-in\"]"));
        entryBtn1.click();
        Thread.sleep(3000);

        WebElement passwField = driver.findElement(By.xpath("//*[@id=\"passp-field-passwd\"]"));
        func.InsertInto(passwField, passwd);

        WebElement entryBtn2 = driver.findElement(By.xpath("//*[@id=\"passp:sign-in\"]"));
        entryBtn2.click();

        Thread.sleep(5000);

        //------------------------------------
        int k = 0;
        //System.setProperty("webdriver.chrome.driver", "C:\\Users\\Mishka\\chromedriver.exe");

        List<WebElement> list_letters = driver.findElements(By.xpath("//span[text()='Simbirsoft Тестовое задание']"));
        for (int i = 0; i < list_letters.size(); i++)
        {
            if (list_letters.get(i).getText().equals("Simbirsoft Тестовое задание")) {
                k+=1;
            }
        }
        System.out.println("Количество писем - " + k);

        Thread.sleep(2000);

    }


}
