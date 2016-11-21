package by.nc.shpakovskaya.beans.diagnosis;

import java.io.Serializable;
import java.util.Comparator;

/**
 * Created by Valeria on 18.10.2016.
 */
public class Diagnosis implements Serializable, Comparable, Comparator<Diagnosis>{

    private String name;

    public Diagnosis(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int compare(Diagnosis obj1, Diagnosis obj2) {
        int k = obj1.getName()
                .compareTo(obj2.getName());
        if(k == 0) {
            return obj1.compareTo(obj2);
        }
        else {
            return k;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Diagnosis diagnosis = (Diagnosis) o;

        return name != null ? name.equals(diagnosis.name) : diagnosis.name == null;

    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    @Override
    public int compareTo(Object obj) {
        Diagnosis entry = (Diagnosis) obj;
        int result =  entry.getName().compareTo(this.getName());
        if(result != 0) {
            return result;
        }
        return 0;
    }
}
