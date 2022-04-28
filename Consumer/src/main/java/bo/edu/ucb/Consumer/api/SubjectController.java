package bo.edu.ucb.Consumer.api;

import bo.edu.ucb.Consumer.Dto.Subject;
import bo.edu.ucb.Consumer.config.RabbitMqConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SubjectController {
    private static Logger LOGGER = LoggerFactory.getLogger(SubjectController.class);
    @RabbitListener(queues = RabbitMqConfig.D_QUEUE3)
    public void d_subject(List<Subject> subject){
        LOGGER.info("Direct Exchange Subject");
        for (int i =0; i<subject.size();i++){
            //System.out.print("Subject list direct exchange");
            System.out.println(subject.get(i));
        }
    }

    @RabbitListener(queues = RabbitMqConfig.T_QUEUE_2)
    public void t_subject(List<Subject> subject){
        LOGGER.info("Topic Exchange Subject");
        for (int i =0; i<subject.size();i++){
            //System.out.print("Subject list, topic exchange subject ");
            System.out.println(subject.get(i));
        }
    }

}
