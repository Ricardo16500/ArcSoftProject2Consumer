package bo.edu.ucb.Consumer.api;

import bo.edu.ucb.Consumer.config.RabbitMqConfig;
import bo.edu.ucb.Consumer.Dto.Teacher;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class TeacherController {

    @RabbitListener(queues = RabbitMqConfig.D_QUEUE2)
    public void d_teacher(List<Teacher> teacher){
        for (int i =0; i<teacher.size();i++){
            System.out.print("teacher list, direct exchange ");
            System.out.println(teacher.get(i));
        }
    }

    @RabbitListener(queues = RabbitMqConfig.F_QUEUE_1)
    public void f_teacher(List<Teacher> teacher){
        Integer cont = 0;
        for (int i =0; i<teacher.size();i++){
            if (teacher.get(i) == null){
                cont++;
            }
        }
        if(cont <=1) {
            for (int i = 0; i < teacher.size(); i++) {
                System.out.print("teacher list, first fanout exchange  ");
                System.out.println(teacher.get(i));
            }
        }
    }
    @RabbitListener(queues = RabbitMqConfig.F_QUEUE_2)
    public void f_teacher_2(List<Teacher> teacher){
        Integer cont = 0;
        for (int i =0; i<teacher.size();i++){
            if (teacher.get(i) == null){
                cont++;
            }
        }
        if(cont <=1) {
            for (int i = 0; i < teacher.size(); i++) {
                System.out.print("teacher list, second fanout exchange  ");
                System.out.println(teacher.get(i));
            }
        }
    }
    @RabbitListener(queues = RabbitMqConfig.F_QUEUE_3)
    public void f_teacher_3(List<Teacher> teacher){
        Integer cont = 0;
        for (int i =0; i<teacher.size();i++){
            if (teacher.get(i) == null){
                cont++;
            }
        }
        if(cont <=1) {
            for (int i = 0; i < teacher.size(); i++) {
                System.out.print("teacher list, thrid fanout exchange  ");
                System.out.println(teacher.get(i));
            }
        }
    }
    @RabbitListener(queues = RabbitMqConfig.T_QUEUE_3)
    public void t_teacher(List<Teacher> teacher){
        for (int i =0; i<teacher.size();i++){
            System.out.print("teacher list, topic exchange teacher ");
            System.out.println(teacher.get(i));
        }
    }
    @RabbitListener(queues = RabbitMqConfig.T_QUEUE_4)
    public void t_teacher_2(List<Teacher> teacher){

        Integer cont = 0;
        for (int i =0; i<teacher.size();i++){
            if (teacher.get(i) == null){
                cont++;
            }
        }
        if(cont <=1) {
            for (int i = 0; i < teacher.size(); i++) {
                System.out.print("teacher list, topic exchange all ");
                System.out.println(teacher.get(i));
            }
        }
    }
    @RabbitListener(queues = RabbitMqConfig.T_QUEUE_5)
    public void t_teacher_3(List<Teacher> teacher){
        Integer cont = 0;
        for (int i =0; i<teacher.size();i++){
            if (teacher.get(i) == null){
                cont++;
            }
        }
        if(cont <=1) {
            for (int i = 0; i < teacher.size(); i++) {
                System.out.print("teacher list, topic exchange teacher and student ");
                System.out.println(teacher.get(i));
            }
        }
    }

}
