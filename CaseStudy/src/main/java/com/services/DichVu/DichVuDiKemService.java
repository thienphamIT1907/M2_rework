package com.services.DichVu;

import com.models.DichVuModels.DichVuDiKem;

public interface DichVuDiKemService {

    Iterable<DichVuDiKem> findAll();

    void them(DichVuDiKem dichVuDiKem);

    DichVuDiKem timTheoId(Long id);

    void xoaTheoId(Long id);
}
