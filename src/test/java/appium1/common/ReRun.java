package appium1.common;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class ReRun implements IRetryAnalyzer {
    int index = 0;
    int retryCount = 1;

    public boolean retry(ITestResult iTestResult) {
        if(index < retryCount){
            index++;
            return true;
        }
        return false;
    }
}
