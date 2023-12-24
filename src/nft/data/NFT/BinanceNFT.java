package nft.data.NFT;

public class BinanceNFT extends NFTToken {
    private String volume;
    private String volumeChange;
    private String priceChange;
    private String owner;
    private String item;

    public String getVolume() {
        return volume;
    }

    public String getVolumeChange() {
        return volumeChange;
    }

    public String getPriceChange() {
        return priceChange;
    }

    public String getOwner() {
        return owner;
    }

    public String getItem() {
        return item;
    }

    public BinanceNFT(String collection, String rank, String price, String volume, String volumeChange, String priceChange, String owner, String item) {
        super(collection, rank, price);
        this.volume = volume;
        this.volumeChange = volumeChange;
        this.priceChange = priceChange;
        this.owner = owner;
        this.item = item;
    }

    @Override
    public String toString() {
        return "BinanceNFT{" + '\n' +
                "Rank: " + this.getRank() + '\n' +
                "Collection: " + this.getCollection() + '\n' +
                "Volume: " + this.getVolume() + '\n' +
                "Volume change: " + this.getVolumeChange() + '\n' +
                "Price: " + this.getPrice() + '\n' +
                "Price change:  " + this.getPriceChange() + '\n' +
                "Owner: " + this.getOwner() + '\n' +
                "Item: " + this.getItem() + '\n' +
                '}';
    }
}
