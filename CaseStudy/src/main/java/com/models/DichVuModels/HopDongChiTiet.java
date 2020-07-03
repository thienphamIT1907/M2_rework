package com.models.DichVuModels;

import javax.persistence.*;

@Entity
@Table
public class HopDongChiTiet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idHopDongChiTiet;

    @ManyToOne
    @JoinColumn(name = "id_hop_dong")
    private HopDong hopDong;

    @ManyToOne
    @JoinColumn(name="id_dich_vu_di_kem")
    private DichVuDiKem dichVuDiKem;

    public HopDongChiTiet() {
    }

    public HopDongChiTiet(Long idHopDongChiTiet, HopDong hopDong, DichVuDiKem dichVuDiKem) {
        this.idHopDongChiTiet = idHopDongChiTiet;
        this.hopDong = hopDong;
        this.dichVuDiKem = dichVuDiKem;
    }

    public Long getIdHopDongChiTiet() {
        return idHopDongChiTiet;
    }

    public void setIdHopDongChiTiet(Long idHopDongChiTiet) {
        this.idHopDongChiTiet = idHopDongChiTiet;
    }

    public HopDong getHopDong() {
        return hopDong;
    }

    public void setHopDong(HopDong hopDong) {
        this.hopDong = hopDong;
    }

    public DichVuDiKem getDichVuDiKem() {
        return dichVuDiKem;
    }

    public void setDichVuDiKem(DichVuDiKem dichVuDiKem) {
        this.dichVuDiKem = dichVuDiKem;
    }
}
