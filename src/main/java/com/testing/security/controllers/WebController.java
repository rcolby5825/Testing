package com.testing.security.controllers;

import com.testing.security.services.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.ui.Model;


@Controller
public class WebController {
    private static final String MODEL_SUCCESS = "success";
    private static final String MODEL_ERROR = "error";
    private static final String MODEL_TEXT = "text";
    @Autowired
    private FileService fileService;

    @RequestMapping(value = "/fileUpload", method = RequestMethod.POST)
    public String importParse(@RequestParam("textFile") MultipartFile textFile, Model model) {
        if(textFile.isEmpty()){
            model.addAttribute(MODEL_ERROR, "No file was uploaded.");
            return "index.html";
        }
        //would need to be altered to work with doc with one hash/line
        if (!textFile.getOriginalFilename().equals("crackHashes.txt")) {
            model.addAttribute(MODEL_ERROR, "Upload crackHashes.txt file.");
            System.out.println(textFile.getOriginalFilename());
            return "index.html";
        }
        model.addAttribute(MODEL_SUCCESS, "Successful loading of file.");
        model.addAttribute(MODEL_TEXT, fileService.readFile(textFile));
        return "index.html";
    }
}
