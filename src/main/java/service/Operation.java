/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package service;

/**
 *
 * @author luciuses
 */
public enum Operation {
    plus(" + "), minus(" - "), divide(" / "), multiply(" * "), square_root_1arg("square root");
    
    private Operation(final String text) {
        this.text = text;
    }
   
    private final String text;

    @Override
    public String toString() {
        return text;
    }
}
