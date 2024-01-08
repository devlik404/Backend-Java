package appvehicel.testappvehicle.service.impl;

import appvehicel.testappvehicle.exception.ResourceNotFoundException;
import appvehicel.testappvehicle.model.Employ;
import appvehicel.testappvehicle.repository.EmployRepository;
import appvehicel.testappvehicle.service.EmployService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployServiceImpl implements EmployService {
    private  EmployRepository employRepository;

    public EmployServiceImpl(EmployRepository employRepository) {
        super();
        this.employRepository = employRepository;
    }
    @Override
    public Employ saveEmploy(Employ employ) {
        return employRepository.save(employ);
    }

    @Override
    public List<Employ> getAllEmploys() {
        return employRepository.findAll();
    }

    @Override
    public Employ getEmployById(long id) {

      return  employRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employ","id",id));
    }

    @Override
    public Employ updateEmploy(Employ employ, long id) {
//        check id exist in db
        Employ existingEmploy = employRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employ","Id",id));
       existingEmploy.setNoReg(employ.getNoReg());
       existingEmploy.setNameUser(employ.getNameUser());
       existingEmploy.setCapacity(employ.getCapacity());
       existingEmploy.setColor(employ.getColor());
       existingEmploy.setVclBrand(employ.getVclBrand());
       existingEmploy.setYearsOM(employ.getYearsOM());
       existingEmploy.setFuel(employ.getFuel());
       existingEmploy.setAddress(employ.getAddress());
       employRepository.save(existingEmploy);
        return existingEmploy;

    }

    @Override
    public List<Employ> findFirstByNoRegAndNameUser(String noReg, String nameUser) {
        if (noReg != null && nameUser != null) {
            return employRepository.findFirstByNoRegAndNameUser(noReg, nameUser);
        } else {
            return employRepository.findAll();
        }
    }


    @Override
    public void deleteEmploy(long id) {
//        check exist id in Db

        employRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employ","Id",id));

        employRepository.deleteById(id);
    }


}
