package com.boggle;
import org.junit.Assert;
import org.junit.Test;

import static com.boggle.FullWordCalculator.checkIsWordFull;


public class FullWordTest {

    @Test
    public void testFullWordCalculator() {
        Assert.assertEquals(checkIsWordFull("dog"), true);
        Assert.assertEquals(checkIsWordFull("that"), true);
        Assert.assertEquals(checkIsWordFull("pear"), false);

    }
}
