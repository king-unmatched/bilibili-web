package com.jk.controller;

import com.jk.entity.EpisodeNumber;
import com.jk.service.ComicVideoService;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

@Controller
public class FreemakerController {

    @Autowired
    private ComicVideoService comicVideoService;


    @RequestMapping("creatGoodsHtmlById")
    @ResponseBody
    public void creatMovieHtmlById(HttpServletRequest request, int episodeId) {
        //获取servlet上下文环境对象
        ServletContext servletContext = request.getServletContext();
        Configuration configuration = new Configuration();
        //加载绝对路径的模板  加载的是一个文件夹
        try {
            configuration.setDirectoryForTemplateLoading(new File("E:\\IDEA工作空间\\bilibili-web\\consumer\\src\\main\\resources\\templates"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        OutputStreamWriter outputStreamWriter = null;
        FileOutputStream fileOutputStream = null;
        //在加载的模板文件夹中获取到对应的模板文件
        try {
            Template template = configuration.getTemplate("guan.flt");
            EpisodeNumber com = comicVideoService.findgoodbyid(episodeId);

            String id = com.getEpisodeId().toString();
            String fileName = id + ".html";
            fileOutputStream = new FileOutputStream("E:\\IDEA工作空间\\bilibili-web\\consumer\\src\\main\\resources\\templates\\" + fileName);
            outputStreamWriter = new OutputStreamWriter(fileOutputStream, "UTF-8");
            //把模板和数据合成一个新的文件并输出到fileWriter目录当中
            template.process(com, outputStreamWriter);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        } finally {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (outputStreamWriter != null) {
                try {
                    outputStreamWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
