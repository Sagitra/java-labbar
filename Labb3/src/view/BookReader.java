package view;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.*;
import java.util.*;

import view.model.SortedListModel;

public class BookReader {
    private JFrame frame;
    private JPanel north;
    private JPanel east;
    
    public BookReader(SortedListModel<Map.Entry<String, Integer>> sortedList, SearchPanel searchPanel, SortButton sortButton){
        //Skapar själva fönstrer
        frame = new JFrame("BookReader");
        frame.setMinimumSize(new Dimension(500,300));


        //Lägger till de olika objekten till panelena north och east
        north = searchPanel.getJPanel();
        east = sortButton.getJPanel();

        //Lägger till panelerna till Framen
        frame.add(north, BorderLayout.NORTH);
        frame.add(east, BorderLayout.EAST);

        
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
