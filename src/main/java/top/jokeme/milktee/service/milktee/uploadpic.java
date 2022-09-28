package top.jokeme.milktee.service.milktee;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Map;

/**
 * project_name: milk-tee
 * author:       frelon
 * date:         2022/9/27
 **/
public interface uploadpic {
    Map<String ,String> uploadpicture(MultipartFile file) throws IOException;
}
