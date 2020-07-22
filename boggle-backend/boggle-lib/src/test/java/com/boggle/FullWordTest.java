package com.boggle;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class FullWordTest {

    @Test
    public void testFullWordCalculator() throws IOException  {
        FullWordCalculator fullWordCalculator = new FullWordCalculator("/Users/natashasinghvi/Documents/boggle/boggle-backend/boggle-lib/src/main/java/com/boggle/popularWords.txt");
        Assert.assertEquals(fullWordCalculator.checkIsWordFull("dog"), true);
        Assert.assertEquals(fullWordCalculator.checkIsWordFull("that"), true);
        Assert.assertEquals(fullWordCalculator.checkIsWordFull("pear"), false);

    }
}
