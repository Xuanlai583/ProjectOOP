package screen.Controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import nftdata.datastorage.nft.BinanceNFT;
import nftdata.datastorage.nft.OpenseaNFT;
import nftdata.datastorage.nft.RaribleNFT;
import nftdata.datastorage.posts.Cointelegraph;
import nftdata.datastorage.posts.Decrypt;
import nftdata.datastorage.posts.Tweet;

import static nftdata.dataprocessing.Database.*;

public class MainScreenController {
    private TableView<?> curTable = new TableView<>();

    private FilteredList<Tweet> tweetFilteredList;
    private FilteredList<Decrypt> decryptFilteredList;
    private FilteredList<Cointelegraph> cointelegraphFilteredList;
    private FilteredList<RaribleNFT> raribleNFTFilteredList;
    private FilteredList<OpenseaNFT> openseaNFTFilteredList;
    private FilteredList<BinanceNFT> binanceNFTFilteredList;

    public MainScreenController() {
        this.tweetFilteredList = new FilteredList<>(itemsTwitter);
        this.decryptFilteredList = new FilteredList<>(itemsDecrypt);
        this.cointelegraphFilteredList = new FilteredList<>(itemsCointelegraph);
        this.raribleNFTFilteredList = new FilteredList<>(itemsRaribleNFT);
        this.openseaNFTFilteredList = new FilteredList<>(itemsOpenseaNFT);
        this.binanceNFTFilteredList = new FilteredList<>(itemsBinanceNFT);
    }

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
    private MenuButton menuButtonSource;

    @FXML
    private TableView<BinanceNFT> tblBinance = new TableView<>(binanceNFTFilteredList);

    @FXML
    private TableView<Cointelegraph> tblCointelegraph = new TableView<>(cointelegraphFilteredList);

    @FXML
    private TableView<Decrypt> tblDecrypt = new TableView<>(decryptFilteredList);

    @FXML
    private TableView<OpenseaNFT> tblOpenSea = new TableView<>(openseaNFTFilteredList);

    @FXML
    private TableView<RaribleNFT> tblRarible = new TableView<>(raribleNFTFilteredList);

    @FXML
    private TableView<Tweet> tblTwitter = new TableView<>(tweetFilteredList);

    @FXML
    private TextField tfSearch;

    @FXML
    void btnNFTTokenPressed(ActionEvent event) {

    }

