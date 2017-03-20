package com.hc.core.annotation.impl;

import com.hc.core.annotation.CheckEmail;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by milk.huchan on 2017/3/13.
 */
public class CheckEmailImpl implements ConstraintValidator<CheckEmail, String> {
    private String regexp;

    @Override
    public void initialize(CheckEmail checkEmail) {
        this.regexp = checkEmail.regexp();
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (s == null) {
            return true;
        }
        if (s.matches(regexp)) {
            return true;
        }
        return false;
    }
}
