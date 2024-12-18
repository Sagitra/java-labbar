package view.model;


import java.util.*;
import java.io.FileNotFoundException;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.assertEquals;
import parser.TextAnalyzer;


public class SortedListModelTest {
    @Test
    @DisplayName("GetWordList")
    //OBS KOLLA LIMIT OM DET EJ FUNKAR. I GWC
    public void getWordList() throws FileNotFoundException{
        TextAnalyzer analyzer = new TextAnalyzer("input/undantagsord.txt");
        List<Map.Entry<String, Integer>> result = analyzer.getWordList("test_data/Test.txt");
        System.out.println(result.toString());
        assertEquals("[gullan=2, hej=4, jojo=2, lucas=3]", result.toString());
    }

    @Test
    @DisplayName("SortedListModel-nbr")
    //OBS KOLLA LIMIT OM DET EJ FUNKAR. I GWC
    public void SLMN() throws FileNotFoundException{
        TextAnalyzer analyzer = new TextAnalyzer("input/undantagsord.txt");
        SortedListModel<Map.Entry<String, Integer>> sortedList = new SortedListModel<>(analyzer.getWordList("test_data/Test.txt"));
        sortedList.sort(Comparator.comparing(Map.Entry::getValue));
        assertEquals("[gullan=2, jojo=2, lucas=3, hej=4]", sortedList.getList().toString());
    }

    @Test
    @DisplayName("SortedListModel-alfa")
    //OBS KOLLA LIMIT OM DET EJ FUNKAR. I GWC
    public void SLMA() throws FileNotFoundException{
        TextAnalyzer analyzer = new TextAnalyzer("input/undantagsord.txt");
        SortedListModel<Map.Entry<String, Integer>> sortedList = new SortedListModel<>(analyzer.getWordList("test_data/Test.txt"));
        sortedList.sort(Comparator.comparing(Map.Entry::getKey));
        assertEquals("[gullan=2, hej=4, jojo=2, lucas=3]", sortedList.getList().toString());

    }

    @Test
    @DisplayName("SortedListModel-alfa")
    //OBS KOLLA LIMIT OM DET EJ FUNKAR. I GWC
    public void testIndexForEmptyList() {
        SortedListModel<Map.Entry<String, Integer>> model = new SortedListModel<>(new ArrayList<>());
        assertEquals(-1, model.indexFor(entry -> entry.getKey().equals("test")));

    }

    @Test
    @DisplayName("SortedListModel-alfa")
    //OBS KOLLA LIMIT OM DET EJ FUNKAR. I GWC
    public void testIndexForFirst() {
        ArrayList<Map.Entry<String, Integer>> lista = new ArrayList<>();
        lista.add(Map.entry("Banan", 4));
        lista.add(Map.entry("äpple", 3));
        lista.add(Map.entry("päron", 2));
        @SuppressWarnings({ "rawtypes", "unchecked" })
        SortedListModel<Map.Entry<String, Integer>> model = new SortedListModel(lista);
        assertEquals(0, model.indexFor(entry -> entry.getKey().equals("Banan")));
    }

    @Test
    @DisplayName("SortedListModel-alfa")
    //OBS KOLLA LIMIT OM DET EJ FUNKAR. I GWC
    public void testIndexForSecond() {
        ArrayList<Map.Entry<String, Integer>> lista = new ArrayList<>();
        lista.add(Map.entry("Banan", 4));
        lista.add(Map.entry("äpple", 3));
        lista.add(Map.entry("päron", 2));
        @SuppressWarnings({ "rawtypes", "unchecked" })
        SortedListModel<Map.Entry<String, Integer>> model = new SortedListModel(lista);
        assertEquals(1, model.indexFor(entry -> entry.getKey().equals("äpple")));
    } 
    
}