package parser;

import java.util.*;


public class GeneralWordCounter implements TextProcessor{
    protected ArrayList<String> illegal;
    protected Map<String, Integer> map;

    //Måste vara större eller lika med
    protected final static int LIMIT = 0;
    
    String path;
    
    public GeneralWordCounter(String path){
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
        for(Map.Entry<String, Integer> temp : getWordList()){
            sb.append(temp.toString());
            sb.append(", ");
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
            System.out.println("icke giltig path: GWC");
        }
        return illegal;
    }

    public List<Map.Entry<String, Integer>> getWordList(){
        List<Map.Entry<String, Integer>> tempList = new ArrayList<>();
        for(Map.Entry<String, Integer> temp : map.entrySet()){
            if(temp.getValue() >= LIMIT){
                //if(!tempList.contains(temp)){
                    tempList.add(temp);
                    System.out.println("HEj");
                //}

            } 
        }
        System.out.println(tempList.toString());
        return tempList;
    }
}