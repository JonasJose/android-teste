package jose.jonas.exercicio01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class telaContato extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_contato);

        Intent it = getIntent();
        Contato contato = (Contato)it.getParcelableExtra("contato");
        TextView labAtcEmail = (TextView)findViewById(R.id.labAtcEmail);
        TextView labAtcTelefone = (TextView)findViewById(R.id.labAtcTelefone);

        if (contato == null)
        {
            labAtcEmail.setText("NULL");
            labAtcTelefone.setText("NULL");
        }
        else
        {
            labAtcEmail.setText(contato.email);
            labAtcTelefone.setText(contato.telefone);
        }
    }
}
