package com.thoughtworks.training.todoserver.ControllerTest;


import com.thoughtworks.training.todoserver.repository.TodoRepository;
import com.thoughtworks.training.todoserver.server.UserSever;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.unauthenticated;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@DataJpaTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
public class TodolistTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TodoRepository todoRepository;

    @MockBean
    private UserSever userSever;


    @Test
    public void shouldBeReturn401WithoutAuthenticated() throws Exception {
        mockMvc.perform(get("/todos"))
                .andExpect(unauthenticated());

    }

    @Test
    public void shuoldbereturnlistAfterAuthenticated() throws Exception{
//
//        User user =new User(6,"getian","12345");
//
//        when(userSever.findOneByName("getian")).thenReturn(user);
//
//        when(todoRepository.findAllByUseridEquals(1))
//                .thenReturn(Collections.singletonList(new Todo(1,"donothing",false,false,6)));
//
//        mockMvc.perform(get("/todos")
//                .with(authentication(new UsernamePasswordAuthenticationToken("getian", null, Collections.emptyList()))))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$[0].id").value(1));

    }

}
