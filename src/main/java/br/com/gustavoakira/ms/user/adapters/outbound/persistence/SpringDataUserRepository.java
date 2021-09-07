package br.com.gustavoakira.ms.user.adapters.outbound.persistence;

import br.com.gustavoakira.ms.user.adapters.outbound.persistence.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SpringDataUserRepository extends JpaRepository<UserEntity,UUID> {
}
