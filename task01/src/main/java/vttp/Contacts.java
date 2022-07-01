package vttp;

public class Contacts {
    private String first_name;
    private String last_name;
    private String address;
    private int years;

    public Contacts(String first_name, String last_name, String address, int years) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.address = address;
        this.years = years;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getYears() {
        return years;
    }

    public void setYears(int years) {
        this.years = years;
    }

    @Override
    public String toString() {
        return "Contacts [address=" + address + ", first_name=" + first_name + ", last_name=" + last_name + ", years="
                + years + "]";
    }

    
    
}
