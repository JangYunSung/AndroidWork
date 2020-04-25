package com.lec.android.mydd;


import android.icu.util.ULocale;
import android.os.Parcel;
import android.os.Parcelable;

public class ItemDB {
        private final String TYPE_STRING = "string";
        private final String TYPE_DRAWABLE = "drawable";
        private int name;
        private int desc;
        private float hunger;
        private float armor;
        private float cooldown;
        private String attack;
        private String pc_ver;
        private String pe_ver;
        private String grid;
        private int icon;
        private ULocale.Category category;
    public ItemDB(Parcel parcel) {
        // must be same order with writeToParcel()
        this.name = parcel.readInt();
        this.desc = parcel.readInt();
        this.icon = parcel.readInt();
        this.hunger = parcel.readFloat();
        this.armor = parcel.readFloat();
        this.cooldown = parcel.readFloat();
        this.attack = parcel.readString();
        this.pc_ver = parcel.readString();
        this.pe_ver = parcel.readString();
        this.grid = parcel.readString();
    }
    public ItemDB(...) {
        // your constructor
    }
    // create Parcelable
    public static final Parcelable.Creator<ItemDB> CREATOR = new Parcelable.Creator<ItemDB>() {
        @Override
        public ItemDB createFromParcel(Parcel parcel) {
            return new ItemDB(parcel);
        }
        @Override
        public ItemDB[] newArray(int size) {
            return new ItemDB[size];
        }
    };
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.name);
        dest.writeInt(this.desc);
        dest.writeInt(this.icon);
        dest.writeFloat(this.hunger);
        dest.writeFloat(this.armor);
        dest.writeFloat(this.cooldown);
        dest.writeString(this.attack);
        dest.writeString(this.pc_ver);
        dest.writeString(this.pe_ver);
        dest.writeString(this.grid);
    }
    @Override
    public int describeContents() {
        return 0;
    }
    public int getName {
        return this.name;
    }
}

