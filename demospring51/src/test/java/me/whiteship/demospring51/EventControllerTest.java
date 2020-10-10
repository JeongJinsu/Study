package me.whiteship.demospring51;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest({EventController.class, EventConverter.StringToEventConverter.class}) //자동 추가가 안될시, 테스트에 필요한 빈들을 명시적으로 추가함
class EventControllerTest {

    @Autowired
    MockMvc mockMvc;

    /*
     *스프링 어플리케이션에 /event/1 요청을 하고
     *요청을 통해서 받은 데이터가 1인지 체크하는 테스트를 작성한 것
     */
    @Test
    public void getTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/event/1"))
                .andExpect(status().isOk()) //결과가 200(500은 서버오류)으로 나오는지 확인
                .andExpect(content().string("1")); //return event.getId().toString(); 결과가 1로 나오는지 확인
    }
}