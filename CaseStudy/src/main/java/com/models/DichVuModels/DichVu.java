package com.models.DichVuModels;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class DichVu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDichVu;

    @ManyToOne
    @JoinColumn(name = "id_loai_dich_vu")
    private LoaiDichVu loaiDichVu;

    @ManyToOne
    @JoinColumn(name = "id_kieu_thue")
    private KieuThue kieuThue;

    @OneToMany(targetEntity = HopDong.class, mappedBy = "dichVu")
    private List<HopDong> listHopDong;

    @Column
    private String tenDichVu;

    @Column
    private Long dienTichSuDung;

    @Column
    private Long chiPhiThue;

    @Column
    private Long soNguoiToiDa;

    @Column
    private String tieuChuanPhong;

    @Column
    private String moTaTienNghiKhac;

    @Column
    private Long dienTichHoBoi;

    @Column
    private Long soTang;

    @Column
    private boolean trangThai;

    public DichVu() {
    }

    public DichVu(String tenDichVu, Long dienTichSuDung, Long chiPhiThue, Long soNguoiToiDa, String tieuChuanPhong, String moTaTienNghiKhac, Long dienTichHoBoi, Long soTang, boolean trangThai) {
        this.tenDichVu = tenDichVu;
        this.dienTichSuDung = dienTichSuDung;
        this.chiPhiThue = chiPhiThue;
        this.soNguoiToiDa = soNguoiToiDa;
        this.tieuChuanPhong = tieuChuanPhong;
        this.moTaTienNghiKhac = moTaTienNghiKhac;
        this.dienTichHoBoi = dienTichHoBoi;
        this.soTang = soTang;
        this.trangThai = trangThai;
    }

    public Long getIdDichVu() {
        return idDichVu;
    }

    public void setIdDichVu(Long idDichVu) {
        this.idDichVu = idDichVu;
    }

    public LoaiDichVu getLoaiDichVu() {
        return loaiDichVu;
    }

    public void setLoaiDichVu(LoaiDichVu loaiDichVu) {
        this.loaiDichVu = loaiDichVu;
    }

    public KieuThue getKieuThue() {
        return kieuThue;
    }

    public void setKieuThue(KieuThue kieuThue) {
        this.kieuThue = kieuThue;
    }

    public List<HopDong> getListHopDong() {
        return listHopDong;
    }

    public void setListHopDong(List<HopDong> listHopDong) {
        this.listHopDong = listHopDong;
    }

    public String getTenDichVu() {
        return tenDichVu;
    }

    public void setTenDichVu(String tenDichVu) {
        this.tenDichVu = tenDichVu;
    }

    public Long getDienTichSuDung() {
        return dienTichSuDung;
    }

    public void setDienTichSuDung(Long dienTichSuDung) {
        this.dienTichSuDung = dienTichSuDung;
    }

    public Long getChiPhiThue() {
        return chiPhiThue;
    }

    public void setChiPhiThue(Long chiPhiThue) {
        this.chiPhiThue = chiPhiThue;
    }

    public Long getSoNguoiToiDa() {
        return soNguoiToiDa;
    }

    public void setSoNguoiToiDa(Long soNguoiToiDa) {
        this.soNguoiToiDa = soNguoiToiDa;
    }

    public String getTieuChuanPhong() {
        return tieuChuanPhong;
    }

    public void setTieuChuanPhong(String tieuChuanPhong) {
        this.tieuChuanPhong = tieuChuanPhong;
    }

    public String getMoTaTienNghiKhac() {
        return moTaTienNghiKhac;
    }

    public void setMoTaTienNghiKhac(String moTaTienNghiKhac) {
        this.moTaTienNghiKhac = moTaTienNghiKhac;
    }

    public Long getDienTichHoBoi() {
        return dienTichHoBoi;
    }

    public void setDienTichHoBoi(Long dienTichHoBoi) {
        this.dienTichHoBoi = dienTichHoBoi;
    }

    public Long getSoTang() {
        return soTang;
    }

    public void setSoTang(Long soTang) {
        this.soTang = soTang;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }
}


