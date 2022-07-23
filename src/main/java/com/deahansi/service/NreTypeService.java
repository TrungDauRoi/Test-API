package com.deahansi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.deahansi.entity.NreType;
import com.deahansi.model.NreTypeModel;
import com.deahansi.repository.NreTypeRepository;

@Service
public class NreTypeService {

  @Autowired
  private NreTypeRepository repository;

  @Transactional(readOnly = true)
  public List<NreTypeModel> filter() {
    List<NreType> nreTypes = this.repository.findAll();
    List<NreTypeModel> nreTypeModels = new ArrayList<>();
    nreTypes.stream().forEach(entity -> {
      NreTypeModel model = new NreTypeModel();
      model.setId(entity.getId());
      model.setCode(entity.getCode());
      model.setName(entity.getName());
      model.setDescription(entity.getDescription());
      model.setOrderNo(entity.getOrderNo());
      nreTypeModels.add(model);
    });
    return nreTypeModels;
  }

  @Transactional
  public NreTypeModel add(NreTypeModel nreTypeModel) {
    NreType entity = new NreType();
    entity.setCode(nreTypeModel.getCode());
    entity.setName(nreTypeModel.getName());
    entity.setDescription(nreTypeModel.getDescription());
    entity.setOrderNo(nreTypeModel.getOrderNo());
    entity = this.repository.saveAndFlush(entity);
    return nreTypeModel;
  }

}
