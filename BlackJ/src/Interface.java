import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.awt.*;


/**
 * This is to build a window for the game
 * screen resolution and window size
 */
public class Interface extends JFrame {

    int wd = 1200; //width
    int ht = 800; //height

    //colors
    Color colorBackground = new Color(48, 124, 25);
    Color buttonColor = new Color (250,200,10);

    //fonts
    Font buttonF = new Font("Times New Romman", Font.PLAIN, 20);

    //buttons
    JButton hit = new JButton();
    JButton stay = new JButton();
    JButton yes = new JButton();
    JButton no = new JButton();

    public Interface() {
        this.setSize(wd + 6, ht + 29); //Just to make sure it doesn't cover the application
        this.setTitle("BSU - Blackjack"); //Title of the window
        this.setVisible(true); //allows the player to be able to see the window
        this.setResizable(false); //this gives the player the capability of resizing the game window themselves
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //When the window is closed, stop the program

        /**
         * This is to make graphics for the entire game
         */
        Board board = new Board();
        this.setContentPane(board);

        /**
         * This will add buttons to the board
         * Hit, Stay, Yes and No for Play again
         */
        actionHit ahit = new actionHit(); //Give actions to the buttons
        actionStay astay = new actionStay();
        actionYes ayes = new actionYes();
        actionNo ano = new actionNo();

        hit.addActionListener(ahit);
        hit.setBounds(200,200,100,60); //size of the buttons
        hit.setBackground(buttonColor); //button color
        hit.setText("HIT"); //Text written on the button
        hit.setFont(buttonF); //Font of the button, listed under fonts

        stay.addActionListener(astay);
        stay.setBounds(200,100,100,60);
        stay.setBackground(buttonColor);
        stay.setText("STAY");
        stay.setFont(buttonF);

        yes.addActionListener(ayes);
        yes.setBounds(450,100,100,60);
        yes.setBackground(buttonColor);
        yes.setText("YES");
        yes.setFont(buttonF);

        no.addActionListener(ano);
        no.setBounds(450,200,100,60);
        no.setBackground(buttonColor);
        no.setText("NO");
        no.setFont(buttonF);

        board.add(hit);
        board.add(stay);
        board.add(yes);
        board.add(no);

    }

    public class Board extends JPanel{

        public void boardColors(Graphics b){

            b.setColor(colorBackground); //This will make the background of the Frame whatever color is listed in color
            b.fillRect(0,0,wd,ht); //This will fill the dimensions

        }

    }

    public class actionHit implements ActionListener {


        @Override
        public void actionPerformed(ActionEvent e) {

            System.out.println("You hit and get another card.");


        }
    }

    public class actionStay implements ActionListener{


        @Override
        public void actionPerformed(ActionEvent e) {

            System.out.println("You stay");
        }
    }

    public class actionYes implements ActionListener{


        @Override
        public void actionPerformed(ActionEvent e) {

            System.out.println("You play again");
        }
    }

    public class actionNo implements ActionListener{


        @Override
        public void actionPerformed(ActionEvent e) {

            JOptionPane.showMessageDialog(null,"Thank You for Playing");

        }
    }


}
