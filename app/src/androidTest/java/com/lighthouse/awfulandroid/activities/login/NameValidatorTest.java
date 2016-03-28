package com.lighthouse.awfulandroid.activities.login;

import junit.framework.TestCase;

public class NameValidatorTest extends TestCase {

    public void testCheckNameReturnsTrueWhenNameEnteredFirstDotLast() throws Exception {
        assertTrue(NameValidator.checkName("william.do"));
    }

    public void testCheckNameReturnsFalseWhenNameEnteredFirstLast() throws Exception {
        assertFalse(NameValidator.checkName("williamDo"));
    }

    public void testCheckNameReturnsFalseWhenNameEnteredContainsExtraWhiteSpace() throws Exception {
        assertFalse(NameValidator.checkName("     william.do    "));
    }

    public void testCheckNameReturnsFalseWhenMiddleNameAlsoEntered() throws Exception {
        assertFalse(NameValidator.checkName("tom.will.go"));
    }
}