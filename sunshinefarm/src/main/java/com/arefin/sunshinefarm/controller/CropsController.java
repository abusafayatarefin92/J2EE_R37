package com.arefin.sunshinefarm.controller;

import com.arefin.sunshinefarm.entity.Crops;
import com.arefin.sunshinefarm.image.ImageOptimizer;
import com.arefin.sunshinefarm.repo.CropsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
@RequestMapping(value = "/crops/")
public class CropsController {
    //Save the uploaded file to this folder
    private static final String UPLOADED_FOLDER = "src/main/resources/static/images/";

    @Autowired
    private ImageOptimizer imageOptimizer;

    @Autowired
    private CropsRepo cropsRepo;

    @GetMapping(value = "list")
    public String cropsListView(Model model) {
        model.addAttribute("cropslist", this.cropsRepo.findAll());
        this.cropsRepo.findAll().forEach((crops) -> {
            System.out.println(crops.toString());
        });
        return "crops/list";
    }

    @GetMapping(value = "create")
    public String addCropsView() {
        return "crops/create";
    }

    @PostMapping(value = "create")
    public String addCrops(@Valid Crops crops, BindingResult bindingResult, Model model, @RequestParam("file") MultipartFile file) {
        if (bindingResult.hasErrors()) {
            return "crops/create";
        } else {
            if (crops != null) {
                Crops crops1 = this.cropsRepo.findByName(crops.getName());
                if(crops1 != null){
                    model.addAttribute("existCrops", "crop is already exist");
                }else{
                    try {
                        //////////////////////For Image Upload start /////////////////////
                        byte[] bytes = file.getBytes();
                        Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());

                        Files.write(path, bytes);
                        crops.setFileName("new-" + file.getOriginalFilename());
                        crops.setFileSize(file.getSize());
                        crops.setFilePath("images/" + "new-" + file.getOriginalFilename());
                        crops.setFileExtention(file.getContentType());
                        //////////////////////For Image Upload end/////////////////////
                        this.cropsRepo.save(crops);
                        model.addAttribute("crops", new Crops());
                        model.addAttribute("successcrops", "You Have Successfully add crop");
                        imageOptimizer.optimizeImage(UPLOADED_FOLDER, file, 1.0f, 100, 100);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return "crops/create";
    }

    @GetMapping(value = "update/{id}")
    public String editCropsView(Model model, @PathVariable("id") Long id) {
        model.addAttribute("crops", this.cropsRepo.getOne(id));
        return "crops/update";
    }

    @PostMapping(value = "update/{id}")
    public String editCrops(@Valid Crops crops, BindingResult bindingResult, @PathVariable("id") Long id, Model model, @RequestParam("file") MultipartFile file) {
        Crops crops1 = this.cropsRepo.getOne(id);
        if (bindingResult.hasErrors()) {
            return "crops/update";
        }
        try {
            //////////////////////For Image Upload start /////////////////////
            if (file.getOriginalFilename().length() > 0) {
                byte[] bytes = file.getBytes();
                Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());

                Files.write(path, bytes);
                crops.setFileName("new-" + file.getOriginalFilename());
                crops.setFileSize(file.getSize());
                crops.setFilePath("images/" + "new-" + file.getOriginalFilename());
                crops.setFileExtention(file.getContentType());
            } else {
                crops.setFileName(crops1.getFileName());
                crops.setFilePath(crops1.getFilePath());
                crops.setFileSize(crops1.getFileSize());
                crops.setFileExtention(crops1.getFileExtention());
            }
            //////////////////////For Image Upload end/////////////////////
            this.cropsRepo.save(crops);
            model.addAttribute("crops", new Crops());
            model.addAttribute("successcrops", "You Have Successfully Edited crop");
            if (file.getOriginalFilename().length() > 0) {
                imageOptimizer.optimizeImage(UPLOADED_FOLDER, file, 1.0f, 100, 100);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "crops/list";
    }

    @GetMapping(value = "delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        if (id != null) {
            this.cropsRepo.deleteById(id);
        }
        return "crops/list";
    }
}
