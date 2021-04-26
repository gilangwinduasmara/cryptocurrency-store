package com.ggv.cryptocurrencystore.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

public class Asset implements Parcelable {
    private String asset_id;
    private String name;
    private String type_is_crypto;
    private String data_start;
    private String data_end;
    private String data_quote_start;
    private String data_quote_end;
    private String data_orderbook_start;
    private String data_orderbook_end;
    private String data_trade_start;
    private String data_trade_end;
    private String data_symbols_count;
    private String volume_1hrs_usd;
    private String volume_1day_usd;
    private String volume_1mth_usd;
    private String price_usd;
    private String id_icon;

    public Asset() {
    }

    public Asset(String asset_id, String name, String type_is_crypto, String data_start, String data_end, String data_quote_start, String data_quote_end, String data_orderbook_start, String data_orderbook_end, String data_trade_start, String data_trade_end, String data_symbols_count, String volume_1hrs_usd, String volume_1day_usd, String volume_1mth_usd, String price_usd, String id_icon) {
        this.asset_id = asset_id;
        this.name = name;
        this.type_is_crypto = type_is_crypto;
        this.data_start = data_start;
        this.data_end = data_end;
        this.data_quote_start = data_quote_start;
        this.data_quote_end = data_quote_end;
        this.data_orderbook_start = data_orderbook_start;
        this.data_orderbook_end = data_orderbook_end;
        this.data_trade_start = data_trade_start;
        this.data_trade_end = data_trade_end;
        this.data_symbols_count = data_symbols_count;
        this.volume_1hrs_usd = volume_1hrs_usd;
        this.volume_1day_usd = volume_1day_usd;
        this.volume_1mth_usd = volume_1mth_usd;
        this.price_usd = price_usd;
        this.id_icon = id_icon;
    }

    public String getAsset_id() {
        return asset_id;
    }

    public void setAsset_id(String asset_id) {
        this.asset_id = asset_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType_is_crypto() {
        return type_is_crypto;
    }

    public void setType_is_crypto(String type_is_crypto) {
        this.type_is_crypto = type_is_crypto;
    }

    public String getData_start() {
        return data_start;
    }

    public void setData_start(String data_start) {
        this.data_start = data_start;
    }

    public String getData_end() {
        return data_end;
    }

    public void setData_end(String data_end) {
        this.data_end = data_end;
    }

    public String getData_quote_start() {
        return data_quote_start;
    }

    public void setData_quote_start(String data_quote_start) {
        this.data_quote_start = data_quote_start;
    }

    public String getData_quote_end() {
        return data_quote_end;
    }

    public void setData_quote_end(String data_quote_end) {
        this.data_quote_end = data_quote_end;
    }

    public String getData_orderbook_start() {
        return data_orderbook_start;
    }

    public void setData_orderbook_start(String data_orderbook_start) {
        this.data_orderbook_start = data_orderbook_start;
    }

    public String getData_orderbook_end() {
        return data_orderbook_end;
    }

    public void setData_orderbook_end(String data_orderbook_end) {
        this.data_orderbook_end = data_orderbook_end;
    }

    public String getData_trade_start() {
        return data_trade_start;
    }

    public void setData_trade_start(String data_trade_start) {
        this.data_trade_start = data_trade_start;
    }

    public String getData_trade_end() {
        return data_trade_end;
    }

    public void setData_trade_end(String data_trade_end) {
        this.data_trade_end = data_trade_end;
    }

    public String getData_symbols_count() {
        return data_symbols_count;
    }

    public void setData_symbols_count(String data_symbols_count) {
        this.data_symbols_count = data_symbols_count;
    }

    public String getVolume_1hrs_usd() {
        return volume_1hrs_usd;
    }

    public void setVolume_1hrs_usd(String volume_1hrs_usd) {
        this.volume_1hrs_usd = volume_1hrs_usd;
    }

    public String getVolume_1day_usd() {
        return volume_1day_usd;
    }

    public void setVolume_1day_usd(String volume_1day_usd) {
        this.volume_1day_usd = volume_1day_usd;
    }

    public String getVolume_1mth_usd() {
        return volume_1mth_usd;
    }

    public void setVolume_1mth_usd(String volume_1mth_usd) {
        this.volume_1mth_usd = volume_1mth_usd;
    }

    public String getPrice_usd() {

        return price_usd;
    }

    public void setPrice_usd(String price_usd) {

        this.price_usd = price_usd;
    }

    public String getId_icon() {
        return id_icon;
    }

    public void setId_icon(String id_icon) {
        if(id_icon != null){
            id_icon = id_icon.replaceAll("-","");
            id_icon += ".png";
        }
        this.id_icon = id_icon;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.asset_id);
        dest.writeString(this.name);
        dest.writeString(this.type_is_crypto);
        dest.writeString(this.data_start);
        dest.writeString(this.data_end);
        dest.writeString(this.data_quote_start);
        dest.writeString(this.data_quote_end);
        dest.writeString(this.data_orderbook_start);
        dest.writeString(this.data_orderbook_end);
        dest.writeString(this.data_trade_start);
        dest.writeString(this.data_trade_end);
        dest.writeString(this.data_symbols_count);
        dest.writeString(this.volume_1hrs_usd);
        dest.writeString(this.volume_1day_usd);
        dest.writeString(this.volume_1mth_usd);
        dest.writeString(this.price_usd);
        dest.writeString(this.id_icon);
    }

    public void readFromParcel(Parcel source) {
        this.asset_id = source.readString();
        this.name = source.readString();
        this.type_is_crypto = source.readString();
        this.data_start = source.readString();
        this.data_end = source.readString();
        this.data_quote_start = source.readString();
        this.data_quote_end = source.readString();
        this.data_orderbook_start = source.readString();
        this.data_orderbook_end = source.readString();
        this.data_trade_start = source.readString();
        this.data_trade_end = source.readString();
        this.data_symbols_count = source.readString();
        this.volume_1hrs_usd = source.readString();
        this.volume_1day_usd = source.readString();
        this.volume_1mth_usd = source.readString();
        this.price_usd = source.readString();
        this.id_icon = source.readString();
    }

    protected Asset(Parcel in) {
        this.asset_id = in.readString();
        this.name = in.readString();
        this.type_is_crypto = in.readString();
        this.data_start = in.readString();
        this.data_end = in.readString();
        this.data_quote_start = in.readString();
        this.data_quote_end = in.readString();
        this.data_orderbook_start = in.readString();
        this.data_orderbook_end = in.readString();
        this.data_trade_start = in.readString();
        this.data_trade_end = in.readString();
        this.data_symbols_count = in.readString();
        this.volume_1hrs_usd = in.readString();
        this.volume_1day_usd = in.readString();
        this.volume_1mth_usd = in.readString();
        this.price_usd = in.readString();
        this.id_icon = in.readString();
    }

    public static final Parcelable.Creator<Asset> CREATOR = new Parcelable.Creator<Asset>() {
        @Override
        public Asset createFromParcel(Parcel source) {
            return new Asset(source);
        }

        @Override
        public Asset[] newArray(int size) {
            return new Asset[size];
        }
    };
}
