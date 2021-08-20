package jose.jonas.activityresult;

import android.content.Intent;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static final int REQUEST_ESTADO = 1;
    public static final String STATE_ESTADO = "estados";
    Button botaoEstado;
    String estados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botaoEstado = (Button)findViewById(R.id.btnState);
        botaoEstado.setOnClickListener(this);

        if (savedInstanceState != null) {
            estados = savedInstanceState.getString(STATE_ESTADO);
            if(estados != null) {
                botaoEstado.setText(estados);
            }
        }
    }

    @Override
    public void onClick(View v) {
        Intent it = new Intent(this, TelaSelecaoActivity.class);
        it.putExtra(TelaSelecaoActivity.EXTRA_ESTADO, estados);
        startActivityForResult(it, REQUEST_ESTADO);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == RESULT_OK && requestCode == REQUEST_ESTADO) {
            estados = data.getStringExtra(TelaSelecaoActivity.EXTRA_RESULTADO);
            if(estados != null) {
                botaoEstado.setText(estados);
            }
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(STATE_ESTADO, estados);
    }
}
