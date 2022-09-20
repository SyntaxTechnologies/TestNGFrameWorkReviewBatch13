package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

import java.util.List;

public class EmployeeSearchPage extends CommonMethods {

    @FindBy(id="menu_pim_viewPimModule")
    public WebElement pimOption;

    @FindBy(id="menu_pim_addEmployee")
    public WebElement addEmployeeOption;

    @FindBy(id="menu_pim_viewEmployeeList")
    public WebElement empListOption;

    @FindBy(xpath="(//*[@type='text'])[1]")
    public WebElement nameField;

    @FindBy(id="empsearch_id")
    public WebElement idField;

    @FindBy(id="searchBtn")
    public WebElement searchButton;

    @FindBy(xpath = "//*[@id='resultTable']/tbody/tr/td[2]")
    public List<WebElement> rowData;



    public EmployeeSearchPage(){
        PageFactory.initElements(driver, this);
    }

}
