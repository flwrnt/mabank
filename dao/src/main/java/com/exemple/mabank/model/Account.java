package com.exemple.mabank.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {

  private UUID id;

  private String label;

  private Double money;

  private Devise devise;

  public Double addMoney(Double amount) {
    if (amount < 0) {
      throw new RuntimeException("le montant doit être positif");
    }
    money += amount;
    return money;
  }

  public Double substractMoney(Double amount) {
    if (amount > 0) {
      throw new RuntimeException("le montant doit être positif");
    }
    money -= amount;
    return money;
  }
}
