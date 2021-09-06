package com.example.thefoodcorner.Modals;

public class OrderModal {
    int orderImg;
    String soldItemName , price , orderNumber;

    public OrderModal(int orderImg, String soldItemName, String price, String orderNumber) {
        this.orderImg = orderImg;
        this.soldItemName = soldItemName;
        this.price = price;
        this.orderNumber = orderNumber;
    }

    public OrderModal() {
        this.orderImg = orderImg;
        this.soldItemName = soldItemName;
        this.price = price;
        this.orderNumber = orderNumber;
    }


    public int getOrderImg() {
        return orderImg;
    }

    public void setOrderImg(int orderImg) {
        this.orderImg = orderImg;
    }

    public String getSoldItemName() {
        return soldItemName;
    }

    public void setSoldItemName(String soldItemName) {
        this.soldItemName = soldItemName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }


}
