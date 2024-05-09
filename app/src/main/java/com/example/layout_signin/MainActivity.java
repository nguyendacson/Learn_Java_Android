package com.example.layout_signin;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText textTaiKhoan,textMatKhau;
    Button buttonLogin,buttonSignup;
    TextView textmesses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
                        Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        textTaiKhoan = (EditText) findViewById(R.id.TaiKhoan);
        textMatKhau = (EditText) findViewById(R.id.MatKhau);
        buttonLogin = (Button) findViewById(R.id.Login);
        textmesses = (TextView) findViewById(R.id.messes);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(textTaiKhoan.getText().toString().equals("nguyendacson")&&
                textMatKhau.getText().toString().equals("1822003")){
                    textmesses.setVisibility(View.VISIBLE);
                    textmesses.setTextColor(Color.parseColor("#FF4500"));
                    textmesses.setText("DONE");
                }
                else {
                    textmesses.setVisibility(View.VISIBLE);
                    textmesses.setText("Fail");
                }
            }
        });

        textTaiKhoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!textmesses.getText().toString().isEmpty()){
                    textmesses.setText("");
                }
            }
        });

    }
}