package ru.taxik.model.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class City {

    @Expose
    @SerializedName("city_id")
    public long id;

    @Expose
    @SerializedName("order")
    public long order;

    @Expose
    @SerializedName("city_name")
    public String name;

    @Expose
    @SerializedName("city_latitude")
    public double latitude;

    @Expose
    @SerializedName("city_longitude")
    public double longitude;

    @Expose
    @SerializedName("city_spn_latitude")
    public double spnLatitude;

    @Expose
    @SerializedName("city_spn_longitude")
    public double spnLongitude;

    @Expose
    @SerializedName("last_app_android_version")
    public long lastAppAndroidVersion;

    @Expose
    @SerializedName("transfers")
    public boolean transfers;

    @Expose
    @SerializedName("client_email_required")
    public boolean clientEmailRequired;

    @Expose
    @SerializedName("registration_promocode")
    public boolean registrationPromocode;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getSpnLatitude() {
        return spnLatitude;
    }

    public void setSpnLatitude(double spnLatitude) {
        this.spnLatitude = spnLatitude;
    }

    public double getSpnLongitude() {
        return spnLongitude;
    }

    public void setSpnLongitude(double spnLongitude) {
        this.spnLongitude = spnLongitude;
    }

    public long getLastAppAndroidVersion() {
        return lastAppAndroidVersion;
    }

    public void setLastAppAndroidVersion(long lastAppAndroidVersion) {
        this.lastAppAndroidVersion = lastAppAndroidVersion;
    }

    public boolean isTransfers() {
        return transfers;
    }

    public void setTransfers(boolean transfers) {
        this.transfers = transfers;
    }

    public boolean isClientEmailRequired() {
        return clientEmailRequired;
    }

    public void setClientEmailRequired(boolean clientEmailRequired) {
        this.clientEmailRequired = clientEmailRequired;
    }

    public boolean isRegistrationPromocode() {
        return registrationPromocode;
    }

    public void setRegistrationPromocode(boolean registrationPromocode) {
        this.registrationPromocode = registrationPromocode;
    }

}
