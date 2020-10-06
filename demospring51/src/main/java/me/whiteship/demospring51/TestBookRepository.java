package me.whiteship.demospring51;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

@Repository
@Profile("test") //@componentScan 에서도 프로파일 생성 가능
public class TestBookRepository implements BookRepository {

}
