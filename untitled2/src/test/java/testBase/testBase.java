package testBase;

import io.restassured.response.Response;



import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.commons.io.output.WriterOutputStream;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;
import report.ReportClass;


import java.io.PrintStream;
import java.io.StringWriter;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;
import java.io.PrintStream;

public class testBase {
    protected static ReportClass extent;
    public static  StringWriter writer;

    public static void writeRequestAndResponseInReport(String request, String response) {

        extent.LogInfo("---- Request ---");
        formatAPIAndLogInReport(request);
        extent.LogInfo("---- Response ---");
        formatAPIAndLogInReport(response);
    }

    public static void formatAPIAndLogInReport(String content) {

        String prettyPrint = content.replace("\n", "<br>");
        extent.LogInfo("<pre>" + prettyPrint + "</pre>");
    }

    Response response;
    public static PrintStream captor;
}
