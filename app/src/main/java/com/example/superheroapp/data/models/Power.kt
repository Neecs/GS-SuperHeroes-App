package com.example.superheroapp.data.models

import android.os.Parcel
import android.os.Parcelable

data class Power(
    val id: Int,
    val name: String
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString() ?: ""
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(name)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Power> {
        override fun createFromParcel(parcel: Parcel): Power {
            return Power(parcel)
        }

        override fun newArray(size: Int): Array<Power?> {
            return arrayOfNulls(size)
        }
    }
}