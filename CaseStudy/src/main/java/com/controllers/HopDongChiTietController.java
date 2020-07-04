package com.controllers;

import com.models.DichVuModels.DichVuDiKem;
import com.models.DichVuModels.HopDong;
import com.models.DichVuModels.HopDongChiTiet;
import com.services.DichVu.DichVuDiKemService;
import com.services.DichVu.HopDongChiTietService;
import com.services.DichVu.HopDongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/hop-dong-chi-tiet")
public class HopDongChiTietController {

    @Autowired
    HopDongChiTietService hopDongChiTietService;

    @Autowired
    HopDongService hopDongService;

    @Autowired
    DichVuDiKemService dichVuDiKemService;

    @ModelAttribute("listHopDong")
    public Iterable<HopDong> showListHopDong() {
        return hopDongService.findAll();
    }

    @ModelAttribute("listDichVuDiKem")
    public Iterable<DichVuDiKem> showListDichVuDiKem() {
        return dichVuDiKemService.findAll();
    }

    @GetMapping("/danh-sach")
    public ModelAndView xemDanhSachHopDongChiTiet() {
        return new ModelAndView("hop-dong-chi-tiet/danh-sach", "listHopDongChiTiet", hopDongChiTietService.findAll());
    }

    @GetMapping("/them")
    public ModelAndView showThemMoi() {
        return new ModelAndView("hop-dong-chi-tiet/them", "hopDongChiTiet", new HopDongChiTiet());
    }

    @PostMapping("/them")
    public String themMoiHopDongChiTiet(@ModelAttribute HopDongChiTiet hopDongChiTiet, RedirectAttributes redirectAttributes) {
        hopDongChiTietService.them(hopDongChiTiet);
        redirectAttributes.addFlashAttribute("message", "Tạo mới hợp đồng chi tiết thành công !");
        return "redirect:/hop-dong-chi-tiet/danh-sach";
    }

    @GetMapping("/sua")
    public ModelAndView suaHopDongChiTiet(@RequestParam Long id) {
        return new ModelAndView("/hop-dong-chi-tiet/sua", "hopDongChiTietSua", hopDongChiTietService.timTheoId(id));
    }

    @PostMapping("/sua")
    public String capNhatHopDongChiTiet(@ModelAttribute HopDongChiTiet hopDongChiTiet, RedirectAttributes redirectAttributes) {
        hopDongChiTietService.them(hopDongChiTiet);
        redirectAttributes.addFlashAttribute("message", "Cập nhật hợp đồng chi tiết thành công !");
        return "redirect:/hop-dong-chi-tiet/danh-sach";
    }

    @GetMapping("/xoa")
    public String xoaHopDongChiTiet(@RequestParam Long id, RedirectAttributes redirectAttributes) {
        hopDongChiTietService.xoaTheoId(id);
        redirectAttributes.addFlashAttribute("message", "Xoá hợp đồng chi tiết thành công !");
        return "redirect:/hop-dong-chi-tiet/danh-sach";
    }
}
