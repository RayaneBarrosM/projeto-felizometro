package br.gov.sp.cps.projeto4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Random;

public class ActivityMegaSena extends AppCompatActivity {

    private Button btnVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_mega_sena);
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
    }

    private TextView[] viewResultados; //Lista onde aparece os numeros

    public void sorteiaNumero(View view){
        //vincula o elemento textResultado(visualização) com o MainActivity:
        viewResultados = new TextView[] {
                findViewById(R.id.textResultado1),
                findViewById(R.id.textResultado2),
                findViewById(R.id.textResultado3),
                findViewById(R.id.textResultado4),
                findViewById(R.id.textResultado5),
                findViewById(R.id.textResultado6)
        };

        //lista que guarda os numeros
        ArrayList<Integer> nmSorteados = new ArrayList<>();
        Random random = new Random();

        //lógica de números aleatórios
        while (nmSorteados.size() == 6){
            int n = random.nextInt(60) + 1;

            if(!nmSorteados.contains(n)){ //Se não conter na lista
                nmSorteados.add(n);
            }
        }

        //Adiciona os numeros ao textView
        for (int i = 0; i < viewResultados.length; i++) {
            viewResultados[i].setText(String.valueOf(nmSorteados.get(i)));
        }
    }

    //Apagar numeros
    public void apagaNumeros(View view){
        for (int i = 0; i < viewResultados.length; i++) {
            viewResultados[i].setText("");
        }
    }
}