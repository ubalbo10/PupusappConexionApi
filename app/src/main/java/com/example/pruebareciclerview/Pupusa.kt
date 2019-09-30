package com.example.pruebareciclerview

import android.os.Parcel
import android.os.Parcelable

class Pupusa(var relleno:String, var conMaiz:Int, var conArroz:Int) :Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readInt(),
        parcel.readInt()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(relleno)
        parcel.writeInt(conMaiz)
        parcel.writeInt(conArroz)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Pupusa> {
        override fun createFromParcel(parcel: Parcel): Pupusa {
            return Pupusa(parcel)
        }

        override fun newArray(size: Int): Array<Pupusa?> {
            return arrayOfNulls(size)
        }
    }
}
