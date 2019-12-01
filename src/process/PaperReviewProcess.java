/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package process;

import java.util.Scanner;
import model.Paper;

/**
 *
 * @author student1
 */
public class PaperReviewProcess {

    private final Paper paper;

    public PaperReviewProcess() {
        paper = new Paper();
    }

    public void process() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("1: Get current state");
            System.out.println("2: Do something in current state");
            System.out.println("3: exit");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("=============================================================");
                    System.out.println("Current state: " + paper.getCurrentState());
                    System.out.println("=============================================================");
                    break;
                case 2:
//                    paper.doSomethingOnState();
                    paper.getCurrentState().doSomething(paper);
                    break;
                case 3:
                    System.out.println("Goodbye");
                    break;
            }

        } while (choice != 3);

    }

}
