package com.javadevjournal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class FIleUploadController {

    @GetMapping(value = "/saveFile")
    public String getFileU(Model model){
        return "uploadForm";
    }

    @PostMapping(value = "/saveFile")
    public String handleFileUpload(@RequestParam("file") MultipartFile file, Model model) {

        //Logic to store data in temp file or in DB
        model.addAttribute("uploadedFile", file);
        return "uploadForm";
    }

    @PostMapping(value = "/saveFiles")
    public String handleFileUpload(@RequestParam("files") MultipartFile[] files, Model model) {

        //Logic to store data in temp file or in DB
        model.addAttribute("uploadedFile", files);
        return "uploadForm";
    }
}
