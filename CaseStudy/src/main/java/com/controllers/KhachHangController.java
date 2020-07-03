package com.controllers;

import com.models.KhachHangModels.KhachHang;
import com.models.KhachHangModels.LoaiKhachHang;
import com.services.KhachHang.KhachHangService;
import com.services.KhachHang.LoaiKhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(value = "/khach-hang")
public class KhachHangController {

    @Autowired
    KhachHangService khachHangService;

    @Autowired
    LoaiKhachHangService loaiKhachHangService;

    @ModelAttribute("listLoaiKhachHang")
    public Iterable<LoaiKhachHang> showListLoaiKhachHang() {
        return loaiKhachHangService.findAll();
    }

    @GetMapping("/danh-sach")
    public ModelAndView xemDanhSachKhachHang() {
        return new ModelAndView("/khach-hang/danh-sach", "listKhachHang", khachHangService.findAll());
    }

    @GetMapping("/them")
    public ModelAndView showThemMoi() {
        return new ModelAndView("/khach-hang/them", "khachHang", new KhachHang());
    }

    @PostMapping("/them")
    public String themMoiKhachHang(@ModelAttribute KhachHang khachHang, RedirectAttributes redirectAttributes) {
        khachHangService.them(khachHang);
        System.out.println(khachHang.toString());
        redirectAttributes.addFlashAttribute("message", "Tạo mới khách hàng thành công !");
        return "redirect:/khach-hang/danh-sach";
    }

    @GetMapping("/sua")
    public ModelAndView suaKhachHang(@RequestParam Long id) {
        return new ModelAndView("/khach-hang/sua", "khachHangSua", khachHangService.timTheoId(id));
    }

    @PostMapping("/sua")
    public String capNhatKhachHang(@ModelAttribute KhachHang khachHangDaCapNhat, RedirectAttributes redirectAttributes) {
        khachHangService.them(khachHangDaCapNhat);
        redirectAttributes.addFlashAttribute("message", "Cập nhật khách hàng thành công !");
        return "redirect:/khach-hang/danh-sach";
    }

//    @GetMapping("/xoa/{id}")
//    public String xacNhanXoaKhachHang(@PathVariable Long id) {
////        return new ModelAndView("/khachhang/xoa", "khachHangXoa", khachHangService.timTheoId(id));
//        khachHangService.xoaTheoId(id);
//        return "redirect:/khach-hang/danh-sach";
//    }

    @GetMapping("/xoa")
    public String xoaKhachHang(@RequestParam Long id, RedirectAttributes redirectAttributes) {
        khachHangService.xoaTheoId(id);
        redirectAttributes.addFlashAttribute("message", "Xoá khách hàng thành công !");
        return "redirect:/khach-hang/danh-sach";
    }
}
