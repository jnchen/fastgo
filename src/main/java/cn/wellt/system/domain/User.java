package cn.wellt.system.domain;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * 用户信息实体类
 */
@Entity
@Table(name = "sys_user")
@Data
@ToString(exclude = "roleList")
public class User implements Serializable {
    /**
    * 主键
    */
    @Id
    @GeneratedValue
    private Long id;
    /**
    * 用户名
    */
    private String username;
    /**
     * 用户昵称
     */
    private String name;
    /**
     * 密码
     */
    private String password;
    /**
     * 盐
     */
    private String salt;
    /**
     * 状态
     */
    private byte state; //1 正常 2 锁定 0 未启用
    /**
     * 所属角色
     */
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "SysUserRole",joinColumns = {@JoinColumn(name = "uid")},inverseJoinColumns = {@JoinColumn(name = "roleId")})
    private List<Role> roleList;
    /**
     * 认证盐
     * @return
     */
    public String getCredentialsSalt(){
        return this.username + this.salt;
    }
}
