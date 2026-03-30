package br.gov.sp.cps.projeto4;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ActivityIMC extends AppCompatActivity {

    private Button btnCalcular;
    private Button btnLimpar;

    private EditText cmpNome;
    private EditText cmpPeso;
    private EditText cmpAltura;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_imc);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btnCalcular = findViewById(R.id.btnCalcular);
        cmpPeso = findViewById(R.id.peso);
        cmpAltura = findViewById(R.id.altura);

        btnCalcular.setOnClickListener(view -> {
            // Pegamos o texto, convertemos para String e depois para double
            String nome = cmpNome.getText().toString();
            double peso = Double.parseDouble(cmpPeso.getText().toString());
            double altura = Double.parseDouble(cmpAltura.getText().toString());

            double imc = calculaIMC(peso, altura);

            Intent intent;

            if (imc < 18.5) {
                intent = new Intent(this, ActivityCorpulent.class);

            } else if (imc >= 18.5 && imc < 24.99) {
                intent = new Intent(this, ActivityNormal.class);

            } else {
                intent = new Intent(this, ActivityThin.class);

            }

            intent.putExtra("NOME_USUARIO", nome);
            intent.putExtra("PESO_VALOR", peso);
            intent.putExtra("ALTURA_VALOR", altura);
            intent.putExtra("IMC_VALOR", imc);

            startActivity(intent);

        });

        btnLimpar = findViewById(R.id.btnLimpar);

        btnLimpar.setOnClickListener(view ->{
            cmpNome.setText("");
            cmpPeso.setText("");
            cmpAltura.setText("");

        });
    }

    public double calculaIMC(double peso, double altura){
        return peso / (altura * altura);
    }
}