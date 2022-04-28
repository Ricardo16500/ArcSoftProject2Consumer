package bo.edu.ucb.Consumer.api;

import bo.edu.ucb.Consumer.Dto.Subject;
import bo.edu.ucb.Consumer.config.RabbitMqConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SubjectController {

    @RabbitListener(queues = RabbitMqConfig.D_QUEUE3)
    public void d_subject(List<Subject> subject){
        for (int i =0; i<subject.size();i++){
            System.out.print("Subject list direct exchange");
            System.out.println(subject.get(i));
        }
    }

    @RabbitListener(queues = RabbitMqConfig.F_QUEUE_1)
    public void f_subject(List<Subject> subject){
       Integer cont = 0;
        for (int i =0; i<subject.size();i++){
            if (subject.get(i) == null){
                cont++;
            }
        }
        if(cont <=1) {
            for (int i = 0; i < subject.size(); i++) {
                System.out.print("Subject list, first fanout exchange ");
                System.out.println(subject.get(i));
            }
        }
    }
    @RabbitListener(queues = RabbitMqConfig.F_QUEUE_2)
    public void f_subject2(List<Subject> subject){
        Integer cont = 0;
        for (int i =0; i<subject.size();i++){
            if (subject.get(i) == null){
                cont++;
            }
        }
        if(cont <=1) {
            for (int i = 0; i < subject.size(); i++) {
                System.out.print("Subject list, second fanout exchange ");
                System.out.println(subject.get(i));
            }
        }
    }
    @RabbitListener(queues = RabbitMqConfig.F_QUEUE_3)
    public void f_subject3(List<Subject> subject){
        Integer cont = 0;
        for (int i =0; i<subject.size();i++){
            if (subject.get(i).equals(null)){
                cont++;
            }
        }
        if(cont <=1) {
            for (int i = 0; i < subject.size(); i++) {
                System.out.print("Subject list, third fanout exchange ");
                System.out.println(subject.get(i));
            }
        }
    }

    @RabbitListener(queues = RabbitMqConfig.T_QUEUE_2)
    public void t_subject(List<Subject> subject){
        for (int i =0; i<subject.size();i++){
            System.out.print("Subject list, topic exchange subject ");
            System.out.println(subject.get(i));
        }
    }
    @RabbitListener(queues = RabbitMqConfig.T_QUEUE_4)
    public void t_subject_total(List<Subject> subject) {
        Integer cont = 0;
        for (int i = 0; i < subject.size(); i++) {
            if (subject.get(i).equals(null)) {
                cont++;
            }
        }
        if (cont <= 1) {
            for (int i = 0; i < subject.size(); i++) {
                System.out.print("Subject list, topic exchange all ");
                System.out.println(subject.get(i));
            }
        }
    }

}
