package com.services.DichVu;

import com.models.DichVuModels.DichVu;

import java.util.List;

public interface DichVuService {

    List<DichVu> findAll();

    void them(DichVu dichVu);

    DichVu timTheoId(Long id);

    void xoaTheoId(Long id);
}
