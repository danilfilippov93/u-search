package ru.mipt.search.searchmodul;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SearchModulation implements SearchModul {
    public List<Words> listOfWords = new ArrayList<Words>();
    public List listOfStringWords = new ArrayList();

    public SearchModulation(String searchString) {
        listOfStringWords = stringToWords(searchString);
        listOfStringWords = changeOrUnchange(listOfStringWords);
        stringToList(listOfStringWords);
    }

    public void stringToList(List<String> stringLine) {
        int length = stringLine.size();
        for (int i = 0; i < length; i++){
            listOfWords.add(i,new Words(listOfStringWords.get(i).toString()));
        }
    }

    public List stringToWords(String searchString) {//разбивает строку на слова
        StringTokenizer token = new StringTokenizer(searchString.toLowerCase());
        List result = new ArrayList<String>();
        while (token.hasMoreTokens()) {
            result.add(token.nextToken());
        }
        return result;
    }

    public List changeOrUnchange(List words){
        int length = words.size();
        List copyList = new ArrayList();
        for (int i = 0; i < length; i++){
            if (words.get(i).toString().startsWith("\"")){
                if(!words.get(i).toString().endsWith("\"")){
                    String copy = words.get(i).toString();
                    int k = 0;
                    while (words.get(i+k+1).toString().endsWith("\"")){
                        copy = copy + " " + words.get(i+k+1).toString();
                        k++;
                    }
                    copyList.add(copy);
                    i += k;
                }
                else{
                    copyList.add(words.get(i).toString());
                }
            }else{
                copyList.add(words.get(i).toString());
            }
        }
        return copyList;
    }
}
