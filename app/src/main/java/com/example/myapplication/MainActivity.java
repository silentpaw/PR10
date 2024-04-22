package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText edit_name_user=findViewById(R.id.editname);
        TextView content=findViewById(R.id.prefs_content);
        Button record_btn=findViewById(R.id.record_btn);
        Button view_btn=findViewById(R.id.look_btn);
        Button del_btn=findViewById(R.id.del_btn);
        Button edit_btn=findViewById(R.id.edit_btn);
        SharedPreferences sharedPreferences;
        record_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences =
                        getSharedPreferences("myPreferences", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                String newname =edit_name_user.getText().toString();
                // Сохранение строкового значения
                editor.putString("username", newname);
                // Сохранение изменений
                editor.apply();
            }
        });
        view_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences =
                        getSharedPreferences("myPreferences", MODE_PRIVATE);
                // Чтение строкового значения
                String username = sharedPreferences.getString("username",
                        "nothing");
                content.setText(username);

            }
        });
        del_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences =
                        getSharedPreferences("myPreferences", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.clear();
                editor.apply();

            }
        });
        edit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences =
                        getSharedPreferences("myPreferences", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                String newnameuser =edit_name_user.getText().toString();
                // Сохранение строкового значения
                editor.putString("username", newnameuser);
                // Сохранение изменений
                editor.apply();


            }
        });

    }

}
