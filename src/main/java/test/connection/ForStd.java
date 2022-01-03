package test.connection;

public class ForStd {

    private int id;
    private String name;
    private String email;
    private String round;

    public ForStd() {
    }

    public ForStd(int id, String name, String email, String round) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.round = round;
    }

    public String getRound() {
        return round;
    }

    public void setRound(String round) {
        this.round = round;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
