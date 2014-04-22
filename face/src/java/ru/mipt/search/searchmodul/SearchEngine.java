package ru.mipt.search.searchmodul;

import ru.mipt.search.MssFile;
import ru.mipt.search.database.MssFileLocator;
import java.util.ArrayList;
import java.util.List;

public class SearchEngine {
    List<MssFile> lib = new ArrayList<MssFile>();
    MssFileLocator locator = new MssFileLocator();
    SearchModulation searchmod;
    boolean findByServer = false;

    public SearchEngine(String searchString) {
        searchmod = new SearchModulation (searchString);

        for(int i = 0 ; i < searchmod.listOfWords.size(); i++){
            if(searchmod.listOfWords.get(i).isFindByServer())
                findByServer = true;
        }

        if(findByServer){
            resultByServer();
        }
        else {
            resultByName();
        }
    }

    public void resultByServer(){
        int i = 0;
        while(searchmod.listOfWords.size() != i){
            lib.addAll(locator.findFilesByServer(searchmod.listOfWords.get(i).allWord, 0, 100));
            i++;
        }
    }

    public void resultByName(){
        int i = 0;
        while(searchmod.listOfWords.size() != i){
            lib.addAll(locator.findFilesByName(searchmod.listOfWords.get(i).allWord, 0, 100));
            i++;
        }
    }

    public List<MssFile> getLib() {
        return lib;
    }
}
