package com.example.testsql;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText edt1,edt2,edt3;
    private Button btn1,btn2;
    TextView txt_lichsu;
    String lichsu ="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edt1 = (EditText) findViewById(R.id.edt1);
        edt2 = (EditText) findViewById(R.id.edt2);
        edt3 =(EditText) findViewById(R.id.edt3);
        btn1 = (Button) findViewById(R.id.btntong);
        btn2 = (Button) findViewById(R.id.btnclearn);
        txt_lichsu = (TextView) findViewById(R.id.txt_lichsu);
        //đọc lại dữ liệu dã lưu reonf sharePreferences
        SharedPreferences mypref = getSharedPreferences("mysave",MODE_PRIVATE);
        lichsu = mypref.getString("ls", "");
        txt_lichsu.setText(lichsu);
        //xử lý click
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt(edt1.getText().toString());
                int b = Integer.parseInt(edt2.getText().toString());
                int  c = a + b;
                edt3.setText('c');
                lichsu += a +" + " + b + " = " + c;
                txt_lichsu.setText(lichsu);
                lichsu += "\n";
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lichsu = "";
                txt_lichsu.setText(lichsu);
            }
        });
    }
    //gọi hàm onPase() để lưu tru dl
    @Override
    protected void onPause() {
        super.onPause();
        //4 bước để tạo ra 1 đối tượng
        //1.tạo ra lớp SharedPreferences
        SharedPreferences mypref = getSharedPreferences("mysave",MODE_PRIVATE);
        //để sửa
        SharedPreferences.Editor myedit= mypref.edit();
        String lichsu = null;
        myedit.putString("ls", lichsu);
        //comit du lieu
        myedit.commit();
    }
}