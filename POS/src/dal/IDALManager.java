package dal;

import java.util.ArrayList;
import model.dto.CustomerDTO;
import model.dto.Response;
import model.dto.SupplierDTO;
import model.dto.UserDTO;


public interface IDALManager {
    
     //user methods

    void addUser(UserDTO userObj, Response responseObj);
    
    void verifyUser(UserDTO user, Response responseObj);
    
    void updatePassword(UserDTO userObj, Response responseObj);
    
    void deleteUser(UserDTO userObj, Response responseObj);

    void deleteUsers(ArrayList<UserDTO> users, Response responseObj);
    
    ArrayList<UserDTO> getUsers(Response response);
    
    void addUsers(ArrayList<UserDTO> users, Response responseObj);
    
    //customer methods
    
    void saveCustomer(CustomerDTO customer, Response response);
    
    void updateCustomer(CustomerDTO customer, Response response);
    
    void deleteCustomer(CustomerDTO customer, Response response);
    
    ArrayList<CustomerDTO> getCustomers(Response response);
    
     //supplier methods

    void saveSupplier(SupplierDTO supplier, Response response);

    void updateSupplier(SupplierDTO suppier, Response response);
    
    void deleteSupplier(SupplierDTO supplier, Response response);

    ArrayList<SupplierDTO> getSuppliers(Response res);
    
}
