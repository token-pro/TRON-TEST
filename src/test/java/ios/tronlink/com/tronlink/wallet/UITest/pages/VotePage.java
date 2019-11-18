package ios.tronlink.com.tronlink.wallet.UITest.pages;

import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.concurrent.TimeUnit;


public class VotePage extends AbstractPage {


    public IOSDriver<?> driver;

    public VotePage(IOSDriver<?> driver) {
        super(driver);
        this.driver = driver;
    }

//    @FindBy(xpath = "(//XCUIElementTypeButton[@name='投票'])[3]")
//    public WebElement voteTitle_btn;
@FindBy(xpath = "(//XCUIElementTypeButton[@name='投票'])[1]")
public WebElement vote_title;

    @FindBy(name = "重置")
    public WebElement reset_btn;


//    @FindBy(name = "com.tronlink.wallet:id/et_input")

    @FindBy(xpath = "(//XCUIElementTypeApplication[@name='TronLink']/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeTable/XCUIElementTypeCell[2]/XCUIElementTypeTextField")
    public WebElement et_input;


    @FindBy(xpath = "(//XCUIElementTypeButton[@name='投票'])[3]")
    public WebElement vote_btn;

    @FindBy(name = "//XCUIElementTypeStaticText[@name=\"871\"]")
    public WebElement surplusAvailableVote_text;

    @FindBy(name = "com.tronlink.wallet:id/ll_vote_select")
    public WebElement vote_list;

    @FindBy(name = "com.tronlink.wallet:id/tv_all")
    public WebElement all_witness_item;

    @FindBy(name = "com.tronlink.wallet:id/tv_me")
    public WebElement my_voted_item;

    @FindBy(name = "com.tronlink.wallet:id/et_input")
    public List<WebElement> all_witness_edit_text;

    @FindBy(name = "com.tronlink.wallet:id/address")
    public List<WebElement> voted_address;

    @FindBy(name = "com.tronlink.wallet:id/tv_vote_role")
    public WebElement myVoteAndAllWitnessList;

    @FindBy(name = "com.tronlink.wallet:id/tv_person_name")
    public List<WebElement> myVotesNetInfoList;

    @FindBy(name = "com.tronlink.wallet:id/et_search")
    public WebElement search_edit_text;



    @FindBy(xpath = "//*[@text='可用投票数不足']")
    public WebElement availableVote_toast;

    @FindBy(xpath = "//*[@text='Insufficient number of votes available']")
    public WebElement english_availableVote_toast;

    @FindBy(xpath = "//*[@text='投票数为空']")
    public WebElement availableVote_toast_null;

    @FindBy(xpath = "//*[@text='0 vote']")
    public WebElement english_availableVote_toast_null;

    public boolean getHits(){
        boolean hits = false;
        try {
            TimeUnit.SECONDS.sleep(2);
        }catch (Exception e) {
            e.printStackTrace();
        }

        if (vote_btn != null) {
            hits = true;
        }
        return hits;
    }

    public boolean getTostInfo() {
        boolean tostInfo = false;
        if (vote_btn != null) {
            tostInfo = true;
        }
        System.out.println(tostInfo);
        return tostInfo;
    }

    public void unusualVoteOperate() throws Exception{
        TimeUnit.SECONDS.sleep(2);
        reset_btn.click();
        int surplusAvailableVoteNum = Integer.parseInt(surplusAvailableVote_text.getText().toString());
        int unusualVoteNum = surplusAvailableVoteNum + 20;
        et_input.sendKeys(String.valueOf(unusualVoteNum));
        vote_btn.click();
    }

    public VoteConfirmPage enterVoteConfirmPage(){
        reset_btn.click();
        et_input.sendKeys("1");
        vote_btn.click();
        return new VoteConfirmPage(driver);
    }

    public void checkTheSecondInfoOfVoted() throws Exception {
        TimeUnit.SECONDS.sleep(1);
        String voteListContent = vote_list.getText();
        if (!voteListContent.equals("我投过的") || !voteListContent.equals("My Votes")) {
            myVoteAndAllWitnessList.click();
            TimeUnit.SECONDS.sleep(1);
            my_voted_item.click();
            TimeUnit.SECONDS.sleep(1);
        }
        TimeUnit.SECONDS.sleep(3);
    }

    public void checkTheSecondInfoOfVoted01() throws Exception {
        TimeUnit.SECONDS.sleep(1);
        String voteListContent = vote_list.getText();
        if (!voteListContent.equals("我投过的") || !voteListContent.equals("My Votes")) {
            myVoteAndAllWitnessList.click();
            TimeUnit.SECONDS.sleep(1);
            my_voted_item.click();
            TimeUnit.SECONDS.sleep(1);
            String voteInfo = myVotesNetInfoList.get(1).getText();
            search_edit_text.sendKeys(voteInfo);
        }
    }

    public VoteConfirmPage setrVotePremise() throws Exception{
        TimeUnit.SECONDS.sleep(2);
        reset_btn.click();
        TimeUnit.SECONDS.sleep(1);
        all_witness_edit_text.get(0).sendKeys("1");
        all_witness_edit_text.get(1).sendKeys("1");
        vote_btn.click();
        TimeUnit.SECONDS.sleep(1);
        return new VoteConfirmPage(driver);
    }

    public VoteConfirmPage confirmVote() {
        return new VoteConfirmPage(driver);
    }






}