package com.example.activityresultlauncher12052022;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity2 extends AppCompatActivity {

    Button mBtnButton2;
    EditText mEdtText2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        init();

        //NHAN DU LIEU TU MAIN
        String receiveFromMain=getIntent().getStringExtra("sendText");
        mEdtText2.setText(receiveFromMain);

        mBtnButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String senTextFromMain2=mEdtText2.getText().toString().trim();
                sendTextFromMain2(senTextFromMain2);
            }
        });


    }

    private void sendTextFromMain2(String senTextFromMain2) {
        Intent intent=new Intent(this,MainActivity2.class);
        intent.putExtra("sendTextFromMain2",senTextFromMain2);
        setResult(RESULT_OK,intent);
        finish();
    }


    private void init()
    {
        mBtnButton2=findViewById(R.id.btnButton2);
        mEdtText2=findViewById(R.id.edtText2);
    }
}