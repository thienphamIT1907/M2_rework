package com.services.DichVu;

import com.models.DichVuModels.KieuThue;

public interface KieuThueService {

    Iterable<KieuThue> findAll();

    KieuThue timTheoId(Long id);
}
