public class Customer {
    private String firstname;
    private String lastname;
    private final int id;
    private String tel;

    public Customer(String firstname, String lastname, int id, String tel){
        this.firstname = firstname;
        this.lastname = lastname;
        this.id = id;
        this.tel = tel;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getId() {
        return id;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}
