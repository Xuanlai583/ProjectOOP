package screen.controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.MenuButton;
import javafx.stage.Stage;
import nftdata.dataprocessing.ReadData;
import nftdata.dataprocessing.datacollector.*;

public class UpdateBoxController {
    private Stage subStage;

    public void setSubStage(Stage mainStage) {
        this.subStage = mainStage;
    }

    @FXML
    private MenuButton menuButtonSource;

    @FXML
    void btnCancelPressed(ActionEvent event) {
        subStage.close();
    }

    @FXML
    void btnUpdatePressed(ActionEvent event) {
        updateSource();
    }

    @FXML
    void menuItemBinanceChoose(ActionEvent event) {
        menuButtonSource.setText("Binance");
    }

    @FXML
    void menuItemCointelegraphChoose(ActionEvent event) {
        menuButtonSource.setText("Cointelegraph");
    }

    @FXML
    void menuItemDecryptChoose(ActionEvent event) {
        menuButtonSource.setText("Decrypt");
    }

    @FXML
    void menuItemOpenSeaChoose(ActionEvent event) {
        menuButtonSource.setText("OpenSea");
    }

    @FXML
    void menuItemRaribleChoose(ActionEvent event) {
        menuButtonSource.setText("Rarible");
    }

    @FXML
    void menuItemTwitterChoose(ActionEvent event) {
        menuButtonSource.setText("Twitter");
    }

    private void updateSource(){
        String sourceName = menuButtonSource.getText();
        Platform.runLater(() -> {
            Alert waitAlert = showWaitAlert();
            waitAlert.show();
        });
        switch (sourceName){
            case "Twitter":
                TwitterDataCollector.twitterDataCollector();
                ReadData.readTweetData();
                break;
            case "Decrypt":
                DecryptDataCollector.decryptDataCollector();
                ReadData.readDecryptData();
                break;
            case "Cointelegraph":
                CointelegraphDataCollector.cointelegraphDataCollector();
                ReadData.readCointelegraphData();
                break;
            case "OpenSea":
                OpenseaDataCollector.openseaDataCollector();
                ReadData.readOpenseaData();
                break;
            case "Binance":
                BinanceDataCollector.binanceDataCollector();
                ReadData.readBinanceData();
                break;
            case "Rarible":
                RaribleDataCollector.raribleDataCollector();
                ReadData.readRaribleData();
                break;
        }
        Platform.runLater(() -> {
            Alert waitAlert = showWaitAlert();
            waitAlert.close();
            showSuccessAlert();
        });
    }

    private Alert showWaitAlert() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Please Wait");
        alert.setHeaderText(null);
        alert.setContentText("Updating data... Please wait.");
        alert.show();
        return alert;
    }

    private void showSuccessAlert() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setHeaderText(null);
        alert.setContentText("Data updated successfully!");
        alert.getButtonTypes().setAll(ButtonType.OK);
        alert.showAndWait();
    }
}
