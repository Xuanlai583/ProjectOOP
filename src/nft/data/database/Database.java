package nft.data.database;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import nft.data.NFT.BinanceNFT;
import nft.data.NFT.OpenseaNFT;
import nft.data.NFT.RaribleNFT;
import nft.data.posts.Cointelegraph;
import nft.data.posts.Decrypt;
import nft.data.posts.Tweet;

public class Database {
    public static ObservableList<RaribleNFT> itemsRaribleNFT  = FXCollections.observableArrayList();
    public static ObservableList<BinanceNFT> itemsBinanceNFT  = FXCollections.observableArrayList();
    public static ObservableList<OpenseaNFT> itemsOpenseaNFT   = FXCollections.observableArrayList();
    public static ObservableList<Tweet> itemsTwitter = FXCollections.observableArrayList();
    public static ObservableList<Cointelegraph> itemsCointelegraph  = FXCollections.observableArrayList();
    public static ObservableList<Decrypt> itemsDecrypt  = FXCollections.observableArrayList();

    public static void main(String[] args) {
        ReadData.readRaribleData();
        ReadData.readBinanceData();
        ReadData.readOpenseaData();
        ReadData.readTweetData();
        ReadData.readDecryptData();
        ReadData.readCointelegraphData();
    }
}
