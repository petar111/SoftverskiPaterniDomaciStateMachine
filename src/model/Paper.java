/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import state.ReviewState;
import state.State;
import state.WritingState;

/**
 *
 * @author student1
 */
public class Paper {

    private State state;

    public Paper() {
        state = new WritingState();
    }

    public State getCurrentState() {
        return state;
    }

    public void doSomethingOnState() {
        state.doSomething(this);
    }

    public void goToState(State newState) {
        state = newState;
    }

}
