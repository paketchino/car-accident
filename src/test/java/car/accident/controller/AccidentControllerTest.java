package car.accident.controller;

import car.accident.model.AccidentType;
import car.accident.model.Rule;
import car.accident.service.AccidentTypeServiceData;
import car.accident.service.AuthorityServiceData;
import car.accident.service.RuleServiceData;
import org.junit.Assert;
import org.junit.Ignore;
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
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import car.accident.CarAccidentApplication;
import car.accident.model.Accident;
import car.accident.service.AccidentServiceData;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.Set;

import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@SpringBootTest(classes = CarAccidentApplication.class)
@AutoConfigureMockMvc
public class AccidentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AccidentServiceData accidentServiceData;

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
        AccidentType accidentType = new AccidentType(1, "Accident Type 1");
        Set<AccidentType> accidentTypeSet = Set.of(accidentType);
        Accident accident = new Accident(1, "Accident Name",
                new Rule(1, "Rule 1"), accidentTypeSet,
                "Adress 1", 12123213, "Desc 1",
                file.getBytes(), false);

        AuthorityServiceData authorityServiceData =
                mock(AuthorityServiceData.class);

        RuleServiceData ruleServiceData =
                mock(RuleServiceData.class);

        AccidentTypeServiceData accidentTypeServiceData =
                mock(AccidentTypeServiceData.class);

        AccidentController accidentController = new AccidentController(
                accidentServiceData,
                authorityServiceData,
                ruleServiceData,
                accidentTypeServiceData);
        HttpServletRequest req = mock(HttpServletRequest.class);
        String rsl = accidentController.saveAccident(accident, file, req);
        verify(accidentServiceData).create(accident);
        Assert.assertThat(rsl, is("redirect:/index"));
    }
}