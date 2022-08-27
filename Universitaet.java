import java.util.ArrayList;

public class Universitaet {

    private String name ="X";
    private String city ="Y";
    private boolean technik = false;
    private ArrayList<Student> Studenten = new ArrayList<Student>();
    private ArrayList<Dozent> Dozent = new ArrayList<Dozent>();
    private ArrayList<LVA> LVA = new ArrayList<LVA>();


    //Constructor

     public Universitaet(String name,String city,boolean technik){
         this.name = name;
         this.city = city;
         this.technik = technik;
     }

     public ArrayList<Student> getStudenten(){
         return Studenten;
     }

    public ArrayList<Dozent> getDozent(){
        return Dozent;
    }

    public ArrayList<LVA> getLVA(){
        return LVA;
    }

 //Functions

    //Case 1

    public void addStudent(Student newS) {
        Studenten.add(newS);
    }

    //Case 2

    public void alleStudenten() {
        for (int i=0; i<Studenten.size(); i++) {
            System.out.println(Studenten.get(i).toString());
        }
    }
    //Case 3

    public void searchStudent(String temp) {

        for(int i=0; i<Studenten.size(); i++) {
            if(temp.equals(Studenten.get(i).getMatrikelNum())) {
                System.out.println(Studenten.get(i));
                System.out.println("ögrenci bulundu");
                break;
            }
            if(i==Studenten.size()-1){
                System.out.println("ögrenci bulunamadı");
                break;
            }
        }
    }

    //Case 4

    public void removeStudent(String temp) {
        for(int i=0; i<Studenten.size(); i++){
            if(temp.equals(Studenten.get(i).getMatrikelNum())) {
                Studenten.remove(i);
                System.out.println("silindi");
                break;
            }
            if(i==Studenten.size()-1){
                System.out.println("bulunamadı");
                break;
            }
        }
    }

    //Case 5


    public void addLVAtoStd(String tempMN,String LVACod ){

        for(int i=0; i<Studenten.size(); i++) {
            if(tempMN.equals(Studenten.get(i).getMatrikelNum())) {
                if(searchLVAforStd(LVACod) != null){

                    if(Studenten.get(i).getstdLVAsize()==0){
                        Studenten.get(i).addLVA(searchLVAforStd(LVACod));
                        searchLVAforStd(LVACod).addStudent(Studenten.get(i));
                        System.out.println("ögrenciyi derse eklendi : ");
                        break;
                    }
                    else {
                        for(int j=0; j<Studenten.get(i).getstdLVAsize(); j++){
                            if(!LVACod.equals(Studenten.get(i).getLVA().get(j).getLescode())){
                                Studenten.get(i).addLVA(searchLVAforStd(LVACod));
                                searchLVAforStd(LVACod).addStudent(Studenten.get(i));
                                System.out.println("ögrenciyi derse eklendi : ");
                                break;
                            }
                            else{
                                System.out.println("ögrenciyi zaten bu dersi almis : ");
                                break;
                            }

                        }
                        break;
                    }



                }
                else{
                    System.out.println("ders bulunamadı");
                    break;
                }

            }
            if(i==Studenten.size()-1){
                System.out.println("ögrenci bulunamadı");
                break;
            }
        }

    }

    public LVA searchLVAforStd(String temp) {

        for(int i=0; i<LVA.size(); i++) {
            if(temp.equals(LVA.get(i).getLescode())) {
                return LVA.get(i);

            }
            if(i==LVA.size()-1){
                return null;
            }
        }
        return null;
    }

    public boolean searchStudentcheck(String temp) {

        for(int i=0; i<Studenten.size(); i++) {
            if(temp.equals(Studenten.get(i).getMatrikelNum())) {
                return true;
            }
            if(i==Studenten.size()-1){
                return false;
            }
        }
        return false;
    }

    public boolean searchLVAcheck(String temp) {

        for(int i=0; i<LVA.size(); i++) {
            if(temp.equals(LVA.get(i).getLescode())) {
                return true;
            }
            if(i==LVA.size()-1){
                return false;
            }
        }
        return false;
    }

    //Case 6

