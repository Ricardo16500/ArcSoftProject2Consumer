package bo.edu.ucb.Consumer.api;

import bo.edu.ucb.Consumer.config.RabbitMqConfig;
import bo.edu.ucb.Consumer.Dto.Teacher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class TeacherController {
    private static Logger LOGGER = LoggerFactory.getLogger(TeacherController.class);
    @RabbitListener(queues = RabbitMqConfig.D_QUEUE2)
    public void d_teacher(List<Teacher> teacher){
        LOGGER.info("Direct exchange teacher");
        for (int i =0; i<teacher.size();i++){
            System.out.print("teacher list, direct exchange ");
            System.out.println(teacher.get(i));
        }
    }

    @RabbitListener(queues = RabbitMqConfig.T_QUEUE_3)
    public void t_teacher(List<Teacher> teacher){
        LOGGER.info("Topic exchange teacher");
        for (int i =0; i<teacher.size();i++){
           System.out.print("teacher list, topic exchange teacher ");
            System.out.println(teacher.get(i));
        }
    }

}
