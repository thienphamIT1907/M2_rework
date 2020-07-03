package com.models.DichVuModels;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "loai_dich_vu")
public class LoaiDichVu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_loai_dich_vu")
    private Long idLoaiDichVu;

    @Column(name = "ten_loai_dich_vu")
    private String tenLoaiDichVu;

    @OneToMany(targetEntity = DichVu.class, mappedBy = "loaiDichVu")
    private List<DichVu> DichVu;

    public LoaiDichVu() {
    }

    public LoaiDichVu(Long idLoaiDichVu, String tenLoaiDichVu, List<com.models.DichVuModels.DichVu> dichVu) {
        this.idLoaiDichVu = idLoaiDichVu;
        this.tenLoaiDichVu = tenLoaiDichVu;
        DichVu = dichVu;
    }

    public Long getIdLoaiDichVu() {
        return idLoaiDichVu;
    }

    public void setIdLoaiDichVu(Long idLoaiDichVu) {
        this.idLoaiDichVu = idLoaiDichVu;
    }

    public String getTenLoaiDichVu() {
        return tenLoaiDichVu;
    }

    public void setTenLoaiDichVu(String tenLoaiDichVu) {
        this.tenLoaiDichVu = tenLoaiDichVu;
    }

    public List<com.models.DichVuModels.DichVu> getDichVu() {
        return DichVu;
    }

    public void setDichVu(List<com.models.DichVuModels.DichVu> dichVu) {
        DichVu = dichVu;
    }
}
