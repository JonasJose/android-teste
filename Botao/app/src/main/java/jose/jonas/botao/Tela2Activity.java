package jose.jonas.botao;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Tela2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela2);
        Intent it = getIntent();
        Cliente cliente = it.getParcelableExtra("cliente");
        TextView texto = (TextView)findViewById(R.id.txtTexto);
        if (cliente == null)
        {
            String nome = it.getStringExtra("nome");
            int idade = it.getIntExtra("idade", 0);

            texto.setText(String.format("Nome %s / Idade: %d", nome, idade));
        }
        else
        {
            texto.setText(String.format("Nome %s / Idade: %d", cliente.nome, cliente.codigo));
        }
    }
}
