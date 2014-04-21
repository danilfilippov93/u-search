/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Beans;

import ru.mipt.search.MssFile;
import ru.mipt.search.database.MssFileLocator;
import ru.mipt.search.searchmodul.*;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
@RequestScoped
public class SearchBean {

    private String searchString;
    private boolean findByServer = false;
    List<MssFile> lib = new ArrayList<MssFile>();


    public void searchBean() {
       }

    public void push() {
        SearchEngine searchEngine = new SearchEngine(searchString);
        lib.addAll(searchEngine.getLib());
    }

    public String getSearchString() {
        return searchString;
    }

    public void setSearchString(String searchString) {
        this.searchString = searchString;
    }

    public List<MssFile> getLib() {
        return lib;
    }

    public void setLib(List<MssFile> lib) {
        this.lib = lib;
    }

    public String getResult() {
        if ("".equals(searchString) || searchString == null) {
            return "";
        } else {
            return searchString;
        }
    }

    public boolean isFindByServer() {
        return findByServer;
    }

    public void setFindByServer(boolean findByServer) {
        this.findByServer = findByServer;
    }
}
