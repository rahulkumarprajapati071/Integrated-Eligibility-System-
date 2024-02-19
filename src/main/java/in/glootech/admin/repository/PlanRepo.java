package in.glootech.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.glootech.admin.entity.Plan;

public interface PlanRepo extends JpaRepository<Plan, Integer>{

}
