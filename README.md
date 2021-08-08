
# Steps to run this application

## Setup h2 database

1) Setup h2 database in your machine.
    
    Download h2 database(Version 1.4.199 (2019-03-13), Last Stable) from http://www.h2database.com/html/download.html 

5) Create test directory under your users home directory.
    
    Example(Mac OS):    /Users/dhiraj/test

2) Extract the zip file under your home directory

3) Navigate to h2/bin diretory

4) Execute below command

    java -jar h2-1.4.199.jar

6) Enter JDBC URL:  jdbc:h2:~/test
7) Click test connection, you should be able to see message below:  Test successful

## Running the application
1) clone this repository 

    git clone https://github.com/dhirajn72/test.git

2) cd to test/bookingserv-master and run below command(before running make sure maven is installed)
        
    mvn clean install
    
3) Once above command completes, navigate to  bookingservImplementation directory
    
    cd  bookingservImplementation/

4) Run this command to launch the application:
    
    mvn spring-boot:run

5) Two sample curl has been added in the repository under directory: bookingservApi/src/main/resources

6) Use postman or curl to run those request payloads.
7) Validate the changes

