package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TodoItemTest {

    @Test
    public void getStatusTest() {
        TodoItem todoItem = new TodoItem("clean", "clean bedroom and kitchen", "10% done");
        Assertions.assertEquals("10% done", todoItem.getStatus());
    }

    @Test
    public void getDetailTest() {
        TodoItem todoItem = new TodoItem("clean", "clean bedroom and kitchen", "10% done");
        Assertions.assertEquals("clean bedroom and kitchen", todoItem.getDetail());
    }

    @Test
    public void getTitleTest() {
        TodoItem todoItem = new TodoItem("clean", "clean bedroom and kitchen", "10% done");
        Assertions.assertEquals("clean", todoItem.getTitle());
    }

    public void setStatusTest() {
        TodoItem todoItem = new TodoItem("clean", "clean bedroom and kitchen", "10% done");
        Assertions.assertEquals("10% done", todoItem.getStatus());
        todoItem.setStatus("20% done");
        Assertions.assertEquals("20% done", todoItem.getStatus());
    }

    @Test
    public void setDetailTest() {
        TodoItem todoItem = new TodoItem("clean", "clean bedroom and kitchen", "10% done");
        Assertions.assertEquals("clean bedroom and kitchen", todoItem.getDetail());
        todoItem.setDetail(todoItem.getDetail() + " and bathroom!");
        Assertions.assertEquals("clean bedroom and kitchen and bathroom!", todoItem.getDetail());
    }

    @Test
    public void setTitleTest() {
        TodoItem todoItem = new TodoItem("clean", "clean bedroom and kitchen", "10% done");
        Assertions.assertEquals("clean", todoItem.getTitle());
        todoItem.setTitle("get Bob to clean");
        Assertions.assertEquals("get Bob to clean", todoItem.getTitle());
    }

}