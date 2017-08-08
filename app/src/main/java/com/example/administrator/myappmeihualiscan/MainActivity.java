package com.example.administrator.myappmeihualiscan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.zbar.lib.CaptureActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btn_sacn;
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
                startActivity(new Intent(getApplicationContext(), CaptureActivity.class));
                break;
        }
    }
}