    public void deleteLVAtoStd(String tempMN,String LVACod ){

        for(int i=0; i<Studenten.size(); i++) {
            if(tempMN.equals(Studenten.get(i).getMatrikelNum())) {
                if(searchLVAforStd(LVACod) != null){
                    Studenten.get(i).deleteLVA(searchLVAforStd(LVACod));
                    searchLVAforStd(LVACod).removeStudent(Studenten.get(i));
                    System.out.println("ögrencinin sectigniz dersi silindi : ");
                    break;
                }
                else{
                    System.out.println("ders bulunamadı");
                    break;
                }

            }
            if(i==Studenten.size()-1){
                System.out.println("ögrenci bulunamadı");
                break;
            }
        }

    }

    public boolean showLVAforStdcheck(String tempMN){

        for(int i=0; i<Studenten.size(); i++) {
            if(tempMN.equals(Studenten.get(i).getMatrikelNum())) {
                if(Studenten.get(i).getstdLVAsize()>0){
                    return true;
                }
                else
                {
                    return false;
                }
            }

        }
    return false;
    }




    //Case 7

    public void showLVAforStd(String tempMN){

        for(int i=0; i<Studenten.size(); i++) {
            if(tempMN.equals(Studenten.get(i).getMatrikelNum())) {
                if(Studenten.get(i).getstdLVAsize()>0){
                    Studenten.get(i).printLVA();
                    break;
                }
                else
                {
                    System.out.println("ögrencinin aldigi ders yok");
                    break;
                }

            }

            if(i==Studenten.size()-1){
                System.out.println("ögrenci bulunamadı");
                break;
            }

        }

    }



    //Case 8

    public void addDozent(Dozent newD) {
        Dozent.add(newD);
    }

    //Case 9

    public void alleDozent() {
        for (int i=0; i<Dozent.size(); i++) {
            System.out.println(Dozent.get(i).toString());
        }
    }

    //Case 10

    public void searchDozent(String temp) {

        for(int i=0; i<Dozent.size(); i++) {
            if(temp.equals(Dozent.get(i).getAusweis())) {
                System.out.println(Dozent.get(i));
                System.out.println("dozent bulundu");
                break;
            }
            if(i==Dozent.size()-1){
                System.out.println("dozent bulunamadı");
                break;
            }
        }
    }

    //Case 11

    public void removeDozent(String temp) {
        for(int i=0; i<Dozent.size(); i++){
            if(temp.equals(Dozent.get(i).getAusweis())) {
                Dozent.remove(i);
                System.out.println("dozent silindi");
                break;
            }
            if(i==Dozent.size()-1){
                System.out.println("dozent bulunamadı");
                break;
            }
        }
    }

    //Case 12

    public void addLVAtoDoz(String tempMN,String LVACod ){

        for(int i=0; i<Dozent.size(); i++) {
            if(tempMN.equals(Dozent.get(i).getAusweis())) {
                if(searchLVAforDoz(LVACod) != null){

                    if(Dozent.get(i).getDozLVAsize()==0){
                        Dozent.get(i).addLVA(searchLVAforDoz(LVACod));
                        searchLVAforDoz(LVACod).addDozent(Dozent.get(i));
                        System.out.println("dozent derse eklendi : ");
                        break;
                    }
                    else {
                        for(int j=0; j<Dozent.get(i).getDozLVAsize(); j++){
                            if(!LVACod.equals(Dozent.get(i).getLVA().get(j).getLescode())){
                                Dozent.get(i).addLVA(searchLVAforDoz(LVACod));
                                searchLVAforDoz(LVACod).addDozent(Dozent.get(i));
                                System.out.println("dozent derse eklendi : ");
                                break;
                            }
                            else{
                                System.out.println("dozent zaten bu dersi verio : ");
                                break;
                            }

                        }
                        break;
                    }



                }
                else{
                    System.out.println("ders bulunamadı");
                    break;
                }

            }
            if(i==Dozent.size()-1){
                System.out.println("dozent bulunamadı");
                break;
            }
        }

    }

    public LVA searchLVAforDoz(String temp) {

        for(int i=0; i<LVA.size(); i++) {
            if(temp.equals(LVA.get(i).getLescode())) {
                return LVA.get(i);

            }
            if(i==LVA.size()-1){
                return null;
            }
        }
        return null;
    }

    public boolean searchDozentcheck(String temp) {

        for(int i=0; i<Dozent.size(); i++) {
            if(temp.equals(Dozent.get(i).getAusweis())) {
                return true;
            }
            if(i==Dozent.size()-1){
                return false;
            }
        }
        return false;
    }



    //Case 13

