import java.util.Objects;

class User {
    private String firstName;
    private String lastName;

    public User() {
        this.firstName = "";
        this.lastName = "";
    }

    public void setFirstName(String firstName) {
        this.firstName = Objects.requireNonNullElse(firstName, "");
    }

    public void setLastName(String lastName) {
        this.lastName = Objects.requireNonNullElse(lastName, "");
    }

    public String getFullName() {
        if ("".equals(firstName) && "".equals(lastName)) {
            return "Unknown";
        } else {
            return (firstName + " " + lastName).strip();
        }
    }

    public static void main(String[] args) {
        User tim = new User();
        tim.setFirstName(null);
        tim.setLastName(null);
        System.out.println(tim.getFullName());
    }
}