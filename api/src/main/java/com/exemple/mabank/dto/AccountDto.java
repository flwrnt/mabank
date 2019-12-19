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
@NoArgsConstructor
@ApiModel(description = "compte bancaire")
public class AccountDto {

  @ApiModelProperty(value = "identifiant du compte bancaire", required = true)
  private UUID id;

  @ApiModelProperty(value = "libellé du compte bancaire", required = true)
  private String label;

  @ApiModelProperty(value = "argent disponible sur le compte bancaire", required = true)
  private Double money;

  @ApiModelProperty(value = "devise du compte bancaire", required = true)
  private Devise devise;
}
