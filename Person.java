public class Person {


    private String vorName="";
    private String nachName="";
    private String alter = "";
    private String Geburtsdatum = "";
    private String personalAusweisNum = "";


    //Get Functions

    protected String getVorname() {
        return vorName;
    }
    protected String getNachname() {
        return nachName;
    }
    protected String getAusweis(){
        return personalAusweisNum;
    }
    protected String getAlter(){
        return alter;
    }
    protected String getGeburtsdatum(){
        return Geburtsdatum;
    }


    //Set Functions

    protected void setVorname(String vorName) {
        this.vorName = vorName;
    }
    protected void setNachname(String nachName) {
        this.nachName = nachName;
    }
    protected void setAlter(String alter){this.alter = alter;}
    protected void setAusweis(String personalAusweisNum) {
        this.personalAusweisNum=personalAusweisNum;
    }
    protected void setGeburtsdatum(String Geburtsdatum){this.Geburtsdatum = Geburtsdatum;}
}
