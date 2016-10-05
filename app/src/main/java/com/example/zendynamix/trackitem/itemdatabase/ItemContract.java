package com.example.zendynamix.trackitem.itemdatabase;

import android.provider.BaseColumns;

/**
 * Created by zendynamix on 8/9/2016.
 */
public final class ItemContract {
    private ItemContract() {
    }
    public static final class ConsumerOrder implements BaseColumns {
//        public static final class ItemTable {
//        }
        public static final String TABLE_NAME = "consumerOrder";
        public static final class Cols {
            public static final String IMAGE_URI = "imageUrl";
            public static final String PRODUCT_NAME = "productName";
            public static final String RETAILER_ID = "retailerId";
            public static final String PRODUCT_DELIVERY_STATUS = "currentStatus";
            public static final String ARCHIVE="archive";
        }
    }
    public static final class RetailerEntry implements BaseColumns{
        public static final String TABLE_NAME= "retailer";

        public static final class Cols{
            public static final String RETAILER_ID = "retailerId";
            public static final String RETAILER_SHORT_NAME="retSortName";
            public static final String RETAILER_FULL_NAME="retFullName";
            public static final String RETAILER_DISPLAY_NAME="retDisplyName";

        }
    }
    public static final class Product implements BaseColumns{
        public static final String TABLE_NAME="product";

        public static final class Cols{
            public static final String PRODUCT_ID_RETAILER="prodIdRetailer";
            public static final String PRODUCT_RETAILER="productRetailer";
            public static final String MODEL_NUMBER="modelNumber";
            public static final String MANUFACTURER_ID= "manufacturerId";
            public static final String MANUFACTURER_NAME="manufacturerName";
        }
    }

    public static final class Consumer implements BaseColumns{

        public static final String TABLE_NAME="consumer";
        public static final class Cols{
            public static final String CONSUMER_ID="consumerId";
            public static final String USER_NAME="userName";
            public static final String PASSWORD="password";
            public static final String FIRST_NAME="firstName";
            public static final String LAST_NAME="lastName";
            public static final String EMAIL="email";
            public static final String PHONE_NUMBER="phoneNo";

        }
    }
}


