package com.example.ibraimkulov_hw1_m3__intent_textinputlayout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private Button btSent;
    private EditText etEmail,etSubject,etSms;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initListener();
    }
    private void initListener(){
        btSent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);

                emailIntent.setType("plain/text");
                //кому
                emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL,
                        new String[] { etEmail.getText().toString() });
                // зачем
                emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT,
                        etSubject.getText().toString());
                // о чём
                emailIntent.putExtra(android.content.Intent.EXTRA_TEXT,
                       etSms.getText().toString());

                MainActivity.this.startActivity(Intent.createChooser(emailIntent,
                        "Отправка письма..."));
            }
        });

    }
    private void initView(){
        btSent=findViewById(R.id.bt_sent);
        etEmail=findViewById(R.id.et_email);
        etSubject=findViewById(R.id.et_subject);
        etSms=findViewById(R.id.et_sms);

    }
}