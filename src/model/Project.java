package model;

public class Project {
    private int id;
    private String name;
    private String customer;
    private String status;
    private String startDate;
    private String endDate;

    // Constructor
    public Project(int id, String name, String customer, String status, String startDate, String endDate) {
        this.id = id;
        this.name = name;
        this.customer = customer;
        this.status = status;
        this.startDate = startDate;
        this.endDate = endDate;
    }
    // Constructor tanpa id untuk insert
    public Project(String name, String customer, String status, String startDate, String endDate) {
        this.name = name;
        this.customer = customer;
        this.status = status;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    // Getter dan Setter
    public int getId() { return id; }
    public String getName() { return name; }
    public String getCustomer() { return customer; }
    public String getStatus() { return status; }
    public String getStartDate() { return startDate; }
    public String getEndDate() { return endDate; }

    // (tambahkan setter jika perlu)
}
    // Getters and setters...
