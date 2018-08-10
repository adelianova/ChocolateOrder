package adel.co.asyst.chocolateorderadel.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Menu implements Parcelable {
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
    String menu;
    String topping;

    protected Menu(Parcel in) {
        menu = in.readString();
        topping = in.readString();
    }

    public Menu(String menu, String topping) {
        this.menu = menu;
        this.topping = topping;
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(menu);
        dest.writeString(topping);
    }
}
