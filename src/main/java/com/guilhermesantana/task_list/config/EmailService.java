package com.guilhermesantana.task_list.config;

import com.guilhermesantana.task_list.models.Tasks;
import com.guilhermesantana.task_list.repository.TasksRepository;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmailService {

    private JavaMailSender mailSender;
    private TasksRepository taskRepository;


    public EmailService(JavaMailSender mailSender, TasksRepository taskRepository) {
        this.mailSender = mailSender;
        this.taskRepository = taskRepository;
    }

    @Scheduled(cron = "0 0 8 * * *")
    public void checkTasksComing() {
        List<Tasks> listTasks = taskRepository.findTasksComming();

        for (Tasks task : listTasks) {
            sendEmail(task);
        }
    }

    private void sendEmail(Tasks task) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("guiguilsantana@gmail.com");
        message.setSubject("Aviso: Tarefa próxima ao vencimento");
        message.setText("Tarefa: " + task.getTitle() + "\nDescrição: " + task.getDescription());
        mailSender.send(message);
    }
}
