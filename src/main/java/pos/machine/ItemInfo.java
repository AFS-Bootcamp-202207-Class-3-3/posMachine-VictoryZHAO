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

    public String getBarcodesAll(List<String> barcodesList) {
        ArrayList<String> receiptList = new ArrayList<>();
        receiptList.add("***<store earning no money>Receipt***\n");
        for(String barcodes : barcodesList){
            receiptList.add(getBarcodesLine(barcodes));
            int totalPrice = totalPrice + getBarodesPrice(barcodes);
        }
        receiptList.add("----------------------\n");
        receiptList.add("Total: " + totalPrice + " (yuan)\n");
        receiptList.add("**********************");
        return String.format(String.join("%n",  barcodesList));
    }

    public String getBarcodesLine(String barcodes){
        for(String item : itemInfos) {
            if (barcodes == item.get(0)){
                return String  barcodesLine = "Name: " + getBarcodesName(barcodes) + ", Quantity: "
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


}
