package com.example.mvmax.mindgames.example;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class ExampleMessageModel implements Parcelable {

    @IntDef({DialogMessageType.INFO,
            DialogMessageType.PRESENTER,
            DialogMessageType.PLAYER,
            DialogMessageType.FINISH})
    @Retention(RetentionPolicy.SOURCE)
    public @interface DialogMessageType {

        int INFO = 0;
        int PRESENTER = 1;
        int PLAYER = 2;
        int FINISH = 3;
    }

    @DialogMessageType
    private int mType;
    private String mMessage;

    public ExampleMessageModel(final String pMessage, @DialogMessageType final int pType) {
        mMessage = pMessage;
        mType = pType;
    }

    public void setType(@DialogMessageType final int pType) {
        mType = pType;
    }

    @DialogMessageType
    public int getType() {
        return mType;
    }

    public void setMessage(final String pMessage) {
        mMessage = pMessage;
    }

    public String getMessage() {
        return mMessage;
    }

    protected ExampleMessageModel(final Parcel in) {
        mType = in.readInt();
        mMessage = in.readString();
    }

    public static final Creator<ExampleMessageModel> CREATOR = new Creator<ExampleMessageModel>() {

        @Override
        public ExampleMessageModel createFromParcel(final Parcel in) {
            return new ExampleMessageModel(in);
        }

        @Override
        public ExampleMessageModel[] newArray(final int size) {
            return new ExampleMessageModel[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(final Parcel pParcel, final int pI) {
        pParcel.writeInt(mType);
        pParcel.writeString(mMessage);
    }
}
