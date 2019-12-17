package com.exemple.mabank.dto;

import com.exemple.mabank.model.Devise;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@ApiModel(description = "compte bancaire")
public class AccountDto {

  @ApiModelProperty("identifiant du compte bancaire")
  private final UUID id;

  @ApiModelProperty("libellé du compte bancaire")
  private final String label;

  @ApiModelProperty("argent disponible sur le compte bancaire")
  private final Double money;

  @ApiModelProperty("devise du compte bancaire")
  private final Devise devise;
}
