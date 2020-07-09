package com.repositories.DichVu;

import com.models.DichVuModels.HopDong;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface HopDongRepository extends PagingAndSortingRepository<HopDong, Long> {

    Iterable<HopDong> findAllByKhachHang_IdKhachHang(Long id);
}
