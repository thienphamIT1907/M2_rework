package com.controllers;

import com.models.DichVuModels.HopDong;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class LichSuGiaoDichController {

    @GetMapping("/lichSuGiaoDich")
    public ModelAndView showLichSuGiaoDich(HttpServletRequest request, HttpServletResponse response) {
        Cookie[] cookies = request.getCookies();
        for(int i = 0; i < cookies.length; i++) {
            if(cookies[i].getName().contains("hopDong")) {
                HopDong hd = new HopDong();
                String[] cookiesValue = cookies[i].getValue().split("_");
                hd.setIdHopDong(Long.parseLong(cookiesValue[0]));
            }
        }
        return new ModelAndView("dich-vu/lich-su-giao-dich");
    }
}
