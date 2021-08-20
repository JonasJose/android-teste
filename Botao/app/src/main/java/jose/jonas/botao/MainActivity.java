package jose.jonas.botao;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText editText;
    Button botao;
    Button botao2;
    Button botao3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText)findViewById(R.id.editText);
        botao = (Button)findViewById(R.id.button);
        botao.setOnClickListener(this);
        botao2 = (Button)findViewById(R.id.button2);
        botao2.setOnClickListener(this);
        botao3 = (Button)findViewById(R.id.button3);
        botao3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                String texto = editText.getText().toString();
                Toast.makeText(this, texto, Toast.LENGTH_SHORT).show();
            break;
            case R.id.button2:
                Intent it = new Intent(this, Tela2Activity.class);
                it.putExtra("nome", "Jonas");
                it.putExtra("idade", 23);
                startActivity(it);
            break;
            case R.id.button3:
               Cliente cliente = new Cliente("Jonas José Rosa", 1);
                Intent it2 = new Intent(this, Tela2Activity.class);
                it2.putExtra("cliente", cliente);
                startActivity(it2);
            break;

    }
    }
}
