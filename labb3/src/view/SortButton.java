package view;

import java.util.Comparator;
import java.util.Map;

import javax.swing.*;

import view.model.SortedListModel;

public class SortButton {
    private JRadioButton alfa;
    private JRadioButton nbr;
    private ButtonGroup btnGroup;

    public SortButton(SortedListModel<Map.Entry<String, Integer>> sortedList){
        //Skapar de tvp Radiobuttons
        alfa = new JRadioButton("Alfabetisk");
        nbr = new JRadioButton("Numerisk");

        //lägger till dem i en buttonGroup => båda kan inte vara markerade samtidigt
        btnGroup = new ButtonGroup();
        btnGroup.add(alfa);
        btnGroup.add(nbr);

        //Ifall alfa ifylld sorterat vi efter alfabete med sortmetoden
        alfa.addActionListener(e ->{
            sortedList.sort(Comparator.comparing(Map.Entry:: getKey));
        });

        nbr.addActionListener(e ->{
            sortedList.sort(Comparator.comparing(Map.Entry:: getValue));
        });

    }

    public JPanel getJPanel(){
        JPanel buttoPanel = new JPanel();
        buttoPanel.setLayout(new BoxLayout(buttoPanel, BoxLayout.Y_AXIS));
        buttoPanel.add(alfa);
        buttoPanel.add(nbr);
        return buttoPanel;
    }


    
}
