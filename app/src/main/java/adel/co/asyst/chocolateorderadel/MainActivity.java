package adel.co.asyst.chocolateorderadel;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import adel.co.asyst.chocolateorderadel.adapter.MenuAdapter;
import adel.co.asyst.chocolateorderadel.model.Menu;
import adel.co.asyst.chocolateorderadel.utility.Constant;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ListView orderlv;
    Button addbtn, donebtn;
    String nama, menu, topping;
    int hargatotal;
    TextView ppntv, totaltv, bayartv;
    MenuAdapter menuAdapter;
    int reqOrder = 1;
    ArrayList<Menu> listMenu = new ArrayList<>();
    int total, ppn, bayar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        orderlv = findViewById(R.id.list_view_order);
        addbtn = findViewById(R.id.button_add);
        donebtn = findViewById(R.id.button_done);
        totaltv = findViewById(R.id.text_view_total);
        bayartv = findViewById(R.id.text_view_total_bayar);
        ppntv = findViewById(R.id.text_view_ppn);
        addbtn.setOnClickListener(this);
        donebtn.setOnClickListener(this);
        menuAdapter = new MenuAdapter(this, listMenu);

        orderlv.setAdapter(menuAdapter);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.button_add:
                Intent intent = new Intent(MainActivity.this, MenuActivity.class);
                startActivityForResult(intent, reqOrder);
                break;
            case R.id.button_done:
                AlertDialog.Builder alertDia = new AlertDialog.Builder(this);
                alertDia.setTitle("Confirmation").setCancelable(false).setMessage("Are you sure to finish order?").
                        setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent1 = new Intent(MainActivity.this, FinishActivity.class);
                                startActivity(intent1);
                            }
                        }).setNegativeButton("No", null).show();
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == reqOrder) {
            if (resultCode == Activity.RESULT_OK) {
                if (data.getExtras() != null) {

                    Bundle bundle = data.getExtras();
                    nama = bundle.getString(Constant.KEY_NAME);
                    menu = bundle.getString(Constant.KEY_MENU);
                    topping = bundle.getString(Constant.KEY_TOPPING);
                    hargatotal = bundle.getInt(Constant.KEY_HARGA);
                    Menu menu1 = new Menu(nama, menu, topping, hargatotal);

                    total += hargatotal;
                    ppn = total * 10 / 100;
                    bayar = total + ppn;
                    listMenu.add(menu1);
                    ppntv.setText(ppn + "");
                    totaltv.setText(total + "");
                    bayartv.setText("" + bayar);
                    menuAdapter.notifyDataSetChanged();
                }
            }
        }
    }
}
