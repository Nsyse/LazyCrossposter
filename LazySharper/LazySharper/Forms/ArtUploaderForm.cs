using LazySharper.FormModel;
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

        private ArtUploadModel m_ArtUploadModel = new ArtUploadModel();

        public ArtUploaderForm()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            OpenFileDialog file = new OpenFileDialog();
            if (file.ShowDialog() == DialogResult.OK)
            {
                m_ArtUploadModel.FilePath = file.FileName;
                if (ImageExtensions.Contains(Path.GetExtension(m_ArtUploadModel.FilePath).ToUpperInvariant()))
                {
                    button1.Text = m_ArtUploadModel.FilePath;
                    pictureBox1.Image = Image.FromFile(m_ArtUploadModel.FilePath).GetThumbnailImage(153, 153, () => false, IntPtr.Zero);
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
            if (button1.Text != "Select file to crosspost")
            {
                System.Diagnostics.Process.Start(m_ArtUploadModel.FilePath);
            }
        }

        //Title box
        private void textBox1_LostFocus(object sender, EventArgs e)
        {
            if (textBox1.Text != String.Empty)
            {
                textBox1.BackColor = ReminderDoneColor;
                m_ArtUploadModel.Title = textBox1.Text;
            }
            else
            {
                m_ArtUploadModel.Title = null;
            }
        }

        //Description box
        private void textBox2_LostFocus(object sender, EventArgs e)
        {
            if (textBox2.Text != String.Empty)
            {
                textBox2.BackColor = ReminderDoneColor;
                m_ArtUploadModel.Description = textBox2.Text;
            }
            else
            {
                m_ArtUploadModel.Description = null;
            }
        }

        //Tags box
        private void textBox3_LostFocus(object sender, EventArgs e)
        {
            if (textBox3.Text != String.Empty)
            {
                textBox3.BackColor = ReminderDoneColor;
                m_ArtUploadModel.GenerateTags(textBox3.Text);
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
            m_ArtUploadModel.AgeRating = ArtUploadModel.ContentRating.General;
        }

        private void radioButton6_CheckedChanged(object sender, EventArgs e)
        {
            SetContentRatingSelected();
            m_ArtUploadModel.AgeRating = ArtUploadModel.ContentRating.Teen;
        }

        private void radioButton7_CheckedChanged(object sender, EventArgs e)
        {
            SetContentRatingSelected();
            m_ArtUploadModel.AgeRating = ArtUploadModel.ContentRating.Mature;
        }

        private void radioButton8_CheckedChanged(object sender, EventArgs e)
        {
            SetContentRatingSelected();
            m_ArtUploadModel.AgeRating = ArtUploadModel.ContentRating.Adult;
        }
        #endregion

        // Submit Button click
        private void button2_Click(object sender, EventArgs e)
        {
            generateGenerator();

            SuiteGenerator generator = new SuiteGenerator();

            Console.WriteLine(m_ArtUploadModel);
            bool genDA = checkBox1.Checked;
            bool genFA = checkBox2.Checked;
            bool genFU = checkBox3.Checked;
            bool genSF = checkBox4.Checked;
            bool genTB = checkBox5.Checked;
            bool genWS = checkBox6.Checked;

            //Gen suite and tests
            //TODO : add a list of active sites in the model.
            generator.GenerateSuite(m_ArtUploadModel);
        }

        private void generateGenerator()
        {
            //Read all text line in a given file.
            string[] readLines = File.ReadAllLines(@"Input\test.txt");

            using (System.IO.StreamWriter file = new System.IO.StreamWriter(@"Input\genned.txt"))
            {
                file.WriteLine("using (System.IO.StreamWriter file = new System.IO.StreamWriter(@\"Input\\genned.txt\"))");
                file.WriteLine("{");
                //For each line of text, write in another file the same line with a given prefix and suffix to make a hardcoded generator.
                foreach (string s in readLines)
                {
                    file.WriteLine("file.WriteLine(\"" + s + "\");");
                }
                file.WriteLine("}");
            }
        }

    }
}
