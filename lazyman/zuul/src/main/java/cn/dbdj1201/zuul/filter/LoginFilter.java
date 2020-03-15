package cn.dbdj1201.zuul.filter;

import com.netflix.zuul.IZuulFilter;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;

/**
 * @author tyz1201
 * @datetime 2020-03-16 0:14
 **/
public class LoginFilter extends ZuulFilter {


    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 10;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        return null;
    }
}
