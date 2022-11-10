package superhero2.comparator;
import superhero2.Superhero;
import java.util.Comparator;


public class FlexibleComparator implements Comparator<Superhero> {
    private String sortedList;
    public FlexibleComparator(String sortedInput){
        this.sortedList = sortedInput;
    }

    @Override
    public int compare (Superhero o1, Superhero o2){
        switch (sortedList){
            case "Superhero name" -> {
                return o1.getHeroName().compareTo(o2.getHeroName());
            }
            case "Real name of superhero" -> {
                return o1.getRealName().compareTo(o2.getRealName());
            }
            case "Creation year" -> {
                return Integer.compare(o1.getCreationYear(), o2.getCreationYear());
            }
            case "Superhero superpower" -> {
                return o1.getSuperpower().compareTo(o2.getSuperpower());
            }
            case "Human status" -> {
                return Boolean.compare(o1.isHuman(),o2.isHuman());
            }
            case "Strenght" -> {
                return Double.compare(o1.getStrength(),o2.getStrength());
            }
        }
        return 0;
    }

}
