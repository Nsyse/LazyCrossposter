namespace LazySharper.Forms
{
    partial class ArtUploaderForm
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
            this.m_OpenFileSelector = new System.Windows.Forms.Button();
            this.m_TitleField = new System.Windows.Forms.TextBox();
            this.m_DescriptionField = new System.Windows.Forms.TextBox();
            this.label3 = new System.Windows.Forms.Label();
            this.label4 = new System.Windows.Forms.Label();
            this.m_ContentRatingG = new System.Windows.Forms.RadioButton();
            this.m_ContentRatingT = new System.Windows.Forms.RadioButton();
            this.m_ContentRatingM = new System.Windows.Forms.RadioButton();
            this.m_ContentRatingA = new System.Windows.Forms.RadioButton();
            this.label2 = new System.Windows.Forms.Label();
            this.m_ImagePreview = new System.Windows.Forms.PictureBox();
            this.m_TagsField = new System.Windows.Forms.TextBox();
            this.label1 = new System.Windows.Forms.Label();
            this.m_ArtPageDA = new System.Windows.Forms.CheckBox();
            this.m_ArtPageFA = new System.Windows.Forms.CheckBox();
            this.m_ArtPageWeasyl = new System.Windows.Forms.CheckBox();
            this.m_GenerateTests = new System.Windows.Forms.Button();
            this.m_ArtPageSO = new System.Windows.Forms.CheckBox();
            this.m_ArtSitesFlowPanel = new System.Windows.Forms.FlowLayoutPanel();
            ((System.ComponentModel.ISupportInitialize)(this.m_ImagePreview)).BeginInit();
            this.m_ArtSitesFlowPanel.SuspendLayout();
            this.SuspendLayout();
            // 
            // m_OpenFileSelector
            // 
            this.m_OpenFileSelector.BackColor = System.Drawing.SystemColors.Info;
            this.m_OpenFileSelector.Location = new System.Drawing.Point(12, 12);
            this.m_OpenFileSelector.Name = "m_OpenFileSelector";
            this.m_OpenFileSelector.Size = new System.Drawing.Size(467, 131);
            this.m_OpenFileSelector.TabIndex = 0;
            this.m_OpenFileSelector.Text = "Select file to crosspost";
            this.m_OpenFileSelector.UseVisualStyleBackColor = false;
            this.m_OpenFileSelector.Click += new System.EventHandler(this.OpenFileSelector_Click);
            // 
            // m_TitleField
            // 
            this.m_TitleField.BackColor = System.Drawing.SystemColors.Info;
            this.m_TitleField.Location = new System.Drawing.Point(16, 185);
            this.m_TitleField.Name = "m_TitleField";
            this.m_TitleField.Size = new System.Drawing.Size(622, 20);
            this.m_TitleField.TabIndex = 7;
            this.m_TitleField.TextChanged += new System.EventHandler(this.TitleField_LostFocus);
            // 
            // m_DescriptionField
            // 
            this.m_DescriptionField.BackColor = System.Drawing.SystemColors.Info;
            this.m_DescriptionField.Location = new System.Drawing.Point(14, 225);
            this.m_DescriptionField.Multiline = true;
            this.m_DescriptionField.Name = "m_DescriptionField";
            this.m_DescriptionField.Size = new System.Drawing.Size(621, 215);
            this.m_DescriptionField.TabIndex = 9;
            this.m_DescriptionField.TextChanged += new System.EventHandler(this.DescriptionField_LostFocus);
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(301, 208);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(85, 13);
            this.label3.TabIndex = 8;
            this.label3.Text = "Description Field";
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Location = new System.Drawing.Point(301, 169);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(52, 13);
            this.label4.TabIndex = 6;
            this.label4.Text = "Title Field";
            // 
            // m_ContentRatingG
            // 
            this.m_ContentRatingG.AutoSize = true;
            this.m_ContentRatingG.Location = new System.Drawing.Point(330, 150);
            this.m_ContentRatingG.Name = "m_ContentRatingG";
            this.m_ContentRatingG.Size = new System.Drawing.Size(33, 17);
            this.m_ContentRatingG.TabIndex = 1;
            this.m_ContentRatingG.TabStop = true;
            this.m_ContentRatingG.Text = "G";
            this.m_ContentRatingG.UseVisualStyleBackColor = true;
            this.m_ContentRatingG.CheckedChanged += new System.EventHandler(this.ContentRating_CheckedChanged);
            // 
            // m_ContentRatingT
            // 
            this.m_ContentRatingT.AutoSize = true;
            this.m_ContentRatingT.Location = new System.Drawing.Point(369, 149);
            this.m_ContentRatingT.Name = "m_ContentRatingT";
            this.m_ContentRatingT.Size = new System.Drawing.Size(32, 17);
            this.m_ContentRatingT.TabIndex = 2;
            this.m_ContentRatingT.TabStop = true;
            this.m_ContentRatingT.Text = "T";
            this.m_ContentRatingT.UseVisualStyleBackColor = true;
            this.m_ContentRatingT.CheckedChanged += new System.EventHandler(this.ContentRatingT_CheckedChanged);
            // 
            // m_ContentRatingM
            // 
            this.m_ContentRatingM.AutoSize = true;
            this.m_ContentRatingM.Location = new System.Drawing.Point(407, 149);
            this.m_ContentRatingM.Name = "m_ContentRatingM";
            this.m_ContentRatingM.Size = new System.Drawing.Size(34, 17);
            this.m_ContentRatingM.TabIndex = 3;
            this.m_ContentRatingM.TabStop = true;
            this.m_ContentRatingM.Text = "M";
            this.m_ContentRatingM.UseVisualStyleBackColor = true;
            this.m_ContentRatingM.CheckedChanged += new System.EventHandler(this.ContentRatingM_CheckedChanged);
            // 
            // m_ContentRatingA
            // 
            this.m_ContentRatingA.AutoSize = true;
            this.m_ContentRatingA.Location = new System.Drawing.Point(447, 149);
            this.m_ContentRatingA.Name = "m_ContentRatingA";
            this.m_ContentRatingA.Size = new System.Drawing.Size(32, 17);
            this.m_ContentRatingA.TabIndex = 4;
            this.m_ContentRatingA.TabStop = true;
            this.m_ContentRatingA.Text = "A";
            this.m_ContentRatingA.UseVisualStyleBackColor = true;
            this.m_ContentRatingA.CheckedChanged += new System.EventHandler(this.ContentRatingA_CheckedChanged);
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.BackColor = System.Drawing.SystemColors.Info;
            this.label2.Location = new System.Drawing.Point(244, 153);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(84, 13);
            this.label2.TabIndex = 5;
            this.label2.Text = "Content Rating :";
            // 
            // m_ImagePreview
            // 
            this.m_ImagePreview.BackColor = System.Drawing.SystemColors.ActiveCaptionText;
            this.m_ImagePreview.Location = new System.Drawing.Point(485, 14);
            this.m_ImagePreview.Name = "m_ImagePreview";
            this.m_ImagePreview.Size = new System.Drawing.Size(153, 153);
            this.m_ImagePreview.TabIndex = 10;
            this.m_ImagePreview.TabStop = false;
            this.m_ImagePreview.Click += new System.EventHandler(this.ImagePreview_Click);
            // 
            // m_TagsField
            // 
            this.m_TagsField.BackColor = System.Drawing.SystemColors.Info;
            this.m_TagsField.Location = new System.Drawing.Point(16, 459);
            this.m_TagsField.Name = "m_TagsField";
            this.m_TagsField.Size = new System.Drawing.Size(622, 20);
            this.m_TagsField.TabIndex = 12;
            this.m_TagsField.LostFocus += new System.EventHandler(this.TagsField_LostFocus);
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(301, 443);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(56, 13);
            this.label1.TabIndex = 11;
            this.label1.Text = "Tags Field";
            // 
            // m_ArtPageDA
            // 
            this.m_ArtPageDA.AutoSize = true;
            this.m_ArtPageDA.BackColor = System.Drawing.SystemColors.Info;
            this.m_ArtPageDA.CheckAlign = System.Drawing.ContentAlignment.BottomCenter;
            this.m_ArtPageDA.Location = new System.Drawing.Point(3, 3);
            this.m_ArtPageDA.Name = "m_ArtPageDA";
            this.m_ArtPageDA.Size = new System.Drawing.Size(26, 31);
            this.m_ArtPageDA.TabIndex = 14;
            this.m_ArtPageDA.Text = "DA";
            this.m_ArtPageDA.UseVisualStyleBackColor = false;
            // 
            // m_ArtPageFA
            // 
            this.m_ArtPageFA.AutoSize = true;
            this.m_ArtPageFA.BackColor = System.Drawing.SystemColors.Info;
            this.m_ArtPageFA.CheckAlign = System.Drawing.ContentAlignment.BottomCenter;
            this.m_ArtPageFA.Location = new System.Drawing.Point(35, 3);
            this.m_ArtPageFA.Name = "m_ArtPageFA";
            this.m_ArtPageFA.Size = new System.Drawing.Size(56, 31);
            this.m_ArtPageFA.TabIndex = 15;
            this.m_ArtPageFA.Text = "Furaffinity";
            this.m_ArtPageFA.UseVisualStyleBackColor = false;
            // 
            // m_ArtPageWeasyl
            // 
            this.m_ArtPageWeasyl.AutoSize = true;
            this.m_ArtPageWeasyl.BackColor = System.Drawing.SystemColors.Info;
            this.m_ArtPageWeasyl.CheckAlign = System.Drawing.ContentAlignment.BottomCenter;
            this.m_ArtPageWeasyl.Location = new System.Drawing.Point(150, 3);
            this.m_ArtPageWeasyl.Name = "m_ArtPageWeasyl";
            this.m_ArtPageWeasyl.Size = new System.Drawing.Size(46, 31);
            this.m_ArtPageWeasyl.TabIndex = 19;
            this.m_ArtPageWeasyl.Text = "Weasyl";
            this.m_ArtPageWeasyl.UseVisualStyleBackColor = false;
            // 
            // m_GenerateTests
            // 
            this.m_GenerateTests.BackColor = System.Drawing.SystemColors.Control;
            this.m_GenerateTests.Location = new System.Drawing.Point(16, 527);
            this.m_GenerateTests.Name = "m_GenerateTests";
            this.m_GenerateTests.Size = new System.Drawing.Size(622, 65);
            this.m_GenerateTests.TabIndex = 20;
            this.m_GenerateTests.Text = "Create Selenium Tests!";
            this.m_GenerateTests.UseVisualStyleBackColor = false;
            this.m_GenerateTests.Click += new System.EventHandler(this.GenerateTests_Click);
            // 
            // m_ArtPageSO
            // 
            this.m_ArtPageSO.AutoSize = true;
            this.m_ArtPageSO.BackColor = System.Drawing.SystemColors.Info;
            this.m_ArtPageSO.CheckAlign = System.Drawing.ContentAlignment.BottomCenter;
            this.m_ArtPageSO.Location = new System.Drawing.Point(97, 3);
            this.m_ArtPageSO.Name = "m_ArtPageSO";
            this.m_ArtPageSO.Size = new System.Drawing.Size(47, 31);
            this.m_ArtPageSO.TabIndex = 17;
            this.m_ArtPageSO.Text = "SoFurry";
            this.m_ArtPageSO.UseVisualStyleBackColor = false;
            // 
            // m_ArtSitesFlowPanel
            // 
            this.m_ArtSitesFlowPanel.Controls.Add(this.m_ArtPageDA);
            this.m_ArtSitesFlowPanel.Controls.Add(this.m_ArtPageFA);
            this.m_ArtSitesFlowPanel.Controls.Add(this.m_ArtPageSO);
            this.m_ArtSitesFlowPanel.Controls.Add(this.m_ArtPageWeasyl);
            this.m_ArtSitesFlowPanel.Location = new System.Drawing.Point(16, 485);
            this.m_ArtSitesFlowPanel.Name = "m_ArtSitesFlowPanel";
            this.m_ArtSitesFlowPanel.Size = new System.Drawing.Size(622, 36);
            this.m_ArtSitesFlowPanel.TabIndex = 21;
            // 
            // ArtUploaderForm
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(647, 604);
            this.Controls.Add(this.m_ArtSitesFlowPanel);
            this.Controls.Add(this.m_GenerateTests);
            this.Controls.Add(this.m_TagsField);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.m_ImagePreview);
            this.Controls.Add(this.m_DescriptionField);
            this.Controls.Add(this.label3);
            this.Controls.Add(this.m_TitleField);
            this.Controls.Add(this.label4);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.m_ContentRatingA);
            this.Controls.Add(this.m_ContentRatingM);
            this.Controls.Add(this.m_ContentRatingT);
            this.Controls.Add(this.m_ContentRatingG);
            this.Controls.Add(this.m_OpenFileSelector);
            this.Name = "ArtUploaderForm";
            this.Text = "ArtUploaderForm";
            ((System.ComponentModel.ISupportInitialize)(this.m_ImagePreview)).EndInit();
            this.m_ArtSitesFlowPanel.ResumeLayout(false);
            this.m_ArtSitesFlowPanel.PerformLayout();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion
        private System.Windows.Forms.Button m_OpenFileSelector;
        private System.Windows.Forms.TextBox m_TitleField;
        private System.Windows.Forms.TextBox m_DescriptionField;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.RadioButton m_ContentRatingG;
        private System.Windows.Forms.RadioButton m_ContentRatingT;
        private System.Windows.Forms.RadioButton m_ContentRatingM;
        private System.Windows.Forms.RadioButton m_ContentRatingA;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.PictureBox m_ImagePreview;
        private System.Windows.Forms.TextBox m_TagsField;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.CheckBox m_ArtPageDA;
        private System.Windows.Forms.CheckBox m_ArtPageFA;
        private System.Windows.Forms.CheckBox m_ArtPageWeasyl;
        private System.Windows.Forms.Button m_GenerateTests;
        private System.Windows.Forms.CheckBox m_ArtPageSO;
        private System.Windows.Forms.FlowLayoutPanel m_ArtSitesFlowPanel;
    }
}