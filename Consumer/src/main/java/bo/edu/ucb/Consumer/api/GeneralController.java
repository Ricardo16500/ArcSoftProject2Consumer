package bo.edu.ucb.Consumer.api;

import bo.edu.ucb.Consumer.config.RabbitMqConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class GeneralController {
    private static Logger LOGGER = LoggerFactory.getLogger(GeneralController.class);
    @RabbitListener(queues = RabbitMqConfig.F_QUEUE_1)
    public void f_student(ArrayList general){
        LOGGER.info("Fanout 1, general ");
        for (int i =0; i<general.size();i++){

            System.out.print("Fanout Exchange Fisrt Queue");
            System.out.println(general.get(i));
        }
    }
    @RabbitListener(queues = RabbitMqConfig.F_QUEUE_2)
    public void f_student2(ArrayList general){
        LOGGER.info("Fanout 2, general ");
        for (int i =0; i<general.size();i++){

            System.out.print("Fanout Exchange Second Queue ");
            System.out.println(general.get(i));
        }
    }
    @RabbitListener(queues = RabbitMqConfig.F_QUEUE_3)
    public void f_student3(ArrayList general){
        LOGGER.info("Fanout 3, general ");
        for (int i =0; i<general.size();i++){
            System.out.print("Fanout Exchange Third Queue ");
            System.out.println(general.get(i));
        }
    }
    @RabbitListener(queues = RabbitMqConfig.T_QUEUE_4)
    public void t_student2(ArrayList general){
        LOGGER.info("All topic ");
        for (int i =0; i<general.size();i++){
            System.out.print("Topic Exchange all ");
            System.out.println(general.get(i));
        }
    }

}
