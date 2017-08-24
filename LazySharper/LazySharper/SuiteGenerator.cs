using LazySharper.FormModel;
using System.IO;

namespace LazySharper
{
    public class SuiteGenerator
    {
        public ArtUploadModel Model { get; private set; }

        public void GenerateSuite(ArtUploadModel model)
        {
            Model = model;
            GenerateSuiteDoc();
            GenerateTestsDocs();
        }

        private void GenerateTestsDocs()
        {
            if (Model.ActiveSites.Contains("DA"))
            {

            }
        }

        private void GenerateSuiteDoc()
        {
            using (StreamWriter file = new StreamWriter(@"Output\UploadArtSuite.html"))
            {
                file.WriteLine("<?xml version='1.0' encoding='UTF - 8'?>");
                file.WriteLine(@"<!DOCTYPE html PUBLIC "" -//W3C//DTD XHTML 1.0 Strict//EN\"" ""http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\"">");
                file.WriteLine("<html xmlns='http://www.w3.org/1999/xhtml\' xml:lang='en' lang='en'>");
                file.WriteLine("<head>");
                file.WriteLine("  <meta content='text / html; charset = UTF - 8' http-equiv='content - type' />");
                file.WriteLine("  <title>Test Suite</title>");
                file.WriteLine("</head>");
                file.WriteLine("<body>");
                file.WriteLine("<table id='suiteTable' cellpadding='1' cellspacing='1' border='1' class='selenium'><tbody>");
                file.WriteLine("<tr><td><b>Test Suite</b></td></tr>");

                if (Model.ActiveSites.Contains(Sites.DA))
                {
                    file.WriteLine("<tr><td><a href='DA upload_ready_test.html'>Deviantart</a></td></tr>");
                }
                if (Model.ActiveSites.Contains(Sites.FA))
                {
                    file.WriteLine("<tr><td><a href='FA upload_ready_test.html'>Furaffinity upload TITLE_TEXT ready test</a></td></tr>");
                }
                if (Model.ActiveSites.Contains(Sites.SF))
                {
                    file.WriteLine("<tr><td><a href='SoFurry upload_ready_test.html'>SoFurry upload TITLE_TEXT ready test</a></td></tr>");
                }
                if (Model.ActiveSites.Contains(Sites.WS))
                {
                    file.WriteLine("<tr><td><a href='Weasyl upload_ready_test.html'>Weasyl upload TITLE_TEXT ready test</a></td></tr>");
                }
                file.WriteLine("</tbody></table>");
                file.WriteLine("</body>");
                file.WriteLine("</html>");

                MessageDialogUtils.ShowInfoMessageDialog("Selenium Generator", "Generated tests successfully");
            }
        }
    }
}
