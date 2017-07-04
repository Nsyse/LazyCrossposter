using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LazySharper
{
    class SuiteGenerator
    {
        public List<string> ActiveSites { get; private set; }

        public void GenerateSuite(List<string> activeSites)
        {
            ActiveSites = activeSites;
            generateSuiteDoc();
            generateTestsDocs();
        }

        private void generateTestsDocs()
        {
            if (ActiveSites.Contains("DA"))
            {

            }
        }

        private void generateSuiteDoc()
        {
            using (System.IO.StreamWriter file = new System.IO.StreamWriter(@"Output\UploadArtSuite.html"))
            {
                file.WriteLine("<?xml version=\"1.0\" encoding=\"UTF - 8\"?>");
                file.WriteLine("<!DOCTYPE html PUBLIC \" -//W3C//DTD XHTML 1.0 Strict//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">");
                file.WriteLine("<html xmlns=\"http://www.w3.org/1999/xhtml\" xml:lang=\"en\" lang=\"en\">");
                file.WriteLine("<head>");
                file.WriteLine("  <meta content=\"text / html; charset = UTF - 8\" http-equiv=\"content - type\" />");
                file.WriteLine("  <title>Test Suite</title>");
                file.WriteLine("</head>");
                file.WriteLine("<body>");
                file.WriteLine("<table id=\"suiteTable\" cellpadding=\"1\" cellspacing=\"1\" border=\"1\" class=\"selenium\"><tbody>");
                file.WriteLine("<tr><td><b>Test Suite</b></td></tr>");

                if (ActiveSites.Contains("DA"))
                {
                    file.WriteLine("<tr><td><a href=\"DA.html\">TestSuite_DA</a></td></tr>");
                }

                file.WriteLine("</tbody></table>");
                file.WriteLine("</body>");
                file.WriteLine("</html>");
            }
        }
    }
}
