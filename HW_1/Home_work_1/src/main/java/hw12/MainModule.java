package hw12;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainModule {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext2.xml"
        );

        Quest quest1 = context.getBean("quest1", Quest.class);
        Quest quest2 = context.getBean("quest2", Quest.class);

//        Knight knight = context.getBean("knight", Knight.class);
        Knight knight = new Knight(quest1);

        System.out.println(knight.toString());

        knight = null;

        knight = new Knight(quest2);

        System.out.println(knight.toString());

        context.close();
    }
}



