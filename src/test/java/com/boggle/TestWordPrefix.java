package com.boggle;
import org.junit.Assert;
import org.junit.Test;

import static com.boggle.WordPrefixCalculator.checkIsWordPrefix;

public class TestWordPrefix {

    @Test
    public void test_IsWordPrefix() {
        Assert.assertEquals(checkIsWordPrefix("do"), true);
        Assert.assertEquals(checkIsWordPrefix("th"), true);
        Assert.assertEquals(checkIsWordPrefix("tk"), false);

    }
}
