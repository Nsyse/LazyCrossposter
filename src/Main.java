import Generators.PathChooser;

import java.io.*;

/**
 * Created by Nsyse on 2016-03-26.
 */
public class Main {
    public static void main(String[] args) {
        FormChoosingFrame fCF = new FormChoosingFrame();
        //generateSeleniumCodeGenerator("general");
   }

    /**
     * A function that takes a selenium script and generates the java code that would generate the script
     * Yes, I'm that lazy.
     * @param seleniumScriptName
     */
    public static void generateSeleniumCodeGenerator(String seleniumScriptName){

        BufferedReader br=null;
        try {
            br = new BufferedReader(new FileReader(PathChooser.getDefaultPath()+seleniumScriptName+".html"));
            String line = br.readLine();

            BufferedWriter outStream = new BufferedWriter(new FileWriter("Output/output.txt"));
            while (line != null) {
                line = line.replace("\"", "\\\"");
                outStream.write("outStream.write(\""+line+"\");");
                outStream.newLine();
                outStream.write("outStream.newLine();");
                outStream.newLine();
                line = br.readLine();
            }
            outStream.close();
        }catch (IOException ioe){
            ioe.printStackTrace();
        }
        finally {
            try {
                br.close();
            }catch (IOException ioe){
                ioe.printStackTrace();
            }
        }
    }
}
