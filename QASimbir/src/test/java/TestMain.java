import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class TestMain
{
    public static WebDriver driver;
    public static LoginPage loginPage;
    public static ProfilePage profilePage;

    String login = "test.simbir.valeev";
    String passwd = "ks007410";

    @BeforeClass
    public static void setup() {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Mishka\\chromedriver.exe");
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        profilePage = new ProfilePage(driver);
        driver.manage().window().maximize();

        driver.get("https://mail.yandex.ru/?uid=1555275419#tabs/relevant");
    }

    @Test

    @Description("Main testing")
    public void TestTesting() throws InterruptedException, MalformedURLException {
        DesiredCapabilities caps = DesiredCapabilities.chrome();
        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), caps);
        loginPage.ButtonClick();
        Thread.sleep(2000);
        loginPage.inputLogin(login);
        loginPage.EntryButtonClick();
        Thread.sleep(2000);
        loginPage.inputPasswd(passwd);
        loginPage.EntryButtonClick();
        Thread.sleep(10000);
        profilePage.FindMessage();
        //System.out.println("Найдено сообщение");
        profilePage.ButtonSendClick();
        Thread.sleep(2000);
        profilePage.inputName("test.simbir.valeev@yandex.ru");
        profilePage.inputTheme("Simbirsoft Тестовое задание");
        profilePage.inputMessage();
        Thread.sleep(5000);
        profilePage.OutButtonClick();
    }


    @AfterClass
    public static void ShutDown() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
        driver.close();
    }


}