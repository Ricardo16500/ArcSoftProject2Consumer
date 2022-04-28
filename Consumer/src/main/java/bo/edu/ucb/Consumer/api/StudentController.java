package bo.edu.ucb.Consumer.api;

import bo.edu.ucb.Consumer.config.RabbitMqConfig;
import bo.edu.ucb.Consumer.Dto.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Component
public class StudentController {
    private static Logger LOGGER = LoggerFactory.getLogger(StudentController.class);

    @RabbitListener(queues = RabbitMqConfig.D_QUEUE1)
    public void d_student(List<Student> student){
        LOGGER.info("Direct Exchange student");
        for (int i =0; i<student.size();i++){
            //System.out.print("Direct Exchange ");
            System.out.println(student.get(i));
        }
    }


    @RabbitListener(queues = RabbitMqConfig.T_QUEUE_1)
    public void t_student(ArrayList student){
        LOGGER.info("Topic Exchange student");
        for (int i =0; i<student.size();i++){
            //System.out.print ("Topic Exchange Student ");
            System.out.println(student.get(i));
        }
    }





}
