public class Main {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            LoginForm login = new LoginForm();
            login.setTitle("Aplikasi Manajemen Proyek");
            login.setVisible(true);
        });
    }
}
