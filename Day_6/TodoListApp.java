package Day_6;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TodoListApp extends JFrame {
    private DefaultListModel<String> taskListModel;
    private JList<String> taskList;
    private JTextField taskField;

    public TodoListApp() {
        setTitle("To-Do List");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Layout
        setLayout(new BorderLayout());

        // Task list model & JList
        taskListModel = new DefaultListModel<>();
        taskList = new JList<>(taskListModel);
        JScrollPane scrollPane = new JScrollPane(taskList);

        // Input panel with text field and add button
        JPanel inputPanel = new JPanel(new BorderLayout());
        taskField = new JTextField();
        JButton addButton = new JButton("Add");
        addButton.addActionListener(e -> addTask());

        inputPanel.add(taskField, BorderLayout.CENTER);
        inputPanel.add(addButton, BorderLayout.EAST);

        // Delete button panel
        JPanel deletePanel = new JPanel();
        JButton deleteButton = new JButton("Delete Selected");
        deleteButton.addActionListener(e -> deleteTask());
        deletePanel.add(deleteButton);

        // Add components to frame
        add(inputPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(deletePanel, BorderLayout.SOUTH);
    }

    private void addTask() {
        String task = taskField.getText().trim();
        if (!task.isEmpty()) {
            taskListModel.addElement(task);
            taskField.setText("");
        } else {
            JOptionPane.showMessageDialog(this, "Please enter a task.", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void deleteTask() {
        int selectedIndex = taskList.getSelectedIndex();
        if (selectedIndex != -1) {
            taskListModel.remove(selectedIndex);
        } else {
            JOptionPane.showMessageDialog(this, "Please select a task to delete.", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TodoListApp app = new TodoListApp();
            app.setVisible(true);
        });
    }
}
