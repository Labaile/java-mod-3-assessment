public class Patient {

    public int getHealthIndex() {
        return healthIndex;
    }

    public void setHealthIndex(int healthIndex) {
        this.healthIndex = healthIndex;
    }

    public Ailment getMyDisease() {
        return myDisease;
    }

    public void setMyDisease(Ailment myDisease) {
        this.myDisease = myDisease;
    }

    private int healthIndex;
    private Ailment myDisease;

    public Patient(String name, Ailment ailment) {
        this.name = name;
        this.myDisease = ailment;
        this.healthIndex = myDisease.getStartingHealthIndex();
    }

    public void receiveTreatment(int healed) {
        healthIndex += healed;
    }

    public boolean isHealed() {
        return this.healthIndex >= 100;
    }

    public boolean isDead() {
        return this.healthIndex <= 0;
    }

    // TODO: add tostring() method


    private String name;
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
}
