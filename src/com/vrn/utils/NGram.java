/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.vrn.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Produces N-grams for given piece of input text.
 * Generic class as n-grams can be characters or words
 *
 * @author vedam
 */
public class NGram<T> {
    private int tupleSize;
    private List<T> tuple;

    /* instance methods */
    public NGram(int tupleSize) {
        this.tupleSize = tupleSize;
        this.tuple = new ArrayList<T>();
    }

    public int getTupleSize() {
        return this.tupleSize;
    }

    public List<T> getTuple() {
        return this.tuple;
    }

    /**
     * checks to see if ngram tuple is the length of the specified ngram tuple
     * size
     * @return
     */
    public boolean isCompleteNGram() {
        return (this.tupleSize == this.tuple.size());
    }
}
