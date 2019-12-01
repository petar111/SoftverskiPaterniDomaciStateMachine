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
public class WritingState extends State {

    @Override
    public String toString() {
        return "Writing state"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void showOptions(Paper paper) {
        System.out.println("1: I need to write more (dont change state) ");
        System.out.println("2: Send to review");
        System.out.println("3: Cancel writing");
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                System.out.println("=============================================================");
                System.out.println("Dont change state");
                System.out.println("=============================================================");
                break;
            case 2:
                paper.goToState(new ReviewState());
                break;
            case 3:
                paper.goToState(new CancelState());
                break;
        }
    }

}
