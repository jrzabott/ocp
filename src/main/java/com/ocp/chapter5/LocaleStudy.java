package com.ocp.chapter5;

import java.util.Locale;

public class LocaleStudy {

    public static final Locale SYSTEM_DEFAULT_LOCALE = Locale.getDefault();

    public static void main(String[] args) {
        LocaleStudy l = new LocaleStudy();
        l.printSystemDefault();

        final Locale currentDefaultLocale = l.setAnotherDefaultLocale();
        System.out.println("Setting another default locale: " + currentDefaultLocale);
        l.printSystemDefault();

        final Locale previousLocalel = l.revertToDefaultLocale();
        System.out.println("Reverting to default locale: " + previousLocalel);
        l.printSystemDefault();
    }

    private Locale revertToDefaultLocale() {
        final Locale result = Locale.getDefault();
        Locale.setDefault(SYSTEM_DEFAULT_LOCALE);
        return result;
    }

    private Locale setAnotherDefaultLocale() {
        Locale.setDefault(Locale.FRANCE);
        return SYSTEM_DEFAULT_LOCALE;
    }

    private void printSystemDefault() {
        final Locale aDefault = Locale.getDefault();
        System.out.println(aDefault);
    }
}
