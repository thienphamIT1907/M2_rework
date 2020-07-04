package com.controllers;

import com.models.DichVuModels.DichVu;
import com.models.DichVuModels.KieuThue;
import com.models.DichVuModels.LoaiDichVu;
import com.models.KhachHangModels.KhachHang;
import com.services.DichVu.DichVuService;
import com.services.DichVu.KieuThueService;
import com.services.DichVu.LoaiDichVuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/dich-vu")
public class DichVuController {

    @Autowired
    DichVuService dichVuService;

    @Autowired
    LoaiDichVuService loaiDichVuService;

    @Autowired
    KieuThueService kieuThueService;

    @ModelAttribute("listLoaiDichVu")
    public Iterable<LoaiDichVu> showListLoaiDichVu() {
        return loaiDichVuService.findAll();
    }

    @ModelAttribute("listKieuThue")
    public Iterable<KieuThue> showListKieuThue() {
        return kieuThueService.findAll();
    }

    @GetMapping("/danh-sach")
    public String xemDanhSachDichVu(
            @PageableDefault(size = 9) Pageable pageable,
            @RequestParam Optional<String> keyword,
            Model model
            ) {
        Page<DichVu> dichVuPage;
        if(keyword.isPresent()) {
            dichVuPage = dichVuService.findAllByTenDichVuContaining(keyword.get(), pageable);
        } else {
            dichVuPage = dichVuService.findAllPaging(pageable);
        }
        model.addAttribute("listDichVu", dichVuPage);
        return "/dich-vu/danh-sach";
    }

    @GetMapping("/them")
    public ModelAndView showThemMoi() {
        return new ModelAndView("dich-vu/them", "dichVu", new DichVu());
    }

    @PostMapping("/them")
    public String themMoiDichVu(
            RedirectAttributes redirectAttributes,
            @Validated @ModelAttribute DichVu dichVu,
            BindingResult bindingResult
    ) {
        if(bindingResult.hasFieldErrors()) {
            return "dich-vu/them";
        } else {
            dichVuService.them(dichVu);
            redirectAttributes.addFlashAttribute("message", "Tạo mới dịch vụ thành công !");
            return "redirect:/dich-vu/danh-sach";
        }
    }

    @GetMapping("/sua")
    public ModelAndView suaDichVu(@RequestParam Long id) {
        return new ModelAndView("/dich-vu/sua", "dichVuSua", dichVuService.timTheoId(id));
    }

    @PostMapping("/sua")
    public String capNhatDichVu(@ModelAttribute DichVu dichVuDaCapNhat, RedirectAttributes redirectAttributes) {
        dichVuService.them(dichVuDaCapNhat);
        redirectAttributes.addFlashAttribute("message", "Cập nhật dịch vụ thành công !");
        return "redirect:/dich-vu/danh-sach";
    }

    @GetMapping("/xoa")
    public String xoaDichVu(@RequestParam Long id, RedirectAttributes redirectAttributes) {
        dichVuService.xoaTheoId(id);
        redirectAttributes.addFlashAttribute("message", "Xoá dich vụ thành công !");
        return "redirect:/dich-vu/danh-sach";
    }
}
