import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import java.io.File;
import java.io.IOException;
import java.util.List;

//This class concentrates functions that are useful during the project
public class BasePage {

    public WebElement getWebElement(By locator) {
        return SingletonWebDriver.getInstance().findElement(locator);
    }
    public void clickElement(By locator) {
        getWebElement(locator).click();
    }
    public void sendKeysToElementList(int index, String text, List<WebElement> list){
        list.get(index).sendKeys(text);
    }
    public WebElement getWebElementFromList(List<WebElement> list, int index) {
        return list.get(index);
    }
    public void sendKeysToElement(By locator, String text) {
        getWebElement(locator).sendKeys(text);
    }

    //screenshot function to document failed tests
    public static String takeScreenShot(String ImagesPath) {
        TakesScreenshot takesScreenshot = (TakesScreenshot) SingletonWebDriver.getInstance();
        File screenShotFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File destinationFile = new File(ImagesPath + ".png");
        try {
            FileUtils.copyFile(screenShotFile, destinationFile);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return ImagesPath + ".png";
    }
}