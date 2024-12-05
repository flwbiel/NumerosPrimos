package br.fatec.gov.numerosprimos;

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

    private EditText etNumero;
    private Button btnCalc;
    private TextView tvRes;

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

        etNumero = findViewById(R.id.etNumero);
        etNumero.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        btnCalc = findViewById(R.id.btnCalc);
        tvRes = findViewById(R.id.tvRes);
        tvRes.setTextAlignment(TextView.TEXT_ALIGNMENT_CENTER);
        btnCalc.setOnClickListener(op -> Calcular());

    }




        public void Calcular(){
            int etNum = Integer.parseInt(etNumero.getText().toString());
            if (etNum <= 100 && etNum >= 1){
                StringBuilder numerosPrimos = new StringBuilder();
                for (int i = 2; i <= etNum; i++) {
                    if (isPrime(i)) {
                        numerosPrimos.append(i).append(" ");
                    }
                }

                tvRes.setText("Numeros Primos: " + numerosPrimos.toString());

            }else{
                String aviso = getString(R.string.aviso);
                tvRes.setText(aviso);
            }
        }
        private boolean isPrime(int etNum) {
            if (etNum <= 1) {
                return false;
            }
            for (int i = 2; i <= Math.sqrt(etNum); i++) {
                if (etNum % i == 0) {
                    return false;
                }}
            return true;
        }
}