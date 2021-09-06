package com.example.thefoodcorner.Modals;

public class MainModal {
    int img;
    String name, price , description;

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public MainModal(int img, String name, String price, String description) {
        this.img = img;
        this.name = name;
        this.price = price;
        this.description = description;
    }
}
