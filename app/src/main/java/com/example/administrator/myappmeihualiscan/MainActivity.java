package com.example.administrator.myappmeihualiscan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.zbar.lib.CaptureActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btn_sacn;
    public static final int resultcode = 101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        intView();
    }

    private void intView() {
        btn_sacn = findViewById(R.id.btn_sacn);
        btn_sacn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_sacn:
                Intent intent = new Intent(getApplicationContext(), CaptureActivity.class);
                startActivityForResult(intent,resultcode);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data != null) {
            String result = data.getStringExtra("result");
            Toast.makeText(getApplicationContext(),"测试结果 "+result ,Toast.LENGTH_SHORT).show();
        }
    }
}
