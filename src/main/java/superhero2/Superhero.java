package superhero2;

public class Superhero {

    private String helteNavn;
    private String ægteNavn;
    private int årstal;
    private String superkraft;
    private boolean human;
    private double power;

    public Superhero(String helteNavn, String ægteNavn, int årstal, String superkraft, boolean human, double power) {
        this.helteNavn = helteNavn;
        this.ægteNavn = ægteNavn;
        this.årstal = årstal;
        this.superkraft = superkraft;
        this.human = human;
        this.power=power;
    }

    public Superhero() {

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
    public double getPower() {
        return power;
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
    public void setPower(double power){
        this.power=power;
    }

    @Override
    public String toString() {
        return "Superhero{" +
                "helteNavn='" + helteNavn + '\'' +
                ", ægteNavn='" + ægteNavn + '\'' +
                ", årstal=" + årstal +
                ", superkraft='" + superkraft + '\'' +
                ", human=" + human +
                ", power=" + power +
                '}';
    }
}
