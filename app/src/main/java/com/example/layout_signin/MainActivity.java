package com.example.layout_signin;

import static com.example.layout_signin.R.*;

import android.annotation.SuppressLint;
import android.app.slice.SliceItem;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText textTaiKhoan,textMatKhau;
    Button buttonLogin,buttonSignup;
    TextView forgotpassswork,textor;
    ProgressBar Barleft,Barright;
    ImageButton showPasswork;
    boolean isPasswordVisible = false;
    private void mapping(){
        textTaiKhoan = (EditText) findViewById(R.id.TaiKhoan);
        textMatKhau = (EditText) findViewById(R.id.MatKhau);
        buttonLogin = (Button) findViewById(R.id.Login);
        buttonSignup = (Button)findViewById(R.id.Signup);
        textor = (TextView) findViewById(R.id.textViewor);
        showPasswork = (ImageButton) findViewById(R.id.buttonShowPasswork);
        forgotpassswork = (TextView) findViewById(R.id.forgotPaswork);
        Barleft = (ProgressBar) findViewById(R.id.progressBarleft);
        Barright = (ProgressBar) findViewById(R.id.progressBarright);
    }
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

        mapping();


        buttonLogin.setOnClickListener(view -> {
            if(textTaiKhoan.getText().toString().equals("nguyendacson")&&
            textMatKhau.getText().toString().equals("1822003")){

                forgotpassswork.setVisibility(View.INVISIBLE);
                Barleft.setVisibility(View.INVISIBLE);
                Barright.setVisibility(View.INVISIBLE);
                textor.setVisibility(View.INVISIBLE);
                String noiDung = "Done";
                Toast.makeText(MainActivity.this,noiDung,Toast.LENGTH_LONG).show();

                Intent intent = new Intent(MainActivity.this,Sign_up.class);
                startActivity(intent);
            }
            else {
                String noiDung = "Fail";
                Toast.makeText(MainActivity.this,noiDung,Toast.LENGTH_LONG).show();
            }
        });

        buttonSignup.setOnClickListener(v -> {
            Intent myIntent = new Intent(MainActivity.this, Sign_up.class);
            startActivity(myIntent);
        });

        showPasswork.setOnClickListener(v -> {
            if (isPasswordVisible) {
                textMatKhau.setTransformationMethod(PasswordTransformationMethod.getInstance());
                showPasswork.setImageResource(drawable.not_eye);
                isPasswordVisible = false;
            } else {
                textMatKhau.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                showPasswork.setImageResource(drawable.eye);
                isPasswordVisible = true;
            }
            textMatKhau.setSelection(textMatKhau.getText().length());
        });
    }
}


