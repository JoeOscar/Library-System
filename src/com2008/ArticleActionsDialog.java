package com2008;

import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ArticleActionsDialog extends JDialog {
    private JPanel contentPane;
    private JButton viewButton;
    private JButton acceptButton;
    private JButton delayButton;
    private JButton rejectButton;

    private int submissionId;

    public ArticleActionsDialog(int submissionId) {
        this.submissionId = submissionId;

        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(viewButton);

        viewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                viewArticle();
            }
        });

        acceptButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                makeDecision("accepted");
            }
        });

        rejectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                makeDecision("rejected");
            }
        });

        delayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                makeDecision("delayed");
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onCancel() {
        dispose();
    }

    private void viewArticle() {
        ArticleView.showArticleView(submissionId);
    }

    private void makeDecision(String decision) {
        Statement stmt = null;

        try (Connection con = DriverManager.getConnection("jdbc:mysql://stusql.dcs.shef.ac.uk/team019", "team019", "fd0751c6")) {
            stmt = con.createStatement();
            stmt.executeUpdate("UPDATE consideredSubmissions SET decision = '" +
                    decision + "' WHERE submissionId = '" + submissionId + "'");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void showArticleActionsDialog(int submissionId) {
        ArticleActionsDialog d = new ArticleActionsDialog(submissionId);
        d.pack();
        d.setLocationRelativeTo(null);
        d.setVisible(true);
    }
}
