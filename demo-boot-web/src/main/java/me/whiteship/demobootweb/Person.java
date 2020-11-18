package me.whiteship.demobootweb;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

//스프링 데이터 JPA 의 도메인 클래스 컨버터기능을 사용하려면
//@Entity 애노테이션을 붙여 엔티티 매핑을 하고
@Entity
@XmlRootElement
public class Person {

    //도메인 객체의 Id 값을 애노테이션으로 지정한다
    //@GeneratedValue: 도메인 객체가 생성되었을때 해당 값도 같이 생성된다
    @Id @GeneratedValue
    private long id;

    String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
