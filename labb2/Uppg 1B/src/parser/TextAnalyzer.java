package parser;

import java.util.Scanner;
import java.util.List;


public class TextAnalyzer {

    List<TextProcessor> processors;

    public TextAnalyzer(List<TextProcessor> textProcessor) {
        this.processors = textProcessor;
    }

    public String analyzeText(Scanner scanner) {
        //Sålänge det finns ord att hämta så körs loopen
        while (scanner.hasNext()) {
            //hämtar ordet
            String ord = scanner.next().toLowerCase();
            
            //För varje temporärt ex av typen TextProcessor i listan processors
            for(TextProcessor ex : processors){
                //Skickar vidare ordet till Process
                ex.process(ord);
            }
        }
        scanner.close();
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < processors.size(); i++){
            sb.append(processors.get(i).report());
            if(i < processors.size()-1){
                sb.append("\n");
            }
        }
        /* Hitta ej ett smart sätt att bli av med \n i slutet av sista med
        en for-each 
        for(TextProcessor temp : processors){
            sb.append(temp.report());
            sb.append("\n");            
        }
        */
        return sb.toString();
    }
}