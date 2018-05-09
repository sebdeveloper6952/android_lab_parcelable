package com.sebdeveloper6952.lab2_listview_parcelable;

import android.os.Parcel;
import android.os.Parcelable;

public class ParcelableUser implements Parcelable
{
    private String name;
    private int age;
    private ParcelableAddress address;

    public ParcelableUser(String name, int age, String address, String city)
    {
        this.name = name;
        this.age = age;
        this.address = new ParcelableAddress(address, city);
    }

    protected ParcelableUser(Parcel in)
    {
        name = in.readString();
        age = in.readInt();
        address = in.readParcelable(ParcelableAddress.class.getClassLoader());
    }

    @Override
    public void writeToParcel(Parcel dest, int flags)
    {
        dest.writeString(name);
        dest.writeInt(age);
        dest.writeParcelable(address, flags);
    }

    @Override
    public int describeContents() { return 0; }

    public static final Creator<ParcelableUser> CREATOR = new Creator<ParcelableUser>()
    {
        @Override
        public ParcelableUser createFromParcel(Parcel in)
        {
            return new ParcelableUser(in);
        }

        @Override
        public ParcelableUser[] newArray(int size)
        {
            return new ParcelableUser[size];
        }
    };

    @Override
    public String toString()
    {
        return name + "," + age + "," + address;
    }
}
