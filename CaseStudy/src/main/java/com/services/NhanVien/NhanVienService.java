package com.services.NhanVien;


import com.models.NhanVienModels.NhanVien;

import java.util.List;

public interface NhanVienService {

    List<NhanVien> findAll();

    void them(NhanVien nhanVien);

    NhanVien timTheoId(Long id);

    void xoaTheoId(Long id);
}
