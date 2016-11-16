package utils;


import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class TestListenerCustom extends TestListenerAdapter {

    @Override
    public void onTestFailure(ITestResult tr){
        super.onTestFailure(tr);
        AllUtlis.makeScreenshot("failure screenshot");
    }

}
