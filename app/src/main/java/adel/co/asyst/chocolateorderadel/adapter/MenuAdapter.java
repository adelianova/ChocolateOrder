package adel.co.asyst.chocolateorderadel.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import adel.co.asyst.chocolateorderadel.R;
import adel.co.asyst.chocolateorderadel.model.Menu;

public class MenuAdapter extends ArrayAdapter<Menu> {

    ArrayList<Menu> listMenu;

    public MenuAdapter(Context context, ArrayList<Menu> listMenu) {
        super(context, R.layout.item_menu, listMenu);

        this.listMenu = listMenu;
    }

    public MenuAdapter(@NonNull Context context, int resource) {
        super(context, resource);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View rootView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_menu, null);
        TextView nametv = rootView.findViewById(R.id.tv_menu);
        TextView toppingtv = rootView.findViewById(R.id.tv_topping);

        nametv.setText(listMenu.get(position).getMenu());
        toppingtv.setText(listMenu.get(position).getTopping());

        return rootView;
    }
}
