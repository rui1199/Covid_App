package pt.ipg.dadospessoais;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class MostraDadosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostra_dados);

        Intent intent = getIntent();

        String nome = intent.getStringExtra(MainActivity.EXTRA_NOME);
        int idade = intent.getIntExtra(MainActivity.EXTRA_IDADE, 18);

        Toast.makeText(this, nome + " (idade = " + idade + ")", Toast.LENGTH_LONG).show();
    }
}
