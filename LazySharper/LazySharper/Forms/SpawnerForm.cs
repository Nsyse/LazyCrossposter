using System;
using System.Windows.Forms;

namespace LazySharper.Forms
{
    public partial class SpawnerForm : Form
    {
        public SpawnerForm()
        {
            InitializeComponent();
        }

        private void UploadContent_Click(object sender, EventArgs e)
        {
            ArtUploaderForm artForm = new ArtUploaderForm();
            artForm.Show();
        }

        private void Complain_Click(object sender, EventArgs e)
        {
            System.Diagnostics.Process.Start("https://github.com/Nsyse/LazyCrossposter/issues");
        }

        private void Contact_Click(object sender, EventArgs e)
        {
            System.Diagnostics.Process.Start("https://twitter.com/ZeNsyse");
        }
    }
}
