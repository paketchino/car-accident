package car.accident.controller;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import car.accident.CarAccidentApplication;
import car.accident.model.User;

import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(classes = CarAccidentApplication.class)
@AutoConfigureMockMvc
public class RegControlTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RegControl regControl;

    @Test
    @WithMockUser
    public void regPage() throws Exception {
        this.mockMvc.perform(get("/reg"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("reg"));
    }

    /*
    @Test
    @WithMockUser
    public void setRegControl() throws Exception {
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("username", "user");
        map.add("password", "password");
        this.mockMvc.perform(post("/reg")
                        .params(map))
                .andDo(print())
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/login"));
        ArgumentCaptor<User> argument = ArgumentCaptor.forClass(User.class);
        verify(regControl).regSave(argument.capture());
        User user = argument.capture();
        Assert.assertEquals(user.getUsername(), "user");
        Assert.assertEquals(user.getPassword(), "password");
    }

    @Test
    @WithMockUser
    public void shouldReturnRedirectJspWithDuplicateUser() throws Exception {
        this.mockMvc.perform(get("/reg?error=true"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("reg"))
                .andExpect(model().attribute("errorMessage",
                        "User with this username is already registered!!"));
    }
     */
}