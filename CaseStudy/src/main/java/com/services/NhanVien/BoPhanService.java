package com.services.NhanVien;


import com.models.NhanVienModels.BoPhan;

import java.util.List;

public interface BoPhanService {

    Iterable<BoPhan> findAll();

    void them(BoPhan boPhan);

    BoPhan timTheoId(Long id);

    void xoaTheoId(Long id);
}
