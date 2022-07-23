package com.deahansi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deahansi.base.data.ResponseData;
import com.deahansi.base.data.ResponseUtils;
import com.deahansi.entity.Province;
import com.deahansi.model.ProvinceModel;
import com.deahansi.service.ProvinceService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/province")
public class ProvinceController {

    @Autowired
    private ProvinceService service;

    @ApiOperation("Lấy danh sách Province")
    @GetMapping

    public ResponseEntity<ResponseData<List<ProvinceModel>>> filter() {
        return ResponseUtils.success(this.service.filter());
    }

    @ApiOperation("Thêm mới Province")
    @PostMapping
    // @PreAuthorize
    public ResponseEntity<ResponseData<ProvinceModel>> add(@RequestBody ProvinceModel provinceModel) {
        return ResponseUtils.success(this.service.add(provinceModel));
    }

    @ApiOperation("Sửa lại Province")
    @PutMapping
    public ResponseEntity<ResponseData<ProvinceModel>> edit(@RequestBody ProvinceModel provinceModel,
            @PathVariable String id) {
        Province province = new Province();
        province.setCode(provinceModel.getCode());
        province.setId(provinceModel.getId());
        province.setName(provinceModel.getName());
        province.setOrderNo(provinceModel.getOrderNo());
        service.repository.findById(id).map(province1 -> {
            province1 = province;
            return service.repository.saveAndFlush(province1);
        }).orElseGet(() -> {
            return service.repository.saveAndFlush(province);
        });
        return null;
    }

    @ApiOperation("Xóa đi Province")
    @DeleteMapping
    public ResponseEntity<ResponseData<ProvinceModel>> delete(@PathVariable String id) {
        if (service.repository.findById(id).isPresent()) {
            service.repository.deleteById(id);
        }
        return null;
    }
}
