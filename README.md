# bulambo-25-makeshiftsReddits_APIs
makeshift Reddit API is designed to connect people who share similar interests and attributes, enabling them to form meaningful relationships and share as well discuss trends and opinions.



makeshift Reddit API is designed to connect people who share similar interests and attributes, enabling them to form meaningful relationships and share as well discuss trends and opinions. makeshiftRedditAPI-1.0.0
Spring Boot 2.7.1 application with restful api and thymeleaf front-end
makeshift Reddit API - Spring Boot 2.7.1 Application
Welcome to the makeshift Reddit API project! This Spring Boot 2.7.1 application provides a RESTful API backend system for social interactions platform . Table of Contents Introduction Features Getting Started Usage Technologies Used Contributing License
Introduction makeshift Reddit API is designed to connect people who share similar interests and attributes, enabling them to form meaningful relationships and share as well discuss trends and opinions.
Features This makeshift Reddit API aims to provide users with functionalities similar to the Reddit platform, adhering to the following criteria:
Post Management: Users can create, update, and delete posts. Voting System: Users can upvote or downvote posts. Users can upvote or downvote comments. Commenting: Users can comment on posts. User Interaction: Users can query posts they have upvoted or downvoted. Users can view all posts created by a specific user by using their username. Post Details: Viewing a post displays all associated comments. Users can see the number of upvotes and downvotes for each post. The API aims to provide a comprehensive platform for users to engage with various communities, share their interests, and interact with content seamlessly.

#Getting Started

To set up the makeshift Reddit API project on your local machine, follow these steps:
Clone the repository: git clone https://github.com/your-username/makeshiftRedditAPI.git
Navigate to the project directory: cd makeshiftRedditAPI
Configure your database settings in application.yml: On the application.yml you need to change password and username
Build the application: mvn clean install
Run the application: mvn spring-boot:run
Open your browser and visit: http://localhost:8080
Usage User Registration: Sign up with your details and preferences to create your profile. User Profiles: Fill out your profile with information about yourself, your interests, and compatibility preferences. Matchmaking: The application will suggest potential matches based on your profile and preferences. Messaging: Connect with your matches through the in-app messaging system. Browsing: Use the search and filter options to explore other user profiles and initiate conversations.
Technologies Used Java with Spring Boot 2.7.1
Spring Data JPA for database interactions Spring Security for user authentication and authorization RESTful API architecture for backend communication IntelliJ IDEA for development MySQL

#POST http://localhost:1212/makeshift-Reddit/create

#POST http://localhost:1212/makeshift-Reddit/login 

#POST http://localhost:1212/makeshift-Reddit/post/create
http://localhost:1212/makeshift-Reddit/post/update 

# POST http://localhost:1212/makeshift-Reddit/user/{user_id}/upvotePost/{post_id}
#POST http://localhost:1212/makeshift-Reddit/user/{user_id}/downvotePost/{post_id}
#POST http://localhost:1212/makeshift-Reddit/user/{user_id}/addCommentToPost/{post_id}
#POST http://localhost:1212/makeshift-Reddit/user/{user_id}/upVotecomments/{post_id}/{comment_id}  
POST http://localhost:1212/makeshift-Reddit/user/{user_id}/downVoteComment/{post_id}/{comment_id} 
GET http://localhost:1212/makeshift-Reddit/post/getAllPost/upvoted/{id}
GET http://localhost:1212/makeshift-Reddit/post/getAllPost/downvoters/{id}
GET http://localhost:1212/makeshift-Reddit/post/getAllPost/username/{username}
GET http://localhost:1212/makeshift-Reddit/post/view/all 
GET http://localhost:1212/makeshift-Reddit/post/getAllPost/user/{id} 
GET http://localhost:1212/makeshift-Reddit/post/getAllPost/user/
Delete http://localhost:1212/makeshift-Reddit/post/delete/{id}

NB: PLEASE FIND THE DOCUMENTATION IN FOLDER resources/endpointPayloadResources in the file directory


Contributing 
We welcome contributions to the makeshift Reddit API project! To contribute, follow these steps:
Fork the repository. Create a new branch for your feature or bug fix: git checkout -b feature/your-feature-name Make your changes and commit them with meaningful messages. Push your changes to your forked repository. Create a pull request describing your changes.
License This project is licensed under the MIT License.

![image](https://github.com/bulambo-25/makeshift_Reddit_API/assets/80287850/b09b7225-d6c5-47e4-bfc2-ab7132810e38)
![Uploading image.png…]()
