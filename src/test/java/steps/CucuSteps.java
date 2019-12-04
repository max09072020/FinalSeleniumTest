package steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.ActionPage;
import pages.MainPage;

import java.util.concurrent.TimeUnit;

public class CucuSteps {

    MainPage mainPage = new MainPage();
    ActionPage actionPage = new ActionPage();

    @When("^пользователь выбирает вкладку \"(.*)\" на панели навигации$")
    public void selectMainMenuStep (String menuTab){
        mainPage.selectMainMenu(menuTab);
    }

    @When("^пользователь выбирает отдел \"(.*)\" в Яндекс маркете$")
    public void selectMarketMenuStep (String tab){
        mainPage.selectMarketMenu(tab);
    }

    @When("^пользователь выбирает раздел \"(.*)\" в подМеню$")
    public void selectSubMenuStep (String subItem){
        mainPage.selectSubMenu(subItem);
    }
    @When("^пользователь проверяет, что он в правильном разделе \"(.*)\"$")
    public void checkPage (String  title){
        Assert.assertEquals(BaseSteps.getMydriver().getTitle(), title + " — купить на Яндекс.Маркете");
    }

    @When("^пользователь устанавливает минимальную сумму в \"(.*)\" в фильтре$")
    public void selectMinAmountStep (String minAmount) {
        actionPage.fillPrice(minAmount);
    }

    @When("^пользователь просматривает сообщение о найденых товарах$")
    public void lookForSearchMessage (){
        WebElement element = null;
        WebDriverWait wait = new WebDriverWait(BaseSteps.getMydriver(), 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("_1RqJzaMsJQ _1yevJbN4UM _3zMtk0OXjW")));
        element = BaseSteps.getMydriver().findElement(By.xpath("//div[@data-d6578eea ='true']//div[@class='_1RqJzaMsJQ _1yevJbN4UM _3zMtk0OXjW']"));
        if (element != null){
            System.out.println(element.getAttribute("innetText"));
        }

    }

    @When("пользователь задаёт характеристики поиска$")
    public void customerChoice (DataTable table){
        table.asMap(String.class, String.class).forEach((key,value) -> actionPage.checkBoxSet(key,value));
        BaseSteps.getMydriver().manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

    }

    @When("пользователь проверяет, что по результату поиска получено \"(.*)\" элементов$")
    public void checkResults (String value){
        BaseSteps.getMydriver().navigate().refresh();
        int newValue = Integer.parseInt(value);
        Assert.assertTrue(newValue <= actionPage.resultList().size());
    }

    @When("пользователь вводит \"(.*)\" элемент в поле поиска$")
    public void searchAny (String searchVal){
        BaseSteps.getMydriver().manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
        int index = Integer.parseInt(searchVal);
        actionPage.search(actionPage.resultList().get(index - 1));
        BaseSteps.getMydriver().manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
    }

    @When("пользователь проверяет что товар соответствует найденому")
    public void checkTheItem (){
        Assert.assertEquals(actionPage.resultList().get(0), actionPage.searchField.getAttribute("value"));
    }

    @When("пользователь разворачивает варианты поиска")
    public void expandSearch(){
        actionPage.expandList.click();
    }
}