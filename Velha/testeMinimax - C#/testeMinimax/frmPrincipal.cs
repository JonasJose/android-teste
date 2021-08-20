using Microsoft.VisualBasic;
using System;
using System.Windows.Forms;

namespace testeMinimax
{
    public partial class frmPrincipal : Form
    {
        int jogadorAtual = 0;
        int[] jogoAtual = { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
        int rodada = 0;
        bool continuar = false;

        int Jogador = 0;
        int Computador = 0;
        int Velha = 0;

        //Construtor do formulario principal
        public frmPrincipal()
        {
            InitializeComponent();

            //adiciona metodo btn_Click no evento click
            btn01.Click += new EventHandler(btn_Click);
            btn02.Click += new EventHandler(btn_Click);
            btn03.Click += new EventHandler(btn_Click);
            btn04.Click += new EventHandler(btn_Click);
            btn05.Click += new EventHandler(btn_Click);
            btn06.Click += new EventHandler(btn_Click);
            btn07.Click += new EventHandler(btn_Click);
            btn08.Click += new EventHandler(btn_Click);
            btn09.Click += new EventHandler(btn_Click);

            //Desabilita botoes para aguardar quem iniciara o novo jogo
            gerenciaBotao(false);
        }

        //desabilita/habilita botão para evitar que jogador click em um botão que já foi clicado
        private void gerenciaBotao(bool btn)
        {
            btn01.Enabled = btn;
            btn02.Enabled = btn;
            btn03.Enabled = btn;
            btn04.Enabled = btn;
            btn05.Enabled = btn;
            btn06.Enabled = btn;
            btn07.Enabled = btn;
            btn08.Enabled = btn;
            btn09.Enabled = btn;
        }

        //Evento adicionado nos botões 1-9 para escutar click do usuario e realizar jogada
        private void btn_Click(object sender, EventArgs e)
        {
            continuar = true;
            JogadaDoUsuario(jogoAtual, (sender as Botao)._valor);
            InicioPartida();
        }

        //seta no botão o valor da sua respectiva posição 
        void Imprimir(int[] Jogo)
        {
            btn01.Text = RetonarJogador(Jogo[0]).ToString();
            btn02.Text = RetonarJogador(Jogo[1]).ToString();
            btn03.Text = RetonarJogador(Jogo[2]).ToString();
            btn04.Text = RetonarJogador(Jogo[3]).ToString();
            btn05.Text = RetonarJogador(Jogo[4]).ToString();
            btn06.Text = RetonarJogador(Jogo[5]).ToString();
            btn07.Text = RetonarJogador(Jogo[6]).ToString();
            btn08.Text = RetonarJogador(Jogo[7]).ToString();
            btn09.Text = RetonarJogador(Jogo[8]).ToString();

            //caso o computador jogue em um botão esse codigo verifica se o botão tem um valor (X,O)
            //para desativar e evitar problema de jogada em uma mesma posição
            if (RetonarJogador(Jogo[0]).ToString() != " ")
            {
                btn01.Enabled = false;
            }

            if (RetonarJogador(Jogo[1]).ToString() != " ")
            {
                btn02.Enabled = false; ;
            }

            if (RetonarJogador(Jogo[2]).ToString() != " ")
            {
                btn03.Enabled = false;
            }

            if (RetonarJogador(Jogo[3]).ToString() != " ")
            {
                btn04.Enabled = false;
            }

            if (RetonarJogador(Jogo[4]).ToString() != " ")
            {
                btn05.Enabled = false;
            }

            if (RetonarJogador(Jogo[5]).ToString() != " ")
            {
                btn06.Enabled = false;
            }

            if (RetonarJogador(Jogo[6]).ToString() != " ")
            {
                btn07.Enabled = false;
            }

            if (RetonarJogador(Jogo[7]).ToString() != " ")
            {
                btn08.Enabled = false;
            }

            if (RetonarJogador(Jogo[8]).ToString() != " ")
            {
                btn09.Enabled = false;
            }
        }

        //metodo principal que incia a partida ou continua do ponto que parou
        private void InicioPartida()
        {
            if (!continuar)
            {
                //pergunta para o usuario quem vai começar o jogo
                frmQuemComeca quemComeca = new frmQuemComeca();
                DialogResult dr = quemComeca.ShowDialog();
                if (dr == DialogResult.Yes)
                {
                    jogadorAtual = 2; //computador
                }
                else if (dr == DialogResult.No)
                {
                    jogadorAtual = 1; //usuario
                }

                gerenciaBotao(true);
            }

            for (; rodada < 9 && ganhou(jogoAtual) == 0; ++rodada)
            {
                if (continuar)
                {
                    Imprimir(jogoAtual);
                    continuar = false;
                }
                else if ((rodada + jogadorAtual) % 2 == 0)
                {
                    jogadaDoComputador(jogoAtual);
                }
                else
                {
                    Imprimir(jogoAtual);
                    return;
                }
            }

            //verifica quem ganhou e exibe uma msg com o resultado
            switch (ganhou(jogoAtual))
            {
                case 0:
                    MessageBox.Show("Deu Velha!");
                    Velha++;
                    labVelha.Text = Velha.ToString();
                    break;
                case 1:
                    Imprimir(jogoAtual);
                    MessageBox.Show("Você perdeu!");
                    Computador++;
                    labComputador.Text = Computador.ToString();
                    break;
                case -1:
                    MessageBox.Show("Você ganhou! Impossivel!");
                    Jogador++;
                    labJogador.Text = Jogador.ToString();
                    break;
            }

            gerenciaBotao(false);
        }

        //retorna o jogado
        private char RetonarJogador(int i)
        {
            switch (i)
            {
                case -1:
                    return 'X';
                case 0:
                    return ' ';
                case 1:
                    return 'O';
                default:
                    return '_';
            }
        }

        // função que verifica si alguem ganhou e o retona
        private int ganhou(int[] jogoAtualParaVerificar)
        {
            //Jogos que ganhão
            int[,] JogosGanhao = new[,]
            {
                {0,1,2},{3,4,5},{6,7,8},
                {0,3,6},{1,4,7},{2,5,8},
                {0,4,8},{2,4,6}
            };

            for (int i = 0; i < 8; ++i)
            {
                if (jogoAtualParaVerificar[JogosGanhao[i, 0]] != 0 && jogoAtualParaVerificar[JogosGanhao[i, 0]] == jogoAtualParaVerificar[JogosGanhao[i, 1]] && jogoAtualParaVerificar[JogosGanhao[i, 0]] == jogoAtualParaVerificar[JogosGanhao[i, 2]])
                {
                    return jogoAtualParaVerificar[JogosGanhao[i, 2]];
                }
            }

            return 0;
        }

        //algoritimo reponsavel por retonar a melhor posição possivel para o computador ganhar
        //algoritimo inteligente
        private int minimax(int[] jogoAtualParaVerificar, int jogadorAtualParaVerificar)
        {
            //verifica ganhador
            int ganhador = ganhou(jogoAtualParaVerificar);

            if (ganhador != 0)
            {
                return ganhador * jogadorAtualParaVerificar;
            }

            int movimento = -1;
            int pontuacao = -2;//remove -2 das jogadas ruins

            for (int i = 0; i < 9; ++i)
            {//faz uma varedura em todas as jogadas
                if (jogoAtualParaVerificar[i] == 0)
                {//se a posição for legal,
                    jogoAtualParaVerificar[i] = jogadorAtualParaVerificar;//tenta o movimento
                    int pontuacaoAtual = -minimax(jogoAtualParaVerificar, jogadorAtualParaVerificar * -1);

                    if (pontuacaoAtual > pontuacao)
                    {
                        pontuacao = pontuacaoAtual;
                        movimento = i;
                    }// Escolhe o que é pior para o oponente
                    jogoAtualParaVerificar[i] = 0;//Reseta jogoAtualParaVerificar depois de tentar
                }
            }
            if (movimento == -1)
            {
                return 0;
            }

            return pontuacao;
        }

        private void jogadaDoComputador(int[] jogoAtualParaVerificar)
        {
            int move = -1;
            int score = -2;
            for (int i = 0; i < 9; ++i)
            {
                if (jogoAtualParaVerificar[i] == 0)
                {
                    jogoAtualParaVerificar[i] = 1;
                    int tempScore = -minimax(jogoAtualParaVerificar, -1);
                    jogoAtualParaVerificar[i] = 0;
                    if (tempScore > score)
                    {
                        score = tempScore;
                        move = i;
                    }
                }
            }
            //returns a score based on minimax tree at a given node.
            jogoAtualParaVerificar[move] = 1;
        }

        //verifica/Seta a jogada do usuario no jogo atual
        private void JogadaDoUsuario(int[] jogoAtualParaVerificar, int Jogada)
        {
            int move = 0;
            do
            {
                move = Jogada; 
            } while (move >= 9 || move < 0 && jogoAtualParaVerificar[move] == 0);
            jogoAtualParaVerificar[move] = -1;
        }

        //Clck do botão Novo Jogo
        private void btnNovoJogo_Click(object sender, EventArgs e)
        {
            jogadorAtual = 0;
            jogoAtual = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
            rodada = 0;
            continuar = false;
            InicioPartida();
        }
    }
}
