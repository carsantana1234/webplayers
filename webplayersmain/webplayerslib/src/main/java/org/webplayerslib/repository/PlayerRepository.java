package org.webplayerslib.repository;

import org.register.model.EntityPlayer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends JpaRepository<EntityPlayer, Integer> {

}
