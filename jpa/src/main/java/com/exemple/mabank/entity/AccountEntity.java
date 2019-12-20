package com.exemple.mabank.entity;

import com.exemple.mabank.model.Account;
import com.exemple.mabank.model.Devise;
import com.flwrnt.annotation.Converter;
import com.flwrnt.annotation.FieldConverter;
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
@Converter(targetClass = Account.class)
public class AccountEntity {

  @Id
  @FieldConverter
  @Column(name = "id")
  private UUID id;

  @FieldConverter
  private String label;

  @FieldConverter(targetFieldName = "money")
  private Double amount;

  @FieldConverter
  @Enumerated(EnumType.STRING)
  private Devise devise;
}
