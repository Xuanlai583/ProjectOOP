package nftdata.dataprocessing;

import nftdata.datastorage.nft.BinanceNFT;
import nftdata.datastorage.nft.OpenseaNFT;
import nftdata.datastorage.nft.RaribleNFT;
import nftdata.datastorage.posts.Cointelegraph;
import nftdata.datastorage.posts.Decrypt;
import nftdata.datastorage.posts.Tweet;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.Iterator;

import static nftdata.dataprocessing.Database.*;

public class ReadData {
    public static void readRaribleData() {
        JSONParser jsonParser = new JSONParser();
        try (FileReader reader = new FileReader("src/nftdata/datacollection/rarible.json")) {
            // Đọc và parse file JSON thành một đối tượng JSONArray
            Object obj = jsonParser.parse(reader);
            JSONArray jsonArray = (JSONArray) obj;

            // Lặp qua mỗi đối tượng trong mảng JSON
            Iterator<JSONObject> iterator = jsonArray.iterator();
            while (iterator.hasNext()) {
                JSONObject jsonObject = iterator.next();
                // Lấy thông tin từ mỗi đối tượng
                String ranking = (String) jsonObject.get("ranking");
                String name = (String) jsonObject.get("name");
                String floorPrice = (String) jsonObject.get("floor price");

                RaribleNFT newRNFT = new RaribleNFT(name, ranking, floorPrice);
                itemsRaribleNFT.add(newRNFT);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void readBinanceData() {
        JSONParser jsonParser = new JSONParser();
        try (FileReader reader = new FileReader("src/nftdata/datacollection/binance.json")) {
            // Đọc và parse file JSON thành một đối tượng JSONArray
            Object obj = jsonParser.parse(reader);
            JSONArray jsonArray = (JSONArray) obj;

            // Lặp qua mỗi đối tượng trong mảng JSON
            Iterator<JSONObject> iterator = jsonArray.iterator();
            while (iterator.hasNext()) {
                JSONObject jsonObject = iterator.next();
                String ranking = (String) jsonObject.get("rank");
                String name = (String) jsonObject.get("collection");
                String volume = (String) jsonObject.get("volume");
                String volumeChange = (String) jsonObject.get("volume change");
                String floorPrice = (String) jsonObject.get("floor price");
                String priceChange = (String) jsonObject.get("price change");
                Object ownersObj = jsonObject.get("owners");
                String owner = (ownersObj != null) ? ownersObj.toString() : "";
                Object itemObj = jsonObject.get("items");
                String item = (itemObj != null) ? itemObj.toString() : "";


                BinanceNFT newBNFT = new BinanceNFT(name, ranking, floorPrice, volume, volumeChange, priceChange, owner, item);
                itemsBinanceNFT.add(newBNFT);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void readOpenseaData() {
        JSONParser jsonParser = new JSONParser();
        try (FileReader reader = new FileReader("src/nftdata/datacollection/opensea.json")) {
            // Đọc và parse file JSON thành một đối tượng JSONArray
            Object obj = jsonParser.parse(reader);
            JSONArray jsonArray = (JSONArray) obj;

            // Lặp qua mỗi đối tượng trong mảng JSON
            Iterator<JSONObject> iterator = jsonArray.iterator();
            while (iterator.hasNext()) {
                JSONObject jsonObject = iterator.next();
                String volume = (String) jsonObject.get("volume");
                String rank = (String) jsonObject.get("rank");
                String change = (String) jsonObject.get("change");
                String name = (String) jsonObject.get("collection");
                String sales = (String) jsonObject.get("sales");
                String floorPrice = (String) jsonObject.get("floor price");
                OpenseaNFT newONFT = new OpenseaNFT(name, rank, floorPrice, volume, change, sales);
                itemsOpenseaNFT.add(newONFT);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void readTweetData() {
        JSONParser jsonParser = new JSONParser();
        try (FileReader reader = new FileReader("src/nftdata/datacollection/twitter.json")) {
            // Đọc và parse file JSON thành một đối tượng JSONArray
            Object obj = jsonParser.parse(reader);
            JSONArray jsonArray = (JSONArray) obj;

            // Lặp qua mỗi đối tượng trong mảng JSON
            Iterator<JSONObject> iterator = jsonArray.iterator();
            while (iterator.hasNext()) {
                JSONObject jsonObject = iterator.next();
                String author = (String) jsonObject.get("author");
                String date = (String) jsonObject.get("date");
                String replies = (String) jsonObject.get("replies");
                String reposts = (String) jsonObject.get("reposts");
                String likes = (String) jsonObject.get("likes");
                String views = (String) jsonObject.get("views");
                String hashtags = (String) jsonObject.get("hashtags");
                Tweet newTweet = new Tweet(author, date, hashtags, replies, reposts, likes, views);
                itemsTwitter.add(newTweet);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void readDecryptData() {
        JSONParser jsonParser = new JSONParser();
        try (FileReader reader = new FileReader("src/nftdata/datacollection/decrypt.json")) {
            // Đọc và parse file JSON thành một đối tượng JSONArray
            Object obj = jsonParser.parse(reader);
            JSONArray jsonArray = (JSONArray) obj;

            // Lặp qua mỗi đối tượng trong mảng JSON
            Iterator<JSONObject> iterator = jsonArray.iterator();
            while (iterator.hasNext()) {
                JSONObject jsonObject = iterator.next();
                String title = (String) jsonObject.get("title");
                String author = (String) jsonObject.get("author");
                String date = (String) jsonObject.get("date");
                String tags = (String) jsonObject.get("tags");
                Decrypt newDecrypt = new Decrypt(author, date, tags, title);
                itemsDecrypt.add(newDecrypt);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void readCointelegraphData() {
        JSONParser jsonParser = new JSONParser();
        try (FileReader reader = new FileReader("src/nftdata/datacollection/cointelegraph.json")) {
            // Đọc và parse file JSON thành một đối tượng JSONArray
            Object obj = jsonParser.parse(reader);
            JSONArray jsonArray = (JSONArray) obj;

            // Lặp qua mỗi đối tượng trong mảng JSON
            Iterator<JSONObject> iterator = jsonArray.iterator();
            while (iterator.hasNext()) {
                JSONObject jsonObject = iterator.next();
                String title = (String) jsonObject.get("title");
                String author = (String) jsonObject.get("author");
                String date = (String) jsonObject.get("date");
                String tags = (String) jsonObject.get("tags");
                String view = (String) jsonObject.get("views");
                Cointelegraph newCointelegraph = new Cointelegraph(author, date, tags, title, view);
                itemsCointelegraph.add(newCointelegraph);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
