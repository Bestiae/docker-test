package com.capco.expensesapp.enums;

import org.hibernate.validator.constraints.Currency;

import javax.validation.Payload;
import java.lang.annotation.Annotation;

/*
* this is the test of the currency for this application. You need to figure out how to use it in this applicaiton.
* in choose section, you need to choose currency which will be your choice.
*/
public class Test implements Currency {
    @Override
    public String message() {
        return null;
    }

    @Override
    public Class<?>[] groups() {
        return new Class[0];
    }

    @Override
    public Class<? extends Payload>[] payload() {
        return new Class[0];
    }

    @Override
    public String[] value() {
        return new String[0];
    }

    @Override
    public Class<? extends Annotation> annotationType() {
        return null;
    }
}
