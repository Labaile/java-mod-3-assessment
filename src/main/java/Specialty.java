public class Specialty {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumOfTreatments() {
        return numOfTreatments;
    }

    public void setNumOfTreatments(int numOfTreatments) {
        this.numOfTreatments = numOfTreatments;
    }

    public boolean isFullCurePossible() {
        return isFullCurePossible;
    }

    public void setFullCurePossible(boolean fullCurePossible) {
        isFullCurePossible = fullCurePossible;
    }

    private int numOfTreatments;
    private boolean isFullCurePossible;

    public Specialty(String name, int numOfTreatments, boolean isFullCurePossible) {
        this.name = name;
        this.numOfTreatments = numOfTreatments;
        this.isFullCurePossible = isFullCurePossible;
    }

    // TODO: add tostring() method
}
