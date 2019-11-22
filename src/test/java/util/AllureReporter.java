package util;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import ru.yandex.qatools.allure.annotations.Attachment;
import steps.BaseSteps;

public class AllureReporter  extends ru.yandex.qatools.allure.cucumberjvm.AllureReporter {

        @Override
        public void result(gherkin.formatter.model.Result result) {
            if(result.getStatus().equals("failed")) {
                takeScreenshot();
            }
            super.result(result);
        }


        @Attachment(type = "img/png",value = "Screen on error")
        public byte[] takeScreenshot(){
            return ((TakesScreenshot) BaseSteps.getMydriver()).getScreenshotAs(OutputType.BYTES);
        }
    }

