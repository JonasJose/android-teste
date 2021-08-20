using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Windows.Forms;

namespace testeMinimax
{
    public partial class Botao : Button
    {
        public bool _clicado { get; set; }
        public int _valor { get; set; }

        private void InitializeComponent()
        {
            this.SuspendLayout();
            // 
            // Botao
            // 
            this.Click += new System.EventHandler(this.Botao_Click);
            this.MouseClick += new System.Windows.Forms.MouseEventHandler(this.Botao_MouseClick);
            this.MouseDown += new System.Windows.Forms.MouseEventHandler(this.Botao_MouseDown);
            this.MouseUp += new System.Windows.Forms.MouseEventHandler(this.Botao_MouseUp);
            this.ResumeLayout(false);

        }

        private void Botao_MouseDown(object sender, MouseEventArgs e)
        {
            
        }

        private void Botao_MouseUp(object sender, MouseEventArgs e)
        {
            
        }

        private void Botao_MouseClick(object sender, MouseEventArgs e)
        {
            
        }

        private void Botao_Click(object sender, EventArgs e)
        {
            
        }
    }
}
