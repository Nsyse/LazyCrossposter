using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;

namespace LazySharper.FormModel
{
    class ArtUploadModel
    {
        public enum ContentRating
        {
            Unset, General, Teen, Mature, Adult
        }

        public string FilePath { get; set; }
        public string Title { get; set; }
        public string Description { get; set; }
        public List<string> Tags { get; set; }


        private ContentRating m_AgeRating = ContentRating.Unset;
        public ContentRating AgeRating {
            get { return m_AgeRating; }
            set { m_AgeRating = value; }
        }

        public ArtUploadModel()
        {
            this.Tags = new List<string>();
        }

        public override string ToString()
        {
            string toStringValue = "FilePath : " + FilePath + "\n" +
                "Title : " + Title + "\n" +
                "Description : " + Description + "\n" +
                "Tags : ";
            for (int i = 0; i < Tags.Count; i++)
            {
                toStringValue += Tags[i]+", ";
            }
            toStringValue += "\nAgeRating : " + AgeRating + "\n";
            return toStringValue;
        }

        public bool GenerateTags(string text)
        {
            if (StringIsAlphanumeric(text))
            {
                text.Replace(' ', '_');
                Tags = text.Split(',').ToList();
            }
            else
            {
                MessageDialogUtils.ShowErrorMessageDialog("Tag Field Error", "Only alphanumeric characters are allowed for the tags field.");
            }

            if (Tags.Count >= 2)
            {
                return true;
            }
            else
            {
                MessageDialogUtils.ShowErrorMessageDialog("Tag Field Error", "Require at least 2 tags.\n" +
                    "Please separate tags by commas.");
            }
            return false;
        }

        private bool StringIsAlphanumeric(string text)
        {
            Regex r = new Regex("^[a-zA-Z0-9, ]*$");
            return r.IsMatch(text);
        }
    }
}
