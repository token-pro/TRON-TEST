package android.com.wallet.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.concurrent.TimeUnit;
import io.appium.java_client.android.AndroidDriver;

public class ImportPrivateKeyPage extends AbstractPage {


    public AndroidDriver<?> driver;


    public ImportPrivateKeyPage(AndroidDriver<?> driver) {
        super(driver);
        this.driver = driver;
    }


    @FindBy(id = "com.tronlinkpro.wallet:id/et_content")
    public WebElement content_text;



    @FindBy(id = "com.tronlinkpro.wallet:id/bt_next")
    public WebElement next_btn;



    @FindBy(id = "com.tronlinkpro.wallet:id/tv_error")
    public WebElement error_hits;



    @FindBy(id = "com.tronlinkpro.wallet:id/ll_common_left")
    public WebElement back_btn;





    public String checkPrivateKey(String key) throws Exception {
        content_text.sendKeys(key);
        next_btn.click();
        TimeUnit.SECONDS.sleep(1);
        String hits = error_hits.getText();
        return hits;
    }


    public PrivateKeySetNamePage enterPrivateKeySetNamePage(String key) throws Exception{
        content_text.sendKeys(key);
        next_btn.click();
        TimeUnit.SECONDS.sleep(2);
        return new PrivateKeySetNamePage(driver);
    }



    public String inputErrorKeyGetHits(String key) throws Exception {
        content_text.sendKeys(key);
        next_btn.click();
        TimeUnit.SECONDS.sleep(2);
        return error_hits.getText();
    }



}
