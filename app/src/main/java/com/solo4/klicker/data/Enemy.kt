package com.solo4.klicker.data

import android.os.Parcel
import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Enemy(
    @ColumnInfo var level: Int,
    @ColumnInfo var name: Int,
    @ColumnInfo var description: Int,
    @ColumnInfo var image: Int,
    @ColumnInfo var defaultGold: Double,
    @ColumnInfo var attack: Double,
    @ColumnInfo var hp: Double,
    @ColumnInfo var critRate: Double,
    @ColumnInfo var defeat: Boolean
) : Parcelable {
    @ColumnInfo
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0

    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readDouble(),
        parcel.readDouble(),
        parcel.readDouble(),
        parcel.readDouble(),
        parcel.readByte() != 0.toByte()
    ) {
        id = parcel.readInt()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(level)
        parcel.writeInt(name)
        parcel.writeInt(description)
        parcel.writeInt(image)
        parcel.writeDouble(defaultGold)
        parcel.writeDouble(attack)
        parcel.writeDouble(hp)
        parcel.writeDouble(critRate)
        parcel.writeByte(if (defeat) 1 else 0)
        parcel.writeInt(id)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Enemy> {
        override fun createFromParcel(parcel: Parcel): Enemy {
            return Enemy(parcel)
        }

        override fun newArray(size: Int): Array<Enemy?> {
            return arrayOfNulls(size)
        }
    }
}