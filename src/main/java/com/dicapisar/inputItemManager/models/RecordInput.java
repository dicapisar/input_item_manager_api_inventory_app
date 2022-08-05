package com.dicapisar.inputItemManager.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "records_input")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RecordInput {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rec_inp_id")
    private Long id;

    @Column(name = "rec_inp_active", nullable = false)
    private boolean isActive;

    @Column(name = "rec_inp_status", nullable = false)
    private String status;

    @Column(name = "rec_inp_reason", nullable = false)
    private String reason;

    @Column(name = "rec_inp_creation_date")
    private LocalDateTime creationDate;

    @Column(name = "rec_inp_update_date")
    private LocalDateTime updateDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rec_inp_creator_id")
    private User creator;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rec_inp_updater_id")
    private User updater;
}
