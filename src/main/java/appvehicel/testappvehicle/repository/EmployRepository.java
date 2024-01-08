package appvehicel.testappvehicle.repository;

import appvehicel.testappvehicle.model.Employ;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface EmployRepository extends JpaRepository<Employ, Long> {
    List<Employ> findFirstByNoRegAndNameUser(String noReg,String nameUser);

}
