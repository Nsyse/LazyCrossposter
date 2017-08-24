using System;
using LazySharper.FormModel;
using static LazySharper.FormModel.ArtUploadModel;

namespace LazySharper
{
    internal class WeasylArtGenerator : ArtUploadTestGenerator
    {
        public override void GenerateSeleniumTest(ArtUploadModel model)
        {
            using (System.IO.StreamWriter file = new System.IO.StreamWriter(@"Output\Weasyl upload_ready_test.html"))
            {
                file.WriteLine(@"<?xml version=""1.0"" encoding=""UTF-8""?>");
                file.WriteLine(@"<!DOCTYPE html PUBLIC ""-//W3C//DTD XHTML 1.0 Strict//EN"" ""http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd"">");
                file.WriteLine(@"<html xmlns=""http://www.w3.org/1999/xhtml"" xml:lang=""en"" lang=""en"">");
                file.WriteLine(@"<head profile=""http://selenium-ide.openqa.org/profiles/test-case"">");
                file.WriteLine(@"<meta http-equiv=""Content-Type"" content=""text/html; charset=UTF-8"" />");
                file.WriteLine(@"<link rel=""selenium.base"" href=""https://www.weasyl.com/"" />");
                file.WriteLine(@"<title>Weasyl upload ready test</title>");
                file.WriteLine(@"</head>");
                file.WriteLine(@"<body>");
                file.WriteLine(@"<table cellpadding=""1"" cellspacing=""1"" border=""1"">");
                file.WriteLine(@"<thead>");
                file.WriteLine(@"<tr><td rowspan=""1"" colspan=""3"">Weasyl upload ready test</td></tr>");
                file.WriteLine(@"</thead><tbody>");
                file.WriteLine(@"<tr>");
                file.WriteLine(@"	<td>openWindow</td>");
                file.WriteLine(@"	<td>/</td>");
                file.WriteLine(@"	<td></td>");
                file.WriteLine(@"</tr>");
                file.WriteLine(@"<tr>");
                file.WriteLine(@"	<td>waitForPopUp</td>");
                file.WriteLine(@"	<td></td>");
                file.WriteLine(@"	<td>5000</td>");
                file.WriteLine(@"</tr>");
                file.WriteLine(@"<tr>");
                file.WriteLine(@"	<td>selectWindow</td>");
                file.WriteLine(@"	<td>title=Home &#x2014; Weasyl</td>");
                file.WriteLine(@"	<td></td>");
                file.WriteLine(@"</tr>");
                file.WriteLine(@"<tr>");
                file.WriteLine(@"	<td>waitForVisible</td>");
                file.WriteLine(@"	<td>link=Submit</td>");
                file.WriteLine(@"	<td></td>");
                file.WriteLine(@"</tr>");
                file.WriteLine(@"<tr>");
                file.WriteLine(@"	<td>clickAndWait</td>");
                file.WriteLine(@"	<td>link=Submit</td>");
                file.WriteLine(@"	<td></td>");
                file.WriteLine(@"</tr>");
                file.WriteLine(@"<tr>");
                file.WriteLine(@"	<td>clickAndWait</td>");
                file.WriteLine(@"	<td>link=Visual</td>");
                file.WriteLine(@"	<td></td>");
                file.WriteLine(@"</tr>");
                file.WriteLine(@"<tr>");
                file.WriteLine(@"	<td>type</td>");
                file.WriteLine(@"	<td>id=submitfile</td>");
                file.WriteLine(@"	<td>"+model.FilePath+@"</td>");
                file.WriteLine(@"</tr>");
                file.WriteLine(@"<tr>");
                file.WriteLine(@"	<td>type</td>");
                file.WriteLine(@"	<td>id=submissiontitle</td>");
                file.WriteLine(@"	<td>"+model.Title+@"</td>");
                file.WriteLine(@"</tr>");
                file.WriteLine(@"<tr>");
                file.WriteLine(@"	<td>type</td>");
                file.WriteLine(@"	<td>id=submissiondesc</td>");
                file.WriteLine(@"	<td>"+model.Description+@"</td>");
                file.WriteLine(@"</tr>");
                file.WriteLine(@"<tr>");
                file.WriteLine(@"	<td>waitForVisible</td>");
                file.WriteLine(@"	<td>//form[@id='submit-form']/div[4]/ul/li/input</td>");
                file.WriteLine(@"	<td></td>");
                file.WriteLine(@"</tr>");
                file.WriteLine(@"<tr>");
                file.WriteLine(@"	<td>click</td>");
                file.WriteLine(@"	<td>//form[@id='submit-form']/div[4]/ul/li/input</td>");
                file.WriteLine(@"	<td></td>");
                file.WriteLine(@"</tr>");
                file.WriteLine(@"<tr>");
                file.WriteLine(@"	<td>type</td>");
                file.WriteLine(@"	<td>//form[@id='submit-form']/div[4]/ul/li/input</td>");
                String concatenatedString = "";
                foreach (String tag in model.Tags)
                {
                    concatenatedString += tag.Replace(" ", "_") + " ";
                }
                file.WriteLine(@"	<td>"+concatenatedString+@"</td>");
                file.WriteLine(@"</tr>");
                file.WriteLine(@"<tr>");
                file.WriteLine(@"	<td>select</td>");
                file.WriteLine(@"	<td>id=submissionrating</td>");
                if (model.AgeRating == ContentRating.General)
                {
                    file.WriteLine(@"	<td>label=General</td>");
                }
                else if (model.AgeRating == ContentRating.Teen)
                {
                    file.WriteLine(@"	<td>label=Moderate (13+)</td>");
                }
                else if (model.AgeRating == ContentRating.Mature)
                {
                    file.WriteLine(@"	<td>label=Mature (18+ non-sexual)</td>");
                }
                else if (model.AgeRating == ContentRating.Adult)
                {
                    file.WriteLine(@"	<td>label=Explicit (18+ sexual)</td>");
                }
                file.WriteLine(@"</tr>");
                file.WriteLine(@"</tbody></table>");
                file.WriteLine(@"</body>");
                file.WriteLine(@"</html>");
            }

        }
    }
}