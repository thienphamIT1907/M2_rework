package com.models.DichVuModels;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class DichVuDiKem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDichVuDiKem;

    @OneToMany(targetEntity = HopDongChiTiet.class, mappedBy = "dichVuDiKem")
    private List<HopDongChiTiet> listHopDongChiTiet;

    @Column
    private String tenDichVuDiKem;

    @Column
    private Long donVi;

    @Column
    private Long gia;

    public DichVuDiKem() {
    }

    public DichVuDiKem(String tenDichVuDiKem, Long donVi, Long gia) {
        this.tenDichVuDiKem = tenDichVuDiKem;
        this.donVi = donVi;
        this.gia = gia;
    }

    public Long getIdDichVuDiKem() {
        return idDichVuDiKem;
    }

    public void setIdDichVuDiKem(Long idDichVuDiKem) {
        this.idDichVuDiKem = idDichVuDiKem;
    }

    public String getTenDichVuDiKem() {
        return tenDichVuDiKem;
    }

    public void setTenDichVuDiKem(String tenDichVuDiKem) {
        this.tenDichVuDiKem = tenDichVuDiKem;
    }

    public Long getDonVi() {
        return donVi;
    }

    public void setDonVi(Long donVi) {
        this.donVi = donVi;
    }

    public Long getGia() {
        return gia;
    }

    public void setGia(Long gia) {
        this.gia = gia;
    }

    public List<HopDongChiTiet> getListHopDongChiTiet() {
        return listHopDongChiTiet;
    }

    public void setListHopDongChiTiet(List<HopDongChiTiet> listHopDongChiTiet) {
        this.listHopDongChiTiet = listHopDongChiTiet;
    }
}
