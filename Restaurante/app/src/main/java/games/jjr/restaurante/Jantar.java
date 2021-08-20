package games.jjr.restaurante;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Jantar extends AppCompatActivity implements View.OnClickListener {

    Button btnEscolherRestaurante;
    Button btnEndereco;
    TextView labRestaurante;
    TextView labEnredeco;
    public static final int REQUEST_RESTAURANTE = 1;
    public static final String STATE_RESTAURANTE = "restaurante";
    ArrayList<Restaurante> restaurantesSelecao;
    String restauranteSelecionado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jantar);

        Intent it = getIntent();
        restaurantesSelecao = it.getParcelableArrayListExtra("lista");

        btnEscolherRestaurante = (Button)findViewById(R.id.btnEscolherRestauranteJ);
        btnEscolherRestaurante.setOnClickListener(this);
        btnEndereco = (Button) findViewById(R.id.btnEnderecoJ);
        btnEndereco.setOnClickListener(this);
        labRestaurante = (TextView)findViewById(R.id.labRestauranteJ);
        labEnredeco = (TextView)findViewById(R.id.labEnderecoJ);

        if (savedInstanceState != null) {
            restauranteSelecionado = savedInstanceState.getString(STATE_RESTAURANTE);
            if(restauranteSelecionado != null) {
                labRestaurante.setText(restauranteSelecionado);
                labEnredeco.setText(restauranteSelecionado);
            }
        }
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnEscolherRestauranteJ:
                Intent itListagem = new Intent(this, TelaSelecaoActivity.class);
                itListagem.putParcelableArrayListExtra("lista", restaurantesSelecao);
                startActivityForResult(itListagem, REQUEST_RESTAURANTE);
                break;
            case R.id.btnEnderecoJ:
                if(restauranteSelecionado != null) {
                    int pos = restauranteSelecionado.indexOf(":");
                    Uri uri = Uri.parse("geo:0,0?q=" + restauranteSelecionado.substring(restauranteSelecionado.indexOf("\n") + 1, restauranteSelecionado.length()).replace(" ","+"));
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
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
                labRestaurante.setText("Restaurante: " + restauranteSelecionado.substring(0, pos - 5));
                labEnredeco.setText("Endereço: " + restauranteSelecionado.substring(restauranteSelecionado.indexOf("\n") + 1, restauranteSelecionado.length()));
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
