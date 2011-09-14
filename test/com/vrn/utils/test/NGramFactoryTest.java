/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.vrn.utils.test;

import java.util.List;
import org.junit.*;
import com.vrn.utils.NGram;
import com.vrn.utils.NGramFactory;
import org.junit.Assert.*;

/**
 *
 * @author vedam
 */
public class NGramFactoryTest {
    @Test
    public void parsedNGramsTest() {
        String inputText = "The dog was sick.";
        String[] tokens = inputText.replaceAll("\\.", "").split(" ");

        // TEST 1 bi-gram test
        List<NGram<String>> ngrams = NGramFactory.parseNgrams(tokens, 2);

        // since this creates only 3 bi-grams this makes it easy to not
        // having to do any looping.
        Assert.assertEquals(2, ngrams.get(0).getTupleSize());
        Assert.assertEquals("The", ngrams.get(0).getTuple().get(0));
        Assert.assertEquals("dog", ngrams.get(0).getTuple().get(1));

        Assert.assertEquals("dog", ngrams.get(1).getTuple().get(0));
        Assert.assertEquals("was", ngrams.get(1).getTuple().get(1));

        Assert.assertEquals("was", ngrams.get(2).getTuple().get(0));
        Assert.assertEquals("sick", ngrams.get(2).getTuple().get(1));
    }
}
