package cn.wellt.system.domain;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * 角色实体类
 */
@Entity
@Table(name = "sys_role")
@Data
@ToString(exclude = {"permissions","users"})
public class Role implements Serializable {
    /**
     * 主键
     */
    @Id
    @GeneratedValue
    private Long id;
    /**
     * 角色名
     */
    private String role;
    /**
     * 角色描述
     */
    private String description;
    /**
     * 角色可用性
     */
    private Boolean available = Boolean.FALSE;

    /**
     * 角色所属权限
     */
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "SysRolePermission",joinColumns = {@JoinColumn(name = "roleId")},inverseJoinColumns = {@JoinColumn(name = "permissionId")})
    private List<Permission> permissions;


    /**
     * 拥有此角色用户
     */
    @ManyToMany
    @JoinTable(name = "SysUserRole",joinColumns = {@JoinColumn(name = "roleId")},inverseJoinColumns = {@JoinColumn(name = "uid")})
    private List<User> users;
}
