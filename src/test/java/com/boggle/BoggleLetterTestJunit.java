package com.boggle;

import org.junit.Assert;
import org.junit.Test;

public class BoggleLetterTestJunit {

    @Test
    public void test_BoggleLetterGetters() {
        BoggleLetter boggleLetter = new BoggleLetter(2, 1, 'd');
        Assert.assertEquals(boggleLetter.getRow(), 2);
        Assert.assertEquals(boggleLetter.getCol(), 1);
        Assert.assertEquals(boggleLetter.getVal(), 'd');
    }
}
