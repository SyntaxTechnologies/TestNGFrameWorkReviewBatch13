package utils;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class listeners implements ITestListener {

    @Override
    public void onTestSuccess(ITestResult result){
        CommonMethods.takeScreenshot("passed"+result.getName());
    }

}
