package com.example.administrator.seventhwork;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText accountEdit;
    private EditText passwordEdit;

    private TextView toobarEdit;
    private TextView accountTxt;
    private TextView passwordTxt;
    private TextView poetF_introductionEdit;
    private TextView poetS_introductionEdit;

    private Button loginBtn;

    private String account = "123456";
    private String password = "000000";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUI();
    }

    private void initUI() {
        toobarEdit = findViewById(R.id.txt_toobar_login);
        toobarEdit.setTypeface(Typeface.createFromAsset(getAssets(),"font/hwxk.ttf"));

        accountTxt = findViewById(R.id.txt_account);
        accountTxt.setTypeface(Typeface.createFromAsset(getAssets(),"font/hwxk.ttf"));

        passwordTxt = findViewById(R.id.txt_password);
        passwordTxt.setTypeface(Typeface.createFromAsset(getAssets(),"font/hwxk.ttf"));

        accountEdit = findViewById(R.id.edit_account);
        accountEdit.setTypeface(Typeface.createFromAsset(getAssets(),"font/hwxk.ttf"));

        passwordEdit = findViewById(R.id.edit_password);
        passwordEdit.setTypeface(Typeface.createFromAsset(getAssets(),"font/hwxk.ttf"));

        poetF_introductionEdit = findViewById(R.id.txt_poet1);
        poetF_introductionEdit.setTypeface(Typeface.createFromAsset(getAssets(),"font/hwxk.ttf"));

        poetS_introductionEdit = findViewById(R.id.txt_poet2);
        poetS_introductionEdit.setTypeface(Typeface.createFromAsset(getAssets(),"font/hwxk.ttf"));

        loginBtn = findViewById(R.id.btn_login);
        loginBtn.setTypeface(Typeface.createFromAsset(getAssets(),"font/hwxk.ttf"));
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(accountEdit.getText().toString().equals(account) &&
                        passwordEdit.getText().toString().equals(password)){
                    Intent intent = new Intent(MainActivity.this,SendRequest.class);
                    startActivity(intent);
                }else {
                    Toast.makeText(MainActivity.this,"账号或者密码输入错误",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
