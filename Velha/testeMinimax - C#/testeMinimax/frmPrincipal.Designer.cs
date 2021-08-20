namespace testeMinimax
{
    partial class frmPrincipal
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.label1 = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.label3 = new System.Windows.Forms.Label();
            this.groupBox1 = new System.Windows.Forms.GroupBox();
            this.labVelha = new System.Windows.Forms.Label();
            this.labComputador = new System.Windows.Forms.Label();
            this.labJogador = new System.Windows.Forms.Label();
            this.btnNovoJogo = new testeMinimax.Botao();
            this.btn09 = new testeMinimax.Botao();
            this.btn08 = new testeMinimax.Botao();
            this.btn07 = new testeMinimax.Botao();
            this.btn06 = new testeMinimax.Botao();
            this.btn05 = new testeMinimax.Botao();
            this.btn04 = new testeMinimax.Botao();
            this.btn03 = new testeMinimax.Botao();
            this.btn02 = new testeMinimax.Botao();
            this.btn01 = new testeMinimax.Botao();
            this.groupBox1.SuspendLayout();
            this.SuspendLayout();
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(6, 16);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(48, 13);
            this.label1.TabIndex = 10;
            this.label1.Text = "Jogador:";
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(6, 33);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(67, 13);
            this.label2.TabIndex = 11;
            this.label2.Text = "Computador:";
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(6, 50);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(37, 13);
            this.label3.TabIndex = 12;
            this.label3.Text = "Velha:";
            // 
            // groupBox1
            // 
            this.groupBox1.Controls.Add(this.labVelha);
            this.groupBox1.Controls.Add(this.labComputador);
            this.groupBox1.Controls.Add(this.labJogador);
            this.groupBox1.Controls.Add(this.label2);
            this.groupBox1.Controls.Add(this.label3);
            this.groupBox1.Controls.Add(this.label1);
            this.groupBox1.Location = new System.Drawing.Point(181, 12);
            this.groupBox1.Name = "groupBox1";
            this.groupBox1.Size = new System.Drawing.Size(105, 75);
            this.groupBox1.TabIndex = 13;
            this.groupBox1.TabStop = false;
            this.groupBox1.Text = "Placar Geral";
            // 
            // labVelha
            // 
            this.labVelha.AutoSize = true;
            this.labVelha.Location = new System.Drawing.Point(86, 52);
            this.labVelha.Name = "labVelha";
            this.labVelha.Size = new System.Drawing.Size(13, 13);
            this.labVelha.TabIndex = 15;
            this.labVelha.Text = "0";
            // 
            // labComputador
            // 
            this.labComputador.AutoSize = true;
            this.labComputador.Location = new System.Drawing.Point(86, 33);
            this.labComputador.Name = "labComputador";
            this.labComputador.Size = new System.Drawing.Size(13, 13);
            this.labComputador.TabIndex = 14;
            this.labComputador.Text = "0";
            // 
            // labJogador
            // 
            this.labJogador.AutoSize = true;
            this.labJogador.Location = new System.Drawing.Point(86, 16);
            this.labJogador.Name = "labJogador";
            this.labJogador.Size = new System.Drawing.Size(13, 13);
            this.labJogador.TabIndex = 13;
            this.labJogador.Text = "0";
            // 
            // btnNovoJogo
            // 
            this.btnNovoJogo._clicado = false;
            this.btnNovoJogo._valor = 0;
            this.btnNovoJogo.Location = new System.Drawing.Point(13, 12);
            this.btnNovoJogo.Name = "btnNovoJogo";
            this.btnNovoJogo.Size = new System.Drawing.Size(75, 23);
            this.btnNovoJogo.TabIndex = 9;
            this.btnNovoJogo.Text = "Novo Jogo";
            this.btnNovoJogo.UseVisualStyleBackColor = true;
            this.btnNovoJogo.Click += new System.EventHandler(this.btnNovoJogo_Click);
            // 
            // btn09
            // 
            this.btn09._clicado = false;
            this.btn09._valor = 8;
            this.btn09.Location = new System.Drawing.Point(125, 157);
            this.btn09.Name = "btn09";
            this.btn09.Size = new System.Drawing.Size(50, 50);
            this.btn09.TabIndex = 8;
            this.btn09.UseVisualStyleBackColor = true;
            // 
            // btn08
            // 
            this.btn08._clicado = false;
            this.btn08._valor = 7;
            this.btn08.Location = new System.Drawing.Point(69, 157);
            this.btn08.Name = "btn08";
            this.btn08.Size = new System.Drawing.Size(50, 50);
            this.btn08.TabIndex = 7;
            this.btn08.UseVisualStyleBackColor = true;
            // 
            // btn07
            // 
            this.btn07._clicado = false;
            this.btn07._valor = 6;
            this.btn07.Location = new System.Drawing.Point(13, 157);
            this.btn07.Name = "btn07";
            this.btn07.Size = new System.Drawing.Size(50, 50);
            this.btn07.TabIndex = 6;
            this.btn07.UseVisualStyleBackColor = true;
            // 
            // btn06
            // 
            this.btn06._clicado = false;
            this.btn06._valor = 5;
            this.btn06.Location = new System.Drawing.Point(125, 101);
            this.btn06.Name = "btn06";
            this.btn06.Size = new System.Drawing.Size(50, 50);
            this.btn06.TabIndex = 5;
            this.btn06.UseVisualStyleBackColor = true;
            // 
            // btn05
            // 
            this.btn05._clicado = false;
            this.btn05._valor = 4;
            this.btn05.Location = new System.Drawing.Point(69, 101);
            this.btn05.Name = "btn05";
            this.btn05.Size = new System.Drawing.Size(50, 50);
            this.btn05.TabIndex = 4;
            this.btn05.UseVisualStyleBackColor = true;
            // 
            // btn04
            // 
            this.btn04._clicado = false;
            this.btn04._valor = 3;
            this.btn04.Location = new System.Drawing.Point(13, 101);
            this.btn04.Name = "btn04";
            this.btn04.Size = new System.Drawing.Size(50, 50);
            this.btn04.TabIndex = 3;
            this.btn04.UseVisualStyleBackColor = true;
            // 
            // btn03
            // 
            this.btn03._clicado = false;
            this.btn03._valor = 2;
            this.btn03.Location = new System.Drawing.Point(125, 45);
            this.btn03.Name = "btn03";
            this.btn03.Size = new System.Drawing.Size(50, 50);
            this.btn03.TabIndex = 2;
            this.btn03.UseVisualStyleBackColor = true;
            // 
            // btn02
            // 
            this.btn02._clicado = false;
            this.btn02._valor = 1;
            this.btn02.Location = new System.Drawing.Point(69, 45);
            this.btn02.Name = "btn02";
            this.btn02.Size = new System.Drawing.Size(50, 50);
            this.btn02.TabIndex = 1;
            this.btn02.UseVisualStyleBackColor = true;
            // 
            // btn01
            // 
            this.btn01._clicado = false;
            this.btn01._valor = 0;
            this.btn01.Location = new System.Drawing.Point(13, 45);
            this.btn01.Name = "btn01";
            this.btn01.Size = new System.Drawing.Size(50, 50);
            this.btn01.TabIndex = 0;
            this.btn01.UseVisualStyleBackColor = true;
            // 
            // frmPrincipal
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(293, 223);
            this.Controls.Add(this.groupBox1);
            this.Controls.Add(this.btnNovoJogo);
            this.Controls.Add(this.btn09);
            this.Controls.Add(this.btn08);
            this.Controls.Add(this.btn07);
            this.Controls.Add(this.btn06);
            this.Controls.Add(this.btn05);
            this.Controls.Add(this.btn04);
            this.Controls.Add(this.btn03);
            this.Controls.Add(this.btn02);
            this.Controls.Add(this.btn01);
            this.MaximizeBox = false;
            this.MaximumSize = new System.Drawing.Size(309, 262);
            this.MinimumSize = new System.Drawing.Size(309, 262);
            this.Name = "frmPrincipal";
            this.ShowIcon = false;
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "Jogo da Velha";
            this.groupBox1.ResumeLayout(false);
            this.groupBox1.PerformLayout();
            this.ResumeLayout(false);

        }

        #endregion

        private Botao btn01;
        private Botao btn02;
        private Botao btn03;
        private Botao btn04;
        private Botao btn05;
        private Botao btn06;
        private Botao btn07;
        private Botao btn08;
        private Botao btn09;
        private Botao btnNovoJogo;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.GroupBox groupBox1;
        private System.Windows.Forms.Label labVelha;
        private System.Windows.Forms.Label labComputador;
        private System.Windows.Forms.Label labJogador;
    }
}

