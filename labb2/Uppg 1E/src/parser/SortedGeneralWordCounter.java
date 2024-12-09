package parser;

import java.util.*;


public class SortedGeneralWordCounter extends GeneralWordCounter {
    private List<Map.Entry<String, Integer>> sortedArray;
    
    
    public SortedGeneralWordCounter(){
        super();
    }

    public void sort(){
        //Skapar en arraylist som kommer att innehålla alla entrysets från
        //superklassens map
        sortedArray = new ArrayList<>(super.map.entrySet());
        
        //logiskt uttryck för sorterinen
        sortedArray.sort((a,b) -> {
            if(a.getValue() == b.getValue()){
                return a.getKey().compareTo(b.getKey());
            }else{
                return b.getValue()-a.getValue();
            }
        });
    }

    @Override
    public String report(){
        sort();
        StringBuilder sb = new StringBuilder();
        //Skulle man lägga tillbaka arraylisten till en Map skulle ordningen ändra pga
        //Hur Map strukturen ser ut, printar därför bara ut array istället
        for(Map.Entry<String, Integer> entry : sortedArray){
            String key = entry.getKey();
            int value = entry.getValue();
            if(value >= LIMIT){
                sb.append(key);
                sb.append(": ");
                sb.append(value);
                sb.append("\n");
            }
        }
        return sb.toString().trim();
    }


}
