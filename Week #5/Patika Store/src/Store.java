import java.util.ArrayList;

public class Store {
    ArrayList<MobilePhone> mobilePhones;
    ArrayList<Notebook> notebook;


    public Store() {
        this.mobilePhones = new ArrayList<MobilePhone>();
        this.notebook = new ArrayList<Notebook>();
    }

    public ArrayList<MobilePhone> getMobilePhones() {
        return mobilePhones;
    }

    public void setMobilePhones(ArrayList<MobilePhone> mobilePhones) {
        this.mobilePhones = mobilePhones;
    }

    public ArrayList<Notebook> getNotebook() {
        return notebook;
    }

    public void setNotebook(ArrayList<Notebook> notebook) {
        this.notebook = notebook;
    }

    public void addMobilePhone(MobilePhone mb) {

    }

    public void addNotebook(Notebook nt) {

    }

    public void removePhone(MobilePhone mb) {

    }

    public void removeNotebook(Notebook nt) {

    }




}
