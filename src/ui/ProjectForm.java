package ui;

import controller.ProjectManager;
import model.Project;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class ProjectForm extends JFrame {
    private ProjectManager projectManager;
    private JTable projectTable;
    private DefaultTableModel tableModel;

    public ProjectForm() {
        super("Project Management");
        projectManager = new ProjectManager();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 400);
        setLocationRelativeTo(null);
        initUI();
        loadProjects();
    }

    private void initUI() {
        JPanel panel = new JPanel(new BorderLayout());

        // Table
        String[] columnNames = {"ID", "Name", "Customer", "Status", "Start Date", "End Date"};
        tableModel = new DefaultTableModel(columnNames, 0);
        projectTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(projectTable);

        // Buttons
        JPanel buttonPanel = new JPanel();
        JButton addButton = new JButton("Add Project");
        JButton updateButton = new JButton("Update Project");
        JButton deleteButton = new JButton("Delete Project");
        JButton refreshButton = new JButton("Refresh");

        addButton.addActionListener(e -> addProject());
        updateButton.addActionListener(e -> updateProject());
        deleteButton.addActionListener(e -> deleteProject());
        refreshButton.addActionListener(e -> loadProjects());

        buttonPanel.add(addButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(refreshButton);

        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        add(panel);
    }

    private void loadProjects() {
    tableModel.setRowCount(0);
    List<Project> projects = projectManager.readProjects();
    for (Project p : projects) {
        Object[] row = {
            p.getId(),
            p.getName(),
            p.getCustomer(),
            p.getStatus(),
            p.getStartDate(),
            p.getEndDate()
        };
        tableModel.addRow(row);
    }
}

    private void deleteProject() {
    int selectedRow = projectTable.getSelectedRow();
    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(this, "Pilih project yang ingin dihapus!");
        return;
    }

    int id = (int) tableModel.getValueAt(selectedRow, 0);
    int confirm = JOptionPane.showConfirmDialog(
        this,
        "Apakah Anda yakin ingin menghapus project dengan ID " + id + "?",
        "Konfirmasi Hapus",
        JOptionPane.YES_NO_OPTION
    );
    if (confirm == JOptionPane.YES_OPTION) {
        projectManager.deleteProject(id);
        loadProjects();
    }
}
    private void updateProject() {
    int selectedRow = projectTable.getSelectedRow();
    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(this, "Pilih project yang ingin diubah!");
        return;
    }

    // Ambil data lama
    int id = (int) tableModel.getValueAt(selectedRow, 0);
    String nameOld = (String) tableModel.getValueAt(selectedRow, 1);
    String customerOld = (String) tableModel.getValueAt(selectedRow, 2);
    String statusOld = (String) tableModel.getValueAt(selectedRow, 3);
    String startOld = (String) tableModel.getValueAt(selectedRow, 4);
    String endOld = (String) tableModel.getValueAt(selectedRow, 5);

    // Komponen form
    JTextField nameField = new JTextField(nameOld);
    JTextField customerField = new JTextField(customerOld);
    String[] statuses = {"instal", "non-instal"};
    JComboBox<String> statusBox = new JComboBox<>(statuses);
    statusBox.setSelectedItem(statusOld);
    JTextField startDateField = new JTextField(startOld);
    JTextField endDateField = new JTextField(endOld);

    JPanel panel = new JPanel(new GridLayout(5, 2));
    panel.add(new JLabel("Name:"));
    panel.add(nameField);
    panel.add(new JLabel("Customer:"));
    panel.add(customerField);
    panel.add(new JLabel("Status:"));
    panel.add(statusBox);
    panel.add(new JLabel("Start Date:"));
    panel.add(startDateField);
    panel.add(new JLabel("End Date:"));
    panel.add(endDateField);

    int result = JOptionPane.showConfirmDialog(this, panel, "Update Project", JOptionPane.OK_CANCEL_OPTION);
    if (result == JOptionPane.OK_OPTION) {
        String name = nameField.getText().trim();
        String customer = customerField.getText().trim();
        String status = (String) statusBox.getSelectedItem();
        String startDate = startDateField.getText().trim();
        String endDate = endDateField.getText().trim();

        if (name.isEmpty() || customer.isEmpty() || startDate.isEmpty() || endDate.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Semua field harus diisi!");
            return;
        }

        Project updated = new Project(id, name, customer, status, startDate, endDate);
        projectManager.updateProject(updated);
        loadProjects();
    }
}

    private void addProject() {
        JTextField nameField = new JTextField();
        JTextField customerField = new JTextField();
        String[] statuses = {"instal", "non-instal"};
        JComboBox<String> statusBox = new JComboBox<>(statuses);
        JTextField startDateField = new JTextField("YYYY-MM-DD");
        JTextField endDateField = new JTextField("YYYY-MM-DD");

        JPanel panel = new JPanel(new GridLayout(5, 2));
        panel.add(new JLabel("Name:"));
        panel.add(nameField);
        panel.add(new JLabel("Customer:"));
        panel.add(customerField);
        panel.add(new JLabel("Status:"));
        panel.add(statusBox);
        panel.add(new JLabel("Start Date:"));
        panel.add(startDateField);
        panel.add(new JLabel("End Date:"));
        panel.add(endDateField);

        int result = JOptionPane.showConfirmDialog(this, panel, "Add Project", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            String name = nameField.getText();
            String customer = customerField.getText();
            String status = (String) statusBox.getSelectedItem();
            String startDate = startDateField.getText();
            String endDate = endDateField.getText();

            if (name.isEmpty() || customer.isEmpty() || startDate.isEmpty() || endDate.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Semua field harus diisi!");
                 return;
            }

            Project project = new Project(name, customer, status, startDate, endDate);
            projectManager.createProject(project);
            loadProjects();
        }
    }
}
