package ru.samsung.itschool.mdev.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    private TextView tv;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        tv = findViewById(R.id.textView2);
        btn = findViewById(R.id.button3);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // передача данных из второй активности в первую
                Intent intent = new Intent();
                intent.putExtra("ppp",getResources().getString(R.string.str2));
                setResult(RESULT_OK,intent);
                finish(); // onDestroy
            }
        });


        Bundle bundle = getIntent().getExtras();
        if(bundle != null) {
            String value = bundle.getString("val");
            tv.setText(value);
        }
    }
}