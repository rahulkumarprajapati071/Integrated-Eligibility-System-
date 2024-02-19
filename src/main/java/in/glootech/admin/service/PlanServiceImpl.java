package in.glootech.admin.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.glootech.admin.entity.Plan;
import in.glootech.admin.repository.PlanRepo;

@Service
@Transactional
public class PlanServiceImpl implements PlanService {

    @Autowired
    private PlanRepo planRepository;

    @Override
    public Boolean savePlan(Plan plan) {
        try {
            planRepository.save(plan);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Boolean updatePlan(Integer planId, Plan plan) {
        try {
            Plan existingPlan = planRepository.findById(planId).orElse(null);
            if (existingPlan != null) {
            	BeanUtils.copyProperties(plan,existingPlan);
                planRepository.save(existingPlan);
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Plan> getAllPlan() {
        return planRepository.findAll();
    }

    @Override
    public Plan getPlanById(Integer planId) {
        return planRepository.findById(planId).orElse(null);
    }

    @Override
    public Boolean changeStatus(Integer planId) {
        try {
            Plan existingPlan = planRepository.findById(planId).orElse(null);
            if (existingPlan != null) {
                existingPlan.setActiveStatus(!existingPlan.getActiveStatus());
                planRepository.save(existingPlan);
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
