# Full-Stack
<b><h3>Full Stack Problem Solving Apps</h3></b>

1. HackerEarth MakeMyTrip Full Stack Hiring Challenge - Shortlistd Entry<br/>
<h4><i> Year 2016 | Shortlisted Entry | One Day Completion challenge
      
<b><h3>Problem Statement:</h3></b>
  Develop a web application which would let users search and list airports conveniently.

<b><h3>Technology Stack:</h3></b>
  1.	Java 1.8
  2.	MySQL 8.0.21
  3.	Primefaces 6.0.RC3[JSF library]

<b><h3>Server used for Deployment and Testing:</h3></b>
  1.	Apache Tomcat 8.0.14

<b><h3>How To Run:</b></h3>
  You must have installed Java1.8(or) higher and MySQL 8(or) higher. Preferably Tomcat as well[But can be deployed on to any server].

<b><h3>SetUp database:</b></h3>
  1.	Run mmt_airports.sql in your database schema
  2.	Update the below properties in dbproprs.properties under src folder with appropriate database details and credentials.
    url=jdbc:mysql://hostname:port/db_schema name
    username=admin
    password=xxxx
  3.	For direct upload of MMTMyPortWebApp.war to server, open war, navigate to WEB-INF/classes, edit dbprops.properties with appropriate details, save it and deploy war on to       server.

<b><h3>Eclipse Project Setup:</b></h3>
  1. Open Eclipse
  2. Add Apache tomcat server by following instructions in Eclipse Server view
  3. Go to File->Import->Existing Projects into Workspace->Choose MMTMyPortWebApp folder from the unzipped directory and finish import.
  4. Go to src->dbprops.properties file and change mysql url,username and password to point to mysql database containing mmt table with values.
  5. Make sure Project build path and facets matches the workspace preferences.
  6. Right click on the project and select Run as->Run on Server->Select Tomcat 8 and click on finish.

<b><h3>Implemented Features:</b></h3>
  1.	Fetch port details and display it in Home Page
  2.	Implement Search feature for overall details
  3.	Implement specific search feature based on name, code and country
  4.	Pagination
  5.	Display total count
  6.	Filter based on type
  7.	Sort By UI Component
  8.	Display rating – Rounded off to integers
  9.	Included favicon for the site

<b><h3>Proposed Enhancements:</b></h3>
  1.	Sort By functionality
  2.	Accurate Rating with float values
  3.	Restful Services for display functionalities and basic searches.
  4.	Ajax based auto complete feature for searches/filters.
  5.	Usage of JS frameworks to reduce server based renderers for basic functionalities.
  6.	Code documentation for better maintenance.

