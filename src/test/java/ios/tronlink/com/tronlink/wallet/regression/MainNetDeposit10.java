package ios.tronlink.com.tronlink.wallet.regression;

import ios.tronlink.com.tronlink.wallet.UITest.base.BaseTest;
import ios.tronlink.com.tronlink.wallet.UITest.pages.*;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class MainNetDeposit10 extends BaseTest {




    //enter SettingPage
    public SettingPage enterSettingPage() throws Exception {
        AssetPage asset = new AssetPage(DRIVER);
        MinePage mine = asset.enterMinePage();
        return mine.enterSettingPage();
    }



    //enter TRXPage
    public TrxPage enterTrxPage() throws Exception{
        SettingPage set = enterSettingPage();
        NodeSetPage nodeSet = set.enterNodeSetPage();
        set = nodeSet.enterSettingPageChoiseMainChain();
        MinePage mine  = set.enterMinePage();
        AssetPage asset = mine.enterAssetPage();
        return asset.enterTrx10Page();
    }




    @Test(description = "Change Chain",alwaysRun = true)
    public void test001_changeChain() throws Exception {
        SettingPage set = enterSettingPage();
        String nodeName = set.node_name.getText();
        NodeSetPage nodeSet = set.enterNodeSetPage();
        set = nodeSet.enterSettingPageChoiseDappChain();
        String currentNodeName = set.node_name.getText();
        Assert.assertNotEquals(nodeName,currentNodeName);
    }



    @Test(description = "Check TransferIn Chain Name",alwaysRun = true)
    public void test002_checkTransferInChainName() throws Exception {
        TrxPage trx = enterTrxPage();
        TransferPage transferIn = trx.enterTransferPage();
        String chain = transferIn.chain_text.getText();
        Assert.assertTrue(chain.equals("DAppChain"));
    }




    @Test(description = "Check TransferIn Trc10 Count",alwaysRun = true)
    public void test003_checkTransferInTrc10() throws Exception {
        TrxPage trx = enterTrxPage();
        TransferPage transferIn = trx.enterTransferPage();
        String info = transferIn.getTransferInfo("trx");
        Assert.assertTrue(info.contains("10"));
    }



    @Test(description = "Check TransferIn Hits",alwaysRun = true)
    public void test004_checkTransferInHits() throws Exception {
        TrxPage trx = enterTrxPage();
        TransferPage transferIn = trx.enterTransferPage();
        String info = transferIn.getTransferInfo("hits");
        Assert.assertTrue(info.equals("转入需要执行智能合约。执行智能合约同时会消耗 Energy。") || info.contains("requires the execution of a smart contract"));
    }



    @Test(description = "Check TransferIn Fee",alwaysRun = true)
    public void test005_checkTransferInFee() throws Exception {
        TrxPage trx = enterTrxPage();
        TransferPage transferIn = trx.enterTransferPage();
        String info = transferIn.getTransferInfo("fee");
        int count = Integer.valueOf(info);
        Assert.assertTrue(50 <= count && count <= 500);
    }



    @Test(description = "Check Available Balance",enabled = false)
    public void test006_checkAvailableBalance() throws Exception {
        SettingPage set = enterSettingPage();
        NodeSetPage nodeSet = set.enterNodeSetPage();
        set = nodeSet.enterSettingPageChoiseMainChain();
        MinePage mine  = set.enterMinePage();
        AssetPage asset = mine.enterAssetPage();
        int trxCount = Integer.valueOf(removeSymbol(asset.getTrxCount()));
        TrxPage trx = asset.enterTrx10Page();
        int frozenCount = Integer.valueOf(removeSymbol(trx.freezeCount_text.getText()));
        TransferPage transferIn = trx.enterTransferPage();
        int availableBalance = Integer.valueOf(removeSymbol(transferIn.availableBalance_text.getText().split(" ")[1]));
        Assert.assertTrue(trxCount == frozenCount + availableBalance);
    }



    @Test(description = "TransferIn Success Checkout Available trc10",alwaysRun = true)
    public void test007_checkAvailableBalance() throws Exception {
        TrxPage trx = enterTrxPage();
        int trxCount = Integer.valueOf(removeSymbol(trx.trxTotal_text.getText()));
        TransferPage transferIn =  trx.enterTransferPage();
        trx = transferIn.enterTrxPageWithTransferSuccess();
        int trxCountNow = Integer.valueOf(removeSymbol(trx.trxTotal_text.getText()));
        Assert.assertTrue(trxCount >= trxCountNow + 10);
    }



    @Test(description = "TransferIn Success Recording",alwaysRun = true)
    public void test008_transferInSuccessRecording() throws Exception {
        TrxPage trx = enterTrxPage();
        TransferPage transferIn =  trx.enterTransferPage();
        String count = random(10,10);
        trx = transferIn.enterTrxPageWithTransferSuccess(count);
        int tries = 0;
        Boolean exist = false;
        while(exist == false && tries < 7) {
            tries++;
            try {
                AssetPage arret = trx.enterAssetPage();
                trx = arret.enterTrx10Page();
                trx.tranfer_tab.get(3).click();
                TimeUnit.SECONDS.sleep(3);
                String tranferInCount = trx.tranferIncount_text.get(1).getText().split(" ")[1];
                if (count.equals(tranferInCount)){
                    exist = true;
                    break;
                }
            }catch (Exception e){}
        }
        Assert.assertTrue(exist);
    }

}