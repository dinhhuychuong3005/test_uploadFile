package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;

@Controller
public class ProductController {
    @GetMapping("/home")
    public ModelAndView showForm() {
        ModelAndView modelAndView = new ModelAndView("/home");
        return modelAndView;
    }

    @PostMapping("/upload")
    public ModelAndView upload(@RequestParam MultipartFile img) {
        String fileName = img.getOriginalFilename();
        try {
            FileCopyUtils.copy(img.getBytes(),new File("D:/image/" + fileName));

        }catch (IOException e){
            e.printStackTrace();
        }
        ModelAndView modelAndView = new ModelAndView("/upload");
        modelAndView.addObject("img", fileName);
        return modelAndView;
    }
}
