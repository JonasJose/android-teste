package games.jjr.velha;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;

import static java.lang.System.in;

public class MainActivity extends AppCompatActivity {
    Button btn01;
    Button btn02;
    Button btn03;
    Button btn04;
    Button btn05;
    Button btn06;
    Button btn07;
    Button btn08;
    Button btn09;

    TextView labVelha;
    TextView labComputador;
    TextView labJogador;

    int player = 0;
    int[] board = { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
    int turn = 0;
    boolean continuar = false;

    int Jogador = 0;
    int Computador = 0;
    int Velha = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn01 = (Button) findViewById(R.id.btn01);
        btn02 = (Button) findViewById(R.id.btn02);
        btn03 = (Button) findViewById(R.id.btn03);
        btn04 = (Button) findViewById(R.id.btn04);
        btn05 = (Button) findViewById(R.id.btn05);
        btn06 = (Button) findViewById(R.id.btn06);
        btn07 = (Button) findViewById(R.id.btn07);
        btn08 = (Button) findViewById(R.id.btn08);
        btn09 = (Button) findViewById(R.id.btn09);

        labVelha = (TextView) findViewById(R.id.labVelha);
        labComputador = (TextView) findViewById(R.id.labComputador);
        labJogador = (TextView) findViewById(R.id.labJogador);

        gerenciaBotao(false);
    }

    public void  btnOnNovoJogo(View v){
        player = 0;
        board = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
        turn = 0;
        continuar = false;
        QuestionBox();
    }

    public void btnOnClick(View v) {
        continuar = true;
        int valor = -1;
        switch (v.getId()) {
            case R.id.btn01:
                valor = 0;
                btn01.setEnabled(false);
                break;
            case R.id.btn02:
                valor = 1;
                btn02.setEnabled(false);
                break;
            case R.id.btn03:
                valor = 2;
                btn03.setEnabled(false);
                break;
            case R.id.btn04:
                valor = 3;
                btn04.setEnabled(false);
                break;
            case R.id.btn05:
                valor = 4;
                btn05.setEnabled(false);
                break;
            case R.id.btn06:
                valor = 5;
                btn06.setEnabled(false);
                break;
            case R.id.btn07:
                valor = 6;
                btn07.setEnabled(false);
                break;
            case R.id.btn08:
                valor = 7;
                btn08.setEnabled(false);
                break;
            case R.id.btn09:
                valor = 8;
                btn09.setEnabled(false);
                break;
        }

        JogadaDoUsuario(board, valor);
        InicioPartida();
    }



    void Imprimir(int[] Jogo)
    {
        btn01.setText(RetonarJogador(Jogo[0]));
        if (RetonarJogador(Jogo[0]) != "") {
            btn01.setEnabled(false);
        }
        btn02.setText(RetonarJogador(Jogo[1]));
        if (RetonarJogador(Jogo[1]) != "") {
            btn02.setEnabled(false);
        }
        btn03.setText(RetonarJogador(Jogo[2]));
        if (RetonarJogador(Jogo[2]) != "") {
            btn03.setEnabled(false);
        }
        btn04.setText(RetonarJogador(Jogo[3]));
        if (RetonarJogador(Jogo[3]) != "") {
            btn04.setEnabled(false);
        }
        btn05.setText(RetonarJogador(Jogo[4]));
        if (RetonarJogador(Jogo[4]) != "") {
            btn05.setEnabled(false);
        }
        btn06.setText(RetonarJogador(Jogo[5]));
        if (RetonarJogador(Jogo[5]) != "") {
            btn06.setEnabled(false);
        }
        btn07.setText(RetonarJogador(Jogo[6]));
        if (RetonarJogador(Jogo[6]) != "") {
            btn07.setEnabled(false);
        }
        btn08.setText(RetonarJogador(Jogo[7]));
        if (RetonarJogador(Jogo[7]) != "") {
            btn08.setEnabled(false);
        }
        btn09.setText(RetonarJogador(Jogo[8]));
        if (RetonarJogador(Jogo[8]) != "") {
            btn09.setEnabled(false);
        }
    }

