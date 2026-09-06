package com.tanmay.watchmyfund.entity;

import java.time.LocalDateTime;

import com.tanmay.watchmyfund.enums.AlertDeliveryStatus;

import jakarta.persistence.*;

@Entity
@Table(name = "alert_histories")
public class AlertHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "alert_rule_id", nullable = false)
    private AlertRule alertRule;

    @Column(name = "triggered_at", nullable = false)
    private LocalDateTime triggeredAt;

    @Column(name = "message", nullable = false)
    private String message;

    @Column(name = "delivery_status", nullable = false)
    @Enumerated(EnumType.STRING)
    private AlertDeliveryStatus deliveryStatus;

    public AlertHistory() {
    }

    public AlertHistory(LocalDateTime triggeredAt, String message, AlertDeliveryStatus deliveryStatus) {
        this.triggeredAt = triggeredAt;
        this.message = message;
        this.deliveryStatus = deliveryStatus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getTriggeredAt() {
        return triggeredAt;
    }

    public void setTriggeredAt(LocalDateTime triggeredAt) {
        this.triggeredAt = triggeredAt;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public AlertDeliveryStatus getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(AlertDeliveryStatus deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }

}
