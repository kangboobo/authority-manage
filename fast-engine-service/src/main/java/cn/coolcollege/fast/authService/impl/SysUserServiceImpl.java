package cn.coolcollege.fast.authService.impl;

import cn.coolcollege.fast.authService.ISysUserService;
import cn.coolcollege.fast.config.SysUserConfig;
import cn.coolcollege.fast.constants.BaseResponse;
import cn.coolcollege.fast.exception.AuthManageErrConstant;
import cn.coolcollege.fast.service.HttpRestTemplateService;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * @author zhu.changgen
 * @version 1.0
 * @date 2022/11/15 11:24
 * @description
 */
@Service
@Slf4j
public class SysUserServiceImpl implements ISysUserService {

    @Autowired
    private SysUserConfig sysUserConfig;

    @Autowired
    private HttpRestTemplateService httpRestTemplateService;

    /**
     * 查询用户列表
     * @param departmentId 部门id
     * @param keyword 关键词
     * @param pageNumber 分页参数
     * @param pageSize 分页参数
     * @return
     */
    @Override
    public BaseResponse getUserList(String departmentId, String keyword, Integer pageNumber, Integer pageSize) {
        // 调用部门接口
        String apiUrl = null;
        JSONObject jsonObject = null;
        try {
            apiUrl = String.format(sysUserConfig.getGetUserListApi(), departmentId, keyword, pageNumber, pageSize);
            String content = httpRestTemplateService.getForObject(apiUrl, String.class, Maps.newHashMap());
            jsonObject = JSONObject.parseObject(content);
        }catch (Exception e){
            log.error("getDepartmentList error, call api failed, apiUrl:{}", apiUrl, e);
            return BaseResponse.getFailedResponse(AuthManageErrConstant.CALL_USER_API_FAILED);
        }
        Integer code = jsonObject.getInteger("code");
        if(!Objects.equals(0, code)){
            return BaseResponse.getFailedResponse(AuthManageErrConstant.CALL_USER_API_FAILED);
        }
        // 组织返回结果
        BaseResponse response = BaseResponse.getSuccessResponse(jsonObject.getJSONObject("data"));
        return response;
    }
}
