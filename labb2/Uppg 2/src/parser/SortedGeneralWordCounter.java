package parser;

import java.util.*;


public class SortedGeneralWordCounter extends GeneralWordCounter {
    private Map<String, Integer> sorted;
    private List<Map.Entry<String, Integer>> sortedArray;
    
    
    public SortedGeneralWordCounter(){
        super();
        //LinkedHashMap bryr sig om ordningen på elementen som inputas
        //Kommer retunera elementen i den ordning som de blev inlagda
        sorted = new LinkedHashMap<>();
    }

    public void sort(){
        //Skapar en arraylist som kommer att innehålla alla entrysets från
        //superklassens map
        sortedArray = new ArrayList<>(super.map.entrySet());
        
        //logiskt uttryck för sorterinen
        sortedArray.sort((a,b) -> {
            if(a.getKey().compareTo(b.getKey()) == 0){
                return a.getKey().compareTo(b.getKey());
            }else{
                return b.getValue()-a.getValue();
            }
        });
        
        //Skriver över den sorterade Arraylisten till en hashMap som report sendan använder
        for(Map.Entry<String, Integer> entry : sortedArray){
            sorted.put(entry.getKey(),entry.getValue());
        }
    }

    @Override
    public String report(){
        //Samma stringBuilder som i förregående uppg med skillnaden
        //att den kallar på sort() innan den börjar sätta ihop Stringen
        sort();
        StringBuilder sb = new StringBuilder();
        for(String ord : sorted.keySet()){
            if(sorted.get(ord) >= LIMIT){
                sb.append(ord);
                sb.append(": ");
                sb.append(map.get(ord));
                sb.append(", ");
            }
        }

        return sb.toString().trim();
    }


}
