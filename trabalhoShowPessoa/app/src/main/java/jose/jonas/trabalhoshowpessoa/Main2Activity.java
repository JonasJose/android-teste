package jose.jonas.trabalhoshowpessoa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent it = getIntent();
        Pessoa pess = (Pessoa)it.getParcelableExtra("pess");

        TextView txtNome = (TextView)findViewById(R.id.txtNome);
        TextView txtParente = (TextView)findViewById(R.id.txtParente);
        TextView txtIdade = (TextView)findViewById(R.id.txtIdade);
        TextView txtCidade = (TextView)findViewById(R.id.txtCidade);
        ImageView imgView = (ImageView)findViewById(R.id.imageView2);

        if (pess != null)
        {
            txtNome.setText(pess.getNomeCompleto());
            txtParente.setText(pess.getParente());
            txtIdade.setText(Integer.toString(pess.getIdade()) + " Anos");
            txtCidade.setText(pess.getCidade());
            imgView.setBackgroundResource(pess.getFoto());
        }
    }
}
