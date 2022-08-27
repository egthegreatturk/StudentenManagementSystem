import java.util.ArrayList;

public class LVA {

    private String lname = "";
    private String lescode = "";
    private String ort = "";
    private String zeit = "";
    private String datum = "";

    private ArrayList<Student> alleStundenten = new ArrayList<>();
    private ArrayList<Dozent> alleDozent = new ArrayList<>();

    //Constructors

    public LVA(String lnm, String code) {
        lname = lnm;
        lescode = code;
    }
    public LVA(String lnm, String code, String dat) {
        lname = lnm;
        lescode = code;
        datum = dat;
    }


    //Get Functions

    public String getLname() {
        return lname;
    }
    public String getLescode() {
        return lescode;
    }
    public String getZeit() {
        return zeit;
    }
    public String getDatum() {
        return datum;
    }
    public String getOrt() {
        return ort;
    }
    public ArrayList<Student> getAlleStundenten(){return alleStundenten;}
    public ArrayList<Dozent> getAlleDozent(){return alleDozent;}

    //Set Functions

    public void setLname(String n) {
        lname = n;
    }
    public void setLescode(String c) {
        lescode = c;
    }
    public void setDatum(String d) {
        datum = d;
    }
    public void setZeit(String z) {
        zeit = z;
    }
    public void setOrt(String o) {
        ort = o;
    }


    //Other Functions


    public void addStudent(Student newS) {
        alleStundenten.add(newS);
    }
    public void addDozent(Dozent newD) {
        alleDozent.add(newD);
    }

    
    public void removeStudent(Student remS) {
        alleStundenten.remove(remS);
    }
    public void removeDozent(Dozent remD) {
        alleDozent.remove(remD);
    }

    public void printstd() {

        for (int i=0; i<alleStundenten.size(); i++) {
            System.out.println(alleStundenten.get(i));

        }
    }

    public void printdoz() {

        for (int i=0; i<alleDozent.size(); i++) {
            System.out.println(alleDozent.get(i));

        }
    }


    public String toString() {
        return this.getLescode() + " : " + this.getLname();
    }

    public static boolean LVAsuitable(String temp) {
        if ((temp.length() == 6)){

            if((64< temp.charAt(0) && temp.charAt(0) <91) && 64< temp.charAt(1) && temp.charAt(1) <91 && 64< temp.charAt(2) && temp.charAt(2) <91){

                if(47 < temp.charAt(3) && temp.charAt(3) <58 && 47< temp.charAt(4) && temp.charAt(4) <58 && 47< temp.charAt(5) && temp.charAt(5) <58){

                    return true;
                }

            }
            else
                return false;

        }

        return false;


    }



    public boolean equals(Object myobj) {
        LVA temp = (LVA) myobj;
        if(lescode.equals(temp.lescode)) {
            return true;
        }
        return false;
    }






}

