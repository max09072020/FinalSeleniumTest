package util;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import ru.yandex.qatools.allure.Allure;
import ru.yandex.qatools.allure.events.MakeAttachmentEvent;
import steps.BaseSteps;

public class AllureReporter  extends ru.yandex.qatools.allure.cucumberjvm.AllureReporter {

        @Override
        public void result(gherkin.formatter.model.Result result) {
            if("failed".equals(result.getStatus())) {
                takeScreenshot(result);
            }
            super.result(result);
        }
    public void takeScreenshot(gherkin.formatter.model.Result step) {
        if (BaseSteps.getMydriver() != null) {
            Allure.LIFECYCLE.fire(new MakeAttachmentEvent(((TakesScreenshot) BaseSteps.getMydriver()).getScreenshotAs(OutputType.BYTES),
                    "Скриншот в момент ошибки", "image/png"));
        }
    }

//        @Attachment(value = "Screen on error", type = "image/png")
//        public byte[] takeScreenshot(){
//            return ((TakesScreenshot) BaseSteps.getMydriver()).getScreenshotAs(OutputType.BYTES);
//        }
    }

