package wallet.pages;

import common.utils.Helper;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;


/**
 * 转帐页
 */

public class SendTrxPage extends AbstractPage {

    public AndroidDriver<?> driver;

    public SendTrxPage(AndroidDriver<?> driver) {
        super(driver);
        this.driver = driver;
    }

    @FindBy(id = "com.tronlink.wallet:id/tv_common_title")
    public WebElement transferTtile_btn;

    @FindBy(id = "com.tronlink.wallet:id/et_address")
    public WebElement receiveAddress_text;


    @FindBy(id = "com.tronlink.wallet:id/et_count")
    public WebElement tranferCount_text;

    @FindBy(id = "com.tronlink.wallet:id/send")
    public WebElement send_btn;


    @FindBy(id = "com.tronlink.wallet:id/bt_go")
    public WebElement transferNow_btn;


    @FindBy(id = "com.tronlink.wallet:id/et_new_password")
    public WebElement InputPasswordConfim_btn;


    @FindBy(id = "com.tronlink.wallet:id/bt_send")
    public WebElement confirm_btn;


    @FindBy(id = "com.tronlink.wallet:id/tv_error")
    public WebElement formatErrorHits_text;


    @FindBy(id = "com.tronlink.wallet:id/tv_note")
    public WebElement note_text;


    @FindBy(id = "com.tronlink.wallet:id/tv_balance")
    public WebElement balance_text;


    @FindBy(id = "com.tronlink.wallet:id/tv_max")
    public WebElement tvMax_btn;


    @FindBy(id = "com.tronlink.wallet:id/rl_token")
    public WebElement token_btn;


    @FindBy(id = "//*[@text='(1000042)']")
    public WebElement trc10_btn;



    public void swip(){
        Helper.swipScreen(driver);
    }



    public SendTrxSuccessPage enterSendTrxSuccessPage(){
        confirm_btn.click();
        return new SendTrxSuccessPage(driver);
    }


    public SendTrxSuccessPage normalSendTrx() throws Exception {
        receiveAddress_text.sendKeys("TG5wFVvrJiTkBA1WaZN3pzyJDfkgHMnFrp");
        tranferCount_text.sendKeys("1");
        swip();
        send_btn.click();
        transferNow_btn.click();
        InputPasswordConfim_btn.sendKeys("Test0001");
        confirm_btn.click();
        TimeUnit.SECONDS.sleep(1);
        return new SendTrxSuccessPage(driver);
    }


    public void sendKey(WebElement el,String value) throws Exception {
        el.sendKeys(value);
        TimeUnit.SECONDS.sleep(2);
    }


    public void sendAllTrx(String value) throws Exception {
        receiveAddress_text.sendKeys("TG5wFVvrJiTkBA1WaZN3pzyJDfkgHMnFrp");
        //calculate trx
        switch(value){
            case "max":
//                String current = balance_text.getText();
//                int  index = current.lastIndexOf(" ");
//                current = current.substring(index + 1,current.length());
//                tranferCount_text.sendKeys(current);
                tvMax_btn.click();
                break;
            case "mix":
                tranferCount_text.sendKeys("0");
                break;
            case "tooMuch":
                tranferCount_text.sendKeys("9999999999");
                break;
        }
        send_btn.click();
        TimeUnit.SECONDS.sleep(1);
    }

    public void sendAllTrc10(String value) throws Exception {
        receiveAddress_text.sendKeys("TG5wFVvrJiTkBA1WaZN3pzyJDfkgHMnFrp");
        //calculate trx
        switch(value){
            case "max":
//                String current = balance_text.getText();
//                int  index = current.lastIndexOf(" ");
//                current = current.substring(index + 1,current.length());
//                tranferCount_text.sendKeys(current);
                tvMax_btn.click();
                break;
            case "mix":
                tranferCount_text.sendKeys("0");
                break;
            case "tooMuch":
                tranferCount_text.sendKeys("9999999999");
                break;
        }
        token_btn.click();
        trc10_btn.click();
        send_btn.click();
        TimeUnit.SECONDS.sleep(1);
    }





}
