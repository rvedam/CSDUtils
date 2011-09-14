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
    
    @Before
    public void setUp() {
        ngram = new NGram<String>(2);
        ngram.getTuple().add("the");
        ngram.getTuple().add("dog");
    }

    @Test
    public void constructorTest() {
        assertNotNull(ngram);
    }

    @Test
    public void tupleSizeTest() {
        assertEquals(2, ngram.getTupleSize());
    }

    @Test
    public void tupleTest() {
        assertEquals("the", ngram.getTuple().get(0));
        assertEquals("dog", ngram.getTuple().get(1));
    }

    @Test
    public void isCompleteTest() {
        // TEST 1: make sure the currently constructed bi-gram
        // is correctly a bi-gram.
        assertEquals(true, ngram.isCompleteNGram());

        // TEST 2: empty the bi-gram tuple and then check it appropriately
        // fails.
        ngram.getTuple().removeAll(ngram.getTuple());
        assertEquals(false, ngram.isCompleteNGram());
    }

    @After
    public void tearDown() {
        ngram = null;
    }
}
