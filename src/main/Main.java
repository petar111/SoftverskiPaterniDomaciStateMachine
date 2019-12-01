/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import javax.swing.JFrame;
import javax.swing.JPanel;
import process.PaperReviewProcess;
import view.FrmPaperReview;

/**
 *
 * @author student1
 */
public class Main {

    public static void main(String[] args) {
        //PaperReviewProcess paperReviewProcess = new PaperReviewProcess();
        //paperReviewProcess.process();
        
        
        JFrame frame = new JFrame();
        JPanel pnl = new FrmPaperReview();
        
        frame.add(pnl);
        frame.pack();
        
        frame.setVisible(true);
    }
}
