package com.services.DichVu.impl;

import com.models.DichVuModels.LoaiDichVu;
import com.repositories.DichVu.LoaiDichVuRepository;
import com.services.DichVu.LoaiDichVuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoaiDichVuServiceImpl implements LoaiDichVuService {

    @Autowired
    LoaiDichVuRepository loaiDichVuRepository;

    @Override
    public Iterable<LoaiDichVu> findAll() {
        return loaiDichVuRepository.findAll();
    }

    @Override
    public LoaiDichVu timTheoId(Long id) {
        return loaiDichVuRepository.findById(id).orElse(null);
    }
}
