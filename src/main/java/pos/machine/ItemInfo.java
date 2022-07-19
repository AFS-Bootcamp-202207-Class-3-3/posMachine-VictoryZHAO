package pos.machine;

public class ItemInfo {
    private final String barcode;
    private final String name;
    private final int price;

    public ItemInfo(String barcode, String name, int price) {
        this.barcode = barcode;
        this.name = name;
        this.price = price;
    }

    public String getBarcodesInfo(List<String> barcodes) {


        return null;
    }

    public String getBarcodesName(String barcodes) {


        return null;
    }

    public int getBarcodesQuantity(String barcodes) {

        return null;
    }

    public int getBarodesUnit(String barcodes) {

        return null;
    }

    public int getBarodesPrice(String barcodes) {
        for(String iteminfo : itemInfos) {
            for(String item : iteminfo){
                if (barcodes == item.get(0)){
                    return item.get(2)*getBarodesUnit(barcodes);
                }
            }
        }
        return null;
    }

    public int getBarodesTotalPrice(String barcodesTotalPrice) {

        return null;
    }

}
