package appium1.listeners;

import appium1.common.ReRun;
import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class ReRunListener implements IAnnotationTransformer {

    public void transform(ITestAnnotation iTestAnnotation, Class aClass, Constructor constructor, Method method) {
        IRetryAnalyzer iRetryAnalyzer = iTestAnnotation.getRetryAnalyzer();
        if(iRetryAnalyzer == null){
            iTestAnnotation.setRetryAnalyzer(ReRun.class);
        }
    }
}
