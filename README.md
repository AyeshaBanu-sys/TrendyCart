 **Project Name**: TrendyCart

 **What is TrendyCart?**

**TrendyCart** is a **mini e-commerce jewelry website** specially designed for women. It allows users to explore a variety of jewelry items categorized as **Necklaces**, **Earrings**, **Maang Tikka**, **Bangles**, **Rings**, **Anklets**, and **Nose Rings** — because every woman deserves beautiful jewelry!

The platform provides functionalities for **Sign-up/Login** and **CRUD operations** (Create, Read, Update, Delete) on jewelry items — but only after successful user login. It offers a stylish and user-friendly interface to promote self-expression and beauty through jewelry.

 **Why was this project created?**

This project was created to:

* Understand how a **website works end-to-end**
* Learn how **Frontend, Backend, Database**, and **API Testing** work together
* Practice building **real-time features** like:
  * User authentication
  * Data validation
  * Role-based access
* Allow users to **securely manage jewelry items** using **CRUD operations**
* Provide a platform to **practice API testing (Postman)** and **SQL queries**

 **Signup Functionality**

* **Fields**: Username, Email, Password, Confirm Password
* **Validations**:
  * Username must start with a letter, allow letters/numbers/underscores, and be 3–20 characters long
  * Email must be in valid format (e.g., `user@example.com`) and unique
  * Password must include at least:
    * 1 uppercase
    * 1 lowercase
    * 1 number
    * 1 special character
  * Confirm Password must match Password
* **Error Handling**: Field-specific, clear error messages
* **Storage**: Stored securely in `localStorage`

 **Login Functionality**

* **Fields**: Username, Password
* **Validation**: Matches credentials from signup
* **Session**: User session is stored in `localStorage`
* **Access Control**:
  * Users must **log in to access CRUD operations**
  * If not logged in, show: **"Please log in to access CRUD operations."**

 **CRUD Operations for Jewelry**

* **Only available after login**
* **CRUD actions include**:

  * **Create**: Add a new jewelry item
  * **Read**: View jewelry list
  * **Update**: Modify item details
  * **Delete**: Remove items
* **Storage**: Data is saved using `localStorage`
* **Jewelry details shown under categories on the homepage*

**Jewelry Categories**

Displayed visually for easy navigation:
* Necklace
* Earrings
* Maang Tikka
* Nose Pins
* Bangles
* Rings
* Anklets
Each category displays jewelry added via CRUD operations.

 **UI Design Highlights**

* **Tagline**: *“Women, You Deserve It!”*
* Stylish, women-centric design with **red theme**
* **Popup modals** for Signup/Login
* Minimal, elegant layout
* Form error messages are shown in red
* 
 **Technologies Used**

| Layer               | Tech                                         |
| ------------------- | -------------------------------------------- |
| **Frontend**        | HTML, CSS, JavaScript                        |
| **Backend**         | Java + Spring Boot (API for CRUD operations) |
| **Database**        | MySQL                                        |
| **Testing**         | Postman (API Testing)                        |
| **Version Control** | Git, GitHub                                  |

 **Extras**

* Users can only do CRUD operations *after login*
* The homepage dynamically displays jewelry items under the appropriate categories (like Rings, Anklets, etc.)

