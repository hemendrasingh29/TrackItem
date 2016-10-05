package com.example.zendynamix.trackitem;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.zendynamix.trackitem.utils.PictureUtils;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zendynamix on 7/12/2016.
 */
public class ProductDetailFragment extends Fragment {
    private static final String LOG = ProductDetailFragment.class.getSimpleName();
    static final int REQUEST_IMAGE_CAPTURE = 1;
    static final int CAMERA_RESULT_OK = 0;
    private static final int REQUEST_PHOTO = 2;
    private ItemData itemData;
    private List<ItemData> itemDatList = new ArrayList<>();
    private ImageView dImageViewDetail;
    private TextView dItemTitle;
    private TextView dRetailerName;
    private TextView dDeliveryStatus;
    private ImageView cameraButton;
    private Bitmap bitmap;
    private ImageView cameraImage;
    private Context context;
    private File photoFile;
    private Button sendButton;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        photoFile=getPhotoFile(itemData);


    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.product_detail, container, false);
        dImageViewDetail = (ImageView) view.findViewById(R.id.image_view_detail);

        Bundle bundle = getActivity().getIntent().getExtras();
        if (bundle != null) {
            int position = bundle.getInt("position");
            itemDatList = (List<ItemData>) bundle.getSerializable("list");
            itemData = itemDatList.get(position);
            String imgUri = itemData.getItemImageUri();
            Picasso.with(getContext()).load("http://api.tracck.com:4000/productimg/" + imgUri).into(dImageViewDetail);

            dItemTitle = (TextView) view.findViewById(R.id.detail_item_title);
            dRetailerName = (TextView) view.findViewById(R.id.detail_retailer_name);
            dDeliveryStatus = (TextView) view.findViewById(R.id.detail_delivery_status);

            dItemTitle.setText(itemData.getItemName());
            dRetailerName.setText(getString(R.string.retailer));
            String dStatus = itemData.getDeliveryStatus();
            if (dStatus.charAt(0) == 'D' || dStatus.charAt(0) == 'd') {
                dDeliveryStatus.setTextColor(getResources().getColor(R.color.light_green));
            } else {
                dDeliveryStatus.setTextColor(getResources().getColor(R.color.dark_yellow));
            }
            dDeliveryStatus.setText(itemData.getDeliveryStatus());
        }
        cameraButton = (ImageView) view.findViewById(R.id.camera);
        cameraButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dispatchTakePictureIntent();
            }
        });
        cameraImage = (ImageView) view.findViewById(R.id.camera_image);
       updatePhotoView();
        sendButton=(Button)view.findViewById(R.id.send_button);
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cameraImage.setImageDrawable(null);
                photoFile.delete();
            }
        });
        return view;
    }
    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        boolean cantakePicture= photoFile !=null &&
        takePictureIntent.resolveActivity(getActivity().getPackageManager()) != null;
        cameraButton.setEnabled(cantakePicture);
        if(cantakePicture){
            Uri uri=Uri.fromFile(photoFile);
            takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT,uri);
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == CAMERA_RESULT_OK) {
            updatePhotoView();
            Log.v(LOG, ">>>EXTRA>" + bitmap);
        }
    }

    public File getPhotoFile(ItemData itemData) {
        File externalFilesDir = getContext().getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        if (externalFilesDir == null) {
            return null;
        }
        ItemData itemData1 = new ItemData();
        return new File(externalFilesDir,itemData1.getPhotoFilename());
    }

    private void updatePhotoView(){
        if(photoFile==null||!photoFile.exists()){
            cameraImage.setImageDrawable(null);
        }else{
            Bitmap bitmap= PictureUtils.getscaledBitmap(photoFile.getPath(),getActivity());
            cameraImage.setImageBitmap(bitmap);
        }
    }


}
