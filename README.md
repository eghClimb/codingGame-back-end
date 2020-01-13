# codingGame-back-end

in the conext of Maltem recruting process, this application is a coding game so that to give an idea about my technical skills.
the application was designed in two parts :

# part 1 : back end 
the back end part was developped in Java 8 using spring boot.

the main idea, is that the back end part of the application should be able to respond to multiple http requests.

in this part we consider 5 major packages:

 Entity: this package is for persistence layer, in our case we only have one class which is Movie.java
 
 Repository : this package is for direct interaction with the data (which in our case is nothing but a json file)
 
 Service : this package is for business logic ... in our case we don't a specific business logic
 
 Controller : to respond to http requests
 
 error : to customize error handling
 
 # running the back end application :
 
 please make sure to run the back end part first. to do so you'll have to run class CodingGameApplication.java (embeeded tomecat 
 will be launched on port 8080)
 
 # part 2 : front end
 
 this part is developped using Angular 8 + bootstrap 3
 
 we have 4 major web components :
 
 Movie : for displaying the list of movies, and performing the different type of search
 
 new-movie : to add a new movie to the list of movies
 
 edit-movie: to update an existing movie
 
 home : is for home web page
 
  # running the front end application :
  
  run the angular Cli server on port 4200 and enjoy browsing
