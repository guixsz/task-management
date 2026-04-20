package com.guilhermesantana.task_list.config;

import com.guilhermesantana.task_list.models.Tasks;
import com.guilhermesantana.task_list.repository.TasksRepository;
import com.guilhermesantana.task_list.util.DateFormat;
import jakarta.mail.internet.MimeMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
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
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");

            helper.setTo("guiguilsantana@gmail.com");
            helper.setSubject("Lembrete de Tarefa: " + task.getTitle());

            String htmlContent = "<html>" +
                    "<body style='font-family: Arial, sans-serif;'>" +
                    "<h2 style='color: #2E86C1; font-size:22px'>Você tem uma tarefa hoje!</h2>" +
                    "<p style='font-size: 18px;'>Olá. Bom dia, Senhor! Não se esqueça! <b>" + task.getTitle() + "</b> às <b>"+ DateFormat.dateFormatted(task.getDate()) + "</b></p>" +
                    "</body>" +
                    "</html>";

            helper.setText(htmlContent, true);

            mailSender.send(message);
        } catch (Exception e) {
            throw new IllegalArgumentException("Erro ao enviar e-mail HTML: ", e);
        }
    }
}
