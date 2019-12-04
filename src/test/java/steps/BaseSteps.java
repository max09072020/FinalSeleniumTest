package steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.TestProperties;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseSteps {

    protected static WebDriver mydriver;
    protected static String URL;

    public static Properties properties = TestProperties.getOnlyOne().getProperties();

    public static WebDriver getMydriver() {
        return mydriver;
    }

    @Before
    public void setUp (){
        System.out.println("Открываем браузер и заходим на сайт");
        System.setProperty("webdriver.chrome.driver", properties.getProperty("webdriver.chrome.driver"));
        mydriver = new ChromeDriver();
        URL = properties.getProperty("url");
        mydriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        mydriver.manage().window().maximize();
        mydriver.get(URL);

    }
    @After
    public static void wrapUp() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(BaseSteps.getMydriver(), 3);
        mydriver.quit();

    }
    }

