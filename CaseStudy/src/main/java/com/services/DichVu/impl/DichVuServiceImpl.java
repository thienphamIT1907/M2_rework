package com.services.DichVu.impl;

import com.models.DichVuModels.DichVu;
import com.repositories.DichVu.DichVuRepository;
import com.services.DichVu.DichVuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DichVuServiceImpl implements DichVuService {

    @Autowired
    DichVuRepository dichVuRepository;

    @Override
    public Iterable<DichVu> findAll() {
        return dichVuRepository.findAll();
    }

    @Override
    public Page<DichVu> findAllPaging(Pageable pageable) {
        return dichVuRepository.findAll(pageable);
    }

    @Override
    public void them(DichVu dichVu) {
        dichVuRepository.save(dichVu);
    }

    @Override
    public DichVu timTheoId(Long id) {
        return dichVuRepository.findById(id).orElse(null);
    }

    @Override
    public void xoaTheoId(Long id) {
        dichVuRepository.deleteById(id);
    }

    @Override
    public Page<DichVu> findAllByTenDichVuContaining(String tenDichVu, Pageable pageable) {
        return dichVuRepository.findAllByTenDichVuContaining(tenDichVu, pageable);
    }
}
