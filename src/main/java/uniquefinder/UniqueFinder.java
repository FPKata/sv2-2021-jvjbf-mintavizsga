package uniquefinder;

import java.util.ArrayList;
import java.util.List;

public class UniqueFinder {
    public List<Character> getUniqueChars(String word){
        if (word == null){
            throw new IllegalArgumentException("Text is null.");
        }
        List<Character> list = new ArrayList<>();
        for (Character ch : word.toCharArray()){
            if (!list.contains(ch)){
                list.add(ch);
            }
        }
        return  list;
    }


}
