package top.jokeme.milktee.service.milktee;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * project_name: milk-tee
 * author:       frelon
 * date:         2022/9/27
 **/
public interface uploadpic {
    String uploadpicture(MultipartFile file) throws IOException;
}
