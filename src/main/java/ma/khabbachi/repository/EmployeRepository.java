package ma.khabbachi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.khabbachi.entities.Employe;



@Repository
public interface EmployeRepository extends JpaRepository<Employe, Long>{

}
