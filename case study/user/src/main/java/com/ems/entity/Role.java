package com.ems.entity;

import com.ems.utils.RoleEnum;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Data
@NoArgsConstructor
@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(generator = "UUID2", strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "UUID2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "role_uuid", columnDefinition = "uuid")
    private UUID roleId;

    @Column(name = "roleName")
    private Enum<RoleEnum> roleName;

    public Role(Enum<RoleEnum> roleName) {
        this.setRoleName(roleName);
    }
}