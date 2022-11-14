package cn.coolcollege.fast.storage.entity.vo;

import cn.coolcollege.fast.storage.entity.dao.SysUserGroup;
import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

/**
 * @author baibin
 * @version 1.0
 * @date 2022/11/14 15:26
 * @description
 */
public class SysUserGroupVo extends SysUserGroup {

    private static final long serialVersionUID = 1L;

    @JSONField(name = "sys_app")
    private BaseAuthVo sysApp;

    @JSONField(name = "sys_bases")
    private List<BaseAuthVo> sysBases;

    @JSONField(name = "sys_roles")
    private List<BaseAuthVo> sysRoles;

    @JSONField(name = "sys_users")
    private List<BaseAuthVo> sysUsers;

    public BaseAuthVo getSysApp() {
        return sysApp;
    }

    public void setSysApp(BaseAuthVo sysApp) {
        this.sysApp = sysApp;
    }

    public List<BaseAuthVo> getSysBases() {
        return sysBases;
    }

    public void setSysBases(List<BaseAuthVo> sysBases) {
        this.sysBases = sysBases;
    }

    public List<BaseAuthVo> getSysRoles() {
        return sysRoles;
    }

    public void setSysRoles(List<BaseAuthVo> sysRoles) {
        this.sysRoles = sysRoles;
    }

    public List<BaseAuthVo> getSysUsers() {
        return sysUsers;
    }

    public void setSysUsers(List<BaseAuthVo> sysUsers) {
        this.sysUsers = sysUsers;
    }
}

