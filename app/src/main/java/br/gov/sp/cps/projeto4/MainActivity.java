package br.gov.sp.cps.projeto4;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.content.Intent;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnMegaSena;
    private Button btnHappyTest;
    private Button btnJokenPo;
    private Button btnImc;



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



        btnMegaSena = findViewById(R.id.btnMegaSena);
        btnHappyTest = findViewById(R.id.btnHappyTest);
        btnJokenPo = findViewById(R.id.btnJokenPo);
        btnImc = findViewById(R.id.btnImc);

        btnImc.setOnClickListener(view -> {
            Intent intent = new Intent(this, ActivityIMC.class);
            startActivity(intent);
        });

        btnHappyTest.setOnClickListener(view -> {
            Intent intent = new Intent(this, ActivityHappyTest.class);
            startActivity(intent);
        });

        btnJokenPo.setOnClickListener(view -> {
            Intent intent = new Intent(this, ActivityJokenPo.class);
            startActivity(intent);
        });

        btnMegaSena.setOnClickListener(view -> {
            Intent intent = new Intent(this, ActivityMegaSena.class);
            startActivity(intent);
        });


    }
}