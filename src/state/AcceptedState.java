/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package state;

import model.Paper;

/**
 *
 * @author student1
 */
public class AcceptedState extends FinalState {

    @Override
    public String toString() {
        return super.toString() + "Accepted state"; //To change body of generated methods, choose Tools | Templates.

    }

    @Override
    protected void showOptions(Paper paper) {
        System.out.println("Final state: " + this);
    }

    
}
