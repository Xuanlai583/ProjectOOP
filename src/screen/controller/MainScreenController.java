package screen.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import nft.data.NFT.BinanceNFT;
import nft.data.NFT.OpenseaNFT;
import nft.data.NFT.RaribleNFT;
import nft.data.posts.Cointelegraph;
import nft.data.posts.Decrypt;
import nft.data.posts.Tweet;

import static nft.data.database.Database.*;

public class MainScreenController {
    private TableView<?> curTable = new TableView<>();

    @FXML
    private Button btnNFTToken;

    @FXML
    private Button btnUpdate;

    @FXML
    private TableColumn<Cointelegraph, String> colAuthorCointelegraph;

    @FXML
    private TableColumn<Decrypt, String> colAuthorDecrypt;

    @FXML
    private TableColumn<Tweet, String> colAuthorTwitter;

    @FXML
    private TableColumn<OpenseaNFT, String> colChangeOpenSea;

    @FXML
    private TableColumn<BinanceNFT, String> colCollectionBinance;

    @FXML
    private TableColumn<OpenseaNFT, String> colCollectionOpenSea;

    @FXML
    private TableColumn<Cointelegraph, String> colDateCointelegraph;

    @FXML
    private TableColumn<Decrypt, String> colDateDecrypt;

    @FXML
    private TableColumn<Tweet, String> colDateTwitter;

    @FXML
    private TableColumn<BinanceNFT, String> colFloorPriceBinance;

    @FXML
    private TableColumn<OpenseaNFT, String> colFloorPriceOpenSea;

    @FXML
    private TableColumn<RaribleNFT, String> colFloorPriceRarible;

    @FXML
    private TableColumn<Tweet, String> colHashtagsTwitter;

    @FXML
    private TableColumn<BinanceNFT, String> colItemsBinance;

    @FXML
    private TableColumn<Tweet, String> colLikesTwitter;

    @FXML
    private TableColumn<RaribleNFT, String> colNameRarible;

    @FXML
    private TableColumn<BinanceNFT, String> colOrdinalNumBinance;

    @FXML
    private TableColumn<OpenseaNFT, String> colOrdinalNumOpenSea;

    @FXML
    private TableColumn<BinanceNFT, String> colOwnersBinance;

    @FXML
    private TableColumn<BinanceNFT, String> colPriceChangeBinance;

    @FXML
    private TableColumn<RaribleNFT, String> colRankingRarible;

    @FXML
    private TableColumn<Tweet, String> colRepliesTwitter;

    @FXML
    private TableColumn<Tweet, String> colRepostsTwitter;

    @FXML
    private TableColumn<OpenseaNFT, String> colSalesOpenSea;

    @FXML
    private TableColumn<Cointelegraph, String> colTagsCointelegraph;

    @FXML
    private TableColumn<Decrypt, String> colTagsDecrypt;

    @FXML
    private TableColumn<Cointelegraph, String> colTitleCointelegraph;

    @FXML
    private TableColumn<Decrypt, String> colTitleDecrypt;

    @FXML
    private TableColumn<Cointelegraph, String> colViewsCointelegraph;

    @FXML
    private TableColumn<Tweet, String> colViewsTwitter;

    @FXML
    private TableColumn<BinanceNFT, String> colVolumeBinance;

    @FXML
    private TableColumn<BinanceNFT, String> colVolumeChangeBinance;

    @FXML
    private TableColumn<OpenseaNFT, String> colVolumeOpenSea;

    @FXML
    private MenuButton menuButtonSearch;

    @FXML
    private MenuButton menuButtonSort;

    @FXML
    private MenuButton menuButtonSource;

    @FXML
    private TableView<BinanceNFT> tblBinance;

    @FXML
    private TableView<Cointelegraph> tblCointelegraph;

    @FXML
    private TableView<Decrypt> tblDecrypt;

    @FXML
    private TableView<OpenseaNFT> tblOpenSea;

    @FXML
    private TableView<RaribleNFT> tblRarible;

    @FXML
    private TableView<Tweet> tblTwitter;

    @FXML
    private TextField tfSearch;

    @FXML
    private ToggleGroup toggleSortGroup;

    @FXML
    void btnNFTTokenPressed(ActionEvent event) {

    }

    @FXML
    void btnUpdatePressed(ActionEvent event) {

    }

    @FXML
    void menuItemAuthorChoose(ActionEvent event) {

    }

    @FXML
    void menuItemBinanceChoose(ActionEvent event) {
        ChangeSource("Binance", tblBinance);
    }

    @FXML
    void menuItemCointelegraphChoose(ActionEvent event) {
        ChangeSource("Cointelegraph", tblCointelegraph);
    }

    @FXML
    void menuItemDecryptChoose(ActionEvent event) {
        ChangeSource("Decrypt", tblDecrypt);
    }

    @FXML
    void menuItemHashtagChoose(ActionEvent event) {

    }

    @FXML
    void menuItemOpenSeaChoose(ActionEvent event) {
        ChangeSource("OpenSea", tblOpenSea);
    }

