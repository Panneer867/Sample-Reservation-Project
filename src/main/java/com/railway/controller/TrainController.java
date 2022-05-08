package com.railway.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.railway.model.Train;
import com.railway.service.TrainServiceImpl;


@Controller
public class TrainController {

    @Autowired
    private TrainServiceImpl trainService;

    @GetMapping("/adminDashboard")
    public String dashboard(Model model) {
        model.addAttribute("listTrains", trainService.getAllTrains());
        return "admin/dashboard";
    }


    @GetMapping("/addTrains")
    public String addTrainList(Model model) {
        model.addAttribute("train", new Train());
        return "admin/addtrain";
    }


    @PostMapping("/addTrains")
    public String saveTrain(@Valid @ModelAttribute("train") Train train, BindingResult result) {
    	
    	if(result.hasErrors()) {
			return "admin/addtrain";
		}
        trainService.saveTrain(train);
        return "redirect:/adminDashboard";
    }
    
    @PostMapping("/saveTrain")
    public String saveTrain(@ModelAttribute("train") Train train) {
        trainService.saveTrain(train);
        return "redirect:/adminDashboard";
    }


    @GetMapping("/updateTrainNo-{trainNo}")
    public String trainUpdate(@PathVariable(value = "trainNo") long trainNo, Model model) {
        Train train = trainService.getTrainById(trainNo);
        model.addAttribute("train", train);
        return "admin/updateTrain";
    }


    @RequestMapping(value = "/deleteTrainNo-{trainNo}", method= {RequestMethod.DELETE,RequestMethod.GET})
    public String deleteTrain(@PathVariable(value = "trainNo") long trainNo) {
        this.trainService.deleteTrainById(trainNo);
        return "redirect:adminDashboard";
    }

}