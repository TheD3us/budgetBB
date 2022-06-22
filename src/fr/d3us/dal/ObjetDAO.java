package fr.d3us.dal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.d3us.bo.ObjetPourBebe;



@Repository
public interface ObjetDAO extends JpaRepository<ObjetPourBebe, Integer>{
	
}
