package me.whiteship.demospring51;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class AppRunner implements ApplicationRunner {

    @Autowired
    ApplicationContext ctx;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("proto");
        System.out.println(ctx.getBean(Proto.class)); //Proto@3078cac
        System.out.println(ctx.getBean(Proto.class)); //Proto@f6de586
        System.out.println(ctx.getBean(Proto.class)); //Proto@5f2bd6d9

        System.out.println("single");
        System.out.println(ctx.getBean(Single.class)); //Single@43d9f1a2
        System.out.println(ctx.getBean(Single.class)); //Single@43d9f1a2
        System.out.println(ctx.getBean(Single.class)); //Single@43d9f1a2

        System.out.println("proto by single");
        System.out.println(ctx.getBean(Single.class).getProto()); //Proto@63dfada0
        System.out.println(ctx.getBean(Single.class).getProto()); //Proto@6f231ced
        System.out.println(ctx.getBean(Single.class).getProto()); //Proto@35a60674
    }
}
