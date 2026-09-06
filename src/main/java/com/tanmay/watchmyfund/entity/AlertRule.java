package com.tanmay.watchmyfund.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.*;
import com.tanmay.watchmyfund.enums.AlertStatus;

@Entity
@Table(name = "alert_rules")
public class AlertRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_fund_id", nullable = false)
    UserFund userFund;

    @Column(name = "target_percentage", nullable = false, scale = 4)
    private BigDecimal targetPercentage;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private AlertStatus status = AlertStatus.ACTIVE;

    @Column(name = "is_deleted", nullable = false)
    private Boolean isDeleted = false;

    @Column(name = "created_at", nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    public AlertRule(UserFund userFund, BigDecimal targetPercentage) {
        this.userFund = userFund;
        this.targetPercentage = targetPercentage;
    }

    public AlertRule() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserFund getUserFund() {
        return userFund;
    }

    public void setUserFund(UserFund userFund) {
        this.userFund = userFund;
    }

    public BigDecimal getTargetPercentage() {
        return targetPercentage;
    }

    public void setTargetPercentage(BigDecimal targetPercentage) {
        this.targetPercentage = targetPercentage;
    }

    public AlertStatus getStatus() {
        return status;
    }

    public void setStatus(AlertStatus status) {
        this.status = status;
    }

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
}
