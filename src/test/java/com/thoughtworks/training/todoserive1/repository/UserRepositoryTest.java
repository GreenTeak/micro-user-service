package com.thoughtworks.training.todoserive1.repository;

import com.thoughtworks.training.todoserive1.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@DataJpaTest
@RunWith(SpringRunner.class)
public class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldBeReturnUserWithName() {
        userRepository.save(new User(null,"guoguo7", "guoguo7"));

        User user = userRepository.findOneByName("guoguo7");
        //assertTrue(user == null);
        assertThat(user.getName(),is("guoguo7"));
    }

    @Test
    public void shouldBeReturn401() throws Exception {
//       mockMvc.perform(get("/todos"))
//               .andExpect(unauthenticated());

    }

    @Test
    public void  shouldReturnItemListWithAuthentication() throws Exception {
//        mockMvc.perform(get("/todos"))
//                .with(authentication(new UsernamePasswordAuthenticationToken(
//                        "guoguo7",null, Collections.emptyList()
//                )))
//                .andExpect(status().isOk());
    }

}