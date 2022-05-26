package com.ocp.chapter5;

import java.util.ListResourceBundle;

public class Zoo_en extends ListResourceBundle {
    @Override
    protected Object[][] getContents() {
        return new Object[][]{
                {"hello", "Hello"},
                {"open", "The zoo is open"},
                {"closed", "The zoo is closed"}
        };
    }
}
