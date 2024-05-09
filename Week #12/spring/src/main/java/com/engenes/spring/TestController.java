package com.engenes.spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

//Tarayıcıda bu dosyadan işlem yapabilirim demek
@Controller
@ResponseBody
// browser'a ne yazdığında çalıştırcağını söylüyoruz
// ortak olan pathi burda yazabiliriz mesal tr
@RequestMapping("/")
public class TestController {

    //url adresi mappleme işlemi
    @GetMapping("/")
    public String home(){
        return "Anasayfa";
    }

    @GetMapping("/about")
    //@RequestMapping(value = "/about", method = RequestMethod.GET) buda aynı işlevi görüyor
    public String about(){
        return "About Us Page";
    }
    // tarayıcı üzerinden urlden veri almak
    @GetMapping("/user/{userId}/{userName}")
    public String getUser(@PathVariable("userId") int user_id, @PathVariable("userName") String userName ) {
        return "User id : " + user_id + " " + userName;
    }



}
