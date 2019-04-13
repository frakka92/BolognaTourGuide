package com.example.android.bolognatourguide;

/**
 * This class represents the thing to see/do in Bologna
 */
public class Attraction {
    private String mTitle;
    private String mAddress;
    private int mPictureID;
    private String mDescription;

    /**
     * @param mTitle     the title of the attraction
     * @param mAddress   the address of the attraction
     * @param mPictureID a picture of the attraction
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
}
