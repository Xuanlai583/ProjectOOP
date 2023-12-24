package nft.data.NFT;

import nft.data.database.ReadData;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.Iterator;

import static nft.data.database.Database.itemsRaribleNFT ;

public class RaribleNFT extends NFTToken{
    public RaribleNFT(String collection, String rank, String price) {
        super(collection, rank, price);
    }
}
