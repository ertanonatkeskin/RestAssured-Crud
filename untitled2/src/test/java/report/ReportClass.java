package report;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ReportClass {

    public static ExtentHtmlReporter htmlReporter;
    public static ExtentReports extent;

    public static ExtentHtmlReporter getHtmlReporter() {
        return htmlReporter;
    }

    public static void setHtmlReporter(ExtentHtmlReporter htmlReporter) {
        ReportClass.htmlReporter = htmlReporter;
    }

    public static ExtentReports getExtent() {
        return extent;
    }

    public static void setExtent(ExtentReports extent) {
        ReportClass.extent = extent;
    }

    public static ExtentTest getTest() {
        return test;
    }

    public static void setTest(ExtentTest test) {
        ReportClass.test = test;
    }

    public static ExtentTest test;

    public ReportClass(String reportName)
    {
        DateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd HH-mm-ss");

        String destDir = dateFormat.format(new Date()) + ".html";

        htmlReporter = new ExtentHtmlReporter(".//testoutput//"+reportName+"_"+destDir+"");

        htmlReporter.config().setDocumentTitle("Automation Report for "+reportName+"");
        htmlReporter.config().setReportName("Regression Testing For "+reportName+"");
        htmlReporter.config().setTheme(Theme.DARK);

        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);


        //General info
        extent.setSystemInfo("Host name", "");
        extent.setSystemInfo("Environemnt", "");
        extent.setSystemInfo("user", "");
    }

    public void CreateTest(String testName)
    {
        test = extent.createTest(testName);
    }

    public void Close()
    {
        extent.flush();
    }

    public void FailedTest(String message)
    {
        test.fail(message);
    }
    public void FailedTestCaseMessage(String message)
    {
        test.fail(message);
    }

    public void PassedTest(String message)
    {
        test.pass(message);
    }

    public void SkipTest(String message)
    {
        test.skip(message);
    }

    public void LogInfo(String message)
    {
        test.info(message);
    }

}
