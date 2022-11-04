package Comparator;

import java.lang.reflect.Array;

public class NameComparator {

    public static void main (String[] args) {


    public class NavnComparator implements Comparator <Person> {
        public int compare(Person p1, Person p2) {
            return p1.getNavn().compareTo(p2.getNavn());
        }
    }
}
