package com.qkikakiood.dressmeup.cmn;

import android.graphics.Bitmap;

import com.qkikakiood.dressmeup.ImageHelper;

/**
 * Created by a on 19.7.2016 г..
 */
public class Cloth {
    public Cloth(Bitmap image, int clothID) {
        this.image = image;
        this.clothID = clothID;
    }

    private Bitmap image;
    private int clothID;
   // private String category;
    //private String colour;


    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }

    public int getClothID() {
        return clothID;
    }

    public void setClothID(int clothID) {
        this.clothID = clothID;
    }

//    public String getCategory() {
//        return category;
//    }
//
//    public void setCategory(String category) {
//        this.category = category;
//    }
//
//    public String getColour() {
//        return colour;
//    }
//
//    public void setColour(String colour) {
//        this.colour = colour;
//    }


}
