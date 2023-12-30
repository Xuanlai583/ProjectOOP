package nftdata.dataprocessing.datacollector;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BinanceDataCollector extends DataCollector{
    public static void binanceDataCollector() {
        WebDriver driver = openBrowser();
        int count = 1;
        try{
            driver.get("https://www.binance.com/en/nft/ranking");
            Thread.sleep(5000);

            //Data Collect
            JSONArray jsonArray = new JSONArray();
            List<WebElement> collectionElements = driver.findElements(By.xpath("//a[@class=\"css-1xxn6ao\"]"));

            for (WebElement collectionElement : collectionElements) {
                String rank;
                if (count < 4){
                    rank = Integer.toString(count);
                    count++;
                } else {
                    rank = collectionElement.findElement(By.xpath(".//div[@class=\"css-ffknne\"]")).getText();
                }
                String collection = collectionElement.findElement(By.xpath(".//div[@class=\"css-1iqk42z\"]")).getText();
                String volume = collectionElement.findElement(By.xpath(".//div[@class=\"css-79h90x\"]")).getText();
                String volumeChange = collectionElement.findElement(By.xpath(".//div[@class=\"css-xs8nuv\"]")).getText().replace("\n", "").trim();
                String floorPrice = collectionElement.findElement(By.xpath(".//div[@class=\"css-1j59jpm\"]")).getText();
                String priceChange = collectionElement.findElement(By.xpath(".//div[@class=\"css-87rt9h\"]")).getText().replace("\n", "").trim();
                String owners = collectionElement.findElement(By.xpath(".//div[@class=\"css-15n6x8q\"][1]")).getText();
                String items = collectionElement.findElement(By.xpath(".//div[@class=\"css-15n6x8q\"][2]")).getText();

                //JSON Object
                JSONObject binanceObject = new JSONObject();
                binanceObject.put("rank", rank);
                binanceObject.put("collection", collection);
                binanceObject.put("volume", volume);
                binanceObject.put("volume change", volumeChange);
                binanceObject.put("floor price", floorPrice);
                binanceObject.put("price change", priceChange);
                binanceObject.put("owners", owners);
                binanceObject.put("items", items);

                jsonArray.add(binanceObject);
            }
            //JSON File Create
            exportJSON(jsonArray, "binance.json");

        }catch (InterruptedException e){
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
