import java.util.ArrayList;

public class Dozent extends Person {

    private String dozNum = "";

    ArrayList <LVA> dozLVA = new ArrayList<>();

    //Constructor


    public Dozent(String vor, String nach, String ausweis, String offnum) {
        this.setVorname(vor);
        this.setNachname(nach);
        this.setAusweis(ausweis);
        dozNum = offnum;
    }

    public Dozent(String vor, String nach) {
        this.setVorname(vor);
        this.setNachname(nach);
    }

    public Dozent(String vor, String nach, String ausweis) {
        this.setVorname(vor);
        this.setNachname(nach);
        this.setAusweis(ausweis);
    }



    //Functions

    protected ArrayList<LVA> getLVA() {
        return dozLVA;
    }
    public void addLVA(LVA newLVA) {
        dozLVA.add(newLVA);
    }
    public void removeLVA(LVA newLVA) {
        dozLVA.remove(newLVA);
    }

    public boolean equals(Object myobj) {
        Dozent temp = (Dozent) myobj;
        if(this.getAusweis().equals(temp.getAusweis())) {
            return true;
        }
        return false;
    }

    protected int getDozLVAsize(){return dozLVA.size();}

    public void printdozLVA() {

        for (int i=0; i<dozLVA.size(); i++) {
            System.out.println(dozLVA.get(i));

        }
    }

    public static boolean Dozsuitable(String temp) {
        if((temp.matches("[0-9]+")) && (temp.length()==11)){
            return true;
        }
        else{
            return false;
        }
    }

    public String toString() {
        return this.getAusweis() + " , " + this.getVorname() + " " + this.getNachname().toUpperCase();
    }


}
