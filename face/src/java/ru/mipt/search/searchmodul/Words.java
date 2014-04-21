package ru.mipt.search.searchmodul;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Words {
    public String allWord;
    public String rootWord;
    boolean unchanged  = false;
    boolean findByServer = false;

    public Words(String stringForWord) {
        if((stringForWord.charAt(0) == '"') && (stringForWord.charAt(stringForWord.length()-1)) == '"') {
            stringForWord = stringForWord.substring(1,stringForWord.length()-1);
            unchanged = true;
        }
        findStringAndSet(stringForWord); //ищем стлова сервер выставляем флаг и обрезаем строку

        findRootOfWord(getAllWord());  // пока только отбрасываем икончание
     }

    public void findStringAndSet(String string){
        Pattern p = Pattern.compile("^server:.*");
        Matcher m = p.matcher(string);
        if (m.matches()){
            findByServer = true;
            setAllWord(changeString(string));
        }
        setAllWord(string);
    }

    public String changeString (String string){
        int position = string.indexOf(":");
        string = string.substring(position+1);
        return string;
    }

    public void findRootOfWord(String string){
        if(string.length() > 4){
           string = string.substring(0,string.length() - 2);
        }
        setRootWord(string);
    }
    public String getAllWord() {
        return allWord;
    }

    public void setAllWord(String allWord) {
        this.allWord = allWord;
    }

    public String getRootWordWord() {
        return rootWord;
    }

    public void setRootWord(String rootWord) {
        this.rootWord = rootWord;
    }

    public boolean isUnchanged() {
        return unchanged;
    }

    public void setUnchanged(boolean unchanged) {
        this.unchanged = unchanged;
    }

    public boolean isFindByServer() {
        return findByServer;
    }

    public void setFindByServer(boolean findByServer) {
        this.findByServer = findByServer;
    }
}
