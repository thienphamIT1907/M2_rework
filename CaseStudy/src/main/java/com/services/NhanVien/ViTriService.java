package com.services.NhanVien;


import com.models.NhanVienModels.ViTri;

import java.util.List;

public interface ViTriService {

    List<ViTri> findAll();

    void them(ViTri viTri);

    ViTri timTheoId(Long id);

    void xoaTheoId(Long id);
}
