package com.controllers;

import com.models.DichVuModels.DichVu;
import com.models.DichVuModels.HopDong;
import com.models.KhachHangModels.KhachHang;
import com.models.NhanVienModels.NhanVien;
import com.services.DichVu.DichVuService;
import com.services.DichVu.HopDongService;
import com.services.KhachHang.KhachHangService;
import com.services.NhanVien.NhanVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/hop-dong")
public class HopDongController {

    @Autowired
    HopDongService hopDongService;

    @Autowired
    NhanVienService nhanVienService;

    @Autowired
    KhachHangService khachHangService;

    @Autowired
    DichVuService dichVuService;

    @ModelAttribute("listNhanVien")
    public Iterable<NhanVien> showListNhanVien() {
        return nhanVienService.findAll();
    }

    @ModelAttribute("listKhachHang")
    public Iterable<KhachHang> showListKhachHang() {
        return khachHangService.findAll();
    }

    @ModelAttribute("listDichVu")
    public Iterable<DichVu> showListDichVu() {
        return dichVuService.findAll();
    }

    @GetMapping("/danh-sach")
    public ModelAndView xemDanhSachHopDong() {
        return new ModelAndView("/hop-dong/danh-sach", "listHopDong", hopDongService.findAll());
    }

    @GetMapping("/them")
    public ModelAndView showThemMoi() {
        return new ModelAndView("/hop-dong/them", "hopDong", new HopDong());
    }

    @PostMapping("/them")
    public String themMoiHopDong(
            @ModelAttribute HopDong hopDong,
            RedirectAttributes redirectAttributes,
            HttpServletRequest request,
            HttpServletResponse response
    ) {
        hopDongService.them(hopDong);
        System.out.println(hopDong.toString());

        Iterable<HopDong> listHopDong = hopDongService.findAllByKhachHang_IdKhachHang((long) 1);
        for(HopDong hd: listHopDong) {
            String cookieValue =
                    hd.getKhachHang().getIdKhachHang() + "_" +
                    hd.getDichVu().getIdDichVu() + "_" +
                    hd.getNgayBatDau() + "_" +
                    hd.getNgayKetThuc();

            Cookie cookie = new Cookie("hopDong " + hd.getIdHopDong(), cookieValue);
            cookie.setMaxAge(60*60);
            cookie.setPath("/lichSuGiaoDich");

            response.addCookie(cookie);
        }

        redirectAttributes.addFlashAttribute("message", "Tạo mới hợp đồng thành công !");
        return "redirect:/hop-dong/danh-sach";
    }

    @GetMapping("/sua")
    public ModelAndView suaHopDong(@RequestParam Long id) {
        return new ModelAndView("/hop-dong/sua", "hopDongSua", hopDongService.timTheoId(id));
    }

    @PostMapping("/sua")
    public String capNhatHopDong(@ModelAttribute HopDong hopDongDaCapNhat, RedirectAttributes redirectAttributes) {
        hopDongService.them(hopDongDaCapNhat);
        redirectAttributes.addFlashAttribute("message", "Cập nhật hợp đồng thành công !");
        return "redirect:/hop-dong/danh-sach";
    }

    @GetMapping("/xoa")
    public String xoaHopDong(@RequestParam Long id, RedirectAttributes redirectAttributes) {
        hopDongService.xoaTheoId(id);
        redirectAttributes.addFlashAttribute("message", "Xoá hợp đồng thành công !");
        return "redirect:/hop-dong/danh-sach";
    }
}
