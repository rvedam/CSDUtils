/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.vrn.utils;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vedam
 */
public class NGramFactory {
    /* class methods */
    // TODO: may need to generalize this a bit more.
    public static List<NGram<String>> parseNgrams(String[] tokens, int tupleSize){
        List<NGram<String>> result = new ArrayList<NGram<String>>();
        for(int i = 0; i < tokens.length; i++) {
            NGram<String> ngram = new NGram<String>(tupleSize);
            for(int j = 0, k = i; j < tupleSize && k < tokens.length; j++, k++) {
                ngram.getTuple().add(tokens[k]);
            }

            if(ngram.isCompleteNGram()) {
                result.add(ngram);
            }
        }
        return result;
    }
}
