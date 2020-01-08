package com.example.helal;

/**
 * Created by Mohamed on 10/12/2018.
 */
public class product {

    public int getProduct_image() {
        return product_image;
    }

    public void setProduct_image(int product_image) {
        this.product_image = product_image;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    private int product_image;
    private String product_name;

    public product(int product_image, String product_name) {
        this.product_image = product_image;
        this.product_name = product_name;
    }
    public product() {

    }



}
