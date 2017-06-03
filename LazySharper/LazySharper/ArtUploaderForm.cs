using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace LazySharper
{
    public partial class ArtUploaderForm : Form
    {
        private static readonly List<string> ImageExtensions = new List<string> { ".JPG", ".JPE", ".BMP", ".GIF", ".PNG" };

        private Color ReminderDoneColor = System.Drawing.SystemColors.Control;

        private string selectedImagePath = null;

        public ArtUploaderForm()
        {
            InitializeComponent();
        }

        private void ArtUploaderForm_Load(object sender, EventArgs e)
        {

        }

        private void openFileDialog1_FileOk(object sender, CancelEventArgs e)
        {

        }

        private void button1_Click(object sender, EventArgs e)
        {
            OpenFileDialog file = new OpenFileDialog();
            if (file.ShowDialog() == DialogResult.OK)
            {
                selectedImagePath = file.FileName;
                if (ImageExtensions.Contains(Path.GetExtension(selectedImagePath).ToUpperInvariant()))
                {
                    button1.Text = selectedImagePath;
                    pictureBox1.Image = Image.FromFile(selectedImagePath).GetThumbnailImage(153, 153, () => false, IntPtr.Zero);
                    button1.BackColor = ReminderDoneColor;

                }
                else
                {
                    MessageDialogUtils.ShowErrorMessageDialog("Invalid file selected!", "Only files with the given extensions are supported : " +
                        "\n- .bmp, " +
                        "\n- .gif, " +
                        "\n- .jpe, " +
                        "\n- .jpg, " +
                        "\n- .png");
                }
            }
        }

        private void pictureBox1_Click(object sender, EventArgs e)
        {
            if(button1.Text != "Select file to crosspost")
            {
                System.Diagnostics.Process.Start(selectedImagePath);
            }
        }

        private void textBox1_LostFocus(object sender, System.EventArgs e)
        {
            if (textBox1.Text != String.Empty)
            {
                textBox1.BackColor = ReminderDoneColor;
            }
        }

        #region Content Rating Radio buttons
        private void SetContentRatingSelected()
        {
            label2.BackColor = ReminderDoneColor;
        }

        private void radioButton5_CheckedChanged(object sender, EventArgs e)
        {
            SetContentRatingSelected();
        }

        private void radioButton6_CheckedChanged(object sender, EventArgs e)
        {
            SetContentRatingSelected();
        }

        private void radioButton7_CheckedChanged(object sender, EventArgs e)
        {
            SetContentRatingSelected();
        }

        private void radioButton8_CheckedChanged(object sender, EventArgs e)
        {
            SetContentRatingSelected();
        }
        #endregion
    }
}
