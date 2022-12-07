package car.accident.controller;

import car.accident.CarAccidentApplication;
import car.accident.model.Authority;
import car.accident.model.User;
import org.junit.Assert;
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
import car.accident.model.Rule;
import car.accident.service.RuleServiceData;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(classes = CarAccidentApplication.class)
@AutoConfigureMockMvc
public class RuleControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RuleServiceData ruleServiceData;

    @MockBean
    private RegControl regControl;

    @Test
    @WithMockUser
    public void shouldReturnRuleCreateView() throws Exception {
        User user = new User(1,
                "root2",
                "password",
                new Authority(1, "ADMIN"),
                true);
        regControl.regSave(user);
        Map<String, Object> params = new HashMap<>();
        params.put("id", "125");
        params.put("username", "root2");
        params.put("password", "password");
        params.put("authority.authority", "ROLE_ADMIN");
        params.put("enabled", "true");
        this.mockMvc.perform(get("/rules/createRule")
                .flashAttrs(params))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("rule/createRule"));
    }

    @Test
    @WithMockUser
    public void shouldReturnRuleEditView() throws Exception {
        this.mockMvc.perform(get("/rules/updateRule?id=1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("rule/updateRule"));
    }

    @Test
    @WithMockUser
    public void shouldReturnCreateRuleView() throws Exception {
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("id", "1");
        map.add("name", "Статья 1");
        this.mockMvc.perform(post("/rules/saveRule").params(map))
                .andDo(print())
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/index"));
        ArgumentCaptor<Rule> argument = ArgumentCaptor.forClass(Rule.class);
        verify(ruleServiceData).save(argument.capture());
        Rule value = argument.getValue();
        Assert.assertEquals(value.getId(), 1);
        Assert.assertEquals(value.getName(), "Статья 1");
    }

    @Test
    @WithMockUser
    public void update() throws Exception {
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("id", "1");
        map.add("name", "Статья 2");
        this.mockMvc.perform(post("/rules/saveRule")
                        .params(map))
                .andDo(print())
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/index"));
        ArgumentCaptor<Rule> argument = ArgumentCaptor.forClass(Rule.class);
        verify(ruleServiceData).save(argument.capture());
        Rule value = argument.getValue();
        Assert.assertEquals(value.getId(), 1);
        Assert.assertEquals(value.getName(), "Статья 2");
    }
}