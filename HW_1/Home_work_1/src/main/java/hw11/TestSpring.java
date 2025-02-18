package hw11;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml"
        );

        TestBean testBean = context.getBean("testBean", TestBean.class);
        Knight knight = context.getBean("knight", Knight.class);


        System.out.println(testBean.getName());
        System.out.println(knight.getName());

        System.out.println(knight.toString());

        context.close();
    }
}



