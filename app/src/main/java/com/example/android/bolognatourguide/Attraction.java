package com.example.android.bolognatourguide;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * This class represents the thing to see/do in Bologna
 */
public class Attraction implements Parcelable {
    private String mTitle;
    private String mAddress;
    private int mPictureID;
    private String mDescription;

    /**
     * @param mTitle       the title of the attraction
     * @param mAddress     the address of the attraction
     * @param mPictureID   a picture of the attraction
     * @param mDescription the description of the attraction
     */
    public Attraction(String mTitle, String mAddress, int mPictureID, String mDescription) {
        setmTitle(mTitle);
        setmAddress(mAddress);
        setmPictureID(mPictureID);
        setmDescription(mDescription);
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getmAddress() {
        return mAddress;
    }

    public void setmAddress(String mAddress) {
        this.mAddress = mAddress;
    }

    public int getmPictureID() {
        return mPictureID;
    }

    public void setmPictureID(int mPictureID) {
        this.mPictureID = mPictureID;
    }

    public String getmDescription() {
        return mDescription;
    }

    public void setmDescription(String mDescription) {
        this.mDescription = mDescription;
    }

    @Override
    public String toString() {
        return "Attraction{" +
                "mTitle='" + mTitle + '\'' +
                ", mAddress='" + mAddress + '\'' +
                ", mPictureID=" + mPictureID +
                ", mDescription='" + mDescription + '\'' +
                '}';
    }

    // In constructor you will read the variables from Parcel. Make sure to read them in the same sequence in which you have written them in Parcel.
    public Attraction(Parcel in) {

        mTitle = in.readString();
        mAddress = in.readString();
        mPictureID = in.readInt();
        mDescription = in.readString();
    }

    // This is to de-serialize the object
    public static final Creator<Attraction> CREATOR = new Creator<Attraction>() {
        @Override
        public Attraction createFromParcel(Parcel in) {
            return new Attraction(in);
        }

        @Override
        public Attraction[] newArray(int size) {
            return new Attraction[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    // This is where you will write your member variables in Parcel. Here you can write in any order. It is not necessary to write all members in Parcel.
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mTitle);
        dest.writeString(mAddress);
        dest.writeInt(mPictureID);
        dest.writeString(mDescription);
    }
}
