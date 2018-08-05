package com.thoughtworks.training.todoserive1.repositoryTest;

import com.thoughtworks.training.todoserive1.model.User;
import com.thoughtworks.training.todoserive1.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.unauthenticated;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@DataJpaTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
public class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldBeReturnUserWithName() {

        userRepository.save(new User(null,"guoguo7", "guoguo"));

        User user = userRepository.findOneByName("guoguo7");

        assertThat(user.getName(),is("guoguo7"));
    }



//    @Test
//    public void  shouldReturnItemListWithAuthentication() throws Exception {
////        mockMvc.perform(get("/todos"))
////                .with(authentication(new UsernamePasswordAuthenticationToken(
////                        "guoguo7",null, Collections.emptyList()
////                )))
////                .andExpect(status().isOk());
//    }

}