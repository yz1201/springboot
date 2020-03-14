package cn.dbdj1201.lazyman.controller;

import cn.dbdj1201.lazyman.service.ISysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author tyz1201
 * @datetime 2020-03-14 13:03
 **/
@Controller
@RequestMapping("/syslog")
public class SysLogController {

    @Autowired
    private ISysLogService sysLogService;

    @GetMapping("list")
    public String list(Model model) {
        model.addAttribute("syslogList", sysLogService.findAll());
        return "syslog-list";
    }
}
