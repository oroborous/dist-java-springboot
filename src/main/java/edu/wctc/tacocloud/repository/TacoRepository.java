package edu.wctc.tacocloud.repository;

import edu.wctc.tacocloud.entity.Taco;
import org.springframework.data.repository.CrudRepository;

public interface TacoRepository extends CrudRepository<Taco, Long> {


}
