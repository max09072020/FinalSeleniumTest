package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import steps.BaseSteps;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class ActionPage {

    @FindBy(xpath = "//div[@data-zone-name='search-filters-aside']")
    public WebElement filter;

    @FindBy(xpath = "//p[@data-range-input-type='from']//input")
    public WebElement priceFrom;

    @FindBy(xpath = "//span[@class='input__box']//input")
    public WebElement searchField;

    @FindBy(xpath = "//label[contains(@class, 'radio-button')]//input[@value='list']")
    public WebElement expandList;

    public ActionPage (){
        PageFactory.initElements(BaseSteps.getMydriver(), this);
        BaseSteps.getMydriver().manage().timeouts().pageLoadTimeout(12, TimeUnit.SECONDS);
    }

    public void fillField (WebElement element, String value){
        element.clear();
        element.sendKeys(value);
    }

    public void fillPrice (String price){
        fillField(priceFrom, price);
    }


    public void checkBoxSet (String filterName, String charecter){
        WebElement element = filter.findElement(By.xpath("//legend[text()='" + filterName + "']//..//input[@type='checkbox']//..//span[text()='" + charecter + "']"));
        element.click();
        BaseSteps.getMydriver().manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
    }

    public ArrayList<String> resultList (){
        List<WebElement> searchList = BaseSteps.getMydriver().findElements(By.xpath("//h3[@class='n-snippet-card2__title']"));
        List <String> titles = searchList.stream().map(WebElement::getText).collect(Collectors.toList());
        return (ArrayList<String>) titles;
    }

    public void search (String searchValue){
        fillField(searchField, searchValue);
        searchField.sendKeys(Keys.ENTER);
    }
}
