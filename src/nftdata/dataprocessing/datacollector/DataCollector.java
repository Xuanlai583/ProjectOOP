package nftdata.dataprocessing.datacollector;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataCollector {
    public static final String SEARCH_HASHTAG = "#NFT";
    public static int SCROLL_TURNS = 10;

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

    static void scrollDown(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static String dateFormat(String inputDate){
        LocalDate dateFormat = LocalDate.parse(inputDate, DateTimeFormatter.ISO_LOCAL_DATE);
        return dateFormat.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }
}
