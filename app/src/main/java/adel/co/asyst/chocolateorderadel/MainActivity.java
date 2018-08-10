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

import adel.co.asyst.chocolateorderadel.model.Menu;
import adel.co.asyst.chocolateorderadel.utility.Constant;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ListView orderlv;
    Button addbtn, donebtn;
    TextView totaltv, nametv;
    String nama;
    int reqOrder = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        orderlv = findViewById(R.id.list_view_order);
        addbtn = findViewById(R.id.button_add);
        donebtn = findViewById(R.id.button_done);
        totaltv = findViewById(R.id.text_view_total);
        nametv = findViewById(R.id.text_view_name);

        addbtn.setOnClickListener(this);
        donebtn.setOnClickListener(this);
        if (getIntent().getExtras() != null) {
            nama = getIntent().getExtras().getString(Constant.KEY_NAME);
            nametv.setText(nama);
        }
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
                Menu menu = data.getExtras().getParcelable("menu");
            }
        }
    }
}
