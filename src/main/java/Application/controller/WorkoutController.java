package Application.controller;

import Application.model.Workout;
import Application.service.WorkoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class WorkoutController {

    @Autowired
    private WorkoutService workoutService;

    @GetMapping(value = "/")
    public ModelAndView getWorkout() {
        ModelAndView modelAndView = new ModelAndView();
        try {
            List<Workout> workouts = workoutService.findAll();
            modelAndView.setViewName("Workout.html");
            modelAndView.addObject("tableWorkout", workouts);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return modelAndView;
    }

    @PostMapping(value = "/", params = "add")
    public ModelAndView postAddWorkout(@RequestParam String exerciseName,
                                       @RequestParam String muscleName,
                                       @RequestParam String recommendedExecutionTime,
                                       @RequestParam String description,
                                       @RequestParam String numberOfRepetitions,
                                       @RequestParam String numberOfApproaches) {
        ModelAndView modelAndView = new ModelAndView(new RedirectView("/"));
        try {
            Workout workout = new Workout(exerciseName, muscleName, recommendedExecutionTime, description, numberOfRepetitions, numberOfApproaches);
            workoutService.saveService(workout);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return modelAndView;
    }

    @PostMapping(value = "/", params = "update")
    public ModelAndView postUpdateWorkout(@RequestParam long id,
                                          @RequestParam String exerciseName,
                                          @RequestParam String muscleName,
                                          @RequestParam String recommendedExecutionTime,
                                          @RequestParam String description,
                                          @RequestParam String numberOfRepetitions,
                                          @RequestParam String numberOfApproaches) {
        ModelAndView modelAndView = new ModelAndView(new RedirectView("/"));
        try {
            Workout workout = workoutService.findId(id);
            workoutService.updateService(workout, id, exerciseName, muscleName, recommendedExecutionTime, description, numberOfRepetitions, numberOfApproaches);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return modelAndView;
    }

    @PostMapping(value = "/", params = "delete")
    public ModelAndView postDeleteWorkout(@RequestParam long id) {
        ModelAndView modelAndView = new ModelAndView(new RedirectView("/"));
        try {
            Workout workout = workoutService.findId(id);
            workoutService.deleteService(workout);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return modelAndView;
    }
}
