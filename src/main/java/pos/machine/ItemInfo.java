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

    public String getBarcodesAll(List<String> barcodes) {

        return null;
    }

    public String getBarcodesLine(String barcodes){
        ArrayList<String> infoList = new ArrayList<>();
        for(String item : itemInfos) {
            if (barcodes == item.get(0)){
                return String  line = "Name: " + getBarcodesName(barcodes) + ", Quantity: "
                        + getBarcodesQuantity(barcodes) + ", Unit Price: " + getBarodesUnit(barcodes)
                        + " (yuan), Subtotal: " + getBarodesPrice(barcodes) + " (yuan)\n";
            }
        }
    }


    public String getBarcodesName(String barcodes) {
        for(String item : itemInfos) {
            if (barcodes == item.get(0)){
                return item.get(1);
            }
        }
        return null;
    }

    public int getBarcodesQuantity(String barcodes) {
        int quantity;
        for(String iteminfo : itemInfos) {
            if (barcodes == item.get(0)){
                quantity++;
            }
        }
        return quantity;
    }

    public int getBarodesUnit(String barcodes) {
        for(String item : itemInfos) {
                if (barcodes == item.get(0)){
                    return item.get(2);
                }
        }
        return null;
    }

    public int getBarodesPrice(String barcodes) {
        return getBarodesUnit(barcodes) * getBarodesQuantity(barcodes);
    }

    public int getBarodesTotalPrice(String barcodesTotalPrice) {

        return null;
    }

}
