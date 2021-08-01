
/**
 * GUI Project: Battleship
 * Name: Lisa Vong   
 * Date: January 14th, 2019                
 */               

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Battleship extends JPanel implements ActionListener 
{
    //GLOBAL VARIABLES 
    CardLayout cdlayout = new CardLayout ();
    GridBagConstraints c = new GridBagConstraints();
    int row = 8;
    int col = 8;
    JButton a [][] = new JButton [row][col];
    //2D PICTURE ARRAY
    //0 IS A PNG IMAGE OF A GRAY SQUARE
    //PLAYER ONE PLACE SHIP ARRAY
    int b [][] = {{0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0}};
    //RESET ARRAY
    int r [][] = {{0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0}};
    //PLAYER TWO PLACE SHIP ARRAY
    JButton d [][] = new JButton [row][col];
    int f [][] = {{0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0}};
    //PLAYER ONE GUESSING ARRAY
    JButton h [][] = new JButton [row][col];
    int guess [][] = {{0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0}};
    //PLAYER TWO GUESSING ARRAY
    JButton k [] [] = new JButton [row][col];
    int guess1 [][] = {{0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0}};
    //COUNTER FOR NUMBER OF TIMES ROTATE BUTTON HAS BEEN CLICKED
    int rotatecount = 0;
    //IF THE NUMBER IS THREE, THE SHIP CAN STILL BE PLACED. THE NUMBER CHANGES ONCE THE SHIP HAS BEEN PLACED
    //THIS PREVENTS FROM ONE TYPE OF SHIP BEING PLACED MULTIPLE TIMES
    //CS = CARRIER SHIP
    int cs = 3;
    //BS = BATTLESHIP
    int bs = 3;
    //CCS = CRUISER SHIP
    int ccs = 3;
    //SS = SUBMARINE SHIP
    int ss = 3;
    //DS = DESTROYER SHIP
    int ds = 3;
    int cs1 = 3;
    int bs1 = 3;
    int ccs1 = 3;
    int ss1 = 3;
    int ds1 = 3;
    //X AND Y COORDINATES ARE CALCULATED IN ACTION PERFORM
    int x, y = 0;
    //P AND Q ARE USED TO CHECK WHICH SHIP IS CURRENTLY SELECTED
    int p = 0;
    int q = 0;
    //I AND J ARE USED TO PRINT OUT THE ARRAY
    int i ,j = 0;
    //SCREEN INDICATES WHICH SCREEN IS CURRENTLY VISIBLE (APPLIES ONLY TO GAMEPLAY AND GAMEPLAY1 SCREENS)
    int screen = 0;
    //IMAGES OF SHIPS CHANGE DEPENDING UPON WHICH IS SELECTED
    JLabel ship;
    JLabel ship1;
    //ALLOWS PLAYER TO SEE WHICH SHIP IS SELECTED AND ONLY ALLOW ONE TO BE SELECTED AT A TIME
    JRadioButton carrier, battleship, cruiser, submarine, destroyer;
    JRadioButton carrier1, battleship1, cruiser1, submarine1, destroyer1;
    //BUTTON TO RESTART GAME
    JButton brestart;
    //BUTTON TO QUIT GAME
    JButton bquit;
    //BUTTON TO RESUME GAME
    JButton bresume;
    //BUTTON TO GO TO INSTRUCTION SCREEN
    JButton binstruct;
    //TOTAL VARIABLES USED TO CHECK IF ALL FIVE SHIPS HAVE BEEN PLACED
    int total = 0;
    int total1 = 0;
    //BACKGROUND OF INSTRUCTION SCREEN
    JLabel backgroundinstruct;

    public static void main (String args [])
    {
        Battleship content = new Battleship ();
        JFrame window = new JFrame("Battleship");
        window.setContentPane (content);
        window.setSize(970, 1075);
        window.setLocation(450, 0);
        window.setVisible(true);
    }

    public Battleship ()
    {
        //ALL SCREENS USED IN GAME
        setLayout (cdlayout);
        screenmainmenu ();
        screeninstruct ();
        screeninstruct1 ();
        screeninstruct2 ();
        screeninstruct3 ();
        screeninstruct4 ();
        screenplayer1 ();
        screenplayer2 ();
        screenpause ();
        screenpause1 ();
        screenpause2 ();
        screenpause3 ();
        screengameplay ();
        screengameplay1 ();
        screenwinner1 ();
        screenwinner2 ();
    }

    public void screenmainmenu ()
    {
        JPanel menu = new JPanel ();
        //BACKGROUND IMAGE
        JLabel background = new JLabel (createImageIcon("background.jpg"));
        menu.add (background);
        background.setLayout (new GridBagLayout ());

        //TITLE
        JLabel title = new JLabel (createImageIcon("titlebattle.png"));
        c.weightx = 0.5;
        c.gridx = 0;
        c.gridy = 0;
        c.anchor = GridBagConstraints.NORTH;
        c.fill = GridBagConstraints.HORIZONTAL;
        background.add (title, c);

        //UNDERLINE 
        JLabel underline = new JLabel (createImageIcon("underline.png"));
        c.gridy = 1;
        c.insets = new Insets (0,0,100,0);
        c.anchor = GridBagConstraints.CENTER;
        background.add (underline, c);

        //BUTTON TO START GAME
        JButton bplay = new JButton ("PLAY");
        bplay.setFont (new Font("britannic bold", Font.PLAIN, 85));
        bplay.setBackground (Color.red);
        bplay.setForeground (Color.white);
        bplay.addActionListener (this);
        bplay.setActionCommand ("splay");
        c.gridy = 2;
        c.fill = GridBagConstraints.NONE;
        c.insets = new Insets (0,0,0,0);
        background.add (bplay, c);

        //BUTTON TO GO TO INSTRUCTIONS SCREEN
        JButton binstruct = new JButton ("INSTRUCTIONS");
        binstruct.setFont (new Font("britannic bold", Font.PLAIN, 65));
        binstruct.setBackground (Color.red);
        binstruct.setForeground (Color.white);
        binstruct.addActionListener (this);
        binstruct.setActionCommand ("instruction");
        c.gridy = 3;
        c.insets = new Insets (75,0,75,0);
        background.add (binstruct, c);

        //BUTTON TO QUIT GAME
        JButton bquit = new JButton ("QUIT");
        bquit.setFont (new Font("britannic bold", Font.PLAIN, 65));
        bquit.setBackground (Color.red);
        bquit.setForeground (Color.white);
        bquit.addActionListener (this);
        bquit.setActionCommand ("quit");
        c.gridy = 4;
        c.insets = new Insets (0,0,50,0);
        background.add (bquit, c);

        add ("mmenu", menu);
    }

    public void screeninstruct ()
    {
        //INSTRUCTIONS SCREEN WHEN COMING FROM MAIN MENU
        JPanel instruction = new JPanel ();
        backgroundinstruct = new JLabel (createImageIcon("background.jpg"));
        instruction.add (backgroundinstruct);
        backgroundinstruct.setLayout (new GridBagLayout());

        text ();
        
        //BUTTON TO GO BACK TO MAIN MENU
        JButton bmainmenu = new JButton ("BACK TO MAIN MENU");
        bmainmenu.setFont (new Font("britannic bold", Font.PLAIN, 50));
        bmainmenu.setBackground (Color.red);
        bmainmenu.setForeground (Color.white);
        bmainmenu.addActionListener (this);
        bmainmenu.setActionCommand ("mmenu");
        c.gridy = 3;
        c.insets = new Insets (70,10,0,10);
        backgroundinstruct.add (bmainmenu, c);

        add ("instruction", instruction);
    }

    public void screeninstruct1 ()
    {
        //INSTRUCTIONS SCREEN WHEN COMING FROM "PLAYER ONE SETUP FLEET" SCREEN
        JPanel instruction = new JPanel ();
        backgroundinstruct = new JLabel (createImageIcon("background.jpg"));
        instruction.add (backgroundinstruct);
        backgroundinstruct.setLayout (new GridBagLayout());

        text ();

        //BUTTON TO GO BACK TO "PLAYER ONE SETUP FLEET"
        JButton bback = new JButton ("BACK");
        bback.setFont (new Font("britannic bold", Font.PLAIN, 50));
        bback.setBackground (Color.red);
        bback.setForeground (Color.white);
        bback.addActionListener (this);
        c.gridy = 3;
        c.insets = new Insets (70,10,0,10);
        bback.setActionCommand ("splay");
        backgroundinstruct.add (bback, c);

        add ("instruction1", instruction);
    }

    public void screeninstruct2 ()
    {
        //INSTRUCTIONS SCREEN WHEN COMING FROM "PLAYER TWO SETUP FLEET" SCREEN
        JPanel instruction = new JPanel ();
        backgroundinstruct = new JLabel (createImageIcon("background.jpg"));
        instruction.add (backgroundinstruct);
        backgroundinstruct.setLayout (new GridBagLayout());

        text ();

        //BUTTON TO GO BACK TO "PLAYER TWO SETUP FLEET" SCREEN
        JButton bback = new JButton ("BACK");
        bback.setFont (new Font("britannic bold", Font.PLAIN, 50));
        bback.setBackground (Color.red);
        bback.setForeground (Color.white);
        bback.addActionListener (this);
        c.gridy = 3;
        c.insets = new Insets (70,10,0,10);
        bback.setActionCommand ("instructplay1");
        backgroundinstruct.add (bback, c);

        add ("instruction2", instruction);
    }

    public void screeninstruct3 ()
    {
        //INSTRUCTIONS SCREEN WHEN COMING FROM "PLAYER ONE GUESS" SCREEN
        JPanel instruction = new JPanel ();
        backgroundinstruct = new JLabel (createImageIcon("background.jpg"));
        instruction.add (backgroundinstruct);
        backgroundinstruct.setLayout (new GridBagLayout());

        text ();

        //BUTTON TO GO BACK TO "PLAYER ONE GUESS" SCREEN
        JButton bback = new JButton ("BACK");
        bback.setFont (new Font("britannic bold", Font.PLAIN, 50));
        bback.setBackground (Color.red);
        bback.setForeground (Color.white);
        bback.addActionListener (this);
        c.gridy = 3;
        c.insets = new Insets (70,10,0,10);
        bback.setActionCommand ("instructgameplay");
        backgroundinstruct.add (bback, c);

        add ("instruction3", instruction);
    }

    public void screeninstruct4 ()
    {
        //INSTRUCTIONS SCREEN WHEN COMING FROM "PLAYER TWO GUESS" SCREEN
        JPanel instruction = new JPanel ();
        backgroundinstruct = new JLabel (createImageIcon("background.jpg"));
        instruction.add (backgroundinstruct);
        backgroundinstruct.setLayout (new GridBagLayout());

        text ();

        //BUTTON TO GO BACK "PLAYER TWO GUESS" SCREEN
        JButton bback = new JButton ("BACK");
        bback.setFont (new Font("britannic bold", Font.PLAIN, 50));
        bback.setBackground (Color.red);
        bback.setForeground (Color.white);
        bback.addActionListener (this);
        bback.setActionCommand ("gameplay1");
        c.gridy = 3;
        c.insets = new Insets (70,10,0,10);
        backgroundinstruct.add (bback, c);

        add ("instruction4", instruction);
    }

    //TEXT FOR INSTRUCTIONS
    //IN METHOD AS REPEATEDLY USED
    public void text ()
    {
        JLabel title = new JLabel (createImageIcon("titleinstruction.png"));
        c.gridy = 0;
        c.insets = new Insets (20,0,0,0);
        c.anchor = GridBagConstraints.NORTH;
        c.fill = GridBagConstraints.HORIZONTAL;
        backgroundinstruct.add (title, c);

        JLabel underline = new JLabel (createImageIcon("underline1.png"));
        c.gridy = 1;
        c.insets = new Insets (0,0,20,0);
        c.anchor = GridBagConstraints.CENTER;
        backgroundinstruct.add (underline, c);

        JPanel text = new JPanel ();
        text.setBackground (Color.black);
        text.setLayout(new GridBagLayout());
        c.gridy = 2;
        c.insets = new Insets (20,0,0,0);
        c.fill = GridBagConstraints.NONE;
        backgroundinstruct.add (text, c);

        JLabel moretext = new JLabel ("WELCOME TO BATTLESHIP!");
        moretext.setFont (new Font ("Times new roman", Font.PLAIN, 20));
        moretext.setForeground(Color.white);
        c.anchor = GridBagConstraints.WEST;
        c.gridy = 0;
        c.insets = new Insets (10,10,10,10);
        text.add (moretext, c);

        JLabel goal = new JLabel ("THE GOAL OF THE GAME IS TO BE THE FIRST PLAYER TO SINK ALL OF THE OPPONENT'S SHIPS.");
        goal.setFont (new Font ("Times new roman", Font.PLAIN, 16));
        goal.setForeground(Color.white);
        c.gridy = 1;
        text.add (goal, c);

        JLabel howtoplace = new JLabel ("HOW TO PLACE SHIPS:");
        howtoplace.setFont (new Font ("Times new roman", Font.PLAIN, 16));
        howtoplace.setForeground(Color.white);
        c.insets = new Insets (0,10,0,10);
        c.gridy = 2;
        text.add (howtoplace, c);

        JLabel howtoplace1 = new JLabel ("EACH PLAYER WILL HAVE A CHANCE TO PLACE THEIR SHIPS.");
        howtoplace1.setFont (new Font ("Times new roman", Font.PLAIN, 16));
        howtoplace1.setForeground(Color.white);
        c.gridy = 3;
        text.add (howtoplace1, c);

        JLabel howtoplace2 = new JLabel ("THE SHIPS ARE:");
        howtoplace2.setFont (new Font ("Times new roman", Font.PLAIN, 16));
        howtoplace2.setForeground (Color.white);
        c.gridy = 4;
        text.add (howtoplace2, c);

        JLabel howtoplace3 = new JLabel ("               THE CARRIER (LENGTH: 5 SQUARES)");
        howtoplace3.setFont (new Font ("Times new roman", Font.PLAIN, 16));
        howtoplace3.setForeground (Color.white);
        c.gridy = 5;
        text.add (howtoplace3, c);

        JLabel howtoplace4 = new JLabel ("               THE BATTLESHIP (LENGTH: 4 SQUARES)");
        howtoplace4.setFont (new Font ("Times new roman", Font.PLAIN, 16));
        howtoplace4.setForeground (Color.white);
        c.gridy = 6;
        text.add (howtoplace4, c);

        JLabel howtoplace5 = new JLabel ("               THE CRUISER (LENGTH: 3 SQUARES)");
        howtoplace5.setFont (new Font ("Times new roman", Font.PLAIN, 16));
        howtoplace5.setForeground (Color.white);
        c.gridy = 7;
        text.add (howtoplace5, c);

        JLabel howtoplace6 = new JLabel ("               THE SUBMARINE (LENGTH: 3 SQUARES)");
        howtoplace6.setFont (new Font ("Times new roman", Font.PLAIN, 16));
        howtoplace6.setForeground (Color.white);
        c.gridy = 8;
        text.add (howtoplace6, c);

        JLabel howtoplace7 = new JLabel ("               THE DESTROYER (LENGTH: 2 SQUARES)");
        howtoplace7.setFont (new Font ("Times new roman", Font.PLAIN, 16));
        howtoplace7.setForeground (Color.white);
        c.gridy = 9;
        text.add (howtoplace7, c);

        JLabel howtoplace8 = new JLabel ("TO PLACE THE SHIPS, PLAYERS WILL CLICK A SQUARE ON THE GRID.");
        howtoplace8.setFont (new Font ("Times new roman", Font.PLAIN, 16));
        howtoplace8.setForeground (Color.white);
        c.gridy = 10;
        text.add (howtoplace8, c);

        JLabel howtoplace9 = new JLabel ("THE SQUARE ON THE SHIP THAT IS LOCATED ON THE UPPER LEFT WILL CORRESPOND TO THE SQUARE THE PLAYER");
        howtoplace9.setFont (new Font ("Times new roman", Font.PLAIN, 16));
        howtoplace9.setForeground (Color.white);
        c.gridy = 11;
        text.add (howtoplace9, c);

        JLabel howtoplace13 = new JLabel ("HAS CLICKED ON THE GRID.");
        howtoplace13.setFont (new Font ("Times new roman", Font.PLAIN, 16));
        howtoplace13.setForeground (Color.white);
        c.gridy = 12;
        text.add (howtoplace13, c);

        JLabel howtoplace10 = new JLabel ("PLAYERS ARE ABLE TO ROTATE SHIPS BY PRESSING THE ROTATE BUTTON LOCATED UNDER THE IMAGE OF THE SHIP.");
        howtoplace10.setFont (new Font ("Times new roman", Font.PLAIN, 16));
        howtoplace10.setForeground (Color.white);
        c.gridy = 13;
        text.add (howtoplace10, c);

        JLabel howtoplace11 = new JLabel ("TO CLEAR THE GRID, CLICK ON THE RESET BUTTON LOCATED UNDER THE ROTATE BUTTON.");
        howtoplace11.setFont (new Font ("Times new roman", Font.PLAIN, 16));
        howtoplace11.setForeground (Color.white);
        c.gridy = 14;
        text.add (howtoplace11, c);

        JLabel howtoplace12 = new JLabel ("WHEN FINISHED PLACING DOWN SHIPS, CLICK THE DONE BUTTON LOCATED BOTTOM RIGHT OF SCREEN.");
        howtoplace12.setFont (new Font ("Times new roman", Font.PLAIN, 16));
        howtoplace12.setForeground (Color.white);
        c.gridy = 15;
        text.add (howtoplace12, c);

        JLabel howtoplace14 = new JLabel ("ALL FIVE SHIPS MUST BE PLACED DOWN!");
        howtoplace14.setFont (new Font ("Times new roman", Font.PLAIN, 16));
        howtoplace14.setForeground (Color.white);
        c.gridy = 16;
        text.add (howtoplace14, c);

        JLabel guess = new JLabel ("HOW TO GUESS:");
        guess.setFont (new Font ("Times new roman", Font.PLAIN, 16));
        guess.setForeground (Color.white);
        c.gridy = 17;
        c.insets = new Insets (10,10,0,10);
        text.add (guess, c);

        JLabel guess1 = new JLabel ("AFTER BOTH PLAYERS ARE DONE PLACING THEIR SHIPS, PLAYERS WILL ALTERNATE TURNS GUESSING WHERE");
        guess1.setFont (new Font ("Times new roman", Font.PLAIN, 16));
        guess1.setForeground (Color.white);
        c.gridy = 18;
        c.insets = new Insets (0,10,0,10);
        text.add (guess1, c);

        JLabel guess2 = new JLabel ("THEIR OPPONENT'S SHIPS ARE LOCATED.");
        guess2.setFont (new Font ("Times new roman", Font.PLAIN, 16));
        guess2.setForeground (Color.white);
        c.gridy = 19;
        text.add (guess2, c);

        JLabel guess3 = new JLabel ("PLAYERS WILL GUESS BY CLICKING ON THE GRID WHERE THEY THINK THEIR OPPONENT'S SHIP IS.");
        guess3.setFont (new Font ("Times new roman", Font.PLAIN, 16));
        guess3.setForeground (Color.white);
        c.gridy = 20;
        text.add (guess3, c);

        JLabel guess4 = new JLabel ("GRAY SQUARE WITH BLUE OUTLINE = MISS");
        guess4.setFont (new Font ("Times new roman", Font.PLAIN, 16));
        guess4.setForeground (Color.white);
        c.gridy = 21;
        text.add (guess4, c);

        JLabel guess5 = new JLabel ("BLACK SQUARE WITH RED OUTLINE = HIT");
        guess5.setFont (new Font ("Times new roman", Font.PLAIN, 16));
        guess5.setForeground (Color.white);
        c.gridy = 22;
        text.add (guess5, c);

        JLabel end = new JLabel ("HAVE FUN! :)");
        end.setFont (new Font ("Times new roman", Font.PLAIN, 20));
        end.setForeground (Color.white);
        c.gridy = 23;
        c.insets = new Insets (10,10,10,10);
        text.add (end, c);
    }

    //SCREEN WHERE PLAYER ONE PLACES DOWN SHIPS
    public void screenplayer1 ()
    {
        JPanel play = new JPanel ();
        JLabel background1 = new JLabel (createImageIcon("background.jpg"));
        play.add (background1);
        background1.setLayout (new GridBagLayout());

        //PAUSE BUTTON TO TAKE PLAYER TO PAUSE MENU
        JButton bpause = new JButton ("l l");
        bpause.setFont (new Font ("britannic bold", Font.PLAIN, 25));
        bpause.setBackground (Color.red);
        bpause.setForeground (Color.white);
        bpause.addActionListener (this);
        bpause.setActionCommand ("spause");
        c.gridy = 0;
        c.ipady = 13;
        c.anchor = GridBagConstraints.NORTHEAST;
        c.insets = new Insets (20,2,2,2);
        background1.add (bpause, c);

        //TITLE
        JLabel title1 = new JLabel (createImageIcon("titleplace.png"));
        c.gridy = 1;
        c.ipady = 0;
        c.insets = new Insets (0,0,0,0);
        c.anchor = GridBagConstraints.CENTER;
        c.fill = GridBagConstraints.HORIZONTAL;
        background1.add (title1, c);

        //UNDERLINE
        JLabel underline1 = new JLabel (createImageIcon("underline1.png"));
        c.gridy = 2;
        c.insets = new Insets (0,0,5,0);
        background1.add (underline1, c);

        //BOTTOM PORTION OF THE SCREEN
        //NEW PANEL AS A DIFFERENT LAYOUT IS BEING USED (BORDER LAYOUT)
        JPanel bottom = new JPanel (new BorderLayout ());
        //HIDE THE BACKGROUND OF THE PANEL
        bottom.setOpaque (false);
        c.insets = new Insets (20,10,50,10);
        c.gridy = 3;
        c.fill = GridBagConstraints.NONE;
        background1.add (bottom, c);

        //GRID FOR PLAYER ONE TO PLACE DOWN SHIPS
        JPanel grid = new JPanel (new GridLayout (row, col));
        //M IS USED TO CALCULATE THE COORDINATES IN ACTION PERFORM
        int m = 0;
        //8 X 8 GRID
        for (i = 0 ; i<row ; i++)
        {
            for (j = 0; j<col ; j++)
            {
                //IMAGES FROM B[][] ARE PRINTED ONTO A[][]
                //ARRAY OF BUTTONS
                a[i][j] = new JButton (createImageIcon(b[i][j]+".png"));
                a[i][j].setBackground (Color.black);
                a[i][j].addActionListener (this);
                a[i][j].setActionCommand (""+m);
                grid.add (a[i][j]);
                m++;
            }
        }

        //GRID1 PANEL IS USED TO CREATE A BORDER 
        JPanel grid1 = new JPanel (new GridBagLayout ());
        grid1.setBackground (Color.black);
        c.gridy = 0;
        c.insets = new Insets (10,10,10,10);
        c.fill = GridBagConstraints.NONE;
        grid1.add (grid, c);
        bottom.add (grid1, BorderLayout.CENTER);

        //PANEL THAT HOLDS WIDGETS BEING PLACED ON THE RIGHT SIDE
        JPanel right = new JPanel (new GridBagLayout());
        right.setOpaque(false);
        bottom.add (right, BorderLayout.EAST);

        JLabel backgroundchoose = new JLabel (createImageIcon("backgroundchoose.jpg"));
        c.anchor = GridBagConstraints.NORTH;
        right.add (backgroundchoose, c);
        backgroundchoose.setLayout (new GridBagLayout ());

        //RADIOBUTTONS FOR PLAYERS TO SEE WHICH SHIP IS CURRENTLY SELECTED
        JPanel shipchoose = new JPanel (new GridLayout (0,1));
        shipchoose.setOpaque (false);
        c.insets = new Insets (40,10,10,10);
        backgroundchoose.add (shipchoose, c);

        carrier = new JRadioButton ("CARRIER");
        carrier.setFont (new Font("britannic bold", Font.PLAIN, 18));
        carrier.addActionListener (this);
        carrier.setActionCommand ("carrier");
        carrier.setOpaque (false);
        carrier.setSelected (true);

        battleship = new JRadioButton ("BATTLESHIP");
        battleship.setFont (new Font("britannic bold", Font.PLAIN, 18));
        battleship.addActionListener (this);
        battleship.setActionCommand ("battleship");
        battleship.setOpaque (false);

        cruiser = new JRadioButton ("CRUISER");
        cruiser.setFont (new Font("britannic bold", Font.PLAIN, 18));
        cruiser.addActionListener (this);
        cruiser.setActionCommand ("cruiser");
        cruiser.setOpaque (false);

        submarine = new JRadioButton ("SUBMARINE");
        submarine.setFont (new Font("britannic bold", Font.PLAIN, 18));
        submarine.addActionListener (this);
        submarine.setActionCommand ("submarine");
        submarine.setOpaque (false);

        destroyer = new JRadioButton ("DESTROYER");
        destroyer.setFont (new Font("britannic bold", Font.PLAIN, 18));
        destroyer.addActionListener (this);
        destroyer.setActionCommand ("destroyer");
        destroyer.setOpaque (false);

        ButtonGroup group = new ButtonGroup();
        group.add (carrier);
        group.add (battleship);
        group.add (cruiser);
        group.add (submarine);
        group.add (destroyer);

        shipchoose.add (carrier);
        shipchoose.add (battleship);
        shipchoose.add (cruiser);
        shipchoose.add (submarine);
        shipchoose.add (destroyer);

        //IMAGE OF SHIP SO PLAYERS CAN VISUALLY SEE LENGTH OF SHIP
        ship = new JLabel (createImageIcon("carriervert.png"));
        c.gridy = 1;
        c.insets = new Insets (10,10,10,10);
        c.anchor = GridBagConstraints.CENTER;
        backgroundchoose.add (ship, c);

        //BUTTON TO ROTATE SHIP 
        JButton brotate = new JButton ("ROTATE");
        brotate.setFont (new Font("britannic bold", Font.BOLD, 18));
        brotate.setBackground (Color.red);
        brotate.setForeground (Color.white);
        brotate.addActionListener (this);
        brotate.setActionCommand ("rotate");
        c.gridy = 2;
        c.insets = new Insets(10,10,45,10);
        backgroundchoose.add (brotate, c);

        //BUTTON TO RESET/CLEAR GRID
        JButton breset = new JButton ("RESET");
        breset.setFont (new Font ("britannic bold", Font.PLAIN, 45));
        breset.setBackground (Color.red);
        breset.setForeground (Color.white);
        breset.addActionListener (this);
        breset.setActionCommand ("reset");
        c.gridy = 1;
        c.insets = new Insets (35,10,35,10);
        right.add (breset, c);

        //BUTTON THAT MOVES ONTO "PLAYER TWO SETUP FLEET" SCREEN
        JButton bdone = new JButton ("DONE");
        bdone.setFont (new Font ("britannic bold", Font.PLAIN, 50));
        bdone.setBackground (Color.red);
        bdone.setForeground(Color.white);
        bdone.addActionListener (this);
        bdone.setActionCommand ("splay1");
        c.gridy = 2;
        c.insets = new Insets (10,10,35,10);
        right.add (bdone, c);

        add ("splay", play);
    }

    //SCREEN FOR PLAYER TWO TO PLACE SHIPS
    //SAME WIDGETS AS "PLAYER ONE SETUP FLEET" SCREEN
    public void screenplayer2 ()
    {
        JPanel play = new JPanel ();
        JLabel background1 = new JLabel (createImageIcon("background.jpg"));
        play.add (background1);
        background1.setLayout (new GridBagLayout());

        JButton bpause = new JButton ("l l");
        bpause.setFont (new Font ("britannic bold", Font.PLAIN, 35));
        bpause.setBackground (Color.red);
        bpause.setForeground (Color.white);
        bpause.addActionListener (this);
        bpause.setActionCommand ("spause1");
        c.gridy = 0;
        c.ipady = 16;
        c.anchor = GridBagConstraints.NORTHEAST;
        c.insets = new Insets (20,10,0,10);
        background1.add (bpause, c);

        JLabel title = new JLabel (createImageIcon("titleplace1.png"));
        c.gridy = 1;
        c.ipady = 0;
        c.insets = new Insets (0,0,0,0);
        c.anchor = GridBagConstraints.CENTER;
        c.fill = GridBagConstraints.HORIZONTAL;
        background1.add (title, c);

        JLabel underline = new JLabel (createImageIcon("underline1.png"));
        c.gridy = 2;
        c.insets = new Insets (0,0,10,0);
        background1.add (underline, c);

        JPanel bottom = new JPanel (new BorderLayout ());
        bottom.setOpaque (false);
        c.insets = new Insets (20,10,50,10);
        c.gridy = 3;
        c.fill = GridBagConstraints.NONE;
        background1.add (bottom, c);

        JPanel grid = new JPanel (new GridLayout (row, col));
        int m = 0;
        for (i = 0 ; i<row ; i++)
        {
            for (j = 0; j<col ; j++)
            {
                d[i][j] = new JButton (createImageIcon(f[i][j]+".png"));
                d[i][j].setBackground (Color.black);
                d[i][j].addActionListener (this);
                d[i][j].setActionCommand (""+m);
                grid.add (d[i][j]);
                m++;
            }
        }

        JPanel grid1 = new JPanel (new GridBagLayout ());
        grid1.setBackground (Color.black);
        c.gridy = 0;
        c.insets = new Insets (10,10,10,10);
        c.fill = GridBagConstraints.NONE;
        grid1.add (grid, c);
        bottom.add (grid1, BorderLayout.CENTER);

        JPanel right = new JPanel (new GridBagLayout());
        right.setOpaque(false);
        bottom.add (right, BorderLayout.EAST);

        JLabel backgroundchoose = new JLabel (createImageIcon("backgroundchoose.jpg"));
        c.anchor = GridBagConstraints.NORTH;
        right.add (backgroundchoose, c);
        backgroundchoose.setLayout (new GridBagLayout ());

        JPanel shipchoose = new JPanel (new GridLayout (0,1));
        shipchoose.setOpaque (false);
        c.insets = new Insets (40,10,10,10);
        backgroundchoose.add (shipchoose, c);

        carrier1 = new JRadioButton ("CARRIER");
        carrier1.setFont (new Font("britannic bold", Font.PLAIN, 18));
        carrier1.addActionListener (this);
        carrier1.setActionCommand ("carrier1");
        carrier1.setOpaque (false);
        carrier1.setSelected (true);

        battleship1 = new JRadioButton ("BATTLESHIP");
        battleship1.setFont (new Font("britannic bold", Font.PLAIN, 18));
        battleship1.addActionListener (this);
        battleship1.setActionCommand ("battleship1");
        battleship1.setOpaque (false);

        cruiser1 = new JRadioButton ("CRUISER");
        cruiser1.setFont (new Font("britannic bold", Font.PLAIN, 18));
        cruiser1.addActionListener (this);
        cruiser1.setActionCommand ("cruiser1");
        cruiser1.setOpaque (false);

        submarine1 = new JRadioButton ("SUBMARINE");
        submarine1.setFont (new Font("britannic bold", Font.PLAIN, 18));
        submarine1.addActionListener (this);
        submarine1.setActionCommand ("submarine1");
        submarine1.setOpaque (false);

        destroyer1 = new JRadioButton ("DESTROYER");
        destroyer1.setFont (new Font("britannic bold", Font.PLAIN, 18));
        destroyer1.addActionListener (this);
        destroyer1.setActionCommand ("destroyer1");
        destroyer1.setOpaque (false);

        ButtonGroup group = new ButtonGroup();
        group.add (carrier1);
        group.add (battleship1);
        group.add (cruiser1);
        group.add (submarine1);
        group.add (destroyer1);

        shipchoose.add (carrier1);
        shipchoose.add (battleship1);
        shipchoose.add (cruiser1);
        shipchoose.add (submarine1);
        shipchoose.add (destroyer1);

        ship1 = new JLabel (createImageIcon("carriervert.png"));
        c.gridy = 1;
        c.insets = new Insets (10,10,10,10);
        c.anchor = GridBagConstraints.CENTER;
        backgroundchoose.add (ship1, c);

        JButton brotate = new JButton ("ROTATE");
        brotate.setFont (new Font("britannic bold", Font.BOLD, 18));
        brotate.setBackground (Color.red);
        brotate.setForeground (Color.white);
        brotate.addActionListener (this);
        brotate.setActionCommand ("rotate1");
        c.gridy = 2;
        c.insets = new Insets(10,10,45,10);
        backgroundchoose.add (brotate, c);

        JButton breset = new JButton ("RESET");
        breset.setFont (new Font ("britannic bold", Font.PLAIN, 45));
        breset.setBackground (Color.red);
        breset.setForeground (Color.white);
        breset.addActionListener (this);
        breset.setActionCommand ("reset1");
        c.gridy = 1;
        c.insets = new Insets (35,10,35,10);
        right.add (breset, c);

        //BUTTON TO MOVE ONTO "PLAYER ONE GUESS" SCREEN
        JButton bdone = new JButton ("DONE");
        bdone.setFont (new Font ("britannic bold", Font.PLAIN, 50));
        bdone.setBackground (Color.red);
        bdone.setForeground(Color.white);
        bdone.addActionListener (this);
        bdone.setActionCommand ("gameplay");
        c.gridy = 2;
        c.insets = new Insets (10,10,35,10);
        right.add (bdone, c);

        add ("splay1", play);
    }

    //SCREEN WHERE PLAYER ONE GUESSES WHERE PLAYER TWO'S SHIPS ARE PLACED
    public void screengameplay()
    {
        JPanel gameplay = new JPanel (new GridBagLayout ());
        JLabel background = new JLabel (createImageIcon("background.jpg"));
        gameplay.add (background);
        background.setLayout (new GridBagLayout());

        //PAUSE BUTTON TO TAKE PLAYER TO PAUSE MENU
        JButton bpause = new JButton ("l l");
        bpause.setFont (new Font ("britannic bold", Font.PLAIN, 35));
        bpause.setBackground (Color.red);
        bpause.setForeground (Color.white);
        bpause.addActionListener (this);
        bpause.setActionCommand ("spause2");
        c.gridy = 0;
        c.ipady = 13;
        c.insets = new Insets (10,10,10,10);
        c.anchor = GridBagConstraints.NORTHEAST;
        background.add (bpause, c);

        JLabel title = new JLabel (createImageIcon("player1guess.png"));
        c.gridy = 1;
        c.ipady = 0;
        c.insets = new Insets (0,0,0,0);
        c.fill = GridBagConstraints.HORIZONTAL;
        background.add (title, c);

        JLabel underline = new JLabel (createImageIcon("underline1.png"));
        c.gridy = 2;
        c.insets = new Insets (0,0,10,0);
        background.add (underline, c);

        //GRID FOR PLAYER TO GUESS PLACEMENT OF SHIPS
        JPanel grid = new JPanel (new GridLayout (row, col));
        int m = 0;
        for (i = 0 ; i<row ; i++)
        {
            for (j = 0; j<col ; j++)
            {
                h[i][j] = new JButton (createImageIcon(guess[i][j]+".png"));
                h[i][j].setBackground (Color.black);
                h[i][j].addActionListener (this);
                h[i][j].setActionCommand (""+m);
                grid.add (h[i][j]);
                m++;
            }
        }

        JPanel grid1 = new JPanel (new GridBagLayout ());
        grid1.setBackground (Color.black);
        c.gridy = 0;
        c.insets = new Insets (10,10,10,10);
        c.fill = GridBagConstraints.NONE;
        grid1.add (grid, c);
        c.gridy = 3;
        c.insets = new Insets (0,20,10,20);
        background.add (grid1, c);

        add ("gameplay", gameplay);
    }

    //SCREEN FOR PLAYER TWO TO GUESS PLACEMENT OF SHIPS
    public void screengameplay1()
    {
        JPanel gameplay = new JPanel (new GridBagLayout ());
        JLabel background = new JLabel (createImageIcon("background.jpg"));
        gameplay.add (background);
        background.setLayout (new GridBagLayout());

        JButton bpause = new JButton ("l l");
        bpause.setFont (new Font ("britannic bold", Font.PLAIN, 35));
        bpause.setBackground (Color.red);
        bpause.setForeground (Color.white);
        bpause.addActionListener (this);
        bpause.setActionCommand ("spause3");
        c.gridy = 0;
        c.ipady = 13;
        c.insets = new Insets (10,10,10,10);
        c.anchor = GridBagConstraints.NORTHEAST;
        background.add (bpause, c);

        JLabel title = new JLabel (createImageIcon("player2guess.png"));
        c.gridy = 1;
        c.ipady = 0;
        c.insets = new Insets (0,0,0,0);
        c.fill = GridBagConstraints.HORIZONTAL;
        background.add (title, c);

        JLabel underline = new JLabel (createImageIcon("underline1.png"));
        c.gridy = 2;
        c.insets = new Insets (0,0,10,0);
        background.add (underline, c);

        JPanel grid = new JPanel (new GridLayout (row, col));
        grid.setSize (600,600);
        int m = 0;
        for (i = 0 ; i<row ; i++)
        {
            for (j = 0; j<col ; j++)
            {
                k[i][j] = new JButton (createImageIcon(guess1[i][j]+".png"));
                k[i][j].setBackground (Color.black);
                k[i][j].addActionListener (this);
                k[i][j].setActionCommand (""+m);
                grid.add (k[i][j]);
                m++;
            }
        }

        JPanel grid1 = new JPanel (new GridBagLayout ());
        grid1.setBackground (Color.black);
        c.gridy = 0;
        c.insets = new Insets (10,10,10,10);
        c.fill = GridBagConstraints.NONE;
        grid1.add (grid, c);
        c.gridy = 3;
        c.insets = new Insets (0,20,10,20);
        background.add (grid1, c);

        add ("gameplay1", gameplay);
    }

    //PAUSE SCREENS
    //DIFFERENT PAUSE SCREENS CORRESPOND TO DIFFERENT SCREENS AS THE RESUME BUTTON HAS A DIFFERENT ACTION COMMAND
    public void screenpause ()
    {
        JPanel pause = new JPanel (new GridBagLayout ());
        pause.setBackground(new Color(0,0,0,123));

        JLabel pausetitle = new JLabel (createImageIcon("titlepause.png"));
        c.gridy = 0;
        pause.add (pausetitle, c);

        //BUTTON THAT TAKES PLAYER BACK TO "PLAYER ONE SETUP FLEET" SCREEN
        resumebutton ();
        bresume.setActionCommand ("splay");
        pause.add (bresume, c);

        instructbutton ();
        binstruct.setActionCommand ("instruction1");
        pause.add (binstruct, c);

        restartbutton ();
        pause.add (brestart, c);

        quitbutton ();
        pause.add (bquit, c);

        add ("spause", pause);
    }

    public void screenpause1 ()
    {
        JPanel pause = new JPanel (new GridBagLayout ());
        pause.setBackground(new Color(0,0,0,123));

        JLabel pausetitle = new JLabel (createImageIcon("titlepause.png"));
        c.gridy = 0;
        pause.add (pausetitle, c);

        //BUTTON THAT TAKES PLAYER BACK TO "PLAYER TWO SETUP FLEET" SCREEN
        resumebutton ();
        bresume.setActionCommand ("splay1");
        pause.add (bresume, c);

        instructbutton ();
        binstruct.setActionCommand ("instruction2");
        pause.add (binstruct, c);

        restartbutton ();
        pause.add (brestart, c);

        quitbutton ();
        pause.add (bquit, c);

        add ("spause1", pause);
    }

    public void screenpause2 ()
    {
        JPanel pause = new JPanel (new GridBagLayout ());
        pause.setBackground(new Color(0,0,0,123));

        JLabel pausetitle = new JLabel (createImageIcon("titlepause.png"));
        c.gridy = 0;
        pause.add (pausetitle, c);

        //BUTTON THAT TAKES PLAYER BACK TO "PLAYER ONE GUESS" SCREEN
        resumebutton ();
        bresume.setActionCommand ("gameplay");
        pause.add (bresume, c);

        instructbutton ();
        binstruct.setActionCommand ("instruction3");
        pause.add (binstruct, c);

        restartbutton ();
        pause.add (brestart, c);

        quitbutton ();
        pause.add (bquit, c);

        add ("spause2", pause);
    }

    public void screenpause3 ()
    {
        JPanel pause = new JPanel (new GridBagLayout ());
        pause.setBackground(new Color(0,0,0,123));

        JLabel pausetitle = new JLabel (createImageIcon("titlepause.png"));
        c.gridy = 0;
        pause.add (pausetitle, c);

        //BUTTON THAT TAKES PLAYER BACK TO "PLAYER TWO GUESS" SCREEN
        resumebutton ();
        bresume.setActionCommand ("gameplay1");
        pause.add (bresume, c);

        instructbutton ();
        binstruct.setActionCommand ("instruction4");
        pause.add (binstruct, c);

        restartbutton ();
        pause.add (brestart, c);

        quitbutton ();
        pause.add (bquit, c);

        add ("spause3", pause);
    }

    //SCREEN APPEARS WHEN THE WINNER IS PLAYER ONE
    public void screenwinner1 ()
    {
        JPanel win = new JPanel ();
        JLabel background = new JLabel (createImageIcon("background.jpg"));
        win.add (background);
        background.setLayout (new GridBagLayout());

        JLabel winner = new JLabel (createImageIcon("player1winner.png"));
        c.gridy = 0;
        c.insets = new Insets (50,0,0,0);
        c.anchor = GridBagConstraints.CENTER;
        background.add (winner, c);

        //BUTTON TO RESTART ENTIRE GAME
        restartbutton ();
        c.gridy = 1;
        c.insets = new Insets (25,0,0,0);
        background.add (brestart, c);

        quitbutton();
        c.gridy = 2;
        background.add (bquit, c);

        add ("win", win);
    }

    //SCREEN APPEARS WHEN PLAYER TWO IS THE WINNER
    public void screenwinner2 ()
    {
        JPanel win = new JPanel ();
        JLabel background = new JLabel (createImageIcon("background.jpg"));
        win.add (background);
        background.setLayout (new GridBagLayout());

        JLabel winner = new JLabel (createImageIcon("player2winner.png"));
        c.gridy = 0;
        c.insets = new Insets (50,0,0,0);
        background.add (winner, c);

        restartbutton ();
        c.gridy = 1;
        c.insets = new Insets (25,0,0,0);
        background.add (brestart, c);

        quitbutton();
        c.gridy = 2;
        background.add (bquit, c);

        add ("win1", win);
    }

    //IN A METHOD AS USED REPEATEDLY
    public void instructbutton ()
    {
        binstruct = new JButton ("INSTRUCTIONS");
        binstruct.setFont (new Font("britannic bold", Font.PLAIN, 50));
        binstruct.setBackground (Color.red);
        binstruct.setForeground (Color.white);
        binstruct.addActionListener (this);
        c.gridy = 2;
    }

    public void restartbutton ()
    {
        brestart = new JButton ("RESTART");
        brestart.setFont (new Font("britannic bold", Font.PLAIN, 50));
        brestart.setBackground (Color.red);
        brestart.setForeground (Color.white);
        brestart.addActionListener (this);
        brestart.setActionCommand ("restart");
        c.gridy = 3;
    }

    public void quitbutton ()
    {
        bquit = new JButton ("QUIT");
        bquit.setFont (new Font("britannic bold", Font.PLAIN, 50));
        bquit.setBackground (Color.red);
        bquit.setForeground (Color.white);
        bquit.addActionListener (this);
        bquit.setActionCommand ("quit");
        c.gridy = 4;
    }

    public void resumebutton ()
    {
        bresume = new JButton ("RESUME");
        bresume.setFont (new Font("britannic bold", Font.PLAIN, 50));
        bresume.setBackground (Color.red);
        bresume.setForeground (Color.white);
        bresume.addActionListener (this);
        bresume.setActionCommand ("splay");
        c.insets = new Insets (80,0,0,0);
        c.gridy = 1;
    }

    public void actionPerformed (ActionEvent e)
    {
        //EXITS GAME
        if (e.getActionCommand().equals("quit"))
            System.exit(0);
        //RESETS ALL VARIABLES AND GRIDS
        if (e.getActionCommand().equals("restart"))
        {
            reset ();
            reset1();
            reset2 ();
            reset3 ();
            for (i = 0; i < row ; i++)
            {
                for (j = 0 ; j < col ; j++)
                {
                    h[i][j].setBackground (Color.black);
                    k[i][j].setBackground (Color.black);
                }
            }
            carrier.setSelected (true);
            carrier1.setSelected (true);
            ship.setIcon(createImageIcon ("carriervert.png"));
            rotatecount = 0;
            p = 0;
            ship1.setIcon(createImageIcon ("carriervert.png"));
            q = 0;
            cdlayout.show (this, "mmenu");
            screen = 0;
        }
        //SCREENS WILL APPEAR DEPENDING UPON WHICH ACTION COMMAND WAS USED
        if (e.getActionCommand ().equals("splay"))
            cdlayout.show(this, "splay");
        else if (e.getActionCommand().equals ("instruction"))
            cdlayout.show (this, "instruction");
        else if (e.getActionCommand ().equals("splay1"))
            if (total == 17)
            {
                cdlayout.show(this, "splay1");
                rotatecount = 0;
                reset1 ();
            }
            else
                cdlayout.show(this, "splay");
        else if (e.getActionCommand ().equals("gameplay"))
            if (total1 == 17)
            {
                screen = 1;
                cdlayout.show(this, "gameplay");
            }
            else
                cdlayout.show(this, "splay1");
        else if (e.getActionCommand ().equals ("gameplay1"))
        {
            screen = 2;
            cdlayout.show(this, "gameplay1");
        }
        else if (e.getActionCommand ().equals("instructplay1"))
            cdlayout.show (this, "splay1");
        else if (e.getActionCommand().equals ("instructgameplay"))
        {
            cdlayout.show (this, "gameplay");
            screen = 1;
        }
        else if (e.getActionCommand ().equals("spause"))
            cdlayout.show (this, "spause");
        else if (e.getActionCommand ().equals("spause1"))
            cdlayout.show (this, "spause1");
        else if (e.getActionCommand ().equals("spause2"))
            cdlayout.show(this, "spause2");
        else if (e.getActionCommand ().equals("spause3"))
            cdlayout.show(this, "spause3");    
        else if (e.getActionCommand ().equals("mmenu"))
            cdlayout.show (this, "mmenu");
        else if (e.getActionCommand ().equals ("instruction1"))
            cdlayout.show (this, "instruction1");
        else if (e.getActionCommand ().equals ("instruction2"))
            cdlayout.show (this, "instruction2");
        else if (e.getActionCommand ().equals ("instruction3"))
            cdlayout.show (this, "instruction3");
        else if (e.getActionCommand ().equals ("instruction4"))
            cdlayout.show (this, "instruction4");

        //ACTIONS RADIOBUTTONS DO WHEN CLICKED
        if (e.getActionCommand().equals ("carrier"))
        {
            //CHANGES IMAGE
            ship.setIcon(createImageIcon ("carriervert.png"));
            //SETS COUNT BACK TO 0
            rotatecount = 0;
            //INDICATES THE SHIP IS CURRENTLY VERTICAL
            p = 2;
        }
        else if (e.getActionCommand ().equals ("battleship"))
        {
            ship.setIcon(createImageIcon ("battleshipvert.png"));
            rotatecount = 0;
            p = 4;
        }
        else if (e.getActionCommand ().equals ("cruiser"))
        {
            ship.setIcon(createImageIcon ("cruiserandsubvert.png"));
            rotatecount = 0;
            p = 6;
        }
        else if (e.getActionCommand ().equals ("submarine"))
        {
            ship.setIcon(createImageIcon ("cruiserandsubvert.png"));
            rotatecount = 0;
            p = 8;
        }
        else if (e.getActionCommand ().equals ("destroyer"))
        {
            ship.setIcon (createImageIcon ("destroyervert.png"));
            rotatecount = 0;
            p = 10;
        }

        if (e.getActionCommand().equals ("rotate"))
        {
            rotatecount++;
            if (carrier.isSelected())
            {
                //ODD NUMBERS = HORIZONTAL SHIP
                if (rotatecount % 2 == 1)
                {
                    ship.setIcon (createImageIcon("carrierhori.png"));
                    //INDICATES SHIP IS HORIZONTAL
                    p = 1;
                }
                //EVEN NUMBER = VERTICAL SHIP
                else 
                {
                    ship.setIcon (createImageIcon ("carriervert.png"));
                    p = 2;
                }
            }
            else if (battleship.isSelected())
            {
                if (rotatecount % 2 == 1)
                {
                    ship.setIcon (createImageIcon("battleshiphori.png"));
                    p = 3;
                }
                else 
                {
                    ship.setIcon (createImageIcon ("battleshipvert.png"));
                    p = 4;
                } 
            }
            else if (cruiser.isSelected())
            {
                if (rotatecount % 2 == 1)
                {
                    ship.setIcon (createImageIcon("cruiserandsubhori.png"));
                    p = 5;
                }
                else 
                {
                    ship.setIcon (createImageIcon ("cruiserandsubvert.png"));
                    p = 6;
                } 
            }
            else if (submarine.isSelected())
            {
                if (rotatecount % 2 == 1)
                {
                    ship.setIcon (createImageIcon("cruiserandsubhori.png"));
                    p = 7;
                }
                else 
                {
                    ship.setIcon (createImageIcon ("cruiserandsubvert.png"));
                    p = 8;
                } 
            }
            else if (destroyer.isSelected())
            {
                if (rotatecount % 2 == 1)
                {
                    ship.setIcon (createImageIcon("destroyerhori.png"));
                    p = 9;
                }
                else 
                {
                    ship.setIcon (createImageIcon ("destroyervert.png"));
                    p = 10;
                } 
            }

        }
        if (e.getActionCommand ().equals ("reset"))
        {
            //RESETS SETTINGS
            reset();
            carrier.setSelected(true);
            ship.setIcon(createImageIcon ("carriervert.png"));
            rotatecount = 0;
            p = 0;
        }

        //"PLAYER TWO SETUP FLEET" SCREEN
        //SAME FUNCTIONS AS "PLAYER ONE SETUP FLEET" SCREEN
        if (e.getActionCommand().equals ("carrier1"))
        {
            ship1.setIcon(createImageIcon ("carriervert.png"));
            rotatecount = 0;
            q = 2;
        }
        else if (e.getActionCommand ().equals ("battleship1"))
        {
            ship1.setIcon(createImageIcon ("battleshipvert.png"));
            rotatecount = 0;
            q = 4;
        }
        else if (e.getActionCommand ().equals ("cruiser1"))
        {
            ship1.setIcon(createImageIcon ("cruiserandsubvert.png"));
            rotatecount = 0;
            q = 6;
        }
        else if (e.getActionCommand ().equals ("submarine1"))
        {
            ship1.setIcon(createImageIcon ("cruiserandsubvert.png"));
            rotatecount = 0;
            q = 8;
        }
        else if (e.getActionCommand ().equals ("destroyer1"))
        {
            ship1.setIcon (createImageIcon ("destroyervert.png"));
            rotatecount = 0;
            q = 10;
        }

        if (e.getActionCommand().equals ("rotate1"))
        {
            rotatecount++;
            if (carrier1.isSelected())
            {
                if (rotatecount % 2 == 1)
                {
                    ship1.setIcon (createImageIcon("carrierhori.png"));
                    q = 1;
                }
                else 
                {
                    ship1.setIcon (createImageIcon ("carriervert.png"));
                    q = 2;
                }
            }
            else if (battleship1.isSelected())
            {
                if (rotatecount % 2 == 1)
                {
                    ship1.setIcon (createImageIcon("battleshiphori.png"));
                    q = 3;
                }
                else 
                {
                    ship1.setIcon (createImageIcon ("battleshipvert.png"));
                    q = 4;
                } 
            }
            else if (cruiser1.isSelected())
            {
                if (rotatecount % 2 == 1)
                {
                    ship1.setIcon (createImageIcon("cruiserandsubhori.png"));
                    q = 5;
                }
                else 
                {
                    ship1.setIcon (createImageIcon ("cruiserandsubvert.png"));
                    q = 6;
                } 
            }
            else if (submarine1.isSelected())
            {
                if (rotatecount % 2 == 1)
                {
                    ship1.setIcon (createImageIcon("cruiserandsubhori.png"));
                    q = 7;
                }
                else 
                {
                    ship1.setIcon (createImageIcon ("cruiserandsubvert.png"));
                    q = 8;
                } 
            }
            else if (destroyer1.isSelected())
            {
                if (rotatecount % 2 == 1)
                {
                    ship1.setIcon (createImageIcon("destroyerhori.png"));
                    q = 9;
                }
                else 
                {
                    ship1.setIcon (createImageIcon ("destroyervert.png"));
                    q = 10;
                } 
            }

        }

        if (e.getActionCommand ().equals ("reset1"))
        {
            reset1 ();
            carrier1.setSelected(true);
            ship1.setIcon(createImageIcon ("carriervert.png"));
            rotatecount = 0;
            q = 0;
        }

        else
        {
            int n = Integer.parseInt (e.getActionCommand());
            //CALCULATES COORDINATES
            x = n/row;
            y = n%row;

            //PLAYER ONE PLACING SHIPS
            //IF THE SQUARE CLICKED  DOES NOT HOLD A SHIP 
            if (b[x][y] == 0)
            {
                //CHECKS WHICH SHIP IS SELECTED, IF THE SHIP HAS ALREADY BEEN PLACED, AND IF THERE ARE ANY OTHER SHIPS IN THE WAY
                if (p == 1 && cs >= 3 && b[x][y+4] == 0 && b[x][y+3] == 0 && b[x][y+2] == 0 && b[x][y+1] == 0)
                {
                    //COORDINATE SELECTED AND FOUR SQUARES TO THE RIGHT ARE REPLACED WITH A BLACK SQUARE
                    b[x][y] = 1;
                    b[x][y+1] = 1;
                    b[x][y+2] = 1;
                    b[x][y+3] = 1;
                    b[x][y+4] = 1;
                    cs = 1;
                    total += 5;
                }
                else if (p == 2 || p == 0 && cs >= 3 && b[x+4][y] == 0 && b[x+3][y] == 0 && b[x+2][y] == 0 && b[x+1][y] == 0)
                {
                    b[x][y] = 1;
                    b[x+1][y] = 1;
                    b[x+2][y] = 1;
                    b[x+3][y] = 1;
                    b[x+4][y] = 1;
                    cs = 2;
                    total += 5;
                }
                else if (p == 3 && bs >= 3 && b[x][y+3] == 0 && b[x][y+2] == 0 && b[x][y+1] == 0)
                {
                    b[x][y] = 1;
                    b[x][y+1] = 1;
                    b[x][y+2] = 1;
                    b[x][y+3] = 1;
                    bs = 1;
                    total += 4;
                }
                else if (p == 4 && bs >= 3 && b[x+3][y] == 0 && b[x+2][y] == 0 && b[x+1][y] == 0)
                {
                    b[x][y] = 1;
                    b[x+1][y] = 1;
                    b[x+2][y] = 1;
                    b[x+3][y] = 1;
                    bs = 2;
                    total += 4;
                }
                else if (p == 5 && ccs == 3 && b[x][y+2] == 0 && b[x][y+1] == 0)
                {
                    b[x][y] = 1;
                    b[x][y+1] = 1;
                    b[x][y+2] = 1;         
                    ccs = 1;
                    total += 3;
                }
                else if (p == 6 && ccs == 3 && b[x+2][y] == 0 && b[x+1][y] == 0)
                {
                    b[x][y] = 1;
                    b[x+1][y] = 1;
                    b[x+2][y] = 1;
                    ccs = 2;
                    total += 3;
                }
                else if (p == 7 && ss == 3 && b[x][y+2] == 0 && b[x][y+1] == 0)
                {
                    b[x][y] = 1;
                    b[x][y+1] = 1;
                    b[x][y+2] = 1;         
                    ss = 1;
                    total += 3;
                }
                else if (p == 8 && ss == 3 && b[x+2][y] == 0 && b[x+1][y] == 0)
                {
                    b[x][y] = 1;
                    b[x+1][y] = 1;
                    b[x+2][y] = 1;
                    ss = 2;
                    total += 3;
                }
                else if (p == 9 && ds == 3 && b[x][y+1] == 0)
                {
                    b[x][y] = 1;
                    b[x][y+1] = 1;
                    ds = 1;
                    total += 2;
                }
                else if (p == 10 && ds == 3 && b[x+1][y] == 0)
                {
                    b[x][y] = 1;
                    b[x+1][y] = 1;
                    ds = 2;
                    total += 2;
                }
                //REDRAW GRID WITH REPLACED IMAGES
                redraw ();
            }

            //PLAYER TWO PLACING SHIPS
            if (f[x][y] == 0)
            {
                if (q == 1  && cs1 == 3 && f[x][y+4] == 0 && f[x][y+3] == 0 && f[x][y+2] == 0 && f[x][y+1] == 0)
                {
                    f[x][y] = 1;
                    f[x][y+1] = 1;
                    f[x][y+2] = 1;
                    f[x][y+3] = 1;
                    f[x][y+4] = 1;
                    cs1 = 1;
                    total1 += 5;
                }
                else if (q == 2 || q == 0 && cs1 == 3 && f[x+4][y] == 0 && f[x+3][y] == 0 && f[x+2][y] == 0 && f[x+1][y] == 0)
                {
                    f[x][y] = 1;
                    f[x+1][y] = 1;
                    f[x+2][y] = 1;
                    f[x+3][y] = 1;
                    f[x+4][y] = 1;
                    cs1 = 2;
                    total1 += 5;
                }
                else if (q == 3 && bs1 == 3 && f[x][y+3] == 0 && f[x][y+2] == 0 && f[x][y+1] == 0)
                {
                    f[x][y] = 1;
                    f[x][y+1] = 1;
                    f[x][y+2] = 1;
                    f[x][y+3] = 1;
                    bs1 = 1;
                    total1 += 4;
                }
                else if (q == 4 && bs1 == 3 && f[x+3][y] == 0 && f[x+2][y] == 0 && f[x+1][y] == 0)
                {
                    f[x][y] = 1;
                    f[x+1][y] = 1;
                    f[x+2][y] = 1;
                    f[x+3][y] = 1;
                    bs1 = 2;
                    total1 += 4;
                }
                else if (q == 5 && ccs1 == 3 && f[x][y+2] == 0 && f[x][y+1] == 0)
                {
                    f[x][y] = 1;
                    f[x][y+1] = 1;
                    f[x][y+2] = 1;         
                    ccs1 = 1;
                    total1 += 3;
                }
                else if (q == 6 && ccs1 == 3 && f[x+2][y] == 0 && f[x+1][y] == 0)
                {
                    f[x][y] = 1;
                    f[x+1][y] = 1;
                    f[x+2][y] = 1;
                    ccs1 = 2;
                    total1 += 3;
                }
                else if (q == 7 && ss1 == 3 && f[x][y+2] == 0 && f[x][y+1] == 0)
                {
                    f[x][y] = 1;
                    f[x][y+1] = 1;
                    f[x][y+2] = 1;         
                    ss1 = 1;
                    total1 += 3;
                }
                else if (q == 8 && ss1 == 3 && f[x+2][y] == 0 && f[x+1][y] == 0)
                {
                    f[x][y] = 1;
                    f[x+1][y] = 1;
                    f[x+2][y] = 1;
                    ss1 = 2;
                    total1 += 3;
                }
                else if (q == 9 && ds1 == 3 && f[x][y+1] == 0)
                {
                    f[x][y] = 1;
                    f[x][y+1] = 1;
                    ds1 = 1;
                    total1 += 2;
                }
                else if (q == 10 && ds1 == 3 && f[x+1][y] == 0)
                {
                    f[x][y] = 1;
                    f[x+1][y] = 1;
                    ds1 = 2;
                    total1 += 2;
                }

                redraw1 ();
            }

        }
        //SCREEN ONE IS "PLAYER ONE GUESS" AND SCREEN TWO IS "PLAYER TWO GUESS"
        if (screen == 1 || screen == 2)
        {
            if (screen == 1)
            {
                //IF THE COORDINATE SELECTED HAS NOT BEEN GUESSED
                if (guess[x][y] == 0)
                {
                    //IF THE COORDINATE HAS A SHIP 
                    if (f[x][y] == 1)
                    {
                        //COORDINATE SELECTED BECOMES A BLCK SQUARE WITH A RED OUTLINE INDICATING IT WAS A HIT
                        guess[x][y] = 1;
                        redraw2();
                        h[x][y].setBackground (Color.red);
                    }
                    //IF THE COORDINATE DOES NOT HAVE A SHIP, IT WILL HAVE A BLUE OUTLINE INDICATING IT WAS A MISS
                    else if (f[x][y] == 0)
                        h[x][y].setBackground (Color.blue); 
                    //SCREEN CHANGES TO "PLAYER TWO GUESS" 
                    cdlayout.show(this, "gameplay1");
                    screen = 2;
                }
            }
            else if (screen == 2)
            {
                if (guess1[x][y] == 0)
                {
                    if (b[x][y] == 1)
                    {
                        guess1[x][y] = 1;
                        redraw3();
                        k[x][y].setBackground (Color.red);
                    }
                    else if (b[x][y] == 0)
                        k[x][y].setBackground (Color.blue);
                    cdlayout.show(this, "gameplay");
                    screen = 1;
                }
            }
            //IF PLAYER ONE IS THE WINNER
            if (wl ())
            //"PLAYER ONE WINS" SCREEN APPEARS
                cdlayout.show (this, "win");
            //IF PLAYER TWO WINS
            else if (wl1 ()) 
            //"PLAYER TWO WINS" SCREEN APPEARS
                cdlayout.show(this, "win1");
        }
    }

    public static ImageIcon createImageIcon (String path)
    {
        java.net.URL imgURL = Battleship.class.getResource (path);
        if (imgURL != null)
        {
            return new ImageIcon (imgURL);
        }
        else 
        {
            System.err.println ("Couldn't find file: "+path);
            return null;
        }
    }

    //RE PRINTS ARRAY WITH REPLACED IMAGES
    public void redraw ()
    {
        for (i = 0 ; i<row ; i++)
        {
            for (j = 0 ; j < col ; j++)
            {
                a[i][j].setIcon (createImageIcon (b[i][j]+".png"));
            }
        }
    }

    //RESETS GRID AND VARIABLES
    public void reset ()
    {
        for (int i = 0 ; i < row ; i++)
        {
            for (int j = 0 ; j < col ; j++)
            {
                //COPIES RESET ARRAY 
                b [i] [j] = r [i] [j];
            }
        }
        redraw ();
        cs = 3;
        bs = 3;
        ccs = 3;
        ss = 3;
        ds = 3;
        total = 0;
    }

    public void redraw1 ()
    {
        int m = 0;
        for (i = 0 ; i<row ; i++)
        {
            for (j = 0 ; j < col ; j++)
            {
                d[i][j].setIcon (createImageIcon (f[i][j]+".png"));
                m++;
            }
        }
    }

    public void reset1 ()
    {
        for (int i = 0 ; i < row ; i++)
        {
            for (int j = 0 ; j < col ; j++)
            {
                f [i] [j] = r [i] [j];
            }
        }
        redraw1 ();
        cs1 = 3;
        bs1 = 3;
        ccs1 = 3;
        ss1 = 3;
        ds1 = 3;
        total1 = 0;
    }

    public void redraw2 ()
    {
        int m = 0;
        for (i = 0 ; i<row ; i++)
        {
            for (j = 0 ; j < col ; j++)
            {
                h[i][j].setIcon (createImageIcon (guess[i][j]+".png"));
                m++;
            }
        }
    }

    public void reset2 ()
    {
        for (int i = 0 ; i < row ; i++)
        {
            for (int j = 0 ; j < col ; j++)
            {
                guess [i] [j] = r [i] [j];
            }
        }
        redraw2 ();
    }

    public void reset3 ()
    {
        for (int i = 0 ; i < row ; i++)
        {
            for (int j = 0 ; j < col ; j++)
            {
                guess1 [i] [j] = r [i] [j];
            }
        }
        redraw3 ();
    }

    public void redraw3 ()
    {
        int m = 0;
        for (i = 0 ; i<row ; i++)
        {
            for (j = 0 ; j < col ; j++)
            {
                k[i][j].setIcon (createImageIcon (guess1[i][j]+".png"));
                m++;
            }
        }
    }

    //CHECKS IF "PLAYER ONE GUESS" GRID IS THE SAME AS "PLAYER TWO SETUP FLEET" GRID
    public boolean wl ()
    {
        for (int i = 0 ; i < row ; i++)
        {
            for (int j = 0 ; j < col ; j++)
            {   
                if (guess [i] [j] != f [i] [j])
                    return false;
            }
        }
        return true;
    }

    //CHECKS IF "PLAYER TWO GUESS" GRID IS THE SAME AS "PLAYER ONE SETUP FLEET" GRID
    public boolean wl1 ()
    {
        for (int i = 0 ; i < row ; i++)
        {
            for (int j = 0 ; j < col ; j++)
            {   
                if (guess1 [i] [j] != b [i] [j])
                    return false;
            }
        }
        return true;
    }

}

