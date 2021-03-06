package ios.tronlink.com.tronlink.wallet.UITest.pages;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSTouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class NodeSetPage extends AbstractPage {

    public IOSDriver<?> driver;

    public NodeSetPage(IOSDriver<?> driver) {
        super(driver);
        this.driver = driver;
    }

    @FindBy(id = "black path")
    public WebElement back_btn;

    @FindBy(name = "设置")
    public WebElement title;

    @FindBy(name =  "MainChain")
    public WebElement MainChain_btn;

    @FindBy(name =  "DAppChain")
    public WebElement DAppChain_btn;


//    @FindBy(className = "XCUIElementTypeButton")
//    public List<WebElement> buttonArray;  //原来有5个后来定位有时候顺序不一致



    public NodeSetDetailPage enterSettingPageDAppChain() throws Exception {
        DAppChain_btn.click();
        return new NodeSetDetailPage(driver);
    }

    public NodeSetDetailPage enterSettingPageMainChain() throws Exception {
//        MainChain_btn.click();
        int topX = MainChain_btn.getLocation().x + 10;
        int topY = MainChain_btn.getLocation().y + 10;
        log("\n topY: " + topX + " botY: " + topY );
        IOSTouchAction action = new IOSTouchAction(driver);
        action.tap(PointOption.point(topX,topY)).perform();

        return new NodeSetDetailPage(driver);
    }


    public SettingPage enterSettingPageChoiseDappChain() throws Exception {
        int normal = driver.findElementById("node select normal").getLocation().getY();
        int selected = driver.findElementById("node select selected").getLocation().getY();
        if (normal > selected){
            driver.findElementById("node select normal").click();
        }
        waiteTime();
        back_btn.click();
        waiteTime();
        return new SettingPage(driver);
    }


    public SettingPage enterSettingPageChoiseMainChain() throws Exception {
        int normal = driver.findElementById("node select normal").getLocation().getY();
        int selected = driver.findElementById("node select selected").getLocation().getY();
        if (normal < selected){
            driver.findElementById("node select normal").click();
        }
        waiteTime();
        back_btn.click();
        waiteTime();
        return new SettingPage(driver);
    }



}
