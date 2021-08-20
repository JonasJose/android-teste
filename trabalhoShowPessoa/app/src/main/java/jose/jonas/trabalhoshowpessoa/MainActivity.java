package jose.jonas.trabalhoshowpessoa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;
    Button btn5;
    Button btn6;
    ImageView imgView;

    Pessoa pess1;
    Pessoa pess2;
    Pessoa pess3;
    Pessoa pess4;
    Pessoa pess5;
    Pessoa pess6;

    public enum teste {Jonas, Aurea};
    public teste jonas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        jonas = teste.Jonas;


        imgView = (ImageView)findViewById(R.id.imageView);
        imgView.setBackgroundResource(R.drawable.family);
        pess1 = new Pessoa(1, "Jonas", "Jonas José Rosa", "Pai", 23, "Viçosa", R.drawable.eu);
        pess2 = new Pessoa(2, "Sofia", "Sofia Lopes Mendes Rosa", "Filha", 04, "Viçosa", R.drawable.filha);
        pess3 = new Pessoa(3, "Janaina", "Janaina Rosa Santos de Oliveira", "Irmã", 37, "Viçosa", R.drawable.irma);
        pess4 = new Pessoa(4, "Jorge", "Jorge Luiz Fernandes Rosa", "Irmão", 21, "Viçosa", R.drawable.irmao);
        pess5 = new Pessoa(5, "Sara", "Saraline Eduarda da Silva", "Namorada", 22, "Viçosa", R.drawable.namorada);
        pess6 = new Pessoa(6, "Bruno", "Bruno Lopes Gonsalves", "Amigo", 22, "Viçosa", R.drawable.amigo);

        btn1 = (Button)findViewById(R.id.btn1);
        btn1.setText(pess1.getNome());
        btn2 = (Button)findViewById(R.id.btn2);
        btn2.setText(pess2.getNome());
        btn3 = (Button)findViewById(R.id.btn3);
        btn3.setText(pess3.getNome());
        btn4 = (Button)findViewById(R.id.btn4);
        btn4.setText(pess4.getNome());
        btn5 = (Button)findViewById(R.id.btn5);
        btn5.setText(pess5.getNome());
        btn6 = (Button)findViewById(R.id.btn6);
        btn6.setText(pess6.getNome());
    }

    public void btnOnClick(View v){
        Intent it = new Intent(this, Main2Activity.class);

        switch (v.getId()) {
            case R.id.btn1:
                it.putExtra("pess", pess1);
                startActivity(it);
                break;
            case R.id.btn2:
                it.putExtra("pess", pess2);
                startActivity(it);
                break;
            case R.id.btn3:
                it.putExtra("pess", pess3);
                startActivity(it);
                break;
            case R.id.btn4:
                it.putExtra("pess", pess4);
                startActivity(it);
                break;
            case R.id.btn5:
                it.putExtra("pess", pess5);
                startActivity(it);
                break;
            case R.id.btn6:
                it.putExtra("pess", pess6);
                startActivity(it);
                break;
        }
    }
}
