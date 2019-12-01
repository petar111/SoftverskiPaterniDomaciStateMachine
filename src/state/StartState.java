/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package state;

import model.Paper;

/**
 *
 * @author siux
 */
public class StartState extends State{

    @Override
    public String toString() {
        return "*";
    }

    
    
    
    @Override
    protected void showOptions(Paper paper) {
        
    }
    
    
}
