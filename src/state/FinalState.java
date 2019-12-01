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
public abstract class FinalState extends State{

    @Override
    public String toString() {
        return "Final state: "; //To change body of generated methods, choose Tools | Templates.
    }

    
    
    
    
    @Override
    protected abstract void showOptions(Paper paper);
    
}
