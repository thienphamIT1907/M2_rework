package com.models.KhachHangModels;

import com.models.DichVuModels.HopDong;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class KhachHang implements Validator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idKhachHang;

    @ManyToOne
    @JoinColumn(name = "id_loai_khach_hang")
    private LoaiKhachHang loaiKhachHang;

    @OneToMany(targetEntity = HopDong.class, mappedBy = "khachHang")
    private List<HopDong> listHopDong;

    @NotEmpty(message = "Không để trống !")
    @Column
    private String hoTen;

    @NotEmpty(message = "Không để trống !")
    @Column
    String ngaySinh;

    @NotEmpty(message = "Không để trống !")
    @Column
    private String gioiTinh;

    @NotEmpty(message = "Không để trống !")
    @Pattern(regexp = "^((\\d{9})|(\\d{12}))$", message = "9 hoặc 12 số!")
    @Column
    private String soCmnd;

    @NotEmpty(message = "Không để trống !")
    @Pattern(regexp = "^(0|\\(84\\)\\+)9(0|1)\\d{7}", message = "[090/091/(84)+90/(84)+91] xxxxxxx")
    @Column
    private String soDienThoai;

    @NotEmpty(message = "Không để trống !")
    @Pattern(regexp = "^[a-zA-Z0-9]+@[a-z]+.com$", message = "Email sai định dạng!")
    @Column
    private String email;

    @NotEmpty(message = "Không để trống !")
    @Column
    private String diaChi;

    @NotEmpty(message = "Không để trống !")
    @Pattern(regexp = "^KH-\\d{4}$", message = "Định dạng KH-XXXX!")
    @Column
    private String maKhachHang;

//    public KhachHang() {
//    }
//
//    public KhachHang(String hoTen, String ngaySinh, String gioiTinh, String soCmnd, String soDienThoai,
//                     String email, String diaChi, String maKhachHang) {
//        this.hoTen = hoTen;
//        this.ngaySinh = ngaySinh;
//        this.gioiTinh = gioiTinh;
//        this.soCmnd = soCmnd;
//        this.soDienThoai = soDienThoai;
//        this.email = email;
//        this.diaChi = diaChi;
//        this.maKhachHang = maKhachHang;
//    }

//    public Long getIdKhachHang() {
//        return idKhachHang;
//    }
//
//    public void setIdKhachHang(Long idKhachHang) {
//        this.idKhachHang = idKhachHang;
//    }
//
//    public LoaiKhachHang getLoaiKhachHang() {
//        return loaiKhachHang;
//    }
//
//    public void setLoaiKhachHang(LoaiKhachHang loaiKhachHang) {
//        this.loaiKhachHang = loaiKhachHang;
//    }
//
//    public List<HopDong> getListHopDong() {
//        return listHopDong;
//    }
//
//    public void setListHopDong(List<HopDong> listHopDong) {
//        this.listHopDong = listHopDong;
//    }
//
//    public String getHoTen() {
//        return hoTen;
//    }
//
//    public void setHoTen(String hoTen) {
//        this.hoTen = hoTen;
//    }
//
//    public String getNgaySinh() {
//        return ngaySinh;
//    }
//
//    public void setNgaySinh(String ngaySinh) {
//        this.ngaySinh = ngaySinh;
//    }
//
//    public String getGioiTinh() {
//        return gioiTinh;
//    }
//
//    public void setGioiTinh(String gioiTinh) {
//        this.gioiTinh = gioiTinh;
//    }
//
//    public String getSoCmnd() {
//        return soCmnd;
//    }
//
//    public void setSoCmnd(String soCmnd) {
//        this.soCmnd = soCmnd;
//    }
//
//    public String getSoDienThoai() {
//        return soDienThoai;
//    }
//
//    public void setSoDienThoai(String soDienThoai) {
//        this.soDienThoai = soDienThoai;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getDiaChi() {
//        return diaChi;
//    }
//
//    public void setDiaChi(String diaChi) {
//        this.diaChi = diaChi;
//    }
//
//    public String getMaKhachHang() {
//        return maKhachHang;
//    }
//
//    public void setMaKhachHang(String maKhachHang) {
//        this.maKhachHang = maKhachHang;
//    }

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

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

        KhachHang khachHang = (KhachHang) target;

        //regex valid date : ^((0)[1-9]|[1-2][0-9]|(3)[0-1])(\/)((0)[1-9]|((1)[0-2]))(\/)\d{4}$
        String ngaySinh = khachHang.getNgaySinh();

        if (!ngaySinh.isEmpty()) {
            if(!ngaySinh.matches("^\\d{4}-\\d{2}-\\d{2}$")){ // => ("yyyy-MM-dd")
                errors.rejectValue("birthday", "birthday.format");
            } else {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd"); //pattern to save DB
                try {
                    simpleDateFormat.parse(ngaySinh);
                } catch (ParseException e) {
                    errors.rejectValue("birthday", "birthday.format");
                }
            }
        }
    }
}
