package ru.samsung.itschool.mdev.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btn1, btn2;
    private EditText ed;
    public static int CODE_RESULT = 312;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = findViewById(R.id.button);

        btn2 = findViewById(R.id.button2);
        ed = findViewById(R.id.editText);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.button) {
            // переходим на вторую активность
            Intent intent = new Intent(this,MainActivity2.class);
            intent.putExtra("val",ed.getText().toString());
            //startActivity(intent);
            startActivityForResult(intent,CODE_RESULT);
        } else {
            // браузер
            String url = "https://letovo.ru";
            // Неявное намерение
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(url));
            startActivity(intent);
        }
    }

    // ожидаем результата из второй активности
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == CODE_RESULT) {
            if(resultCode == RESULT_OK) {
                Snackbar.make(findViewById(R.id.root),data.getStringExtra("ppp"),Snackbar.LENGTH_LONG).show();
            }
        }
    }
}