import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage
{
    public WebDriver driver;
    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver; }


    @FindBy(xpath = "//*[@id=\"index-page-container\"]/div/div[2]/div/div/div[4]/a[2]")
    private WebElement btn;

    @FindBy(xpath = "//*[@id=\"passp-field-login\"]")
    private WebElement loginField;

    @FindBy(xpath = "//*[@id=\"passp:sign-in\"]")
    WebElement entryButton;

    @FindBy(xpath = "//*[@id=\"passp-field-passwd\"]")
    WebElement passwdField;

    public int k = 0;

    public void ButtonClick()
    {
        btn.click();
    }

    public void EntryButtonClick()
    {
        entryButton.click();
    }

    public void inputLogin(String keys)
    {
        loginField.sendKeys(keys);
    }


    public void inputPasswd(String keys)
    {
        passwdField.sendKeys(keys);
    }
}
