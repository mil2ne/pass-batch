package com.fastcampus.pass.repository;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

/**
 * 공통 매핑 정보를 가진 Entity
 */

@MappedSuperclass // 상속 받은 entity에서 아래 필드들을 컬럼으로 사용할 수 있습니다.
@EntityListeners(AuditingEntityListener.class) // Auditing 정보를 캡쳐하는 Listner 입니다.
public abstract class BaseEntity {

    @CreatedDate // 생성일시를 생성합니다.
    @Column(updatable = false, nullable = false) // 업데이트를 하지 않도록, null 이 되지 않도록 명시합니다.L
    private LocalDateTime createdAt;

    @LastModifiedDate // 마지막 수정일시를 생성 합니다.
    private LocalDateTime modifiedAt;
}
