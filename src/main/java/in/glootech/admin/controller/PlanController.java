package in.glootech.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import in.glootech.admin.entity.Plan;
import in.glootech.admin.service.PlanService;

@RestController
@RequestMapping("/plans")
public class PlanController {

    @Autowired
    private PlanService planService;

    @PostMapping("/save")
    public ResponseEntity<String> savePlan(@RequestBody Plan plan) {
        Boolean saved = planService.savePlan(plan);
        if (saved) {
            return ResponseEntity.ok("Plan saved successfully");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to save plan");
        }
    }

    @PutMapping("edit/{planId}")
    public ResponseEntity<String> updatePlan(@PathVariable Integer planId, @RequestBody Plan plan) {
        Boolean updated = planService.updatePlan(planId, plan);
        if (updated) {
            return ResponseEntity.ok("Plan updated successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Plan not found");
        }
    }

    @GetMapping("getbyid/{planId}")
    public ResponseEntity<Plan> getPlanById(@PathVariable Integer planId) {
        Plan plan = planService.getPlanById(planId);
        if (plan != null) {
            return ResponseEntity.ok(plan);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/getall")
    public ResponseEntity<List<Plan>> getAllPlans() {
        List<Plan> plans = planService.getAllPlan();
        return ResponseEntity.ok(plans);
    }

    @PutMapping("status/{planId}")
    public ResponseEntity<Boolean> deleteUser(@PathVariable Integer planId) {
        Boolean unlock = planService.changeStatus(planId);
        if (unlock) {
            return ResponseEntity.ok(true);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
