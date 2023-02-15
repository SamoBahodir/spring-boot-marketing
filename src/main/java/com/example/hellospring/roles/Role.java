package com.example.hellospring.roles;

import com.example.hellospring.cor.Name;
import com.example.hellospring.cor.Permission;
import com.example.hellospring.cor.TechnicalFields;
import com.vladmihalcea.hibernate.type.array.IntArrayType;
import com.vladmihalcea.hibernate.type.array.StringArrayType;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "roles")
@TypeDefs({
        @TypeDef(name = "string-array", typeClass = StringArrayType.class),
        @TypeDef(name = "int-array", typeClass = IntArrayType.class),
        @TypeDef(name = "jsonb", typeClass = JsonBinaryType.class),

})
public class Role extends TechnicalFields {

    @Id
    @SequenceGenerator(name = "roles_id_seq", sequenceName = "roles_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "roles_id_seq")
    @Column(name = "id")
    private Integer id;

    @Type(type = "jsonb")
    @Column(name = "name", columnDefinition = "jsonb", nullable = false)
    private Name name;

    @Type(type = "jsonb")
    @Column(name = "permissions", columnDefinition = "jsonb", nullable = false)
    private List<Permission> permissions;
}