    public void deleteLVAtoDoz(String tempMN,String LVACod ){

        for(int i=0; i<Dozent.size(); i++) {
            if(tempMN.equals(Dozent.get(i).getAusweis())) {
                if(searchLVAforDoz(LVACod) != null){
                    Dozent.get(i).removeLVA(searchLVAforDoz(LVACod));
                    searchLVAforDoz(LVACod).removeDozent(Dozent.get(i));
                    System.out.print("dozentin sectigniz dersi silindi : ");
                    break;
                }
                else{
                    System.out.println("ders bulunamadı");
                    break;
                }

            }
            if(i==Dozent.size()-1){
                System.out.println("ögrenci bulunamadı");
                break;
            }
        }

    }

    public boolean showLVAforDozcheck(String tempMN){

        for(int i=0; i<Dozent.size(); i++) {
            if(tempMN.equals(Dozent.get(i).getAusweis())) {
                if(Dozent.get(i).getDozLVAsize()>0){
                    return true;
                }
                else
                {
                    return false;
                }
            }

        }
        return false;
    }

    //Case 14

    public void showLVAforDoz(String tempMN){

        for(int i=0; i<Dozent.size(); i++) {
            if(tempMN.equals(Dozent.get(i).getAusweis())) {
                if(Dozent.get(i).getDozLVAsize()>0){
                    Dozent.get(i).printdozLVA();
                    break;
                }
                else
                {
                    System.out.println("dozentin verdigi ders yok");
                    break;
                }

            }

            if(i==Dozent.size()-1){
                System.out.println("dozent bulunamadı");
                break;
            }

        }

    }



    //Case 15

    public void addLVA(LVA newLVA) {
        LVA.add(newLVA);
    }

    //Case 16

    public void alleLVA() {
        for (int i=0; i<LVA.size(); i++) {
            System.out.println(LVA.get(i));
        }
    }

    //Case 17

    public void searchLVA(String temp) {

        for(int i=0; i<LVA.size(); i++) {
            if(temp.equals(LVA.get(i).getLescode())) {
                System.out.println(LVA.get(i));
                System.out.println("LVA BULUNDU");
                break;

            }
            if(i==LVA.size()-1){
                System.out.println("LVA BULUNAMADI");
                break;
            }
        }

    }

    //Case 18

    public void removeLVA(String temp) {
        for(int i=0; i<LVA.size(); i++){
            if(temp.equals(LVA.get(i).getLescode())) {

                LVA.remove(i);

                for (int a=0; a<Studenten.size(); a++){

                    for (int b=0; b<Studenten.get(a).getstdLVAsize(); b++){
                        if(temp.equals(Studenten.get(a).getLVA().get(b).getLescode())){
                            Studenten.get(a).getLVA().remove(b);
                            System.out.println("ders ögrenciden silindi");
                        }
                    }
                }

                for (int a=0; a<Dozent.size(); a++){

                    for (int b=0; b<Dozent.get(a).getDozLVAsize(); b++){
                        if(temp.equals(Dozent.get(a).getLVA().get(b).getLescode())){
                            Dozent.get(a).getLVA().remove(b);
                            System.out.println("ders dozentten silindi");
                        }
                    }
                }

            }
            if(i==LVA.size()-1){
                System.out.println("ders bulunamadı");
                break;
            }
        }
    }

    //Case 19

    public void StdinLVA(String tempLVA){

        for(int i=0; i<LVA.size(); i++) {
            if(tempLVA.equals(LVA.get(i).getLescode())) {
                if(LVA.get(i).getAlleStundenten().size()>0){
                    LVA.get(i).printstd();
                    break;
                }
                else
                {
                    System.out.println("lvaya kayıtlı ögrenci yok");
                    break;
                }

            }

            if(i==LVA.size()-1){
                System.out.println("lva bulunamadı");
                break;
            }

        }

    }


    //Case 20


    public void DozinLVA(String tempLVA){

        for(int i=0; i<LVA.size(); i++) {
            if(tempLVA.equals(LVA.get(i).getLescode())) {
                if(LVA.get(i).getAlleDozent().size()>0){
                    LVA.get(i).printdoz();
                    break;
                }
                else
                {
                    System.out.println("lvayı veren doz yok");
                    break;
                }

            }

            if(i==LVA.size()-1){
                System.out.println("lva bulunamadı");
                break;
            }

        }

    }








}
