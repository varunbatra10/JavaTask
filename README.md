# JavaTask

To get the project-
1. git clone https://github.com/varunbatra10/JavaTask.git
2. cd JavaTask
3. Change the database username and password in application.properties. I'm using MySQl 8.0.18.


For Import Controller-
While importing Employees data, the keys were like first-name and last-name, so I had to change it to firstName and lastName because first-name and last-name were not legible java variable names.

For Export Controller-
I saved all the data exported to csv in files folder and have returned the json response back to the user.
