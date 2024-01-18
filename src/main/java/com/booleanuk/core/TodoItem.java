package com.booleanuk.core;

public class TodoItem {
    private String title;
    private String detail;
    private String status;

    public TodoItem(String title, String detail, String status) {
        this.title = title;
        this.detail = detail;
        this.status = status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return this.status;
    }

    public String getTitle() {
        return title;
    }

    public String getDetail() {
        return detail;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}




