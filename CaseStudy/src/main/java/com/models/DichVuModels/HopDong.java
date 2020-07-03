package com.models.DichVuModels;

import com.models.KhachHangModels.KhachHang;
import com.models.NhanVienModels.NhanVien;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table
public class HopDong {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idHopDong;

    @ManyToOne
    @JoinColumn(name = "id_nhan_vien")
    private NhanVien nhanVien;

    @ManyToOne
    @JoinColumn(name = "id_khach_hang")
    private KhachHang khachHang;

    @ManyToOne
    @JoinColumn(name = "id_dich_vu")
    private DichVu dichVu;

    @OneToMany(targetEntity = HopDongChiTiet.class, mappedBy = "hopDong")
    private List<HopDongChiTiet> listHopDongChiTiet;

    @Column
    private LocalDate ngayBatDau;

    @Column
    private LocalDate ngayKetThuc;

    @Column
    private Long tienCoc;

    @Column
    private Long tongThanhToan;

    public HopDong() {
    }

    public HopDong(Long idHopDong, NhanVien nhanVien, KhachHang khachHang, DichVu dichVu, List<HopDongChiTiet> listHopDongChiTiet, LocalDate ngayBatDau, LocalDate ngayKetThuc, Long tienCoc, Long tongThanhToan) {
        this.idHopDong = idHopDong;
        this.nhanVien = nhanVien;
        this.khachHang = khachHang;
        this.dichVu = dichVu;
        this.listHopDongChiTiet = listHopDongChiTiet;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
        this.tienCoc = tienCoc;
        this.tongThanhToan = tongThanhToan;
    }

    public Long getIdHopDong() {
        return idHopDong;
    }

    public void setIdHopDong(Long idHopDong) {
        this.idHopDong = idHopDong;
    }

    public NhanVien getNhanVien() {
        return nhanVien;
    }

    public void setNhanVien(NhanVien nhanVien) {
        this.nhanVien = nhanVien;
    }

    public KhachHang getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(KhachHang khachHang) {
        this.khachHang = khachHang;
    }

    public DichVu getDichVu() {
        return dichVu;
    }

    public void setDichVu(DichVu dichVu) {
        this.dichVu = dichVu;
    }

    public List<HopDongChiTiet> getListHopDongChiTiet() {
        return listHopDongChiTiet;
    }

    public void setListHopDongChiTiet(List<HopDongChiTiet> listHopDongChiTiet) {
        this.listHopDongChiTiet = listHopDongChiTiet;
    }

    public LocalDate getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(LocalDate ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public LocalDate getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(LocalDate ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }

    public Long getTienCoc() {
        return tienCoc;
    }

    public void setTienCoc(Long tienCoc) {
        this.tienCoc = tienCoc;
    }

    public Long getTongThanhToan() {
        return tongThanhToan;
    }

    public void setTongThanhToan(Long tongThanhToan) {
        this.tongThanhToan = tongThanhToan;
    }
}
