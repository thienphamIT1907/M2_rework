package com.controllers;

import com.models.DichVuModels.DichVu;
import com.models.KhachHangModels.KhachHang;
import com.services.DichVu.DichVuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/dich-vu")
public class DichVuController {

    @Autowired
    DichVuService dichVuService;

//    @ModelAttribute("listDichVu")
//    public Iterable<DichVu> showListLoaiKhachHang() {
//        return loaiKhachHangService.findAll();
//    }

    @GetMapping("/danh-sach")
    public ModelAndView xemDanhSachDichVu() {
        return new ModelAndView("", "listDichVu", dichVuService.findAll());
    }

    @GetMapping("/them")
    public ModelAndView showThemMoi() {
        return new ModelAndView("KhachHang/them", "khachHang", new KhachHang());
    }

    @PostMapping("/them")
    public String themMoiDichVu(@ModelAttribute DichVu dichVu, RedirectAttributes redirectAttributes) {
        dichVuService.them(dichVu);
        redirectAttributes.addFlashAttribute("message", "Tạo mới dịch vụ thành công !");
        return "redirect:/dich-vu/danh-sach";
    }

    @GetMapping("/sua/{id}")
    public ModelAndView suaDichVu(@PathVariable Long id) {
        return new ModelAndView("/", "dichVuSua", dichVuService.timTheoId(id));
    }

    @PostMapping("/sua")
    public String capNhatDichVu(@ModelAttribute DichVu dichVuDaCapNhat, RedirectAttributes redirectAttributes) {
        dichVuService.them(dichVuDaCapNhat);
        redirectAttributes.addFlashAttribute("message", "Cập nhật dịch vụ thành công !");
        return "redirect:/dich-vu/danh-sach";
    }

    @GetMapping("/xoa/{id}")
    public ModelAndView xacNhanXoaDichVu(@PathVariable Long id) {
        return new ModelAndView("/dich-vu/xoa", "dichVuXoa", dichVuService.timTheoId(id));
    }

    @PostMapping("/xoa")
    public String xoaDichVu(@ModelAttribute DichVu dichVu, RedirectAttributes redirectAttributes) {
        dichVuService.xoaTheoId(dichVu.getIdDichVu());
        redirectAttributes.addFlashAttribute("message", "Xoá dịch vụ thành công !");
        return "redirect:/dich-vu/danh-sach";
    }
}
