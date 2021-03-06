Ripple IDCR Demonstrator
=========
  


### Requirements

To develop and run the application locally you must have the following installed:  
* Java JDK 8  
* Maven 3  
* MySQL  
* NodeJS  
* Ruby  
* Ruby Gems
  

### Installation of Development Tools and Languages

Install the JavaScript package manager NodeJS:  
https://nodejs.org/download/

Install Java Development Kit 8:  
http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html

Install Maven 3:  
https://maven.apache.org/download.cgi

Install Ruby:  
http://rubyinstaller.org/downloads

Install Ruby Gems:  
https://rubygems.org/pages/download

Ensure that the system environment variables for Java, Maven, Ruby, and Ruby Gems are set correctly, as described below...

M2_HOME should point to the install directory of your local Maven install folder, e.g.  
```
M2_HOME C:\Maven\apache-maven-3.3.3
```

JAVA_HOME should point to the install directory of your local Java JDK install folder, e.g.  
```
JAVA_HOME C:\Java\jdk1.8.0_65
```

RUBY_HOME should point to the install directory of your local Ruby lang install folder, e.g.  
```
RUBY_HOME C:\Ruby22-x64
```

RUBYGEMS_HOME should point to the install directory of your local Ruby Gems install folder, e.g.  
```
RUBYGEMS_HOME C:\Javascript\rubygems-2.5.1
```

PATH should contain the bin directory of both M2_HOME and JAVA_HOME, e.g.  
```
...;%JAVA_HOME%\bin;%M2_HOME%\bin;%RUBY_HOME%\bin;%RUBYGEMS_HOME%\bin;...
```



### Installation of the MySQL Database

Install MySQL:  
http://dev.mysql.com/downloads/installer/

When using the Windows installer above, the PATH variables are automatically set.

Create the database locally by executing the scripts found in the following directory:  
*ripple-database/src/main/resources/sql/legacy*

These scripts are to be run in the order specified in the following file (located in the directory described above):  
*sql_script_run_order.info*



### Initialising the Tomcat Context File (XML Descriptor):

Throughout the Java side of the application, environment properties are used. These are properties which correspond to
certain settings, such as:  
* Addresses of data sources  
* Usernames and passwords for data sources  
* Specific endpoints to be used for queries  

To find an example of this file, you can copy the a fully working example of one, which is located in the following
directory:  
*ripple-demonstrator-api\src\main\resources\config\tomcat-context-example.xml*

Copy the file to the *root directory* of the project. It is imperative that this context file is located here when on a 
development environment.

Rename the context file to:  
*context-ripple.xml*  



### Installing front end packages

Install Grunt, the JavaScript task runner. You may need to be root user:  
```sh
npm install -g grunt-cli bower
```

Install Sass:  
```sh
gem install sass
```

Navigate to the webapp folder of the Ripple project:  
```sh
cd {projectRoot}\webapp
```

Install all packages used in the Ripple project. If you are prompted to select a version of AngularJS, select v1.3.12:  
```sh
bower install
```

Update Bower:  
```sh
bower update
```

Update NodeJS:  
```sh
npm update
```
  


### Running the Application

Open up a shell and navigate to the *root directory* of the project.  
```sh
cd {projectRoot}
```

Use the following command to spin up an instance of a development server (the Java API code):    
```sh
mvn clean package -Pwebapp:run
```

If you're experiencing build errors, execute the following commands:   
```sh
java --version
```

```sh
mvn --version 
```

```sh
ruby --version
```

```sh
gem --version 
```

If they do not return a suitable response, ensure that the system environment variables described above are pointing
to the correct install directory, and that the *\bin* directories within them are on your PATH system environment variable.

Now that the server is running, open up a second shell and serve the web assets.

Firstly, change the current directory to the webapp package within the root directory of the project.  
```sh
cd {projectRoot}\webapp
```

Serving the web assets will also watch for changes to the front end code, and re-serve those assets (used to facilitate 
speedy development of the UI).

These assets, and the features and themes enabled, are centred around a specific tenant. 

In order to run the application using the standard Ripple tenant:  
```sh
grunt serve
```

In order to run the application using the a specific tenant:  
```sh
grunt serve --tenant=stft
```
  


### Deployment and Server Configuration

Following the same logic shown above for serving the web assets, but use the *build* task instead of the *serve* task:  
```sh
grunt build
```  

In order to build the application using the a specific tenant:  
```sh
grunt build --tenant=stft
```

The build task minifies and uglifies the front end code in the webapp directory of the project, and packages it up 
in the ripple-demonstrator-api module under the following directory:  
*ripple-demonstrator-api\src\main\webapp* 

This is so that the packaged *ripple-demonstrator-api* module can then be deployed to an application container, 
such as Tomcat, with the front end code packaged with it.

With front end code and server-side code is packaged as one, it makes things easy to handle in a deployment scenario.

For a full tutorial on how to deploy the application, read the following article:  
http://dev.rippleosi.org/knowledgebase/server-installation-and-initial-setup/
  

### A Bit More on Tenants

As mentioned previously, the application is centred around the concept of a tenant. This idea can be thought of as a 
specific instance of the system, and the associated themes and behaviour of that instance.

Using the system under the precept of a tenant will alter the look and feel of the site, and will also activate or deactivate 
functionality.

The current tenants programmed into Ripple are:  
* ripple  
* stft  

In order to make use of a tenant's version of the site, you may either serve or build the site with the *--tenant* argument 
appended to the grunt command, e.g.  
```sh
grunt serve --tenant=stft
```

Or...  
```sh
grunt build --tenant=stft
```



##### ENJOY!