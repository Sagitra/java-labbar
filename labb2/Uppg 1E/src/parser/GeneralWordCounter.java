package parser;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;

public class GeneralWordCounter implements TextProcessor{
    protected ArrayList<String> illegal;
    protected HashMap<String, Integer> map;
    protected final static int LIMIT = 2;
    
    public GeneralWordCounter(){
        illegal = forbiddenWords();
        map = new HashMap<>();
    }

    public void process(String w){
        if(!illegal.contains(w)){
            map.put(w, map.getOrDefault(w, 0) + 1);
        }
    }

    public String report(){
        StringBuilder sb = new StringBuilder();
        for(String ord : map.keySet()){
            if(map.get(ord) >= LIMIT){
                sb.append(ord);
                sb.append(": ");
                sb.append(map.get(ord));
                sb.append("\n");
            }
        }

        return sb.toString().trim();
    }

    //Metod som hämtar de förbjudna orden från den förbjudna listan
    private ArrayList<String> forbiddenWords(){
        ArrayList<String> illegal = new ArrayList<>();
        try {
            Scanner scanner = ScannerFactory.scannerForNaturalLanguage("input/undantagsord.txt");
            while(scanner.hasNext()){
                illegal.add(scanner.next());
            }
        } catch (Exception FileNotFoundException) {
            System.out.println("icke giltig path");
        }
        return illegal;
    }
}