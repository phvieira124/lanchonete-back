package com.lanchonete.lanches;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LancheRepository extends JpaRepository<Lanche, Long> {
	
}
