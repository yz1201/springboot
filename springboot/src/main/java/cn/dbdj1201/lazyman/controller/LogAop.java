package cn.dbdj1201.lazyman.controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import cn.dbdj1201.lazyman.pojo.SysLog;
import cn.dbdj1201.lazyman.service.ISysLogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.validation.support.BindingAwareModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.stream.Stream;

/**
 * @author tyz1201
 * @datetime 2020-03-14 11:48
 **/
@Component
@Aspect
public class LogAop {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private ISysLogService sysLogService;

    private Date visitTime; //开始时间
    private Class clazz; //访问的类
    private String methodName;//访问的方法
    private Method method;

    @Before("execution(* cn.dbdj1201.lazyman.controller.*.*(..))")
    public void doBefore(JoinPoint jp) throws NoSuchMethodException {
        this.visitTime = new Date();
        this.clazz = jp.getTarget().getClass();
        this.methodName = jp.getSignature().getName(); //获取访问的方法的名称
        Object[] args = jp.getArgs();

        if (args == null || args.length == 0) {
            this.method = this.clazz.getMethod(this.methodName);
        } else {
            int len = args.length;
            Class[] classes = new Class[args.length];
            for (int i = 0; i < len; i++) {
                if (args[i] instanceof BindingAwareModelMap)
                    classes[i] = Model.class;
            }
            this.method = this.clazz.getMethod(this.methodName, classes);
        }

    }

    @After("execution(* cn.dbdj1201.lazyman.controller.*.*(..))")
    public void doAfter() throws Exception {
        long executionTime = new Date().getTime() - visitTime.getTime();
        if (clazz != null && method != null && clazz != LogAop.class) {
            RequestMapping clazzAnnotation = (RequestMapping) clazz.getAnnotation(RequestMapping.class);
            if (clazzAnnotation != null) {
                String[] classValue = clazzAnnotation.value();
                GetMapping methodAnnotation = method.getAnnotation(GetMapping.class);
                if (methodAnnotation != null) {
                    String[] methodValue = methodAnnotation.value();
                    String url = classValue[0] + methodValue[0];
//                    SecurityContext context = SecurityContextHolder.getContext();
//                    User user = (User) context.getAuthentication().getPrincipal();
//                    String username = user.getUsername();
                    String username = "dbdj1201";
                    String ip = request.getRemoteAddr();
                    SysLog sysLog = new SysLog();
                    sysLog.setIp(ip);
                    sysLog.setExecutionTime(executionTime);
                    sysLog.setMethod("[类名]" + clazz.getName() + "[方法名]" + this.methodName);
                    sysLog.setUrl(url);
                    sysLog.setUsername(username);
                    sysLog.setVisitTime(visitTime);
                    sysLogService.save(sysLog);
                }
            }
        }
    }
}
