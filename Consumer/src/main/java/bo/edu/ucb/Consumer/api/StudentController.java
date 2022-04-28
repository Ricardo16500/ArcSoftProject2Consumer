package bo.edu.ucb.Consumer.api;

import bo.edu.ucb.Consumer.config.RabbitMqConfig;
import bo.edu.ucb.Consumer.Dto.Student;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Component
public class StudentController {

    @RabbitListener(queues = RabbitMqConfig.D_QUEUE1)
    public void d_student(List<Student> student){

        for (int i =0; i<student.size();i++){
            System.out.print("Direct Exchange ");
            System.out.println(student.get(i));
        }
    }
    @RabbitListener(queues = RabbitMqConfig.F_QUEUE_1)
    public void f_student(ArrayList student){

        for (int i =0; i<student.size();i++){
            System.out.print("Fanout Exchange Fisrt Queue");
            System.out.println(student.get(i));
        }
    }
    @RabbitListener(queues = RabbitMqConfig.F_QUEUE_2)
    public void f_student2(ArrayList student){

        for (int i =0; i<student.size();i++){
            System.out.print("Fanout Exchange Second Queue ");
            System.out.println(student.get(i));
        }
    }
    @RabbitListener(queues = RabbitMqConfig.F_QUEUE_3)
    public void f_student3(ArrayList student){

        for (int i =0; i<student.size();i++){
            System.out.print("Fanout Exchange Third Queue ");
            System.out.println(student.get(i));
        }
    }
    @RabbitListener(queues = RabbitMqConfig.T_QUEUE_1)
    public void t_student(ArrayList student){

        for (int i =0; i<student.size();i++){
            System.out.print ("Topic Exchange Student ");
            System.out.println(student.get(i));
        }
    }
    @RabbitListener(queues = RabbitMqConfig.T_QUEUE_4)
    public void t_student2(ArrayList student){

        for (int i =0; i<student.size();i++){
            System.out.print("Topic Exchange all ");
            System.out.println(student.get(i));
        }
    }
    @RabbitListener(queues = RabbitMqConfig.T_QUEUE_5)
    public void t_student3(ArrayList student){
        for (int i =0; i<student.size();i++){
            System.out.print("Topic Exchange student, teacher ");
            System.out.println(student.get(i));
        }


    }




}
