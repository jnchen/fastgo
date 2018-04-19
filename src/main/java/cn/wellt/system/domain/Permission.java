package cn.wellt.system.domain;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * 权限实体类
 */
@Entity
@Table(name = "sys_perm")
@Data
@ToString(exclude = "roles")
public class Permission implements Serializable {
    /**
     * 主键
     */
    @Id
    @GeneratedValue
    private Long id;
    /**
     * 权限名称
     */
    private String name;
    /**
     * 资源类型
     */
    @Column(columnDefinition = "enum('menu','button')")
    private String resourceType;
    /**
     * 资源路径
     */
    private String url;
    /**
     *
     */
    private String permission;
    /**
     * 父权限ID
     */
    private Long parentId;
    /**
     * 权限全路径
     */
    private String parentIds;
    /**
     * 可用性
     */
    private Boolean available = Boolean.FALSE;
    /**
     * 包含此权限角色列表
     */
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "SysRolePermission",joinColumns = {@JoinColumn(name = "permissionId")},inverseJoinColumns = {@JoinColumn(name="roleId")})
    private List<Role> roles;
}
