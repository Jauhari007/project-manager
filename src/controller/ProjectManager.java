package controller;

import model.Project;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProjectManager extends BaseManager {

    public ProjectManager() {
        super();
    }

    public void createProject(Project project) {
        try {
            String sql = "INSERT INTO projects (name, customer, status, start_date, end_date) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stmt = db.prepareStatement(sql);
            stmt.setString(1, project.getName());
            stmt.setString(2, project.getCustomer());
            stmt.setString(3, project.getStatus());
            stmt.setString(4, project.getStartDate());
            stmt.setString(5, project.getEndDate());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Project> readProjects() {
        List<Project> projects = new ArrayList<>();
        try {
            String sql = "SELECT id, name, customer, status, start_date, end_date FROM projects";
            PreparedStatement stmt = db.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Project p = new Project(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("customer"),
                    rs.getString("status"),
                    rs.getString("start_date"),
                    rs.getString("end_date")
                );
                projects.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return projects;
    }
}
