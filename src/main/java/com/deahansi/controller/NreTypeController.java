package com.deahansi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deahansi.base.data.ResponseData;
import com.deahansi.base.data.ResponseUtils;
import com.deahansi.model.NreTypeModel;
import com.deahansi.service.NreTypeService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/nre-type")
public class NreTypeController {

  @Autowired
  private NreTypeService service;

  @ApiOperation("Lấy danh sách NRE")
  @GetMapping

  public ResponseEntity<ResponseData<List<NreTypeModel>>> filter() {
    return ResponseUtils.success(this.service.filter());
  }

  @ApiOperation("Thêm mới NRE")
  @PostMapping
  // @PreAuthorize
  public ResponseEntity<ResponseData<NreTypeModel>> adđ(
      @RequestBody NreTypeModel nreTypeModel) {
    return ResponseUtils.success(this.service.add(nreTypeModel));
  }
}
