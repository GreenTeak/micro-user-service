package com.thoughtworks.training.todoserive1.ControllerTest;


import com.thoughtworks.training.todoserive1.repository.TodoRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class TodolistTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TodoRepository todoRepository;

    @Test
    public void shuoldbereturnlist() throws Exception{
//        when(todoRepository.list()).thenReturn(ImmutableList.of(new Todo(0,"foo",true,true)));
//        MvcResult result =mockMvc.perform(get("/todos"))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.length()").value(1))
//                .andReturn();
//
//        //System.out.print((result.getResponse().getContentAsString());

    }
}
