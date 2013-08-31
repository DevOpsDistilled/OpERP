OpERP
=====

Enterprise Resource Planning for Distribution Companies

Setting Up
----------

<b>Database Setup<b>


1. Install MySQL
2. Create user:devops with password:devopsdistilled

    `CREATE USER 'devops'@'localhost' IDENTIFIED BY 'devopsdistilled';`

3. Log in to mysql with new user 'devops'
    
    `mysql -u root -p'devopsdistilled';`
    
3. Create database with name OpERP
 
    `CREATE DATABASE OpERP;`


<b> Server Setup </b>

   Download [ServerApp](http://dl.bintray.com/thekojueffect/OpERP)
   
   To initialize fresh Server without any data in the database, execute
   
   `java -jar ServerApp.jar-jar-with-dependencies.jar init`
   
   After initialization is done, `ServerApp` will have to run without any arguments
   
   `java -jar ServerApp.jar-jar-with-dependencies.jar`
   
   
<b>Client Setup</b>
  
   Download [ClientApp](http://dl.bintray.com/thekojueffect/OpERP)
   
   To run `ClientApp`, execute
   
   `java - jar ClientApp.jar-jar-with-dependencies.jar 'server-ip'`
   
   If `ServerApp` is running the same machine, 'server-ip` argument can be omitted.
   
   `java -jar ClientApp.jar-jar-with-dependencies.jar`
   
   
<i>Enjoy!</i>   
   ____________________


<b>DevOps Distilled</b>


  > _Adapting with your Needs_
