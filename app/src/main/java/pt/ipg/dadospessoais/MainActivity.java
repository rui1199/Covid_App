package pt.ipg.dadospessoais;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void enviar(View view) {
        // Verificar se os dados estão corretos
        EditText editTextNome = (EditText) findViewById(R.id.editTextNome);
        String nome = editTextNome.getText().toString();

        if (nome.length() == 0) {
            editTextNome.setError("Preencha o nome.");
            editTextNome.requestFocus();
            return;
        }

        EditText editTextTelefone = (EditText) findViewById(R.id.editTextTelefone);
        String telefone = editTextTelefone.getText().toString();

        if (telefone.length() < 9) {
            editTextTelefone.setError("Telefone inválido. Preencha o telefone.");
            editTextTelefone.requestFocus();
            return;
        }

        // Enviar a informação para outra atividade
        Intent intent = new Intent(this, MostraDadosActivity.class);

        startActivity(intent);
    }
}
