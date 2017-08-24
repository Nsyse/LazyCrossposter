using System;
using System.Collections.Generic;
using System.Linq;
using System.Text.RegularExpressions;

namespace LazySharper.FormModel
{
    public class ArtUploadModel : TestGeneratorModel
    {
        public enum ContentRating
        {
            Unset, General, Teen, Mature, Adult
        }

        public string FilePath { get; set; }
        public string Title { get; set; }
        public string Description { get; set; }
        public List<string> Tags { get; set; }


        private static Regex m_stringIsNumericRegex = new Regex("^[a-zA-Z0-9, ]*$");

        public ContentRating AgeRating { get; set; } = ContentRating.Unset;

        private List<string> m_ActiveSites = new List<string>();
        public List<string> ActiveSites {
            get => m_ActiveSites ?? (m_ActiveSites = new List<string>());
            set => m_ActiveSites = value;
        }

        public ArtUploadModel()
        {
            Tags = new List<string>();
        }

        public override string ToString()
        {
            return "FilePath : " + FilePath + "\n" +
                "Title : " + Title + "\n" +
                "Description : " + Description + "\n" +
                "Tags : " + string.Join(", ", Tags) + "\n" +
                "AgeRating : " + AgeRating + "\n";
        }

        public bool GenerateTags(string text)
        {
            if (StringIsAlphanumeric(text))
            {
                text.Replace(' ', '_'); // TODO @Nsyse ?
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
            MessageDialogUtils.ShowErrorMessageDialog("Tag Field Error", "Require at least 2 tags.\n" + 
                                                                         "Please separate tags by commas.");
            return false;
        }

        private bool StringIsAlphanumeric(string text)
        {
            return m_stringIsNumericRegex.IsMatch(text);
        }
    }
}
