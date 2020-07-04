package com.services.DichVu;

import com.models.DichVuModels.DichVu;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface DichVuService {

    Iterable<DichVu> findAll();

    Page<DichVu> findAllPaging(Pageable pageable);

    void them(DichVu dichVu);

    DichVu timTheoId(Long id);

    void xoaTheoId(Long id);

    Page<DichVu> findAllByTenDichVuContaining(String tenDichVu, Pageable pageable);
}
