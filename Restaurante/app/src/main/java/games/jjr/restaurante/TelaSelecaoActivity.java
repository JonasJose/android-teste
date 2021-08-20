package games.jjr.restaurante;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Jonas on 26/04/2017.
 */

public class TelaSelecaoActivity extends ListActivity {

    public static final String EXTRA_RESTAURANTE = "restaurante";
    public static final String EXTRA_RESULTADO = "result";
    ArrayList<Restaurante> restaurantesSelecao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        restaurantesSelecao = getIntent().getParcelableArrayListExtra("lista");
        setListAdapter(new ArrayAdapter<Restaurante>(this, android.R.layout.simple_list_item_single_choice, restaurantesSelecao));
        String estado = getIntent().getStringExtra(EXTRA_RESTAURANTE);
        if(estado != null) {
            int position = Arrays.asList(restaurantesSelecao).indexOf(estado);
            getListView().setChoiceMode(AbsListView.CHOICE_MODE_SINGLE);
            getListView().setItemChecked(position, true);
        }
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        String result = l.getItemAtPosition(position).toString();
        Intent it = new Intent();
        it.putExtra(EXTRA_RESULTADO, result);
        setResult(RESULT_OK, it);
        finish();
    }
}
