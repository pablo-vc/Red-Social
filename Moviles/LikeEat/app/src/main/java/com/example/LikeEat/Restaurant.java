package com.example.LikeEat;

import java.util.ArrayList;

public class Restaurant {
    private String name;
    private ArrayList<Integer> Images;
    private int imageResId; // Usaremos imágenes de drawable
    private String category1="";
    private String category2="";
    private String category3="";

    public Restaurant(String name, int imageResId) {
        this.name = name;
        this.imageResId = imageResId;
    }

    public Restaurant(String name, int imageResId, String category1) {
        this(name, imageResId);
        this.category1=category1;

    }

    public Restaurant(String name, int imageResId, String category1, String category2) {
        this(name, imageResId, category1);
        this.category2=category2;
    }

    public Restaurant(String name, int imageResId, String category1, String category2, String category3) {
        this(name, imageResId, category1, category2);
        this.category3=category3;
    }


    public String getName() {
        return name;
    }

    public int getImageResId() {
        return imageResId;
    }

    public String getCategory1() {
        return category1;
    }

    public void setCategory1(String category1) {
        this.category1 = category1;
    }

    public String getCategory2() {
        return category2;
    }

    public void setCategory2(String category2) {
        this.category2 = category2;
    }

    public String getCategory3() {
        return category3;
    }

    public void setCategory3(String category3) {
        this.category3 = category3;
    }
}
