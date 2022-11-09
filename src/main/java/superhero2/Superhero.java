package superhero2;

public class Superhero {

    private String heroName;
    private String realName;
    private int creationYear;
    private String superpower;
    private boolean human;
    private String humanternary;
    private double strength;

    public Superhero(String heroName, String realName, int creationYear, String superpower, boolean human, double strength) {
        this.heroName = heroName;
        this.realName = realName;
        this.creationYear = creationYear;
        this.superpower = superpower;
        this.human = human;
        this.strength = strength;
    }


    public Superhero() {

    }

    public String getHeroName() {
        return heroName;
    }

    public void setHeroName(String heroName) {
        this.heroName = heroName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public int getCreationYear() {
        return creationYear;
    }

    public void setCreationYear(int creationYear) {
        this.creationYear = creationYear;
    }

    public String getSuperpower() {
        return superpower;
    }

    public void setSuperpower(String superpower) {
        this.superpower = superpower;
    }

    public boolean isHuman() {
        return human;
    }

    public void setHuman(boolean human) {
        this.human = human;
    }

    public double getStrength() {
        return strength;
    }

    public void setStrength(double strength) {
        this.strength = strength;
    }

    @Override
    public String toString() {
        return "Superhero{" +
                "heroName='" + heroName + '\'' +
                ", realName='" + realName + '\'' +
                ", creationYear=" + creationYear +
                ", superpower='" + superpower + '\'' +
                ", human=" + human +
                ", strength=" + strength +
                '}';
    }

    //Ternary operator for boolean human
    public String getHumanternary() {
        String getHumanternary = (human) ? "No" : "Yes";
        return getHumanternary;
    }
}

