package com.exemple.mabank.entity;

import com.exemple.mabank.model.Devise;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
@Table(name = "account")
@AllArgsConstructor
@NoArgsConstructor
public class AccountEntity {

  @Id
  @Column(name = "id")
  private UUID id;

  private String label;

  private Double amount;

  @Enumerated(EnumType.STRING)
  private Devise devise;
}
