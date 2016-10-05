package com.example.zendynamix.trackitem;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class ProductDetailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Product Details");
        //setTitle(Html.fromHtml("<font color='#ff0000'>ActionBarTitle </font>"));
        setContentView(R.layout.fragment_product_detail);
        if(savedInstanceState==null){
            ProductDetailFragment productDetailFragment=new ProductDetailFragment();
            getSupportFragmentManager().beginTransaction().add(R.id.product_fragment,productDetailFragment).commit();
        }
    }
}
