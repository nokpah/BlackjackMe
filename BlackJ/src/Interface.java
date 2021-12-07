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

    //window resolution
    int wd = 1200; //width
    int ht = 800; //height

    //background color
    Color colorBackground = new Color(39,120,20);
    Color buttonColor = new Color (250,200,10);

    //fonts
    Font buttonF = new Font("Times New Romman", Font.PLAIN, 20);


    //buttons
    JButton hit = new JButton();
    JButton stay = new JButton();
    JButton yes = new JButton();
    JButton no = new JButton();

    //card grid position and dimensions
    //x,y-axis / width and height
    int gridx = 50;
    int gridy = 50;
    int gridw = 800;
    int gridh = 400;

    //card spacing
    int cardSpacing = 10;
    int cardTW = gridw/2;
    int cardTH = gridh/2;
    int cardAW = cardTW - 2*cardSpacing;
    int cardAH = cardTH - 2*cardSpacing;

    //totals and hit/stay gird dimensions
    int hsX = gridx + gridw + 50;
    int hsY = gridy;
    int hsW = 230;
    int hsH = 400;

    //play more
    int pmX = hsX;
    int pmY = hsY + hsH + 50;
    int pmW = hsW;
    int pmH = 200;

    public Interface() {

        this.setSize(wd,ht);
        this.setTitle("Eclipse Test");
        this.setVisible(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );

        Board board = new Board();
        this.setContentPane(board);
        this.setLayout(null);

        actionHit ahit = new actionHit(); //Give actions to the buttons
        actionStay astay = new actionStay();
        actionYes ayes = new actionYes();
        actionNo ano = new actionNo();


        hit.addActionListener(ahit);
        hit.setBounds(hsX+55,hsY+40,100,60); //size of the buttons
        hit.setBackground(buttonColor); //button color
        hit.setText("HIT"); //Text written on the button
        hit.setFont(buttonF); //Font of the button, listed under fonts

        stay.addActionListener(astay);
        stay.setBounds(hsX+55,hsY+288,100,60);
        stay.setBackground(buttonColor);
        stay.setText("STAY");
        stay.setFont(buttonF);

        yes.addActionListener(ayes);
        yes.setBounds(pmX+10,pmY+110,100,60);
        yes.setBackground(buttonColor);
        yes.setText("YES");
        yes.setFont(buttonF);

        no.addActionListener(ano);
        no.setBounds(pmX+120,pmY+110,100,60);
        no.setBackground(buttonColor);
        no.setText("NO");
        no.setFont(buttonF);

        board.add(hit);
        board.add(stay);
        board.add(yes);
        board.add(no);


    }


    public class Board extends JPanel{

        public void paintComponent(Graphics g) {
            g.setColor(colorBackground);
            g.fillRect(0,0,wd,ht);

            //temp grid painting
            g.setColor(Color.black);
            g.drawRect(gridx,gridy,gridw,gridh);

            //temp log border
            g.drawRect(gridx,gridy+gridh+100, gridw,300);

            //grid for buttons
            g.drawRect(hsX,hsY,hsW,hsH);

            //temp play again grid
            g.drawRect(pmX,pmY,pmW,pmH);

            for (int i = 0; i < 6; i++){
                g.drawRect(gridx+i*cardTH+cardSpacing,gridy+cardSpacing,cardAW,cardAH);

            }
        }
    }

    public class actionHit implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("You just clicked the Hit button");

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

            System.out.println("Do you want to play again?");
        }
    }

    public class actionNo implements ActionListener{


        @Override
        public void actionPerformed(ActionEvent e) {

            JOptionPane.showMessageDialog(null,"Thank You for Playing");

        }
    }


}