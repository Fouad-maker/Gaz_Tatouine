package tn.com.etap.EtapWorkers.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.com.etap.EtapWorkers.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {

}
