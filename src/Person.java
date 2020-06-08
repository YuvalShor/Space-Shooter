public class Person {

    private String dateOfBirth;
    private String username;
    private String password;

    public Person( String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return super.toString();
    }


    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
