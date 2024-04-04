package com.service.employee.Service;

import com.service.employee.Dto.EmployeeDto;
import com.service.employee.Model.EmployeeModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class EmployeeService {
    private static final Logger logger = Logger.getLogger(EmployeeService.class.getName());
    private final AtomicLong idGenerator = new AtomicLong(1);
    HashMap<Long, EmployeeModel> employeeHashMap = new HashMap<>();

    public String insertEmployee(EmployeeDto employeeDto) {

        Long id = idGenerator.getAndIncrement();

        EmployeeModel employee=new EmployeeModel();
        employee.setEmployeeId(id);
        employee.setEmployeeName(employeeDto.getEmployeeName());
        employee.setMark1(employeeDto.getMark1());
        employee.setMark2(employeeDto.getMark2());
        employee.setMark3(employeeDto.getMark3());
        long total = employeeDto.getMark1() + employeeDto.getMark2() + employeeDto.getMark3();
        employee.setTotal(total);

        employeeHashMap.put(id, employee);
        logger.info(employeeHashMap.toString());
        return "Insert Successfully";
    }


    public List<EmployeeModel> getAllEmployee() {
        List<EmployeeModel> employeeModels = new ArrayList<>();
        for (Map.Entry<Long, EmployeeModel> map : employeeHashMap.entrySet()) {
            employeeModels.add(map.getValue());
        }
        return employeeModels;
    }

    public EmployeeModel getById(Long empId) {
        EmployeeModel employeeModel=new EmployeeModel();
        for (Map.Entry<Long, EmployeeModel> map : employeeHashMap.entrySet()) {

            if(empId.equals(map.getKey())){
              employeeModel=  map.getValue();
            }
        }
        logger.info(employeeModel.toString());
        return employeeModel;
    }


    public long getByIdTotal(Long empId) {
        long total = 0;
        for (Map.Entry<Long, EmployeeModel> map : employeeHashMap.entrySet()) {
            if(empId.equals(map.getKey())){
                total=  map.getValue().getTotal();
            }
        }
        return total;
    }
}
