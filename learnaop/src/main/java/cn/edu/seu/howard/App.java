package cn.edu.seu.howard;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * Hello world!
 */
public class App {

    public static void main(String[] args) {
        System.out.println("Hello World!");

//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("src/main/java/spring-config.xml");
        ApplicationContext applicationContext = new FileSystemXmlApplicationContext("src/main/java/spring-config.xml");
        TestBean testBean = (TestBean) applicationContext.getBean("testBean");
        testBean.printInfo();
    }
}
