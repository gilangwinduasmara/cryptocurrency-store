package com.ggv.cryptocurrencystore.models;

public class Transaction {
    private String id;
    private String asset_id;
    private double price_usd;
    private String status;
    private double ammount;
    private String created_at;
    private String updated_at;
    private Asset asset;

    public Transaction() {
    }

    public Transaction(String id, String asset_id, double price_usd, String status, double ammount, String created_at, String updated_at, Asset asset) {
        this.id = id;
        this.asset_id = asset_id;
        this.price_usd = price_usd;
        this.status = status;
        this.ammount = ammount;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.asset = asset;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAsset_id() {
        return asset_id;
    }

    public void setAsset_id(String asset_id) {
        this.asset_id = asset_id;
    }

    public double getPrice_usd() {
        return price_usd;
    }

    public void setPrice_usd(double price_usd) {
        this.price_usd = price_usd;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getAmmount() {
        return ammount;
    }

    public void setAmmount(double ammount) {
        this.ammount = ammount;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public Asset getAsset() {
        return asset;
    }

    public void setAsset(Asset asset) {
        this.asset = asset;
    }
}
