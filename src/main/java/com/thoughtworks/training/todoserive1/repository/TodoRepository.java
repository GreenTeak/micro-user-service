package com.thoughtworks.training.todoserive1.repository;

import com.thoughtworks.training.todoserive1.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TodoRepository extends JpaRepository<Todo,Integer> {

   List<Todo> findAllByUserIdEquals(Integer id);

    //List<Todo> findAllByuserId(Integer userId);
//    @Value("classpath:static/factors.json")
//    private Resource todos;
//
//    public List<Todo> list() throws IOException {
//        String todosData =  IOUtils.toString(todos.getInputStream(), Charset.forName("UTF-8"));
//        return ReadFile.read(todosData);
//    }
}