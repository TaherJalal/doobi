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
to register as a user
| HTTP Method | URL | Require's Token? | Request Data |
| POST |  http://localhost:8080/api/v1/auth/register | No | Request Body as JSON, field required are firstName, lastName, email, password all of which are a string |

to login as a user
| HTTP Method | URL | Require's Token? | Request Data |
| GET |  http://localhost:8080/api/v1/auth/login | No |

| HTTP Method | URL | Require's Token? | Request Data |
| GET |  http://localhost:8080/api/v1/auth | No |

| HTTP Method | URL | Require's Token? | Request Data |
| GET |  http://localhost:8080/api/v1/auth | No |

| HTTP Method | URL | Require's Token? | Request Data |
| GET |  http://localhost:8080/api/v1/auth | No |

| HTTP Method | URL | Require's Token? | Request Data |
| GET |  http://localhost:8080/api/v1/auth | No |

| HTTP Method | URL | Require's Token? | Request Data |
| GET |  http://localhost:8080/api/v1/auth | No |

| HTTP Method | URL | Require's Token? | Request Data |
| GET |  http://localhost:8080/api/v1/auth | No |

| HTTP Method | URL | Require's Token? | Request Data |
| GET |  http://localhost:8080/api/v1/auth | No |

| HTTP Method | URL | Require's Token? | Request Data |
| GET |  http://localhost:8080/api/v1/auth | No |

| HTTP Method | URL | Require's Token? | Request Data |
| GET |  http://localhost:8080/api/v1/auth | No |

| HTTP Method | URL | Require's Token? | Request Data |
| GET |  http://localhost:8080/api/v1/auth | No |
