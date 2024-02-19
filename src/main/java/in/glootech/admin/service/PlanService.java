package in.glootech.admin.service;

import java.util.List;

import in.glootech.admin.entity.Plan;

public interface PlanService {
	public Boolean savePlan(Plan plan);
	public Boolean updatePlan(Integer planId,Plan plan);
	public List<Plan> getAllPlan();
	public Plan getPlanById(Integer planId);
	public Boolean changeStatus(Integer planId);
}
