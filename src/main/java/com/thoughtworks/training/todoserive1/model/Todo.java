package com.thoughtworks.training.todoserive1.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name ="todo")
public class Todo {
    public int getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public boolean isCompleted() {
        return completed;
    }

    public boolean isEdit() {
        return edit;
    }

    public int getUserid() {
        return userid;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public void setEdit(boolean edit) {
        this.edit = edit;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    @Id
    @GeneratedValue
    private int id;

    private String text;
    private boolean completed;
    private boolean edit;
    private  int userid;

    @OneToMany(cascade = {CascadeType.ALL})
    @JoinColumn(name="todo_id")
    private List<Task> tasks;


}
