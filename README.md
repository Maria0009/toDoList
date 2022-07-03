# TODO LIST
### Introduction

    TodoList is a task manager. 
    This is a convenient application of notes 
    with the functions of adding, deleting and 
    updating existing ones. 
    There is also a user authentication function.

### Stack
In this project I use:
- Java 17
- Maven
- PostgreSQL
- Spring MVC
- Spring Data
- Spring Security

### Application Functions
After launching the application in IntelliJ IDEA, 
enter the following address in the browser:
http://localhost:8088

- The first page is the authentication page, 
with login and password fields:

![Page1](https://user-images.githubusercontent.com/68506586/177040886-ed8a7790-24dc-4c84-a4dd-fe632c894d47.PNG)
- The second page is a HOME page with 
a link to go to the main page with notes:

![Page2](https://user-images.githubusercontent.com/68506586/177041221-1b9cdd88-f91b-4e1c-b535-ad60ee804bea.PNG)
- List-todo page is a page with buttons: 
**Update** the notes of the current user, 
**Delete** or **Add Todo** a new note. 
All notes are sorted by the targetDate field:

![Page3](https://user-images.githubusercontent.com/68506586/177041226-c939f52e-8099-4650-acb3-010332ad4cd0.PNG)
Also we have three buttons: **Home** -  go back to the main page, **Todos** update the current one, **Logout** - log out of the account.
- When adding a note, we fill in the description 
and target Date field (in the specified format) 
with the option to **Save** or **Return** to the previous page.

![Page4](https://user-images.githubusercontent.com/68506586/177041235-c984fa4e-b958-4f4a-9089-2a7bd57d989c.PNG)
TodoList is very simple and intuitive programme to use.
