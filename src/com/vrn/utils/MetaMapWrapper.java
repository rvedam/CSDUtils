/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.vrn.utils;

import gov.nih.nlm.nls.metamap.ConceptPair;
import gov.nih.nlm.nls.metamap.Ev;
import gov.nih.nlm.nls.metamap.MetaMapApi;
import gov.nih.nlm.nls.metamap.MetaMapApiImpl;
import gov.nih.nlm.nls.metamap.PCM;
import gov.nih.nlm.nls.metamap.Result;
import gov.nih.nlm.nls.metamap.Utterance;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Sole purpose of this object is to create a wrapper class around the
 * MetaMap API so that
 * @author Ramnarayan Vedam
 */
public class MetaMapWrapper {
    private MetaMapApi api;

    /**
     * constructs a wrapper object around MetaMap API
     * @param host - IP or host's name
     * @param port
     */
    public MetaMapWrapper(String host, int port) {
        this.api = new MetaMapApiImpl();
        this.api.setHost(host);
        this.api.setPort(port);
    }

    /**
     * wrapper to grab UMLS concepts from MetaMap
     *
     * @param inputText - text to query UMLS Concepts for
     * @return a List of MetaMap Result objects containing the candidate
     * mappings
     */
    public List<Result> retrieveConcepts(String inputText) {
        List<Result> results = this.api.processCitationsFromString(inputText);
        return results;
    }

    /**
     *
     * @param result
     * @return
     */
    public List<Ev> retrieveCandidates(Result res) {
        try {
            List<Ev> results = new ArrayList<Ev>();
            for (Utterance utterance : res.getUtteranceList()) {
                for (PCM pcm : utterance.getPCMList()) {
                    results.addAll(pcm.getCandidateList());
                }
            }
            return results;
        } catch (Exception ex) {
            Logger.getLogger(MetaMapWrapper.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    /**
     * 
     * @param results
     * @return
     */
    public List<Ev> retrieveCandidates(List<Result> results) {
        try {
            List<Ev> candidates = new ArrayList<Ev>();
            for(Result result: results) {
                for(Utterance utterance : result.getUtteranceList()) {
                    for(PCM pcm : utterance.getPCMList()) {
                        candidates.addAll(pcm.getCandidateList());
                    }
                }
            }
            return candidates;
        } catch(Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
