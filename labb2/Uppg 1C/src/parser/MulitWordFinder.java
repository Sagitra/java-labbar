package parser;

import java.util.HashMap;

public class MulitWordFinder implements TextProcessor{
    private String[] ord;
    private HashMap<String, Integer> map;

    public MulitWordFinder(String[] ord){
        this.ord = ord;
        map = new HashMap<>();

        for(String s : ord){
            map.put(s, 0);
        }
    }

    public void process(String w){
        if(map.containsKey(w)){
            map.put(w, map.get(w)+1);
        }
    }

    public String report(){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < map.size(); i++){
            sb.append(ord[i] + ": ");
            sb.append(map.get(ord[i]));
            
            if(i < map.size()-1){
                sb.append("\n");
            }
        }


        return sb.toString();
    }
}
