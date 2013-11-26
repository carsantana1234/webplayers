package org.webplayerslib.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.webplayerslib.model.EntityPlayer;

@Repository
public interface PlayerRepository extends JpaRepository<EntityPlayer, Integer> {

}
