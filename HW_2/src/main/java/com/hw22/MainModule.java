package com.hw22;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainModule {
        public static void main(String[] args) {
            ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                    "applContextAutomob.xml"
            );

            Movement movement = context.getBean("target1", Movement.class);
            Automob auto1 = new Automob(movement);
            auto1.movingOnRoad();

            //
            Automob auto2  = context.getBean("kIAK5", Automob.class);
            auto2.movingOnRoad();

            // Constructor
            Automob3 auto3 = context.getBean("toyotaLandCruiser", Automob3.class);
            auto3.movingOnRoad();

            // Setter
            Automob4 auto4 = context.getBean("hyundaiVenue", Automob4.class);
            auto4.movingOnRoad();

            // init-method
            Automob5 auto5 = context.getBean("subaruOutback", Automob5.class);
            auto5.movingOnRoad();


            context.close();
        }
    }

