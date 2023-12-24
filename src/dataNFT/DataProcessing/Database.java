package dataNFT.DataProcessing;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import dataNFT.DataStorage.NFT.BinanceNFT;
import dataNFT.DataStorage.NFT.OpenseaNFT;
import dataNFT.DataStorage.NFT.RaribleNFT;
import dataNFT.DataStorage.posts.Cointelegraph;
import dataNFT.DataStorage.posts.Decrypt;
import dataNFT.DataStorage.posts.Tweet;

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
