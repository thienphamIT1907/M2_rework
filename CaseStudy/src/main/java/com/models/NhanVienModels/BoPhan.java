package com.models.NhanVienModels;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class BoPhan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBoPhan;

    @Column
    private String tenBoPhan;

    @OneToMany(targetEntity = NhanVien.class, mappedBy = "boPhan", cascade = CascadeType.ALL)
    private List<NhanVien> listNhanVien;

    public BoPhan() {
    }

    public BoPhan(Long idBoPhan, String tenBoPhan, List<NhanVien> listNhanVien) {
        this.idBoPhan = idBoPhan;
        this.tenBoPhan = tenBoPhan;
        this.listNhanVien = listNhanVien;
    }

    public Long getIdBoPhan() {
        return idBoPhan;
    }

    public void setIdBoPhan(Long idBoPhan) {
        this.idBoPhan = idBoPhan;
    }

    public String getTenBoPhan() {
        return tenBoPhan;
    }

    public void setTenBoPhan(String tenBoPhan) {
        this.tenBoPhan = tenBoPhan;
    }

    public List<NhanVien> getListNhanVien() {
        return listNhanVien;
    }

    public void setListNhanVien(List<NhanVien> listNhanVien) {
        this.listNhanVien = listNhanVien;
    }
}
