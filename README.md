# Doobi App
To Download this project follow the following steps :
## Prerequisite : 
1. [Java 21](https://www.oracle.com/java/technologies/downloads/) you need to have java 21 installed <br>
2. [PostgreSQL](https://www.enterprisedb.com/downloads/postgres-postgresql-downloads) continue with the launcher and set the password to 1234 and use the default user which is postgres, after the installion using pgadmin4 create a database called note-app<br>
3. [Postman](https://www.postman.com/downloads/) for making API calls <br>
4. Any IDEA, Preferably [Intellij](https://www.jetbrains.com/idea/download/?section=windows) make sure to download the community edition
## Step 1: 
if you have a git tool just run ```git clone https://github.com/TaherJalal/doobi``` <br>if not download git using the link [Download Git](https://git-scm.com/downloads) and then run the command
## Step 2: 
open intellij idea and open the project<br>
## Step 3: 
on the left a couple of files should appear, navigate to  src -> main -> java -> com -> noteapp -> Application -> Application , ps: note that it should be blue indicating that it is a java class
## Step 4: 
on the top right click on the play icon to start and stop the server
## Step 5: 
using postman make an api call according to the below API's <br>

## Available APIs

### User Registration and Login

1. Register a New User:

    URL: http://localhost:8080/api/v1/auth/register<br>
    Method: POST<br>
    Input:
         firstName, lastName, email, password as a String in JSON format in the body <br>
    Output: Getting a jwt token if registration is succesful.

2. Log In:

    URL: http://localhost:8080/api/v1/auth/login
    Method: POST<br>
    Input:
        email, password as a String in JSON format in the body<br>
    Output: Getting a jwt token if the login is successful.

### Folders

1. Get All Public Folders By All Users:

    URL: http://localhost:8080/api/v1/user/folder/all<br>
    Method: GET<br>
    Input: the jwt token as a bearer token<br>
    Output: A list of all public folders in the system.<br>

2. Get Your Folders:

    URL: http://localhost:8080/api/v1/user/folder/user<br>
    Method: GET<br>
    Input: the jwt token as a bearer token<br>
    Output: A list of all your folders, both public and private.<br>

3. Get Your Private Folders:<br>

    URL: http://localhost:8080/api/v1/user/folder/private<br>
    Method: GET<br>
    Input: the jwt token as a bearer token<br>
    Output: A list of only your private folders.<br>

### Creating and Deleting Folders

4. Create a Folder:

    URL: http://localhost:8080/api/v1/user/folder/add<br>
    Method: POST<br>
    Input:<br>
        the jwt token as a bearer token<br>
        name as a String, isPrivate as boolean in the body<br>
    Output: A message confirming if the folder was created successfully.<br>

5. Delete a Folder:

    URL: http://localhost:8080/api/v1/user/folder/delete<br>
    Method: DELETE<br>
    Input:
        the jwt token as a bearer token<br>
        The ID of the folder you want to delete as a request parameter<br>
    Output: A message confirming if the folder was deleted successfully.<br>

### Notes

6. Create a Note:

    URL: http://localhost:8080/api/v1/user/note/add<br>
    Method: POST<br>
    Input:
        the jwt token as a bearer token<br>
        the title, description, folderId as A String in the body<br>
    Output: A message confirming if the note was created successfully.

8. Delete a Note:

    URL: http://localhost:8080/api/v1/user/note/remove<br>
    Method: DELETE<br>
    Input:
        the jwt token as a bearer token<br>
        The ID of the note you want to delete as a request parameter<br>
    Output: A message confirming if the note was deleted successfully.

### Managing Images in Folders

8. Add an Image to a Folder:

    URL: http://localhost:8080/api/v1/user/folder/image/add<br>
    Method: POST<br>
    Input:
        the jwt token as a bearer token<br>
        The ID of the folder, The image path or url as a String in the body<br>
    Output: A message confirming if the image was added successfully.

9. Delete an Image from a Folder:

    URL: http://localhost:8080/api/v1/user/folder/image/delete<br>
    Method: DELETE<br>
    Input:
       the jwt token as a bearer token<br>
        The ID of the folder, The image path or url as a String in the body<br>
    Output: A message confirming if the image was deleted successfully.
