package Stage1;

import java.util.Scanner;
import Main.MasterStage;
import static java.lang.System.out;


public class Stage1 extends MasterStage {
Scanner input = new Scanner(System.in);

int beginning=0;
public void start(){
    if (beginning ==0) {
        out.println("You Wake up and find yourself in a forest.");
        beginning=1;
    }
    out.println("There is a trail ahead of you that goes north and a trail behind you that goes south");
    out.println("Were do you want to go");
    out.println("Enter 1 to go north");
    out.println("Enter 2 to go south");
    String S1Choice = input.nextLine();
    while(!S1Choice.trim().equals("1")||!S1Choice.trim().equals("2")) {
        if (S1Choice.trim().equals("1")) {
            S1Choice="";
            s1town.start();

        } else if (S1Choice.trim().equals("2")) {
            S1Choice="";
            s1well.start();

        } else {
            out.println("Invalid input please try again");
            S1Choice = input.nextLine();
        }

    }


    }








}
