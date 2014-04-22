package Beans;

import ru.mipt.search.MssFile;
import ru.mipt.search.searchmodul.*;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.List;

@ManagedBean
@SessionScoped
public class SearchBean {

    private int currentPage = 0;
    private int countElementsOnPage = 1;
    private int maxNumberOfPages; // number starts with zero
    private String searchString;
    private boolean findByServer = false;
    List<MssFile> lib = null;

    public void searchBean() {
    }

    public void push() {
        SearchEngine searchEngine = new SearchEngine(searchString);
        maxNumberOfPages = searchEngine.getLib().size()/countElementsOnPage - 1;
        if(searchEngine.getLib().size()%countElementsOnPage != 0)
            maxNumberOfPages++;
        lib = searchEngine.getLib();
    }

    public String getSearchString() {
        return searchString;
    }

    public void setSearchString(String searchString) {
        this.searchString = searchString;
    }

    public List<MssFile> getLib() {
        if(lib != null)
            return lib.subList(currentPage * countElementsOnPage, countElementsOnPage *(currentPage + 1));
        return null;
    }

    public void setLib(List<MssFile> lib) {
        this.lib = lib;
    }

    public boolean isFindByServer() {
        return findByServer;
    }

    public void setFindByServer(boolean findByServer) {
        this.findByServer = findByServer;
    }

    public void toNextPage() {
        if(currentPage < maxNumberOfPages)
            currentPage++;
    }

    public void toPreviousPage() {
        if(currentPage > 0)
            currentPage--;
    }

}

