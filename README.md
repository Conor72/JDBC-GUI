# Description:

Java JDBC CRUD Application linked to a mySQL WAMP server that allows a user to create, read, update and delete users from a mySQL database by using a GUI.


# Features:


## Full CRUD funcitonality

## Create:
SQL Insert (Save Button)

### Validation & Exception Handling:
All text fields must be filled in or there will be a popup promting the user to "Please Fill In All The Fields!"

Gender text field must have a vaild entry (M/F) otherwise there will be a popup promting the user to do so

When all fields have valid input and the query is successful the user will be prompted with a popup saying a user has been created and the text fields will all return to empty.

Integar must be inputted in salary field, otherwise a new user will not be created


## Read:
Next Button and Prev Button browse through list of users on SQL server and display details in text field


## Update:
SQL Update (Update Button)

### Validation & Exception Handling:

After a successful update query the user will be prompted with a successful update popup


## Delete:
SQL Delete (Delete Button)

### Validation & Exception Handling:

After a delete query has been successful after clicking on the delete button the user will get a popup saying "User has been successfully deleted!"

All text fields will then be returned to empty.


# References:

https://docs.oracle.com/javase/tutorial/jdbc/basics/jdbcswing.html
https://www.developer.com/java/creating-a-jdbc-gui-application.html
https://www.youtube.com/watch?v=LXcbU0g3yd0
