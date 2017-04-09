package com.qkjt.qkkt.common.utils;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;


public class I18n {

    private static final String I18n_PATH = "properties/message";

    public static final Locale locale = Locale.getDefault();

    public static final ResourceBundle rb = ResourceBundle.getBundle(I18n_PATH, locale);

    public static String m(String key, Object... o){
        return MessageFormat.format(rb.getString(key),o);
    }
   
}
