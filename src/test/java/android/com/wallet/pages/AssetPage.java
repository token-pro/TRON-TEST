package android.com.wallet.pages;

import android.com.utils.Helper;
import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 资产页
 */

public class AssetPage extends AbstractPage {


    public AndroidDriver<?> driver;


    public AssetPage(AndroidDriver<?> driver) {
        super(driver);
        this.driver = driver;
        try {
            driver.manage().timeouts().implicitlyWait(1,TimeUnit.SECONDS);
            // if page display AD , cloese the AD
            if (ad_pic.isDisplayed()){
                adClose_btn.click();
                driver.manage().timeouts().implicitlyWait(1,TimeUnit.SECONDS);
            }
        }catch (Exception e){}
//
//        try {
//            TimeUnit.SECONDS.sleep(1);
//            // if updateview display ,close
//            if (update_topview.isDisplayed()) {
//                update_btn.click();
//                TimeUnit.SECONDS.sleep(1);
//            }
//        }catch (Exception e){}

        try {
            driver.manage().timeouts().implicitlyWait(1,TimeUnit.SECONDS);
            // if mutisignview display ,close
            if (mutisign_tipview.isDisplayed()) {
                mutisign_closebtn.click();
                driver.manage().timeouts().implicitlyWait(1,TimeUnit.SECONDS);
            }
        }catch (Exception e){}
    }


    @FindBy(id = "com.tronlinkpro.wallet:id/rl_deal_sign_tip")
    public WebElement mutisign_tipview;



    @FindBy(id = "com.tronlinkpro.wallet:id/iv_sign_close")
    public WebElement mutisign_closebtn;



    @FindBy(id = "com.tronlinkpro.wallet:id/top")
    public WebElement update_topview;



    @FindBy(id = "com.tronlinkpro.wallet:id/tv_cancle")
    public WebElement update_btn;



    @FindBy(id = "com.tronlinkpro.wallet:id/iv_pic")
    public WebElement ad_pic;

    @FindBy(id = "com.tronlinkpro.wallet:id/tv_money_value")
    public WebElement abountmoneyvalue;

    @FindBy(id = "com.tronlinkpro.wallet:id/tv_trx_value")
    public WebElement trxtotalvalue;


    @FindBy(id = "com.tronlinkpro.wallet:id/iv_close")
    public WebElement adClose_btn;



    @FindBy(id = "com.tronlinkpro.wallet:id/rl_send")
    public WebElement assets_btn;

    @FindBy(id = "com.tronlinkpro.wallet:id/rl_safe_tip")
    public WebElement safe_tip;



    @FindBy(id="com.tronlinkpro.wallet:id/rl_bg_vote")
    public WebElement vote_btn;



    @FindBy(id="com.tronlinkpro.wallet:id/appmarket")
    public WebElement market_btn;



    @FindBy(id="com.tronlinkpro.wallet:id/tv_trx_value")
    public WebElement trxValue;



    @FindBy(id="com.tronlinkpro.wallet:id/rl_receive")
    public WebElement receipt_btn;



    @FindBy(id = "com.tronlinkpro.wallet:id/rl_bg_add_assets")
    public WebElement addAssert_btn;



    @FindBy(id = "com.tronlinkpro.wallet:id/assets_name")
    public List<WebElement> assetsName;


    @FindBy(id = "com.tronlinkpro.wallet:id/rl_bg_freeze_unfreeze")
    public WebElement freeze_btn;



    @FindBy(id = "com.tronlinkpro.wallet:id/my")
    public WebElement mine_btn;



    @FindBy(id = "com.tronlinkpro.wallet:id/app1")
    public WebElement discover_btn;



    @FindBy(id = "com.tronlinkpro.wallet:id/assets")
    public WebElement assetsMain_btn;



    @FindBy(xpath = "//*[@text='TRX']")
    public WebElement trx_btn;

