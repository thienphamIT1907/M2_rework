package com.controllers;

import com.models.NhanVienModels.BoPhan;
import com.models.NhanVienModels.NhanVien;
import com.models.NhanVienModels.TrinhDo;
import com.models.NhanVienModels.ViTri;
import com.services.NhanVien.BoPhanService;
import com.services.NhanVien.NhanVienService;
import com.services.NhanVien.TrinhDoService;
import com.services.NhanVien.ViTriService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(value = "/nhan-vien")
public class NhanVienController {

    @Autowired
    NhanVienService nhanVienService;

    @Autowired
    TrinhDoService trinhDoService;

    @Autowired
    BoPhanService boPhanService;

    @Autowired
    ViTriService viTriService;

    @ModelAttribute("listTrinhDo")
    public Iterable<TrinhDo> showListTrinhDo() {
        return trinhDoService.findAll();
    }

    @ModelAttribute("listBoPhan")
    public Iterable<BoPhan> showListBoPhan() {
        return boPhanService.findAll();
    }

    @ModelAttribute("listViTri")
    public Iterable<ViTri> showListViTri() {
        return viTriService.findAll();
    }

    @GetMapping("/danh-sach")
    public ModelAndView xemDanhSachNhanVien() {
        return new ModelAndView("NhanVien/danh-sach", "listNhanVien", nhanVienService.findAll());
    }

    @GetMapping("/them")
    public ModelAndView showThemMoi() {
        return new ModelAndView("NhanVien/them", "nhanVien", new NhanVien());
    }

    @PostMapping("/them")
    public String themMoiNhanVien(@ModelAttribute NhanVien nhanVien, RedirectAttributes redirectAttributes) {
        nhanVienService.them(nhanVien);
        redirectAttributes.addFlashAttribute("message", "Tạo mới nhân viên thành công !");
        return "redirect:/nhan-vien/danh-sach";
    }

    @GetMapping("/sua/{id}")
    public ModelAndView suaNhanVien(@PathVariable Long id) {
        return new ModelAndView("/NhanVien/sua", "nhanVienSua", nhanVienService.timTheoId(id));
    }

    @PostMapping("/sua")
    public String capNhatNhanVien(@ModelAttribute NhanVien NhanVienDaCapNhat, RedirectAttributes redirectAttributes) {
        nhanVienService.them(NhanVienDaCapNhat);
        redirectAttributes.addFlashAttribute("message", "Cập nhật nhân viên thành công !");
        return "redirect:/nhan-vien/danh-sach";
    }

    @GetMapping("/xoa/{id}")
    public ModelAndView xacNhanXoaNhanVien(@PathVariable Long id) {
        return new ModelAndView("/NhanVien/xoa", "NhanVienXoa", nhanVienService.timTheoId(id));
    }

    @PostMapping("/xoa")
    public String xoaNhanVien(@ModelAttribute NhanVien NhanVien, RedirectAttributes redirectAttributes) {
        nhanVienService.xoaTheoId(NhanVien.getIdNhanVien());
        redirectAttributes.addFlashAttribute("message", "Xoá nhân viên thành công !");
        return "redirect:/nhan-vien/danh-sach";
    }
}

