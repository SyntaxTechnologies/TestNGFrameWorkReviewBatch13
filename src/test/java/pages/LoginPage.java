package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class LoginPage extends CommonMethods {
    @FindBy(id="txtUsername")
    public WebElement usernameBox;

    @FindBy(name="txtPassword")
    public WebElement passwordBox;

    @FindBy(id="btnLogin")
    public WebElement loginBtn;

    @FindBy(xpath="//*[@id=\"divLogo\"]/img")
    public  WebElement logo;

    @FindBy(id="spanMessage")
    public WebElement errorMessage;

    @FindBy(id="logInPanelHeading")
    public WebElement LoginPanel;

    public LoginPage(){
        PageFactory.initElements(driver, this);
    }

    public void LoginMethod(String username , String password){
        sendText(usernameBox,username);
        sendText(passwordBox,password);
        loginBtn.click();

    }

}

