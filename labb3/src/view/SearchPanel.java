package view;

import java.util.Map;

import javax.swing.*;

import view.model.SortedListModel;

public class SearchPanel {
    private JTextField ruta;
    private JButton knapp;
    private JScrollPane scroll;

    public SearchPanel(SortedListModel<Map.Entry<String, Integer>> sortedList){
        //Skapar rutan
        ruta = new JTextField("Sökord", 30);
        //Skapar knappen
        knapp = new JButton("Sök");

        //Omvandlar vårt sortedList till en JList för att kunna lägga in den i rutan
        JList<Map.Entry<String, Integer>> localList = new JList<>(sortedList);
        scroll = new JScrollPane(localList);

        //Kollar på sökknappen
        knapp.addActionListener(e -> {
            if(!getSearch().equals("Sökord")){
                int index = sortedList.indexFor(entry -> entry.getKey().equals(getSearch())); //Hämtar index
                if(index != -1){ //Ifall vi få giltigt index
                    localList.setSelectedIndex(index); //Markera och scrolla dit
                    scroll.getVerticalScrollBar().setValue(localList.getCellBounds(index, index).y);
                }else{
                    //Fixar en ruta ifall ordet ej finns med i listan
                    JOptionPane.showMessageDialog(null, "Ordet finns inte med i listan!", "Information", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        //Lyssnar på enter
        ruta.addActionListener(e -> knapp.doClick());
    }

    //Skapar och skickar panelen till BookReader
    public JPanel getJPanel(){
        JPanel panel = new JPanel();
        panel.add(knapp);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(ruta);
        panel.add(scroll);
        return panel;
    }

    //Hämtar vad som står skriver i sökrutan
    public String getSearch(){
        return ruta.getText();
    }
}
