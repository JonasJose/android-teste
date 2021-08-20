package games.jjr.restaurante;

import android.content.Intent;
import android.net.Uri;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Pedir extends AppCompatActivity implements View.OnClickListener {

    Button btnEscolherRestaurante;
    Button btnLigar;
    TextView labRestaurante;
    TextView labTel;
    public static final int REQUEST_RESTAURANTE = 1;
    public static final String STATE_RESTAURANTE = "restaurante";
    ArrayList<Restaurante> restaurantesSelecao;
    String restauranteSelecionado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedir);
        Intent it = getIntent();
        restaurantesSelecao = it.getParcelableArrayListExtra("lista");

        btnEscolherRestaurante = (Button)findViewById(R.id.btnEscolherRestaurante);
        btnEscolherRestaurante.setOnClickListener(this);
        btnLigar = (Button) findViewById(R.id.btnLigar);
        btnLigar.setOnClickListener(this);
        labRestaurante = (TextView)findViewById(R.id.labRestaurante);
        labTel = (TextView)findViewById(R.id.labTel);

        if (savedInstanceState != null) {
            restauranteSelecionado = savedInstanceState.getString(STATE_RESTAURANTE);
            if(restauranteSelecionado != null) {
                labRestaurante.setText(restauranteSelecionado);
                labTel.setText(restauranteSelecionado);
            }
        }
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnEscolherRestaurante:
                Intent itListagem = new Intent(this, TelaSelecaoActivity.class);
                itListagem.putParcelableArrayListExtra("lista", restaurantesSelecao);
                startActivityForResult(itListagem, REQUEST_RESTAURANTE);
                break;
            case R.id.btnLigar:
                if(restauranteSelecionado != null) {
                    int pos = restauranteSelecionado.indexOf(":");
                    Uri uri = Uri.parse("tel:" + restauranteSelecionado.substring(pos + 2, restauranteSelecionado.indexOf("\n")));
                    Intent intent = new Intent(Intent.ACTION_DIAL, uri);
                    dispararIntent(intent);
                }
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == RESULT_OK && requestCode == REQUEST_RESTAURANTE) {
            restauranteSelecionado = data.getStringExtra(TelaSelecaoActivity.EXTRA_RESULTADO);
            if(restauranteSelecionado != null) {
                int pos = restauranteSelecionado.indexOf(":");
                labRestaurante.setText(restauranteSelecionado.substring(0, pos - 5));
                labTel.setText(restauranteSelecionado.substring(pos + 2, restauranteSelecionado.indexOf("\n")));
            }
        }
    }

    private void dispararIntent(Intent intent) {
        if(intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Toast.makeText(this, R.string.erro, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(STATE_RESTAURANTE, restauranteSelecionado);
    }
}
