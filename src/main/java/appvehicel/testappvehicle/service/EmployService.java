package appvehicel.testappvehicle.service;

import appvehicel.testappvehicle.model.Employ;

import java.util.List;

public interface EmployService {
    Employ saveEmploy(Employ employ);
    List<Employ> getAllEmploys();
    Employ getEmployById(long id);
    Employ updateEmploy(Employ employ,long id);

    List<Employ> findFirstByNoRegAndNameUser(String noReg,String nameUser);
    void deleteEmploy(long id);
}
