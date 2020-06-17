package com.qlkh_qlt.service.province;


import com.qlkh_qlt.models.Province;

public interface ProvinceService {

    Iterable<Province> findAll();

    Province findById(Long id);

    void save(Province province);

    void remove(Long id);
}
