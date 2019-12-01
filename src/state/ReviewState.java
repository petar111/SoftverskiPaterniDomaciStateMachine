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
public class ReviewState extends State {

    @Override
    public String toString() {
        return "Review state"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void showOptions(Paper paper) {
        System.out.println("1: Continue reviewing (dont change state)");
        System.out.println("2: Accept paper");
        System.out.println("3: Reject paper");
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                System.out.println("=============================================================");
                System.out.println("Dont change state");
                System.out.println("=============================================================");
                break;
            case 2:
                paper.goToState(new AcceptedState());
                break;
            case 3:
                paper.goToState(new RejectState());
                break;
        }
    }

}
