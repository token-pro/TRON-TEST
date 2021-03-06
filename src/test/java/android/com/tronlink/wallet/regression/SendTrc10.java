package android.com.tronlink.wallet.regression;

import android.com.utils.Configuration;
import android.com.wallet.UITest.base.Base;
import android.com.wallet.pages.*;
import android.com.utils.Helper;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringUtils;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SendTrc10 extends Base {
    Random rand = new Random();
    float sendTrxAmount;
    int beforeSendBalance;
    int afterSendBalance;
    static String receiverAddress = Configuration.getByPath("testng.conf")
            .getString("foundationAccount.receiverAddress");
    static String currentMainNetBlockNum = Configuration.getByPath("testng.conf")
            .getString("foundationAccount.currentMainNetBlockNum");
    static String trc10TokenName = Configuration.getByPath("testng.conf")
            .getString("foundationAccount.trc10TokenName");
    static String TRXandTRC10InNileprivateKey = Configuration.getByPath("testng.conf")
            .getString("HaveTRXandTRC10InNile.privateKey1");
    static String haveBandwidthprivateKey = Configuration.getByPath("testng.conf")
            .getString("HaveBandWidthInNile.privateKey1");

    @Parameters({"privateKey"})
    @BeforeClass(alwaysRun = true)
    public void setUpBefore(String privateKey) throws Exception {
        System.out.println("执行setUpBefore");
        new Helper().getSign(privateKey, DRIVER);
    }


    @AfterMethod(alwaysRun = true)
    public void afterMethod() {
        try {
            DRIVER.closeApp();
            DRIVER.activateApp("com.tronlinkpro.wallet");
        } catch (Exception e) {
        }
    }


    @AfterClass(alwaysRun = true)
    public void tearDownAfterClass() {
        try {
            DRIVER.quit();
        } catch (Exception e) {
        }
    }


    public SendTrxPage enterToSendTrxPage() {
        AssetPage asset = new AssetPage(DRIVER);
        SendTrxPage transfer = asset.enterSendTrxPage();
        return transfer;
    }


    @Test(groups = {"P0"}, enabled = true, description = "SendTrc10 success test", alwaysRun = true)
    public void test001_sendTrc10Success() throws Exception {
        AssetPage asset = new AssetPage(DRIVER);
        asset.mine_btn.click();
        asset.assetsMain_btn.click();
        SendTrxPage transfer = asset.enterSendTrc10Page();
        beforeSendBalance = Integer.valueOf(removeSymbol(transfer.balance_text.getText().split(" ")[1]));
        sendTrxAmount = getAnAmount();
        transfer.sendTrc10(Float.toString(sendTrxAmount));
    }

    @Test(enabled = true, description = "input max send number", alwaysRun = true)
    public void test002_inputMaxSendNumber() throws Exception {
        SendTrxPage transfer = enterToSendTrxPage();
        transfer.sendAllTrc10("max");
        Assert.assertTrue(transfer.transferNow_btn.isEnabled());
    }

    //使用一个没有足够冻结带宽的账户,点击转账会出现激活消耗的0.1trx
    @Test(enabled = true,description = "test003_inputNotEnoughBandWidthSendMax20NumberUNActive")
    public void test003_inputNotEnoughBandWidthSendMax10NumberUNActive() throws Exception {
        DRIVER.resetApp();
        new Helper().getSign(TRXandTRC10InNileprivateKey,DRIVER);
        SendTrxPage transfer = enterToSendTrxPage();
        Float allNumber =   sepRightNumberTextToFloat(transfer.sendMaxCoinWithType("10"),"可转账数量");
        Float number =  sepLeftNumberTextToFloat(transfer.real_money.getText(),"tronlink_token");
        Assert.assertEquals(sepLeftNumberTextToString(transfer.fee_text.getText(),"TRX"),"0.1");
        Assert.assertEquals(allNumber,number);
        Assert.assertFalse(transfer.isElementExist("com.tronlinkpro.wallet:id/tv_no_bandwidth"));
    }

    //max 未激活的显示
    @Test(enabled = true, description = "test004_inputHaveBandWidthSendMax10NumberToUNActive")
    public void test004_inputHaveBandWidthSendMax10NumberToUNActive() throws Exception {
        DRIVER.resetApp();
        new Helper().getSign(haveBandwidthprivateKey,DRIVER);
        SendTrxPage transfer = enterToSendTrxPage();
        Float allNumber = sepRightNumberTextToFloat(transfer.sendMaxCoinWithType("10"), "可转账数量");
        Float number = sepLeftNumberTextToFloat(transfer.real_money.getText(), "tronlink_token");
        Assert.assertTrue(sepLeftNumberTextToFloat(transfer.fee_text.getText(), "TRX") == 0);
        Assert.assertEquals(allNumber, number);
        Assert.assertFalse(transfer.isElementExist("com.tronlinkpro.wallet:id/tv_no_bandwidth"));


    }

    @Parameters({"privateKey"})
    @Test(enabled = true, description = "input mix send number", alwaysRun = true)
    public void test005_inputMixSendNumber(String privateKey) throws Exception {
        DRIVER.resetApp();
        new Helper().getSign(privateKey,DRIVER);
        SendTrxPage transfer = enterToSendTrxPage();
        transfer.sendAllTrc10("mix");
        String centent = transfer.formatErrorHits_text.getText();
        Assert.assertTrue(centent.contains("转账金额需大于 0") || centent.equals("转账金额需大于0") || centent.contains("greater than 0"));
    }


    @Test(enabled = true, description = "input too Much trc10 send number", alwaysRun = true)
    public void test006_inputTooMuchSendNumber() throws Exception {
        SendTrxPage transfer = enterToSendTrxPage();
        transfer.sendAllTrc10("tooMuch");
        String centent = transfer.formatErrorHits_text.getText();
        Assert.assertTrue(centent.equals("余额不足") || centent.equals("insufficient balance"));
    }


    @Test(enabled = true, description = "trc10 check 10name", alwaysRun = true)
    public void test007_check10Name() throws Exception {
        AssetPage asset = new AssetPage(DRIVER);
        TrxPage trxPage = asset.enterTrx10Page();
        SendTrxPage sendTrxPage = trxPage.enterSendTrc10Page();
        //TransferPage transferPage = trxPage.enterTransferPage();
        Assert.assertTrue(sendTrxPage.tvName_text.getText().contains("token"));
    }


    @Test(groups = {"P0"}, enabled = true, description = "Trc10 transfer success recording")
    public void test008_trc10TransferInSuccessRecording() throws Exception {
        AssetPage asset = new AssetPage(DRIVER);
        TrxPage trx = asset.enterTrx10Page();
        trx.tranfer_tab.get(1).click();
        System.out.println(trx.tranferIncount_text.get(1).getText());
        String tranferInCount = trx.tranferIncount_text.get(1).getText().substring(1);
        Assert.assertTrue(Float.toString(sendTrxAmount).substring(0, 5).equals(tranferInCount.substring(0, 5)));
    }

    @Test(enabled = true, description = "Trc10 transfer balance decrease check")
    public void test009_trc10BalanceReduceAfterSendCoin() throws Exception {
        AssetPage asset = new AssetPage(DRIVER);
        SendTrxPage transfer = asset.enterSendTrc10Page();
        afterSendBalance = Integer.valueOf(removeSymbol(transfer.balance_text.getText().split(" ")[1]));
        System.out.println("beforeSendBalance:" + beforeSendBalance);
        System.out.println("afterSendBalance:" + afterSendBalance);
        Assert.assertTrue(beforeSendBalance - afterSendBalance >= 1);
    }

    @Test(enabled = true, description = "test015_BandWidthShowTest", alwaysRun = true)
    public void test010_BandWidthShowTest() throws Exception {
        AssetPage asset = new AssetPage(DRIVER);
        SendTrxPage transfer = asset.enterSendTrc10Page();
        transfer.receiveAddress_text.sendKeys("TG5wFVvrJiTkBA1WaZN3pzyJDfkgHMnFrp");
        transfer.tranferCount_text.sendKeys("0.000001");
        transfer.send_btn.click();
        waiteTime();
        String content = transfer.bandwidth_text.getText();
        String number = StringUtils.substringBeforeLast(content, "带宽");
        Assert.assertTrue(Integer.parseInt(number.trim()) > 0);
    }

    @Test(enabled = true, description = "TRC10 transfer history record test", alwaysRun = true)
    public void test011_transactionRecord() throws Exception {
        AssetPage asset = new AssetPage(DRIVER);
        MinePage mine = asset.enterMinePage();
        TransactionRecordPage transaction = mine.enterTransactionRecordPage();
        String transactionType = transaction.transactionTypeList.get(0).getText();
        System.out.println(transactionType);
        Assert.assertTrue(transactionType.contains("转账 TRC10 通证") || transactionType.contains("TRC10") || transactionType.equals("transfer TRC10 token"));
    }

    @Parameters({"address"})
    @Test(enabled = true, description = "Trc10 transaction detail info test", alwaysRun = true)
    public void test012_trc10TransactionDetailInfo(String address) throws Exception {
        AssetPage asset = new AssetPage(DRIVER);
        TransactionDetailInfomaitonPage transactionInfo = asset.enterTransactionDetailPage(1);
        Assert.assertEquals(transactionInfo.sendAddress_text.getText(), address);
        Assert.assertEquals(transactionInfo.receiverAddress_text.getText(), receiverAddress);
        Assert.assertEquals(transactionInfo.txid_hash_test.getText().length(), 64);
        Assert.assertTrue(transactionInfo.transaction_time_text.getText().contains("202"));
        Assert.assertTrue(transactionInfo.title_amount_test.getText().contains(trc10TokenName));

        System.out.println(transactionInfo.title_amount_test.getText());
        System.out.println(transactionInfo.title_amount_test.getText().split(" ")[0]);
        String detailPageSendAmount = transactionInfo.title_amount_test.getText().split(" ")[0];
        Assert.assertEquals(detailPageSendAmount.substring(1, 7), String.valueOf(sendTrxAmount).substring(0, 6));
        Assert.assertTrue(Long.valueOf(transactionInfo.block_num_text.getText())
                > Long.valueOf(currentMainNetBlockNum));

        Helper.swipScreen(transactionInfo.driver);
        Assert.assertTrue(transactionInfo.transaction_QRCode.isDisplayed());
        Assert.assertTrue(transactionInfo.to_tronscan_btn.isEnabled());

        String number = StringUtils.substringBeforeLast(transactionInfo.resouce_cost.getText(), "带宽");
        Assert.assertTrue(Integer.parseInt(number.trim()) > 0);
    }


    @Parameters({"address"})
    @Test(enabled = true, description = "Trc10 receive transaction detail info test", alwaysRun = true)
    public void test013_trc10ReceiveTransactionDetailInfo(String address) throws Exception {
        AssetPage asset = new AssetPage(DRIVER);
        TransactionDetailInfomaitonPage transactionInfo = asset.enterReceiverTransactionDetailPage(1);
        System.out.println(transactionInfo.title_amount_test.getText());
        System.out.println(transactionInfo.title_amount_test.getText().split(" ")[1]);
        String detailPageReceiveAmount = transactionInfo.title_amount_test.getText().split(" ")[0];
        String receiveIcon = transactionInfo.title_amount_test.getText().split(" ")[0];
        Assert.assertTrue(receiveIcon.contains("+"));
        Assert.assertTrue(transactionInfo.title_amount_test.getText().contains(trc10TokenName));
        Assert.assertEquals(transactionInfo.receiverAddress_text.getText(), address);
        Assert.assertEquals(transactionInfo.txid_hash_test.getText().length(), 64);
        Assert.assertTrue(transactionInfo.transaction_time_text.getText().contains("202"));
        Assert.assertTrue(Float.valueOf(removeSymbol(detailPageReceiveAmount)) > 0);
        Assert.assertTrue(Long.valueOf(transactionInfo.block_num_text.getText())
                > Long.valueOf(currentMainNetBlockNum));
        Helper.swipScreen(transactionInfo.driver);
        TimeUnit.SECONDS.sleep(1);
        Assert.assertTrue(transactionInfo.transaction_QRCode.isDisplayed());
        Assert.assertTrue(transactionInfo.to_tronscan_btn.isEnabled());
        String number = StringUtils.substringBeforeLast(transactionInfo.resouce_cost.getText(), "带宽");
        Assert.assertTrue(Integer.parseInt(number.trim()) >= 0);
    }


}
