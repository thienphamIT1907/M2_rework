package com.services.DichVu;

import com.models.DichVuModels.LoaiDichVu;

public interface LoaiDichVuService {

    Iterable<LoaiDichVu> findAll();

    LoaiDichVu timTheoId(Long id);
}
