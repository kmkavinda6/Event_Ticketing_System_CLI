# Real-Time Event Ticketing System  

This project is a **Real-Time Event Ticketing System** built in **Java** using **Object-Oriented Programming (OOP)** principles and the **Producer-Consumer Pattern**. It handles concurrent ticket releases by vendors (producers) and purchases by customers (consumers) while ensuring data integrity and synchronization in a multi-threaded environment.

---

## Features  

- **Concurrency Handling**:  
  Supports multiple vendors and customers operating concurrently.  

- **Data Integrity**:  
  Ensures thread-safe access to the shared ticket pool using synchronization.  

- **Customizable Configuration**:  
  Users can configure parameters like ticket release rates, retrieval rates, and maximum pool size before starting the system.  

- **Logging**:  
  Tracks system activities such as ticket additions, purchases, and errors in a log file.  

---

## Technologies Used  

- **Language**: Java  
- **Threading**: Multi-threading with `Runnable`  
- **Synchronization**: Thread-safe access to shared resources using `synchronized` blocks  
- **Logging**: File-based logging using `FileWriter`  

---

## System Requirements  

- **Java**: JDK 8 or higher  
- **IDE**: IntelliJ IDEA, Eclipse, or any Java-compatible editor  
- **Operating System**: Windows, macOS, or Linux  

---

## How to Run  

### Step 1: Clone the Repository  

```bash  
git clone <repository_url>  
cd real-time-ticketing-system  
```  

### Step 2: Compile the Code  

Use the following command to compile all `.java` files:  

```bash  
javac -d out src/**/*.java  
```  

### Step 3: Run the Application  

Run the main application:  

```bash  
java -cp out services.Main  
```  

---

## Configuration  

The system prompts for the following inputs during setup:  

1. **Total Tickets**: Total tickets available in the system.  
2. **Ticket Release Rate**: Number of tickets added to the pool by each vendor per second.  
3. **Customer Retrieval Rate**: Number of tickets retrieved by each customer per second.  
4. **Maximum Ticket Capacity**: Maximum number of tickets the pool can hold at any given time.  

---

## Logging  

System logs are stored in the `system.log` file. Logs include:  

- Ticket additions and purchases  
- Current pool size after each operation  
- Error messages (if any)  

---

## Project Structure  

```  
src/  
├── config/  
│   ├── Configuration.java          # Stores system configuration  
│   └── ConfigManager.java          # Handles user input for configuration  
├── models/  
│   ├── TicketPool.java             # Shared resource for tickets  
│   ├── Vendor.java                 # Producer logic  
│   └── Customer.java               # Consumer logic  
├── logging/  
│   └── Logger.java                 # File-based logging utility  
└── services/  
    └── Main.java                   # Main entry point for the application  
```  

---

## Example Output  

```  
Enter total tickets: 100  
Enter ticket release rate: 10  
Enter customer retrieval rate: 5  
Enter maximum ticket capacity: 50  

10 tickets added. Current pool: 10  
1 ticket purchased. Current pool: 9  
1 ticket purchased. Current pool: 8  
10 tickets added. Current pool: 18  
1 ticket purchased. Current pool: 17  
```  

---

## Future Enhancements  

- **Detailed Reporting**: Generate summaries of tickets sold by each customer.  
- **Web Interface**: Add a simple web-based dashboard for configuration and monitoring.  
- **Advanced Synchronization**: Use `BlockingQueue` for more efficient thread handling.  

---

## Contributing  

1. Fork the repository.  
2. Create a feature branch: `git checkout -b feature-name`.  
3. Commit changes: `git commit -m "Description of changes"`.  
4. Push to the branch: `git push origin feature-name`.  
5. Create a pull request.  

---



---  

## Author  

- **Name**: Kavinda Madhubhashana
- **Contact**: kmkavinda6@gmail.com

Feel free to reach out for questions or suggestions!  
