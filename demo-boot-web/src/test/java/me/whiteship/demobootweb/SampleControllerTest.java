package me.whiteship.demobootweb;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
//@WebMvcTest   //Web과 관련된 빈들만 등록을 해주기 때문에, @Component로 등록한 PersonFormatter빈은 등록되지 않는다
@SpringBootTest //모든 빈들을 통합적으로 등록해 준다, 하지만 MockMvc는 빠져있다
@AutoConfigureMockMvc   //를 사용해 빠진 MockMvc를 별도 빈으로 등록해 해결한다
public class SampleControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    PersonRepository personRepository;

    //Jackson이 제공하는 클래스로, json문자열 객체를 만들 수 있는 기능을 제공한다
    @Autowired
    ObjectMapper objectMapper;

    @Test
    public void hello() throws Exception {
        Person person = new Person();
        person.setName("keesun");
        Person savePerson = personRepository.save(person);

        //.param 자리엔 스트링 타입만 올 수 있어서 .getId()인 Long 타입을 스트링으로 변환해 값을 넘김
        this.mockMvc.perform(get("/hello").param("id", Long.toString(savePerson.getId())))
                .andDo(print())
                .andExpect(content().string("hello keesun"));
    }

    @Test
    public void helloStatic() throws Exception {
        this.mockMvc.perform(get("/index.html"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(Matchers.containsString("hello index")));
    }

    @Test
    public void helloMobile() throws Exception {
        this.mockMvc.perform(get("/mobile/index.html"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(Matchers.containsString("hello mobile")));
    }

    @Test
    public void stringMessage() throws Exception {
        this.mockMvc.perform(get("/message").content("hello"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("hello"));
    }

    @Test
    public void jsonMessage() throws Exception {
        Person person = new Person();
        person.setId(2019L);
        person.setName("keesun");

        String jsonString = objectMapper.writeValueAsString(person);    // {"id":2019,"name":"keesun"}

        this.mockMvc.perform(get("/jsonMessage").content(jsonString)
                .contentType(MediaType.APPLICATION_JSON)    // 본문에 JSON을 담아서 보낼것이다. 라고 서버에 알려준다
                .accept(MediaType.APPLICATION_JSON))        // JSON으로 응답이 오길 바란다. 라고 서버에 알려준다
                                            // 스프링은 위 두 정보를 기반으로, 'JSON HTTP 메시지 컨버터'를 사용하게 된다
                .andDo(print())
                .andExpect(status().isOk());
    }
}