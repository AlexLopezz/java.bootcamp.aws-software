package models.enums;

public enum GENDER {
    MEN ("Men"),
    WOMEN ("Women");

    private final String text;

    GENDER(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
