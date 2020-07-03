package com.models.DichVuModels;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class KieuThue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idKieuThue;

    @Column
    private String tenKieuThue;

    @OneToMany(targetEntity = DichVu.class, mappedBy = "kieuThue")
    private List<DichVu> listDichVu;

    public KieuThue() {
    }

    public KieuThue(Long idKieuThue, String tenKieuThue, List<DichVu> listDichVu) {
        this.idKieuThue = idKieuThue;
        this.tenKieuThue = tenKieuThue;
        this.listDichVu = listDichVu;
    }

    public Long getIdKieuThue() {
        return idKieuThue;
    }

    public void setIdKieuThue(Long idKieuThue) {
        this.idKieuThue = idKieuThue;
    }

    public String getTenKieuThue() {
        return tenKieuThue;
    }

    public void setTenKieuThue(String tenKieuThue) {
        this.tenKieuThue = tenKieuThue;
    }

    public List<DichVu> getListDichVu() {
        return listDichVu;
    }

    public void setListDichVu(List<DichVu> listDichVu) {
        this.listDichVu = listDichVu;
    }
}
