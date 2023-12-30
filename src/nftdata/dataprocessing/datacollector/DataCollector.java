package nftdata.dataprocessing.datacollector;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParser;
import org.json.simple.JSONArray;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataCollector {
    public static final String SEARCH_HASHTAG = "#NFT";
    public static final int SCROLL_TURNS = 10;

    //Extract Hashtags
    static String extractHashtags(WebElement postElement) {
        Pattern pattern = Pattern.compile("#\\w+");
        Matcher matcher = pattern.matcher(postElement.getText());
        StringBuilder hashtagsStringBuilder = new StringBuilder();
        while (matcher.find()) {
            String hashtag = matcher.group();
            hashtagsStringBuilder.append(hashtag).append(" ");
        }
        return hashtagsStringBuilder.toString().trim();
    }

    //Scroll Page
    static void scrollDown(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //Format Date
    static String dateFormat(String inputDate){
        LocalDate dateFormat = LocalDate.parse(inputDate, DateTimeFormatter.ISO_LOCAL_DATE);
        return dateFormat.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    //Open Browser
    static WebDriver openBrowser(){
        System.setProperty("webdriver.edge.driver", "browserDrivers/msedgedriver.exe");
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--start-maximized ", "--disable-extensions");
        WebDriver driver = new EdgeDriver(options);
        return driver;
    }

    //Export JSON
    static void exportJSON(JSONArray jsonArray, String filename){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String formattedJson = gson.toJson(JsonParser.parseString(jsonArray.toString()));
        try (FileWriter fileWriter = new FileWriter("datacollection/" + filename)) {
            fileWriter.write(formattedJson);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
