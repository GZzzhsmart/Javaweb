package top.zywork.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zywork.dao.TemplateDAO;
import top.zywork.dos.TemplateDO;
import top.zywork.service.TemplateService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Wang Genshen on 2017-08-31.
 */
@Service
public class TemplateServiceImpl implements TemplateService<TemplateDO, Long> {

    private TemplateDAO templateDAO;

    @Override
    public void save(TemplateDO templateDO) {
        templateDAO.save(templateDO);
    }

    @Override
    public TemplateDO getById(Long id) {
        return templateDAO.findOne(id);
    }

    @Override
    public List<TemplateDO> listAll() {
        return templateDAO.findAll();
    }

    @Override
    public List<TemplateDO> listDOS() {
        return templateDAO.findDOS();
    }

    @Resource
    public void setTemplateDAO(TemplateDAO templateDAO) {
        this.templateDAO = templateDAO;
    }
}