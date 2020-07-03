package com.models.NhanVienModels;


import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class ViTri {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idViTri;

    @Column
    private String tenViTri;

    @OneToMany(targetEntity = NhanVien.class, mappedBy = "viTri", cascade = CascadeType.ALL)
    private List<NhanVien> listNhanVien;

    public ViTri() {
    }

    public ViTri(Long idViTri, String tenViTri, List<NhanVien> listNhanVien) {
        this.idViTri = idViTri;
        this.tenViTri = tenViTri;
        this.listNhanVien = listNhanVien;
    }

    public Long getIdViTri() {
        return idViTri;
    }

    public void setIdViTri(Long idViTri) {
        this.idViTri = idViTri;
    }

    public String getTenViTri() {
        return tenViTri;
    }

    public void setTenViTri(String tenViTri) {
        this.tenViTri = tenViTri;
    }

    public List<NhanVien> getListNhanVien() {
        return listNhanVien;
    }

    public void setListNhanVien(List<NhanVien> listNhanVien) {
        this.listNhanVien = listNhanVien;
    }
}
