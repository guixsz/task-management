package com.guilhermesantana.task_list.repository;

import com.guilhermesantana.task_list.models.Tasks;
import com.guilhermesantana.task_list.models.enums.Category;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public class TasksRepository {

    private JdbcTemplate jdbcTemplate;

    public TasksRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private RowMapper<Tasks> tasksRowMapper = (rs, rowNum) -> {
        Tasks task = new Tasks();
        task.setId(rs.getInt("id"));
        task.setTitle(rs.getString("title"));
        task.setDescription(rs.getString("description"));
        task.setDate(rs.getObject("task_date", LocalDateTime.class));
        task.setCategory(Category.fromDescription(rs.getString("category")));
        task.setLocation(rs.getString("task_location"));
        task.setFinished(rs.getBoolean("is_finished"));

        return task;
    };

    public Tasks creteTask(Tasks task) {
        String sql = "INSERT INTO tasks(title, description, task_date, category, task_location, is_finished) VALUES(?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql,
                task.getTitle(),
                task.getDescription(),
                task.getDate(),
                task.getCategory().getDescription(),
                task.getLocation(),
                task.getIsFinished());

        return task;
    }

    public List<Tasks> findAll() {
        String sql = "SELECT * FROM tasks WHERE is_finished = false ORDER BY task_date";
        return jdbcTemplate.query(sql, tasksRowMapper);
    }

    public List<Tasks> findTasksComming() {
        String sql = "SELECT * FROM tasks WHERE task_date::date = CURRENT_DATE";
        return jdbcTemplate.query(sql, tasksRowMapper);
    }

    public void updateIsFinished(Integer id) {
        String sql = "UPDATE tasks SET is_finished = true WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
}
