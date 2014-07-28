package perso.userform.domain;

public class User {

    public Long _id;

    public String firstname;

    public String lastname;

    public Address address;

    public String personnalPhone;

    public String portablePhone;

    public User withFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public User withLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }


}
