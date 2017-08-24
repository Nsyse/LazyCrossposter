using System;
using LazySharper.FormModel;

namespace LazySharper
{
    internal class DAArtGenerator : ArtUploadTestGenerator
    {
        public override void GenerateSeleniumTest(ArtUploadModel model)
        {
            using (System.IO.StreamWriter file = new System.IO.StreamWriter(@"Output\DA upload_ready_test.html"))
            {
                file.WriteLine(@"<?xml version=""1.0"" encoding=""UTF-8""?>");
                file.WriteLine(@"<!DOCTYPE html PUBLIC ""-//W3C//DTD XHTML 1.0 Strict//EN"" ""http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd"">");
                file.WriteLine(@"<html xmlns=""http://www.w3.org/1999/xhtml"" xml:lang=""en"" lang=""en"">");
                file.WriteLine(@"<head profile=""http://selenium-ide.openqa.org/profiles/test-case"">");
                file.WriteLine(@"<meta http-equiv=""Content-Type"" content=""text/html; charset=UTF-8"" />");
                file.WriteLine(@"<link rel=""selenium.base"" href=""http://www.deviantart.com/"" />");
                file.WriteLine(@"<title>DA upload ready test</title>");
                file.WriteLine(@"</head>");
                file.WriteLine(@"<body>");
                file.WriteLine(@"<table cellpadding=""1"" cellspacing=""1"" border=""1"">");
                file.WriteLine(@"<thead>");
                file.WriteLine(@"<tr><td rowspan=""1"" colspan=""3"">DATest</td></tr>");
                file.WriteLine(@"</thead><tbody>");
                file.WriteLine(@"<tr>");
                file.WriteLine(@"	<td>open</td>");
                file.WriteLine(@"	<td>/newest/</td>");
                file.WriteLine(@"	<td></td>");
                file.WriteLine(@"</tr>");
                file.WriteLine(@"<tr>");
                file.WriteLine(@"	<td>clickAndWait</td>");
                file.WriteLine(@"	<td>css=a.oh-l.oh-touch &gt; span</td>");
                file.WriteLine(@"	<td></td>");
                file.WriteLine(@"</tr>");
                file.WriteLine(@"<tr>");
                file.WriteLine(@"	<td>selectFrame</td>");
                file.WriteLine(@"	<td>deviation-0</td>");
                file.WriteLine(@"	<td></td>");
                file.WriteLine(@"</tr>");
                file.WriteLine(@"<tr>");
                file.WriteLine(@"	<td>waitForVisible</td>");
                file.WriteLine(@"	<td>name=file</td>");
                file.WriteLine(@"	<td></td>");
                file.WriteLine(@"</tr>");
                file.WriteLine(@"<tr>");
                file.WriteLine(@"	<td>type</td>");
                file.WriteLine(@"	<td>name=file</td>");
                file.WriteLine(@"	<td>"+model.FilePath+@"</td>");
                file.WriteLine(@"</tr>");
                file.WriteLine(@"<tr>");
                file.WriteLine(@"	<td>type</td>");
                file.WriteLine(@"	<td>id=devtitle</td>");
                file.WriteLine(@"	<td>"+model.Title+@"</td>");
                file.WriteLine(@"</tr>");
                file.WriteLine(@"");
                file.WriteLine(@"</tbody></table>");
                file.WriteLine(@"</body>");
                file.WriteLine(@"</html>");
            }
            //TODO : add mature ratings

        }
    }
}