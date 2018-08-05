package com.thoughtworks.training.todoserive1.ControllerTest;


import com.google.common.collect.ImmutableList;
import com.thoughtworks.training.todoserive1.model.Todo;
import com.thoughtworks.training.todoserive1.model.User;
import com.thoughtworks.training.todoserive1.repository.TodoRepository;
import com.thoughtworks.training.todoserive1.repository.UserRepository;
import com.thoughtworks.training.todoserive1.serivice.UserSerive;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.Collections;

import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.authentication;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.unauthenticated;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
    private UserSerive userSerive;


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
//        when(userSerive.findOneByName("getian")).thenReturn(user);
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
