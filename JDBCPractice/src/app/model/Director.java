package app.model;

public class Director {
    private String directorId;
    private String name;
    private String birthDate;
    private String bio;

    public Director(String directorId, String name, String birthDate, String bio) {
        this.directorId = directorId;
        this.name = name;
        this.birthDate = birthDate;
        this.bio = bio;
    }

    public String getDirectorId() {
        return directorId;
    }
    public void setDirectorId(String directorId) {
        this.directorId = directorId;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDate() {
        return birthDate;
    }
    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getBio() {
        return bio;
    }
    public void setBio(String bio) {
        this.bio = bio;
    }

    @Override
    public String toString() {
        return "app.model.Director id: " + directorId + ", name: " + name + ", birthDate: " + birthDate + ", bio: " + bio;
    }
}
