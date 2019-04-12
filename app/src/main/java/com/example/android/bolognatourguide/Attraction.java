package com.example.android.bolognatourguide;

/**
 * This class represents the thing to see/do in Bologna
 */
public class Attraction {
    private String mTitle;
    private String mAddress;
    private int mPictureID;

    /**
     * @param mTitle     the title of the attraction
     * @param mAddress   the address of the attraction
     * @param mPictureID a picture of the attraction
     */
    public Attraction(String mTitle, String mAddress, int mPictureID) {
        setmTitle(mTitle);
        setmAddress(mAddress);
        setmPictureID(mPictureID);
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

    @Override
    public String toString() {
        return "Attraction{" +
                "mTitle='" + mTitle + '\'' +
                ", mAddress='" + mAddress + '\'' +
                ", mPhotoID=" + mPictureID +
                '}';
    }
}
