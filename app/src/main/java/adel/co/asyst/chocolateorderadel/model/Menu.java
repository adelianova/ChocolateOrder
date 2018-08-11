package adel.co.asyst.chocolateorderadel.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Menu implements Parcelable {
    String menu;
    String topping;
    public static final Creator<Menu> CREATOR = new Creator<Menu>() {
        @Override
        public Menu createFromParcel(Parcel in) {
            return new Menu(in);
        }

        @Override
        public Menu[] newArray(int size) {
            return new Menu[size];
        }
    };
    String nama;
    int hargatotal;

    public Menu(String menu, String topping, String nama, int hargatotal) {
        this.menu = menu;
        this.topping = topping;
        this.nama = nama;
        this.hargatotal = hargatotal;
    }

    protected Menu(Parcel in) {
        menu = in.readString();
        topping = in.readString();
        nama = in.readString();
        hargatotal = in.readInt();
    }

    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }

    public String getTopping() {
        return topping;
    }

    public void setTopping(String topping) {
        this.topping = topping;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getHargatotal() {
        return hargatotal;
    }

    public void setHargatotal(int hargatotal) {
        this.hargatotal = hargatotal;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(menu);
        dest.writeString(topping);
        dest.writeString(nama);
        dest.writeInt(hargatotal);
    }
}
