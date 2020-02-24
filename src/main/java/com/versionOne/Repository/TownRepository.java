package com.versionOne.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.versionOne.model.Town;

public interface TownRepository extends JpaRepository<Town, Integer>{

	@Query(value = " Select town, population, sum(client1) as clients from (Select distinct t.name as town, t.population as population, p.clients as client1 from \r\n" + 
			"  town t join branch b  on b.town = t.name  join product p  on p.branch = b.name) as result group by town order by clients desc", nativeQuery = true)
	List<List<Object>> getTowns();
	
	@Query(value=" Select branch, town, sum(client1) as clients from (Select distinct b.name as branch,t.name as town, p.clients as client1 from \r\n" + 
			"  town t join branch b  on b.town = t.name  join product p  on p.branch = b.name) as result group by town order by clients desc", nativeQuery=true)
	List<List<Object>> getTopBranches();
	
}
