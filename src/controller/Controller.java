/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.logging.Level;
import java.util.logging.Logger;
import machine.StateMachine;
import state.State;

/**
 *
 * @author siux
 */
public class Controller {
    
    private static Controller instance;
    private final StateMachine stateMachine;
    
    private Controller(){
        stateMachine = new StateMachine();
        stateMachine.setStateTransitions();
    }
    
    public static Controller Instance(){
        if(instance == null){
            instance = new Controller();
        }
        return instance;
    }

    public void transiteStateMachine(State newState) throws Exception {
        
        try {
            stateMachine.transiteToNextState(stateMachine.getStateIndex(newState));
            
            stateMachine.setStateTransitions();
            
        } catch (Exception ex) {
            
            throw new Exception("");
        }
        
    }
    
    
    

    public StateMachine getStateMachine() {
        return stateMachine;
    }
    
    
    
    
    
    
}
