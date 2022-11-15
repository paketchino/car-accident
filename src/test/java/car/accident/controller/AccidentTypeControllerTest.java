package car.accident.controller;

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
import car.accident.model.AccidentType;
import car.accident.service.AccidentTypeServiceData;

import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class AccidentTypeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AccidentTypeServiceData accidentTypeServiceData;

    @Test
    @WithMockUser
    public void shouldReturnAccidentType() throws Exception {
        this.mockMvc.perform(get("/accidentsTypes/createAccidentType"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("accidentType/createAccidentType"));
    }

    @Test
    @WithMockUser
    public void shouldReturnSaveAccidentType() throws Exception {
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("id", "1");
        map.add("name", "Авария");
        this.mockMvc.perform(post("/accidentsTypes/saveAccidentType").params(map))
                .andDo(print())
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/index"));
        ArgumentCaptor<AccidentType> argument = ArgumentCaptor.forClass(AccidentType.class);
        verify(accidentTypeServiceData).create(argument.capture());
        AccidentType value = argument.getValue();
        Assert.assertEquals(value.getId(), 1);
        Assert.assertEquals(value.getName(), "Авария");
    }
}