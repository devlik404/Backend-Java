package appvehicel.testappvehicle.controller;

import appvehicel.testappvehicle.model.Employ;
import appvehicel.testappvehicle.service.EmployService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employs")
public class EmployController {

    private EmployService employService;

    public EmployController(EmployService employService) {
        super();
        this.employService = employService;
    }
//    REST API
    @PostMapping()
    public ResponseEntity<Employ> saveEmploy(@RequestBody Employ employ){
        return new ResponseEntity<Employ>(employService.saveEmploy(employ), HttpStatus.CREATED);
    }
//    get all API
    @GetMapping()
    public List<Employ> getAllEmploys(){
        return employService.getAllEmploys();
    }
//    get by id
    @GetMapping("{id}")
public ResponseEntity<Employ>  getEmployById(@PathVariable("id") long id) {
        return new ResponseEntity<Employ>(employService.getEmployById(id),HttpStatus.OK);
}
//update api
    @PutMapping("{id}")
public ResponseEntity<Employ> updateEmploy(@PathVariable("id") long id ,@RequestBody Employ employ){
        return new ResponseEntity<Employ>(employService.updateEmploy(employ,id),HttpStatus.OK);
}
//Delete Rest API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmploy(@PathVariable("id") long id){
        employService.deleteEmploy(id);
        return new ResponseEntity<String>("Employ Deleted Succses.", HttpStatus.OK);
    }
//    Search Employ
    @GetMapping("/search")
    public List<Employ>findFirstByNoRegAndNameUser( @RequestParam String noReg,@RequestParam String nameUser){
        return employService.findFirstByNoRegAndNameUser(noReg,nameUser);
    }


}
