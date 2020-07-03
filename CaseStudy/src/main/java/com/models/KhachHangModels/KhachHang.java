package com.models.KhachHangModels;

import com.models.DichVuModels.HopDong;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table
public class KhachHang {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idKhachHang;

    @ManyToOne
    @JoinColumn(name = "id_loai_khach_hang")
    private LoaiKhachHang loaiKhachHang;

    @OneToMany(targetEntity = HopDong.class, mappedBy = "khachHang")
    private List<HopDong> listHopDong;

    @Column
    private String hoTen;

    @Column
    LocalDate ngaySinh;

    @Column
    private String gioiTinh;

    @Column
    private String soCmnd;

    @Column
    private String soDienThoai;

    @Column
    private String email;

    @Column
    private String diaChi;

    public KhachHang() {
    }

    public KhachHang(String hoTen, LocalDate ngaySinh, String gioiTinh, String soCmnd, String soDienThoai, String email, String diaChi) {
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.soCmnd = soCmnd;
        this.soDienThoai = soDienThoai;
        this.email = email;
        this.diaChi = diaChi;
    }

    public Long getIdKhachHang() {
        return idKhachHang;
    }

    public void setIdKhachHang(Long idKhachHang) {
        this.idKhachHang = idKhachHang;
    }

    public LoaiKhachHang getLoaiKhachHang() {
        return loaiKhachHang;
    }

    public void setLoaiKhachHang(LoaiKhachHang loaiKhachHang) {
        this.loaiKhachHang = loaiKhachHang;
    }

    public List<HopDong> getListHopDong() {
        return listHopDong;
    }

    public void setListHopDong(List<HopDong> listHopDong) {
        this.listHopDong = listHopDong;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public LocalDate getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(LocalDate ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getSoCmnd() {
        return soCmnd;
    }

    public void setSoCmnd(String soCmnd) {
        this.soCmnd = soCmnd;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    @Override
    public String toString() {
        return "KhachHang{" +
                "idKhachHang=" + idKhachHang +
                ", loaiKhachHang=" + loaiKhachHang +
                ", listHopDong=" + listHopDong +
                ", hoTen='" + hoTen + '\'' +
                ", ngaySinh=" + ngaySinh +
                ", gioiTinh='" + gioiTinh + '\'' +
                ", soCmnd='" + soCmnd + '\'' +
                ", soDienThoai='" + soDienThoai + '\'' +
                ", email='" + email + '\'' +
                ", diaChi='" + diaChi + '\'' +
                '}';
    }
}
