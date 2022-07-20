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
        receiptList.add("***<store earning no money>Receipt***");
        for(ItemInfo iteminfo : itemInfos){
            receiptList.add(getBarcodesLine(barcodesList, iteminfo.getBarcode()));
            totalPrice = totalPrice + getBarodesPrice(barcodesList, iteminfo.getBarcode());
        }
        receiptList.add("----------------------");
        receiptList.add("Total: " + totalPrice + " (yuan)");
        receiptList.add("**********************");
        return String.format(String.join("\n",  receiptList));
    }

    public String getBarcodesLine(List<String> barcodesList, String barcodes){
        List<ItemInfo> itemInfos = ItemDataLoader.loadAllItemInfos();
        for(ItemInfo item : itemInfos) {
            if (barcodes == item.getBarcode()){
                return "Name: " + getBarcodesName(barcodes) + ", Quantity: "
                        + getBarcodesQuantity(barcodesList, barcodes) + ", Unit price: " + getBarodesUnit(barcodes)
                        + " (yuan), Subtotal: " + getBarodesPrice(barcodesList, barcodes) + " (yuan)";
            }
        }
        return null;
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
        return 0;
    }

    public int getBarodesPrice(List<String>  barcodesList, String barcodes) {
        return getBarodesUnit(barcodes) * getBarcodesQuantity(barcodesList, barcodes);
    }

}
