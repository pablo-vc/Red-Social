package com.example.LikeEat.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.LikeEat.R;
import com.example.LikeEat.ui.home.MainActivity;

public class LogInActivity extends AppCompatActivity {

    Button btnLogin;
    TextView tvRegister, tvForgotPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_log_in);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        initUI();
        setUpListeners();
    }

    private void initUI() {
        btnLogin = findViewById(R.id.btnLogin);
        tvForgotPassword = findViewById(R.id.tvForgotPassword);
        tvRegister = findViewById(R.id.tvRegister);
    }

    private void setUpListeners() {
        btnLogin.setOnClickListener(v -> {
            Intent intent = new Intent(LogInActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        });
        tvRegister.setOnClickListener(v -> {
            startActivity(new Intent(LogInActivity.this, RegisterActivity.class));
        });
        tvForgotPassword.setOnClickListener(v -> {
            startActivity(new Intent(LogInActivity.this, ForgotPasswordActivity.class));
        });
    }

    private void logInManagement() {

    }
}