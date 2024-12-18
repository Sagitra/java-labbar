package parser;


import java.util.*;


public class SortedGeneralWordCounter extends GeneralWordCounter {
    private List<Map.Entry<String, Integer>> sortedArray;
    
    
    public SortedGeneralWordCounter(String path){
        super(path);
    }

    public void sort(List<Map.Entry<String, Integer>> wordList){
        //Skapar en arraylist som kommer att innehålla alla entrysets från
        //superklassens map
        sortedArray = new ArrayList<>(wordList);

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
        sort(super.getWordList());
        StringBuilder sb = new StringBuilder();
        
        for(Map.Entry<String, Integer> temp : sortedArray){
            sb.append(temp.toString());
            sb.append(", ");
        }
        return sb.toString().trim();
    }


}
