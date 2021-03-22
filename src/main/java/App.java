import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/*
Задание:
1. Прочитайте про виды бинов.
2. Создайте POJO-класс Cat.
3. В классе AppConfig, по аналогии, создайте бин с именем “cat”.
4. Настройте этот бин так, чтобы он создавался новым при каждом запросе.
5. В классе App, по аналогии, вызовите еще раз бин HelloWorld,
затем 2 раза вызовите бин cat. Сравните 2 пары бинов по ссылке и выведите результат в консоль.
Для пары HelloWorld должно вернуться true, для cat - false. Так вы можете увидеть результат того, как работает наш контейнер.
6. Раскоментируйте тестовый класс и проверьте своё решение.
 */

public class App {
    public static void main(String[] args) {
        ApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(AppConfig.class);
        HelloWorld bean =
                (HelloWorld) applicationContext.getBean("helloworld");
        System.out.println(bean.getMessage());

        HelloWorld bean2 = (HelloWorld) applicationContext.getBean("helloworld");

        Cat cat1 = applicationContext.getBean("cat", Cat.class);
        Cat cat2 = applicationContext.getBean("cat", Cat.class);

        System.out.println(bean == bean2);
        System.out.println(cat1 == cat2);
    }
}