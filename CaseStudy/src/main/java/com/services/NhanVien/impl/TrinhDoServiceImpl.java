package com.services.NhanVien.impl;

import com.models.NhanVienModels.TrinhDo;
import com.repositories.NhanVien.TrinhDoRepository;
import com.services.NhanVien.TrinhDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrinhDoServiceImpl implements TrinhDoService {

    @Autowired
    TrinhDoRepository trinhDoRepository;


    @Override
    public Iterable<TrinhDo> findAll() {
        return trinhDoRepository.findAll();
    }

    @Override
    public void them(TrinhDo trinhDo) {
        trinhDoRepository.save(trinhDo);
    }

    @Override
    public TrinhDo timTheoId(Long id) {
        return trinhDoRepository.findById(id).orElse(null);
    }

    @Override
    public void xoaTheoId(Long id) {
        trinhDoRepository.deleteById(id);
    }
}
