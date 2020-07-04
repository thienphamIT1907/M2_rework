package com.services.DichVu.impl;

import com.models.DichVuModels.KieuThue;
import com.repositories.DichVu.KieuThueRepository;
import com.services.DichVu.KieuThueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KieuThueServiceImpl implements KieuThueService {

    @Autowired
    KieuThueRepository kieuThueRepository;

    @Override
    public Iterable<KieuThue> findAll() {
        return kieuThueRepository.findAll();
    }

    @Override
    public KieuThue timTheoId(Long id) {
        return kieuThueRepository.findById(id).orElse(null);
    }
}
