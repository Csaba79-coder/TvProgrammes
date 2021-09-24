package models;

public class Movies {

    // TODO as task changed check the fields! regarding the txt file

    private String title;
    private int length;
    private String type;
    private String category;
    private boolean isAgeRestricted;

    public Movies(String title, int length, String type, String category, boolean isAgeRestricted) {
        this.title = title;
        this.length = length;
        this.type = type;
        this.category = category;
        this.isAgeRestricted = isAgeRestricted;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public boolean isAgeRestricted() {
        return isAgeRestricted;
    }

    public void setAgeRestricted(boolean ageRestricted) {
        isAgeRestricted = ageRestricted;
    }
}
