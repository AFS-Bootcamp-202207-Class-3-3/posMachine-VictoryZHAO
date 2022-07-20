package pos.machine;

import java.util.ArrayList;
import java.util.List;

public class PosMachine {
    public String printReceipt(List<String> barcodes) {

        return getBarcodesAll(barcodes);
    }

    public String getBarcodesAll(List<String> barcodesList) {
        ArrayList<String> receiptList = new ArrayList<>();
        List<ItemInfo> itemInfos = ItemDataLoader.loadAllItemInfos();
        int totalPrice = 0;
        receiptList.add("***<store earning no money>Receipt***\n");
        for(ItemInfo barcodes : itemInfos){
            receiptList.add(getBarcodesLine(barcodes));
            totalPrice = totalPrice + getBarodesPrice(barcodes);
        }
        receiptList.add("----------------------\n");
        receiptList.add("Total: " + totalPrice + " (yuan)\n");
        receiptList.add("**********************");
        return String.format(String.join("%n",  barcodesList));
    }

    public String getBarcodesLine(String barcodes){
        List<ItemInfo> itemInfos = ItemDataLoader.loadAllItemInfos();
        for(ItemInfo item : itemInfos) {
            if (barcodes == item.getBarcode()){
                return "Name: " + getBarcodesName(barcodes) + ", Quantity: "
                        + getBarcodesQuantity(barcodes) + ", Unit Price: " + getBarodesUnit(barcodes)
                        + " (yuan), Subtotal: " + getBarodesPrice(barcodes) + " (yuan)\n";
            }
        }
    }

    public String getBarcodesName(String barcodes) {
        List<ItemInfo> itemInfos = ItemDataLoader.loadAllItemInfos();
        for(ItemInfo item : itemInfos) {
            if (barcodes == item.getBarcode()){
                return item.getName();
            }
        }
        return null;
    }

    public int getBarcodesQuantity(List<String>  barcodesList, String barcodes) {
        int quantity = 0;
        for(String iteminfo : barcodesList) {
            if (barcodes == iteminfo){
                quantity++;
            }
        }
        return quantity;
    }

    public int getBarodesUnit(String barcodes) {
        List<ItemInfo> itemInfos = ItemDataLoader.loadAllItemInfos();
        for(ItemInfo item : itemInfos) {
            if (barcodes == item.getBarcode()){
                return item.getPrice();
            }
        }
    }

    public int getBarodesPrice(List<String>  barcodesList, String barcodes) {
        return getBarodesUnit(barcodes) * getBarcodesQuantity(barcodesList, barcodes);
    }

}
