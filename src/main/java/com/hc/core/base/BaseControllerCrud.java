package com.hc.core.base;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.hc.core.model.StatusModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

public class BaseControllerCrud<K extends Serializable, T> extends BaseController<T> {
    private static Logger logger = LoggerFactory.getLogger(BaseControllerCrud.class);

    @Resource
    private IService<T> baseService;

    protected BaseControllerCrud() {
    }

    @GetMapping("index")
    public String indexPage(){
        return viewName("index");
    }

    @GetMapping("insert")
    public String insertPage(){
        return viewName("insert");
    }

    @PostMapping("list")
    @ResponseBody
    public Page<T> list(){
        return baseService.selectPage(new Page<>(), new EntityWrapper<>());
    }

    @PostMapping("insert")
    @ResponseBody
    public StatusModel insert(@RequestBody T t){
        boolean flag = false;
        try {
            flag = baseService.insert(t);
        } catch (DataAccessException e) {
            logger.error(e.getMessage(), e);
        }
        return flag ? new StatusModel(true,"保存成功") : new StatusModel(false,"保存失败");
    }

    @PostMapping("insertBatch")
    @ResponseBody
    public StatusModel insertBatch(@RequestBody List<T> list){
        boolean flag = false;
        try {
            flag = baseService.insertBatch(list);
        } catch (DataAccessException e) {
            logger.error(e.getMessage(), e);
        }
        return flag ? new StatusModel(true,"批量保存成功") : new StatusModel(false,"批量保存失败");
    }

    @PostMapping("{id}/deleteById")
    @ResponseBody
    public StatusModel deleteById(@PathVariable("id")K id){
        boolean flag = false;
        try {
            flag = baseService.deleteById(id);
        } catch (DataAccessException e) {
            logger.error(e.getMessage(), e);
        }
        return flag ? new StatusModel(true,"删除成功") : new StatusModel(false,"删除失败");
    }

    @PostMapping("deleteBatchIds")
    @ResponseBody
    public StatusModel deleteBatchIds(@RequestParam List<K> ids) {
        boolean flag = false;
        try {
            flag = baseService.deleteBatchIds(ids);
        } catch (DataAccessException e) {
            logger.error(e.getMessage(), e);
        }
        return flag ? new StatusModel(true, "批量删除成功") : new StatusModel(false, "批量删除失败");
    }

    @PostMapping("updateById")
    @ResponseBody
    public StatusModel updateById(@RequestBody T t){
        boolean flag = false;
        try {
            flag = baseService.updateById(t);
        } catch (DataAccessException e) {
            logger.error(e.getMessage(), e);
        }
        return flag ? new StatusModel(true, "修改成功") : new StatusModel(false, "修改失败");
    }

    @PostMapping("updateBatchById")
    @ResponseBody
    public StatusModel updateBatchById(@RequestBody List<T> list){
        boolean flag = false;
        try {
            flag = baseService.updateBatchById(list);
        } catch (DataAccessException e) {
            logger.error(e.getMessage(), e);
        }
        return flag ? new StatusModel(true, "修改成功") : new StatusModel(false, "修改失败");
    }
}
