package CucumberFramwork1.model;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class Voiture implements Comparable<Voiture>{

    private int id;
    private String matricule;
    private String model;
    private List list;

    public static Comparator<Voiture> comparator=new Comparator<Voiture>() {
        @Override
        public int compare(Voiture o1, Voiture o2) {
            return o1.getMatricule().compareTo(o2.getMatricule());
        }
    };
    public Voiture(int id, String matricule, String model) {
        this.id = id;
        this.matricule = matricule;
        this.model = model;
    }
    public Voiture(Voiture v){
        this.id = v.getId();
        this.matricule = v.getMatricule();
        this.model = v.getModel();
    }
    public Voiture(){

    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        if (matricule.equals("null")){
            this.matricule="";
        }else {
            this.matricule = matricule;
        }

    }

    public String getModel() {

        return model;
    }

    public void setModel(String model) {
        if(model.equals("null")){
            this.model="";
        }else {
            this.model = model;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Voiture voiture = (Voiture) o;
        return id == voiture.id && Objects.equals(matricule, voiture.matricule) && Objects.equals(model, voiture.model);
    }

    @Override
    public String toString() {
        return "Voiture{" +
                "id=" + id +
                ", matricule='" + matricule + '\'' +
                ", model='" + model + '\'' +
                ", list=" + list +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, matricule, model);
    }

    @Override
    public int compareTo(Voiture o) {
        return this.matricule.compareTo(o.matricule);
    }

}
