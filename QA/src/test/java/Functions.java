import org.openqa.selenium.WebElement;

public class Functions
{
    protected void InsertInto(WebElement element, String text)
    {
        element.sendKeys(text);
    }
}
