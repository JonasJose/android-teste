package jose.jonas.exercicio01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText txtAmEmail;
    EditText txtAmTelefone;
    Button btnConfirmar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtAmEmail = (EditText)findViewById(R.id.txtAmEmail);
        txtAmTelefone = (EditText)findViewById(R.id.txtAmTelefone);
        btnConfirmar = (Button)findViewById(R.id.btnConfirmar);
        btnConfirmar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnConfirmar:
                Contato contato = new Contato(1, txtAmEmail.getText().toString(), txtAmTelefone.getText().toString());
                Intent it = new Intent(this, telaContato.class);
                it.putExtra("contato", contato);
                startActivity(it);
                break;
        }
    }
}
