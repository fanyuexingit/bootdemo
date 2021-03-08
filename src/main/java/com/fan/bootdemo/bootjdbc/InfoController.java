/**
 * @description:
 * @author: Andy
 * @time: 2021/03/05 13:30
 */
package com.fan.bootdemo.bootjdbc;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * Created by fanyuexin on 2021/03/05
 */
@Api(tags = {"信息tag"})
@RestController
@RequestMapping(value = "/info")
public class InfoController {

    static Map<Long, Info> infos = Collections.synchronizedMap(new HashMap<>());

    @ApiOperation(value = "获取info", notes="detail notes")
    @GetMapping("/getUser")
    public List<Info> getInfos(){
        return new ArrayList<>(infos.values());
    }

    @ApiOperation(value = "获取info", notes="detail notes")
    @PostMapping("/getUser")
    public Info getInfoById(Long id) {
        return infos.get(id);
    }

    @ApiOperation(value = "新增info", notes="detail notes")
    @PostMapping("/insert")
    public String insertInfo(@RequestBody Info info){
        infos.put(info.getId(), info);
        return "success";
    }

    @ApiOperation(value = "更改info", notes="detail notes")
    @PostMapping("/update")
    public String updateInfo(@RequestBody Info info){
        Info preInfo = infos.get(info.getId());
        preInfo.setType(info.getType());
        preInfo.setContent(info.getContent());
        infos.put(info.getId(), preInfo);
        return "success";
    }

    @ApiOperation(value = "删除info", notes="detail notes")
    @PostMapping("/delete")
    public String deleteInfo(Long id){
        infos.remove(id);
        return "success";
    }
}
