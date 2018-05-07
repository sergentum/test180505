package repository;

import model.Transaction;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Transaction, Integer> {
}