    private void gerenciaBotao(boolean btn)
    {
        btn01.setEnabled(btn);
        btn02.setEnabled(btn);
        btn03.setEnabled(btn);
        btn04.setEnabled(btn);
        btn05.setEnabled(btn);
        btn06.setEnabled(btn);
        btn07.setEnabled(btn);
        btn08.setEnabled(btn);
        btn09.setEnabled(btn);
    }


    private void QuestionBox(){
        AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
        builder1.setMessage("Quem começa o jogo?");
        builder1.setCancelable(true);
        builder1.setPositiveButton("Computador",new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog,int id){
                        dialog.cancel();
                        player = 2;
                        InicioPartida();
                    }
                }
        );
        builder1.setNegativeButton("Você",new DialogInterface.OnClickListener(){
            public void onClick(DialogInterface dialog,int id){
                dialog.cancel();
                player = 1;
                InicioPartida();
            }
        });
        AlertDialog alert11 = builder1.create();
        alert11.show();
    }

    private void InicioPartida()
    {
        if (!continuar)
        {
            gerenciaBotao(true);
        }

        for (; turn < 9 && ganhou(board) == 0; ++turn)
        {
            if (continuar)
            {
                Imprimir(board);
                continuar = false;
            }
            else if ((turn + player) % 2 == 0)
            {
                jogadaDoComputador(board);
            }
            else
            {
                Imprimir(board);
                return;
            }
        }

        switch (ganhou(board))
        {
            case 0:
                Toast.makeText(this, "Deu Velha!", Toast.LENGTH_SHORT).show();
                Velha++;
                labVelha.setText("Velha: " + Integer.toString(Velha));
                break;
            case 1:
                Imprimir(board);
                Toast.makeText(this, "Você perdeu!", Toast.LENGTH_SHORT).show();
                Computador++;
                labComputador.setText("Computador: " + Integer.toString(Computador));
                break;
            case -1:
                Toast.makeText(this, "Você ganhou! Impossivel!", Toast.LENGTH_SHORT).show();
                Jogador++;
                labJogador.setText("Jogador: " + Integer.toString(Jogador));
                break;
        }

        gerenciaBotao(false);
    }

    private String RetonarJogador(int i)
    {
        switch (i)
        {
            case -1:
                return "X";
            case 0:
                return "";
            case 1:
                return "O";
            default:
                return "";
        }
    }

    private int ganhou(int[] board)
    {
        Integer[][] wins = new Integer[][] {
                new Integer[] {0,1,2}, // TOPO
                new Integer[] {3,4,5}, // MEIO
                new Integer[] {6,7,8}, // BASE
                new Integer[] {0,4,8}, // DIAGONAL_DESCE
                new Integer[] {2,4,6}, // DIAGONAL_SOBE
                new Integer[] {0,3,6}, // COLUNA_ESQUERDA
                new Integer[] {1,4,7}, // COLUNA_CENTRO
                new Integer[] {2,5,8} // COLUNA_DIREITA
        };

        for (int i = 0; i < 8; ++i)
        {
            if (board[wins[i][0]] != 0 && board[wins[i][0]] == board[wins[i][1]] && board[wins[i][0]] == board[wins[i][2]])
            {
                return board[wins[i][2]];
            }
        }

        return 0;
    }

    private int minimax(int[] board, int player)
    {
        int winner = ganhou(board);

        if (winner != 0)
        {
            return winner * player;
        }

        int move = -1;
        int score = -2;

        for (int i = 0; i < 9; ++i)
        {
            if (board[i] == 0)
            {
                board[i] = player;
                int thisScore = -minimax(board, player * -1);

                if (thisScore > score)
                {
                    score = thisScore;
                    move = i;
                }
                board[i] = 0;
            }
        }
        if (move == -1)
        {
            return 0;
        }

        return score;
    }

    private void jogadaDoComputador(int[] board)
    {
        int move = -1;
        int score = -2;
        for (int i = 0; i < 9; ++i)
        {
            if (board[i] == 0)
            {
                board[i] = 1;
                int tempScore = -minimax(board, -1);
                board[i] = 0;
                if (tempScore > score)
                {
                    score = tempScore;
                    move = i;
                }
            }
        }

        board[move] = 1;
    }

    private void JogadaDoUsuario(int[] board, int Jogada)
    {
        int move = 0;
        do
        {
            move = Jogada;
        } while (move >= 9 || move < 0 && board[move] == 0);
        board[move] = -1;
    }
}
