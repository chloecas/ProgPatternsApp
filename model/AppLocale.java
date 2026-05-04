package app.model;

import java.util.Locale;
import java.util.ResourceBundle;

public class AppLocale {
    private static Locale locale = Locale.getDefault();
    private static ResourceBundle bundle = ResourceBundle.getBundle("i18n.messages", locale);

    public static void setLocale(Locale newLocale){
        locale= newLocale;
        bundle = ResourceBundle.getBundle("i18n.messages", locale);
    }

    public static Locale getLocale() {
        return locale;
    }

    public static ResourceBundle getBundle() {
        return bundle;
    }
}
