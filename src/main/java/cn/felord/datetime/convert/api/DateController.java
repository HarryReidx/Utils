package cn.felord.datetime.convert.api;

import cn.felord.datetime.convert.bean.UserInfo;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

/**
 * The type Date controller.
 *
 * @author Dax
 * @since 13 :45  2019/9/17
 */
@RestController
@RequestMapping("/date")
public class DateController {


    /**
     * 测试 {@link DateTimeFormat}注解.
     *
     * @param localDateTime the local date time
     * @return the map
     */
    @GetMapping("/local")
    public Map<String, String> data(@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime localDateTime) {
        Map<String, String> map = new HashMap<>(1);
        map.put("data", localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        return map;

    }


    /**
     * 测试序列化.
     *
     * @param userInfo the user info
     * @return the object
     */
    @PostMapping("/user")
    public Object postData(@RequestBody UserInfo userInfo) {
        System.out.println("userInfo = " + userInfo);
        return userInfo;
    }

    /**
     * 测试全局配置.
     *
     * @param userInfo the user info
     * @return the data
     */
    @GetMapping("/s")
    public Object getData( UserInfo userInfo) {
        System.out.println("userInfo = " + userInfo);
        return userInfo;
    }
}
