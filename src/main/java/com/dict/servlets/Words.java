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
public class Words{
        String word; 
        String definition; 
        String wordtype;

    public Words() {}
       

        public void setWord(String word) {
            this.word = word;
        }

        public void setDefination(String defination) {
            this.definition = defination;
        }

        public void setWordtype(String wordtype) {
            this.wordtype = wordtype;
        }
        
        
    }
