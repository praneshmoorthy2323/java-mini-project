/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.taskmanagerapp;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class TaskManagerApp extends JFrame {

    DefaultTableModel model;
    JTable table;
    JTextField taskField;

    public TaskManagerApp() {

        setTitle("Task & Daily Activity Manager");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // Title
        JLabel title = new JLabel("Task Manager");
        title.setBounds(230, 10, 200, 30);
        add(title);

        // Text Field
        taskField = new JTextField();
        taskField.setBounds(50, 50, 300, 30);
        add(taskField);

        // Add Button
        JButton addBtn = new JButton("Add Task");
        addBtn.setBounds(370, 50, 120, 30);
        add(addBtn);

        // Delete Button
        JButton deleteBtn = new JButton("Delete Task");
        deleteBtn.setBounds(50, 300, 120, 30);
        add(deleteBtn);

        // Done Button
        JButton doneBtn = new JButton("Mark Done");
        doneBtn.setBounds(200, 300, 120, 30);
        add(doneBtn);

        // Table
        model = new DefaultTableModel();
        model.addColumn("Task");
        model.addColumn("Status");

        table = new JTable(model);
        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(50, 100, 440, 180);
        add(sp);

        // ADD TASK
        addBtn.addActionListener(e -> {
            String task = taskField.getText();

            if (task.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter a task!");
            } else {
                model.addRow(new Object[]{task, "Pending"});
                taskField.setText("");
            }
        });

        // DELETE TASK
        deleteBtn.addActionListener(e -> {
            int row = table.getSelectedRow();

            if (row >= 0) {
                model.removeRow(row);
            } else {
                JOptionPane.showMessageDialog(this, "Select a task to delete!");
            }
        });

        // MARK DONE
        doneBtn.addActionListener(e -> {
            int row = table.getSelectedRow();

            if (row >= 0) {
                model.setValueAt("Completed", row, 1);
            } else {
                JOptionPane.showMessageDialog(this, "Select a task!");
            }
        });
    }

    // MAIN METHOD (ENTRY POINT)
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            new TaskManagerApp().setVisible(true);
        });
    }
}
