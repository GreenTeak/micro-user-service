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
    @Id
    @GeneratedValue
    private int id;

    private String text;
    private boolean completed;
    private boolean edit;
    private  int userId;

    @OneToMany(cascade = {CascadeType.ALL})
    @JoinColumn(name="todo_id")
    private List<Task> tasks;
}
