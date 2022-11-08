package superhero2;

public class Superhero {

    private String heroName;
    private String realName;
    private int creationYear;
    private String superpower;
    private boolean human;
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

    public boolean isHuman() {
        return human;
    }

    public String getHeroName() {
        return heroName;
    }

    public String getRealName() {
        return realName;
    }

    public int getCreationYear() {
        return creationYear;
    }

    public String getSuperpower() {
        return superpower;
    }

    public boolean getHuman() {
        return human;
    }

    public double getStrength() {
        return strength;
    }

    public void setHeroName(String heroName) {
        this.heroName = heroName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public void setCreationYear(int creationYear) {
        this.creationYear = creationYear;
    }

    public void setSuperpower(String superpower) {
        this.superpower = superpower;
    }

    public void setHuman(boolean human) {
        this.human = human;
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
}
