package br.gov.sp.cps.projeto4;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.RadioGroup;

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

        CheckBox chkEstudei = findViewById(R.id.atv_estudando);
        CheckBox chkTrabalhei = findViewById(R.id.atv_trabalhando);
        CheckBox chkFolguei = findViewById(R.id.atv_folga);

        RadioButton rbSonoBaixo = findViewById(R.id.sono_baixo);
        RadioButton rbSonoMedio = findViewById(R.id.sono_medio);
        RadioButton rbSonoAlto = findViewById(R.id.sono_alto);

        RadioButton rbStressBaixo = findViewById(R.id.stress_baixo);
        RadioButton rbStressMedio = findViewById(R.id.stress_medio);
        RadioButton rbStressAlto = findViewById(R.id.stress_alto);

        if (chkEstudei.isChecked()) score += 10;
        if (chkTrabalhei.isChecked()) score += 10;
        if (chkFolguei.isChecked()) score += 20;

        int idSono = rgSono.getCheckedRadioButtonId();
        if (idSono == R.id.sono_baixo) score += 5;
        else if (idSono == R.id.sono_medio) score += 15;
        else if (idSono == R.id.sono_alto) score += 25;

        int idStress = rgStress.getCheckedRadioButtonId();
        if (idStress == R.id.stress_baixo) score += 20;
        else if (idStress == R.id.stress_medio) score += 10;
        else if (idStress == R.id.stress_alto) score -= 10;

        Intent intent;

        if (score >= 50) {
            intent = new Intent(this, ActivityHappyTest_fine.class);
        } else if (score >= 30) {
            intent = new Intent(this, ActivityHappyTest_organize.class);
        } else {
            intent = new Intent(this, ActivityHappyTest_rest.class);
        }

        startActivity(intent);
    }
}