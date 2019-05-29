package ru.asavt;

import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import ru.asavt.service.QuestionService;

import java.util.Locale;


@Configuration
@ComponentScan
@PropertySource("/application/application.properties")
public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(Main.class);

        String locale;
        if (args.length > 0) {
            locale = args[0];
        } else {
            locale = Locale.getDefault().getLanguage();
        }
        System.setProperty("instance.locale", locale);
        context.refresh();


        QuestionService service = context.getBean(QuestionService.class);
        service.run();
//
//        Person ivan = service.getByName("Ivan");
//        System.out.println("name: " + ivan.getName() + " age: " + ivan.getAge());
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer placeHolderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
