package car.accident.controller;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import car.accident.CarAccidentApplication;
import car.accident.model.Accident;
import car.accident.service.AccidentServiceData;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

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

    @Ignore
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

    /**
    @Test
    @WithMockUser
    public void saveAccident() throws Exception {
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("id", "2");
        map.add("name", "Авария на дороге");
        map.add("rule.id", "2");
        map.add("accidentType_id", "2");
        map.add("address", "улица Пушкино");
        map.add("numberCar", "98831");
        map.add("description", "Столкновение двух машин");
        map.add("status", "false");
        this.mockMvc.perform(post("/accidents/saveAccident").params(map))
                .andDo(print())
                .andExpect(status().is3xxRedirection());
        ArgumentCaptor<Accident> argument = ArgumentCaptor
                .forClass(Accident.class);
        Accident accident = argument.capture();
        verify(accidentServiceData).create(argument.capture());
        Assert.assertEquals(accident.getId(), 1);
        Assert.assertEquals(accident.getName(), "Авария на дороге");
        Assert.assertEquals(accident.getRule().getId(), 2);
        Assert.assertEquals(accident.getAccidentType(), 2);
        Assert.assertEquals(accident.getAddress(), "улица Пушкино");
        Assert.assertEquals(accident.getNumberCar(), 98831);
        Assert.assertEquals(accident.getDescription(), "Столкновение двух машин");
        Assert.assertEquals(accident.isStatus(), "false");
    }
    */

}