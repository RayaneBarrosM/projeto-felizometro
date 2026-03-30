package br.gov.sp.cps.projeto4;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ActivityNormal extends AppCompatActivity {

    private Button btnVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_normal);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btnVoltar = findViewById(R.id.btnVoltar);
        btnVoltar.setOnClickListener(view ->{
            Intent intent = new Intent(this,MainActivity.class);
            startActivity(intent);

            finish();

        });

        Intent intent = getIntent(); //Pega o conteúdo do usuario

        String nome = intent.getStringExtra("NOME");
        double imc = intent.getDoubleExtra("IMC", 0.0);
        double peso = intent.getDoubleExtra("PESO", 0.0);
        double altura = intent.getDoubleExtra("ALTURA", 0.0);

        //Exibe no seu TextViews
        TextView tvResultado = findViewById(R.id.resultados);
        tvResultado.setText("Nome: " + nome + "\nPeso: " + peso + "kg" + "\nAltura: " + altura + "m" +"IMC calculado: " + String.format("%.2f", imc));


    }
}