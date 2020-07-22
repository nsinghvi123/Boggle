package com.boggle;
import org.junit.Assert;
import org.junit.Test;

import static com.boggle.WordPrefixCalculator.checkIsWordPrefix;

public class TestWordPrefix {

    @Test
    public void test_IsWordPrefix() {
        WordPrefixCalculator wordPrefixCalculator = new WordPrefixCalculator("/Users/natashasinghvi/Documents/boggle/boggle-backend/boggle-lib/src/main/java/com/boggle/popularWords.txt");
        Assert.assertEquals(wordPrefixCalculator.checkIsWordPrefix("do"), true);
        Assert.assertEquals(wordPrefixCalculator.checkIsWordPrefix("th"), true);
        Assert.assertEquals(wordPrefixCalculator.checkIsWordPrefix("tk"), false);

    }
}
