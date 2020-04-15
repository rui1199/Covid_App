package pt.ipg.dadospessoais;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_NOME = "NOME";
    public static final String EXTRA_IDADE = "IDADE";

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

        EditText editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        String email = editTextEmail.getText().toString();

        if (email.length() == 0) {
            editTextEmail.setError("Preencha o email.");
            editTextEmail.requestFocus();
            return;
        }

        EditText editTextIdade = (EditText) findViewById(R.id.editTextIdade);
        String strIdade = editTextIdade.getText().toString();

        int idade;
        try {
            idade = Integer.parseInt(strIdade);
        } catch (NumberFormatException e) {
            editTextIdade.setError("Idade invalida. Preencha a idade.");
            editTextIdade.requestFocus();
            return;
        }

        if (idade < 18) {
            editTextIdade.setError("A idade tem de ser maior ou igual que 18.");
            editTextIdade.requestFocus();
            return;
        }

        // Enviar a informação para outra atividade
        Intent intent = new Intent(this, MostraDadosActivity.class);

        intent.putExtra(EXTRA_NOME, nome);
        intent.putExtra(EXTRA_IDADE, idade);

        startActivity(intent);
    }
}
