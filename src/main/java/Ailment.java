public class Ailment {
    private int startingHealthIndex;

    public int getStartingHealthIndex() {
        return startingHealthIndex;
    }

    public void setStartingHealthIndex(int startingHealthIndex) {
        this.startingHealthIndex = startingHealthIndex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Specialty getAssociatedSpecialty() {
        return associatedSpecialty;
    }

    public void setAssociatedSpecialty(Specialty associatedSpecialty) {
        this.associatedSpecialty = associatedSpecialty;
    }

    private String name;
    private Specialty associatedSpecialty;

    public Ailment(String name, Specialty associatedSpecialty, int startingHealthIndex) {
        this.startingHealthIndex = startingHealthIndex;
        this.name = name;
        this.associatedSpecialty = associatedSpecialty;
    }
}
