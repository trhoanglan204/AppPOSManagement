# Java Project
## Members
- AT19N0101 Nguyễn Thị Hồng Anh
- AT19N0119 Nguyễn Anh Khôi
- AT19N0123 Trương Hoàng Lân
- AT19N0138 Trương Văn Thiệu
## About
This is a Java Swing-**based** Point of Sale (POS) system built with MySQL server integration using the MVC (Model-View-Controller) architecture. 

It offers a user-friendly interface for managing sales transactions, inventory, and customer data.

> in development ...
## Features

- **User Authentication**: Secure login functionality to ensure only authorized personnel can access the system.
- **Sales Management**: Ability to process sales transactions, including adding items, applying discounts, and generating invoices.
- **Inventory Management**: Keep track of available stock, add new items, update quantities, and remove items when sold.
- **Customer Management**: Maintain a database of customer information for loyalty programs and personalized services.
- **QR Barcode Generating**: Generate dynamic QR code base on context 
- **Update Password**: Allow user to update password (validate old password first) & allow admin to create user, update any user password (without validate)

## Technologies Used

- **Java Swing**: For building the graphical user interface (GUI).
- **MySQL**: Database management system for storing and retrieving data.
- **MVC Architecture**: Organizes the codebase into Model, View, and Controller components for better maintainability and scalability.
- **JDBC (Java Database Connectivity)**: API for connecting Java applications to relational databases like MySQL.
- **Validation**: Implement robust validation mechanisms to ensure data integrity and prevent errors.

## Installation

1. **Clone the repository**:

    ```bash
    git clone https://github.com/trhoanglan204/AppPOSManagement.git
    ```

2. **Set up the database**:
    - Install MySQL server.
    - Create a new database named `pos`.
    - Import the SQL schema from `DBScripts/pos.sql`.

3. **Configure database connection**:
    - Update the database connection settings in `POS/src/dal/DALMnager.java` with your MySQL server credentials.

4. **Build and run**:
    - Open the project in your favorite Java IDE.
    - Build and run the project.

## Usage

1. **Login**: Enter your credentials to access the system.
> admin:root | cashier:root

2. **Navigate**: Use the menu options to navigate between different sections such as sales, inventory, and customers.

3. **Perform actions**: Add new items, process sales, update inventory, and manage customer information as needed.

4. **Generate reports**: Utilize the reporting functionality to gain insights into business performance.

## Contributing

Contributions are welcome! 

If you have any suggestions, feature requests, or bug reports, please open an issue or submit a pull request.

See [TODO.md](TODO.md)
## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.