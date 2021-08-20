package games.jjr.restaurante;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnJantar;
    Button btnPedir;
    ArrayList<Restaurante> restaurantes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnJantar = (Button)findViewById(R.id.btnJantar);
        btnJantar.setOnClickListener(this);
        btnPedir = (Button)findViewById(R.id.btnPedir);
        btnPedir.setOnClickListener(this);

        restaurantes = new ArrayList<Restaurante>();
        restaurantes.add(new Restaurante (1,"Sabor & CIA", "(31) 3899-8500", "Calçadão, Viçosa"));
        restaurantes.add(new Restaurante (2,"Saladele", "(31) 3899-8500", "Centro, Viçosa"));
        restaurantes.add(new Restaurante (3,"Boca Viçosa", "(31) 3891-5889", "Av. P H Rolfs 138, Viçosa"));
        restaurantes.add(new Restaurante (5,"CIA da Carne", "(31) 3899-8501", "Calçadão, Viçosa"));
        restaurantes.add(new Restaurante (6,"Restautante 1", "(31) 3899-8502", "Centro, Viçosa"));
        restaurantes.add(new Restaurante (7,"Restautante 2", "(31) 3891-5889", "Av. P H Rolfs 138, Viçosa"));
        restaurantes.add(new Restaurante (8,"Restautante 3", "(31) 3899-8503", "Calçadão, Viçosa"));
        restaurantes.add(new Restaurante (9,"Restautante 4", "(31) 3899-8504", "Centro, Viçosa"));
        restaurantes.add(new Restaurante (10,"Restautante 6", "(31) 3891-5889", "Av. P H Rolfs 138, Viçosa"));
        restaurantes.add(new Restaurante (11,"Restautante 7", "(31) 3899-8505", "Calçadão, Viçosa"));
        restaurantes.add(new Restaurante (12,"Restautante 8", "(31) 3899-8506", "Centro, Viçosa"));
        restaurantes.add(new Restaurante (13,"Restautante 9", "(31) 3891-5889", "Av. P H Rolfs 138, Viçosa"));
        restaurantes.add(new Restaurante (14,"Restautante 10", "(31) 3899-8507", "Calçadão, Viçosa"));
        restaurantes.add(new Restaurante (15,"Restautante 11", "(31) 3899-8508", "Centro, Viçosa"));
        restaurantes.add(new Restaurante (16,"Restautante 12", "(31) 3891-5889", "Av. P H Rolfs 138, Viçosa"));
    }

    @Override
    public void onClick(View v) {
        Intent itJantar = new Intent(this, Jantar.class);
        Intent itPedir = new Intent(this, Pedir.class);

        switch (v.getId()) {
            case R.id.btnJantar:
                itPedir.putParcelableArrayListExtra("lista", restaurantes);
                startActivity(itPedir);
                break;
            case R.id.btnPedir:
                itJantar.putParcelableArrayListExtra("lista", restaurantes);
                startActivity(itJantar);
                break;
        }
    }
}
