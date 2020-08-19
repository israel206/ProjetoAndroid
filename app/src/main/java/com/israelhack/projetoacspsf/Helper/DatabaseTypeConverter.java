package com.israelhack.projetoacspsf.Helper;

/**
 *
 * @author Israel
 */

public class DatabaseTypeConverter {

    public static int booleanToInt(boolean valor) {
        int convertido;
        if (valor == true) {
            convertido = 1;
        } else {
            convertido = 0;
        }
        return convertido;
    }
}
