import java.util.ArrayList;

public class Student extends Person {

    //Private Variables

    private String fakultaet = "";
    private String MatrikelNum ="";
    private String semester = "";


    //Lessons of Students

    private ArrayList<LVA> stdLVA = new ArrayList<LVA>();


    //Constructors

    public Student(String vorName,String MatrikelNum) {
        this.setVorname(vorName);
        this.MatrikelNum = MatrikelNum;
    }

    public Student(String vorName,String nachName,String MatrikelNum){
        this.setVorname(vorName);
        this.setNachname(nachName);
        this.MatrikelNum = MatrikelNum;
    }

    public Student(String vorName,String nachName,String MatrikelNum ,String semester , String fakultaet ,String alter , String Geburtsdatum , String personalAusweisNum){
        this.setVorname(vorName);
        this.setNachname(nachName);
        this.setAlter(alter);
        this.setAusweis(personalAusweisNum);
        this.setGeburtsdatum(Geburtsdatum);
        this.MatrikelNum = MatrikelNum;
        this.semester = semester;
        this.fakultaet = fakultaet;
    }



    //Get Functions

    protected String getMatrikelNum() {
        return MatrikelNum;
    }
    protected String getFakultaet() {
        return fakultaet;
    }
    protected String getsemester() {
        return semester;
    }
    protected ArrayList<LVA> getLVA() {
        return stdLVA;
    }
    protected int getstdLVAsize(){return stdLVA.size();}

    //Set Functions

    protected void setlernNum(String num){this.MatrikelNum = num;}
    protected void setFakultaet(String Fakul){this.fakultaet = Fakul;}
    protected void setsemester(String semes){this.semester = semes;}

    //Other Functions

    //LVA

    public void addLVA(LVA newLVA) {
        stdLVA.add(newLVA);
    }
    public void deleteLVA(LVA newLVA) {
        stdLVA.remove(newLVA);
    }
    public void printLVA() {

        for (int i=0; i<stdLVA.size(); i++) {
            System.out.println(stdLVA.get(i));

        }
    }

    //For Printing

    public String toString() {
        return this.getMatrikelNum() + " , " + this.getVorname() + " " + this.getNachname().toUpperCase();
    }

    //klassenmethode - suitable

    public static boolean numsuitable(String temp) {
        if((temp.matches("[0-9]+")) && (temp.length()==7) && (temp.charAt(0) != '0')){
            return true;
        }
        else{
            return false;
        }
    }

    //isequal

    public boolean equals(Object myobj){
        Student temp = (Student) myobj;
        if(this.MatrikelNum.equals(temp.MatrikelNum)){
            return true;
        }
        else
            return false;
    }


}
