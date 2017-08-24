using System;
using System.Collections.Generic;
using System.Drawing;
using System.IO;
using System.Windows.Forms;
using LazySharper.ArtGens;
using LazySharper.FormModel;

namespace LazySharper.Forms
{
    public partial class ArtUploaderForm : Form
    {
        private static readonly List<string> ImageExtensions = new List<string> { "*.jpg", "*.jpe", "*.jpeg", "*.bpm", "*.gif", "*.png" };

        private Color m_ReminderDoneColor = SystemColors.Control;

        private ArtUploadModel m_ArtUploadModel = new ArtUploadModel();

        private Dictionary<CheckBox, ArtUploadTestGenerator> m_SiteMap = new Dictionary<CheckBox, ArtUploadTestGenerator>();

        public ArtUploaderForm()
        {
            InitializeComponent();
            CreateCheckBoxMap();


            // Create output folder for selenium tests
            if (!Directory.Exists("Output"))
                Directory.CreateDirectory("Output");
        }

        private void CreateCheckBoxMap()
        {
            m_SiteMap[m_ArtPageDA] = new DAArtGenerator();
            m_SiteMap[m_ArtPageFA] = new FuraffinityArtGenerator();
            m_SiteMap[m_ArtPageSO] = new SoFurryArtGenerator();
            m_SiteMap[m_ArtPageWeasyl] = new WeasylArtGenerator();
            //bool genFU = checkBox3.Checked;
            //bool genTB = checkBox5.Checked;
            //bool genWS = checkBox6.Checked;

        }

        private void OpenFileSelector_Click(object sender, EventArgs e)
        {
            OpenFileDialog file = new OpenFileDialog();
            file.Filter = "Image Files" + "|" + string.Join(";", ImageExtensions);
            if (file.ShowDialog() == DialogResult.OK)
            {
                m_ArtUploadModel.FilePath = file.FileName;
                m_OpenFileSelector.Text = m_ArtUploadModel.FilePath;
                m_ImagePreview.Image = Image.FromFile(m_ArtUploadModel.FilePath).GetThumbnailImage(153, 153, () => false, IntPtr.Zero);
                m_OpenFileSelector.BackColor = m_ReminderDoneColor;
            }
        }

        private void ImagePreview_Click(object sender, EventArgs e)
        {
            if (m_OpenFileSelector.Text != "Select file to crosspost")
            {
                System.Diagnostics.Process.Start(m_ArtUploadModel.FilePath);
            }
        }

        //Title box
        private void TitleField_LostFocus(object sender, EventArgs e)
        {
            if (!string.IsNullOrEmpty(m_TitleField.Text))
            {
                m_TitleField.BackColor = m_ReminderDoneColor;
                m_ArtUploadModel.Title = m_TitleField.Text;
            }
            else
            {
                m_ArtUploadModel.Title = null;
            }
        }

        //Description box
        private void DescriptionField_LostFocus(object sender, EventArgs e)
        {
            if (!string.IsNullOrEmpty(m_DescriptionField.Text))
            {
                m_DescriptionField.BackColor = m_ReminderDoneColor;
                m_ArtUploadModel.Description = m_DescriptionField.Text;
            }
            else
            {
                m_ArtUploadModel.Description = null;
            }
        }

        //Tags box
        private void TagsField_LostFocus(object sender, EventArgs e)
        {
            if (!string.IsNullOrEmpty(m_TagsField.Text))
            {
                m_TagsField.BackColor = m_ReminderDoneColor;
                m_ArtUploadModel.GenerateTags(m_TagsField.Text);
            }
        }

        #region Content Rating Radio buttons
        private void SetContentRatingSelected()
        {
            label2.BackColor = m_ReminderDoneColor;
        }

        private void ContentRating_CheckedChanged(object sender, EventArgs e)
        {
            SetContentRatingSelected();
            m_ArtUploadModel.AgeRating = ArtUploadModel.ContentRating.General;
        }

        private void ContentRatingT_CheckedChanged(object sender, EventArgs e)
        {
            SetContentRatingSelected();
            m_ArtUploadModel.AgeRating = ArtUploadModel.ContentRating.Teen;
        }

        private void ContentRatingM_CheckedChanged(object sender, EventArgs e)
        {
            SetContentRatingSelected();
            m_ArtUploadModel.AgeRating = ArtUploadModel.ContentRating.Mature;
        }

        private void ContentRatingA_CheckedChanged(object sender, EventArgs e)
        {
            SetContentRatingSelected();
            m_ArtUploadModel.AgeRating = ArtUploadModel.ContentRating.Adult;
        }
        #endregion

        // Submit Button click
        private void GenerateTests_Click(object sender, EventArgs e)
        {
            //generateGenerator();

            SuiteGenerator generator = new SuiteGenerator();

            Console.WriteLine(m_ArtUploadModel);
            foreach (var control in m_ArtSitesFlowPanel.Controls)
            {
                CheckBox checkbox = control as CheckBox;
                if (checkbox != null)
                {
                    if (checkbox.Checked)
                    {
                        if (m_SiteMap.ContainsKey(checkbox))
                        {
                            m_SiteMap[checkbox].GenerateSeleniumTest(m_ArtUploadModel);
                            m_ArtUploadModel.ActiveSites.Add(checkbox.Text);
                        }
                    }
                }
            }

            //Gen suite and tests
            //TODO : add a list of active sites in the model.
            generator.GenerateSuite(m_ArtUploadModel);
        }

        private void GenerateGenerator()
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
                    string escapedQuotes = s.Replace("\"", "\"\"");
                    file.WriteLine("file.WriteLine(@\"" + escapedQuotes + "\");");
                }
                file.WriteLine("}");
            }
        }
    }
}
