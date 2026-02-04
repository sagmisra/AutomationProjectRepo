package base;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BasePage extends PageObject {

    public WebElementFacade getElement(String locator) {

        try {
            return find(getBy(locator));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<WebElementFacade> getElements(String locator) {

        try {
            return findAll(getBy(locator));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public By getBy(String locator) {

        By by = null;

        try {
            if(locator.startsWith("id=")) {
                locator = locator.substring(3);
                by = By.id(locator);
            }
            if(locator.startsWith("name=")) {
                locator = locator.substring(5);
                by = By.name(locator);
            }
            if(locator.startsWith("input=")) {
                locator = locator.substring(6);
                by = By.id(locator);
            }
            if(locator.startsWith("xpath=")) {
                locator = locator.substring(6);
                by = By.id(locator);
            }
            if(locator.startsWith("css=")) {
                locator = locator.substring(4);
                by = By.id(locator);
            }
            if(locator.startsWith("link=")) {
                locator = locator.substring(3);
                by = By.linkText(locator);
            }
            return by;
        }  catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void click(String locator) {

        waitFor(getElement(locator)).click();
    }

    public void type(String locator, String value) {

        waitFor(getElement(locator)).sendKeys(value);
    }

    public String getText(String locator) {

        return waitFor(getElement(locator)).getText();
    }

    public void moveToElement(String locator) {

        WebElement element = getElement(locator);
        withAction().moveToElement(element).perform();
    }
}
