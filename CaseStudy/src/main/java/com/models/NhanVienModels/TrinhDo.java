package com.models.NhanVienModels;


import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class TrinhDo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTrinhDo;

    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String tenTrinhDo;

    @OneToMany(targetEntity = NhanVien.class, mappedBy = "trinhDo", cascade = CascadeType.ALL)
    private List<NhanVien> listNhanVien;

    public TrinhDo() {
    }

    public TrinhDo(Long idTrinhDo, String tenTrinhDo, List<NhanVien> listNhanVien) {
        this.idTrinhDo = idTrinhDo;
        this.tenTrinhDo = tenTrinhDo;
        this.listNhanVien = listNhanVien;
    }

    public Long getIdTrinhDo() {
        return idTrinhDo;
    }

    public void setIdTrinhDo(Long idTrinhDo) {
        this.idTrinhDo = idTrinhDo;
    }

    public String getTenTrinhDo() {
        return tenTrinhDo;
    }

    public void setTenTrinhDo(String tenTrinhDo) {
        this.tenTrinhDo = tenTrinhDo;
    }

    public List<NhanVien> getListNhanVien() {
        return listNhanVien;
    }

    public void setListNhanVien(List<NhanVien> listNhanVien) {
        this.listNhanVien = listNhanVien;
    }
}
