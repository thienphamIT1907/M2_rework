package com.services.NhanVien;


import com.models.NhanVienModels.TrinhDo;

import java.util.List;

public interface TrinhDoService {

    Iterable<TrinhDo> findAll();

    void them(TrinhDo trinhDo);

    TrinhDo timTheoId(Long id);

    void xoaTheoId(Long id);
}
