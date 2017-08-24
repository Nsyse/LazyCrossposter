namespace LazySharper.Forms
{
    partial class SpawnerForm
    {
        /// <summary>
        /// Variable nécessaire au concepteur.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Nettoyage des ressources utilisées.
        /// </summary>
        /// <param name="disposing">true si les ressources managées doivent être supprimées ; sinon, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Code généré par le Concepteur Windows Form

        /// <summary>
        /// Méthode requise pour la prise en charge du concepteur - ne modifiez pas
        /// le contenu de cette méthode avec l'éditeur de code.
        /// </summary>
        private void InitializeComponent()
        {
            this.uploadContent = new System.Windows.Forms.Button();
            this.complain = new System.Windows.Forms.Button();
            this.contact = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // uploadContent
            // 
            this.uploadContent.Location = new System.Drawing.Point(12, 12);
            this.uploadContent.Name = "uploadContent";
            this.uploadContent.Size = new System.Drawing.Size(260, 36);
            this.uploadContent.TabIndex = 0;
            this.uploadContent.Text = "Upload content";
            this.uploadContent.UseVisualStyleBackColor = true;
            this.uploadContent.Click += new System.EventHandler(this.UploadContent_Click);
            // 
            // complain
            // 
            this.complain.Location = new System.Drawing.Point(12, 54);
            this.complain.Name = "complain";
            this.complain.Size = new System.Drawing.Size(260, 36);
            this.complain.TabIndex = 1;
            this.complain.Text = "Complain about your life";
            this.complain.UseVisualStyleBackColor = true;
            this.complain.Click += new System.EventHandler(this.Complain_Click);
            // 
            // contact
            // 
            this.contact.Location = new System.Drawing.Point(12, 96);
            this.contact.Name = "contact";
            this.contact.Size = new System.Drawing.Size(260, 36);
            this.contact.TabIndex = 2;
            this.contact.Text = "Contact the fucker who made this";
            this.contact.UseVisualStyleBackColor = true;
            this.contact.Click += new System.EventHandler(this.Contact_Click);
            // 
            // SpawnerForm
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(284, 261);
            this.Controls.Add(this.contact);
            this.Controls.Add(this.complain);
            this.Controls.Add(this.uploadContent);
            this.Name = "SpawnerForm";
            this.Text = "Nsyse Lazy Artist Helper";
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.Button uploadContent;
        private System.Windows.Forms.Button complain;
        private System.Windows.Forms.Button contact;
    }
}

