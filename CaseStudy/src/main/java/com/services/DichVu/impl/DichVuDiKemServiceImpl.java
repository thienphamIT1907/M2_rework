package com.services.DichVu.impl;

import com.models.DichVuModels.DichVuDiKem;
import com.repositories.DichVu.DichVuDiKemRepository;
import com.services.DichVu.DichVuDiKemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DichVuDiKemServiceImpl implements DichVuDiKemService {

    @Autowired
    DichVuDiKemRepository dichVuDiKemRepository;

    @Override
    public Iterable<DichVuDiKem> findAll() {
        return dichVuDiKemRepository.findAll();
    }

    @Override
    public void them(DichVuDiKem dichVuDiKem) {
        dichVuDiKemRepository.save(dichVuDiKem);
    }

    @Override
    public DichVuDiKem timTheoId(Long id) {
        return dichVuDiKemRepository.findById(id).orElse(null);
    }

    @Override
    public void xoaTheoId(Long id) {
        dichVuDiKemRepository.deleteById(id);
    }
}
