package com.testing.security.controllers;

@Controller
public class WebController {
    @RequestMapping(value = "/fileUpload", method = RequestMethod.POST)
    public String importParse(@RequestParam("myFile") MultipartFile myFile) {
        // ... do whatever you want with 'myFile'
        // Redirect to a successful upload page
        return "redirect:uploadSuccess.html";
    }
}