    @FindBy(id = "com.tronlinkpro.wallet:id/rl_main")
    public WebElement trz_btn;


/*    @FindBy(xpath = "//*[@text='TRX']")
    public List<WebElement> trx20_btn;*/

    @FindBy(id = "com.tronlinkpro.wallet:id/assets_name")
    public List<WebElement> asset_names;

    //com.tronlinkpro.wallet:id/rl_main
    @FindBy(id = "com.tronlinkpro.wallet:id/rl_main")
    public List<WebElement> trx20_btn;


    @FindBy(xpath = "//*[@text='tronlink_token']")
    public WebElement trx10_btn;

    @FindBy(xpath = "//*[@text='BTT']")
    public WebElement online_trc10_btn;

    @FindBy(xpath = "//*[@text='USDT']")
    public WebElement online_trc20_btn;

    @FindBy(xpath = "//*[@text='TRZ']")
    public WebElement public_account_trz_btn;

    //com.tronlinkpro.wallet:id/iv_renzheng
    @FindBy(id = "com.tronlinkpro.wallet:id/iv_renzheng")
    public List<WebElement> trx10_icon_btns;

    //@FindBy(id = "com.tronlinkpro.wallet:id/rl_main")
    //public List<WebElement> trx10_btn;




    @FindBy(id = "com.tronlinkpro.wallet:id/tv_chain_name")
    public WebElement currChain_name;


    @FindBy(id = "com.tronlinkpro.wallet:id/tv_walletname")
    public WebElement walletName_text;

    @FindBy(className = "com.tronlinkpro.wallet:id/tv_walletname")
    public WebElement assetList_class;

    @FindBy(id = "com.tronlinkpro.wallet:id/ll_transfer2")
    public WebElement trc10Page_transfer_btn;

    @FindBy(id = "com.tronlinkpro.wallet:id/ll_transfer2")
    public WebElement shieldDataSyn_area;

    @FindBy(id = "com.tronlinkpro.wallet:id/tv_current_block")
    public WebElement synCurrent_blockNum;

    @FindBy(id = "com.tronlinkpro.wallet:id/tv_block_amount")
    public WebElement chainCurrent_blockNum;

    @FindBy(id = "com.tronlinkpro.wallet:id/assets_count")
    public WebElement trz_balance;

    @FindBy(id = "com.tronlinkpro.wallet:id/address")
    public WebElement shieldAddress_text;

    //com.tronlinkpro.wallet:id/tv_common_right2
    @FindBy(id = "com.tronlinkpro.wallet:id/tv_common_right2")
    public WebElement saveQR_btn;


    public void waitShieldDataSynFinished() {
        Long startSynTime = System.currentTimeMillis();
        Long currentSynTime;
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (Exception e) {

        }
        while (Integer.valueOf(synCurrent_blockNum.getText()) + 400
                < Integer.valueOf(chainCurrent_blockNum.getText())) {
            try {
                TimeUnit.SECONDS.sleep(10);
                currentSynTime = System.currentTimeMillis();
                //同步大于三十分钟，强制退出
                if (currentSynTime - startSynTime > 1800000L) {
                    break;
                }
            } catch (Exception e){}
        }

    }

    public void refrashWaiteTime(Integer second) throws Exception {
        for (int i = 0 ;i<second;i++){
            Helper.swipScreenToTop(driver);
            TimeUnit.SECONDS.sleep(1);
        }

    }



    public SendTrxPage enterSendTrxPage() {
        waiteTime();
        assets_btn.click();
        waiteTime();
        return new SendTrxPage(driver);
    }

    public SendTrzPage enterSendTrzPage() {
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        assets_btn.click();
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        return new SendTrzPage(driver);
    }


    public SendTrxPage enterSendTrc10Page() {
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        Helper.swipScreenLitte(driver);
        try {
            trx10_btn.click();
        } catch (Exception e) {
            if (trx10_icon_btns.size() > 2){
                trx10_icon_btns.get(1).click();
            }
        }
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        trc10Page_transfer_btn.click();
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        return new SendTrxPage(driver);
    }

