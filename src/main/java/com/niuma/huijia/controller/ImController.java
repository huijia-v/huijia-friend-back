package com.niuma.huijia.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.niuma.huijia.common.BaseResponse;
import com.niuma.huijia.common.ResultUtils;
import com.niuma.huijia.model.domain.Im;
import com.niuma.huijia.service.ImService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
* <p>
*  前端控制器
* </p>
* @since 2023-02-09
*/
@RestController
@RequestMapping("/im")
@CrossOrigin(origins = {"http://bytes-stream.net/"}, allowCredentials = "true")
public class ImController {

    @Resource
    private ImService imService;

    @PostMapping
    public BaseResponse<Boolean> save(@RequestBody Im im) {
        imService.save(im);
        return ResultUtils.success(true);
    }
//
    @PutMapping
    public BaseResponse<Boolean> update(@RequestBody Im im) {
        imService.updateById(im);
        return ResultUtils.success(true);

    }
//
    @DeleteMapping("/{id}")
    public BaseResponse<Boolean> delete(@PathVariable Integer id) {
        imService.removeById(id);
        return ResultUtils.success(true);

    }
//
    @PostMapping("/del/batch")
    public BaseResponse<Boolean> deleteBatch(@RequestBody List<Integer> ids) {
        imService.removeByIds(ids);
        return ResultUtils.success(true);

    }
//
    @GetMapping
    public BaseResponse<List<Im>> findAll() {
        return ResultUtils.success(imService.list());

    }

    @GetMapping("/init/{limit}")
    public BaseResponse<List<Im>> findAllInit(@PathVariable Integer limit) {
        List<Im> ims = imService.list(new QueryWrapper<Im>().orderByDesc("id").last("limit " + limit));
        return ResultUtils.success(ims.stream().sorted(Comparator.comparing(Im::getId)).collect(Collectors.toList()));

    }

    @GetMapping("/{id}")
    public BaseResponse<Im> findOne(@PathVariable Integer id) {
        return ResultUtils.success(imService.getById(id));

    }
//
    @GetMapping("/page")
    public BaseResponse<Page<Im>> findPage(@RequestParam(defaultValue = "") String username,
                           @RequestParam Integer pageNum,
                           @RequestParam Integer pageSize) {
        QueryWrapper<Im> queryWrapper = new QueryWrapper<Im>().orderByDesc("id");
        queryWrapper.like(!"".equals(username), "username", username);
        return ResultUtils.success(imService.page(new Page<>(pageNum, pageSize), queryWrapper));

    }


}