    @FXML
    void menuItemRaribleChoose(ActionEvent event) {
        ChangeSource("Rarible", tblRarible);
    }

    @FXML
    void menuItemTitleChoose(ActionEvent event) {

    }

    @FXML
    void menuItemTwitterChoose(ActionEvent event) {
        ChangeSource("Twitter", tblTwitter);
    }

    @FXML
    void radioBtnAscendingChoose(ActionEvent event) {

    }

    @FXML
    void radioBtnDescendingChoose(ActionEvent event) {

    }

    @FXML
    public void initialize(){
        //Twitter
        colAuthorTwitter.setCellValueFactory(new PropertyValueFactory<Tweet, String>("author"));
        colDateTwitter.setCellValueFactory(new PropertyValueFactory<Tweet, String>("date"));
        colRepliesTwitter.setCellValueFactory(new PropertyValueFactory<Tweet, String>("replies"));
        colRepostsTwitter.setCellValueFactory(new PropertyValueFactory<Tweet, String>("reposts"));
        colLikesTwitter.setCellValueFactory(new PropertyValueFactory<Tweet, String>("likes"));
        colViewsTwitter.setCellValueFactory(new PropertyValueFactory<Tweet, String>("views"));
        colHashtagsTwitter.setCellValueFactory(new PropertyValueFactory<Tweet, String>("hashtags"));
        tblTwitter.setItems(itemsTwitter);

        //Cointelegraph
        colDateCointelegraph.setCellValueFactory(new PropertyValueFactory<Cointelegraph, String>("date"));
        colAuthorCointelegraph.setCellValueFactory(new PropertyValueFactory<Cointelegraph, String>("author"));
        colTitleCointelegraph.setCellValueFactory(new PropertyValueFactory<Cointelegraph, String>("title"));
        colViewsCointelegraph.setCellValueFactory(new PropertyValueFactory<Cointelegraph, String>("views"));
        colTagsCointelegraph.setCellValueFactory(new PropertyValueFactory<Cointelegraph, String>("tags"));
        tblCointelegraph.setItems(itemsCointelegraph);

        //Decrypt
        colTitleDecrypt.setCellValueFactory(new PropertyValueFactory<Decrypt, String>("title"));
        colAuthorDecrypt.setCellValueFactory(new PropertyValueFactory<Decrypt, String>("author"));
        colDateDecrypt.setCellValueFactory(new PropertyValueFactory<Decrypt, String>("date"));
        colTagsDecrypt.setCellValueFactory(new PropertyValueFactory<Decrypt, String>("tags"));
        tblDecrypt.setItems(itemsDecrypt);

        //BinanceNFT
        colOrdinalNumBinance.setCellValueFactory(new PropertyValueFactory<BinanceNFT, String>("#"));
        colCollectionBinance.setCellValueFactory(new PropertyValueFactory<BinanceNFT, String>("collection"));
        colVolumeBinance.setCellValueFactory(new PropertyValueFactory<BinanceNFT, String>("volume"));
        colVolumeChangeBinance.setCellValueFactory(new PropertyValueFactory<BinanceNFT, String>("volume change"));
        colFloorPriceBinance.setCellValueFactory(new PropertyValueFactory<BinanceNFT, String>("floor price"));
        colPriceChangeBinance.setCellValueFactory(new PropertyValueFactory<BinanceNFT, String>("price change"));
        colOwnersBinance.setCellValueFactory(new PropertyValueFactory<BinanceNFT, String>("owners"));
        colItemsBinance.setCellValueFactory(new PropertyValueFactory<BinanceNFT, String>("items"));
        tblBinance.setItems(itemsBinanceNFT);

        //OpenSeaNFT
        colVolumeOpenSea.setCellValueFactory(new PropertyValueFactory<OpenseaNFT, String>("volume"));
        colOrdinalNumOpenSea.setCellValueFactory(new PropertyValueFactory<OpenseaNFT, String>("#"));
        colChangeOpenSea.setCellValueFactory(new PropertyValueFactory<OpenseaNFT, String>("change"));
        colCollectionOpenSea.setCellValueFactory(new PropertyValueFactory<OpenseaNFT, String>("collection"));
        colSalesOpenSea.setCellValueFactory(new PropertyValueFactory<OpenseaNFT, String>("sales"));
        colFloorPriceOpenSea.setCellValueFactory(new PropertyValueFactory<OpenseaNFT, String>("floor price"));
        tblOpenSea.setItems(itemsOpenseaNFT);

        //RaribleNFT
        colRankingRarible.setCellValueFactory(new PropertyValueFactory<RaribleNFT, String>("ranking"));
        colNameRarible.setCellValueFactory(new PropertyValueFactory<RaribleNFT, String>("name"));
        colFloorPriceRarible.setCellValueFactory(new PropertyValueFactory<RaribleNFT, String>("floor price"));
        tblRarible.setItems(itemsRaribleNFT);
    }

    private void ChangeSource(String sourceName, TableView<?> nextTable){
        menuButtonSource.setText(sourceName);
        curTable.setVisible(false);
        nextTable.setVisible(true);
        curTable = nextTable;
    }

}

