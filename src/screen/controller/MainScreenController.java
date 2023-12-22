package screen.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class MainScreenController {
    private TableView<?> curTable = new TableView<>();

    @FXML
    private Button btnNFTToken;

    @FXML
    private Button btnUpdate;

    @FXML
    private TableColumn<?, ?> colAuthorCointelegraph;

    @FXML
    private TableColumn<?, ?> colAuthorDecrypt;

    @FXML
    private TableColumn<?, ?> colAuthorTwitter;

    @FXML
    private TableColumn<?, ?> colChangeOpenSea;

    @FXML
    private TableColumn<?, ?> colCollectionBinance;

    @FXML
    private TableColumn<?, ?> colCollectionOpenSea;

    @FXML
    private TableColumn<?, ?> colDateCointelegraph;

    @FXML
    private TableColumn<?, ?> colDateDecrypt;

    @FXML
    private TableColumn<?, ?> colDateTwitter;

    @FXML
    private TableColumn<?, ?> colFloorPriceBinance;

    @FXML
    private TableColumn<?, ?> colFloorPriceOpenSea;

    @FXML
    private TableColumn<?, ?> colFloorPriceRarible;

    @FXML
    private TableColumn<?, ?> colHashtagsTwitter;

    @FXML
    private TableColumn<?, ?> colItemsBinance;

    @FXML
    private TableColumn<?, ?> colLikesTwitter;

    @FXML
    private TableColumn<?, ?> colNameRarible;

    @FXML
    private TableColumn<?, ?> colOrdinalNumBinance;

    @FXML
    private TableColumn<?, ?> colOrdinalNumOpenSea;

    @FXML
    private TableColumn<?, ?> colOwnersBinance;

    @FXML
    private TableColumn<?, ?> colPriceChangeBinance;

    @FXML
    private TableColumn<?, ?> colRankingRarible;

    @FXML
    private TableColumn<?, ?> colRepliesTwitter;

    @FXML
    private TableColumn<?, ?> colRepostsTwitter;

    @FXML
    private TableColumn<?, ?> colSalesOpenSea;

    @FXML
    private TableColumn<?, ?> colTagsCointelegraph;

    @FXML
    private TableColumn<?, ?> colTagsDecrypt;

    @FXML
    private TableColumn<?, ?> colTitleCointelegraph;

    @FXML
    private TableColumn<?, ?> colTitleDecrypt;

    @FXML
    private TableColumn<?, ?> colViewsCointelegraph;

    @FXML
    private TableColumn<?, ?> colViewsTwitter;

    @FXML
    private TableColumn<?, ?> colVolumeBinance;

    @FXML
    private TableColumn<?, ?> colVolumeChangeBinance;

    @FXML
    private TableColumn<?, ?> colVolumeOpenSea;

    @FXML
    private MenuButton menuButtonSearch;

    @FXML
    private MenuButton menuButtonSort;

    @FXML
    private MenuButton menuButtonSource;

    @FXML
    private TableView<?> tblBinance;

    @FXML
    private TableView<?> tblCointelegraph;

    @FXML
    private TableView<?> tblDecrypt;

    @FXML
    private TableView<?> tblOpenSea;

    @FXML
    private TableView<?> tblRarible;

    @FXML
    private TableView<?> tblTwitter;

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

    private void ChangeSource(String sourceName, TableView<?> nextTable){
        menuButtonSource.setText(sourceName);
        curTable.setVisible(false);
        nextTable.setVisible(true);
        curTable = nextTable;
    }

}

