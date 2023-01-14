package top.jokeme.milktee.service.milktea.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import top.jokeme.milktee.dao.uri;
import top.jokeme.milktee.mapper.uriMp;
import top.jokeme.milktee.service.milktea.uploadpic;
import top.jokeme.milktee.utils.NTime;
import top.jokeme.milktee.utils.uuid;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * project_name: milk-tee
 * author:       frelon
 * date:         2022/9/27
 **/
@SuppressWarnings("ALL")
@Service
public class uploadpicimpl implements uploadpic {

    @Autowired
    private uriMp uriMp;


    @Override
    public Map<String ,String> uploadpicture(MultipartFile file) throws IOException {
        Logger logger = LoggerFactory.getLogger(getClass());

        uri uri = new uri();

        FileInputStream fis = null;
        FileOutputStream fos = null;

        uuid uuid = new uuid();
        String tmp_uuid = uuid.mediumuuid();

        NTime nTime = new NTime();
        String tmp_time = nTime.getShortTime();

        Map map = new HashMap<>();

        final String firstfilepath = "Z:\\udisk\\pict\\"+tmp_time;
        final String BASE_HTTP_URL = "http://pics.ip.jokeme.top:6280/"+tmp_time;
        //  这个路径以后再改。

        //  以后添加文件hash的计算，并保存到MySQL，来避免上传同源文件。
        try {
            if (!file.isEmpty()){
                String originalName = file.getOriginalFilename();
                String prefix = originalName.substring(originalName.lastIndexOf("."));
                final String FINAL_PICTURE_FILEPATH = firstfilepath+"\\"+tmp_uuid+prefix;
                File fl = new File(FINAL_PICTURE_FILEPATH);
                if (!fl.getParentFile().exists()){
                    logger.warn("Target folder not exist，mkdir : "+tmp_time);
                    fl.getParentFile().mkdirs();
                }
                file.transferTo(fl);

                final String FINAL_HTTP_URL = BASE_HTTP_URL+"/"+tmp_uuid+prefix;

                uri.setOriginal_name(originalName);
                uri.setUuid(tmp_uuid);
                uri.setPresent_name(tmp_uuid+prefix);
                uri.setCreate_date(nTime.getNowTime());
                uri.setGenarate_url(FINAL_HTTP_URL);

                Integer result = uriMp.insert(uri);
                logger.info(originalName+" insert MySql result : "+result);
                logger.info(originalName+" saved success! FilePath : "+ FINAL_PICTURE_FILEPATH+", final http url:"+FINAL_HTTP_URL);

                map.put("result","200 ok");
                map.put("url",FINAL_HTTP_URL);
                return map;
            }
        }catch (Exception e){
            logger.error(e.toString());
        }finally {
            try{
                if (fis!=null){
                    fis.close();
                }
                if (fos!=null){
                    fos.close();
                }
            }catch (Exception e){
                logger.error("Close i/o error ! "+e.toString());
            }
        }
        map.put("result","eerror");
        return map;
    }
}
