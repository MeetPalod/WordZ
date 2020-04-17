/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dict.servlets;

/**
 *
 * @author HP
 */
public class Thesu {
        int synonym_id; 
        int word_id; 
        String synonym;
        
        public Thesu() {}
        
    public void setSynonym_id(int synonym_id) {
        this.synonym_id = synonym_id;
    }

    public void setWord_id(int word_id) {
        this.word_id = word_id;
    }

    public void setSynonym(String synonym) {
        this.synonym = synonym;
    }
    
}
