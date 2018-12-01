package com.testing.security.controllers;

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


    @RequestMapping(value = "/fileUpload", method = RequestMethod.POST)
    public String importParse(@RequestParam("myFile") MultipartFile myFile, Model model) {
        model.addAttribute(MODEL_SUCCESS, "Successful loading of file.");
        return "index.html";
    }
}
