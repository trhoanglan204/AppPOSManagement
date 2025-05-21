package model.validators;

import java.util.ArrayList;
import model.dto.CustomerDTO;
import model.dto.Message;
import model.dto.MessageType;
import model.dto.Response;
import model.dto.SupplierDTO;
import model.dto.UserDTO;

public class CommonValidator {

    public static void validateObject(Object obj, Response objResponse) {
        if (obj instanceof UserDTO) {
            UserDTO objUser = (UserDTO) obj;
            isValidUsername(objUser.getUsername(), objResponse);
            isValidPassword(objUser.getPassword(), objResponse);
        } else if (obj instanceof CustomerDTO) {
            CustomerDTO customer = (CustomerDTO) obj;
            isValidName(customer.getName(), objResponse);
            isValildPhoneNo(customer.getPhoneNumber(), objResponse);
        } else if (obj instanceof SupplierDTO) {
            SupplierDTO supplierDTO = (SupplierDTO) obj;
            isValidName(supplierDTO.getName(), objResponse);
            isValildPhoneNo(supplierDTO.getPhoneNumber(), objResponse);
        }
    }

    private static void isValidUsername(String username, Response objResponse) {
        if (username == null || username.length() < 3) {
            objResponse.messagesList.add(new Message("Email is not valid, provide valid username with at least 3 characters.", MessageType.Error));
            return;
        }
    }

    private static void isValidPassword(String password, Response objResponse) {
        if (password == null || password.length() < 3) {
            objResponse.messagesList.add(new Message("Password is not valid, provide valid password with at least 3 characters.", MessageType.Error));
        }

    }

    public static void validateUsers(ArrayList<UserDTO> users, Response responseObj) {
        for (UserDTO user : users) {
            validateObject(user, responseObj);
        }
    }

    private static void isValidName(String name, Response objResponse) {
        if (name == null || name.length() < 3) {
            objResponse.messagesList.add(new Message("Name is not valid, provide valid name with at least 3 characters.", MessageType.Error));
            return;
        }
    }

    private static void isValildPhoneNo(String phoneNumber, Response response) {
        if (phoneNumber == null || phoneNumber.length() != 10) {
            response.messagesList.add(new Message("Phone Number is not valid, provide valid Phone Number with 10 digits.", MessageType.Error));
            return;
        }
    }

}