    public SendTrxPage enterOnlineSendTrc10Page() throws Exception {
        TimeUnit.SECONDS.sleep(5);
        Helper.swipScreenLitte(driver);
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        try {
            online_trc10_btn.click();
        } catch (Exception e) {
            online_trc10_btn.click();
        }
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        trc10Page_transfer_btn.click();
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        return new SendTrxPage(driver);
    }

    public SendTrxPage enterSendTrc20Page() throws  Exception {

        enterTrx20Page();

        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        trc10Page_transfer_btn.click();
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        return new SendTrxPage(driver);
    }

    public SendTrxPage enterOnlineSendTrc20Page() {
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        try {
            Helper.swipScreen(driver);
            online_trc20_btn.click();
        } catch (Exception e) {
            Helper.swipScreen(driver);
            online_trc20_btn.click();
        }
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        trc10Page_transfer_btn.click();
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        return new SendTrxPage(driver);
    }


    public SendTrxPage publicAccountenterSendTrzPage() {
        Helper.swipScreen(driver);
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        try {
            public_account_trz_btn.click();
        } catch (Exception e) {
            public_account_trz_btn.click();
        }
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        trc10Page_transfer_btn.click();
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        return new SendTrxPage(driver);
    }











    public VotePage enterVotePage(){
        try {
            TimeUnit.SECONDS.sleep(3);
            vote_btn.click();
            driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return new VotePage(driver);
    }

    public MarketPage enterMarketPage() {
        try {
            TimeUnit.SECONDS.sleep(2);
            // if page display AD , cloese the AD
/*            if (ad_pic.isDisplayed()){
                adClose_btn.click();
                TimeUnit.SECONDS.sleep(1);
            }*/
        } catch (Exception e){}
        market_btn.click();
        try {
            TimeUnit.SECONDS.sleep(2);
            // if page display AD , cloese the AD
/*            if (ad_pic.isDisplayed()){
                adClose_btn.click();
                TimeUnit.SECONDS.sleep(1);
            }*/
        } catch (Exception e){}

        return new MarketPage(driver);
    }

    public ReceiptPage enterReceiptPage(){
//        try {
//            TimeUnit.SECONDS.sleep(2);
//            // if page display AD , cloese the AD
//            if (ad_pic.isDisplayed()){
//                adClose_btn.click();
//                TimeUnit.SECONDS.sleep(1);
//            }
//        }catch (Exception e){}
        receipt_btn.click();
        return new ReceiptPage(driver);
    }

    public String getTrxCount() throws Exception {
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        String trxCount = trxValue.getText().split(" ")[0];
        return trxCount;
    }

    public AddAssertPage enterAddAssertPage(){
//        try {
//            TimeUnit.SECONDS.sleep(2);
//            // if page display AD , cloese the AD
//            if (ad_pic.isDisplayed()){
//                adClose_btn.click();
//                TimeUnit.SECONDS.sleep(1);
//            }
//        }catch (Exception e){}
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        addAssert_btn.click();
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        return new AddAssertPage(driver);
    }


    public FrozenAndUnfreezePage enterFrozenAndUnfreezePage(){
        try {
            TimeUnit.SECONDS.sleep(2);
            freeze_btn.click();
            TimeUnit.SECONDS.sleep(3);
        }catch (Exception e){
            freeze_btn.click();
        }
        return new FrozenAndUnfreezePage(driver);
    }




    public MinePage enterMinePage(){
        try {
            TimeUnit.SECONDS.sleep(2);
            waiteTime();
            mine_btn.click();
        } catch (Exception e ){};
        waiteTime();
        mine_btn.click();
        return new MinePage(driver);
    }



    public DiscoverPage enterDiscoverPage() throws Exception{
        TimeUnit.SECONDS.sleep(3);
        discover_btn.click();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        TimeUnit.SECONDS.sleep(10);
        return new DiscoverPage(driver);
    }


    public TrxPage enterTrxPage() throws Exception {
        waiteTime();
        Helper.scrollToElementUntilVisible(driver,trx_btn);
        waiteTime();
        trx_btn.click();
        waiteTime();
        return new TrxPage(driver);
    }

    //入参0，为代表进入trx 详细交易页面；入参1，为代表进入trc10详细交易页面；入参2，为代表进入trc20详细交易页面
    public TransactionDetailInfomaitonPage enterTransactionDetailPage(Integer type) throws Exception {
        TrxPage trx;
        switch (type) {
            case 0 :
                trx = enterTrxPage();
                break;
            case 1 :
                trx = enterTrx10Page();
                break;
            case 2 :
                trx = enterTrx20Page();
                break;
            case 3 :
                trx = publicAccountEnterTrzPage();
                break;
            default :
                trx = enterTrxPage();
        }
        waiteTime();
        trx.tranfer_tab.get(1).click();
        waiteTime();
        trx.tranferIncount_text.get(1).click();
        waiteTime();
        TimeUnit.SECONDS.sleep(3);
        return new TransactionDetailInfomaitonPage(driver);
    }

    public TransactionDetailInfomaitonPage pubilcEnterTrzReceiveTransactionDetailPage() throws Exception {
        TrxPage trx = publicAccountEnterTrzPage();
        trx.tranfer_tab.get(2).click();
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        trx.tranferIncount_text.get(1).click();
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        TimeUnit.SECONDS.sleep(3);
        return new TransactionDetailInfomaitonPage(driver);
    }

    //0代表进入第一条转账接收页面，1代编进入第一条收款接收页面
    public TransactionDetailInfomaitonPage enterTrzTransactionDetailPage(Integer type) throws Exception {
        TrzPage trz = enterTrzPage();

        switch (type) {
            case 0 :
                trz.tranfer_tab.get(1).click();
                break;
            case 1 :
                trz.tranfer_tab.get(2).click();
                break;
            default :
                trz.tranfer_tab.get(0).click();
        }

        driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
        trz.tranferRecordCount_text.get(1).click();
        driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
        return new TransactionDetailInfomaitonPage(driver);
    }


    //入参0，为代表进入trx 详细交易页面；入参1，为代表进入trc10详细交易页面；入参2，为代表进入trc20详细交易页面
    public TransactionDetailInfomaitonPage enterReceiverTransactionDetailPage(Integer type) throws Exception {
        TrxPage trx;
        switch (type) {
            case 0 :
                trx = enterTrxPage();
                break;
            case 1 :
                trx = enterTrx10Page();
                break;
            case 2 :
                trx = enterTrx20Page();
                break;
            default :
                trx = enterTrxPage();
        }
        trx.tranfer_tab.get(2).click();
        driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
        trx.tranferIncount_text.get(1).click();
        driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
        return new TransactionDetailInfomaitonPage(driver);
    }


    //入参0，为代表进入trx 详细交易页面；入参1，为代表进入trc10详细交易页面；入参2，为代表进入trc20详细交易页面
    public TransactionDetailInfomaitonPage enterDepositTransactionDetailPage(Integer type) throws Exception {
        TrxPage trx;
        switch (type) {
            case 0 :
                trx = enterTrxPage();
                break;
            case 1 :
                trx = enterTrx10Page();
                break;
            case 2 :
                trx = enterTrx20Page();
                break;
            default :
                trx = enterTrxPage();
        }
        trx.tranfer_tab.get(3).click();
        driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
        trx.tranferIncount_text.get(1).click();
        driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
        return new TransactionDetailInfomaitonPage(driver);
    }

    //入参0，为代表进入trx 详细交易页面；入参1，为代表进入trc10详细交易页面；入参2，为代表进入trc20详细交易页面
    public TransactionDetailInfomaitonPage enterWithdrawTransactionDetailPage(Integer type) throws Exception {
        TrxPage trx;
        switch (type) {
            case 0 :
                trx = enterTrxPage();
                break;
            case 1 :
                trx = enterTrx10Page();
                break;
            case 2 :
                trx = enterTrx20Page();
                break;
            default :
                trx = enterTrxPage();
        }
        trx.tranfer_tab.get(3).click();
        driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
        trx.tranferIncount_text.get(1).click();
        driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
        return new TransactionDetailInfomaitonPage(driver);
    }





    public TrzPage enterTrzPage() throws Exception {
        waitShieldDataSynFinished();
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        try {
            mine_btn.click();
            assetsMain_btn.click();
        } catch (Exception e) {
            assetsMain_btn.click();
        }
        TimeUnit.SECONDS.sleep(1);
        trz_btn.click();
        TimeUnit.SECONDS.sleep(10);
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        return new TrzPage(driver);
    }

    public TrxPage publicAccountEnterTrzPage() throws Exception {
        TimeUnit.SECONDS.sleep(1);
        waiteTime();
        mine_btn.click();
        waiteTime();
        assetsMain_btn.click();
        Helper.swipScreen(driver);
        TimeUnit.SECONDS.sleep(1);
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        Helper.swipScreen(driver);
        try {
            waiteTime();

            public_account_trz_btn.click();
        } catch (Exception e) {
            public_account_trz_btn.click();
        }
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        TimeUnit.SECONDS.sleep(1);
        return new TrxPage(driver);
    }

    public TrxPage enterTrx20Page() throws Exception {

        Helper.swipScreen(driver);
        TimeUnit.SECONDS.sleep(1);

        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        System.out.printf("asset_names.size() :  " +  asset_names.size());
        for (int i = 1; i < asset_names.size(); i++) {
            System.out.printf("asset_names item " + i + "  :  " +  asset_names.get(i).getText());

            if (asset_names.get(i).getText().contains("TRX")){
                System.out.println("从第" + i + "个找到了 TRX20币");
                asset_names.get(i).click();
                break;
            }
        }

        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        return new TrxPage(driver);

    }


    public TrxPage enterTrx10Page() throws Exception {
        TimeUnit.SECONDS.sleep(1);
        try {
            waiteTime();
            mine_btn.click();
        } catch (Exception e) {
        }
        waiteTime();
        assetsMain_btn.click();
        Helper.swipScreen(driver);
        TimeUnit.SECONDS.sleep(1);
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        Helper.swipScreen(driver);
        try {
            waiteTime();
            trx10_btn.click();
        } catch (Exception e) {
            if (trx10_icon_btns.size() > 2){
                trx10_icon_btns.get(1).click();
            }
        }
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        TimeUnit.SECONDS.sleep(2);
        return new TrxPage(driver);
    }

    public TrxPage enterOnlineTrc10Page() throws Exception {
        TimeUnit.SECONDS.sleep(1);
        try {
            mine_btn.click();
        } catch (Exception e) {
            mine_btn.click();
        }
        mine_btn.click();
        assetsMain_btn.click();
        //Helper.swipScreen(driver);
        TimeUnit.SECONDS.sleep(1);
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        //Helper.swipScreen(driver);
        try {
            online_trc10_btn.click();
        } catch (Exception e) {
            online_trc10_btn.click();
        }
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        TimeUnit.SECONDS.sleep(2);
        return new TrxPage(driver);
    }





    public TrxPage enterOnlineTrc20Page() throws Exception {
        mine_btn.click();
        assetsMain_btn.click();
        //Helper.swipScreen(driver);
        TimeUnit.SECONDS.sleep(3);
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        online_trc20_btn.click();
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        TimeUnit.SECONDS.sleep(1);
        return new TrxPage(driver);
    }



    public MyPursePage enterMyPursePage() throws Exception {
        walletName_text.click();
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        return new MyPursePage(driver);
    }



}
