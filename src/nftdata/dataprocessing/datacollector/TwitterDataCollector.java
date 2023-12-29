package nftdata.dataprocessing.datacollector;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TwitterDataCollector extends DataCollector{
    public static void twitterDataCollector() {
        WebDriver driver = openBrowser();
        try{
            driver.get("https://twitter.com/explore");
            Thread.sleep(5000);

            //Login
            WebElement usernameInput = driver.findElement(By.xpath("//input[@autocomplete=\"username\"]"));
            usernameInput.sendKeys("acccftest1@gmail.com");
            usernameInput.sendKeys(Keys.RETURN);
            Thread.sleep(5000);

            WebElement userCheckInput = driver.findElement(By.xpath("//input[@autocomplete=\"on\"]"));
            if (userCheckInput != null) {
                userCheckInput.sendKeys("@cf61885");
                userCheckInput.sendKeys(Keys.RETURN);
                Thread.sleep(5000);
            }

            WebElement passwordInput = driver.findElement(By.xpath("//input[@autocomplete=\"current-password\"]"));
            passwordInput.sendKeys("@cf61885");
            passwordInput.sendKeys(Keys.RETURN);
            Thread.sleep(8000);

            //Search
            WebElement searchBox = driver.findElement(By.xpath("//input[@enterkeyhint=\"search\"]"));
            searchBox.sendKeys(SEARCH_HASHTAG);
            searchBox.sendKeys(Keys.RETURN);
            Thread.sleep(8000);

            //Data Collect
            JSONArray jsonArray = new JSONArray();
            for (int i = 0; i < SCROLL_TURNS; i++) {
                List<WebElement> postElements = driver.findElements(By.xpath("//article[@data-testid=\"tweet\"]"));

                for (WebElement postElement : postElements) {
                    String author = postElement.findElement(By.xpath(".//span[@class=\"css-1qaijid r-bcqeeo r-qvutc0 r-poiln3\"]")).getText();
                    String date = dateFormat(postElement.findElement(By.xpath(".//time")).getAttribute("datetime").substring(0, 10));
                    String replies = postElement.findElement(By.xpath(".//div[@data-testid=\"reply\"]")).getText();
                    String reposts = postElement.findElement(By.xpath(".//div[@data-testid=\"retweet\"]")).getText();
                    String likes = postElement.findElement(By.xpath(".//div[@data-testid=\"like\"]")).getText();
                    String views;
                    try {
                        views = postElement.findElement(By.xpath("(.//div[@class=\"css-175oi2r r-xoduu5 r-1udh08x\"])[4]")).getText();
                    }catch (org.openqa.selenium.NoSuchElementException e){
                        views = "";
                    }
                    String hashtags = extractHashtags(postElement);

                    JSONObject tweetObject = new JSONObject();
                    tweetObject.put("author", author);
                    tweetObject.put("date", date);
                    tweetObject.put("replies", replies);
                    tweetObject.put("reposts", reposts);
                    tweetObject.put("likes", likes);
                    tweetObject.put("views", views);
                    tweetObject.put("hashtags", hashtags);

                    jsonArray.add(tweetObject);
                }

                scrollDown(driver);
            }

            //Export JSON
            exportJSON(jsonArray, "src/nftdata/datacollection/twitter.json");

        }catch (InterruptedException e){
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}