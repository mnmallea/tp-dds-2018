package handlebarsUtils;

public class PagingViewModel {
    private int currentPage;
    private int lastPage;

    public PagingViewModel(int currentPage, int lastPage) {
        this.currentPage = currentPage;
        this.lastPage = lastPage;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public int getLastPage() {
        return lastPage;
    }

    public boolean getIsLast(){
        return currentPage == lastPage;
    }

    public boolean getIsFirst(){
        return currentPage == 1;
    }

    public int getNextPage(){
        return currentPage + 1;
    }

    public int getPreviousPage(){
        return currentPage - 1;
    }
}