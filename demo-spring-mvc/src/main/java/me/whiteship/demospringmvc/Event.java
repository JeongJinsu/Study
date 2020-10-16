package me.whiteship.demospringmvc;

import lombok.*;

import java.time.LocalDateTime;

//모델(프로퍼티객체)의 필드에 대한 getter, setter, 생성자 등등 자동으로 생성해주는 애노테이션(Lombok 라이브러리)
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Event {

    private String name;

    private int limitOfEnrollment;

    private LocalDateTime startDateTime;

    private LocalDateTime endDateTime;

}
