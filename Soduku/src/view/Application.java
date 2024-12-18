package view;


import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.*;

public class Application {

    public static void main(String[] args){
        SwingUtilities.invokeLater(() -> {
            //Skapandet av själva fönstret
            JFrame window = new JFrame("Sudoku");
            window.setMinimumSize(new Dimension(500,500));

            //Skapande av matrix objekt
            Matrix matrix = new Matrix();
            window.add(matrix.getPanel(), BorderLayout.CENTER);

            //Skapande av buttons objekt
            Buttons buttons = new Buttons();
            window.add(buttons.getPanel(), BorderLayout.SOUTH);
            
            
            //Hantering av fönstret
            window.pack();
            window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            window.setVisible(true);
        });           
    }
}

