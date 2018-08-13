package adel.co.asyst.chocolateorderadel;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;

import adel.co.asyst.chocolateorderadel.utility.Constant;

public class MenuActivity extends AppCompatActivity implements View.OnClickListener, RadioGroup.OnCheckedChangeListener, CompoundButton.OnCheckedChangeListener {

    RadioGroup chocoRG;
    RadioButton milkRB, bananaRB, oriRB;
    CheckBox oreocb, milocb, crunchcb;
    Button tambahbtn;
    String selectedMenu, name, order, topping;
    EditText nameET;
    int hargaMenu = 0, hargaTopping = 0, hargaTotal = 0;
    ArrayList<String> listTopping = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        nameET = findViewById(R.id.edit_text_name);
        chocoRG = findViewById(R.id.radio_group_menu);
        milkRB = findViewById(R.id.radio_button_milk);
        bananaRB = findViewById(R.id.radio_button_banana);
        oriRB = findViewById(R.id.radio_button_ori);
        oreocb = findViewById(R.id.checkbox_oreo);
        milocb = findViewById(R.id.checkbox_milo);
        crunchcb = findViewById(R.id.checkbox_crunch);

        tambahbtn = findViewById(R.id.button_tambah);
        tambahbtn.setOnClickListener(this);
        chocoRG.setOnCheckedChangeListener(this);
        crunchcb.setOnCheckedChangeListener(this);
        milocb.setOnCheckedChangeListener(this);
        oreocb.setOnCheckedChangeListener(this);



    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.button_tambah:
                name = nameET.getText().toString();
                if (TextUtils.isEmpty(name)) {
                    nameET.setError("Nama tidak boleh kosong");

                } else {
                    hargaTotal = hargaMenu + hargaTopping;
                    topping = "";
                    for (int i = 0; i < listTopping.size(); i++) {
                        topping = topping + " " + listTopping.get(i);
                    }
                    AlertDialog.Builder alertDia = new AlertDialog.Builder(this);
                    alertDia.setTitle("Confirmation").setCancelable(false).setMessage("Are you sure?").
                            setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Intent intent = getIntent();
                                    intent.putExtra(Constant.KEY_NAME, name);
                                    intent.putExtra(Constant.KEY_MENU, selectedMenu);
                                    intent.putExtra(Constant.KEY_TOPPING, topping);
                                    intent.putExtra(Constant.KEY_HARGA, hargaTotal);
                                    setResult(Activity.RESULT_OK, intent);
                                    finish();
                                }
                            }).setNegativeButton("No", null).show();

                    break;
                }
        }
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.radio_button_ori:
                selectedMenu = "Choco Original";
                hargaMenu = 15000;
                break;
            case R.id.radio_button_milk:
                selectedMenu = "Choco Milk";
                hargaMenu = 16000;
                break;
            case R.id.radio_button_banana:
                selectedMenu = "Choco Banana";
                hargaMenu = 17000;
                break;
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        int id = buttonView.getId();
        switch (id) {
            case R.id.checkbox_crunch:
                if (isChecked) {
                    listTopping.add("Crunch ");
                    hargaTopping += 2000;
                } else {
                    listTopping.remove("Crunch ");
                }
                break;
            case R.id.checkbox_milo:
                if (isChecked) {
                    listTopping.add("Milo ");
                    hargaTopping += 2000;
                } else {
                    listTopping.remove("Milo ");
                }
                break;
            case R.id.checkbox_oreo:
                if (isChecked) {
                    listTopping.add("Oreo ");
                    hargaTopping += 2000;
                } else {
                    listTopping.remove("Oreo ");
                }
                break;
        }
    }
}
