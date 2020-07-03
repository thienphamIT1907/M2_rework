package com.models.KhachHangModels;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class LoaiKhachHang {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLoaiKhachHang;

    @OneToMany(targetEntity = KhachHang.class, mappedBy = "loaiKhachHang")
    private List<KhachHang> listKhachHang;

    @Column
    private String tenLoaiKhachHang;

    public LoaiKhachHang() {
    }

    public LoaiKhachHang(String tenLoaiKhachHang) {
        this.tenLoaiKhachHang = tenLoaiKhachHang;
    }

    public Long getIdLoaiKhachHang() {
        return idLoaiKhachHang;
    }

    public void setIdLoaiKhachHang(Long idLoaiKhachHang) {
        this.idLoaiKhachHang = idLoaiKhachHang;
    }

    public List<KhachHang> getListKhachHang() {
        return listKhachHang;
    }

    public void setListKhachHang(List<KhachHang> listKhachHang) {
        this.listKhachHang = listKhachHang;
    }

    public String getTenLoaiKhachHang() {
        return tenLoaiKhachHang;
    }

    public void setTenLoaiKhachHang(String tenLoaiKhachHang) {
        this.tenLoaiKhachHang = tenLoaiKhachHang;
    }
}
