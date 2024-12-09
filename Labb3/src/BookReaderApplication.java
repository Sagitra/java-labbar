import parser.TextAnalyzer;
import view.BookReader;
import view.SearchPanel;
import view.SortButton;
import view.model.SortedListModel;

import java.util.*;
import java.io.FileNotFoundException;


public class BookReaderApplication {
    private static SortedListModel<Map.Entry<String, Integer>> sortedList; 
    public static void main(String[] Args){
        //Nödvändig kod som behöver köras för att vi ska kunna komma åt GWC och report
        try{
            //Analyserar text och lägger den på ett sortedListModel objekt
            TextAnalyzer analyzer = new TextAnalyzer("input/undantagsord.txt");
            sortedList = new SortedListModel<>(analyzer.getWordList("input/nilsholg.txt"));

            //Skapar objekt av de andra klasser som behövs för att skapa fönstret
            SearchPanel searchPanel = new SearchPanel(sortedList);
            SortButton sortButton = new SortButton(sortedList);

            //Skapar själva fönstret
            new BookReader(sortedList, searchPanel, sortButton);
        }catch(FileNotFoundException e){
            System.out.println("Ogiltig path i BookReaderApplication");
        }

        //Endast gammal kod
        //Gui
        /*SwingUtilities.invokeLater(()->{
            //Skapandet av själva fönstret
            JFrame frame = new JFrame("BookReader");
            frame.setMinimumSize(new Dimension(500,300));

            Container container = frame.getContentPane();

            //Deklaration av alla panels
            JPanel west = new JPanel();
            JPanel center = new JPanel();
            JPanel east = new JPanel();
            JPanel south = new JPanel();
            JPanel north = new JPanel();


            //Sökfältet
            JTextField txt = new JTextField("Sökord",30);
            north.add(txt);

            //Sök knapp
            JButton button = new JButton("SÖK");
            north.add(button);

            //Sorteringsknappar
            JRadioButton alfa = new JRadioButton("Alfabetisk");
            JRadioButton nbr = new JRadioButton("Numerisk");

            //Skapandet av en buttonpanel. Kan samla båda knapparna grafiskt så att de ligger lodrätt med varandra
            JPanel buttoPanel = new JPanel();
            buttoPanel.setLayout(new BoxLayout(buttoPanel, BoxLayout.Y_AXIS));
            buttoPanel.add(alfa);
            buttoPanel.add(nbr);

            east.add(buttoPanel);

            //Skapandet av en buttongroup. Gör så att t.ex båda våra knappar ej kan vara markerade samtidigt
            ButtonGroup btnGroup = new ButtonGroup();
            btnGroup.add(alfa);
            btnGroup.add(nbr);


            //textrutan: Lägger till objekt som är Map.Entrys
            JList<Map.Entry<String, Integer>> txtruta = new JList<>(sortedList);
            //JList<Map.Entry<String, Integer>> txtruta = new JList<>();
            center.add(txtruta);

            //Scrollfunktionen
            JScrollPane ruta = new JScrollPane(txtruta);
            ruta.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
            center.add(ruta);
            
            //Sammankoppladet mellan våra variabler och faktiska positioner i fönstret
            container.add(center, BorderLayout.CENTER);
            container.add(north, BorderLayout.NORTH);
            container.add(south, BorderLayout.SOUTH);
            container.add(west, BorderLayout.WEST);
            container.add(east, BorderLayout.EAST);

            //Logiken bakom knapparna
            //Lyssna på sökknappen
            button.addActionListener(e -> {

                    if(btnGroup.isSelected(alfa.getModel())){ //Ifall alfa är markerat och vi trycker så sorterar vi därefter
                        sortedList.sort(Comparator.comparing(Map.Entry::getKey));
                    }else if(btnGroup.isSelected(nbr.getModel())){ //Ifall nbr är ifylld
                        sortedList.sort(Comparator.comparing(Map.Entry::getValue));
                    }else{ //Ifall ingen är ifylld och vi trycker på sök. Söker efter ord ifall order inte är "sökord"
                        String keyWord = txt.getText();
                        if(!keyWord.equals("Sökord")){
                            int index = sortedList.indexFor(entry -> entry.getKey().equals(keyWord)); //Hämtar index
                            if(index != -1){ //Ifall vi få giltigt index
                                txtruta.setSelectedIndex(index); //Markera och scrolla dit
                                ruta.getVerticalScrollBar().setValue(txtruta.getCellBounds(index, index).y);
                            }
                        }
                    }
            });

            frame.pack();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });

        */
    }
}
