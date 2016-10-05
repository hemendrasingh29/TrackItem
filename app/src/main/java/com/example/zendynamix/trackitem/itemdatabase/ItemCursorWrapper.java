package com.example.zendynamix.trackitem.itemdatabase;

import android.database.Cursor;
import android.database.CursorWrapper;

import com.example.zendynamix.trackitem.itemdatabase.ItemContract.ConsumerOrder;
import com.example.zendynamix.trackitem.ItemData;



/**
 * Created by zendynamix on 8/9/2016.
 */
public class ItemCursorWrapper extends CursorWrapper{


    public static final String LOG_TAG=ItemCursorWrapper.class.getSimpleName();

    public  ItemCursorWrapper(Cursor cursor){
        super(cursor);
    }

    public ItemData getItems(){

        String pImageUri= getString(getColumnIndex(ConsumerOrder.Cols.IMAGE_URI));
        String pName=getString(getColumnIndex(ConsumerOrder.Cols.PRODUCT_NAME));
        String pRetailerId=getString(getColumnIndex(ConsumerOrder.Cols.RETAILER_ID));
        String pDeliveryStatus=getString(getColumnIndex(ConsumerOrder.Cols.PRODUCT_DELIVERY_STATUS));
        String pArchiveStatus=getString(getColumnIndex(ConsumerOrder.Cols.ARCHIVE));

        ItemData itemData=new ItemData();

        return itemData;
    }
}
