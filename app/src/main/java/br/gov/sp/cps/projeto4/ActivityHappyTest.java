package br.gov.sp.cps.projeto4;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.content.Intent;
import android.widget.RadioButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ActivityHappyTest extends AppCompatActivity {

    private CheckBox atv_estudando;
    private CheckBox atv_trabalhando;
    private CheckBox atv_folga;

    private RadioGroup radiogp_stress;
    private RadioButton stress_baixo;
    private RadioButton stress_medio;
    private RadioButton stress_alto;

    private RadioGroup radiogp_sono;
    private RadioButton sono_baixo;
    private RadioButton sono_medio;
    private RadioButton sono_alto;

    private Button btnVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_happytest);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        atv_estudando = findViewById(R.id.atv_estudando);
        atv_trabalhando = findViewById(R.id.atv_trabalhando);
        atv_folga = findViewById(R.id.atv_folga);

        radiogp_sono = findViewById(R.id.radiogp_sono);
        sono_baixo = findViewById(R.id.sono_baixo);
        sono_medio = findViewById(R.id.sono_medio);
        sono_alto = findViewById(R.id.sono_alto);

        radiogp_stress = findViewById(R.id.radiogp_stress);
        stress_baixo = findViewById(R.id.stress_baixo);
        stress_medio = findViewById(R.id.stress_medio);
        stress_alto = findViewById(R.id.stress_alto);

        findViewById(R.id.btn_calcular).setOnClickListener(v -> {
            Intent intent = calcularPontuacao();
            startActivity(intent);

        });

        btnVoltar = findViewById(R.id.btnVoltar);
        btnVoltar.setOnClickListener(view ->{
            Intent intent = new Intent(this,MainActivity.class);
            startActivity(intent);

            finish();

        });
    }

    private Intent calcularPontuacao() {

        int score = 0;

        if (atv_estudando.isChecked()) score += 10;
        if (atv_trabalhando.isChecked()) score += 10;
        if (atv_folga.isChecked()) score += 20;

        int idSono = radiogp_sono.getCheckedRadioButtonId();
        if (idSono == R.id.sono_baixo) score += 5;
        else if (idSono == R.id.sono_medio) score += 15;
        else if (idSono == R.id.sono_alto) score += 25;

        int idStress = radiogp_stress.getCheckedRadioButtonId();
        if (idStress == R.id.stress_baixo) score += 20;
        else if (idStress == R.id.stress_medio) score += 10;
        else if (idStress == R.id.stress_alto) score -= 10;

        Intent intent;

        if (score >= 50) {
            return new Intent(this, ActivityHappyTest_fine.class);
        } else if (score >= 30) {
            return new Intent(this, ActivityHappyTest_organize.class);
        } else {
            return new Intent(this, ActivityHappyTest_rest.class);
        }

    }
}