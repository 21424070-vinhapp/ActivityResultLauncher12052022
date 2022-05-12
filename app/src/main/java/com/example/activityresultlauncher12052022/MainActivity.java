package com.example.activityresultlauncher12052022;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button mBtnButton;
    EditText mEdtText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        mBtnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               String getTextFromMain=mEdtText.getText().toString().trim();
               sendToMain2(getTextFromMain);
            }
        });
    }

    private void sendToMain2(String getTextFromMain) {
        Intent intent=new Intent(this,MainActivity2.class);
        intent.putExtra("sendText",getTextFromMain);
        activityResultLauncher.launch(intent);
    }

    private ActivityResultLauncher<Intent> activityResultLauncher=registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if(result.getResultCode()==RESULT_OK)
                    {
                        Intent intent=result.getData();
                        String getStrfromMain2=intent.getStringExtra("sendTextFromMain2");
                        mEdtText.setText(getStrfromMain2);
                    }
                }
            }
    );

    private void init() {
        mBtnButton = findViewById(R.id.btnButton);
        mEdtText = findViewById(R.id.edtText);
    }


}