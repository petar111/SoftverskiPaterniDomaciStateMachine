/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import edu.uci.ics.jung.algorithms.layout.CircleLayout;
import edu.uci.ics.jung.algorithms.layout.Layout;
import edu.uci.ics.jung.visualization.BasicVisualizationServer;
import edu.uci.ics.jung.visualization.decorators.ToStringLabeller;
import edu.uci.ics.jung.visualization.renderers.Renderer.VertexLabel.Position;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Paint;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.event.ListDataListener;
import machine.StateMachine;
import org.apache.commons.collections15.Transformer;
import state.FinalState;
import state.State;
import view.components.PanelState;

/**
 *
 * @author siux
 */
public class FrmPaperReview extends javax.swing.JPanel {

    /**
     * Creates new form FrmPaperReview
     */
    public FrmPaperReview() {
        initComponents();
        prepareView();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlCurrentState = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblCurrentState = new javax.swing.JLabel();
        pnlChooseNewState = new javax.swing.JPanel();
        cmbStateTransitions = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        pnlStateMachine = new javax.swing.JPanel();

        setLayout(new java.awt.BorderLayout());

        jLabel1.setText("Current state:");

        lblCurrentState.setText("jLabel2");

        javax.swing.GroupLayout pnlCurrentStateLayout = new javax.swing.GroupLayout(pnlCurrentState);
        pnlCurrentState.setLayout(pnlCurrentStateLayout);
        pnlCurrentStateLayout.setHorizontalGroup(
            pnlCurrentStateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCurrentStateLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(lblCurrentState, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(83, Short.MAX_VALUE))
        );
        pnlCurrentStateLayout.setVerticalGroup(
            pnlCurrentStateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCurrentStateLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(pnlCurrentStateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblCurrentState))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        add(pnlCurrentState, java.awt.BorderLayout.PAGE_END);

        cmbStateTransitions.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbStateTransitionsActionPerformed(evt);
            }
        });

        jLabel3.setText("Choose new state");

        javax.swing.GroupLayout pnlChooseNewStateLayout = new javax.swing.GroupLayout(pnlChooseNewState);
        pnlChooseNewState.setLayout(pnlChooseNewStateLayout);
        pnlChooseNewStateLayout.setHorizontalGroup(
            pnlChooseNewStateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlChooseNewStateLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cmbStateTransitions, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(pnlChooseNewStateLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        pnlChooseNewStateLayout.setVerticalGroup(
            pnlChooseNewStateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlChooseNewStateLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(cmbStateTransitions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(213, Short.MAX_VALUE))
        );

        add(pnlChooseNewState, java.awt.BorderLayout.LINE_END);

        javax.swing.GroupLayout pnlStateMachineLayout = new javax.swing.GroupLayout(pnlStateMachine);
        pnlStateMachine.setLayout(pnlStateMachineLayout);
        pnlStateMachineLayout.setHorizontalGroup(
            pnlStateMachineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 350, Short.MAX_VALUE)
        );
        pnlStateMachineLayout.setVerticalGroup(
            pnlStateMachineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 290, Short.MAX_VALUE)
        );

        add(pnlStateMachine, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void cmbStateTransitionsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbStateTransitionsActionPerformed
        State newState = (State)cmbStateTransitions.getSelectedItem();
        
        try {
            stateMachine.transiteToNextState(stateMachine.getStateIndex(newState));
            refreshView();
            
            if(stateMachine.getStates()[stateMachine.getCurrentState()] instanceof FinalState){
                JOptionPane.showMessageDialog(pnlStateMachine, "Object reached final state!", "", JOptionPane.INFORMATION_MESSAGE);
                pnlChooseNewState.setVisible(false);
            }
            
        } catch (Exception ex) {
            Logger.getLogger(FrmPaperReview.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(pnlStateMachine, ex.getMessage());
        }
        
    }//GEN-LAST:event_cmbStateTransitionsActionPerformed
    
    private StateMachine stateMachine;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<State> cmbStateTransitions;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lblCurrentState;
    private javax.swing.JPanel pnlChooseNewState;
    private javax.swing.JPanel pnlCurrentState;
    private javax.swing.JPanel pnlStateMachine;
    // End of variables declaration//GEN-END:variables

    private void prepareView() {
        stateMachine = new StateMachine();
        //stateMachine.initializePanel(pnlStateMachine);
        //pnlStateMachine = new JPanel(new GridLayout(1, stateMachine.getStates().length));
       // stateMachine.initializePanel(pnlStateMachine);
        
        Layout<State,Integer> layout = new CircleLayout(stateMachine.getStateMachineGraph());
        layout.setSize(new Dimension(600,500)); // sets the initial size of the space
        BasicVisualizationServer<State,Integer> vv =
        new BasicVisualizationServer<>(layout);
        vv.setPreferredSize(new Dimension(600,500));
        
        vv.getRenderContext().setVertexLabelTransformer(new ToStringLabeller<>());
        vv.getRenderer().getVertexLabelRenderer().setPosition(Position.S);

        pnlStateMachine = vv;
        
        add(pnlStateMachine, BorderLayout.CENTER);
        
        refreshView();
        
    }
    


    private void refreshView() {
        
        refreshCurrentState();
        refreshTransitions();
        
    }
    
        
    



    
    private void refreshCurrentState(){
        
        
        State currentState = stateMachine.getStates()[stateMachine.getCurrentState()];
        
        lblCurrentState.setText(currentState.toString());
        
        
        Transformer<State,Paint> vertexPaint = new Transformer<State,Paint>() {

            @Override
            public Paint transform(State i) {
                if(i == stateMachine.getStates()[stateMachine.getCurrentState()]){
                    return Color.GREEN;
                }
                if(i instanceof FinalState || i == stateMachine.getStartState()){
                    return Color.BLACK;
                }
                return Color.RED;
            }
        }; 
        
        BasicVisualizationServer<State,Integer> vv = (BasicVisualizationServer<State,Integer>)pnlStateMachine;
        
        
        vv.getRenderContext().setVertexFillPaintTransformer(vertexPaint);
        //stateMachine.getStateMachineGraph().

    }
    
    private void refreshTransitions() {
        
        stateMachine.setStateTransitions();
        
        ComboBoxModel<State> model = new DefaultComboBoxModel<>(stateMachine.getStateTransitions());
        
        cmbStateTransitions.setModel(model);

    }

}
