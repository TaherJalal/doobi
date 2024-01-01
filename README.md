# Doobi App
To Download this project follow the following steps :
## Prerequisite : 
[Java 21](https://www.oracle.com/java/technologies/downloads/) you need to have java 21 installed <br>
[PostgreSQL](https://www.enterprisedb.com/downloads/postgres-postgresql-downloads) continue with the launcher and set the password to 1234 and use the default user which is postgres, after the installion using pgadmin4 create a database called note-app<br>
[Postman](https://www.postman.com/downloads/) <br>
Any IDEA, Preferably [Intellij](https://www.jetbrains.com/idea/download/?section=windows) make sure to download the community edition
## Step 1: 
if you have a git tool just run ```git clone https://github.com/TaherJalal/doobi``` <br>if not download git using the link [Download Git](https://git-scm.com/downloads) and then run the command
## Step 2: 
open intellij idea and open the project<br>
## Step 3: 
on the left a couple of files should appear, navigate to  src -> main -> java -> com -> noteapp -> Application -> Application , ps: note that it should be blue indicating that it is a java class
## Step 4: 
on the top right click on the play icon to start and stop the server
## Step 5: 
using postman make an api call according to the below table <br>
Authentication Routes: <br>
to register as a user: <br>
http://localhost:8080/api/v1/auth/register | No | Request Body as JSON, field required are firstName, lastName, email, password all of which are a string |

to login as a user
| HTTP Method | URL | Require's Token? | Request Data |
| GET |  http://localhost:8080/api/v1/auth/login | No |


## General Structure

    URL: The address you enter in your browser to send a command.
    Method: The action you want to perform (e.g., get information, create something).
    Input: Any details you need to provide for the command.
    Output: The information you'll receive back from the system.

## Available APIs

### Getting Information About Folders

1. Get All Folders:

    URL: /folder/all
    Method: GET (like browsing a website)
    Input: None
    Output: A list of all folders in the system.

2. Get Your Folders:

    URL: /folder/user
    Method: GET
    Input: Your authorization token (like a special password)
    Output: A list of all your folders, both public and private.

3. Get Your Private Folders:

    URL: /folder/private
    Method: GET
    Input: Your authorization token
    Output: A list of only your private folders.

### Creating and Deleting Folders

4. Create a Folder:

    URL: /folder/add
    Method: POST (like submitting a form)
    Input:
        Your authorization token
        Folder details (name, privacy setting)
    Output: A message confirming if the folder was created successfully.

5. Delete a Folder:

    URL: /folder/delete
    Method: DELETE (like removing something)
    Input:
        The ID of the folder you want to delete
    Output: A message confirming if the folder was deleted successfully.

### Working with Notes

6. Create a Note:

    URL: /note/add
    Method: POST
    Input: Note details (text content)
    Output: A message confirming if the note was created successfully.

7. Delete a Note:

    URL: /note/remove
    Method: DELETE
    Input:
        The ID of the note you want to delete
    Output: A message confirming if the note was deleted successfully.

### Managing Images in Folders

8. Add an Image to a Folder:

    URL: /folder/image/add
    Method: POST
    Input:
        The ID of the folder
        The image data
    Output: A message confirming if the image was added successfully.

9. Delete an Image from a Folder:

    URL: /folder/image/delete
    Method: DELETE
    Input:
        The ID of the folder
        The image data
    Output: A message confirming if the image was deleted successfully.

Remember:

    Always use the correct method (GET, POST, DELETE) for each API.
    Provide the necessary input details in the correct format.
    Check the output messages to see if your actions were successful

