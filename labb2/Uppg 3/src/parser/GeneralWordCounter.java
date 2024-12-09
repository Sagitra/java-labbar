package parser;

import java.util.*;


public class GeneralWordCounter implements TextProcessor{
    protected ArrayList<String> illegal;
    protected Map<String, Integer> map;

    //Måste vara större eller lika med
    protected final static int LIMIT = 1000;
    
    String path;
    
    public GeneralWordCounter(String path){
        this.path = path;
        illegal = forbiddenWords(path);

        //Här ändrandet från Hash till TreeMap sker
        map = new TreeMap<>();
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
    private ArrayList<String> forbiddenWords(String path){
        ArrayList<String> illegal = new ArrayList<>();
        try {
            Scanner scanner = ScannerFactory.scannerForNaturalLanguage(path);
            while(scanner.hasNext()){
                illegal.add(scanner.next());
            }
        } catch (Exception FileNotFoundException) {
            System.out.println("icke giltig path");
        }
        return illegal;
    }
}