package ca.nsyse;

import java.util.ArrayList;

/**
 * Created by Nsyse on 2016-03-30.
 */
public class SeleniumTestSuiteGenerator {

    protected ArrayList<GeneratesTest> seleniumGenerators = new ArrayList<>();;

    public SeleniumTestSuiteGenerator(){
    }

    protected void generateSeleniumScripts(ArrayList<String> websitesNames) {
            for (GeneratesTest generator : seleniumGenerators) {
                    generator.overwriteSeleniumTest();
            }
    }
}
