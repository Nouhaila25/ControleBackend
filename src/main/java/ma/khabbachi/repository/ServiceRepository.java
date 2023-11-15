package ma.khabbachi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import ma.khabbachi.entities.Servece;





@Repository
public interface ServiceRepository extends JpaRepository<Servece, Long>{

}
