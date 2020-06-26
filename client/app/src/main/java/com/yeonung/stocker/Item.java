package com.yeonung.stocker;

import com.google.gson.annotations.SerializedName;

public class Item {
    @SerializedName("_id")
    String _id;
    @SerializedName("id")
    int id;
    @SerializedName("name")
    String name;
    @SerializedName("price")
    int price;
    @SerializedName("count")
    int count;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
