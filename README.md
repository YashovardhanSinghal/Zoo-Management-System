## Zoo-Management-System
ASSIGNMENT-2
Name : Yashovardhan Singhal
Roll No : 2022591
______________________________________________________________________
## Overview:
The Zoo Management System is a Java application designed to manage a virtual zoo. This
system allows administrators to add, modify, and remove attractions, set up visitor discounts,
manage visitor information, and purchase tickets for zoo attractions. It also includes features like
special deals and membership options that visitors can use while buying tickets.
______________________________________________________________________
## Command to be Used
Home Folder: 2022591_YashovardhanSinghal
All the commands mentioned below should be executed in the terminal
within the HOME_FOLDER unless otherwise specified.
1. *Download Code*: Download the 2022591_YashovardhanSinghal code folder from
Classroom and unzip it.
2. *Clean*: Run mvn clean to clean the project.
3. *Compile*: Run mvn compile to compile the project.
4. *Package*: Run mvn package to package the project.
5. *Run the Application*: Execute java -jar target\A2_2022591-1.0-SNAPSHOT.jar to run the
application. Optionally, you can replace this command with java -jar <path to jar file> Main,
where the jar file is A2_2022591-1.0-SNAPSHOT.jar.
## Alternatively:
1. *Navigate to the Target Folder*: Run cd target.
2. *Run the Application*: Execute java -jar A2_2022591-1.0-SNAPSHOT.jar Main to run the
application.
## Project Structure
The project is organized around key classes and interfaces, including:
1. *Admin*: Manages administrative functions, including attraction management, visitor
discounts, and special deals.
2. *Visitor*: Represents visitors to the zoo, storing details such as name, age, phone number,
balance, email, and password.
3. *Attractions*: Defines the structure of zoo attractions, including their name, description,
status, price, and visitor count.
4. *Zoo*: Represents the overall zoo and contains data related to attractions.
5. *Main*: Serves as the entry point for the application and manages user interactions.
6.*Dealable and Discountable”: Serves as two interface classes
7.”Animals” - It is the abstract class defining different types of animals
## Functionality
## Administrative Functions

Administrators have access to several essential functions:

1. *Add Attraction*: Easily add new attractions to the zoo by providing the name, description,
and initial status (typically set as "closed").
2. *Modify Attraction*: Update attraction details by specifying the attraction's member ID and
providing the updated information.
3. *Remove Attraction*: Remove attractions from the zoo by specifying the attraction ID.
4. *Set Discounts*: Admins can set discounts for visitors based on categories like "SENIOR"
and "MINOR."
5. *Modify Discounts*: Edit existing discounts by specifying the discount code and updating the
discount percentage.
6. *Remove Discounts*: Remove discounts by specifying the discount code.
7. *Set Special Deals*: Create special deals for visitors based on the number of tickets they
purchase.
8. *Modify Special Deals*: Change special deals by specifying the number of tickets and
updating the discount percentage.
9. *Remove Special Deals*: Eliminate special deals by specifying the number of tickets.
## Assumptions for ADMIN Part
1. There is only one valid username and password for admin, which are "Yash" and "Yash123".
2. Each entity (animal, deal, discount, visitor, attraction) has a unique ID.
3. All attraction details, including name, description, price, and status, must be provided by the
admin.
4. When adding animals, the correct animal type (e.g., "reptiles," "amphibians," "mammals")
must be specified.
5. When modifying an animal, all details such as name, description, and sound must be entered
again.
6. The status of an attraction can be modified by scheduling an event.
7. Discounts are categorized into "MINOR" or "SENIOR" for ease of management.
8. Special deals consider the number of attractions and the discount percentage.
9. Visitor statistics include total revenue, total visitors, and the most popular attractions.
10. An event is considered open if scheduled (true) and closed if not (false).
11. By default, all attractions are initially closed; admin can schedule an event to open them.
12. Attractions can be opened by admin.
13. To ease segregation, open events are considered as attractions.
15. Modification of special deals will create a new deal if none exists for the specified number of
tickets.
16. Admin can't remove an animal if the total number of animals is less than 6.
17. In the modify discount method, only the discount percentage can be updated.
18. If none of the attractions have been visited, and the admin attempts to print the most popular
attraction in the visitor stats, the output will be "all equal currently," which is the default value (0
for all).
19. An email ID is assumed to be unique for each visitor.
20.One email ID is assumed to be present for a single visitor
21.Note : It is assumed that after displaying the entire menu, the user enters the correct input (
i.e. 1 or 2 ) and not some arbitrary value such as string as input.
22.The code assumes that discounts are provided as a percentage and that discounts can be
applied to the membership cost.
## Assumptions for the Visitor Part
1. The user part functions when there are more than 2 animals of each type.
2. Users can view animals and attractions without purchasing a membership but cannot buy
tickets.
3. Membership purchases are not allowed for basic members who have already purchased it
and premium members who have purchased both memberships.
4. Visitors can choose to use discount coupons by answering "Yes/No" during ticket purchase
and entering the discount code.
5. Users must enter the animal's ID to access information, such as feeding or reading about the
animal.
6. Premium members don't need to buy tickets.
7. Basic members can choose to use special deals or discounts, with a limit of one ticket
purchase.
8. Basic members using discounts have their age checked against the discount age.
9. Visitors can visit attractions for which they have purchased tickets by entering the attraction's
ID.
10. There's no provision for renewing a visitor's balance.
11. Visitors cannot visit zoo animals without a ticket.
12. Attractions can be visited only after purchasing a membership.
13. Visitors must register before purchasing memberships or tickets.
14. Discounts can be modified by administrators.
15.If the visitor is buying the membership, it is assumed that the visitor would enter the correct
discount coupon code, another method for eligibility of coupon code has been made, but not
implement for “buy membership option”
16.If a visitor doesn’t have tickets he/she can’t visit the attractions
17.Animals and attractions are separate and their functionalities available to the user are also
entered separately
18.Note : It is assumed that after displaying the entire menu, the user enters the correct input (
i.e. 1 or 2 or 3 ) and not some arbitrary value such as string as input
## OOPS Concepts Used
1. *Polymorphism*: Achieved through the use of the Animal superclass, allowing objects of
Mammal, Reptile, and Amphibian classes to be used as Animal objects.
2. *Inheritance*: Mammals, Amphibians, and Reptiles inherit properties and behaviors from the
Animal class and modify them as needed.
3. *Interface*: An discountable and dealable interface is used to specify methods that is
implemented in Admin Class.
4. *Abstraction*: The Animal class represents the abstract concept of an animal, providing a
blueprint for specific animal types.
5. *Method Overriding*: Subclasses (Mammal, Reptile, Amphibian) override the constructor of
the Animal class to provide their unique properties and behaviors.
6.Object Comparison (toString):have overridden tostring methods in animals and attraction
classes .
7.Class Hierarchy: The code uses a class hierarchy where Admin is a standalone class that
interacts with other classes like Visitor and Zoo. This hierarchy models the relationships
between different components of the application.
8.Access Control: The class specifies private fields and uses getter and setter methods to
control access to those fields. This demonstrates access control principles and encapsulation.
9.Object class implementation:toString method in the Admin class to provide a custom
representation of the object's state. This demonstrates the use of the Object class's toString
method, allowing to present visitor statistics and information about the Admin object in a more
human-readable format.
10.Encapsulation: The class encapsulates private fields, including map, discount_map,
visitor_map, discount_code, and special_deals. These fields are accessed and modified through
getter and setter methods, which provides control over data access
______________________________________________________________________
