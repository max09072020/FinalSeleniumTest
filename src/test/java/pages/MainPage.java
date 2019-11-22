package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import steps.BaseSteps;

public class MainPage {


    @FindBy(xpath = "//div[@role='navigation']")
    public WebElement mainNavigationPanel;

    @FindBy(xpath = "//div[@class='n-w-tabs__horizontal-tabs']")
    public WebElement marketNavigationPanel;

    @FindBy(xpath = "//ul[@data-autotest-id='subItems']")
    public WebElement subMenu;

    public MainPage (){ PageFactory.initElements(BaseSteps.getMydriver(), this); }

    public void selectMainMenu (String menuTab){
        mainNavigationPanel.findElement(By.xpath("//a[text() = '" + menuTab + "']")).click();
    }

    public void selectMarketMenu (String marketMenu){
        marketNavigationPanel.findElement(By.xpath("//span[text() ='" + marketMenu + "']")).click();
    }

    public void selectSubMenu (String subItem){
        subMenu.findElement(By.xpath("//a[text() ='" + subItem + "']")).click();
    }
}
