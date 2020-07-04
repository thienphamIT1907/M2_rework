package com.models.NhanVienModels;

import com.models.DichVuModels.HopDong;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table
public class NhanVien {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idNhanVien;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_trinh_do")
    private TrinhDo trinhDo;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_vi_tri")
    private ViTri viTri;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_bo_phan")
    private BoPhan boPhan;

    @OneToMany(targetEntity = HopDong.class, mappedBy = "nhanVien", cascade = CascadeType.ALL)
    private List<HopDong> listHopDong;

    @Column
    private String hoTen;

    @Column
    private LocalDate ngaySinh;

    @Column
    private String soCMND;

    @Column
    private String soDienThoai;

    @Column
    private String email;

    @NotNull(message = "Không được để trống")
    @Min(value = 0, message = "Lương > 0")
    @Column
    private Long luong;

    public NhanVien() {
    }

    public NhanVien(Long idNhanVien, TrinhDo trinhDo, ViTri viTri, BoPhan boPhan, List<HopDong> listHopDong, String hoTen, LocalDate ngaySinh, String soCMND, String soDienThoai, String email, Long luong) {
        this.idNhanVien = idNhanVien;
        this.trinhDo = trinhDo;
        this.viTri = viTri;
        this.boPhan = boPhan;
        this.listHopDong = listHopDong;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.soCMND = soCMND;
        this.soDienThoai = soDienThoai;
        this.email = email;
        this.luong = luong;
    }

    public Long getIdNhanVien() {
        return idNhanVien;
    }

    public void setIdNhanVien(Long idNhanVien) {
        this.idNhanVien = idNhanVien;
    }

    public TrinhDo getTrinhDo() {
        return trinhDo;
    }

    public void setTrinhDo(TrinhDo trinhDo) {
        this.trinhDo = trinhDo;
    }

    public ViTri getViTri() {
        return viTri;
    }

    public void setViTri(ViTri viTri) {
        this.viTri = viTri;
    }

    public BoPhan getBoPhan() {
        return boPhan;
    }

    public void setBoPhan(BoPhan boPhan) {
        this.boPhan = boPhan;
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

    public String getSoCMND() {
        return soCMND;
    }

    public void setSoCMND(String soCMND) {
        this.soCMND = soCMND;
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

    public Long getLuong() {
        return luong;
    }

    public void setLuong(Long luong) {
        this.luong = luong;
    }
}
