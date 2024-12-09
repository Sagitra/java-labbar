package parser;


import java.util.*;


public class SortedGeneralWordCounter extends GeneralWordCounter {
    private List<Map.Entry<String, Integer>> sortedArray;
    
    
    public SortedGeneralWordCounter(String path){
        super(path);
    }

    public void sort(){
        //Skapar en arraylist som kommer att innehålla alla entrysets från
        //superklassens map
        sortedArray = new ArrayList<>(super.map.entrySet());

        //logiskt uttryck för sorteringen
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
        
        for(Map.Entry<String, Integer> entry : sortedArray){
            String key = entry.getKey();
            int value = entry.getValue();
            if(value >= LIMIT){
                sb.append(key);
                sb.append(": ");
                sb.append(value);
                sb.append(", ");
            }
        }
        return sb.toString().trim();
    }


}
