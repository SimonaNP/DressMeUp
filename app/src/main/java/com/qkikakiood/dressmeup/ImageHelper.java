package com.qkikakiood.dressmeup;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;

import java.io.ByteArrayOutputStream;

/**
 * Created by a on 18.7.2016 г..
 */
public class ImageHelper {
//    private String imageId;
//    private byte[] imageByteArray;
//    public String getImageId() {
//        return imageId;
//    }
//    public void setImageId(String imageId) {
//        this.imageId = imageId;
//    }
//    public byte[] getImageByteArray() {
//        return imageByteArray;
//    }
//    public void setImageByteArray(byte[] imageByteArray) {
//        this.imageByteArray = imageByteArray;
//    }

    public static String BitMapToString(Bitmap bitmap){
        ByteArrayOutputStream baos=new  ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG,100, baos);
        byte [] b=baos.toByteArray();
        String temp= Base64.encodeToString(b, Base64.DEFAULT);
        return temp;
    }

    public static Bitmap StringToBitMap(String encodedString){
        try {
            byte [] encodeByte=Base64.decode(encodedString,Base64.DEFAULT);
            Bitmap bitmap= BitmapFactory.decodeByteArray(encodeByte, 0, encodeByte.length);
            return bitmap;
        } catch(Exception e) {
            e.getMessage();
            return null;
        }
    }


}

