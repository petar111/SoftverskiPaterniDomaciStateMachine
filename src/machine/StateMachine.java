/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package machine;

import edu.uci.ics.jung.graph.DirectedGraph;
import edu.uci.ics.jung.graph.DirectedSparseGraph;
import edu.uci.ics.jung.graph.util.EdgeType;
import javax.swing.JPanel;
import state.AcceptedState;
import state.CancelState;
import state.RejectState;
import state.ReviewState;
import state.RewritingState;
import state.StartState;
import state.State;
import state.WritingState;
import view.components.PanelState;

/**
 *
 * @author siux
 */
public class StateMachine {
    
    private final State[] states;
    private State[] stateTransitions;
    private final int[][] transitions;
    
    
    private final DirectedGraph<State, Integer> stateMachineGraph;
    
    private final State startState;
    private int currentState = 0;
    
    public StateMachine(){
        states = new State[]{new WritingState(), new ReviewState(), new CancelState(), new AcceptedState(), new RejectState(), new RewritingState()};
        transitions = new int[][]{{0, 1, 2}, {1, 3 ,4, 5}, {}, {}, {}, {1, 2, 5}};
        startState = new StartState();
       
        
        stateMachineGraph =  makeGraph();
        
    }
    
    public void transiteToNextState(int nextStateIndex){
        currentState = nextStateIndex;
    }
    
    public State[] getStates() {
        return states;
    }

    public int[][] getTransitions() {
        return transitions;
    }

    public int getCurrentStateIndex() {
        return currentState;
    }

    public State[] getStateTransitions() {
        return stateTransitions;
    }
    
    public State getCurrentState(){
        return states[currentState];
    }
    
    public int getStateIndex(State state) throws Exception{
        for (int i = 0; i < states.length; i++) {
            if(states[i] == state){
                return i;
            }
        }
        throw new Exception("Unknown state.");
    }
    
    
    public void setStateTransitions(){
        int stateTransitionCount = transitions[currentState].length;
        State[] newStateTransitions = new State[stateTransitionCount];
        
        for (int i = 0; i < stateTransitionCount; i++) {
            newStateTransitions[i] = states[transitions[currentState][i]];
        }
        
        stateTransitions = newStateTransitions;
    }
    

    private DirectedGraph<State, Integer> makeGraph() {
        DirectedGraph<State, Integer> stateMachineGraph = new DirectedSparseGraph<>();
        int edgeCount = 0;
        
        
        stateMachineGraph.addVertex(startState);
        
        for (State state : states) {
            stateMachineGraph.addVertex(state);
        }
        
        stateMachineGraph.addEdge(edgeCount++, startState, states[0], EdgeType.DIRECTED);
        
        for (int i = 0; i < transitions.length; i++) {
            for (int j = 0; j < transitions[i].length; j++) {
                stateMachineGraph.addEdge(edgeCount++, states[i], states[transitions[i][j]], EdgeType.DIRECTED);
            }
        }
        
        return stateMachineGraph;
    }

    public DirectedGraph<State, Integer> getStateMachineGraph() {
        return stateMachineGraph;
    }

    public State getStartState() {
        return startState;
    }
    
    
    
}
