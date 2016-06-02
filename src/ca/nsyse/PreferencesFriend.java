package ca.nsyse;

import java.util.prefs.Preferences;

/**
 * Created by noxid on 02/06/16.
 */
public class PreferencesFriend {

    public enum PREF_KEY {
        SELENIUM_SCRIPT_OUTPUT_DIR,
        IMAGE_DEFAULT_DIR,
        DEFAULT_UPLOAD_SITES,
    }

    private static final Preferences prefs = Preferences.userNodeForPackage(ca.nsyse.SeleniumTestSuiteGenerator.class);

    public static String getString(PREF_KEY key, String d) {
        return prefs.get(key.toString(), d);
    }

    public static void set(PREF_KEY key, String val) {
        prefs.put(key.toString(), val);
    }
}
