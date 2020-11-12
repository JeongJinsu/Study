package me.whiteship.demobootweb;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@RunWith(SpringRunner.class)
//@WebMvcTest   //Web과 관련된 빈들만 등록을 해주기 때문에, @Component로 등록한 PersonFormatter빈은 등록되지 않는다
@SpringBootTest //모든 빈들을 통합적으로 등록해 준다, 하지만 MockMvc는 빠져있다
@AutoConfigureMockMvc   //를 사용해 빠진 MockMvc를 별도 빈으로 등록해 해결한다
public class SampleControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void hello() throws Exception {
        this.mockMvc.perform(get("/hello").param("name","keesun"))
                .andDo(print())
                .andExpect(content().string("hello keesun"));
    }
}