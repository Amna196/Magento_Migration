package menuManegment.demo.menu.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Setter
@Getter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
public abstract class Abstract<T> implements Loadable<T> {

    @JsonProperty("created_at")
    @Column(name = "created_at")
    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    @JsonProperty("updated_at")
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}

