package com.engenes.spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//Tarayıcıda bu dosyadan işlem yapabilirim demek
@Controller
@ResponseBody
// browser'a ne yazdığında çalıştırcağını söylüyoruz
@RequestMapping("/")
public class TestController {

    //url adresi mappleme işlemi
    @GetMapping("/")
    public String home(){
        return "Anasayfa";
    }


}
