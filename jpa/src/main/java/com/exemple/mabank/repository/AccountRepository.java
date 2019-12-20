package com.exemple.mabank.repository;

import com.exemple.mabank.entity.AccountEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.OneToOne;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface AccountRepository extends CrudRepository<AccountEntity, UUID> {

  @Override
  List<AccountEntity> findAll();

  @Override
  Optional<AccountEntity> findById(UUID uuid);
}
