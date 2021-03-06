package android.com.wallet.pages;

import io.appium.java_client.android.AndroidDriver;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public abstract class AbstractPage {

    public AndroidDriver<?> driver;

    public AbstractPage(AndroidDriver<?> driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    public WebElement WaitforElement(By element){
        PageFactory.initElements(driver, this);
        new WebDriverWait(driver,30).until(ExpectedConditions.elementToBeClickable(element));
        return driver.findElement(element);

    }

    public void waiteTime(long time) {
        this.driver.manage().timeouts().implicitlyWait(time,TimeUnit.SECONDS);
    }
    public void waiteTime() {
        waiteTime(15);
    }

    /**
     * is element is exist
     * @param name
     * @return boolean value
     */
    public boolean isElementExist(String name) {
        try {
            driver.findElementById(name);
            System.out.println("IsFindById: "+name);
            return  true;
        }catch (org.openqa.selenium.NoSuchElementException ex){
            try {
                driver.findElementByName(name);
                System.out.println("IsFindByName: "+name);
                return  true;
            }catch (org.openqa.selenium.NoSuchElementException eex){
                try {
                    findElementByText(name);
                    System.out.println("IsFindByText: "+name);
                    return  true;
                }catch (org.openqa.selenium.NoSuchElementException xxx) {
                    System.out.println("NotFound: " + name);
                    return false;
                }
            }
        }
    }

    /**
     *
     * @param  text ,which you want to find
     * @return WebElement
     */
    public WebElement findElementByText(String text) {

       return driver.findElementByAndroidUIAutomator("new UiSelector().text(\""+text+"\")");

    }
}
