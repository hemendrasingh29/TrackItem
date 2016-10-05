package com.example.zendynamix.trackitem;

import java.io.Serializable;

/**
 * Created by zendynamix on 7/6/2016.
 */
public class ItemData implements Serializable{
    private static final String LOG = "Login activity>>>>";

    private String itemName;
    private String deliveryStatus;
    private String itemImageUri;
    private String retailer;
    private String archive;

    public String getItemName() {return itemName;}

    public void setItemName(String item) {
        this.itemName = item;
    }

    public String getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(String trackStatus) {
        this.deliveryStatus = trackStatus;
    }

    public String getRetailer() {return retailer;}

    public void setRetailer(String retailer) {
        this.retailer = retailer;
    }

    public String getItemImageUri() {
        return itemImageUri;
    }

    public void setItemImageUri(String itemImageUri) {
        this.itemImageUri = itemImageUri;
    }
      public String getPhotoFilename(){
     return "IMG_"+getItemName()+".jpg";
}

    public String getArchive() {
        return archive;
    }

    public void setArchive(String archive) {
        this.archive = archive;
    }
}


