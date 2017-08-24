using System;
using System.IO;
using LazySharper.FormModel;

namespace LazySharper.ArtGens
{
    public class SoFurryArtGenerator : ArtUploadTestGenerator
    {
        public override void GenerateSeleniumTest(ArtUploadModel model)
        {
            using (StreamWriter file = new StreamWriter(@"Output\SoFurry upload_ready_test.html"))
            {
                file.WriteLine("<?xml version='1.0' encoding='UTF-8'?>");
                file.WriteLine(@"<!DOCTYPE html PUBLIC ""-//W3C//DTD XHTML 1.0 Strict//EN"" ""http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd"">");
                file.WriteLine("<html xmlns='http://www.w3.org/1999/xhtml' xml:lang='en' lang='en'>");
                file.WriteLine("<head profile='http://selenium-ide.openqa.org/profiles/test-case'>");
                file.WriteLine("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8' />");
                file.WriteLine("<link rel='selenium.base' href='https://www.sofurry.com/' />");
                file.WriteLine("<title>SoFurry test</title>");
                file.WriteLine("</head>");
                file.WriteLine("<body>");
                file.WriteLine("<table cellpadding='1' cellspacing='1' border='1'>");
                file.WriteLine("<thead>");
                file.WriteLine("<tr><td rowspan='1' colspan='3'>SoFurry test</td></tr>");
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
                file.WriteLine("	<td>title=SoFurry - The furry creativity home</td>");
                file.WriteLine("	<td></td>");
                file.WriteLine("</tr>");
                file.WriteLine("<tr>");
                file.WriteLine("	<td>clickAndWait</td>");
                file.WriteLine("	<td>link=Upload</td>");
                file.WriteLine("	<td></td>");
                file.WriteLine("</tr>");
                file.WriteLine("<tr>");
                file.WriteLine("	<td>clickAndWait</td>");
                file.WriteLine("	<td>css=a.sf-upload-1-contenttype-choice.sf-upload-1-contenttype-choice-1</td>");
                file.WriteLine("	<td></td>");
                file.WriteLine("</tr>");
                file.WriteLine("<tr>");
                file.WriteLine("	<td>type</td>");
                file.WriteLine("	<td>id=UploadForm_binarycontent</td>");
                file.WriteLine($"	<td>{model.FilePath}</td>");
                file.WriteLine("</tr>");
                file.WriteLine("<tr>");
                file.WriteLine("	<td>type</td>");
                file.WriteLine("	<td>id=UploadForm_P_title</td>");
                file.WriteLine($"	<td>{model.Title}</td>");
                file.WriteLine("</tr>");
                file.WriteLine("<tr>");
                file.WriteLine("	<td>type</td>");
                file.WriteLine("	<td>id=UploadForm_description</td>");
                file.WriteLine($"	<td>{model.Description}</td>");
                file.WriteLine("</tr>");
                file.WriteLine("<tr>");
                file.WriteLine("	<td>type</td>");
                file.WriteLine("	<td>id=sf-upload-tags</td>");
                file.WriteLine($"	<td>{string.Join(",", model.Tags)}</td>");
                file.WriteLine("</tr>");
                file.WriteLine("<tr>");
                file.WriteLine("	<td>click</td>");
                if(model.AgeRating == ArtUploadModel.ContentRating.General||model.AgeRating == ArtUploadModel.ContentRating.Teen)
                {
                    file.WriteLine("	<td>id=UploadForm_contentLevel_0</td>");
                }
                else if (model.AgeRating == ArtUploadModel.ContentRating.Mature)
                {
                    file.WriteLine("	< td > id = UploadForm_contentLevel_1 </ td >");
                }
                else if (model.AgeRating == ArtUploadModel.ContentRating.Adult)
                {
                    file.WriteLine("	< td > id = UploadForm_contentLevel_2 </ td >");
                }
                file.WriteLine(" < td></td>");
                file.WriteLine("</tr>");
                file.WriteLine("</tbody></table>");
                file.WriteLine("</body>");
                file.WriteLine("</html>");
            }

        }
    }
}