package bmi.profession;

public enum WorkType {
    SKI_JUMPER      ("ski_jumper"),
    RUNNER          ("runner"),
    SITTING_WORK    ("sitting_work"),
    PHYSICAL_WORK   ("physical_work"),
    STRONG_MAN      ("strong_man");

    public final String workType;

    WorkType(String workType) {
        this.workType = workType;
    }

    public String toString() {
        return workType;
    }

    public static WorkType fromString(String workType) {
        for (WorkType wt : WorkType.values()) {
            if (wt.workType.equalsIgnoreCase(workType)) {
                return wt;
            }
        }
        return null;
    }
}
