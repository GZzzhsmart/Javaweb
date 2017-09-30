package top.zywork.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.zywork.dos.TemplateDO;
import top.zywork.service.TemplateService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Wang Genshen on 2017-08-30.
 */
@RestController
@RequestMapping("/")
public class IndexController {

    private TemplateService<TemplateDO, Long> templateService;

    @RequestMapping(value = "index")
    public String index(Model model) {
        return "index";
    }

    @RequestMapping(value = "index1", produces = "text/plain;charset=utf-8")
    public String index1() {
        return "spring boot!";
    }

    @GetMapping("index2")
    public String index2() {
        TemplateDO templateDO = new TemplateDO();
        templateDO.setName("spring boot");
        templateDO.setPassword("spring boot");
        templateService.save(templateDO);
        return "save";
    }

    @GetMapping("index3/{id}")
    public TemplateDO index3(@PathVariable("id") Long id) {
        return templateService.getById(id);
    }

    @GetMapping("index4")
    public List<TemplateDO> index4() {
        return templateService.listAll();
    }

    @GetMapping("index5")
    public List<TemplateDO> index5() {
        return templateService.listDOS();
    }

    @Resource
    public void setTemplateService(TemplateService<TemplateDO, Long> templateService) {
        this.templateService = templateService;
    }

}
