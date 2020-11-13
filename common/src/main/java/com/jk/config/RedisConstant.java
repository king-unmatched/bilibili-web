package com.jk.config;

// redis  key维护类
public class RedisConstant {

    // static 直接类名.方法名或者常量，当项目启动时被static修饰的提前加载
    // final 最终，被final修饰的类为最终类不能被继承
    //       被final修饰的方法为最终方法不能被重写
    //       被final修饰的变量为常量不能被修改 ，必须赋予默认值
    //  redis key定义规则（格式）：使用方法名（业务名）作为redis的key，如果缓存数据的方法带有参数，那么redis的key也要拼接参数

    // 定义redis最终常量key
    public static final String LIST_COMIC_KEY = "listComic";

    public static final String LIST_KEY = "list";

    public static final String LIST_JXCHOICENESS_KEY = "listJxChoiceness";

    public static final String SELECT_NEWVIDEO_KEY = "selectNewVideo";

    public static final String SLIDESHOW_KEY = "slideshow";

    public static final String SELECT_LIST_YCO_KEY = "selectlistYCO";
}
