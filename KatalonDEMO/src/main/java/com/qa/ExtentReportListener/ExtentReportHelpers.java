package com.qa.ExtentReportListener;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.model.Media;
import com.katalon.util.TestUtil;
import java.io.IOException;
import java.util.Formatter;
import static org.testng.Assert.fail;

public class ExtentReportHelpers {

     public static String message, errorTrace;
     private static String messageHelp;

     public static void FailStep(String format, Object... args) throws IOException {
          message = new Formatter().format(format, args).toString();
          FailStep();
     }

     public static void FailStep() throws IOException {
          messageHelp = "Error at " + message + "\nStackTrace Result: " + errorTrace;
          ExtentReportListener.test.get().log(Status.FAIL, messageHelp, MakeScreenshot());
          fail(messageHelp);
     }

     public static void PassStep(String format, Object... args) throws IOException {
          message = new Formatter().format(format, args).toString();
          PassStep();
     }

     public static void PassStep() throws IOException {
          ExtentReportListener.test.get().log(Status.PASS, message, MakeScreenshot());
     }

     public static void InfoStepSkipped() {
          messageHelp = "Step was Skipped! Condition to " + message + " was not met";
     }

     public static void InfoStepSkipped(String format, Object... args) throws IOException {
          messageHelp = new Formatter().format(format, args).toString();
          InfoStepScreenshot();
     }

     public static void InfoStep(String format, Object... args) {
          message = new Formatter().format(format, args).toString();
          InfoStep();
     }

     public static void InfoStep() {
          ExtentReportListener.test.get().log(Status.INFO, message);
     }


     public static void InfoStepScreenshot()  throws IOException {
          ExtentReportListener.test.get().log(Status.INFO, messageHelp, MakeScreenshot());
     }


     public static Media MakeScreenshot() throws IOException {
          return MediaEntityBuilder.createScreenCaptureFromBase64String("data:image/png;base64,"+ TestUtil.getScreenshot()).build();
     }
}
