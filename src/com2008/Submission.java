package com2008;

import java.io.File;

public class Submission {
    private int submissionId;
    private String title;
    private String abs;
    private File pdf;
    private String mainAuthorsEmail;
    private String issn;

    public Submission(int submissionId, String title, String abs, File pdf, String mainAuthorsEmail, String issn) {
        this.submissionId = submissionId;
        this.title = title;
        this.abs = abs;
        this.pdf = pdf;
        this.mainAuthorsEmail = mainAuthorsEmail;
        this.issn = issn;
    }

    public int getSubmissionId() {
        return submissionId;
    }

    public String getTitle() {
        return title;
    }

    public String getAbs() {
        return abs;
    }

    public File getPdf() {
        return pdf;
    }

    public String getMainAuthorsEmail() {
        return mainAuthorsEmail;
    }

    public String getIssn() {
        return issn;
    }

    public void setSubmissionId(int submissionId) {
        this.submissionId = submissionId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAbs(String abs) {
        this.abs = abs;
    }

    public void setPdf(File pdf) {
        this.pdf = pdf;
    }

    public void setMainAuthorsEmail(String mainAuthorsEmail) {
        this.mainAuthorsEmail = mainAuthorsEmail;
    }

    public void setIssn(String issn) {
        this.issn = issn;
    }
}
