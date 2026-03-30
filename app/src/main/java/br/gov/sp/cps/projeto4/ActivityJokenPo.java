package br.gov.sp.cps.projeto4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class ActivityJokenPo extends AppCompatActivity {

    private Button btnVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_jokenpo);
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

    public void selectPedra(View views){
        this.opcaoSelecionada("pedra");
    }

    public void selectPapel(View views){
        this.opcaoSelecionada("papel");
    }

    public void selectTesoura(View views){
        this.opcaoSelecionada("tesoura");
    }

    //Placar
    private int pontosUsuario = 0;
    private int pontosPC = 0;

    public void opcaoSelecionada(String opcaoSelecionada) {
        ImageView imgresultado = findViewById(R.id.padrao);



        TextView textResultado = findViewById(R.id.textResultado);
        TextView textPlacar = findViewById(R.id.pontuacao);

        //Lógica
        int numero = new Random().nextInt(3);
        String[] opcoes = {"pedra", "papel", "tesoura"};
        String opcaoPC = opcoes[numero];


        //Muda a figura
        switch (opcaoPC) {
            case "pedra":
                imgresultado.setImageResource(R.drawable.pedra);
                break;
            case "papel":
                imgresultado.setImageResource(R.drawable.papel);
                break;
            case "tesoura":
                imgresultado.setImageResource(R.drawable.tesoura);
                break;
        }

        //Logica do Jogo - analise de quem ganhou ou perdeu
        if (
                (opcaoPC == "Tesoura" && opcaoSelecionada == "papel") ||
                        (opcaoPC == "papel" && opcaoSelecionada == "pedra") ||
                        (opcaoPC == "pedra" && opcaoSelecionada == "tesoura")
        ) {
            pontosPC++;

        } else if (
                (opcaoSelecionada == "Tesoura" && opcaoPC == "papel") ||
                        (opcaoSelecionada == "papel" && opcaoPC == "pedra") ||
                        (opcaoSelecionada == "pedra" && opcaoPC == "tesoura")
        ) {
            pontosUsuario++;
        } else {
            textResultado.setText("Houve um empate!👯‍♂️️");
        }

        //Placar Atualiza
        textPlacar.setText("VOCÊ: " + pontosUsuario + " | PC: " + pontosPC);

        if (pontosUsuario == 5) {
            textResultado.setText("Parabéns, você ganhou!🏆");
        } else if (pontosPC == 5) {
            textResultado.setText("Você é ruim! 💀");
        }
    }

    public void recomecarJogo(View view) {
        pontosUsuario = 0;
        pontosPC = 0;

        TextView textResultado = findViewById(R.id.textResultado);
        TextView textPlacar = findViewById(R.id.pontuacao);
        ImageView imgResultado = findViewById(R.id.padrao);

        textResultado.setText("Escolha a sua opção");
        textPlacar.setText("VOCÊ: 0 | PC: 0");
        imgResultado.setImageResource(R.drawable.padrao);
    }
}