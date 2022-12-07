package car.accident.controller;

import car.accident.model.AccidentType;
import car.accident.model.Rule;
import car.accident.service.AccidentTypeServiceData;
import car.accident.service.AuthorityServiceData;
import car.accident.service.RuleServiceData;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import car.accident.CarAccidentApplication;
import car.accident.model.Accident;
import car.accident.service.AccidentServiceData;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(classes = CarAccidentApplication.class)
@AutoConfigureMockMvc
public class AccidentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AccidentServiceData accidentServiceData;

    @MockBean
    private RuleServiceData ruleServiceData;

    @MockBean
    private AccidentTypeServiceData accidentTypeServiceData;

    @Test
    @WithMockUser
    public void shouldReturnDefaultMessageRuleGet() throws Exception {
        this.mockMvc.perform(get("/accidents/createAccident"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("accident/createAccident"));
    }

    @Test
    @WithMockUser
    public void shouldReturnDefaultMessageAccidentTypeGet() throws Exception {
        this.mockMvc.perform(get("/accidents/formUpdateAccident?id=1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("accident/formUpdateAccident"));
    }

    @Test
    @WithMockUser
    public void saveAccident() throws Exception {
        MockMultipartFile file = new MockMultipartFile(
                "file", "hello.txt", MediaType.TEXT_PLAIN_VALUE, "Hello, Word".getBytes()
        );
        Rule rule = new Rule(1, "Rule 1");
        AccidentType accidentType = new AccidentType(1, "Accident Type 1");
        ruleServiceData.save(rule);
        accidentTypeServiceData.save(accidentType);
        Accident accident = new Accident(1, "Accident Name",
                rule,
                accidentType,
                "Adress 1", "EA12123213", "Desc 1",
                file.getBytes(), false);
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("accident", accident);
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("type.id", String.valueOf(accidentType.getId()));
        params.add("rule.id", String.valueOf(rule.getId()));
        this.mockMvc.perform(multipart("/accidents/saveAccident")
                        .file(file)
                        .flashAttrs(body)
                        .params(params))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/index"));
        ArgumentCaptor<Accident> argumentCaptor = ArgumentCaptor.forClass(Accident.class);
        verify(accidentServiceData).create(argumentCaptor.capture());
        Accident acc = argumentCaptor.getValue();
        Assert.assertThat(acc.getId(), is(accident.getId()));
    }
}