package models.enums;

public enum PROFESSION {
    BACKEND_DEVELOPER("Backend Developer"),
    FRONTEND_DEVELOPER("Frontend Developer"),
    FULLSTACK_DEVELOPER("FullStack Developer"),
    QA ("Tester QA");

    private final String profession;

    PROFESSION(String profession) {
        this.profession = profession;
    }

    public String getProfession() {
        return profession;
    }
}
