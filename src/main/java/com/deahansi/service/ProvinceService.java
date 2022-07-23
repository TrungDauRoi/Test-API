package com.deahansi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.deahansi.entity.Province;
import com.deahansi.model.ProvinceModel;
import com.deahansi.repository.ProvinceRepository;

@Service
public class ProvinceService {

    @Autowired
    public ProvinceRepository repository;

    @Transactional(readOnly = true)
    public List<ProvinceModel> filter() {
        List<Province> provinceTypes = this.repository.findAll();
        List<ProvinceModel> provinceModels = new ArrayList<>();
        provinceTypes.stream().forEach(entity -> {
            ProvinceModel model = new ProvinceModel();
            model.setId(entity.getId());
            model.setCode(entity.getCode());
            model.setName(entity.getName());
            model.setOrderNo(entity.getOrderNo());
            provinceModels.add(model);
        });
        return provinceModels;
    }

    @Transactional
    public ProvinceModel add(ProvinceModel provinceModel) {
        Province entity = new Province();
        entity.setCode(provinceModel.getCode());
        entity.setName(provinceModel.getName());
        entity.setOrderNo(provinceModel.getOrderNo());
        entity = this.repository.saveAndFlush(entity);
        return provinceModel;
    }
}
