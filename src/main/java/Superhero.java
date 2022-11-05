public class Superhero {

    private String helteNavn;
    private String ægteNavn;
    private int årstal;
    private String superkraft;
    private boolean human;

    public Superhero(String helteNavn, String ægteNavn, int årstal, String superkraft, boolean human) {
        this.helteNavn = helteNavn;
        this.ægteNavn = ægteNavn;
        this.årstal = årstal;
        this.superkraft = superkraft;
        this.human = human;
    }

    public String getHelteNavn() {
        return helteNavn;
    }

    public String getÆgteNavn() {
        return ægteNavn;
    }

    public int getÅrstal() {
        return årstal;
    }

    public String getSuperkraft() {
        return superkraft;
    }

    public boolean getHuman() {
        return human;
    }

    public void setHelteNavn(String helteNavn) {
        this.helteNavn = helteNavn;
    }

    public void setÆgteNavn(String ægteNavn) {
        this.ægteNavn = ægteNavn;
    }

    public void setÅrstal(int årstal) {
        this.årstal = årstal;
    }

    public void setSuperkraft(String superkraft) {
        this.superkraft = superkraft;
    }

    public void setHuman(boolean human) {
        this.human = human;
    }

    @Override
    public String toString() {
        return helteNavn + " " + ægteNavn + " " + årstal + " " + superkraft + " " + human;

    }
}
