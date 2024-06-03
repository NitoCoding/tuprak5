package com.example.tuprak5;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Data implements Parcelable {

    private String username;
    private String name;
    private String desc;
    private int fotoProfile;
    private int fotoPostingan;
    private Uri selectedImageUri;

    // Constructor
    public Data(String username, String name, String desc, int fotoProfile, int fotoPostingan) {
        this.username = username;
        this.name = name;
        this.desc = desc;
        this.fotoProfile = fotoProfile;
        this.fotoPostingan = fotoPostingan;
    }

    // Constructor with URI
    public Data(String username, String name, String desc, int fotoProfile, Uri selectedImageUri) {
        this.username = username;
        this.name = name;
        this.desc = desc;
        this.fotoProfile = fotoProfile;
        this.selectedImageUri = selectedImageUri;
    }

    // Getter and Setter methods
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDeskripsi() {
        return desc;
    }

    public void setDeskripsi(String desc) {
        this.desc = desc;
    }

    public int getFotoProfile() {
        return fotoProfile;
    }

    public void setFotoProfile(int fotoProfile) {
        this.fotoProfile = fotoProfile;
    }

    public int getFotoPostingan() {
        return fotoPostingan;
    }

    public void setFotoPostingan(int fotoPostingan) {
        this.fotoPostingan = fotoPostingan;
    }

    public Uri getSelectedImageUri() {
        return selectedImageUri;
    }

    public void setSelectedImageUri(Uri selectedImageUri) {
        this.selectedImageUri = selectedImageUri;
    }

    // Parcelable implementation
    protected Data(Parcel in) {
        username = in.readString();
        name = in.readString();
        desc = in.readString();
        fotoProfile = in.readInt();
        fotoPostingan = in.readInt();
    }

    public static final Creator<Data> CREATOR = new Creator<Data>() {
        @Override
        public Data createFromParcel(Parcel in) {
            return new Data(in);
        }

        @Override
        public Data[] newArray(int size) {
            return new Data[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(username);
        dest.writeString(name);
        dest.writeString(desc);
        dest.writeInt(fotoProfile);
        dest.writeInt(fotoPostingan);
    }
}

