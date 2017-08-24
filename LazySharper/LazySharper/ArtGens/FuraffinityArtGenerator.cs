using System;
using System.IO;
using LazySharper.FormModel;

namespace LazySharper.ArtGens
{
    public class FuraffinityArtGenerator : ArtUploadTestGenerator
    {
        public override void GenerateSeleniumTest(ArtUploadModel model)
        {
            using (StreamWriter file = new StreamWriter("Output/FA upload_ready_test.html"))
            {
                file.WriteLine("<?xml version='1.0' encoding='UTF-8'?>");
                file.WriteLine(@"<!DOCTYPE html PUBLIC ""-//W3C//DTD XHTML 1.0 Strict//EN"" ""http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd"">");
                file.WriteLine("<html xmlns='http://www.w3.org/1999/xhtml' xml:lang='en' lang='en'>");
                file.WriteLine("<head profile='http://selenium-ide.openqa.org/profiles/test-case'>");
                file.WriteLine("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8' />");
                file.WriteLine("<link rel='selenium.base' href='http://www.furaffinity.net/' />");
                file.WriteLine("<title>FA upload ready test</title>");
                file.WriteLine("</head>");
                file.WriteLine("<body>");
                file.WriteLine("<table cellpadding='1' cellspacing='1' border='1'>");
                file.WriteLine("<thead>");
                file.WriteLine("<tr><td rowspan='1' colspan='3'>FA upload ready test</td></tr>");
                file.WriteLine("</thead><tbody>");
                file.WriteLine("<tr>");
                file.WriteLine("	<td>openWindow</td>");
                file.WriteLine("	<td>/</td>");
                file.WriteLine("	<td></td>");
                file.WriteLine("</tr>");
                file.WriteLine("<tr>");
                file.WriteLine("	<td>waitForPopUp</td>");
                file.WriteLine("	<td></td>");
                file.WriteLine("	<td>5000</td>");
                file.WriteLine("</tr>");
                file.WriteLine("<tr>");
                file.WriteLine("	<td>selectWindow</td>");
                file.WriteLine("	<td>title=Index -- Fur Affinity [dot] net</td>");
                file.WriteLine("	<td></td>");
                file.WriteLine("</tr>");
                file.WriteLine("<tr>");
                file.WriteLine("	<td>clickAndWait</td>");
                file.WriteLine("	<td>link=Submit</td>");
                file.WriteLine("	<td></td>");
                file.WriteLine("</tr>");
                file.WriteLine("<tr>");
                file.WriteLine("	<td>clickAndWait</td>");
                file.WriteLine("	<td>css=input.button</td>");
                file.WriteLine("	<td></td>");
                file.WriteLine("</tr>");
                file.WriteLine("<tr>");
                file.WriteLine("	<td>type</td>");
                file.WriteLine("	<td>name=submission</td>");
                file.WriteLine($"	<td>{model.FilePath}</td>");
                file.WriteLine("</tr>");
                file.WriteLine("<tr>");
                file.WriteLine("	<td>clickAndWait</td>");
                file.WriteLine("	<td>css=input.button</td>");
                file.WriteLine("	<td></td>");
                file.WriteLine("</tr>");
                file.WriteLine("<tr>");
                file.WriteLine("	<td>type</td>");
                file.WriteLine("	<td>name=title</td>");
                file.WriteLine($"	<td>{model.Title}</td>");
                file.WriteLine("</tr>");
                file.WriteLine("<tr>");
                file.WriteLine("	<td>type</td>");
                file.WriteLine("	<td>id=JSMessage</td>");
                file.WriteLine($"	<td>{model.Description}</tr>");
                file.WriteLine("<tr>");
                file.WriteLine("	<td>type</td>");
                file.WriteLine("	<td>id=keywords</td>");
                string concatenatedTags = "";
                foreach (string tag in model.Tags)
                {
                    concatenatedTags += tag.Replace(" ", "_")+" ";
                }
                file.WriteLine($"	<td>{concatenatedTags}</td>");

                if (model.AgeRating == ArtUploadModel.ContentRating.General||model.AgeRating ==ArtUploadModel.ContentRating.Teen) {
                    file.WriteLine("<tr>");
                    file.WriteLine("	<td>click</td>");
                    file.WriteLine("	<td>id=rating-type-general</td>");
                    file.WriteLine("	<td></td>");
                    file.WriteLine("</tr>");
                }
                else if (model.AgeRating == ArtUploadModel.ContentRating.Mature)
                {
                    file.WriteLine("<tr>");
                    file.WriteLine("	<td>click</td>");
                    file.WriteLine("	<td>id=rating-type-mature</td>");
                    file.WriteLine("	<td></td>");
                    file.WriteLine("</tr>");
                }
                else if (model.AgeRating == ArtUploadModel.ContentRating.Adult)
                {
                    file.WriteLine("<tr>");
                    file.WriteLine("	<td>click</td>");
                    file.WriteLine("	<td>id=rating-type-adult</td>");
                    file.WriteLine("	<td></td>");
                    file.WriteLine("</tr>");
                }
                file.WriteLine("</tbody></table>");
                file.WriteLine("</body>");
                file.WriteLine("</html>");
            }

        }
    }
}