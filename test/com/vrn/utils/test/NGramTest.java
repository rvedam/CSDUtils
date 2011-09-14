/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.vrn.utils.test;

import junit.framework.TestCase;
import com.vrn.utils.NGram;
import com.vrn.utils.NGramFactory;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


/**
 *
 * @author vedam
 */


public class NGramTest {
    protected NGram<String> ngram;
    protected List< NGram<String> > ngrams;
    
    @Before
    public void setUp() {
        ngram = new NGram<String>(2);
        ngrams = new ArrayList<NGram<String>>();
    }

    @Test
    public void constructorTest() {
        assertNotNull(ngram);
    }

    @Test
    public void parsedNGramsTest() {
        String inputText = "The dog was sick.";
        String[] tokens = inputText.replaceAll("\\.", "").split(" ");

        // TEST 1 bi-gram test
        ngrams = NGramFactory.parseNgrams(tokens, 2);
    }

    @After
    public void tearDown() {

    }
}
