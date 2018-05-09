package com.sebdeveloper6952.lab2_listview_parcelable;

import android.os.Parcel;
import android.os.Parcelable;

public class ParcelableAddress implements Parcelable
{
    private String address;
    private String city;

    public ParcelableAddress(String address, String city)
    {
        this.address = address;
        this.city = city;
    }

    protected ParcelableAddress(Parcel in)
    {
        address = in.readString();
        city = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags)
    {
        dest.writeString(address);
        dest.writeString(city);
    }

    @Override
    public int describeContents() { return 0; }

    public static final Creator<ParcelableAddress> CREATOR = new Creator<ParcelableAddress>()
    {
        @Override
        public ParcelableAddress createFromParcel(Parcel in)
        {
            return new ParcelableAddress(in);
        }

        @Override
        public ParcelableAddress[] newArray(int size)
        {
            return new ParcelableAddress[size];
        }
    };

    @Override
    public String toString()
    {
        return address + "," + city;
    }
}