    @FXML
    void btnUpdatePressed(ActionEvent event) {

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
    void menuItemTwitterChoose(ActionEvent event) {
        ChangeSource("Twitter", tblTwitter);
    }

    @FXML
    public void initialize(){
        //Twitter
        colAuthorTwitter.setCellValueFactory(new PropertyValueFactory<Tweet, String>("author"));
        colDateTwitter.setCellValueFactory(new PropertyValueFactory<Tweet, String>("date"));
        colRepliesTwitter.setCellValueFactory(new PropertyValueFactory<Tweet, String>("reply"));
        colRepostsTwitter.setCellValueFactory(new PropertyValueFactory<Tweet, String>("retweet"));
        colLikesTwitter.setCellValueFactory(new PropertyValueFactory<Tweet, String>("like"));
        colViewsTwitter.setCellValueFactory(new PropertyValueFactory<Tweet, String>("view"));
        colHashtagsTwitter.setCellValueFactory(new PropertyValueFactory<Tweet, String>("hashtag"));
        tblTwitter.setItems(itemsTwitter);
        tblTwitter.setItems(tweetFilteredList);

        //Cointelegraph
        colDateCointelegraph.setCellValueFactory(new PropertyValueFactory<Cointelegraph, String>("date"));
        colAuthorCointelegraph.setCellValueFactory(new PropertyValueFactory<Cointelegraph, String>("author"));
        colTitleCointelegraph.setCellValueFactory(new PropertyValueFactory<Cointelegraph, String>("title"));
        colViewsCointelegraph.setCellValueFactory(new PropertyValueFactory<Cointelegraph, String>("view"));
        colTagsCointelegraph.setCellValueFactory(new PropertyValueFactory<Cointelegraph, String>("hashtag"));
        tblCointelegraph.setItems(itemsCointelegraph);
        tblCointelegraph.setItems(cointelegraphFilteredList);

        //Decrypt
        colTitleDecrypt.setCellValueFactory(new PropertyValueFactory<Decrypt, String>("title"));
        colAuthorDecrypt.setCellValueFactory(new PropertyValueFactory<Decrypt, String>("author"));
        colDateDecrypt.setCellValueFactory(new PropertyValueFactory<Decrypt, String>("date"));
        colTagsDecrypt.setCellValueFactory(new PropertyValueFactory<Decrypt, String>("hashtag"));
        tblDecrypt.setItems(itemsDecrypt);
        tblDecrypt.setItems(decryptFilteredList);

        //BinanceNFT
        colOrdinalNumBinance.setCellValueFactory(new PropertyValueFactory<BinanceNFT, String>("rank"));
        colCollectionBinance.setCellValueFactory(new PropertyValueFactory<BinanceNFT, String>("collection"));
        colVolumeBinance.setCellValueFactory(new PropertyValueFactory<BinanceNFT, String>("volume"));
        colVolumeChangeBinance.setCellValueFactory(new PropertyValueFactory<BinanceNFT, String>("volumeChange"));
        colFloorPriceBinance.setCellValueFactory(new PropertyValueFactory<BinanceNFT, String>("price"));
        colPriceChangeBinance.setCellValueFactory(new PropertyValueFactory<BinanceNFT, String>("priceChange"));
        colOwnersBinance.setCellValueFactory(new PropertyValueFactory<BinanceNFT, String>("owner"));
        colItemsBinance.setCellValueFactory(new PropertyValueFactory<BinanceNFT, String>("item"));
        tblBinance.setItems(itemsBinanceNFT);
        tblBinance.setItems(binanceNFTFilteredList);

        //OpenSeaNFT
        colVolumeOpenSea.setCellValueFactory(new PropertyValueFactory<OpenseaNFT, String>("volume"));
        colOrdinalNumOpenSea.setCellValueFactory(new PropertyValueFactory<OpenseaNFT, String>("rank"));
        colChangeOpenSea.setCellValueFactory(new PropertyValueFactory<OpenseaNFT, String>("change"));
        colCollectionOpenSea.setCellValueFactory(new PropertyValueFactory<OpenseaNFT, String>("collection"));
        colSalesOpenSea.setCellValueFactory(new PropertyValueFactory<OpenseaNFT, String>("sale"));
        colFloorPriceOpenSea.setCellValueFactory(new PropertyValueFactory<OpenseaNFT, String>("price"));
        tblOpenSea.setItems(itemsOpenseaNFT);
        tblOpenSea.setItems(openseaNFTFilteredList);

        //RaribleNFT
        colRankingRarible.setCellValueFactory(new PropertyValueFactory<RaribleNFT, String>("rank"));
        colNameRarible.setCellValueFactory(new PropertyValueFactory<RaribleNFT, String>("collection"));
        colFloorPriceRarible.setCellValueFactory(new PropertyValueFactory<RaribleNFT, String>("price"));
        tblRarible.setItems(itemsRaribleNFT);
        tblRarible.setItems(raribleNFTFilteredList);

        //Searchbox
        tfSearch.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                showFilteredResult(newValue);
            }
        });
    }

    private void ChangeSource(String sourceName, TableView<?> nextTable){
        menuButtonSource.setText(sourceName);
        curTable.setVisible(false);
        nextTable.setVisible(true);
        curTable = nextTable;
    }

    void showFilteredResult(String string){
        String filterText = string.toLowerCase();
        tweetFilteredList.setPredicate(item -> item.getHashtag().toLowerCase().contains(filterText));
        decryptFilteredList.setPredicate(item -> item.getHashtag().toLowerCase().contains(filterText));
        cointelegraphFilteredList.setPredicate(item -> item.getHashtag().toLowerCase().contains(filterText));
    }
}

